package com.rahul.phmc.sopdb.model;

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
 * @author rahul
 *
 */
@XmlRootElement
@Entity
@Table (name = "SOPDB_AAPNA_SEVA2_0_Table1")
@DynamicInsert
@DynamicUpdate
public class PHMC_SOPDB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long SOPDB_AutoSrNo;	
	private String SOPDB_DeviceID_Mfg;	
	private String SOPDB_DeviceID_ModelNo;	
	private String SOPDB_DeviceID_SrNo;
	private Integer SOPDB_SrNO;
	private String SOPDB_Option;	
	private String SOPDB_PCOID;
	private String SOPDB_Location;
	private Integer SOPDB_ServiceID;	
	private String SOPDB_ServiceName;	
	private String SOPDB_SubServiceName;	
	private Date SOPDB_TxnDate;	
	private String SOPDB_TxnTime;
	private String SOPDB_Duration;
	private String SOPDB_RefNo;
	private String SOPDB_ServiceDetails;	
	private String SOPDB_TxnID;
	private Integer SOPDB_Units;	
	private Float SOPDB_TxnAmount;	
	private Float SOPDB_ConvenienceCharge;	
	private Float SOPDB_Adjustment;	
	private Float SOPDB_BillAmount;	
	private Float SOPDB_Commission;
	private String SOPDB_PrintMode;
	private String SOPDB_LoginID;
	private String SOPDB_LoginType;
	private String SOPDB_LoginUserMode;
	private String SOPDB_ServiceOperator;
	private String SOPDB_ServiceRef1;
	private String SOPDB_ServiceRef2;
	private String SOPDB_Status;
	private String SOPDB_Reason;
	private String SOPDB_RRN;
	private Integer SOPDB_SrNo2_future1;
	private Integer SOPDB_UIDAIChannel;
	private Float SOPDB_futureOption3;
	private String SOPDB_OpeningBalance;
	private String SOPDB_ClosingBalnce;
	private String SOPDB_PaymentMode;
	private String SOPDB_futureOption7;
	private String SOPDB_futureOption8;
	private String SOPDB_InsertionMode;
	private Integer SOPDB_futureOption9;
	private Integer SOPDB_futureOption10;
	private Float SOPDB_futureOption11;
	private Float SOPDB_futureOption12;
	private String SOPDB_futureOption13;
	private String SOPDB_futureOption14;
	private String SOPDB_futureOption15;
	private String SOPDB_futureOption16;
	
	
	public String getSOPDB_LoginID() {
		return SOPDB_LoginID;
	}
	public void setSOPDB_LoginID(String sOPDB_LoginID) {
		SOPDB_LoginID = sOPDB_LoginID;
	}
	public Long getSOPDB_AutoSrNo() {
		return SOPDB_AutoSrNo;
	}
	public void setSOPDB_AutoSrNo(Long sOPDB_AutoSrNo) {
		SOPDB_AutoSrNo = sOPDB_AutoSrNo;
	}
	public String getSOPDB_DeviceID_Mfg() {
		return SOPDB_DeviceID_Mfg;
	}
	public void setSOPDB_DeviceID_Mfg(String sOPDB_DeviceID_Mfg) {
		SOPDB_DeviceID_Mfg = sOPDB_DeviceID_Mfg;
	}
	public String getSOPDB_DeviceID_ModelNo() {
		return SOPDB_DeviceID_ModelNo;
	}
	public void setSOPDB_DeviceID_ModelNo(String sOPDB_DeviceID_ModelNo) {
		SOPDB_DeviceID_ModelNo = sOPDB_DeviceID_ModelNo;
	}
	public String getSOPDB_DeviceID_SrNo() {
		return SOPDB_DeviceID_SrNo;
	}
	public void setSOPDB_DeviceID_SrNo(String sOPDB_DeviceID_SrNo) {
		SOPDB_DeviceID_SrNo = sOPDB_DeviceID_SrNo;
	}
	public Integer getSOPDB_SrNO() {
		return SOPDB_SrNO;
	}
	public void setSOPDB_SrNO(Integer sOPDB_SrNO) {
		SOPDB_SrNO = sOPDB_SrNO;
	}
	public String getSOPDB_Option() {
		return SOPDB_Option;
	}
	public void setSOPDB_Option(String sOPDB_Option) {
		SOPDB_Option = sOPDB_Option;
	}
	public String getSOPDB_PCOID() {
		return SOPDB_PCOID;
	}
	public void setSOPDB_PCOID(String sOPDB_PCOID) {
		SOPDB_PCOID = sOPDB_PCOID;
	}
	public String getSOPDB_Location() {
		return SOPDB_Location;
	}
	public void setSOPDB_Location(String sOPDB_Location) {
		SOPDB_Location = sOPDB_Location;
	}
	public Integer getSOPDB_ServiceID() {
		return SOPDB_ServiceID;
	}
	public void setSOPDB_ServiceID(Integer sOPDB_ServiceID) {
		SOPDB_ServiceID = sOPDB_ServiceID;
	}
	public String getSOPDB_ServiceName() {
		return SOPDB_ServiceName;
	}
	public void setSOPDB_ServiceName(String sOPDB_ServiceName) {
		SOPDB_ServiceName = sOPDB_ServiceName;
	}
	public String getSOPDB_SubServiceName() {
		return SOPDB_SubServiceName;
	}
	public void setSOPDB_SubServiceName(String sOPDB_SubServiceName) {
		SOPDB_SubServiceName = sOPDB_SubServiceName;
	}
	public Date getSOPDB_TxnDate() {
		return SOPDB_TxnDate;
	}
	public void setSOPDB_TxnDate(Date sOPDB_TxnDate) {
		SOPDB_TxnDate = sOPDB_TxnDate;
	}
	public String getSOPDB_TxnTime() {
		return SOPDB_TxnTime;
	}
	public void setSOPDB_TxnTime(String sOPDB_TxnTime) {
		SOPDB_TxnTime = sOPDB_TxnTime;
	}
	public String getSOPDB_Duration() {
		return SOPDB_Duration;
	}
	public void setSOPDB_Duration(String sOPDB_Duration) {
		SOPDB_Duration = sOPDB_Duration;
	}
	public String getSOPDB_RefNo() {
		return SOPDB_RefNo;
	}
	public void setSOPDB_RefNo(String sOPDB_RefNo) {
		SOPDB_RefNo = sOPDB_RefNo;
	}
	public String getSOPDB_ServiceDetails() {
		return SOPDB_ServiceDetails;
	}
	public void setSOPDB_ServiceDetails(String sOPDB_ServiceDetails) {
		SOPDB_ServiceDetails = sOPDB_ServiceDetails;
	}
	public String getSOPDB_TxnID() {
		return SOPDB_TxnID;
	}
	public void setSOPDB_TxnID(String sOPDB_TxnID) {
		SOPDB_TxnID = sOPDB_TxnID;
	}
	public Integer getSOPDB_Units() {
		return SOPDB_Units;
	}
	public void setSOPDB_Units(Integer sOPDB_Units) {
		SOPDB_Units = sOPDB_Units;
	}
	public Float getSOPDB_TxnAmount() {
		return SOPDB_TxnAmount;
	}
	public void setSOPDB_TxnAmount(Float sOPDB_TxnAmount) {
		SOPDB_TxnAmount = sOPDB_TxnAmount;
	}
	public Float getSOPDB_ConvenienceCharge() {
		return SOPDB_ConvenienceCharge;
	}
	public void setSOPDB_ConvenienceCharge(Float sOPDB_ConvenienceCharge) {
		SOPDB_ConvenienceCharge = sOPDB_ConvenienceCharge;
	}
	public Float getSOPDB_Adjustment() {
		return SOPDB_Adjustment;
	}
	public void setSOPDB_Adjustment(Float sOPDB_Adjustment) {
		SOPDB_Adjustment = sOPDB_Adjustment;
	}
	public Float getSOPDB_BillAmount() {
		return SOPDB_BillAmount;
	}
	public void setSOPDB_BillAmount(Float sOPDB_BillAmount) {
		SOPDB_BillAmount = sOPDB_BillAmount;
	}
	public Float getSOPDB_Commission() {
		return SOPDB_Commission;
	}
	public void setSOPDB_Commission(Float sOPDB_Commission) {
		SOPDB_Commission = sOPDB_Commission;
	}
	public String getSOPDB_PrintMode() {
		return SOPDB_PrintMode;
	}
	public void setSOPDB_PrintMode(String sOPDB_PrintMode) {
		SOPDB_PrintMode = sOPDB_PrintMode;
	}
	public String getSOPDB_LoginType() {
		return SOPDB_LoginType;
	}
	public void setSOPDB_LoginType(String sOPDB_LoginType) {
		SOPDB_LoginType = sOPDB_LoginType;
	}
	public String getSOPDB_LoginUserMode() {
		return SOPDB_LoginUserMode;
	}
	public void setSOPDB_LoginUserMode(String sOPDB_LoginUserMode) {
		SOPDB_LoginUserMode = sOPDB_LoginUserMode;
	}
	public String getSOPDB_ServiceOperator() {
		return SOPDB_ServiceOperator;
	}
	public void setSOPDB_ServiceOperator(String sOPDB_ServiceOperator) {
		SOPDB_ServiceOperator = sOPDB_ServiceOperator;
	}
	public String getSOPDB_ServiceRef1() {
		return SOPDB_ServiceRef1;
	}
	public void setSOPDB_ServiceRef1(String sOPDB_ServiceRef1) {
		SOPDB_ServiceRef1 = sOPDB_ServiceRef1;
	}
	public String getSOPDB_ServiceRef2() {
		return SOPDB_ServiceRef2;
	}
	public void setSOPDB_ServiceRef2(String sOPDB_ServiceRef2) {
		SOPDB_ServiceRef2 = sOPDB_ServiceRef2;
	}
	public String getSOPDB_Status() {
		return SOPDB_Status;
	}
	public void setSOPDB_Status(String sOPDB_Status) {
		SOPDB_Status = sOPDB_Status;
	}
	public String getSOPDB_Reason() {
		return SOPDB_Reason;
	}
	public void setSOPDB_Reason(String sOPDB_Reason) {
		SOPDB_Reason = sOPDB_Reason;
	}
	public String getSOPDB_RRN() {
		return SOPDB_RRN;
	}
	public void setSOPDB_RRN(String sOPDB_RRN) {
		SOPDB_RRN = sOPDB_RRN;
	}
	public Integer getSOPDB_SrNo2_future1() {
		return SOPDB_SrNo2_future1;
	}
	public void setSOPDB_SrNo2_future1(Integer sOPDB_SrNo2_future1) {
		SOPDB_SrNo2_future1 = sOPDB_SrNo2_future1;
	}
	public Integer getSOPDB_UIDAIChannel() {
		return SOPDB_UIDAIChannel;
	}
	public void setSOPDB_UIDAIChannel(Integer sOPDB_UIDAIChannel) {
		SOPDB_UIDAIChannel = sOPDB_UIDAIChannel;
	}
	public Float getSOPDB_futureOption3() {
		return SOPDB_futureOption3;
	}
	public void setSOPDB_futureOption3(Float sOPDB_futureOption3) {
		SOPDB_futureOption3 = sOPDB_futureOption3;
	}
	public String getSOPDB_OpeningBalance() {
		return SOPDB_OpeningBalance;
	}
	public void setSOPDB_OpeningBalance(String sOPDB_OpeningBalance) {
		SOPDB_OpeningBalance = sOPDB_OpeningBalance;
	}
	public String getSOPDB_ClosingBalnce() {
		return SOPDB_ClosingBalnce;
	}
	public void setSOPDB_ClosingBalnce(String sOPDB_ClosingBalnce) {
		SOPDB_ClosingBalnce = sOPDB_ClosingBalnce;
	}
	public String getSOPDB_PaymentMode() {
		return SOPDB_PaymentMode;
	}
	public void setSOPDB_PaymentMode(String sOPDB_PaymentMode) {
		SOPDB_PaymentMode = sOPDB_PaymentMode;
	}
	
	public String getSOPDB_InsertionMode() {
		return SOPDB_InsertionMode;
	}
	public void setSOPDB_InsertionMode(String sOPDB_InsertionMode) {
		SOPDB_InsertionMode = sOPDB_InsertionMode;
	}
	public String getSOPDB_futureOption7() {
		return SOPDB_futureOption7;
	}
	public void setSOPDB_futureOption7(String sOPDB_futureOption7) {
		SOPDB_futureOption7 = sOPDB_futureOption7;
	}
	public String getSOPDB_futureOption8() {
		return SOPDB_futureOption8;
	}
	public void setSOPDB_futureOption8(String sOPDB_futureOption8) {
		SOPDB_futureOption8 = sOPDB_futureOption8;
	}
	public Integer getSOPDB_futureOption9() {
		return SOPDB_futureOption9;
	}
	public void setSOPDB_futureOption9(Integer sOPDB_futureOption9) {
		SOPDB_futureOption9 = sOPDB_futureOption9;
	}
	public Integer getSOPDB_futureOption10() {
		return SOPDB_futureOption10;
	}
	public void setSOPDB_futureOption10(Integer sOPDB_futureOption10) {
		SOPDB_futureOption10 = sOPDB_futureOption10;
	}
	public float getSOPDB_futureOption11() {
		return SOPDB_futureOption11;
	}
	public void setSOPDB_futureOption11(float sOPDB_futureOption11) {
		SOPDB_futureOption11 = sOPDB_futureOption11;
	}
	public float getSOPDB_futureOption12() {
		return SOPDB_futureOption12;
	}
	public void setSOPDB_futureOption12(float sOPDB_futureOption12) {
		SOPDB_futureOption12 = sOPDB_futureOption12;
	}
	public String getSOPDB_futureOption13() {
		return SOPDB_futureOption13;
	}
	public void setSOPDB_futureOption13(String sOPDB_futureOption13) {
		SOPDB_futureOption13 = sOPDB_futureOption13;
	}
	public String getSOPDB_futureOption14() {
		return SOPDB_futureOption14;
	}
	public void setSOPDB_futureOption14(String sOPDB_futureOption14) {
		SOPDB_futureOption14 = sOPDB_futureOption14;
	}
	public String getSOPDB_futureOption15() {
		return SOPDB_futureOption15;
	}
	public void setSOPDB_futureOption15(String sOPDB_futureOption15) {
		SOPDB_futureOption15 = sOPDB_futureOption15;
	}
	public String getSOPDB_futureOption16() {
		return SOPDB_futureOption16;
	}
	public void setSOPDB_futureOption16(String sOPDB_futureOption16) {
		SOPDB_futureOption16 = sOPDB_futureOption16;
	}
	
	

}
