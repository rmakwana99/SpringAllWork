package com.rahul.phmc.spe.sdp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author rahul Makvana
 *
 */
@Entity
@Table(name = "SPE_DAILY_AMAZON_EARNING_DEPOT")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SPE_DAILY_AMAZON_EARNING_DEPOTModel {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long SPE_AutoSrNo;
	private String SPE_ProductCategory;
	private String SPE_CommissionCategory;
	private String SPE_ProductName;
	private String SPE_StoreID;
	private String SPE_TxnID;
	private Date SPE_DateShipped;
	private Float SPE_Price;
	private Integer SPE_ItemShipped;
	private Integer SPE_ItemRetrun;
	private Float SPE_CommssionEarned;
	private String SPE_DeviceTypeGroup;
	private Integer SPE_IsCommRecieved;
	private Integer SPE_IsValidRecord;
	private String SPE_Option1;
	private String SPE_Option2;
	private String SPE_Option3;
	private String SPE_Option4;
	private String SPE_Option5;
	private String SPE_Option6;
	private String SPE_Option7;
	private String SPE_Option8;
	private String SPE_Option9;
	private String SPE_Option10;
	private Integer SPE_Option11;
	private Integer SPE_Option12;
	private Integer SPE_Option13;
	private Float SPE_Option14;
	private Float SPE_Option15;

	// added newly
	private Date SPE_TxnDate;
	private Float SPE_TotalSellPrice;
	private Float SPE_DisctAmt;
	private Float SPE_NewCustDisctAmt;
	private String SPE_AMZ_TxnID;
	private String SPE_AMZ_SELL_TxnRef;
	private Integer SPE_RECORD_STATUS;
	
	//for status
	private transient Boolean spe_excelcheck;
	private transient String spe_excelError;
	private transient Boolean spe_insertCheck;
	private transient String spe_insertError;

	public SPE_DAILY_AMAZON_EARNING_DEPOTModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getSPE_AutoSrNo() {
		return SPE_AutoSrNo;
	}

	public void setSPE_AutoSrNo(Long sPE_AutoSrNo) {
		SPE_AutoSrNo = sPE_AutoSrNo;
	}

	public String getSPE_ProductCategory() {
		return SPE_ProductCategory;
	}

	public void setSPE_ProductCategory(String sPE_ProductCategory) {
		SPE_ProductCategory = sPE_ProductCategory;
	}

	public String getSPE_CommissionCategory() {
		return SPE_CommissionCategory;
	}

	public void setSPE_CommissionCategory(String sPE_CommissionCategory) {
		SPE_CommissionCategory = sPE_CommissionCategory;
	}

	public String getSPE_ProductName() {
		return SPE_ProductName;
	}

	public void setSPE_ProductName(String sPE_ProductName) {
		SPE_ProductName = sPE_ProductName;
	}

	public String getSPE_StoreID() {
		return SPE_StoreID;
	}

	public void setSPE_StoreID(String sPE_StoreID) {
		SPE_StoreID = sPE_StoreID;
	}

	public String getSPE_TxnID() {
		return SPE_TxnID;
	}

	public void setSPE_TxnID(String sPE_TxnID) {
		SPE_TxnID = sPE_TxnID;
	}

	public Date getSPE_DateShipped() {
		return SPE_DateShipped;
	}

	public void setSPE_DateShipped(Date sPE_DateShipped) {
		SPE_DateShipped = sPE_DateShipped;
	}

	public Float getSPE_Price() {
		return SPE_Price;
	}

	public void setSPE_Price(Float sPE_Price) {
		SPE_Price = sPE_Price;
	}

	public Integer getSPE_ItemShipped() {
		return SPE_ItemShipped;
	}

	public void setSPE_ItemShipped(Integer sPE_ItemShipped) {
		SPE_ItemShipped = sPE_ItemShipped;
	}

	public Integer getSPE_ItemRetrun() {
		return SPE_ItemRetrun;
	}

	public void setSPE_ItemRetrun(Integer sPE_ItemRetrun) {
		SPE_ItemRetrun = sPE_ItemRetrun;
	}

	public Float getSPE_CommssionEarned() {
		return SPE_CommssionEarned;
	}

	public void setSPE_CommssionEarned(Float sPE_CommssionEarned) {
		SPE_CommssionEarned = sPE_CommssionEarned;
	}

	public String getSPE_DeviceTypeGroup() {
		return SPE_DeviceTypeGroup;
	}

	public void setSPE_DeviceTypeGroup(String sPE_DeviceTypeGroup) {
		SPE_DeviceTypeGroup = sPE_DeviceTypeGroup;
	}

	public Integer getSPE_IsCommRecieved() {
		return SPE_IsCommRecieved;
	}

	public void setSPE_IsCommRecieved(Integer sPE_IsCommRecieved) {
		SPE_IsCommRecieved = sPE_IsCommRecieved;
	}

	public Integer getSPE_IsValidRecord() {
		return SPE_IsValidRecord;
	}

	public void setSPE_IsValidRecord(Integer sPE_IsValidRecord) {
		SPE_IsValidRecord = sPE_IsValidRecord;
	}

	public String getSPE_Option1() {
		return SPE_Option1;
	}

	public void setSPE_Option1(String sPE_Option1) {
		SPE_Option1 = sPE_Option1;
	}

	public String getSPE_Option2() {
		return SPE_Option2;
	}

	public void setSPE_Option2(String sPE_Option2) {
		SPE_Option2 = sPE_Option2;
	}

	public String getSPE_Option3() {
		return SPE_Option3;
	}

	public void setSPE_Option3(String sPE_Option3) {
		SPE_Option3 = sPE_Option3;
	}

	public String getSPE_Option4() {
		return SPE_Option4;
	}

	public void setSPE_Option4(String sPE_Option4) {
		SPE_Option4 = sPE_Option4;
	}

	public String getSPE_Option5() {
		return SPE_Option5;
	}

	public void setSPE_Option5(String sPE_Option5) {
		SPE_Option5 = sPE_Option5;
	}

	public String getSPE_Option6() {
		return SPE_Option6;
	}

	public void setSPE_Option6(String sPE_Option6) {
		SPE_Option6 = sPE_Option6;
	}

	public String getSPE_Option7() {
		return SPE_Option7;
	}

	public void setSPE_Option7(String sPE_Option7) {
		SPE_Option7 = sPE_Option7;
	}

	public String getSPE_Option8() {
		return SPE_Option8;
	}

	public void setSPE_Option8(String sPE_Option8) {
		SPE_Option8 = sPE_Option8;
	}

	public String getSPE_Option9() {
		return SPE_Option9;
	}

	public void setSPE_Option9(String sPE_Option9) {
		SPE_Option9 = sPE_Option9;
	}

	public String getSPE_Option10() {
		return SPE_Option10;
	}

	public void setSPE_Option10(String sPE_Option10) {
		SPE_Option10 = sPE_Option10;
	}

	public Integer getSPE_Option11() {
		return SPE_Option11;
	}

	public void setSPE_Option11(Integer sPE_Option11) {
		SPE_Option11 = sPE_Option11;
	}

	public Integer getSPE_Option12() {
		return SPE_Option12;
	}

	public void setSPE_Option12(Integer sPE_Option12) {
		SPE_Option12 = sPE_Option12;
	}

	public Integer getSPE_Option13() {
		return SPE_Option13;
	}

	public void setSPE_Option13(Integer sPE_Option13) {
		SPE_Option13 = sPE_Option13;
	}

	public Float getSPE_Option14() {
		return SPE_Option14;
	}

	public void setSPE_Option14(Float sPE_Option14) {
		SPE_Option14 = sPE_Option14;
	}

	public Float getSPE_Option15() {
		return SPE_Option15;
	}

	public void setSPE_Option15(Float sPE_Option15) {
		SPE_Option15 = sPE_Option15;
	}

	public Date getSPE_TxnDate() {
		return SPE_TxnDate;
	}

	public void setSPE_TxnDate(Date sPE_TxnDate) {
		SPE_TxnDate = sPE_TxnDate;
	}

	public Float getSPE_TotalSellPrice() {
		return SPE_TotalSellPrice;
	}

	public void setSPE_TotalSellPrice(Float sPE_TotalSellPrice) {
		SPE_TotalSellPrice = sPE_TotalSellPrice;
	}

	public Float getSPE_DisctAmt() {
		return SPE_DisctAmt;
	}

	public void setSPE_DisctAmt(Float sPE_DisctAmt) {
		SPE_DisctAmt = sPE_DisctAmt;
	}

	public Float getSPE_NewCustDisctAmt() {
		return SPE_NewCustDisctAmt;
	}

	public void setSPE_NewCustDisctAmt(Float sPE_NewCustDisctAmt) {
		SPE_NewCustDisctAmt = sPE_NewCustDisctAmt;
	}

	public String getSPE_AMZ_TxnID() {
		return SPE_AMZ_TxnID;
	}

	public void setSPE_AMZ_TxnID(String sPE_AMZ_TxnID) {
		SPE_AMZ_TxnID = sPE_AMZ_TxnID;
	}

	public String getSPE_AMZ_SELL_TxnRef() {
		return SPE_AMZ_SELL_TxnRef;
	}

	public void setSPE_AMZ_SELL_TxnRef(String sPE_AMZ_SELL_TxnRef) {
		SPE_AMZ_SELL_TxnRef = sPE_AMZ_SELL_TxnRef;
	}

	public Integer getSPE_RECORD_STATUS() {
		return SPE_RECORD_STATUS;
	}

	public void setSPE_RECORD_STATUS(Integer sPE_RECORD_STATUS) {
		SPE_RECORD_STATUS = sPE_RECORD_STATUS;
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
		return "SPE_DAILY_AMAZON_EARNING_DEPOTModel [SPE_AutoSrNo=" + SPE_AutoSrNo + ", SPE_ProductCategory="
				+ SPE_ProductCategory + ", SPE_CommissionCategory=" + SPE_CommissionCategory + ", SPE_ProductName="
				+ SPE_ProductName + ", SPE_StoreID=" + SPE_StoreID + ", SPE_TxnID=" + SPE_TxnID + ", SPE_DateShipped="
				+ SPE_DateShipped + ", SPE_Price=" + SPE_Price + ", SPE_ItemShipped=" + SPE_ItemShipped
				+ ", SPE_ItemRetrun=" + SPE_ItemRetrun + ", SPE_CommssionEarned=" + SPE_CommssionEarned
				+ ", SPE_DeviceTypeGroup=" + SPE_DeviceTypeGroup + ", SPE_IsCommRecieved=" + SPE_IsCommRecieved
				+ ", SPE_IsValidRecord=" + SPE_IsValidRecord + ", SPE_Option1=" + SPE_Option1 + ", SPE_Option2="
				+ SPE_Option2 + ", SPE_Option3=" + SPE_Option3 + ", SPE_Option4=" + SPE_Option4 + ", SPE_Option5="
				+ SPE_Option5 + ", SPE_Option6=" + SPE_Option6 + ", SPE_Option7=" + SPE_Option7 + ", SPE_Option8="
				+ SPE_Option8 + ", SPE_Option9=" + SPE_Option9 + ", SPE_Option10=" + SPE_Option10 + ", SPE_Option11="
				+ SPE_Option11 + ", SPE_Option12=" + SPE_Option12 + ", SPE_Option13=" + SPE_Option13 + ", SPE_Option14="
				+ SPE_Option14 + ", SPE_Option15=" + SPE_Option15 + ", SPE_TxnDate=" + SPE_TxnDate
				+ ", SPE_TotalSellPrice=" + SPE_TotalSellPrice + ", SPE_DisctAmt=" + SPE_DisctAmt
				+ ", SPE_NewCustDisctAmt=" + SPE_NewCustDisctAmt + ", SPE_AMZ_TxnID=" + SPE_AMZ_TxnID
				+ ", SPE_AMZ_SELL_TxnRef=" + SPE_AMZ_SELL_TxnRef + ", SPE_RECORD_STATUS=" + SPE_RECORD_STATUS + "]";
	}
    
}
