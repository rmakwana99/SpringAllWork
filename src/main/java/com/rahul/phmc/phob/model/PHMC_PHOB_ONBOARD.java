
package com.rahul.phmc.phob.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;



/**
 * @author Rahul makvana This class declares all PHOB_KycForm Attribute to
 *         represent the column of that table and this table is in PHMC-MASTER
 *         Database.
 */
@XmlRootElement
@Entity
@Table(name  = "PHMC_PHOB_ONBOARD")
public class PHMC_PHOB_ONBOARD  implements Serializable{

	@Id
	private Long PHOB_KycSrNo;
	private String PHOB_PersonalDetailsFullName;
	private String PHOB_PersonalDetailsPictureURL;
	private String PHOB_PersonalDetailsPicture;
	private Date PHOB_PersonalDetailsDob;
	private String PHOB_PersonalDetailsMotherName;
	private String PHOB_PersonalDetailsGender;
	private String PHOB_BusinessDetailsBusinessName;
	private String PHOB_BusinessDetailsNatureofBusiness;
	private String PHOB_BusinessDetailsIfany;
	private String PHOB_CommunicationDetailsPersonalAddressAddressline1;
	private String PHOB_CommunicationDetailsPersonalAddressAddressline2;
	private String PHOB_CommunicationDetailsPersonalAddressAddressline3;
	private String PHOB_CommunicationDetailsPersonalAddressPersonalcity;
	private String PHOB_CommunicationDetailsPersonalAddressPersonalState;
	private String PHOB_CommunicationDetailsPersonalAddressPersonalpin;
	private String PHOB_CommunicationDetailsBusinessAddressAddressline1;
	private String PHOB_CommunicationDetailsBusinessAddressAddressline2;
	private String PHOB_CommunicationDetailsBusinessAddressAddressline3;
	private String PHOB_CommunicationDetailsBusinessAddressBusinesscity;
	private String PHOB_CommunicationDetailsBusinessAddressBusinessstate;
	private String PHOB_CommunicationDetailsBusinessAddressBusinesspin;
	private String PHOB_BankDetailsBankName;
	private Long PHOB_BankDetailsBankAccountNumber;
	private String PHOB_BankDetailsBankBranch;
	private String PHOB_BankDetailsAccountType;
	private String PHOB_BankDetailsIfscCode;
	private String PHOB_DocumentDetailsPanFileURL;
	private String PHOB_DocumentDetailsPanFile;
	private String PHOB_DocumentDetailsResidenceFileURLFrontSide;
	private String PHOB_DocumentDetailsResidenceFileFrontSide;
	private String PHOB_DocumentDetailsResidenceFileURLBackSide;
	private String PHOB_DocumentDetailsResidenceFileBackSide;
	private String PHOB_DocumentDetailsBusinessFileURL;
	private String PHOB_DocumentDetailsBusinessFile;
	private String PHOB_DocumentDetailsPCOSignatureURL;
	private String PHOB_DocumentDetailsPCOSignature;
	private String PHOB_DocumentDetailsIfany;
	private String PHOB_DocumentDetailsAgreement;
	private Date PHOB_Created;
	private Long PHOB_User;
	private Date PHOB_KYCUPdateDate;
	private String PHOB_KYCUpdatedBy;
	

	

	
	public PHMC_PHOB_ONBOARD() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the pHOB_KycSrNo
	 */
	public Long getPHOB_KycSrNo() {
		return PHOB_KycSrNo;
	}

	/**
	 * @param pHOB_KycSrNo the pHOB_KycSrNo to set
	 */
	public void setPHOB_KycSrNo(Long pHOB_KycSrNo) {
		PHOB_KycSrNo = pHOB_KycSrNo;
	}

	/**
	 * @return the pHOB_PersonalDetailsFullName
	 */
	public String getPHOB_PersonalDetailsFullName() {
		return PHOB_PersonalDetailsFullName;
	}

	/**
	 * @param pHOB_PersonalDetailsFullName
	 *            the pHOB_PersonalDetailsFullName to set
	 */
	public void setPHOB_PersonalDetailsFullName(String pHOB_PersonalDetailsFullName) {
		PHOB_PersonalDetailsFullName = pHOB_PersonalDetailsFullName;
	}

	/**
	 * @return the pHOB_PersonalDetailsPictureURL
	 */
	public String getPHOB_PersonalDetailsPictureURL() {
		return PHOB_PersonalDetailsPictureURL;
	}

	/**
	 * @param pHOB_PersonalDetailsPictureURL
	 *            the pHOB_PersonalDetailsPictureURL to set
	 */
	public void setPHOB_PersonalDetailsPictureURL(String pHOB_PersonalDetailsPictureURL) {
		PHOB_PersonalDetailsPictureURL = pHOB_PersonalDetailsPictureURL;
	}

	/**
	 * @return the pHOB_PersonalDetailsDob
	 */
	public Date getPHOB_PersonalDetailsDob() {
		return PHOB_PersonalDetailsDob;
	}

	/**
	 * @param pHOB_PersonalDetailsDob
	 *            the pHOB_PersonalDetailsDob to set
	 */
	public void setPHOB_PersonalDetailsDob(Date pHOB_PersonalDetailsDob) {
		PHOB_PersonalDetailsDob = pHOB_PersonalDetailsDob;
	}

	/**
	 * @return the pHOB_PersonalDetailsMotherName
	 */
	public String getPHOB_PersonalDetailsMotherName() {
		return PHOB_PersonalDetailsMotherName;
	}

	/**
	 * @param pHOB_PersonalDetailsMotherName
	 *            the pHOB_PersonalDetailsMotherName to set
	 */
	public void setPHOB_PersonalDetailsMotherName(String pHOB_PersonalDetailsMotherName) {
		PHOB_PersonalDetailsMotherName = pHOB_PersonalDetailsMotherName;
	}

	/**
	 * @return the pHOB_PersonalDetailsGender
	 */
	public String getPHOB_PersonalDetailsGender() {
		return PHOB_PersonalDetailsGender;
	}

	/**
	 * @param pHOB_PersonalDetailsGender
	 *            the pHOB_PersonalDetailsGender to set
	 */
	public void setPHOB_PersonalDetailsGender(String pHOB_PersonalDetailsGender) {
		PHOB_PersonalDetailsGender = pHOB_PersonalDetailsGender;
	}

	/**
	 * @return the pHOB_BusinessDetailsBusinessName
	 */
	public String getPHOB_BusinessDetailsBusinessName() {
		return PHOB_BusinessDetailsBusinessName;
	}

	/**
	 * @param pHOB_BusinessDetailsBusinessName
	 *            the pHOB_BusinessDetailsBusinessName to set
	 */
	public void setPHOB_BusinessDetailsBusinessName(String pHOB_BusinessDetailsBusinessName) {
		PHOB_BusinessDetailsBusinessName = pHOB_BusinessDetailsBusinessName;
	}

	/**
	 * @return the pHOB_BusinessDetailsNatureofBusiness
	 */
	public String getPHOB_BusinessDetailsNatureofBusiness() {
		return PHOB_BusinessDetailsNatureofBusiness;
	}

	/**
	 * @param pHOB_BusinessDetailsNatureofBusiness
	 *            the pHOB_BusinessDetailsNatureofBusiness to set
	 */
	public void setPHOB_BusinessDetailsNatureofBusiness(String pHOB_BusinessDetailsNatureofBusiness) {
		PHOB_BusinessDetailsNatureofBusiness = pHOB_BusinessDetailsNatureofBusiness;
	}

	/**
	 * @return the pHOB_BusinessDetailsIfany
	 */
	public String getPHOB_BusinessDetailsIfany() {
		return PHOB_BusinessDetailsIfany;
	}

	/**
	 * @param pHOB_BusinessDetailsIfany
	 *            the pHOB_BusinessDetailsIfany to set
	 */
	public void setPHOB_BusinessDetailsIfany(String pHOB_BusinessDetailsIfany) {
		PHOB_BusinessDetailsIfany = pHOB_BusinessDetailsIfany;
	}

	/**
	 * @return the pHOB_CommunicationDetailsPersonalAddressAddressline1
	 */
	public String getPHOB_CommunicationDetailsPersonalAddressAddressline1() {
		return PHOB_CommunicationDetailsPersonalAddressAddressline1;
	}

	/**
	 * @param pHOB_CommunicationDetailsPersonalAddressAddressline1
	 *            the pHOB_CommunicationDetailsPersonalAddressAddressline1 to
	 *            set
	 */
	public void setPHOB_CommunicationDetailsPersonalAddressAddressline1(
			String pHOB_CommunicationDetailsPersonalAddressAddressline1) {
		PHOB_CommunicationDetailsPersonalAddressAddressline1 = pHOB_CommunicationDetailsPersonalAddressAddressline1;
	}

	/**
	 * @return the pHOB_CommunicationDetailsPersonalAddressAddressline2
	 */
	public String getPHOB_CommunicationDetailsPersonalAddressAddressline2() {
		return PHOB_CommunicationDetailsPersonalAddressAddressline2;
	}

	/**
	 * @param pHOB_CommunicationDetailsPersonalAddressAddressline2
	 *            the pHOB_CommunicationDetailsPersonalAddressAddressline2 to
	 *            set
	 */
	public void setPHOB_CommunicationDetailsPersonalAddressAddressline2(
			String pHOB_CommunicationDetailsPersonalAddressAddressline2) {
		PHOB_CommunicationDetailsPersonalAddressAddressline2 = pHOB_CommunicationDetailsPersonalAddressAddressline2;
	}

	/**
	 * @return the pHOB_CommunicationDetailsPersonalAddressAddressline3
	 */
	public String getPHOB_CommunicationDetailsPersonalAddressAddressline3() {
		return PHOB_CommunicationDetailsPersonalAddressAddressline3;
	}

	/**
	 * @param pHOB_CommunicationDetailsPersonalAddressAddressline3
	 *            the pHOB_CommunicationDetailsPersonalAddressAddressline3 to
	 *            set
	 */
	public void setPHOB_CommunicationDetailsPersonalAddressAddressline3(
			String pHOB_CommunicationDetailsPersonalAddressAddressline3) {
		PHOB_CommunicationDetailsPersonalAddressAddressline3 = pHOB_CommunicationDetailsPersonalAddressAddressline3;
	}

	/**
	 * @return the pHOB_CommunicationDetailsPersonalAddressPersonalcity
	 */
	public String getPHOB_CommunicationDetailsPersonalAddressPersonalcity() {
		return PHOB_CommunicationDetailsPersonalAddressPersonalcity;
	}

	/**
	 * @param pHOB_CommunicationDetailsPersonalAddressPersonalcity
	 *            the pHOB_CommunicationDetailsPersonalAddressPersonalcity to
	 *            set
	 */
	public void setPHOB_CommunicationDetailsPersonalAddressPersonalcity(
			String pHOB_CommunicationDetailsPersonalAddressPersonalcity) {
		PHOB_CommunicationDetailsPersonalAddressPersonalcity = pHOB_CommunicationDetailsPersonalAddressPersonalcity;
	}

	/**
	 * @return the pHOB_CommunicationDetailsPersonalAddrePersonalState
	 */
	public String getPHOB_CommunicationDetailsPersonalAddressPersonalState() {
		return PHOB_CommunicationDetailsPersonalAddressPersonalState;
	}

	/**
	 * @param pHOB_CommunicationDetailsPersonalAddrePersonalState
	 *            the pHOB_CommunicationDetailsPersonalAddrePersonalState to set
	 */
	public void setPHOB_CommunicationDetailsPersonalAddressPersonalState(
			String pHOB_CommunicationDetailsPersonalAddressPersonalState) {
		PHOB_CommunicationDetailsPersonalAddressPersonalState = pHOB_CommunicationDetailsPersonalAddressPersonalState;
	}

	/**
	 * @return the pHOB_CommunicationDetailsPersonalAddresspersonalpin
	 */
	public String getPHOB_CommunicationDetailsPersonalAddressPersonalpin() {
		return PHOB_CommunicationDetailsPersonalAddressPersonalpin;
	}

	/**
	 * @param pHOB_CommunicationDetailsPersonalAddresspersonalpin
	 *            the pHOB_CommunicationDetailsPersonalAddresspersonalpin to set
	 */
	public void setPHOB_CommunicationDetailsPersonalAddressPersonalpin(
			String pHOB_CommunicationDetailsPersonalAddressPersonalpin) {
		PHOB_CommunicationDetailsPersonalAddressPersonalpin = pHOB_CommunicationDetailsPersonalAddressPersonalpin;
	}

	/**
	 * @return the pHOB_CommunicationDetailsBusinessAddressAddressline1
	 */
	public String getPHOB_CommunicationDetailsBusinessAddressAddressline1() {
		return PHOB_CommunicationDetailsBusinessAddressAddressline1;
	}

	/**
	 * @param pHOB_CommunicationDetailsBusinessAddressAddressline1
	 *            the pHOB_CommunicationDetailsBusinessAddressAddressline1 to
	 *            set
	 */
	public void setPHOB_CommunicationDetailsBusinessAddressAddressline1(
			String pHOB_CommunicationDetailsBusinessAddressAddressline1) {
		PHOB_CommunicationDetailsBusinessAddressAddressline1 = pHOB_CommunicationDetailsBusinessAddressAddressline1;
	}

	/**
	 * @return the pHOB_CommunicationDetailsBusinessAddressAddressline2
	 */
	public String getPHOB_CommunicationDetailsBusinessAddressAddressline2() {
		return PHOB_CommunicationDetailsBusinessAddressAddressline2;
	}

	/**
	 * @param pHOB_CommunicationDetailsBusinessAddressAddressline2
	 *            the pHOB_CommunicationDetailsBusinessAddressAddressline2 to
	 *            set
	 */
	public void setPHOB_CommunicationDetailsBusinessAddressAddressline2(
			String pHOB_CommunicationDetailsBusinessAddressAddressline2) {
		PHOB_CommunicationDetailsBusinessAddressAddressline2 = pHOB_CommunicationDetailsBusinessAddressAddressline2;
	}

	/**
	 * @return the pHOB_CommunicationDetailsBusinessAddressAddressline3
	 */
	public String getPHOB_CommunicationDetailsBusinessAddressAddressline3() {
		return PHOB_CommunicationDetailsBusinessAddressAddressline3;
	}

	/**
	 * @param pHOB_CommunicationDetailsBusinessAddressAddressline3
	 *            the pHOB_CommunicationDetailsBusinessAddressAddressline3 to
	 *            set
	 */
	public void setPHOB_CommunicationDetailsBusinessAddressAddressline3(
			String pHOB_CommunicationDetailsBusinessAddressAddressline3) {
		PHOB_CommunicationDetailsBusinessAddressAddressline3 = pHOB_CommunicationDetailsBusinessAddressAddressline3;
	}

	/**
	 * @return the pHOB_CommunicationDetailsBusinessAddressBusinesscity
	 */
	public String getPHOB_CommunicationDetailsBusinessAddressBusinesscity() {
		return PHOB_CommunicationDetailsBusinessAddressBusinesscity;
	}

	/**
	 * @param pHOB_CommunicationDetailsBusinessAddressBusinesscity
	 *            the pHOB_CommunicationDetailsBusinessAddressBusinesscity to
	 *            set
	 */
	public void setPHOB_CommunicationDetailsBusinessAddressBusinesscity(
			String pHOB_CommunicationDetailsBusinessAddressBusinesscity) {
		PHOB_CommunicationDetailsBusinessAddressBusinesscity = pHOB_CommunicationDetailsBusinessAddressBusinesscity;
	}

	/**
	 * @return the pHOB_CommunicationDetailsBusinessAddressBusinessstate
	 */
	public String getPHOB_CommunicationDetailsBusinessAddressBusinessstate() {
		return PHOB_CommunicationDetailsBusinessAddressBusinessstate;
	}

	/**
	 * @param pHOB_CommunicationDetailsBusinessAddressBusinessstate
	 *            the pHOB_CommunicationDetailsBusinessAddressBusinessstate to
	 *            set
	 */
	public void setPHOB_CommunicationDetailsBusinessAddressBusinessstate(
			String pHOB_CommunicationDetailsBusinessAddressBusinessstate) {
		PHOB_CommunicationDetailsBusinessAddressBusinessstate = pHOB_CommunicationDetailsBusinessAddressBusinessstate;
	}

	/**
	 * @return the pHOB_CommunicationDetailsBusinessAddressBusinesspin
	 */
	public String getPHOB_CommunicationDetailsBusinessAddressBusinesspin() {
		return PHOB_CommunicationDetailsBusinessAddressBusinesspin;
	}

	/**
	 * @param pHOB_CommunicationDetailsBusinessAddressBusinesspin
	 *            the pHOB_CommunicationDetailsBusinessAddressBusinesspin to set
	 */
	public void setPHOB_CommunicationDetailsBusinessAddressBusinesspin(
			String pHOB_CommunicationDetailsBusinessAddressBusinesspin) {
		PHOB_CommunicationDetailsBusinessAddressBusinesspin = pHOB_CommunicationDetailsBusinessAddressBusinesspin;
	}

	/**
	 * @return the pHOB_BankDetailsBankName
	 */
	public String getPHOB_BankDetailsBankName() {
		return PHOB_BankDetailsBankName;
	}

	/**
	 * @param pHOB_BankDetailsBankName
	 *            the pHOB_BankDetailsBankName to set
	 */
	public void setPHOB_BankDetailsBankName(String pHOB_BankDetailsBankName) {
		PHOB_BankDetailsBankName = pHOB_BankDetailsBankName;
	}

	/**
	 * @return the pHOB_BankDetailsBankAccountNumber
	 */
	public Long getPHOB_BankDetailsBankAccountNumber() {
		return PHOB_BankDetailsBankAccountNumber;
	}

	/**
	 * @param pHOB_BankDetailsBankAccountNumber
	 *            the pHOB_BankDetailsBankAccountNumber to set
	 */
	public void setPHOB_BankDetailsBankAccountNumber(Long pHOB_BankDetailsBankAccountNumber) {
		PHOB_BankDetailsBankAccountNumber = pHOB_BankDetailsBankAccountNumber;
	}

	/**
	 * @return the pHOB_BankDetailsBankBranch
	 */
	public String getPHOB_BankDetailsBankBranch() {
		return PHOB_BankDetailsBankBranch;
	}

	/**
	 * @param pHOB_BankDetailsBankBranch
	 *            the pHOB_BankDetailsBankBranch to set
	 */
	public void setPHOB_BankDetailsBankBranch(String pHOB_BankDetailsBankBranch) {
		PHOB_BankDetailsBankBranch = pHOB_BankDetailsBankBranch;
	}

	/**
	 * @return the pHOB_BankDetailsAccountType
	 */
	public String getPHOB_BankDetailsAccountType() {
		return PHOB_BankDetailsAccountType;
	}

	/**
	 * @param pHOB_BankDetailsAccountType
	 *            the pHOB_BankDetailsAccountType to set
	 */
	public void setPHOB_BankDetailsAccountType(String pHOB_BankDetailsAccountType) {
		PHOB_BankDetailsAccountType = pHOB_BankDetailsAccountType;
	}

	/**
	 * @return the pHOB_BankDetailsIfscCode
	 */
	public String getPHOB_BankDetailsIfscCode() {
		return PHOB_BankDetailsIfscCode;
	}

	/**
	 * @param pHOB_BankDetailsIfscCode
	 *            the pHOB_BankDetailsIfscCode to set
	 */
	public void setPHOB_BankDetailsIfscCode(String pHOB_BankDetailsIfscCode) {
		PHOB_BankDetailsIfscCode = pHOB_BankDetailsIfscCode;
	}

	/**
	 * @return the pHOB_DocumentDetailsPanFileURL
	 */
	public String getPHOB_DocumentDetailsPanFileURL() {
		return PHOB_DocumentDetailsPanFileURL;
	}

	/**
	 * @param pHOB_DocumentDetailsPanFileURL
	 *            the pHOB_DocumentDetailsPanFileURL to set
	 */
	public void setPHOB_DocumentDetailsPanFileURL(String pHOB_DocumentDetailsPanFileURL) {
		PHOB_DocumentDetailsPanFileURL = pHOB_DocumentDetailsPanFileURL;
	}

	/**
	 * @return the pHOB_DocumentDetailsResidenceFileURLFrontSide
	 */
	public String getPHOB_DocumentDetailsResidenceFileURLFrontSide() {
		return PHOB_DocumentDetailsResidenceFileURLFrontSide;
	}

	/**
	 * @param pHOB_DocumentDetailsResidenceFileURLFrontSide
	 *            the pHOB_DocumentDetailsResidenceFileURLFrontSide to set
	 */
	public void setPHOB_DocumentDetailsResidenceFileURLFrontSide(String pHOB_DocumentDetailsResidenceFileURLFrontSide) {
		PHOB_DocumentDetailsResidenceFileURLFrontSide = pHOB_DocumentDetailsResidenceFileURLFrontSide;
	}

	/**
	 * @return the pHOB_DocumentDetailsResidenceFileURLBackSide
	 */
	public String getPHOB_DocumentDetailsResidenceFileURLBackSide() {
		return PHOB_DocumentDetailsResidenceFileURLBackSide;
	}

	/**
	 * @param pHOB_DocumentDetailsResidenceFileURLBackSide
	 *            the pHOB_DocumentDetailsResidenceFileURLBackSide to set
	 */
	public void setPHOB_DocumentDetailsResidenceFileURLBackSide(String pHOB_DocumentDetailsResidenceFileURLBackSide) {
		PHOB_DocumentDetailsResidenceFileURLBackSide = pHOB_DocumentDetailsResidenceFileURLBackSide;
	}

	/**
	 * @return the pHOB_DocumentDetailsBusinessFileURL
	 */
	public String getPHOB_DocumentDetailsBusinessFileURL() {
		return PHOB_DocumentDetailsBusinessFileURL;
	}

	/**
	 * @param pHOB_DocumentDetailsBusinessFileURL
	 *            the pHOB_DocumentDetailsBusinessFileURL to set
	 */
	public void setPHOB_DocumentDetailsBusinessFileURL(String pHOB_DocumentDetailsBusinessFileURL) {
		PHOB_DocumentDetailsBusinessFileURL = pHOB_DocumentDetailsBusinessFileURL;
	}

	/**
	 * @return the pHOB_DocumentDetailsPCOSignatureURL
	 */
	public String getPHOB_DocumentDetailsPCOSignatureURL() {
		return PHOB_DocumentDetailsPCOSignatureURL;
	}

	/**
	 * @param pHOB_DocumentDetailsPCOSignatureURL
	 *            the pHOB_DocumentDetailsPCOSignatureURL to set
	 */
	public void setPHOB_DocumentDetailsPCOSignatureURL(String pHOB_DocumentDetailsPCOSignatureURL) {
		PHOB_DocumentDetailsPCOSignatureURL = pHOB_DocumentDetailsPCOSignatureURL;
	}

	/**
	 * @return the pHOB_DocumentDetailsIfany
	 */
	public String getPHOB_DocumentDetailsIfany() {
		return PHOB_DocumentDetailsIfany;
	}

	/**
	 * @param pHOB_DocumentDetailsIfany
	 *            the pHOB_DocumentDetailsIfany to set
	 */
	public void setPHOB_DocumentDetailsIfany(String pHOB_DocumentDetailsIfany) {
		PHOB_DocumentDetailsIfany = pHOB_DocumentDetailsIfany;
	}

	/**
	 * @return the pHOB_DocumentDetailsAgreement
	 */
	public String getPHOB_DocumentDetailsAgreement() {
		return PHOB_DocumentDetailsAgreement;
	}

	/**
	 * @param pHOB_DocumentDetailsAgreement
	 *            the pHOB_DocumentDetailsAgreement to set
	 */
	public void setPHOB_DocumentDetailsAgreement(String pHOB_DocumentDetailsAgreement) {
		PHOB_DocumentDetailsAgreement = pHOB_DocumentDetailsAgreement;
	}

	/**
	 * @return the pHOB_Created
	 */
	public Date getPHOB_Created() {
		return PHOB_Created;
	}

	/**
	 * @param pHOB_Created
	 *            the pHOB_Created to set
	 */
	public void setPHOB_Created(Date pHOB_Created) {
		PHOB_Created = pHOB_Created;
	}

	/**
	 * @return the pHOB_User
	 */
	public Long getPHOB_User() {
		return PHOB_User;
	}

	/**
	 * @param pHOB_User
	 *            the pHOB_User to set
	 */
	public void setPHOB_User(Long pHOB_User) {
		PHOB_User = pHOB_User;
	}

	/**
	 * @return the pHOB_KYCUPdateDate
	 */
	public Date getPHOB_KYCUPdateDate() {
		return PHOB_KYCUPdateDate;
	}

	/**
	 * @param pHOB_KYCUPdateDate
	 *            the pHOB_KYCUPdateDate to set
	 */
	public void setPHOB_KYCUPdateDate(Date pHOB_KYCUPdateDate) {
		PHOB_KYCUPdateDate = pHOB_KYCUPdateDate;
	}

	/**
	 * @return the pHOB_KYCUpdatedBy
	 */
	public String getPHOB_KYCUpdatedBy() {
		return PHOB_KYCUpdatedBy;
	}

	/**
	 * @param pHOB_KYCUpdatedBy
	 *            the pHOB_KYCUpdatedBy to set
	 */
	public void setPHOB_KYCUpdatedBy(String pHOB_KYCUpdatedBy) {
		PHOB_KYCUpdatedBy = pHOB_KYCUpdatedBy;
	}

	/**
	 * @return the pHOB_PersonalDetailsPicture
	 */
	public String getPHOB_PersonalDetailsPicture() {
		return PHOB_PersonalDetailsPicture;
	}

	/**
	 * @param pHOB_PersonalDetailsPicture the pHOB_PersonalDetailsPicture to set
	 */
	public void setPHOB_PersonalDetailsPicture(String pHOB_PersonalDetailsPicture) {
		PHOB_PersonalDetailsPicture = pHOB_PersonalDetailsPicture;
	}

	/**
	 * @return the pHOB_DocumentDetailsPanFile
	 */
	public String getPHOB_DocumentDetailsPanFile() {
		return PHOB_DocumentDetailsPanFile;
	}

	/**
	 * @param pHOB_DocumentDetailsPanFile the pHOB_DocumentDetailsPanFile to set
	 */
	public void setPHOB_DocumentDetailsPanFile(String pHOB_DocumentDetailsPanFile) {
		PHOB_DocumentDetailsPanFile = pHOB_DocumentDetailsPanFile;
	}

	/**
	 * @return the pHOB_DocumentDetailsResidenceFileFrontSide
	 */
	public String getPHOB_DocumentDetailsResidenceFileFrontSide() {
		return PHOB_DocumentDetailsResidenceFileFrontSide;
	}

	/**
	 * @param pHOB_DocumentDetailsResidenceFileFrontSide the pHOB_DocumentDetailsResidenceFileFrontSide to set
	 */
	public void setPHOB_DocumentDetailsResidenceFileFrontSide(String pHOB_DocumentDetailsResidenceFileFrontSide) {
		PHOB_DocumentDetailsResidenceFileFrontSide = pHOB_DocumentDetailsResidenceFileFrontSide;
	}

	/**
	 * @return the pHOB_DocumentDetailsResidenceFileBackSide
	 */
	public String getPHOB_DocumentDetailsResidenceFileBackSide() {
		return PHOB_DocumentDetailsResidenceFileBackSide;
	}

	/**
	 * @param pHOB_DocumentDetailsResidenceFileBackSide the pHOB_DocumentDetailsResidenceFileBackSide to set
	 */
	public void setPHOB_DocumentDetailsResidenceFileBackSide(String pHOB_DocumentDetailsResidenceFileBackSide) {
		PHOB_DocumentDetailsResidenceFileBackSide = pHOB_DocumentDetailsResidenceFileBackSide;
	}

	/**
	 * @return the pHOB_DocumentDetailsBusinessFile
	 */
	public String getPHOB_DocumentDetailsBusinessFile() {
		return PHOB_DocumentDetailsBusinessFile;
	}

	/**
	 * @param pHOB_DocumentDetailsBusinessFile the pHOB_DocumentDetailsBusinessFile to set
	 */
	public void setPHOB_DocumentDetailsBusinessFile(String pHOB_DocumentDetailsBusinessFile) {
		PHOB_DocumentDetailsBusinessFile = pHOB_DocumentDetailsBusinessFile;
	}

	/**
	 * @return the pHOB_DocumentDetailsPCOSignature
	 */
	public String getPHOB_DocumentDetailsPCOSignature() {
		return PHOB_DocumentDetailsPCOSignature;
	}

	/**
	 * @param pHOB_DocumentDetailsPCOSignature the pHOB_DocumentDetailsPCOSignature to set
	 */
	public void setPHOB_DocumentDetailsPCOSignature(String pHOB_DocumentDetailsPCOSignature) {
		PHOB_DocumentDetailsPCOSignature = pHOB_DocumentDetailsPCOSignature;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PHMC_PHOB_ONBOARD [PHOB_KycSrNo=" + PHOB_KycSrNo + ", PHOB_PersonalDetailsFullName="
				+ PHOB_PersonalDetailsFullName + ", PHOB_PersonalDetailsPictureURL=" + PHOB_PersonalDetailsPictureURL
				+ ", PHOB_PersonalDetailsPicture=" + PHOB_PersonalDetailsPicture + ", PHOB_PersonalDetailsDob="
				+ PHOB_PersonalDetailsDob + ", PHOB_PersonalDetailsMotherName=" + PHOB_PersonalDetailsMotherName
				+ ", PHOB_PersonalDetailsGender=" + PHOB_PersonalDetailsGender + ", PHOB_BusinessDetailsBusinessName="
				+ PHOB_BusinessDetailsBusinessName + ", PHOB_BusinessDetailsNatureofBusiness="
				+ PHOB_BusinessDetailsNatureofBusiness + ", PHOB_BusinessDetailsIfany=" + PHOB_BusinessDetailsIfany
				+ ", PHOB_CommunicationDetailsPersonalAddressAddressline1="
				+ PHOB_CommunicationDetailsPersonalAddressAddressline1
				+ ", PHOB_CommunicationDetailsPersonalAddressAddressline2="
				+ PHOB_CommunicationDetailsPersonalAddressAddressline2
				+ ", PHOB_CommunicationDetailsPersonalAddressAddressline3="
				+ PHOB_CommunicationDetailsPersonalAddressAddressline3
				+ ", PHOB_CommunicationDetailsPersonalAddressPersonalcity="
				+ PHOB_CommunicationDetailsPersonalAddressPersonalcity
				+ ", PHOB_CommunicationDetailsPersonalAddressPersonalState="
				+ PHOB_CommunicationDetailsPersonalAddressPersonalState
				+ ", PHOB_CommunicationDetailsPersonalAddressPersonalpin="
				+ PHOB_CommunicationDetailsPersonalAddressPersonalpin
				+ ", PHOB_CommunicationDetailsBusinessAddressAddressline1="
				+ PHOB_CommunicationDetailsBusinessAddressAddressline1
				+ ", PHOB_CommunicationDetailsBusinessAddressAddressline2="
				+ PHOB_CommunicationDetailsBusinessAddressAddressline2
				+ ", PHOB_CommunicationDetailsBusinessAddressAddressline3="
				+ PHOB_CommunicationDetailsBusinessAddressAddressline3
				+ ", PHOB_CommunicationDetailsBusinessAddressBusinesscity="
				+ PHOB_CommunicationDetailsBusinessAddressBusinesscity
				+ ", PHOB_CommunicationDetailsBusinessAddressBusinessstate="
				+ PHOB_CommunicationDetailsBusinessAddressBusinessstate
				+ ", PHOB_CommunicationDetailsBusinessAddressBusinesspin="
				+ PHOB_CommunicationDetailsBusinessAddressBusinesspin + ", PHOB_BankDetailsBankName="
				+ PHOB_BankDetailsBankName + ", PHOB_BankDetailsBankAccountNumber=" + PHOB_BankDetailsBankAccountNumber
				+ ", PHOB_BankDetailsBankBranch=" + PHOB_BankDetailsBankBranch + ", PHOB_BankDetailsAccountType="
				+ PHOB_BankDetailsAccountType + ", PHOB_BankDetailsIfscCode=" + PHOB_BankDetailsIfscCode
				+ ", PHOB_DocumentDetailsPanFileURL=" + PHOB_DocumentDetailsPanFileURL
				+ ", PHOB_DocumentDetailsPanFile=" + PHOB_DocumentDetailsPanFile
				+ ", PHOB_DocumentDetailsResidenceFileURLFrontSide=" + PHOB_DocumentDetailsResidenceFileURLFrontSide
				+ ", PHOB_DocumentDetailsResidenceFileFrontSide=" + PHOB_DocumentDetailsResidenceFileFrontSide
				+ ", PHOB_DocumentDetailsResidenceFileURLBackSide=" + PHOB_DocumentDetailsResidenceFileURLBackSide
				+ ", PHOB_DocumentDetailsResidenceFileBackSide=" + PHOB_DocumentDetailsResidenceFileBackSide
				+ ", PHOB_DocumentDetailsBusinessFileURL=" + PHOB_DocumentDetailsBusinessFileURL
				+ ", PHOB_DocumentDetailsBusinessFile=" + PHOB_DocumentDetailsBusinessFile
				+ ", PHOB_DocumentDetailsPCOSignatureURL=" + PHOB_DocumentDetailsPCOSignatureURL
				+ ", PHOB_DocumentDetailsPCOSignature=" + PHOB_DocumentDetailsPCOSignature
				+ ", PHOB_DocumentDetailsIfany=" + PHOB_DocumentDetailsIfany + ", PHOB_DocumentDetailsAgreement="
				+ PHOB_DocumentDetailsAgreement + ", PHOB_Created=" + PHOB_Created + ", PHOB_User=" + PHOB_User
				+ ", PHOB_KYCUPdateDate=" + PHOB_KYCUPdateDate + ", PHOB_KYCUpdatedBy=" + PHOB_KYCUpdatedBy + "]";
	}
	
	

	



	
	
	
}
