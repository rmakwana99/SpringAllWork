
package com.rahul.phmc.om.login.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author Rahul makvana This class declares all PHMC_OM_Login Attribute to
 *         represent the column of that table and this table is in PHMC-MASTER
 *         Database.
 */
@XmlRootElement
@Entity
@Table(name = "PHMC_OM_LOGIN")
@DynamicInsert
@DynamicUpdate
public class PHMC_OM_LOGIN implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)	
	private  long PHMC_OM_LoginSrNo;
	private String PHMC_OM_FirstName;
	private String PHMC_OM_LastName;
	private Date PHMC_OM_Dob;
	private String PHMC_OM_Email;	
	private String PHMC_OM_UserName;
	private String PHMC_OM_Password;
	private String PHMC_OM_Salt;
	private String PHMC_OM_Lead;
	private String PHMC_OM_OnBoard;
	private String PHMC_OM_Billing;
	private String PHMC_OM_Admin;
	private String PHMC_OM_Supervisor;
	private Date PHMC_OM_UpdatedDate;
	private String PHMC_OM_UpdatedBy;
	private Date PHMC_OM_CreatedDate;
	private String PHMC_OM_PCOStatus;
	private String PHMC_OM_PCOStatusList;
	private String PHMC_OM_PCOGeneralSearch;
	private String PHMC_OM_PCOGeneralSearchRange;
	private String PHMC_OM_FutureField1;
	private String PHMC_OM_FutureField2;
	private Integer PHMC_OM_RoleCode;
	private String PHMC_OM_Address1;
	private String PHMC_OM_Address2;
	private String PHMC_OM_Address3;
	private String PHMC_OM_City;
	private String PHMC_OM_State;
	private Integer PHMC_OM_Pincode;
	private Long PHMC_OM_Phone;
	private String PHMC_OM_CreatedBy;
	private Integer PHMC_OM_ActiveStatus;	
	private Date PHMC_OM_EffectiveDate;
	private Date PHMC_OM_EffectiveEndDate;
	@Transient
	private Integer PHMC_OM_TotalPCO;	
	
	private String PHMC_OM_PrimaryBankName ;
	private Long  PHMC_OM_PrimaryBankAcountNo ;
	private String PHMC_OM_PrimaryBankBranchName ;
	private String PHMC_OM_PrimaryBankAccountType;
	private String PHMC_OM_PrimaryIFSCCode ;
	private Long PHMC_OM_PrimaryBankLinkedAadhaarNo ;
	private String  PHMC_OM_PrimaryBankVPA ;
	private String  PHMC_OM_SecondaryBankName ;
	private Long  PHMC_OM_SecondaryBankAcountNo ;
	private String PHMC_OM_SecondaryBankBranchName ;
	private String PHMC_OM_SecondaryBankAccountType ;
	private String PHMC_OM_SecondaryIFSCCode ;
	private Long PHMC_OM_SecondaryBankLinkedAadhaarNo ;
	private String PHMC_OM_SecondaryBankVPA ;
	private String  PHMC_OM_PANCardNo ;
	private Long PHMC_OM_AadhaarNo ;



	public String getPHMC_OM_PrimaryBankName() {
		return PHMC_OM_PrimaryBankName;
	}

	public void setPHMC_OM_PrimaryBankName(String pHMC_OM_PrimaryBankName) {
		PHMC_OM_PrimaryBankName = pHMC_OM_PrimaryBankName;
	}

	public Long getPHMC_OM_PrimaryBankAcountNo() {
		return PHMC_OM_PrimaryBankAcountNo;
	}

	public void setPHMC_OM_PrimaryBankAcountNo(Long pHMC_OM_PrimaryBankAcountNo) {
		PHMC_OM_PrimaryBankAcountNo = pHMC_OM_PrimaryBankAcountNo;
	}

	public String getPHMC_OM_PrimaryBankBranchName() {
		return PHMC_OM_PrimaryBankBranchName;
	}

	public void setPHMC_OM_PrimaryBankBranchName(String pHMC_OM_PrimaryBankBranchName) {
		PHMC_OM_PrimaryBankBranchName = pHMC_OM_PrimaryBankBranchName;
	}

	public String getPHMC_OM_PrimaryBankAccountType() {
		return PHMC_OM_PrimaryBankAccountType;
	}

	public void setPHMC_OM_PrimaryBankAccountType(String pHMC_OM_PrimaryBankAccountType) {
		PHMC_OM_PrimaryBankAccountType = pHMC_OM_PrimaryBankAccountType;
	}

	public String getPHMC_OM_PrimaryIFSCCode() {
		return PHMC_OM_PrimaryIFSCCode;
	}

	public void setPHMC_OM_PrimaryIFSCCode(String pHMC_OM_PrimaryIFSCCode) {
		PHMC_OM_PrimaryIFSCCode = pHMC_OM_PrimaryIFSCCode;
	}

	public Long getPHMC_OM_PrimaryBankLinkedAadhaarNo() {
		return PHMC_OM_PrimaryBankLinkedAadhaarNo;
	}

	public void setPHMC_OM_PrimaryBankLinkedAadhaarNo(Long pHMC_OM_PrimaryBankLinkedAadhaarNo) {
		PHMC_OM_PrimaryBankLinkedAadhaarNo = pHMC_OM_PrimaryBankLinkedAadhaarNo;
	}

	public String getPHMC_OM_PrimaryBankVPA() {
		return PHMC_OM_PrimaryBankVPA;
	}

	public void setPHMC_OM_PrimaryBankVPA(String pHMC_OM_PrimaryBankVPA) {
		PHMC_OM_PrimaryBankVPA = pHMC_OM_PrimaryBankVPA;
	}

	public String getPHMC_OM_SecondaryBankName() {
		return PHMC_OM_SecondaryBankName;
	}

	public void setPHMC_OM_SecondaryBankName(String pHMC_OM_SecondaryBankName) {
		PHMC_OM_SecondaryBankName = pHMC_OM_SecondaryBankName;
	}

	public Long getPHMC_OM_SecondaryBankAcountNo() {
		return PHMC_OM_SecondaryBankAcountNo;
	}

	public void setPHMC_OM_SecondaryBankAcountNo(Long pHMC_OM_SecondaryBankAcountNo) {
		PHMC_OM_SecondaryBankAcountNo = pHMC_OM_SecondaryBankAcountNo;
	}

	public String getPHMC_OM_SecondaryBankBranchName() {
		return PHMC_OM_SecondaryBankBranchName;
	}

	public void setPHMC_OM_SecondaryBankBranchName(String pHMC_OM_SecondaryBankBranchName) {
		PHMC_OM_SecondaryBankBranchName = pHMC_OM_SecondaryBankBranchName;
	}

	public String getPHMC_OM_SecondaryBankAccountType() {
		return PHMC_OM_SecondaryBankAccountType;
	}

	public void setPHMC_OM_SecondaryBankAccountType(String pHMC_OM_SecondaryBankAccountType) {
		PHMC_OM_SecondaryBankAccountType = pHMC_OM_SecondaryBankAccountType;
	}

	public String getPHMC_OM_SecondaryIFSCCode() {
		return PHMC_OM_SecondaryIFSCCode;
	}

	public void setPHMC_OM_SecondaryIFSCCode(String pHMC_OM_SecondaryIFSCCode) {
		PHMC_OM_SecondaryIFSCCode = pHMC_OM_SecondaryIFSCCode;
	}

	public Long getPHMC_OM_SecondaryBankLinkedAadhaarNo() {
		return PHMC_OM_SecondaryBankLinkedAadhaarNo;
	}

	public void setPHMC_OM_SecondaryBankLinkedAadhaarNo(Long pHMC_OM_SecondaryBankLinkedAadhaarNo) {
		PHMC_OM_SecondaryBankLinkedAadhaarNo = pHMC_OM_SecondaryBankLinkedAadhaarNo;
	}

	public String getPHMC_OM_SecondaryBankVPA() {
		return PHMC_OM_SecondaryBankVPA;
	}

	public void setPHMC_OM_SecondaryBankVPA(String pHMC_OM_SecondaryBankVPA) {
		PHMC_OM_SecondaryBankVPA = pHMC_OM_SecondaryBankVPA;
	}

	public String getPHMC_OM_PANCardNo() {
		return PHMC_OM_PANCardNo;
	}

	public void setPHMC_OM_PANCardNo(String pHMC_OM_PANCardNo) {
		PHMC_OM_PANCardNo = pHMC_OM_PANCardNo;
	}

	public Long getPHMC_OM_AadhaarNo() {
		return PHMC_OM_AadhaarNo;
	}

	public void setPHMC_OM_AadhaarNo(Long pHMC_OM_AadhaarNo) {
		PHMC_OM_AadhaarNo = pHMC_OM_AadhaarNo;
	}

	public Integer getPHMC_OM_TotalPCO() {
		return PHMC_OM_TotalPCO;
	}

	public void setPHMC_OM_TotalPCO(Integer pHMC_OM_TotalPCO) {
		PHMC_OM_TotalPCO = pHMC_OM_TotalPCO;
	}

	/**
	 * @return the pHMC_OM_LoginSrNo
	 */
	public Long getPHMC_OM_LoginSrNo() {
		return PHMC_OM_LoginSrNo;
	}

	/**
	 * @param pHMC_OM_LoginSrNo
	 *            the pHMC_OM_LoginSrNo to set
	 */
	public void setPHMC_OM_LoginSrNo(Long pHMC_OM_LoginSrNo) {
		PHMC_OM_LoginSrNo = pHMC_OM_LoginSrNo;
	}

	/**
	 * @return the pHMC_OM_FirstName
	 */
	public String getPHMC_OM_FirstName() {
		return PHMC_OM_FirstName;
	}

	/**
	 * @param pHMC_OM_FirstName
	 *            the pHMC_OM_FirstName to set
	 */
	public void setPHMC_OM_FirstName(String pHMC_OM_FirstName) {
		PHMC_OM_FirstName = pHMC_OM_FirstName;
	}

	/**
	 * @return the pHMC_OM_LastName
	 */
	public String getPHMC_OM_LastName() {
		return PHMC_OM_LastName;
	}

	/**
	 * @param pHMC_OM_LastName
	 *            the pHMC_OM_LastName to set
	 */
	public void setPHMC_OM_LastName(String pHMC_OM_LastName) {
		PHMC_OM_LastName = pHMC_OM_LastName;
	}

	/**
	 * @return the pHMC_OM_Dob
	 */
	public Date getPHMC_OM_Dob() {
		return PHMC_OM_Dob;
	}

	/**
	 * @param pHMC_OM_Dob
	 *            the pHMC_OM_Dob to set
	 */
	public void setPHMC_OM_Dob(Date pHMC_OM_Dob) {
		PHMC_OM_Dob = pHMC_OM_Dob;
	}

	/**
	 * @return the pHMC_OM_Email
	 */
	public String getPHMC_OM_Email() {
		return PHMC_OM_Email;
	}

	/**
	 * @param pHMC_OM_Email
	 *            the pHMC_OM_Email to set
	 */
	public void setPHMC_OM_Email(String pHMC_OM_Email) {
		PHMC_OM_Email = pHMC_OM_Email;
	}

	/**
	 * @return the pHMC_OM_UserName
	 */
	public String getPHMC_OM_UserName() {
		return PHMC_OM_UserName;
	}

	/**
	 * @param pHMC_OM_UserName
	 *            the pHMC_OM_UserName to set
	 */
	public void setPHMC_OM_UserName(String pHMC_OM_UserName) {
		PHMC_OM_UserName = pHMC_OM_UserName;
	}

	/**
	 * @return the pHMC_OM_Salt
	 */
	public String getPHMC_OM_Salt() {
		return PHMC_OM_Salt;
	}

	/**
	 * @param pHMC_OM_Salt
	 *            the pHMC_OM_Salt to set
	 */
	public void setPHMC_OM_Salt(String pHMC_OM_Salt) {
		PHMC_OM_Salt = pHMC_OM_Salt;
	}

	/**
	 * @return the pHMC_OM_Lead
	 */
	public String getPHMC_OM_Lead() {
		return PHMC_OM_Lead;
	}

	/**
	 * @param pHMC_OM_Lead
	 *            the pHMC_OM_Lead to set
	 */
	public void setPHMC_OM_Lead(String pHMC_OM_Lead) {
		PHMC_OM_Lead = pHMC_OM_Lead;
	}

	/**
	 * @return the pHMC_OM_OnBoard
	 */
	public String getPHMC_OM_OnBoard() {
		return PHMC_OM_OnBoard;
	}

	/**
	 * @param pHMC_OM_OnBoard
	 *            the pHMC_OM_OnBoard to set
	 */
	public void setPHMC_OM_OnBoard(String pHMC_OM_OnBoard) {
		PHMC_OM_OnBoard = pHMC_OM_OnBoard;
	}

	/**
	 * @return the pHMC_OM_Billing
	 */
	public String getPHMC_OM_Billing() {
		return PHMC_OM_Billing;
	}

	/**
	 * @param pHMC_OM_Billing
	 *            the pHMC_OM_Billing to set
	 */
	public void setPHMC_OM_Billing(String pHMC_OM_Billing) {
		PHMC_OM_Billing = pHMC_OM_Billing;
	}

	/**
	 * @return the pHMC_OM_Admin
	 */
	public String getPHMC_OM_Admin() {
		return PHMC_OM_Admin;
	}

	/**
	 * @param pHMC_OM_Admin
	 *            the pHMC_OM_Admin to set
	 */
	public void setPHMC_OM_Admin(String pHMC_OM_Admin) {
		PHMC_OM_Admin = pHMC_OM_Admin;
	}

	/**
	 * @return the pHMC_OM_Supervisor
	 */
	public String getPHMC_OM_Supervisor() {
		return PHMC_OM_Supervisor;
	}

	/**
	 * @param pHMC_OM_Supervisor
	 *            the pHMC_OM_Supervisor to set
	 */
	public void setPHMC_OM_Supervisor(String pHMC_OM_Supervisor) {
		PHMC_OM_Supervisor = pHMC_OM_Supervisor;
	}

	/**
	 * @return the pHMC_OM_UpdatedDate
	 */
	public Date getPHMC_OM_UpdatedDate() {
		return PHMC_OM_UpdatedDate;
	}

	/**
	 * @param pHMC_OM_UpdatedDate
	 *            the pHMC_OM_UpdatedDate to set
	 */
	public void setPHMC_OM_UpdatedDate(Date pHMC_OM_UpdatedDate) {
		PHMC_OM_UpdatedDate = pHMC_OM_UpdatedDate;
	}

	/**
	 * @return the pHMC_OM_UpdatedBy
	 */
	public String getPHMC_OM_UpdatedBy() {
		return PHMC_OM_UpdatedBy;
	}

	/**
	 * @param pHMC_OM_UpdatedBy
	 *            the pHMC_OM_UpdatedBy to set
	 */
	public void setPHMC_OM_UpdatedBy(String pHMC_OM_UpdatedBy) {
		PHMC_OM_UpdatedBy = pHMC_OM_UpdatedBy;
	}

	/**
	 * @return the pHMC_OM_CreatedDate
	 */
	public Date getPHMC_OM_CreatedDate() {
		return PHMC_OM_CreatedDate;
	}

	/**
	 * @param pHMC_OM_CreatedDate
	 *            the pHMC_OM_CreatedDate to set
	 */
	public void setPHMC_OM_CreatedDate(Date pHMC_OM_CreatedDate) {
		PHMC_OM_CreatedDate = pHMC_OM_CreatedDate;
	}

	/**
	 * @return the pHMC_OM_PCOStatus
	 */
	public String getPHMC_OM_PCOStatus() {
		return PHMC_OM_PCOStatus;
	}

	/**
	 * @param pHMC_OM_PCOStatus
	 *            the pHMC_OM_PCOStatus to set
	 */
	public void setPHMC_OM_PCOStatus(String pHMC_OM_PCOStatus) {
		PHMC_OM_PCOStatus = pHMC_OM_PCOStatus;
	}

	/**
	 * @return the pHMC_OM_PCOStatusList
	 */
	public String getPHMC_OM_PCOStatusList() {
		return PHMC_OM_PCOStatusList;
	}

	/**
	 * @param pHMC_OM_PCOStatusList
	 *            the pHMC_OM_PCOStatusList to set
	 */
	public void setPHMC_OM_PCOStatusList(String pHMC_OM_PCOStatusList) {
		PHMC_OM_PCOStatusList = pHMC_OM_PCOStatusList;
	}

	/**
	 * @return the pHMC_OM_PCOGeneralSearch
	 */
	public String getPHMC_OM_PCOGeneralSearch() {
		return PHMC_OM_PCOGeneralSearch;
	}

	/**
	 * @param pHMC_OM_PCOGeneralSearch
	 *            the pHMC_OM_PCOGeneralSearch to set
	 */
	public void setPHMC_OM_PCOGeneralSearch(String pHMC_OM_PCOGeneralSearch) {
		PHMC_OM_PCOGeneralSearch = pHMC_OM_PCOGeneralSearch;
	}

	/**
	 * @return the pHMC_OM_PCOGeneralSearchRange
	 */
	public String getPHMC_OM_PCOGeneralSearchRange() {
		return PHMC_OM_PCOGeneralSearchRange;
	}

	/**
	 * @param pHMC_OM_PCOGeneralSearchRange
	 *            the pHMC_OM_PCOGeneralSearchRange to set
	 */
	public void setPHMC_OM_PCOGeneralSearchRange(String pHMC_OM_PCOGeneralSearchRange) {
		PHMC_OM_PCOGeneralSearchRange = pHMC_OM_PCOGeneralSearchRange;
	}

	/**
	 * @return the pHMC_OM_FutureField1
	 */
	public String getPHMC_OM_FutureField1() {
		return PHMC_OM_FutureField1;
	}

	/**
	 * @param pHMC_OM_FutureField1
	 *            the pHMC_OM_FutureField1 to set
	 */
	public void setPHMC_OM_FutureField1(String pHMC_OM_FutureField1) {
		PHMC_OM_FutureField1 = pHMC_OM_FutureField1;
	}

	/**
	 * @return the pHMC_OM_FutureField2
	 */
	public String getPHMC_OM_FutureField2() {
		return PHMC_OM_FutureField2;
	}

	/**
	 * @param pHMC_OM_FutureField2
	 *            the pHMC_OM_FutureField2 to set
	 */
	public void setPHMC_OM_FutureField2(String pHMC_OM_FutureField2) {
		PHMC_OM_FutureField2 = pHMC_OM_FutureField2;
	}

	/**
	 * @return the pHMC_OM_Password
	 */
	public String getPHMC_OM_Password() {
		return PHMC_OM_Password;
	}

	/**
	 * @param pHMC_OM_Password
	 *            the pHMC_OM_Password to set
	 */
	public void setPHMC_OM_Password(String pHMC_OM_Password) {
		PHMC_OM_Password = pHMC_OM_Password;
	}

	public Integer getPHMC_OM_RoleCode() {
		return PHMC_OM_RoleCode;
	}

	public void setPHMC_OM_RoleCode(Integer pHMC_OM_RoleCode) {
		PHMC_OM_RoleCode = pHMC_OM_RoleCode;
	}

	public String getPHMC_OM_Address1() {
		return PHMC_OM_Address1;
	}

	public void setPHMC_OM_Address1(String pHMC_OM_Address1) {
		PHMC_OM_Address1 = pHMC_OM_Address1;
	}

	public String getPHMC_OM_Address2() {
		return PHMC_OM_Address2;
	}

	public void setPHMC_OM_Address2(String pHMC_OM_Address2) {
		PHMC_OM_Address2 = pHMC_OM_Address2;
	}

	public String getPHMC_OM_Address3() {
		return PHMC_OM_Address3;
	}

	public void setPHMC_OM_Address3(String pHMC_OM_Address3) {
		PHMC_OM_Address3 = pHMC_OM_Address3;
	}

	public String getPHMC_OM_City() {
		return PHMC_OM_City;
	}

	public void setPHMC_OM_City(String pHMC_OM_City) {
		PHMC_OM_City = pHMC_OM_City;
	}

	public String getPHMC_OM_State() {
		return PHMC_OM_State;
	}

	public void setPHMC_OM_State(String pHMC_OM_State) {
		PHMC_OM_State = pHMC_OM_State;
	}

	public Integer getPHMC_OM_Pincode() {
		return PHMC_OM_Pincode;
	}

	public void setPHMC_OM_Pincode(Integer pHMC_OM_Pincode) {
		PHMC_OM_Pincode = pHMC_OM_Pincode;
	}

	public Long getPHMC_OM_Phone() {
		return PHMC_OM_Phone;
	}

	public void setPHMC_OM_Phone(Long pHMC_OM_Phone) {
		PHMC_OM_Phone = pHMC_OM_Phone;
	}

	public String getPHMC_OM_CreatedBy() {
		return PHMC_OM_CreatedBy;
	}

	public void setPHMC_OM_CreatedBy(String pHMC_OM_CreatedBy) {
		PHMC_OM_CreatedBy = pHMC_OM_CreatedBy;
	}

	public Integer getPHMC_OM_ActiveStatus() {
		return PHMC_OM_ActiveStatus;
	}

	public void setPHMC_OM_ActiveStatus(Integer pHMC_OM_ActiveStatus) {
		PHMC_OM_ActiveStatus = pHMC_OM_ActiveStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getPHMC_OM_EffectiveDate() {
		return PHMC_OM_EffectiveDate;
	}

	public void setPHMC_OM_EffectiveDate(Date pHMC_OM_EffectiveDate) {
		PHMC_OM_EffectiveDate = pHMC_OM_EffectiveDate;
	}

	public Date getPHMC_OM_EffectiveEndDate() {
		return PHMC_OM_EffectiveEndDate;
	}

	public void setPHMC_OM_EffectiveEndDate(Date pHMC_OM_EffectiveEndDate) {
		PHMC_OM_EffectiveEndDate = pHMC_OM_EffectiveEndDate;
	}

	@Override
	public String toString() {
		return "PHMC_OM_LOGIN [PHMC_OM_FirstName=" + PHMC_OM_FirstName + ", PHMC_OM_LastName=" + PHMC_OM_LastName
				+ ", PHMC_OM_Dob=" + PHMC_OM_Dob + ", PHMC_OM_Email=" + PHMC_OM_Email + ", PHMC_OM_UserName="
				+ PHMC_OM_UserName + ", PHMC_OM_Password=" + PHMC_OM_Password + ", PHMC_OM_Salt=" + PHMC_OM_Salt
				+ ", PHMC_OM_Lead=" + PHMC_OM_Lead + ", PHMC_OM_OnBoard=" + PHMC_OM_OnBoard + ", PHMC_OM_Billing="
				+ PHMC_OM_Billing + ", PHMC_OM_Admin=" + PHMC_OM_Admin + ", PHMC_OM_Supervisor=" + PHMC_OM_Supervisor
				+ ", PHMC_OM_UpdatedDate=" + PHMC_OM_UpdatedDate + ", PHMC_OM_UpdatedBy=" + PHMC_OM_UpdatedBy
				+ ", PHMC_OM_CreatedDate=" + PHMC_OM_CreatedDate + ", PHMC_OM_PCOStatus=" + PHMC_OM_PCOStatus
				+ ", PHMC_OM_PCOStatusList=" + PHMC_OM_PCOStatusList + ", PHMC_OM_PCOGeneralSearch="
				+ PHMC_OM_PCOGeneralSearch + ", PHMC_OM_PCOGeneralSearchRange=" + PHMC_OM_PCOGeneralSearchRange
				+ ", PHMC_OM_FutureField1=" + PHMC_OM_FutureField1 + ", PHMC_OM_FutureField2=" + PHMC_OM_FutureField2
				+ ", PHMC_OM_RoleCode=" + PHMC_OM_RoleCode + ", PHMC_OM_Address1=" + PHMC_OM_Address1
				+ ", PHMC_OM_Address2=" + PHMC_OM_Address2 + ", PHMC_OM_Address3=" + PHMC_OM_Address3
				+ ", PHMC_OM_City=" + PHMC_OM_City + ", PHMC_OM_State=" + PHMC_OM_State + ", PHMC_OM_Pincode="
				+ PHMC_OM_Pincode + ", PHMC_OM_Phone=" + PHMC_OM_Phone + ", PHMC_OM_CreatedBy=" + PHMC_OM_CreatedBy
				+ ", PHMC_OM_ActiveStatus=" + PHMC_OM_ActiveStatus + ", PHMC_OM_EffectiveDate=" + PHMC_OM_EffectiveDate
				+ ", PHMC_OM_EffectiveEndDate=" + PHMC_OM_EffectiveEndDate + "]";
	}

	

}
