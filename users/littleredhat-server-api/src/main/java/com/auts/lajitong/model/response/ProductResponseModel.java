package com.auts.lajitong.model.response;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.auts.lajitong.model.dao.product.ProfitRebateModel;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 产品接口返回数据JSON
 *
 * @author li.bing
 * @date 2018年2月27日
 */
public class ProductResponseModel {
	@JSONField(name = "pCode")
    @JsonProperty("pCode")
	private String pCode;
	@JSONField(name = "pShortName")
    @JsonProperty("pShortName")
    private String pShortName;
	@JSONField(name = "pFullName")
    @JsonProperty("pFullName")
    private String pFullName;
	@JSONField(name = "pType")
    @JsonProperty("pType")
    private String pType;
	@JSONField(name = "pExpectAnnualRevenue")
    @JsonProperty("pExpectAnnualRevenue")
    private String pExpectAnnualRevenue;
	@JSONField(name = "pSaleStatus")
    @JsonProperty("pSaleStatus")
    private String pSaleStatus;
	@JSONField(name = "pDulTime")
    @JsonProperty("pDulTime")
    private String pDulTime;
	@JSONField(name = "pSaleStartTime")
    @JsonProperty("pSaleStartTime")
    private Date pSaleStartTime;
	@JSONField(name = "pAllIssuingScale")
    @JsonProperty("pAllIssuingScale")
    private String pAllIssuingScale;
	@JSONField(name = "pMinAmount")
    @JsonProperty("pMinAmount")
    private String pMinAmount;
	@JSONField(name = "pPaymentInterestType")
    @JsonProperty("pPaymentInterestType")
    private String pPaymentInterestType;
	@JSONField(name = "pInvestType")
    @JsonProperty("pInvestType")
    private String pInvestType;
	@JSONField(name = "pSizeRatioType")
    @JsonProperty("pSizeRatioType")
    private String pSizeRatioType;
	@JSONField(name = "pInvestOwnerId")
    @JsonProperty("pInvestOwnerId")
    private String pInvestOwnerId;
	@JSONField(name = "profitRebates")
    @JsonProperty("profitRebates")
    private List<ProfitRebateModel> profitRebates;
    private String pAllSubscriptionAmount;
    private String pCommission; //佣金比例
    private String pLatestPayNum;
	private String pRexiao;
	private String pTuijian;
	private String pRgxz; //认购须知
	private String pRemark;//备注

    public String getpRemark() {
		return pRemark;
	}

	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
	}

	public String getpLatestPayNum() {
		return pLatestPayNum;
	}

	public void setpLatestPayNum(String pLatestPayNum) {
		this.pLatestPayNum = pLatestPayNum;
	}
	public String getpRexiao() {
		return pRexiao;
	}

	public void setpRexiao(String pRexiao) {
		this.pRexiao = pRexiao;
	}

	public String getpTuijian() {
		return pTuijian;
	}

	public void setpTuijian(String pTuijian) {
		this.pTuijian = pTuijian;
	}

	public String getpRgxz() {
		return pRgxz;
	}

	public void setpRgxz(String pRgxz) {
		this.pRgxz = pRgxz;
	}

	public String getpCommission() {
		return pCommission;
	}
	public void setpCommission(String pCommission) {
		this.pCommission = pCommission;
	}
    public String getpAllSubscriptionAmount() {
        return pAllSubscriptionAmount;
    }
    public void setpAllSubscriptionAmount(String pAllSubscriptionAmount) {
        this.pAllSubscriptionAmount = pAllSubscriptionAmount;
    }
    public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpShortName() {
		return pShortName;
	}
	public void setpShortName(String pShortName) {
		this.pShortName = pShortName;
	}
	public String getpFullName() {
		return pFullName;
	}
	public void setpFullName(String pFullName) {
		this.pFullName = pFullName;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	public String getpExpectAnnualRevenue() {
		return pExpectAnnualRevenue;
	}
	public void setpExpectAnnualRevenue(String pExpectAnnualRevenue) {
		this.pExpectAnnualRevenue = pExpectAnnualRevenue;
	}
	public String getpSaleStatus() {
		return pSaleStatus;
	}
	public void setpSaleStatus(String pSaleStatus) {
		this.pSaleStatus = pSaleStatus;
	}
	public String getpDulTime() {
		return pDulTime;
	}
	public void setpDulTime(String pDulTime) {
		this.pDulTime = pDulTime;
	}
	public Date getpSaleStartTime() {
		return pSaleStartTime;
	}
	public void setpSaleStartTime(Date pSaleStartTime) {
		this.pSaleStartTime = pSaleStartTime;
	}

	public String getpAllIssuingScale() {
        return pAllIssuingScale;
    }
    public void setpAllIssuingScale(String pAllIssuingScale) {
        this.pAllIssuingScale = pAllIssuingScale;
    }

	public String getpMinAmount() {
        return pMinAmount;
    }
    public void setpMinAmount(String pMinAmount) {
        this.pMinAmount = pMinAmount;
    }
    public String getpPaymentInterestType() {
		return pPaymentInterestType;
	}
	public void setpPaymentInterestType(String pPaymentInterestType) {
		this.pPaymentInterestType = pPaymentInterestType;
	}
	public String getpInvestType() {
		return pInvestType;
	}
	public void setpInvestType(String pInvestType) {
		this.pInvestType = pInvestType;
	}
	public String getpSizeRatioType() {
		return pSizeRatioType;
	}
	public void setpSizeRatioType(String pSizeRatioType) {
		this.pSizeRatioType = pSizeRatioType;
	}
	public String getpInvestOwnerId() {
		return pInvestOwnerId;
	}
	public void setpInvestOwnerId(String pInvestOwnerId) {
		this.pInvestOwnerId = pInvestOwnerId;
	}
	public List<ProfitRebateModel> getProfitRebates() {
		return profitRebates;
	}
	public void setProfitRebates(List<ProfitRebateModel> profitRebates) {
		this.profitRebates = profitRebates;
	}
}
