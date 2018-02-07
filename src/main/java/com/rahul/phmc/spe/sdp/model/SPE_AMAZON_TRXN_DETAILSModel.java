
package com.rahul.phmc.spe.sdp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author rahul Makvana
 *
 */
@XmlRootElement
@Entity
@Table(name="SPE_AMAZON_TRXN_DETAILS")
@DynamicInsert
@DynamicUpdate
public class SPE_AMAZON_TRXN_DETAILSModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long spe_autoSrNo;
	private String spe_transactionID;
	private String spe_storeID;
	private String spe_categoryName;
	private String spe_itemName;
	private Integer spe_itemQty;
	private String spe_itemID;
	private String spe_AmazonTxnId;
	private Float spe_itemPrice;
	private Float spe_itemDiscount;
	private Float spe_newCustDiscount;
	private Float spe_totalTxnAmount;
	private Date spe_shippingDate;
	private Integer spe_isCommDistToDist;
	private Integer spe_isCommDistToPCO;
	private String spe_txnType;
	private String spe_deviceTypeGroup;
	
	private transient Boolean spe_excelcheck;
	private transient String spe_excelError;
	private transient Boolean spe_insertCheck;
	private transient String spe_insertError;
	
	
	public Long getSpe_autoSrNo() {
		return spe_autoSrNo;
	}
	public void setSpe_autoSrNo(Long spe_autoSrNo) {
		this.spe_autoSrNo = spe_autoSrNo;
	}
	public String getSpe_transactionID() {
		return spe_transactionID;
	}
	public void setSpe_transactionID(String spe_transactionID) {
		this.spe_transactionID = spe_transactionID;
	}
	public String getSpe_storeID() {
		return spe_storeID;
	}
	public void setSpe_storeID(String spe_storeID) {
		this.spe_storeID = spe_storeID;
	}
	public String getSpe_categoryName() {
		return spe_categoryName;
	}
	public void setSpe_categoryName(String spe_categoryName) {
		this.spe_categoryName = spe_categoryName;
	}
	public String getSpe_itemName() {
		return spe_itemName;
	}
	public void setSpe_itemName(String spe_itemName) {
		this.spe_itemName = spe_itemName;
	}
	public Integer getSpe_itemQty() {
		return spe_itemQty;
	}
	public void setSpe_itemQty(Integer spe_itemQty) {
		this.spe_itemQty = spe_itemQty;
	}
	public String getSpe_itemID() {
		return spe_itemID;
	}
	public void setSpe_itemID(String spe_itemID) {
		this.spe_itemID = spe_itemID;
	}
	public String getSpe_AmazonTxnId() {
		return spe_AmazonTxnId;
	}
	public void setSpe_AmazonTxnId(String spe_AmazonTxnId) {
		this.spe_AmazonTxnId = spe_AmazonTxnId;
	}
	public Float getSpe_itemPrice() {
		return spe_itemPrice;
	}
	public void setSpe_itemPrice(Float spe_itemPrice) {
		this.spe_itemPrice = spe_itemPrice;
	}
	public Float getSpe_itemDiscount() {
		return spe_itemDiscount;
	}
	public void setSpe_itemDiscount(Float spe_itemDiscount) {
		this.spe_itemDiscount = spe_itemDiscount;
	}
	public Float getSpe_newCustDiscount() {
		return spe_newCustDiscount;
	}
	public void setSpe_newCustDiscount(Float spe_newCustDiscount) {
		this.spe_newCustDiscount = spe_newCustDiscount;
	}
	public Float getSpe_totalTxnAmount() {
		return spe_totalTxnAmount;
	}
	public void setSpe_totalTxnAmount(Float spe_totalTxnAmount) {
		this.spe_totalTxnAmount = spe_totalTxnAmount;
	}
	public Date getSpe_shippingDate() {
		return spe_shippingDate;
	}
	public void setSpe_shippingDate(Date spe_shippingDate) {
		this.spe_shippingDate = spe_shippingDate;
	}
	public Integer getSpe_isCommDistToDist() {
		return spe_isCommDistToDist;
	}
	public void setSpe_isCommDistToDist(Integer spe_isCommDistToDist) {
		this.spe_isCommDistToDist = spe_isCommDistToDist;
	}
	public Integer getSpe_isCommDistToPCO() {
		return spe_isCommDistToPCO;
	}
	public void setSpe_isCommDistToPCO(Integer spe_isCommDistToPCO) {
		this.spe_isCommDistToPCO = spe_isCommDistToPCO;
	}
	public String getSpe_txnType() {
		return spe_txnType;
	}
	public void setSpe_txnType(String spe_txnType) {
		this.spe_txnType = spe_txnType;
	}
	public String getSpe_deviceTypeGroup() {
		return spe_deviceTypeGroup;
	}
	public void setSpe_deviceTypeGroup(String spe_deviceTypeGroup) {
		this.spe_deviceTypeGroup = spe_deviceTypeGroup;
	}
	public Boolean getSpe_excelcheck() {
		return spe_excelcheck;
	}
	public void setSpe_excelcheck(Boolean spe_excelcheck) {
		this.spe_excelcheck = spe_excelcheck;
	}
	public String getSpe_excelError() {
		return spe_excelError;
	}
	public void setSpe_excelError(String spe_excelError) {
		this.spe_excelError = spe_excelError;
	}
	public Boolean getSpe_insertCheck() {
		return spe_insertCheck;
	}
	public void setSpe_insertCheck(Boolean spe_insertCheck) {
		this.spe_insertCheck = spe_insertCheck;
	}
	public String getSpe_insertError() {
		return spe_insertError;
	}
	public void setSpe_insertError(String spe_insertError) {
		this.spe_insertError = spe_insertError;
	}
	@Override
	public String toString() {
		return "SPE_AMAZON_TRXN_DETAILSModel [spe_autoSrNo=" + spe_autoSrNo + ", spe_transactionID=" + spe_transactionID
				+ ", spe_storeID=" + spe_storeID + ", spe_categoryName=" + spe_categoryName + ", spe_itemName="
				+ spe_itemName + ", spe_itemQty=" + spe_itemQty + ", spe_itemID=" + spe_itemID + ", spe_AmazonTxnId="
				+ spe_AmazonTxnId + ", spe_itemPrice=" + spe_itemPrice + ", spe_itemDiscount=" + spe_itemDiscount
				+ ", spe_newCustDiscount=" + spe_newCustDiscount + ", spe_totalTxnAmount=" + spe_totalTxnAmount
				+ ", spe_shippingDate=" + spe_shippingDate + ", spe_isCommDistToDist=" + spe_isCommDistToDist
				+ ", spe_isCommDistToPCO=" + spe_isCommDistToPCO + ", spe_txnType=" + spe_txnType
				+ ", spe_deviceTypeGroup=" + spe_deviceTypeGroup + "]";
	}
	
	

}
