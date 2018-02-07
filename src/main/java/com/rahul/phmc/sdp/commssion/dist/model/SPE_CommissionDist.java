
package com.rahul.phmc.sdp.commssion.dist.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author rahul Makvana
 *
 */
@Entity
@Table(name = "SPE_COMMISSION_DIST")
public class SPE_CommissionDist {

	// SPE_SrNo BIGINT IDENTITY(1,1) NOT NULL,
	// CONSTRAINT PK_SPE_COMMISSION_DIST PRIMARY KEY NONCLUSTERED (SPE_SrNo)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SPE_SrNo")
	private Long srNo;
	// SPE_Amount_RANGE_MIN_VAL DECIMAL(16,2 ) ,
	@Column(name = "SPE_Amount_RANGE_MIN_VAL")
	private Double amountRangeMinVal;
	// SPE_Amount_RANGE_MAX_VAL DECIMAL(16,2 ) ,
	@Column(name = "SPE_Amount_RANGE_MAX_VAL")
	private Double amountRangeMaxVal;
	// SPE_ENTITY_ID VARCHAR(64) ,
	@Column(name = "SPE_ENTITY_ID")
	private String entityId;
	// SPE_ENTITY_TYPE VARCHAR(64) ,
	@Column(name = "SPE_ENTITY_TYPE")
	private String entityType;
	// SPE_PAYMENT_MODE VARCHAR(15) ,
	@Column(name = "SPE_PAYMENT_MODE")
	private String paymentMode;
	// SPE_COMMISSION_PCTN DECIMAL(16, 2) ,
	@Column(name = "SPE_COMMISSION_PCTN")
	private Double commissionPCTN;
	// SPE_FIXED_AMOUNT DECIMAL(16, 2) ,
	@Column(name = "SPE_FIXED_AMOUNT")
	private Double fixedAmount;
	// SPE_COMMISSION_MIN_VAL DECIMAL(16,2 ) ,
	@Column(name = "SPE_COMMISSION_MIN_VAL")
	private Double commssionMinValue;
	// SPE_COMMISSION_MAX_VAL DECIMAL(16,2 ) ,
	@Column(name = "SPE_COMMISSION_MAX_VAL")
	private Double commssionMaxValue;
	// SPE_COMM_EFFECTIVE_START_DATE DATE,
	@Column(name = "SPE_COMM_EFFECTIVE_START_DATE")
	private Date commEffectiveStartDate;
	// SPE_COMM_EFFECTIVE_END_DATE DATE,
	@Column(name = "SPE_COMM_EFFECTIVE_END_DATE")
	private Date commEffectiveEndDate;

	public SPE_CommissionDist() {
		super();		
	}

	public Long getSrNo() {
		return srNo;
	}

	public void setSrNo(Long srNo) {
		this.srNo = srNo;
	}

	public Double getAmountRangeMinVal() {
		return amountRangeMinVal;
	}

	public void setAmountRangeMinVal(Double amountRangeMinVal) {
		this.amountRangeMinVal = amountRangeMinVal;
	}

	public Double getAmountRangeMaxVal() {
		return amountRangeMaxVal;
	}

	public void setAmountRangeMaxVal(Double amountRangeMaxVal) {
		this.amountRangeMaxVal = amountRangeMaxVal;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Double getCommissionPCTN() {
		return commissionPCTN;
	}

	public void setCommissionPCTN(Double commissionPCTN) {
		this.commissionPCTN = commissionPCTN;
	}

	public Double getFixedAmount() {
		return fixedAmount;
	}

	public void setFixedAmount(Double fixedAmount) {
		this.fixedAmount = fixedAmount;
	}

	public Double getCommssionMinValue() {
		return commssionMinValue;
	}

	public void setCommssionMinValue(Double commssionMinValue) {
		this.commssionMinValue = commssionMinValue;
	}

	public Double getCommssionMaxValue() {
		return commssionMaxValue;
	}

	public void setCommssionMaxValue(Double commssionMaxValue) {
		this.commssionMaxValue = commssionMaxValue;
	}

	public Date getCommEffectiveStartDate() {
		return commEffectiveStartDate;
	}

	public void setCommEffectiveStartDate(Date commEffectiveStartDate) {
		this.commEffectiveStartDate = commEffectiveStartDate;
	}

	public Date getCommEffectiveEndDate() {
		return commEffectiveEndDate;
	}

	public void setCommEffectiveEndDate(Date commEffectiveEndDate) {
		this.commEffectiveEndDate = commEffectiveEndDate;
	}

	@Override
	public String toString() {
		return "SPE_CommissionDist [srNo=" + srNo + ", amountRangeMinVal=" + amountRangeMinVal + ", amountRangeMaxVal="
				+ amountRangeMaxVal + ", entityId=" + entityId + ", entityType=" + entityType + ", paymentMode="
				+ paymentMode + ", commissionPCTN=" + commissionPCTN + ", fixedAmount=" + fixedAmount
				+ ", commssionMinValue=" + commssionMinValue + ", commssionMaxValue=" + commssionMaxValue
				+ ", commEffectiveStartDate=" + commEffectiveStartDate + ", commEffectiveEndDate="
				+ commEffectiveEndDate + "]";
	}

}
