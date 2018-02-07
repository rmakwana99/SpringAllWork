
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
 * @author rahul
 * 
 *         It contains all SPE_DAILY_SETTLEMENT_DEPOT database fields and its
 *         setter and getter method it is Model of SPE_DAILY_SETTLEMENT_DEPOT table
 */
@XmlRootElement
@Entity
@Table(name = "SPE_DAILY_SETTLEMENT_DEPOT")
@DynamicInsert
@DynamicUpdate
public class SPE_SDP_BankDailySettlementModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long SPE_AutoSrNo;
	private String SPE_PGMerchantID;
	private String SPE_LegalName;
	private String SPE_DBAName;
	private String SPE_PayeePSP;
	private String SPE_PayeeAccName;
	private Long SPE_PayeeAccNo;
	private String SPE_PayeeIFSCCode;
	private String SPE_PayeeVirtualAddr;
	private Long SPE_TransRefNo;
	private String SPE_TransType;
	private Float SPE_TransactionAmount;
	private String SPE_TransactionRemarks;
	private Date SPE_TransReqDate;
	private String SPE_OrderNo;
	private String SPE_Currency;
	private Float SPE_METRNReqAmt;
	private String SPE_METRNReqStatus;
	private String SPE_PaymentRefNo;
	private String SPE_PayerPSPName;
	private String SPE_PayerAccName;
	private Long SPE_PayerAccNo;
	private String SPE_PayerAccType;
	private String SPE_PayerIFSCCode;
	private String SPE_PayerVirtualAddr;
	private String SPE_DeviceType;
	private String SPE_App;
	private String SPE_DeviceOS;
	private Long SPE_DeviceMobileNo;
	private String SPE_DeviceLocation;
	private String SPE_IPAddress; 
	private String SPE_SettlementStatus;
	private Date SPE_SettlementDate;
	private Float SPE_SettlementAmount;
	private Float SPE_MSFAmount;
	private Float SPE_MSFTaxAmount;
	private String SPE_PayoutStatus;
	private String SPE_MCC;
	private String SPE_NPCIResponseCode;
	private String SPE_CROrDR;
	private String SPE_TransactionStatus;
	private String SPE_PayType;
	private String SPE_Validationstatus;
	private String SPE_ValidationError;
	private Integer SPE_FutureOption1;
	private Integer SPE_FutureOption2;
	private String SPE_FutureOption3;
	private String SPE_FutureOption4;
	private String SPE_FutureOption5;
	private String SPE_FutureOption6;
	private String SPE_FutureOption7;
	private String SPE_FutureOption8;
	
	private transient Boolean excelCheck;
	private transient String excelError;
	private transient Boolean insertCheck;
	private transient String insertError;
	private transient Boolean updateCheck;
	private transient String updateError;
	
	//all getters and setters of this table
	public Long getSPE_AutoSrNo() {
		return SPE_AutoSrNo;
	}
	public void setSPE_AutoSrNo(Long sPE_AutoSrNo) {
		SPE_AutoSrNo = sPE_AutoSrNo;
	}
	public String getSPE_PGMerchantID() {
		return SPE_PGMerchantID;
	}
	public void setSPE_PGMerchantID(String sPE_PGMerchantID) {
		SPE_PGMerchantID = sPE_PGMerchantID;
	}
	public String getSPE_LegalName() {
		return SPE_LegalName;
	}
	public void setSPE_LegalName(String sPE_LegalName) {
		SPE_LegalName = sPE_LegalName;
	}
	public String getSPE_DBAName() {
		return SPE_DBAName;
	}
	public void setSPE_DBAName(String sPE_DBAName) {
		SPE_DBAName = sPE_DBAName;
	}
	public String getSPE_PayeePSP() {
		return SPE_PayeePSP;
	}
	public void setSPE_PayeePSP(String sPE_PayeePSP) {
		SPE_PayeePSP = sPE_PayeePSP;
	}
	public Long getSPE_PayeeAccNo() {
		return SPE_PayeeAccNo;
	}
	public void setSPE_PayeeAccNo(Long sPE_PayeeAccNo) {
		SPE_PayeeAccNo = sPE_PayeeAccNo;
	}
	public String getSPE_PayeeIFSCCode() {
		return SPE_PayeeIFSCCode;
	}
	public void setSPE_PayeeIFSCCode(String sPE_PayeeIFSCCode) {
		SPE_PayeeIFSCCode = sPE_PayeeIFSCCode;
	}
	public String getSPE_PayeeVirtualAddr() {
		return SPE_PayeeVirtualAddr;
	}
	public void setSPE_PayeeVirtualAddr(String sPE_PayeeVirtualAddr) {
		SPE_PayeeVirtualAddr = sPE_PayeeVirtualAddr;
	}
	public Long getSPE_TransRefNo() {
		return SPE_TransRefNo;
	}
	public void setSPE_TransRefNo(Long sPE_TransRefNo) {
		SPE_TransRefNo = sPE_TransRefNo;
	}
	public String getSPE_TransType() {
		return SPE_TransType;
	}
	public void setSPE_TransType(String sPE_TransType) {
		SPE_TransType = sPE_TransType;
	}
	public Float getSPE_TransactionAmount() {
		return SPE_TransactionAmount;
	}
	public void setSPE_TransactionAmount(Float sPE_TransactionAmount) {
		SPE_TransactionAmount = sPE_TransactionAmount;
	}
	public String getSPE_TransactionRemarks() {
		return SPE_TransactionRemarks;
	}
	public void setSPE_TransactionRemarks(String sPE_TransactionRemarks) {
		SPE_TransactionRemarks = sPE_TransactionRemarks;
	}
	public Date getSPE_TransReqDate() {
		return SPE_TransReqDate;
	}
	public void setSPE_TransReqDate(Date sPE_TransReqDate) {
		SPE_TransReqDate = sPE_TransReqDate;
	}
	public String getSPE_OrderNo() {
		return SPE_OrderNo;
	}
	public void setSPE_OrderNo(String sPE_OrderNo) {
		SPE_OrderNo = sPE_OrderNo;
	}
	public String getSPE_Currency() {
		return SPE_Currency;
	}
	public void setSPE_Currency(String sPE_Currency) {
		SPE_Currency = sPE_Currency;
	}
	public Float getSPE_METRNReqAmt() {
		return SPE_METRNReqAmt;
	}
	public void setSPE_METRNReqAmt(Float sPE_METRNReqAmt) {
		SPE_METRNReqAmt = sPE_METRNReqAmt;
	}
	public String getSPE_METRNReqStatus() {
		return SPE_METRNReqStatus;
	}
	public void setSPE_METRNReqStatus(String sPE_METRNReqStatus) {
		SPE_METRNReqStatus = sPE_METRNReqStatus;
	}
	public String getSPE_PaymentRefNo() {
		return SPE_PaymentRefNo;
	}
	public void setSPE_PaymentRefNo(String sPE_PaymentRefNo) {
		SPE_PaymentRefNo = sPE_PaymentRefNo;
	}
	public String getSPE_PayerPSPName() {
		return SPE_PayerPSPName;
	}
	public void setSPE_PayerPSPName(String sPE_PayerPSPName) {
		SPE_PayerPSPName = sPE_PayerPSPName;
	}
	public String getSPE_PayerAccName() {
		return SPE_PayerAccName;
	}
	public void setSPE_PayerAccName(String sPE_PayerAccName) {
		SPE_PayerAccName = sPE_PayerAccName;
	}
	public Long getSPE_PayerAccNo() {
		return SPE_PayerAccNo;
	}
	public void setSPE_PayerAccNo(Long sPE_PayerAccNo) {
		SPE_PayerAccNo = sPE_PayerAccNo;
	}
	public String getSPE_PayerAccType() {
		return SPE_PayerAccType;
	}
	public void setSPE_PayerAccType(String sPE_PayerAccType) {
		SPE_PayerAccType = sPE_PayerAccType;
	}
	public String getSPE_PayerIFSCCode() {
		return SPE_PayerIFSCCode;
	}
	public void setSPE_PayerIFSCCode(String sPE_PayerIFSCCode) {
		SPE_PayerIFSCCode = sPE_PayerIFSCCode;
	}
	public String getSPE_PayerVirtualAddr() {
		return SPE_PayerVirtualAddr;
	}
	public void setSPE_PayerVirtualAddr(String sPE_PayerVirtualAddr) {
		SPE_PayerVirtualAddr = sPE_PayerVirtualAddr;
	}
	public String getSPE_DeviceType() {
		return SPE_DeviceType;
	}
	public void setSPE_DeviceType(String sPE_DeviceType) {
		SPE_DeviceType = sPE_DeviceType;
	}
	public String getSPE_App() {
		return SPE_App;
	}
	public void setSPE_App(String sPE_App) {
		SPE_App = sPE_App;
	}
	public String getSPE_DeviceOS() {
		return SPE_DeviceOS;
	}
	public void setSPE_DeviceOS(String sPE_DeviceOS) {
		SPE_DeviceOS = sPE_DeviceOS;
	}
	public Long getSPE_DeviceMobileNo() {
		return SPE_DeviceMobileNo;
	}
	public void setSPE_DeviceMobileNo(Long sPE_DeviceMobileNo) {
		SPE_DeviceMobileNo = sPE_DeviceMobileNo;
	}
	public String getSPE_DeviceLocation() {
		return SPE_DeviceLocation;
	}
	public void setSPE_DeviceLocation(String sPE_DeviceLocation) {
		SPE_DeviceLocation = sPE_DeviceLocation;
	}
	public String getSPE_IPAddress() {
		return SPE_IPAddress;
	}
	public void setSPE_IPAddress(String sPE_IPAddress) {
		SPE_IPAddress = sPE_IPAddress;
	}
	public String getSPE_SettlementStatus() {
		return SPE_SettlementStatus;
	}
	public void setSPE_SettlementStatus(String sPE_SettlementStatus) {
		SPE_SettlementStatus = sPE_SettlementStatus;
	}
	public Date getSPE_SettlementDate() {
		return SPE_SettlementDate;
	}
	public void setSPE_SettlementDate(Date sPE_SettlementDate) {
		SPE_SettlementDate = sPE_SettlementDate;
	}
	public Float getSPE_SettlementAmount() {
		return SPE_SettlementAmount;
	}
	public void setSPE_SettlementAmount(Float sPE_SettlementAmount) {
		SPE_SettlementAmount = sPE_SettlementAmount;
	}
	public Float getSPE_MSFAmount() {
		return SPE_MSFAmount;
	}
	public void setSPE_MSFAmount(Float sPE_MSFAmount) {
		SPE_MSFAmount = sPE_MSFAmount;
	}
	public Float getSPE_MSFTaxAmount() {
		return SPE_MSFTaxAmount;
	}
	public void setSPE_MSFTaxAmount(Float sPE_MSFTaxAmount) {
		SPE_MSFTaxAmount = sPE_MSFTaxAmount;
	}
	public String getSPE_PayoutStatus() {
		return SPE_PayoutStatus;
	}
	public void setSPE_PayoutStatus(String sPE_PayoutStatus) {
		SPE_PayoutStatus = sPE_PayoutStatus;
	}
	public String getSPE_SPE_Validationstatus() {
		return SPE_Validationstatus;
	}
	public void setSPE_SPE_Validationstatus(String sPE_SPE_Validationstatus) {
		SPE_Validationstatus = sPE_SPE_Validationstatus;
	}
	public String getSPE_ValidationError() {
		return SPE_ValidationError;
	}
	public void setSPE_ValidationError(String sPE_ValidationError) {
		SPE_ValidationError = sPE_ValidationError;
	}
	public Integer getSPE_FutureOption1() {
		return SPE_FutureOption1;
	}
	public void setSPE_FutureOption1(Integer sPE_FutureOption1) {
		SPE_FutureOption1 = sPE_FutureOption1;
	}
	public Integer getSPE_FutureOption2() {
		return SPE_FutureOption2;
	}
	public void setSPE_FutureOption2(Integer sPE_FutureOption2) {
		SPE_FutureOption2 = sPE_FutureOption2;
	}
	public String getSPE_FutureOption3() {
		return SPE_FutureOption3;
	}
	public void setSPE_FutureOption3(String sPE_FutureOption3) {
		SPE_FutureOption3 = sPE_FutureOption3;
	}
	public String getSPE_FutureOption4() {
		return SPE_FutureOption4;
	}
	public void setSPE_FutureOption4(String sPE_FutureOption4) {
		SPE_FutureOption4 = sPE_FutureOption4;
	}
	public String getSPE_FutureOption5() {
		return SPE_FutureOption5;
	}
	public void setSPE_FutureOption5(String sPE_FutureOption5) {
		SPE_FutureOption5 = sPE_FutureOption5;
	}
	public String getSPE_FutureOption6() {
		return SPE_FutureOption6;
	}
	public void setSPE_FutureOption6(String sPE_FutureOption6) {
		SPE_FutureOption6 = sPE_FutureOption6;
	}
	public String getSPE_FutureOption7() {
		return SPE_FutureOption7;
	}
	public void setSPE_FutureOption7(String sPE_FutureOption7) {
		SPE_FutureOption7 = sPE_FutureOption7;
	}
	public String getSPE_FutureOption8() {
		return SPE_FutureOption8;
	}
	public void setSPE_FutureOption8(String sPE_FutureOption8) {
		SPE_FutureOption8 = sPE_FutureOption8;
	}
	public String getSPE_PayeeAccName() {
		return SPE_PayeeAccName;
	}
	public void setSPE_PayeeAccName(String sPE_PayeeAccName) {
		SPE_PayeeAccName = sPE_PayeeAccName;
	}
	public String getSPE_MCC() {
		return SPE_MCC;
	}
	public void setSPE_MCC(String sPE_MCC) {
		SPE_MCC = sPE_MCC;
	}
	public String getSPE_NPCIResponseCode() {
		return SPE_NPCIResponseCode;
	}
	public void setSPE_NPCIResponseCode(String sPE_NPCIResponseCode) {
		SPE_NPCIResponseCode = sPE_NPCIResponseCode;
	}
	public String getSPE_CROrDR() {
		return SPE_CROrDR;
	}
	public void setSPE_CROrDR(String sPE_CROrDR) {
		SPE_CROrDR = sPE_CROrDR;
	}
	public String getSPE_TransactionStatus() {
		return SPE_TransactionStatus;
	}
	public void setSPE_TransactionStatus(String sPE_TransactionStatus) {
		SPE_TransactionStatus = sPE_TransactionStatus;
	}
	public String getSPE_PayType() {
		return SPE_PayType;
	}
	public void setSPE_PayType(String sPE_PayType) {
		SPE_PayType = sPE_PayType;
	}
	public Boolean getExcelCheck() {
		return excelCheck;
	}
	public void setExcelCheck(Boolean excelCheck) {
		this.excelCheck = excelCheck;
	}
	public String getExcelError() {
		return excelError;
	}
	public void setExcelError(String excelError) {
		this.excelError = excelError;
	}
	public Boolean getInsertCheck() {
		return insertCheck;
	}
	public void setInsertCheck(Boolean insertCheck) {
		this.insertCheck = insertCheck;
	}
	public String getInsertError() {
		return insertError;
	}
	public void setInsertError(String insertError) {
		this.insertError = insertError;
	}
	public Boolean getUpdateCheck() {
		return updateCheck;
	}
	public void setUpdateCheck(Boolean updateCheck) {
		this.updateCheck = updateCheck;
	}
	public String getUpdateError() {
		return updateError;
	}
	public void setUpdateError(String updateError) {
		this.updateError = updateError;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SPE_SDP_BankDailySettlementModel [SPE_AutoSrNo=" + SPE_AutoSrNo + ", SPE_PGMerchantID="
				+ SPE_PGMerchantID + ", SPE_LegalName=" + SPE_LegalName + ", SPE_DBAName=" + SPE_DBAName
				+ ", SPE_PayeePSP=" + SPE_PayeePSP + ", SPE_PayeeAccName=" + SPE_PayeeAccName + ", SPE_PayeeAccNo="
				+ SPE_PayeeAccNo + ", SPE_PayeeIFSCCode=" + SPE_PayeeIFSCCode + ", SPE_PayeeVirtualAddr="
				+ SPE_PayeeVirtualAddr + ", SPE_TransRefNo=" + SPE_TransRefNo + ", SPE_TransType=" + SPE_TransType
				+ ", SPE_TransactionAmount=" + SPE_TransactionAmount + ", SPE_TransactionRemarks="
				+ SPE_TransactionRemarks + ", SPE_TransReqDate=" + SPE_TransReqDate + ", SPE_OrderNo=" + SPE_OrderNo
				+ ", SPE_Currency=" + SPE_Currency + ", SPE_METRNReqAmt=" + SPE_METRNReqAmt + ", SPE_METRNReqStatus="
				+ SPE_METRNReqStatus + ", SPE_PaymentRefNo=" + SPE_PaymentRefNo + ", SPE_PayerPSPName="
				+ SPE_PayerPSPName + ", SPE_PayerAccName=" + SPE_PayerAccName + ", SPE_PayerAccNo=" + SPE_PayerAccNo
				+ ", SPE_PayerAccType=" + SPE_PayerAccType + ", SPE_PayerIFSCCode=" + SPE_PayerIFSCCode
				+ ", SPE_PayerVirtualAddr=" + SPE_PayerVirtualAddr + ", SPE_DeviceType=" + SPE_DeviceType + ", SPE_App="
				+ SPE_App + ", SPE_DeviceOS=" + SPE_DeviceOS + ", SPE_DeviceMobileNo=" + SPE_DeviceMobileNo
				+ ", SPE_DeviceLocation=" + SPE_DeviceLocation + ", SPE_IPAddress=" + SPE_IPAddress
				+ ", SPE_SettlementStatus=" + SPE_SettlementStatus + ", SPE_SettlementDate=" + SPE_SettlementDate
				+ ", SPE_SettlementAmount=" + SPE_SettlementAmount + ", SPE_MSFAmount=" + SPE_MSFAmount
				+ ", SPE_MSFTaxAmount=" + SPE_MSFTaxAmount + ", SPE_PayoutStatus=" + SPE_PayoutStatus + ", SPE_MCC="
				+ SPE_MCC + ", SPE_NPCIResponseCode=" + SPE_NPCIResponseCode + ", SPE_CROrDR=" + SPE_CROrDR
				+ ", SPE_TransactionStatus=" + SPE_TransactionStatus + ", SPE_PayType=" + SPE_PayType
				+ ", SPE_SPE_Validationstatus=" + SPE_Validationstatus + ", SPE_ValidationError="
				+ SPE_ValidationError + ", SPE_FutureOption1=" + SPE_FutureOption1 + ", SPE_FutureOption2="
				+ SPE_FutureOption2 + ", SPE_FutureOption3=" + SPE_FutureOption3 + ", SPE_FutureOption4="
				+ SPE_FutureOption4 + ", SPE_FutureOption5=" + SPE_FutureOption5 + ", SPE_FutureOption6="
				+ SPE_FutureOption6 + ", SPE_FutureOption7=" + SPE_FutureOption7 + ", SPE_FutureOption8="
				+ SPE_FutureOption8 + "]";
	}
	
}
