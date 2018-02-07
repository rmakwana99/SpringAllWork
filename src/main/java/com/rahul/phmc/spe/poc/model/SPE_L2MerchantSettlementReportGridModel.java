
package com.rahul.phmc.spe.poc.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SPE_L2MerchantSettlementReportGridModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String transationId;
	private Date transDateTime;
	private Float transAmount;
	private String terminalId;
	private String deviceId;
	private String modeOfPayment;
	private Float amountReceivable;
	private Float amountReceived;
	private Date amountReceivedDate;
	private String moneyTrnsfrRefNum;
	private String comments;
	public String getTransationId() {
		return transationId;
	}
	public void setTransationId(String transationId) {
		this.transationId = transationId;
	}
	public Date getTransDateTime() {
		return transDateTime;
	}
	public void setTransDateTime(Date transDateTime) {
		this.transDateTime = transDateTime;
	}
	public Float getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(Float transAmount) {
		this.transAmount = transAmount;
	}
	public String getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public Float getAmountReceivable() {
		return amountReceivable;
	}
	public void setAmountReceivable(Float amountReceivable) {
		this.amountReceivable = amountReceivable;
	}
	public Float getAmountReceived() {
		return amountReceived;
	}
	public void setAmountReceived(Float amountReceived) {
		this.amountReceived = amountReceived;
	}
	public Date getAmountReceivedDate() {
		return amountReceivedDate;
	}
	public void setAmountReceivedDate(Date amountReceivedDate) {
		this.amountReceivedDate = amountReceivedDate;
	}
	public String getMoneyTrnsfrRefNum() {
		return moneyTrnsfrRefNum;
	}
	public void setMoneyTrnsfrRefNum(String moneyTrnsfrRefNum) {
		this.moneyTrnsfrRefNum = moneyTrnsfrRefNum;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
