
package com.rahul.phmc.spe.poc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class SPE_PaymentAdviceForSrishtiModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date reportStartDate;
	private Date reportEndDate;
	private Float totalPaymentToSrishti;
	private Float totalAmntToDistributed;
	private Float totalEarningToSrishti;
	private List<SPE_MerchantForAdviceModel> reportaccountGrid;
	
	
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
	public Float getTotalPaymentToSrishti() {
		return totalPaymentToSrishti;
	}
	public void setTotalPaymentToSrishti(Float totalPaymentToSrishti) {
		this.totalPaymentToSrishti = totalPaymentToSrishti;
	}
	public Float getTotalAmntToDistributed() {
		return totalAmntToDistributed;
	}
	public void setTotalAmntToDistributed(Float totalAmntToDistributed) {
		this.totalAmntToDistributed = totalAmntToDistributed;
	}
	public Float getTotalEarningToSrishti() {
		return totalEarningToSrishti;
	}
	public void setTotalEarningToSrishti(Float totalEarningToSrishti) {
		this.totalEarningToSrishti = totalEarningToSrishti;
	}
	public List<SPE_MerchantForAdviceModel> getReportaccountGrid() {
		return reportaccountGrid;
	}
	public void setReportaccountGrid(List<SPE_MerchantForAdviceModel> reportaccountGrid) {
		this.reportaccountGrid = reportaccountGrid;
	}
	
}
