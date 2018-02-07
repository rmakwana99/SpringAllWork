
package com.rahul.phmc.spe.poc.model;

import java.io.Serializable;

public class SPE_MerchantForAdviceModel implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String merchantID;
	private String merchantName;
	private Float transactionAmt;
	private Float amtFromBank;
	private Float SrishtiIncome;
	private Float amtForMerchant;
	
	
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
	public Float getTransactionAmt() {
		return transactionAmt;
	}
	public void setTransactionAmt(Float transactionAmt) {
		this.transactionAmt = transactionAmt;
	}
	public Float getAmtFromBank() {
		return amtFromBank;
	}
	public void setAmtFromBank(Float amtFromBank) {
		this.amtFromBank = amtFromBank;
	}
	public Float getSrishtiIncome() {
		return SrishtiIncome;
	}
	public void setSrishtiIncome(Float srishtiIncome) {
		SrishtiIncome = srishtiIncome;
	}
	public Float getAmtForMerchant() {
		return amtForMerchant;
	}
	public void setAmtForMerchant(Float amtForMerchant) {
		this.amtForMerchant = amtForMerchant;
	}
	
	@Override
	public String toString() {
		return "SPE_MerchantForAdviceModel [merchantID=" + merchantID + ", merchantName=" + merchantName
				+ ", transactionAmt=" + transactionAmt + ", amtFromBank=" + amtFromBank + ", SrishtiIncome="
				+ SrishtiIncome + ", amtForMerchant=" + amtForMerchant + "]";
	}

}
