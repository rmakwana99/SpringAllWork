
package com.rahul.phmc.spe.router.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author rahul
 * 
 *         It contains all SPE_TRXN_DETAILS_<ClientID> database fields and its
 *         setters and getters methods. it is Model of SPE_TRXN_DETAILS_
 *         <ClientID> table
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class SPE_TRXNDetailsModel implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
	@Column(name = "SPE_TransactionID", unique = true)
	private String SPE_TransactionID;
	private String SPE_MID;
	private String SPE_TerminalID;
	private String SPE_DeviceID;
	private Float SPE_ErrorCode;
	private String SPE_Response_Code;
	private String SPE_Provider_TransactionID;
	private String SPE_Payer_PaymentAddress1;
	private String SPE_Payer_PaymentAddress2;
	private String SPE_Payer_PaymentAddress3;
	private String SPE_Payee_PaymentAddress1;
	private String SPE_Payee_PaymentAddress2;
	private String SPE_Payee_PaymentAddress3;
	private String SPE_TxnTime;
	private Date SPE_TxnDate;
	private Float SPE_TransactionAmount;
	private Float SPE_ConvinienceAmount;
	private Float SPE_PaymentAmount;
	private Float SPE_ServiceCode;
	private String SPE_SettlementStatus;
	private Date SPE_SettlementDate;
	private Float SPE_SettlementAmount;
	private String SPE_MTransferStatus;
	private String SPE_MTransferMode;
	private String SPE_MTransferredAdd;
	private String SPE_MoneyTransferStatus;
	private Float SPE_MTransferErrorCode;
	private String SPE_CurrencyType;
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
	private Float SPE_Option11;
	private Float SPE_Option12;
	private Float SPE_Option13;
	private Float SPE_Option14;
	private Float SPE_Option15;

	private String SPE_Client;
	private Integer SPE_Application;
	private String SPE_TerminalHub;
	private String SPE_PaymentType;
	private Float SPE_ComsnMerchant;
	private Float SPE_ComsnTerminalHub;
	private Float SPE_ComsnTerminID;
	private Date SPE_ComsnProcessDate;
	private Date SPE_SRSH_SettlementDate;
	private Date SPE_ACK_Date;
	private Integer SPE_ValidationStatus;
	private Integer SPE_ProcessingStatus;
	private Float SPE_ComsnBank;

	public String getSPE_MID() {
		return SPE_MID;
	}

	public void setSPE_MID(String sPE_MID) {
		SPE_MID = sPE_MID;
	}

	public String getSPE_TerminalID() {
		return SPE_TerminalID;
	}

	public void setSPE_TerminalID(String sPE_TerminalID) {
		SPE_TerminalID = sPE_TerminalID;
	}

	public String getSPE_DeviceID() {
		return SPE_DeviceID;
	}

	public void setSPE_DeviceID(String sPE_DeviceID) {
		SPE_DeviceID = sPE_DeviceID;
	}

	public String getSPE_TransactionID() {
		return SPE_TransactionID;
	}

	public void setSPE_TransactionID(String sPE_TransactionID) {
		SPE_TransactionID = sPE_TransactionID;
	}

	public Float getSPE_ErrorCode() {
		return SPE_ErrorCode;
	}

	public void setSPE_ErrorCode(Float sPE_ErrorCode) {
		SPE_ErrorCode = sPE_ErrorCode;
	}

	public String getSPE_Response_Code() {
		return SPE_Response_Code;
	}

	public void setSPE_Response_Code(String sPE_ResponseCode) {
		SPE_Response_Code = sPE_ResponseCode;
	}

	public String getSPE_Provider_TransactionID() {
		return SPE_Provider_TransactionID;
	}

	public void setSPE_Provider_TransactionID(String sPE_Provider_TransactionID) {
		SPE_Provider_TransactionID = sPE_Provider_TransactionID;
	}

	public String getSPE_Payer_PaymentAddress1() {
		return SPE_Payer_PaymentAddress1;
	}

	public void setSPE_Payer_PaymentAddress1(String sPE_Payer_PaymentAddress1) {
		SPE_Payer_PaymentAddress1 = sPE_Payer_PaymentAddress1;
	}

	public String getSPE_Payer_PaymentAddress2() {
		return SPE_Payer_PaymentAddress2;
	}

	public void setSPE_Payer_PaymentAddress2(String sPE_Payer_PaymentAddress2) {
		SPE_Payer_PaymentAddress2 = sPE_Payer_PaymentAddress2;
	}

	public String getSPE_Payer_PaymentAddress3() {
		return SPE_Payer_PaymentAddress3;
	}

	public void setSPE_Payer_PaymentAddress3(String sPE_Payer_PaymentAddress3) {
		SPE_Payer_PaymentAddress3 = sPE_Payer_PaymentAddress3;
	}

	public String getSPE_Payee_PaymentAddress1() {
		return SPE_Payee_PaymentAddress1;
	}

	public void setSPE_Payee_PaymentAddress1(String sPE_Payee_PaymentAddress1) {
		SPE_Payee_PaymentAddress1 = sPE_Payee_PaymentAddress1;
	}

	public String getSPE_Payee_PaymentAddress2() {
		return SPE_Payee_PaymentAddress2;
	}

	public void setSPE_Payee_PaymentAddress2(String sPE_Payee_PaymentAddress2) {
		SPE_Payee_PaymentAddress2 = sPE_Payee_PaymentAddress2;
	}

	public String getSPE_Payee_PaymentAddress3() {
		return SPE_Payee_PaymentAddress3;
	}

	public void setSPE_Payee_PaymentAddress3(String sPE_Payee_PaymentAddress3) {
		SPE_Payee_PaymentAddress3 = sPE_Payee_PaymentAddress3;
	}

	public String getSPE_TxnTime() {
		return SPE_TxnTime;
	}

	public void setSPE_TxnTime(String sPE_TxnTime) {
		SPE_TxnTime = sPE_TxnTime;
	}

	public Date getSPE_TxnDate() {
		return SPE_TxnDate;
	}

	public void setSPE_TxnDate(Date sPE_TxnDate) {
		SPE_TxnDate = sPE_TxnDate;
	}

	public Float getSPE_TransactionAmount() {
		return SPE_TransactionAmount;
	}

	public void setSPE_TransactionAmount(Float sPE_TransactionAmount) {
		SPE_TransactionAmount = sPE_TransactionAmount;
	}

	public Float getSPE_ConvinienceAmount() {
		return SPE_ConvinienceAmount;
	}

	public void setSPE_ConvinienceAmount(Float sPE_ConvinienceAmount) {
		SPE_ConvinienceAmount = sPE_ConvinienceAmount;
	}

	public Float getSPE_PaymentAmount() {
		return SPE_PaymentAmount;
	}

	public void setSPE_PaymentAmount(Float sPE_PaymentAmount) {
		SPE_PaymentAmount = sPE_PaymentAmount;
	}

	public Float getSPE_ServiceCode() {
		return SPE_ServiceCode;
	}

	public void setSPE_ServiceCode(Float sPE_ServiceCode) {
		SPE_ServiceCode = sPE_ServiceCode;
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

	public String getSPE_MTransferStatus() {
		return SPE_MTransferStatus;
	}

	public void setSPE_MTransferStatus(String sPE_MTransferStatus) {
		SPE_MTransferStatus = sPE_MTransferStatus;
	}

	public String getSPE_MTransferMode() {
		return SPE_MTransferMode;
	}

	public void setSPE_MTransferMode(String sPE_MTransferMode) {
		SPE_MTransferMode = sPE_MTransferMode;
	}

	public String getSPE_MTransferredAdd() {
		return SPE_MTransferredAdd;
	}

	public void setSPE_MTransferredAdd(String sPE_MTransferredAdd) {
		SPE_MTransferredAdd = sPE_MTransferredAdd;
	}

	public String getSPE_MoneyTransferStatus() {
		return SPE_MoneyTransferStatus;
	}

	public void setSPE_MoneyTransferStatus(String sPE_MoneyTransferStatus) {
		SPE_MoneyTransferStatus = sPE_MoneyTransferStatus;
	}

	public Float getSPE_MTransferErrorCode() {
		return SPE_MTransferErrorCode;
	}

	public void setSPE_MTransferErrorCode(Float sPE_MTransferErrorCode) {
		SPE_MTransferErrorCode = sPE_MTransferErrorCode;
	}

	public String getSPE_CurrencyType() {
		return SPE_CurrencyType;
	}

	public void setSPE_CurrencyType(String sPE_CurrencyType) {
		SPE_CurrencyType = sPE_CurrencyType;
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

	public Float getSPE_Option11() {
		return SPE_Option11;
	}

	public void setSPE_Option11(Float sPE_Option11) {
		SPE_Option11 = sPE_Option11;
	}

	public Float getSPE_Option12() {
		return SPE_Option12;
	}

	public void setSPE_Option12(Float sPE_Option12) {
		SPE_Option12 = sPE_Option12;
	}

	public Float getSPE_Option13() {
		return SPE_Option13;
	}

	public void setSPE_Option13(Float sPE_Option13) {
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
	

	public String getSPE_Client() {
		return SPE_Client;
	}

	public void setSPE_Client(String sPE_Client) {
		SPE_Client = sPE_Client;
	}

	public Integer getSPE_Application() {
		return SPE_Application;
	}

	public void setSPE_Application(Integer sPE_Application) {
		SPE_Application = sPE_Application;
	}

	public String getSPE_TerminalHub() {
		return SPE_TerminalHub;
	}

	public void setSPE_TerminalHub(String sPE_TerminalHub) {
		SPE_TerminalHub = sPE_TerminalHub;
	}

	public String getSPE_PaymentType() {
		return SPE_PaymentType;
	}

	public void setSPE_PaymentType(String sPE_PaymentType) {
		SPE_PaymentType = sPE_PaymentType;
	}

	public Float getSPE_ComsnMerchant() {
		return SPE_ComsnMerchant;
	}

	public void setSPE_ComsnMerchant(Float sPE_ComsnMerchant) {
		SPE_ComsnMerchant = sPE_ComsnMerchant;
	}

	public Float getSPE_ComsnTerminalHub() {
		return SPE_ComsnTerminalHub;
	}

	public void setSPE_ComsnTerminalHub(Float sPE_ComsnTerminalHub) {
		SPE_ComsnTerminalHub = sPE_ComsnTerminalHub;
	}

	public Float getSPE_ComsnTerminID() {
		return SPE_ComsnTerminID;
	}

	public void setSPE_ComsnTerminID(Float sPE_ComsnTerminID) {
		SPE_ComsnTerminID = sPE_ComsnTerminID;
	}

	public Date getSPE_ComsnProcessDate() {
		return SPE_ComsnProcessDate;
	}

	public void setSPE_ComsnProcessDate(Date sPE_ComsnProcessDate) {
		SPE_ComsnProcessDate = sPE_ComsnProcessDate;
	}

	public Date getSPE_SRSH_SettlementDate() {
		return SPE_SRSH_SettlementDate;
	}

	public void setSPE_SRSH_SettlementDate(Date sPE_SRSH_SettlementDate) {
		SPE_SRSH_SettlementDate = sPE_SRSH_SettlementDate;
	}

	public Date getSPE_ACK_Date() {
		return SPE_ACK_Date;
	}

	public void setSPE_ACK_Date(Date sPE_ACK_Date) {
		SPE_ACK_Date = sPE_ACK_Date;
	}

	public Integer getSPE_ValidationStatus() {
		return SPE_ValidationStatus;
	}

	public void setSPE_ValidationStatus(Integer sPE_ValidationStatus) {
		SPE_ValidationStatus = sPE_ValidationStatus;
	}

	public Integer getSPE_ProcessingStatus() {
		return SPE_ProcessingStatus;
	}

	public void setSPE_ProcessingStatus(Integer sPE_ProcessingStatus) {
		SPE_ProcessingStatus = sPE_ProcessingStatus;
	}

	
	

	public Float getSPE_ComsnBank() {
		return SPE_ComsnBank;
	}

	public void setSPE_ComsnBank(Float sPE_ComsnBank) {
		SPE_ComsnBank = sPE_ComsnBank;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SPE_TRXNDetailsModel [SPE_TransactionID=" + SPE_TransactionID + ", SPE_MID=" + SPE_MID
				+ ", SPE_TerminalID=" + SPE_TerminalID + ", SPE_DeviceID=" + SPE_DeviceID + ", SPE_ErrorCode="
				+ SPE_ErrorCode + ", SPE_Response_Code=" + SPE_Response_Code + ", SPE_Provider_TransactionID="
				+ SPE_Provider_TransactionID + ", SPE_Payer_PaymentAddress1=" + SPE_Payer_PaymentAddress1
				+ ", SPE_Payer_PaymentAddress2=" + SPE_Payer_PaymentAddress2 + ", SPE_Payer_PaymentAddress3="
				+ SPE_Payer_PaymentAddress3 + ", SPE_Payee_PaymentAddress1=" + SPE_Payee_PaymentAddress1
				+ ", SPE_Payee_PaymentAddress2=" + SPE_Payee_PaymentAddress2 + ", SPE_Payee_PaymentAddress3="
				+ SPE_Payee_PaymentAddress3 + ", SPE_TxnTime=" + SPE_TxnTime + ", SPE_TxnDate=" + SPE_TxnDate
				+ ", SPE_TransactionAmount=" + SPE_TransactionAmount + ", SPE_ConvinienceAmount="
				+ SPE_ConvinienceAmount + ", SPE_PaymentAmount=" + SPE_PaymentAmount + ", SPE_ServiceCode="
				+ SPE_ServiceCode + ", SPE_SettlementStatus=" + SPE_SettlementStatus + ", SPE_SettlementDate="
				+ SPE_SettlementDate + ", SPE_SettlementAmount=" + SPE_SettlementAmount + ", SPE_MTransferStatus="
				+ SPE_MTransferStatus + ", SPE_MTransferMode=" + SPE_MTransferMode + ", SPE_MTransferredAdd="
				+ SPE_MTransferredAdd + ", SPE_MoneyTransferStatus=" + SPE_MoneyTransferStatus
				+ ", SPE_MTransferErrorCode=" + SPE_MTransferErrorCode + ", SPE_CurrencyType=" + SPE_CurrencyType
				+ ", SPE_Option1=" + SPE_Option1 + ", SPE_Option2=" + SPE_Option2 + ", SPE_Option3=" + SPE_Option3
				+ ", SPE_Option4=" + SPE_Option4 + ", SPE_Option5=" + SPE_Option5 + ", SPE_Option6=" + SPE_Option6
				+ ", SPE_Option7=" + SPE_Option7 + ", SPE_Option8=" + SPE_Option8 + ", SPE_Option9=" + SPE_Option9
				+ ", SPE_Option10=" + SPE_Option10 + ", SPE_Option11=" + SPE_Option11 + ", SPE_Option12=" + SPE_Option12
				+ ", SPE_Option13=" + SPE_Option13 + ", SPE_Option14=" + SPE_Option14 + ", SPE_Option15=" + SPE_Option15
				+ ", SPE_Client=" + SPE_Client + ", SPE_Application=" + SPE_Application + ", SPE_TerminalHub="
				+ SPE_TerminalHub + ", SPE_PaymentType=" + SPE_PaymentType + ", SPE_ComsnMerchant=" + SPE_ComsnMerchant
				+ ", SPE_ComsnTerminalHub=" + SPE_ComsnTerminalHub + ", SPE_ComsnTerminID=" + SPE_ComsnTerminID
				+ ", SPE_ComsnProcessDate=" + SPE_ComsnProcessDate + ", SPE_SRSH_SettlementDate="
				+ SPE_SRSH_SettlementDate + ", SPE_ACK_Date=" + SPE_ACK_Date + ", SPE_ValidationStatus="
				+ SPE_ValidationStatus + ", SPE_ProcessingStatus=" + SPE_ProcessingStatus + "]";
	}

	

	

	

	

}
