
package com.rahul.phmc.phob.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rahul
 * 
 *
 */
@XmlRootElement
public class PHMC_PHOB_USER{
	
	/**
	 * 
	 */
	private Long PHOB_UserSrNo;
	private Long PHOB_PCOID;
	private String PHOB_Email;
	private Long PHOB_Phone;
	private String PHOB_Password;
	private String PHOB_Salt;
	private String PHOB_PCORoles;
	private Date PHOB_UpdatedDate;
	private String PHOB_UpdatedBy;
	private String PHOB_Terms;
	private String PHOB_WelcomeMail;
	private Date PHOB_Created;
	private Integer PHOB_ResetPasswordToken;
	private String PHOB_SignUp;
	private Date PHOB_ResetPasswordExpired;
	private String PHOB_PCONotes;
	private Long PHOB_KycSrNo;
	private String PHOB_KYCEverythingValid;
	private String PHOB_FollowUpFollowUpStatus;
	private String PHOB_FollowUpFollowUpStatusList;
	private String PHOB_FollowUpGeneralSearch;
	private String PHOB_FollowUpGeneralsearchRange;
	private String PHOB_BasicDetailsIsFilled;
	private String PHOB_BasicDetailsFirstName;
	private String PHOB_BasicDetailsLastName;
    private String PHOB_BasicDetailsNatureOfBussiness;
    private String PHOB_BasicDetailsIfAnyAboutBussiness;
    private String PHOB_BasicDetailsHowYouKnow;
    private String PHOB_BasicDetailsComAddressOne;
    private String PHOB_BasicDetailsComAddressTwo;
    private String PHOB_BasicDetailsComAddressThree;
    private String PHOB_BasicDetailsComCity;
    private String PHOB_BasicDetailsComState;
    private Integer PHOB_BasicDetailsComPincode;
	private String PHOB_KycStatusIsKycVerifiedByOfficial;
    private String PHOB_KycStatusIsWalletCreated;
    private String PHOB_KycStatusIsActivation;
    private String PHOB_KycStatusIsOtpSession;
    private String PHOB_KycStatusPremilinaryReview;
    private String PHOB_KycStatusRemarks;
    private String PHOB_Future_Field1;
    private String PHOB_Future_Field2;
    private String PHOB_Future_Field3;
    private String PHOB_Future_Field4;
    private String PHOB_Future_Field5;
    private String PHOB_Future_Field6;
    private Date PHOB_OTPDate;
    private String PHOB_OTPTime;
    private String PHOB_DIST_ID;

	private PHMC_PHOB_ONBOARD onBoard;

	public Long getPHOB_UserSrNo() {
		return PHOB_UserSrNo;
	}

	public void setPHOB_UserSrNo(Long pHOB_UserSrNo) {
		PHOB_UserSrNo = pHOB_UserSrNo;
	}

	public Long getPHOB_PCOID() {
		return PHOB_PCOID;
	}

	public void setPHOB_PCOID(Long pHOB_PCOID) {
		PHOB_PCOID = pHOB_PCOID;
	}

	public String getPHOB_Email() {
		return PHOB_Email;
	}

	public void setPHOB_Email(String pHOB_Email) {
		PHOB_Email = pHOB_Email;
	}

	public Long getPHOB_Phone() {
		return PHOB_Phone;
	}

	public void setPHOB_Phone(Long pHOB_Phone) {
		PHOB_Phone = pHOB_Phone;
	}

	public String getPHOB_Password() {
		return PHOB_Password;
	}

	public void setPHOB_Password(String pHOB_Password) {
		PHOB_Password = pHOB_Password;
	}

	public String getPHOB_Salt() {
		return PHOB_Salt;
	}

	public void setPHOB_Salt(String pHOB_Salt) {
		PHOB_Salt = pHOB_Salt;
	}

	public String getPHOB_PCORoles() {
		return PHOB_PCORoles;
	}

	public void setPHOB_PCORoles(String pHOB_PCORoles) {
		PHOB_PCORoles = pHOB_PCORoles;
	}

	public Date getPHOB_UpdatedDate() {
		return PHOB_UpdatedDate;
	}

	public void setPHOB_UpdatedDate(Date pHOB_UpdatedDate) {
		PHOB_UpdatedDate = pHOB_UpdatedDate;
	}

	public String getPHOB_UpdatedBy() {
		return PHOB_UpdatedBy;
	}

	public void setPHOB_UpdatedBy(String pHOB_UpdatedBy) {
		PHOB_UpdatedBy = pHOB_UpdatedBy;
	}

	public String getPHOB_Terms() {
		return PHOB_Terms;
	}

	public void setPHOB_Terms(String pHOB_Terms) {
		PHOB_Terms = pHOB_Terms;
	}

	public String getPHOB_WelcomeMail() {
		return PHOB_WelcomeMail;
	}

	public void setPHOB_WelcomeMail(String pHOB_WelcomeMail) {
		PHOB_WelcomeMail = pHOB_WelcomeMail;
	}

	public Date getPHOB_Created() {
		return PHOB_Created;
	}

	public void setPHOB_Created(Date pHOB_Created) {
		PHOB_Created = pHOB_Created;
	}

	public Integer getPHOB_ResetPasswordToken() {
		return PHOB_ResetPasswordToken;
	}

	public void setPHOB_ResetPasswordToken(Integer pHOB_ResetPasswordToken) {
		PHOB_ResetPasswordToken = pHOB_ResetPasswordToken;
	}

	public String getPHOB_SignUp() {
		return PHOB_SignUp;
	}

	public void setPHOB_SignUp(String pHOB_SignUp) {
		PHOB_SignUp = pHOB_SignUp;
	}

	public Date getPHOB_ResetPasswordExpired() {
		return PHOB_ResetPasswordExpired;
	}

	public void setPHOB_ResetPasswordExpired(Date pHOB_ResetPasswordExpired) {
		PHOB_ResetPasswordExpired = pHOB_ResetPasswordExpired;
	}

	public String getPHOB_PCONotes() {
		return PHOB_PCONotes;
	}

	public void setPHOB_PCONotes(String pHOB_PCONotes) {
		PHOB_PCONotes = pHOB_PCONotes;
	}

	public Long getPHOB_KycSrNo() {
		return PHOB_KycSrNo;
	}

	public void setPHOB_KycSrNo(Long pHOB_KycSrNo) {
		PHOB_KycSrNo = pHOB_KycSrNo;
	}

	public String getPHOB_KYCEverythingValid() {
		return PHOB_KYCEverythingValid;
	}

	public void setPHOB_KYCEverythingValid(String pHOB_KYCEverythingValid) {
		PHOB_KYCEverythingValid = pHOB_KYCEverythingValid;
	}

	public String getPHOB_FollowUpFollowUpStatus() {
		return PHOB_FollowUpFollowUpStatus;
	}

	public void setPHOB_FollowUpFollowUpStatus(String pHOB_FollowUpFollowUpStatus) {
		PHOB_FollowUpFollowUpStatus = pHOB_FollowUpFollowUpStatus;
	}

	public String getPHOB_FollowUpFollowUpStatusList() {
		return PHOB_FollowUpFollowUpStatusList;
	}

	public void setPHOB_FollowUpFollowUpStatusList(String pHOB_FollowUpFollowUpStatusList) {
		PHOB_FollowUpFollowUpStatusList = pHOB_FollowUpFollowUpStatusList;
	}

	public String getPHOB_FollowUpGeneralSearch() {
		return PHOB_FollowUpGeneralSearch;
	}

	public void setPHOB_FollowUpGeneralSearch(String pHOB_FollowUpGeneralSearch) {
		PHOB_FollowUpGeneralSearch = pHOB_FollowUpGeneralSearch;
	}

	public String getPHOB_FollowUpGeneralsearchRange() {
		return PHOB_FollowUpGeneralsearchRange;
	}

	public void setPHOB_FollowUpGeneralsearchRange(String pHOB_FollowUpGeneralsearchRange) {
		PHOB_FollowUpGeneralsearchRange = pHOB_FollowUpGeneralsearchRange;
	}

	public String getPHOB_BasicDetailsIsFilled() {
		return PHOB_BasicDetailsIsFilled;
	}

	public void setPHOB_BasicDetailsIsFilled(String pHOB_BasicDetailsIsFilled) {
		PHOB_BasicDetailsIsFilled = pHOB_BasicDetailsIsFilled;
	}

	public String getPHOB_BasicDetailsFirstName() {
		return PHOB_BasicDetailsFirstName;
	}

	public void setPHOB_BasicDetailsFirstName(String pHOB_BasicDetailsFirstName) {
		PHOB_BasicDetailsFirstName = pHOB_BasicDetailsFirstName;
	}

	public String getPHOB_BasicDetailsLastName() {
		return PHOB_BasicDetailsLastName;
	}

	public void setPHOB_BasicDetailsLastName(String pHOB_BasicDetailsLastName) {
		PHOB_BasicDetailsLastName = pHOB_BasicDetailsLastName;
	}

	public String getPHOB_BasicDetailsNatureOfBussiness() {
		return PHOB_BasicDetailsNatureOfBussiness;
	}

	public void setPHOB_BasicDetailsNatureOfBussiness(String pHOB_BasicDetailsNatureOfBussiness) {
		PHOB_BasicDetailsNatureOfBussiness = pHOB_BasicDetailsNatureOfBussiness;
	}

	public String getPHOB_BasicDetailsIfAnyAboutBussiness() {
		return PHOB_BasicDetailsIfAnyAboutBussiness;
	}

	public void setPHOB_BasicDetailsIfAnyAboutBussiness(String pHOB_BasicDetailsIfAnyAboutBussiness) {
		PHOB_BasicDetailsIfAnyAboutBussiness = pHOB_BasicDetailsIfAnyAboutBussiness;
	}

	public String getPHOB_BasicDetailsHowYouKnow() {
		return PHOB_BasicDetailsHowYouKnow;
	}

	public void setPHOB_BasicDetailsHowYouKnow(String pHOB_BasicDetailsHowYouKnow) {
		PHOB_BasicDetailsHowYouKnow = pHOB_BasicDetailsHowYouKnow;
	}

	public String getPHOB_BasicDetailsComAddressOne() {
		return PHOB_BasicDetailsComAddressOne;
	}

	public void setPHOB_BasicDetailsComAddressOne(String pHOB_BasicDetailsComAddressOne) {
		PHOB_BasicDetailsComAddressOne = pHOB_BasicDetailsComAddressOne;
	}

	public String getPHOB_BasicDetailsComAddressTwo() {
		return PHOB_BasicDetailsComAddressTwo;
	}

	public void setPHOB_BasicDetailsComAddressTwo(String pHOB_BasicDetailsComAddressTwo) {
		PHOB_BasicDetailsComAddressTwo = pHOB_BasicDetailsComAddressTwo;
	}

	public String getPHOB_BasicDetailsComAddressThree() {
		return PHOB_BasicDetailsComAddressThree;
	}

	public void setPHOB_BasicDetailsComAddressThree(String pHOB_BasicDetailsComAddressThree) {
		PHOB_BasicDetailsComAddressThree = pHOB_BasicDetailsComAddressThree;
	}

	public String getPHOB_BasicDetailsComCity() {
		return PHOB_BasicDetailsComCity;
	}

	public void setPHOB_BasicDetailsComCity(String pHOB_BasicDetailsComCity) {
		PHOB_BasicDetailsComCity = pHOB_BasicDetailsComCity;
	}

	public String getPHOB_BasicDetailsComState() {
		return PHOB_BasicDetailsComState;
	}

	public void setPHOB_BasicDetailsComState(String pHOB_BasicDetailsComState) {
		PHOB_BasicDetailsComState = pHOB_BasicDetailsComState;
	}

	public Integer getPHOB_BasicDetailsComPincode() {
		return PHOB_BasicDetailsComPincode;
	}

	public void setPHOB_BasicDetailsComPincode(Integer pHOB_BasicDetailsComPincode) {
		PHOB_BasicDetailsComPincode = pHOB_BasicDetailsComPincode;
	}

	public String getPHOB_KycStatusIsKycVerifiedByOfficial() {
		return PHOB_KycStatusIsKycVerifiedByOfficial;
	}

	public void setPHOB_KycStatusIsKycVerifiedByOfficial(String pHOB_KycStatusIsKycVerifiedByOfficial) {
		PHOB_KycStatusIsKycVerifiedByOfficial = pHOB_KycStatusIsKycVerifiedByOfficial;
	}

	public String getPHOB_KycStatusIsWalletCreated() {
		return PHOB_KycStatusIsWalletCreated;
	}

	public void setPHOB_KycStatusIsWalletCreated(String pHOB_KycStatusIsWalletCreated) {
		PHOB_KycStatusIsWalletCreated = pHOB_KycStatusIsWalletCreated;
	}

	public String getPHOB_KycStatusIsActivation() {
		return PHOB_KycStatusIsActivation;
	}

	public void setPHOB_KycStatusIsActivation(String pHOB_KycStatusIsActivation) {
		PHOB_KycStatusIsActivation = pHOB_KycStatusIsActivation;
	}

	public String getPHOB_KycStatusIsOtpSession() {
		return PHOB_KycStatusIsOtpSession;
	}

	public void setPHOB_KycStatusIsOtpSession(String pHOB_KycStatusIsOtpSession) {
		PHOB_KycStatusIsOtpSession = pHOB_KycStatusIsOtpSession;
	}

	public String getPHOB_KycStatusPremilinaryReview() {
		return PHOB_KycStatusPremilinaryReview;
	}

	public void setPHOB_KycStatusPremilinaryReview(String pHOB_KycStatusPremilinaryReview) {
		PHOB_KycStatusPremilinaryReview = pHOB_KycStatusPremilinaryReview;
	}

	public String getPHOB_KycStatusRemarks() {
		return PHOB_KycStatusRemarks;
	}

	public void setPHOB_KycStatusRemarks(String pHOB_KycStatusRemarks) {
		PHOB_KycStatusRemarks = pHOB_KycStatusRemarks;
	}

	public String getPHOB_Future_Field1() {
		return PHOB_Future_Field1;
	}

	public void setPHOB_Future_Field1(String pHOB_Future_Field1) {
		PHOB_Future_Field1 = pHOB_Future_Field1;
	}

	public String getPHOB_Future_Field2() {
		return PHOB_Future_Field2;
	}

	public void setPHOB_Future_Field2(String pHOB_Future_Field2) {
		PHOB_Future_Field2 = pHOB_Future_Field2;
	}

	public String getPHOB_Future_Field3() {
		return PHOB_Future_Field3;
	}

	public void setPHOB_Future_Field3(String pHOB_Future_Field3) {
		PHOB_Future_Field3 = pHOB_Future_Field3;
	}

	public String getPHOB_Future_Field4() {
		return PHOB_Future_Field4;
	}

	public void setPHOB_Future_Field4(String pHOB_Future_Field4) {
		PHOB_Future_Field4 = pHOB_Future_Field4;
	}

	public String getPHOB_Future_Field5() {
		return PHOB_Future_Field5;
	}

	public void setPHOB_Future_Field5(String pHOB_Future_Field5) {
		PHOB_Future_Field5 = pHOB_Future_Field5;
	}

	public String getPHOB_Future_Field6() {
		return PHOB_Future_Field6;
	}

	public void setPHOB_Future_Field6(String pHOB_Future_Field6) {
		PHOB_Future_Field6 = pHOB_Future_Field6;
	}

	public Date getPHOB_OTPDate() {
		return PHOB_OTPDate;
	}

	public void setPHOB_OTPDate(Date pHOB_OTPDate) {
		PHOB_OTPDate = pHOB_OTPDate;
	}

	public String getPHOB_OTPTime() {
		return PHOB_OTPTime;
	}

	public void setPHOB_OTPTime(String pHOB_OTPTime) {
		PHOB_OTPTime = pHOB_OTPTime;
	}

	public PHMC_PHOB_ONBOARD getOnBoard() {
		return onBoard;
	}

	public void setOnBoard(PHMC_PHOB_ONBOARD onBoard) {
		this.onBoard = onBoard;
	}

	public String getPHOB_DIST_ID() {
		return PHOB_DIST_ID;
	}

	public void setPHOB_DIST_ID(String pHOB_DIST_ID) {
		PHOB_DIST_ID = pHOB_DIST_ID;
	}

	@Override
	public String toString() {
		return "PHMC_PHOB_USER [PHOB_UserSrNo=" + PHOB_UserSrNo + ", PHOB_PCOID=" + PHOB_PCOID + ", PHOB_Email="
				+ PHOB_Email + ", PHOB_Phone=" + PHOB_Phone + ", PHOB_Password=" + PHOB_Password + ", PHOB_Salt="
				+ PHOB_Salt + ", PHOB_PCORoles=" + PHOB_PCORoles + ", PHOB_UpdatedDate=" + PHOB_UpdatedDate
				+ ", PHOB_UpdatedBy=" + PHOB_UpdatedBy + ", PHOB_Terms=" + PHOB_Terms + ", PHOB_WelcomeMail="
				+ PHOB_WelcomeMail + ", PHOB_Created=" + PHOB_Created + ", PHOB_ResetPasswordToken="
				+ PHOB_ResetPasswordToken + ", PHOB_SignUp=" + PHOB_SignUp + ", PHOB_ResetPasswordExpired="
				+ PHOB_ResetPasswordExpired + ", PHOB_PCONotes=" + PHOB_PCONotes + ", PHOB_KycSrNo=" + PHOB_KycSrNo
				+ ", PHOB_KYCEverythingValid=" + PHOB_KYCEverythingValid + ", PHOB_FollowUpFollowUpStatus="
				+ PHOB_FollowUpFollowUpStatus + ", PHOB_FollowUpFollowUpStatusList=" + PHOB_FollowUpFollowUpStatusList
				+ ", PHOB_FollowUpGeneralSearch=" + PHOB_FollowUpGeneralSearch + ", PHOB_FollowUpGeneralsearchRange="
				+ PHOB_FollowUpGeneralsearchRange + ", PHOB_BasicDetailsIsFilled=" + PHOB_BasicDetailsIsFilled
				+ ", PHOB_BasicDetailsFirstName=" + PHOB_BasicDetailsFirstName + ", PHOB_BasicDetailsLastName="
				+ PHOB_BasicDetailsLastName + ", PHOB_BasicDetailsNatureOfBussiness="
				+ PHOB_BasicDetailsNatureOfBussiness + ", PHOB_BasicDetailsIfAnyAboutBussiness="
				+ PHOB_BasicDetailsIfAnyAboutBussiness + ", PHOB_BasicDetailsHowYouKnow=" + PHOB_BasicDetailsHowYouKnow
				+ ", PHOB_BasicDetailsComAddressOne=" + PHOB_BasicDetailsComAddressOne
				+ ", PHOB_BasicDetailsComAddressTwo=" + PHOB_BasicDetailsComAddressTwo
				+ ", PHOB_BasicDetailsComAddressThree=" + PHOB_BasicDetailsComAddressThree
				+ ", PHOB_BasicDetailsComCity=" + PHOB_BasicDetailsComCity + ", PHOB_BasicDetailsComState="
				+ PHOB_BasicDetailsComState + ", PHOB_BasicDetailsComPincode=" + PHOB_BasicDetailsComPincode
				+ ", PHOB_KycStatusIsKycVerifiedByOfficial=" + PHOB_KycStatusIsKycVerifiedByOfficial
				+ ", PHOB_KycStatusIsWalletCreated=" + PHOB_KycStatusIsWalletCreated + ", PHOB_KycStatusIsActivation="
				+ PHOB_KycStatusIsActivation + ", PHOB_KycStatusIsOtpSession=" + PHOB_KycStatusIsOtpSession
				+ ", PHOB_KycStatusPremilinaryReview=" + PHOB_KycStatusPremilinaryReview + ", PHOB_KycStatusRemarks="
				+ PHOB_KycStatusRemarks + ", PHOB_Future_Field1=" + PHOB_Future_Field1 + ", PHOB_Future_Field2="
				+ PHOB_Future_Field2 + ", PHOB_Future_Field3=" + PHOB_Future_Field3 + ", PHOB_Future_Field4="
				+ PHOB_Future_Field4 + ", PHOB_Future_Field5=" + PHOB_Future_Field5 + ", PHOB_Future_Field6="
				+ PHOB_Future_Field6 + ", PHOB_OTPDate=" + PHOB_OTPDate + ", PHOB_OTPTime=" + PHOB_OTPTime
				+ ", PHOB_DIST_ID=" + PHOB_DIST_ID + ", onBoard=" + onBoard + "]";
	}

    
    
    
	

}
