
package com.rahul.phmc.spe.router.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author rahul
 * 
 *         It contains all SPE_TRXN_DETAILS_SRSH database fields and its
 *         setters and getters methods. it is Model of SPE_TRXN_DETAILS_SRSH table
 */
@Entity
@Table(name = "SPE_TRXN_DETAILS_SPAY")
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
@AttributeOverrides({ @AttributeOverride(name = "SPE_MID", column = @Column(name = "SPE_MID")),
		@AttributeOverride(name = "SPE_TerminalID", column = @Column(name = "SPE_TerminalID")),
		@AttributeOverride(name = "SPE_DeviceID", column = @Column(name = "SPE_DeviceID")),
		@AttributeOverride(name = "SPE_TransactionID", column = @Column(name = "SPE_TransactionID")),
		@AttributeOverride(name = "SPE_ErrorCode", column = @Column(name = "SPE_ErrorCode")),
		@AttributeOverride(name = "SPE_Response_Code", column = @Column(name = "SPE_Response_Code")),
		@AttributeOverride(name = "SPE_Provider_TransactionID", column = @Column(name = "SPE_Provider_TransactionID")),
		@AttributeOverride(name = "SPE_Payer_PaymentAddress1", column = @Column(name = "SPE_Payer_PaymentAddress1")),
		@AttributeOverride(name = "SPE_Payer_PaymentAddress2", column = @Column(name = "SPE_Payer_PaymentAddress2")),
		@AttributeOverride(name = "SPE_Payer_PaymentAddress3", column = @Column(name = "SPE_Payer_PaymentAddress3")),
		@AttributeOverride(name = "SPE_Payee_PaymentAddress1", column = @Column(name = "SPE_Payee_PaymentAddress1")),
		@AttributeOverride(name = "SPE_Payee_PaymentAddress2", column = @Column(name = "SPE_Payee_PaymentAddress2")),
		@AttributeOverride(name = "SPE_Payee_PaymentAddress3", column = @Column(name = "SPE_Payee_PaymentAddress3")),
		@AttributeOverride(name = "SPE_TxnTime", column = @Column(name = "SPE_TxnTime")),
		@AttributeOverride(name = "SPE_TxnDate", column = @Column(name = "SPE_TxnDate")),
		@AttributeOverride(name = "SPE_TransactionAmount", column = @Column(name = "SPE_TransactionAmount")),
		@AttributeOverride(name = "SPE_ConvinienceAmount", column = @Column(name = "SPE_ConvinienceAmount")),
		@AttributeOverride(name = "SPE_PaymentAmount", column = @Column(name = "SPE_PaymentAmount")),
		@AttributeOverride(name = "SPE_ServiceCode", column = @Column(name = "SPE_ServiceCode")),
		@AttributeOverride(name = "SPE_SettlementStatus", column = @Column(name = "SPE_SettlementStatus")),
		@AttributeOverride(name = "SPE_SettlementDate", column = @Column(name = "SPE_SettlementDate")),
		@AttributeOverride(name = "SPE_SettlementAmount", column = @Column(name = "SPE_SettlementAmount")),
		@AttributeOverride(name = "SPE_MTransferStatus", column = @Column(name = "SPE_MTransferStatus")),
		@AttributeOverride(name = "SPE_MTransferMode", column = @Column(name = "SPE_MTransferMode")),
		@AttributeOverride(name = "SPE_MTransferredAdd", column = @Column(name = "SPE_MTransferredAdd")),
		@AttributeOverride(name = "SPE_MoneyTransferStatus", column = @Column(name = "SPE_MoneyTransferStatus")),
		@AttributeOverride(name = "SPE_MTransferErrorCode", column = @Column(name = "SPE_MTransferErrorCode")),
		@AttributeOverride(name = "SPE_CurrencyType", column = @Column(name = "SPE_CurrencyType")),
		@AttributeOverride(name = "SPE_Option1", column = @Column(name = "SPE_Option1")),
		@AttributeOverride(name = "SPE_Option2", column = @Column(name = "SPE_Option2")),
		@AttributeOverride(name = "SPE_Option3", column = @Column(name = "SPE_Option3")),
		@AttributeOverride(name = "SPE_Option4", column = @Column(name = "SPE_Option4")),
		@AttributeOverride(name = "SPE_Option5", column = @Column(name = "SPE_Option5")),
		@AttributeOverride(name = "SPE_Option6", column = @Column(name = "SPE_Option6")),
		@AttributeOverride(name = "SPE_Option7", column = @Column(name = "SPE_Option7")),
		@AttributeOverride(name = "SPE_Option8", column = @Column(name = "SPE_Option8")),
		@AttributeOverride(name = "SPE_Option9", column = @Column(name = "SPE_Option9")),
		@AttributeOverride(name = "SPE_Option10", column = @Column(name = "SPE_Option10")),
		@AttributeOverride(name = "SPE_Option11", column = @Column(name = "SPE_Option11")),
		@AttributeOverride(name = "SPE_Option12", column = @Column(name = "SPE_Option12")),
		@AttributeOverride(name = "SPE_Option13", column = @Column(name = "SPE_Option13")),
		@AttributeOverride(name = "SPE_Option14", column = @Column(name = "SPE_Option14")),
		@AttributeOverride(name = "SPE_Option15", column = @Column(name = "SPE_Option15")),
		@AttributeOverride(name = "SPE_Client", column = @Column(name = "SPE_Client")),
		@AttributeOverride(name = "SPE_Application", column = @Column(name = "SPE_Application")),
		@AttributeOverride(name = "SPE_TerminalHub", column = @Column(name = "SPE_TerminalHub")),
		@AttributeOverride(name = "SPE_PaymentType", column = @Column(name = "SPE_PaymentType")),
		@AttributeOverride(name = "SPE_ComsnMerchant", column = @Column(name = "SPE_ComsnMerchant")),
		@AttributeOverride(name = "SPE_ComsnTerminalHub", column = @Column(name = "SPE_ComsnTerminalHub")),
		@AttributeOverride(name = "SPE_ComsnTerminID", column = @Column(name = "SPE_ComsnTerminID")),
		@AttributeOverride(name = "SPE_SRSH_SettlementDate", column = @Column(name = "SPE_SRSH_SettlementDate")),
		@AttributeOverride(name = "SPE_ACK_Date", column = @Column(name = "SPE_ACK_Date")),
		@AttributeOverride(name = "SPE_ValidationStatus", column = @Column(name = "SPE_ValidationStatus")),
		@AttributeOverride(name = "SPE_ProcessingStatus", column = @Column(name = "SPE_ProcessingStatus")),
		@AttributeOverride(name = "SPE_ComsnBank", column = @Column(name = "SPE_ComsnBank"))
})
public class SPE_TRXNDetailsSPAYModel extends SPE_TRXNDetailsModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", updatable=false)
	private String SPE_AutoSrNo;

	
	public String getSPE_AutoSrNo() {
		return SPE_AutoSrNo;
	}

	public void setSPE_AutoSrNo(String sPE_AutoSrNo) {
		SPE_AutoSrNo = sPE_AutoSrNo;
	}

	public SPE_TRXNDetailsSPAYModel() {
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SPE_TRXNDetailsSRSHModel [SPE_AutoSrNo=" + SPE_AutoSrNo + ", getSPE_MID()=" + getSPE_MID()
				+ ", getSPE_TerminalID()=" + getSPE_TerminalID() + ", getSPE_DeviceID()=" + getSPE_DeviceID()
				+ ", getSPE_TransactionID()=" + getSPE_TransactionID() + ", getSPE_ErrorCode()=" + getSPE_ErrorCode()
				+ ", getSPE_Response_Code()=" + getSPE_Response_Code() + ", getSPE_Provider_TransactionID()="
				+ getSPE_Provider_TransactionID() + ", getSPE_Payer_PaymentAddress1()=" + getSPE_Payer_PaymentAddress1()
				+ ", getSPE_Payer_PaymentAddress2()=" + getSPE_Payer_PaymentAddress2()
				+ ", getSPE_Payer_PaymentAddress3()=" + getSPE_Payer_PaymentAddress3()
				+ ", getSPE_Payee_PaymentAddress1()=" + getSPE_Payee_PaymentAddress1()
				+ ", getSPE_Payee_PaymentAddress2()=" + getSPE_Payee_PaymentAddress2()
				+ ", getSPE_Payee_PaymentAddress3()=" + getSPE_Payee_PaymentAddress3() + ", getSPE_TxnTime()="
				+ getSPE_TxnTime() + ", getSPE_TxnDate()=" + getSPE_TxnDate() + ", getSPE_TransactionAmount()="
				+ getSPE_TransactionAmount() + ", getSPE_ConvinienceAmount()=" + getSPE_ConvinienceAmount()
				+ ", getSPE_PaymentAmount()=" + getSPE_PaymentAmount() + ", getSPE_ServiceCode()="
				+ getSPE_ServiceCode() + ", getSPE_SettlementStatus()=" + getSPE_SettlementStatus()
				+ ", getSPE_SettlementDate()=" + getSPE_SettlementDate() + ", getSPE_SettlementAmount()="
				+ getSPE_SettlementAmount() + ", getSPE_MTransferStatus()=" + getSPE_MTransferStatus()
				+ ", getSPE_MTransferMode()=" + getSPE_MTransferMode() + ", getSPE_MTransferredAdd()="
				+ getSPE_MTransferredAdd() + ", getSPE_MoneyTransferStatus()=" + getSPE_MoneyTransferStatus()
				+ ", getSPE_MTransferErrorCode()=" + getSPE_MTransferErrorCode() + ", getSPE_CurrencyType()="
				+ getSPE_CurrencyType() + ", getSPE_Option1()=" + getSPE_Option1() + ", getSPE_Option2()="
				+ getSPE_Option2() + ", getSPE_Option3()=" + getSPE_Option3() + ", getSPE_Option4()=" + getSPE_Option4()
				+ ", getSPE_Option5()=" + getSPE_Option5() + ", getSPE_Option6()=" + getSPE_Option6()
				+ ", getSPE_Option7()=" + getSPE_Option7() + ", getSPE_Option8()=" + getSPE_Option8()
				+ ", getSPE_Option9()=" + getSPE_Option9() + ", getSPE_Option10()=" + getSPE_Option10()
				+ ", getSPE_Option11()=" + getSPE_Option11() + ", getSPE_Option12()=" + getSPE_Option12()
				+ ", getSPE_Option13()=" + getSPE_Option13() + ", getSPE_Option14()=" + getSPE_Option14()
				+ ", getSPE_Option15()=" + getSPE_Option15() + ", getSPE_Client()=" + getSPE_Client()
				+ ", getSPE_Application()=" + getSPE_Application() + ", getSPE_TerminalHub()=" + getSPE_TerminalHub()
				+ ", getSPE_PaymentType()=" + getSPE_PaymentType() + ", getSPE_ComsnMerchant()="
				+ getSPE_ComsnMerchant() + ", getSPE_ComsnTerminalHub()=" + getSPE_ComsnTerminalHub()
				+ ", getSPE_ComsnTerminID()=" + getSPE_ComsnTerminID() + ", getSPE_ComsnProcessDate()="
				+ getSPE_ComsnProcessDate() + ", getSPE_SRSH_SettlementDate()=" + getSPE_SRSH_SettlementDate()
				+ ", getSPE_ACK_Date()=" + getSPE_ACK_Date() + ", getSPE_ValidationStatus()="
				+ getSPE_ValidationStatus() + ", getSPE_ProcessingStatus()=" + getSPE_ProcessingStatus() + "]";
	}
}
