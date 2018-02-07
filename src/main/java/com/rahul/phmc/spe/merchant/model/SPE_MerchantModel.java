package com.rahul.phmc.spe.merchant.model;
/**
 * @author rahul Makvana
 * 
 *         It contains all SPE_MERCHANT_DETAIL database fields and its
 *         setter and getter methods
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@XmlRootElement
@Entity
@Table(name = "SPE_MERCHANT_DETAIL")
@DynamicInsert
@DynamicUpdate
public class SPE_MerchantModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long SPE_SrNo;
	private String SPE_email;
	private String SPE_UserName;
	private String SPE_Password;
	private String SPE_Salt;
	private Date SPE_UpdatedDate;
	private String SPE_UpdatedBy;
	private Date SPE_CreatedDate;
	private Integer SPE_RoleCode;
	private String SPE_Address1;
	private String SPE_Address2;
	private String SPE_Address3;
	private String SPE_City;
	private String SPE_State;
	private Integer SPE_Pincode;
	private Long SPE_Phone;
	private String SPE_CreatedBy;
	private Integer SPE_ActiveStatus;
	private Date SPE_EffectiveDate;
	private Date SPE_EffectiveEndDate;
	private String SPE_PrimaryBankName;
	private Long SPE_PrimaryBankAcountNo;
	private String SPE_PrimaryBankBranchName;
	private String SPE_PrimaryBankAccountType;
	private String SPE_PrimaryIFSCCode;
	private Long SPE_PrimaryBankLinkedAadhaarNo;
	private String SPE_PrimaryBankVPA;
	private String SPE_SecondaryBankName;
	private Long SPE_SecondaryBankAcountNo;
	private String SPE_SecondaryBankBranchName;
	private String SPE_SecondaryBankAccountType;
	private String SPE_SecondaryIFSCCode;
	private Long SPE_SecondaryBankLinkedAadhaarNo;
	private String SPE_SecondaryBankVPA;
	private String SPE_PANCardNo;
	private Long SPE_AadhaarNo;
	private String SPE_GSTIN_Number;
	private Integer SPE_GSTIN_Flag;
	private String SPE_MerchantID;
	private String SPE_MerchantKey;
	private String SPE_MerchantTable;
	private Integer SPE_ServiceFlag1;
	private Integer SPE_ServiceFlag2;
	private Integer SPE_ServiceFlag3;
	private Integer SPE_ServiceFlag4;
	private Integer SPE_ServiceFlag5;
	private Integer SPE_ServiceFlag6;
	private Integer SPE_ServiceFlag7;
	private Integer SPE_ServiceFlag8;
	private Integer SPE_ServiceFlag9;
	private Integer SPE_ServiceFlag10;
	
	public Long getSPE_SrNo() {
		return SPE_SrNo;
	}
	public void setSPE_SrNo(Long sPE_SrNo) {
		SPE_SrNo = sPE_SrNo;
	}
	public String getSPE_email() {
		return SPE_email;
	}
	public void setSPE_email(String sPE_email) {
		SPE_email = sPE_email;
	}
	public String getSPE_UserName() {
		return SPE_UserName;
	}
	public void setSPE_UserName(String sPE_UserName) {
		SPE_UserName = sPE_UserName;
	}
	public String getSPE_Password() {
		return SPE_Password;
	}
	public void setSPE_Password(String sPE_Password) {
		SPE_Password = sPE_Password;
	}
	public String getSPE_Salt() {
		return SPE_Salt;
	}
	public void setSPE_Salt(String sPE_Salt) {
		SPE_Salt = sPE_Salt;
	}
	public Date getSPE_UpdatedDate() {
		return SPE_UpdatedDate;
	}
	public void setSPE_UpdatedDate(Date sPE_UpdatedDate) {
		SPE_UpdatedDate = sPE_UpdatedDate;
	}
	public String getSPE_UpdatedBy() {
		return SPE_UpdatedBy;
	}
	public void setSPE_UpdatedBy(String sPE_UpdatedBy) {
		SPE_UpdatedBy = sPE_UpdatedBy;
	}
	public Date getSPE_CreatedDate() {
		return SPE_CreatedDate;
	}
	public void setSPE_CreatedDate(Date sPE_CreatedDate) {
		SPE_CreatedDate = sPE_CreatedDate;
	}
	public Integer getSPE_RoleCode() {
		return SPE_RoleCode;
	}
	public void setSPE_RoleCode(Integer sPE_RoleCode) {
		SPE_RoleCode = sPE_RoleCode;
	}
	public String getSPE_Address1() {
		return SPE_Address1;
	}
	public void setSPE_Address1(String sPE_Address1) {
		SPE_Address1 = sPE_Address1;
	}
	public String getSPE_Address2() {
		return SPE_Address2;
	}
	public void setSPE_Address2(String sPE_Address2) {
		SPE_Address2 = sPE_Address2;
	}
	public String getSPE_Address3() {
		return SPE_Address3;
	}
	public void setSPE_Address3(String sPE_Address3) {
		SPE_Address3 = sPE_Address3;
	}
	public String getSPE_City() {
		return SPE_City;
	}
	public void setSPE_City(String sPE_City) {
		SPE_City = sPE_City;
	}
	public String getSPE_State() {
		return SPE_State;
	}
	public void setSPE_State(String sPE_State) {
		SPE_State = sPE_State;
	}
	public Integer getSPE_Pincode() {
		return SPE_Pincode;
	}
	public void setSPE_Pincode(Integer sPE_Pincode) {
		SPE_Pincode = sPE_Pincode;
	}
	public Long getSPE_Phone() {
		return SPE_Phone;
	}
	public void setSPE_Phone(Long sPE_Phone) {
		SPE_Phone = sPE_Phone;
	}
	public String getSPE_CreatedBy() {
		return SPE_CreatedBy;
	}
	public void setSPE_CreatedBy(String sPE_CreatedBy) {
		SPE_CreatedBy = sPE_CreatedBy;
	}
	public Integer getSPE_ActiveStatus() {
		return SPE_ActiveStatus;
	}
	public void setSPE_ActiveStatus(Integer sPE_ActiveStatus) {
		SPE_ActiveStatus = sPE_ActiveStatus;
	}
	public Date getSPE_EffectiveDate() {
		return SPE_EffectiveDate;
	}
	public void setSPE_EffectiveDate(Date sPE_EffectiveDate) {
		SPE_EffectiveDate = sPE_EffectiveDate;
	}
	public Date getSPE_EffectiveEndDate() {
		return SPE_EffectiveEndDate;
	}
	public void setSPE_EffectiveEndDate(Date sPE_EffectiveEndDate) {
		SPE_EffectiveEndDate = sPE_EffectiveEndDate;
	}
	public String getSPE_PrimaryBankName() {
		return SPE_PrimaryBankName;
	}
	public void setSPE_PrimaryBankName(String sPE_PrimaryBankName) {
		SPE_PrimaryBankName = sPE_PrimaryBankName;
	}
	public Long getSPE_PrimaryBankAcountNo() {
		return SPE_PrimaryBankAcountNo;
	}
	public void setSPE_PrimaryBankAcountNo(Long sPE_PrimaryBankAcountNo) {
		SPE_PrimaryBankAcountNo = sPE_PrimaryBankAcountNo;
	}
	public String getSPE_PrimaryBankBranchName() {
		return SPE_PrimaryBankBranchName;
	}
	public void setSPE_PrimaryBankBranchName(String sPE_PrimaryBankBranchName) {
		SPE_PrimaryBankBranchName = sPE_PrimaryBankBranchName;
	}
	public String getSPE_PrimaryBankAccountType() {
		return SPE_PrimaryBankAccountType;
	}
	public void setSPE_PrimaryBankAccountType(String sPE_PrimaryBankAccountType) {
		SPE_PrimaryBankAccountType = sPE_PrimaryBankAccountType;
	}
	public String getSPE_PrimaryIFSCCode() {
		return SPE_PrimaryIFSCCode;
	}
	public void setSPE_PrimaryIFSCCode(String sPE_PrimaryIFSCCode) {
		SPE_PrimaryIFSCCode = sPE_PrimaryIFSCCode;
	}
	public Long getSPE_PrimaryBankLinkedAadhaarNo() {
		return SPE_PrimaryBankLinkedAadhaarNo;
	}
	public void setSPE_PrimaryBankLinkedAadhaarNo(Long sPE_PrimaryBankLinkedAadhaarNo) {
		SPE_PrimaryBankLinkedAadhaarNo = sPE_PrimaryBankLinkedAadhaarNo;
	}
	
	public String getSPE_PrimaryBankVPA() {
		return SPE_PrimaryBankVPA;
	}
	public void setSPE_PrimaryBankVPA(String sPE_PrimaryBankVPA) {
		SPE_PrimaryBankVPA = sPE_PrimaryBankVPA;
	}
	public String getSPE_SecondaryBankName() {
		return SPE_SecondaryBankName;
	}
	public void setSPE_SecondaryBankName(String sPE_SecondaryBankName) {
		SPE_SecondaryBankName = sPE_SecondaryBankName;
	}
	public Long getSPE_SecondaryBankAcountNo() {
		return SPE_SecondaryBankAcountNo;
	}
	public void setSPE_SecondaryBankAcountNo(Long sPE_SecondaryBankAcountNo) {
		SPE_SecondaryBankAcountNo = sPE_SecondaryBankAcountNo;
	}
	public String getSPE_SecondaryBankBranchName() {
		return SPE_SecondaryBankBranchName;
	}
	public void setSPE_SecondaryBankBranchName(String sPE_SecondaryBankBranchName) {
		SPE_SecondaryBankBranchName = sPE_SecondaryBankBranchName;
	}
	public String getSPE_SecondaryBankAccountType() {
		return SPE_SecondaryBankAccountType;
	}
	public void setSPE_SecondaryBankAccountType(String sPE_SecondaryBankAccountType) {
		SPE_SecondaryBankAccountType = sPE_SecondaryBankAccountType;
	}
	public String getSPE_SecondaryIFSCCode() {
		return SPE_SecondaryIFSCCode;
	}
	public void setSPE_SecondaryIFSCCode(String sPE_SecondaryIFSCCode) {
		SPE_SecondaryIFSCCode = sPE_SecondaryIFSCCode;
	}
	public Long getSPE_SecondaryBankLinkedAadhaarNo() {
		return SPE_SecondaryBankLinkedAadhaarNo;
	}
	public void setSPE_SecondaryBankLinkedAadhaarNo(Long sPE_SecondaryBankLinkedAadhaarNo) {
		SPE_SecondaryBankLinkedAadhaarNo = sPE_SecondaryBankLinkedAadhaarNo;
	}
	public String getSPE_SecondaryBankVPA() {
		return SPE_SecondaryBankVPA;
	}
	public void setSPE_SecondaryBankVPA(String sPE_SecondaryBankVPA) {
		SPE_SecondaryBankVPA = sPE_SecondaryBankVPA;
	}
	public String getSPE_PANCardNo() {
		return SPE_PANCardNo;
	}
	public void setSPE_PANCardNo(String sPE_PANCardNo) {
		SPE_PANCardNo = sPE_PANCardNo;
	}
	public Long getSPE_AadhaarNo() {
		return SPE_AadhaarNo;
	}
	public void setSPE_AadhaarNo(Long sPE_AadhaarNo) {
		SPE_AadhaarNo = sPE_AadhaarNo;
	}
	public String getSPE_GSTIN_Number() {
		return SPE_GSTIN_Number;
	}
	public void setSPE_GSTIN_Number(String sPE_GSTIN_Number) {
		SPE_GSTIN_Number = sPE_GSTIN_Number;
	}
	public Integer getSPE_GSTIN_Flag() {
		return SPE_GSTIN_Flag;
	}
	public void setSPE_GSTIN_Flag(Integer sPE_GSTIN_Flag) {
		SPE_GSTIN_Flag = sPE_GSTIN_Flag;
	}
	public String getSPE_MerchantID() {
		return SPE_MerchantID;
	}
	public void setSPE_MerchantID(String sPE_MerchantID) {
		SPE_MerchantID = sPE_MerchantID;
	}
	public String getSPE_MerchantKey() {
		return SPE_MerchantKey;
	}
	public void setSPE_MerchantKey(String sPE_MerchantKey) {
		SPE_MerchantKey = sPE_MerchantKey;
	}
	public String getSPE_MerchantTable() {
		return SPE_MerchantTable;
	}
	public void setSPE_MerchantTable(String sPE_MerchantTable) {
		SPE_MerchantTable = sPE_MerchantTable;
	}
	public Integer getSPE_ServiceFlag1() {
		return SPE_ServiceFlag1;
	}
	public void setSPE_ServiceFlag1(Integer sPE_ServiceFlag1) {
		SPE_ServiceFlag1 = sPE_ServiceFlag1;
	}
	public Integer getSPE_ServiceFlag2() {
		return SPE_ServiceFlag2;
	}
	public void setSPE_ServiceFlag2(Integer sPE_ServiceFlag2) {
		SPE_ServiceFlag2 = sPE_ServiceFlag2;
	}
	public Integer getSPE_ServiceFlag3() {
		return SPE_ServiceFlag3;
	}
	public void setSPE_ServiceFlag3(Integer sPE_ServiceFlag3) {
		SPE_ServiceFlag3 = sPE_ServiceFlag3;
	}
	public Integer getSPE_ServiceFlag4() {
		return SPE_ServiceFlag4;
	}
	public void setSPE_ServiceFlag4(Integer sPE_ServiceFlag4) {
		SPE_ServiceFlag4 = sPE_ServiceFlag4;
	}
	public Integer getSPE_ServiceFlag5() {
		return SPE_ServiceFlag5;
	}
	public void setSPE_ServiceFlag5(Integer sPE_ServiceFlag5) {
		SPE_ServiceFlag5 = sPE_ServiceFlag5;
	}
	public Integer getSPE_ServiceFlag6() {
		return SPE_ServiceFlag6;
	}
	public void setSPE_ServiceFlag6(Integer sPE_ServiceFlag6) {
		SPE_ServiceFlag6 = sPE_ServiceFlag6;
	}
	public Integer getSPE_ServiceFlag7() {
		return SPE_ServiceFlag7;
	}
	public void setSPE_ServiceFlag7(Integer sPE_ServiceFlag7) {
		SPE_ServiceFlag7 = sPE_ServiceFlag7;
	}
	public Integer getSPE_ServiceFlag8() {
		return SPE_ServiceFlag8;
	}
	public void setSPE_ServiceFlag8(Integer sPE_ServiceFlag8) {
		SPE_ServiceFlag8 = sPE_ServiceFlag8;
	}
	public Integer getSPE_ServiceFlag9() {
		return SPE_ServiceFlag9;
	}
	public void setSPE_ServiceFlag9(Integer sPE_ServiceFlag9) {
		SPE_ServiceFlag9 = sPE_ServiceFlag9;
	}
	public Integer getSPE_ServiceFlag10() {
		return SPE_ServiceFlag10;
	}
	public void setSPE_ServiceFlag10(Integer sPE_ServiceFlag10) {
		SPE_ServiceFlag10 = sPE_ServiceFlag10;
	}
	@Override
	public String toString() {
		return "SPE_MerchantModel [SPE_SrNo=" + SPE_SrNo + ", SPE_email=" + SPE_email + ", SPE_UserName=" + SPE_UserName
				+ ", SPE_Password=" + SPE_Password + ", SPE_Salt=" + SPE_Salt + ", SPE_UpdatedDate=" + SPE_UpdatedDate
				+ ", SPE_UpdatedBy=" + SPE_UpdatedBy + ", SPE_CreatedDate=" + SPE_CreatedDate + ", SPE_RoleCode="
				+ SPE_RoleCode + ", SPE_Address1=" + SPE_Address1 + ", SPE_Address2=" + SPE_Address2 + ", SPE_Address3="
				+ SPE_Address3 + ", SPE_City=" + SPE_City + ", SPE_State=" + SPE_State + ", SPE_Pincode=" + SPE_Pincode
				+ ", SPE_Phone=" + SPE_Phone + ", SPE_CreatedBy=" + SPE_CreatedBy + ", SPE_ActiveStatus="
				+ SPE_ActiveStatus + ", SPE_EffectiveDate=" + SPE_EffectiveDate + ", SPE_EffectiveEndDate="
				+ SPE_EffectiveEndDate + ", SPE_PrimaryBankName=" + SPE_PrimaryBankName + ", SPE_PrimaryBankAcountNo="
				+ SPE_PrimaryBankAcountNo + ", SPE_PrimaryBankBranchName=" + SPE_PrimaryBankBranchName
				+ ", SPE_PrimaryBankAccountType=" + SPE_PrimaryBankAccountType + ", SPE_PrimaryIFSCCode="
				+ SPE_PrimaryIFSCCode + ", SPE_PrimaryBankLinkedAadhaarNo=" + SPE_PrimaryBankLinkedAadhaarNo
				+ ", SPE_PrimaryBankVPA=" + SPE_PrimaryBankVPA + ", SPE_SecondaryBankName=" + SPE_SecondaryBankName
				+ ", SPE_SecondaryBankAcountNo=" + SPE_SecondaryBankAcountNo + ", SPE_SecondaryBankBranchName="
				+ SPE_SecondaryBankBranchName + ", SPE_SecondaryBankAccountType=" + SPE_SecondaryBankAccountType
				+ ", SPE_SecondaryIFSCCode=" + SPE_SecondaryIFSCCode + ", SPE_SecondaryBankLinkedAadhaarNo="
				+ SPE_SecondaryBankLinkedAadhaarNo + ", SPE_SecondaryBankVPA=" + SPE_SecondaryBankVPA
				+ ", SPE_PANCardNo=" + SPE_PANCardNo + ", SPE_AadhaarNo=" + SPE_AadhaarNo + ", SPE_GSTIN_Number="
				+ SPE_GSTIN_Number + ", SPE_GSTIN_Flag=" + SPE_GSTIN_Flag + ", SPE_MerchantID=" + SPE_MerchantID
				+ ", SPE_MerchantKey=" + SPE_MerchantKey + ", SPE_MerchantTable=" + SPE_MerchantTable
				+ ", SPE_ServiceFlag1=" + SPE_ServiceFlag1 + ", SPE_ServiceFlag2=" + SPE_ServiceFlag2
				+ ", SPE_ServiceFlag3=" + SPE_ServiceFlag3 + ", SPE_ServiceFlag4=" + SPE_ServiceFlag4
				+ ", SPE_ServiceFlag5=" + SPE_ServiceFlag5 + ", SPE_ServiceFlag6=" + SPE_ServiceFlag6
				+ ", SPE_ServiceFlag7=" + SPE_ServiceFlag7 + ", SPE_ServiceFlag8=" + SPE_ServiceFlag8
				+ ", SPE_ServiceFlag9=" + SPE_ServiceFlag9 + ", SPE_ServiceFlag10=" + SPE_ServiceFlag10 + "]";
	}
	
	
	
		
}
