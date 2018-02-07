
package com.rahul.phmc.spe.poc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SPE_L2MerchantSettlementReportModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String merchantID;
	private String merchantName;
	private Date reportStartDate;
	private Date reportEndDate;
	private Float totalTransAmount;
	private Float totalAmntRcvbleFrmSrishti;
	private List<SPE_L2MerchantSettlementReportGridModel> reportGrid;
	
	public String getMerchantID() {
		return merchantID;
	}
	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public Date getReportStartDate() {
		return reportStartDate;
	}
	public void setReportStartDate(Date reportStartDate) {
		this.reportStartDate = reportStartDate;
	}
	public Date getReportEndDate() {
		return reportEndDate;
	}
	public void setReportEndDate(Date reportEndDate) {
		this.reportEndDate = reportEndDate;
	}
	public Float getTotalTransAmount() {
		return totalTransAmount;
	}
	public void setTotalTransAmount(Float totalTransAmount) {
		this.totalTransAmount = totalTransAmount;
	}
	public Float getTotalAmntRcvbleFrmSrishti() {
		return totalAmntRcvbleFrmSrishti;
	}
	public void setTotalAmntRcvbleFrmSrishti(Float totalAmntRcvbleFrmSrishti) {
		this.totalAmntRcvbleFrmSrishti = totalAmntRcvbleFrmSrishti;
	}
	public List<SPE_L2MerchantSettlementReportGridModel> getReportGrid() {
		return reportGrid;
	}
	public void setReportGrid(List<SPE_L2MerchantSettlementReportGridModel> reportGrid) {
		this.reportGrid = reportGrid;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
