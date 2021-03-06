package com.auts.lajitong.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auts.lajitong.dao.DeviceBinWatcherMapper;
import com.auts.lajitong.dao.DeviceWatcherMapper;
import com.auts.lajitong.model.dao.device.DeviceBinWatcherModel;
import com.auts.lajitong.model.dao.device.DeviceWatcherModel;
import com.auts.lajitong.service.DeviceService;
import com.dls.sdk.vo.MbParseResult;
import com.dls.sdk.vo.Points;
import com.dls.sdk.vo.Shake;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	DeviceWatcherMapper deviceWatcherMapper;
	
	@Autowired
	DeviceBinWatcherMapper deviceBinWatcherMapper;
	
	@Transactional
	@Override
	public int saveShake(MbParseResult<Shake> mbParseResult) throws Exception{
		
		Shake shake = (Shake)mbParseResult.mbDataObject;
		DeviceWatcherModel deviceWatcherModelDB = deviceWatcherMapper.selectByDeviceId(shake.getMbId());
		if(deviceWatcherModelDB != null) {
			//删除数据，新插入设备信息
			deviceWatcherMapper.deleteByDeviceId(shake.getMbId());
			deviceBinWatcherMapper.deleteByDeviceId(shake.getMbId());
			//新插入设备信息
			DeviceWatcherModel record = convertDeviceDTO(shake);
			int result = deviceWatcherMapper.insert(record);
			if(result > 0) {
				List<Points> pointList = shake.getPointsList();
				for(Points points : pointList) {
					DeviceBinWatcherModel dto = convertDevicePointDTO(points);
					dto.setfId(record.getId());
					dto.setDeviceId(record.getDeviceId());
					deviceBinWatcherMapper.insert(dto);
				}
			}
		} else {
			//第一次设备安装
			DeviceWatcherModel record = convertDeviceDTO(shake);
			int result = deviceWatcherMapper.insert(record);
			if(result > 0) {
				List<Points> pointList = shake.getPointsList();
				for(Points points : pointList) {
					DeviceBinWatcherModel dto = convertDevicePointDTO(points);
					dto.setfId(record.getId());
					dto.setDeviceId(record.getDeviceId());
					deviceBinWatcherMapper.insert(dto);
				}
			}
		}
		
		return 0;
	}
	
	private DeviceWatcherModel convertDeviceDTO(Shake shake) {
		DeviceWatcherModel dto = new DeviceWatcherModel();
		dto.setDeviceId(shake.getMbId());
		dto.setGpsLat(shake.getDEVICE_GPS_Lat() + "");
		dto.setGpsLng(shake.getDEVICE_GPS_LNG() + "");
		dto.setSignalIntensit(shake.getSIGNAL_INTENSITY());
		dto.setFirmwareVersion(shake.getFIRMWARE_VERSION());
		dto.setCharingVoltage(shake.getCHARGING_VOLTAGE());
		dto.setCharingCurrent(shake.getCHARGING_CURRENT());
		dto.setDailyCharge(shake.getDAILY_CHARGE());
		dto.setDailyElectricity(shake.getDAILY_ELECTRICITY());
		dto.setMainboardTemperature(shake.getMAINBOARD_TEMPERATURE());
		dto.setBatteryTemperature(shake.getBATTERY_TEMPERATUR());
		dto.setBatteryVoltage(shake.getBATTERY_VOLTAGE());
		dto.setSortSum(shake.getSORT_SUM());
		dto.setMainboardId(shake.getDeviceId());
		dto.setWsTime(shake.getWsTime());
		dto.setCapacity(shake.getCapacity());
		dto.setTemperatur(shake.getTemperature());
		dto.setWaterLine(shake.getWater_line());
		Date nowDate = new Date();
		dto.setCreateTime(nowDate.getTime());
		dto.setUpdateTime(nowDate.getTime());
		
		return dto;
	}
	
	private DeviceBinWatcherModel convertDevicePointDTO(Points points) {
		DeviceBinWatcherModel dto = new DeviceBinWatcherModel();
		dto.setSortNo(points.getSortNo());
		dto.setVolumn(points.getVolume()); //单位是10g
		dto.setSszl(String.valueOf(points.getSszl()));//单位是10g
		dto.setWd(points.getWd() + "");
		dto.setWorkStatus(points.getZczt() + "");
		dto.setErrorCode(points.getGzzt());
		dto.setErrorMsg(points.getGzMsg());
		Date nowDate = new Date();
		dto.setCreateTime(nowDate.getTime());
		dto.setUpdateTime(nowDate.getTime());
		return dto;
	}
}
