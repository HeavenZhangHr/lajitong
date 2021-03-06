package com.auts.lajitong.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import com.auts.lajitong.model.dao.OrderModel;

public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    @Insert("insert into tbl_order (order_id, user_id, device_id, bin_no, order_type, delivery_time, weight, price, amount, create_time, update_time) "
            + "values (#{record.orderId},#{record.userId},#{record.deviceId},#{record.binNo},#{record.orderType},#{record.deliveryTime},#{record.weight},#{record.price},#{record.amount},#{record.createTime},#{record.updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "record.id")
    int insert(@Param("record") OrderModel record) throws Exception;

    int insertSelective(OrderModel record);

    OrderModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderModel record);

    int updateByPrimaryKey(OrderModel record);
}