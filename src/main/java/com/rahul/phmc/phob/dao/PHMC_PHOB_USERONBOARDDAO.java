package com.rahul.phmc.phob.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rahul.phmc.phob.model.PHMC_PHOB_ONBOARD;
import com.rahul.phmc.phob.model.PHMC_PHOB_USER;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.PHMC_DB_ERROR;
import com.rahul.phmc.util.Payhind_DBManager;

public class PHMC_PHOB_USERONBOARDDAO {

	private PHMC_PHOB_USER phmc_phob_pco;
	private ArrayList<PHMC_PHOB_USER> phmc_phob_pcoOnboardList;
	private ResultSet phmc_rs;

	/**
	 * @param phmc_phob_pcoID
	 * @return
	 */
	public PHMC_PHOB_USER phmc_pco_readPCOWithOnboardDetail(Long phmc_phob_pcoID) {

		String phmc_selectQuary = "SELECT  u.PHOB_UserSrNo, u.PHOB_PCOID, u.PHOB_Email, u.PHOB_Phone , u.PHOB_Password, u.PHOB_Salt "
				+ ", u.PHOB_PCORoles, u.PHOB_UpdatedDate, u.PHOB_UpdatedBy, u.PHOB_Terms, u.PHOB_WelcomeMail, u.PHOB_Created as PHOB_userDate, u.PHOB_ResetPasswordToken "
				+ ", u.PHOB_SignUp, u.PHOB_ResetPasswordExpired, u.PHOB_PCONotes, u.PHOB_KycSrNo, u.PHOB_KYCEverythingValid, u.PHOB_FollowUpFollowUpStatus "
				+ ", u.PHOB_FollowUpFollowUpStatusList , u.PHOB_FollowUpGeneralSearch , u.PHOB_FollowUpGeneralsearchRange , u.PHOB_BasicDetailsIsFilled "
				+ ", u.PHOB_BasicDetailsFirstName , u.PHOB_BasicDetailsLastName , u.PHOB_BasicDetailsNatureOfBussiness, u.PHOB_BasicDetailsIfAnyAboutBussiness"
				+ ", u.PHOB_BasicDetailsHowYouKnow , u.PHOB_BasicDetailsComAddressOne ,u.PHOB_BasicDetailsComAddressTwo, u.PHOB_BasicDetailsComAddressThree "
				+ ", u.PHOB_BasicDetailsComCity, u.PHOB_BasicDetailsComState, u.PHOB_BasicDetailsComPincode "
				+ ", u.PHOB_KycStatusIsKycVerifiedByOfficial,u.PHOB_KycStatusIsWalletCreated , u.PHOB_KycStatusIsActivation, u.PHOB_KycStatusIsOtpSession "
				+ ", u.PHOB_KycStatusPremilinaryReview, u.PHOB_KycStatusRemarks, u.PHOB_Future_Field1 , u.PHOB_Future_Field2 , u.PHOB_Future_Field3 , u.PHOB_Future_Field4 , u.PHOB_Future_Field5"
				+ ", u.PHOB_Future_Field6, u.PHOB_OTPDate, u.PHOB_OTPTime, k.PHOB_PersonalDetailsFullName ,k.PHOB_PersonalDetailsPictureURL, k.PHOB_PersonalDetailsPicture "
				+ ", k.PHOB_PersonalDetailsDob, k.PHOB_PersonalDetailsMotherName, k.PHOB_PersonalDetailsGender, k.PHOB_BusinessDetailsBusinessName "
				+ ", k.PHOB_BusinessDetailsNatureofBusiness, k.PHOB_BusinessDetailsIfany, k.PHOB_CommunicationDetailsPersonalAddressAddressline1 "
				+ ", k.PHOB_CommunicationDetailsPersonalAddressAddressline2, k.PHOB_CommunicationDetailsPersonalAddressAddressline3, k.PHOB_CommunicationDetailsPersonalAddressPersonalcity "
				+ ", k.PHOB_CommunicationDetailsPersonalAddressPersonalState, k.PHOB_CommunicationDetailsPersonalAddressPersonalpin, k.PHOB_CommunicationDetailsBusinessAddressAddressline1 "
				+ ", k.PHOB_CommunicationDetailsBusinessAddressAddressline2, k.PHOB_CommunicationDetailsBusinessAddressAddressline3, k.PHOB_CommunicationDetailsBusinessAddressBusinesscity "
				+ ", k.PHOB_CommunicationDetailsBusinessAddressBusinessstate, k.PHOB_CommunicationDetailsBusinessAddressBusinesspin, k.PHOB_BankDetailsBankName "
				+ ", k.PHOB_BankDetailsBankAccountNumber, k.PHOB_BankDetailsBankBranch, k.PHOB_BankDetailsAccountType, k.PHOB_BankDetailsIfscCode, k.PHOB_DocumentDetailsPanFileURL, k.PHOB_DocumentDetailsPanFile "
				+ ", k.PHOB_DocumentDetailsResidenceFileURLFrontSide,k.PHOB_DocumentDetailsResidenceFileFrontSide,  k.PHOB_DocumentDetailsResidenceFileURLBackSide, k.PHOB_DocumentDetailsResidenceFileBackSide, k.PHOB_DocumentDetailsBusinessFileURL "
				+ ", k.PHOB_DocumentDetailsBusinessFile, k.PHOB_DocumentDetailsPCOSignatureURL, k.PHOB_DocumentDetailsPCOSignature, k.PHOB_DocumentDetailsIfany, k.PHOB_DocumentDetailsAgreement, k.PHOB_Created as PHOB_kycDate, k.PHOB_User, k.PHOB_KYCUPdateDate "
				+ ", k.PHOB_KYCUpdatedBy FROM PHMC_PHOB_USER as u Join PHMC_PHOB_ONBOARD as k on u.PHOB_PCOID=k.PHOB_User where u.PHOB_PCOID= ?";

		System.out.println(phmc_selectQuary);

		// get Database Connection
		try (Connection phmc_conn = Payhind_DBManager.payhind_getConnection();
				PreparedStatement phmc_pst = phmc_conn.prepareStatement(phmc_selectQuary)) {

			phmc_pst.setLong(1, phmc_phob_pcoID);
			

			phmc_rs = phmc_pst.executeQuery();

			while (phmc_rs.next()) {

				// System.out.println(sopdb_rs.getRow());
				phmc_phob_pco = new PHMC_PHOB_USER();
				PHMC_PHOB_ONBOARD phmc_phob_kyc = new PHMC_PHOB_ONBOARD();

				phmc_phob_pco.setPHOB_UserSrNo(phmc_rs.getLong("PHOB_UserSrNo"));
				phmc_phob_pco.setPHOB_PCOID(phmc_rs.getLong("PHOB_PCOID"));
				phmc_phob_pco.setPHOB_Email(phmc_rs.getString("PHOB_Email"));
				phmc_phob_pco.setPHOB_Phone(phmc_rs.getLong("PHOB_Phone"));
				phmc_phob_pco.setPHOB_Password(phmc_rs.getString("PHOB_Password"));
				phmc_phob_pco.setPHOB_Salt(phmc_rs.getString("PHOB_Salt"));
				phmc_phob_pco.setPHOB_PCORoles(phmc_rs.getString("PHOB_PCORoles"));
				phmc_phob_pco.setPHOB_UpdatedDate(phmc_rs.getDate("PHOB_UpdatedDate"));
				phmc_phob_pco.setPHOB_UpdatedBy(phmc_rs.getString("PHOB_UpdatedBy"));
				phmc_phob_pco.setPHOB_Terms(phmc_rs.getString("PHOB_Terms"));
				phmc_phob_pco.setPHOB_WelcomeMail(phmc_rs.getString("PHOB_WelcomeMail"));
				phmc_phob_pco.setPHOB_Created(phmc_rs.getDate("PHOB_userDate"));
				phmc_phob_pco.setPHOB_ResetPasswordToken(phmc_rs.getInt("PHOB_ResetPasswordToken"));
				phmc_phob_pco.setPHOB_SignUp(phmc_rs.getString("PHOB_SignUp"));
				phmc_phob_pco.setPHOB_ResetPasswordExpired(phmc_rs.getDate("PHOB_ResetPasswordExpired"));
				phmc_phob_pco.setPHOB_PCONotes(phmc_rs.getString("PHOB_PCONotes"));
				phmc_phob_pco.setPHOB_KycSrNo(phmc_rs.getLong("PHOB_KycSrNo"));
				phmc_phob_pco.setPHOB_KYCEverythingValid(phmc_rs.getString("PHOB_KYCEverythingValid"));
				phmc_phob_pco.setPHOB_FollowUpFollowUpStatus(phmc_rs.getString("PHOB_FollowUpFollowUpStatus"));
				phmc_phob_pco.setPHOB_FollowUpFollowUpStatusList(phmc_rs.getString("PHOB_FollowUpFollowUpStatusList"));
				phmc_phob_pco.setPHOB_FollowUpGeneralSearch(phmc_rs.getString("PHOB_FollowUpGeneralSearch"));
				phmc_phob_pco.setPHOB_FollowUpGeneralsearchRange(phmc_rs.getString("PHOB_FollowUpGeneralsearchRange"));
				phmc_phob_pco.setPHOB_BasicDetailsIsFilled(phmc_rs.getString("PHOB_BasicDetailsIsFilled"));
				phmc_phob_pco.setPHOB_BasicDetailsFirstName(phmc_rs.getString("PHOB_BasicDetailsFirstName"));
				phmc_phob_pco.setPHOB_BasicDetailsLastName(phmc_rs.getString("PHOB_BasicDetailsLastName"));
				phmc_phob_pco
						.setPHOB_BasicDetailsNatureOfBussiness(phmc_rs.getString("PHOB_BasicDetailsNatureOfBussiness"));
				phmc_phob_pco.setPHOB_BasicDetailsIfAnyAboutBussiness(
						phmc_rs.getString("PHOB_BasicDetailsIfAnyAboutBussiness"));
				phmc_phob_pco.setPHOB_BasicDetailsHowYouKnow(phmc_rs.getString("PHOB_BasicDetailsHowYouKnow"));
				phmc_phob_pco.setPHOB_BasicDetailsComAddressOne(phmc_rs.getString("PHOB_BasicDetailsComAddressOne"));
				phmc_phob_pco.setPHOB_BasicDetailsComAddressTwo(phmc_rs.getString("PHOB_BasicDetailsComAddressTwo"));
				phmc_phob_pco
						.setPHOB_BasicDetailsComAddressThree(phmc_rs.getString("PHOB_BasicDetailsComAddressThree"));
				phmc_phob_pco.setPHOB_BasicDetailsComCity(phmc_rs.getString("PHOB_BasicDetailsComCity"));
				phmc_phob_pco.setPHOB_BasicDetailsComState(phmc_rs.getString("PHOB_BasicDetailsComState"));
				phmc_phob_pco.setPHOB_BasicDetailsComPincode(phmc_rs.getInt("PHOB_BasicDetailsComPincode"));
				phmc_phob_pco.setPHOB_KycStatusIsKycVerifiedByOfficial(
						phmc_rs.getString("PHOB_KycStatusIsKycVerifiedByOfficial"));
				phmc_phob_pco.setPHOB_KycStatusIsWalletCreated(phmc_rs.getString("PHOB_KycStatusIsWalletCreated"));
				phmc_phob_pco.setPHOB_KycStatusIsActivation(phmc_rs.getString("PHOB_KycStatusIsActivation"));
				phmc_phob_pco.setPHOB_KycStatusIsOtpSession(phmc_rs.getString("PHOB_KycStatusIsOtpSession"));
				phmc_phob_pco.setPHOB_KycStatusPremilinaryReview(phmc_rs.getString("PHOB_KycStatusPremilinaryReview"));
				phmc_phob_pco.setPHOB_KycStatusRemarks(phmc_rs.getString("PHOB_KycStatusRemarks"));
				phmc_phob_pco.setPHOB_Future_Field1(phmc_rs.getString("PHOB_Future_Field1"));
				phmc_phob_pco.setPHOB_Future_Field2(phmc_rs.getString("PHOB_Future_Field2"));
				phmc_phob_pco.setPHOB_Future_Field3(phmc_rs.getString("PHOB_Future_Field3"));
				phmc_phob_pco.setPHOB_Future_Field4(phmc_rs.getString("PHOB_Future_Field4"));
				phmc_phob_pco.setPHOB_Future_Field5(phmc_rs.getString("PHOB_Future_Field5"));
				phmc_phob_pco.setPHOB_Future_Field6(phmc_rs.getString("PHOB_Future_Field6"));
				phmc_phob_pco.setPHOB_OTPDate(phmc_rs.getDate("PHOB_OTPDate"));
				phmc_phob_pco.setPHOB_OTPTime(phmc_rs.getString("PHOB_OTPTime"));

				phmc_phob_kyc.setPHOB_PersonalDetailsFullName(phmc_rs.getString("PHOB_PersonalDetailsFullName"));
				phmc_phob_kyc.setPHOB_PersonalDetailsPictureURL(phmc_rs.getString("PHOB_PersonalDetailsPictureURL"));
				phmc_phob_kyc.setPHOB_PersonalDetailsPicture(phmc_rs.getString("PHOB_PersonalDetailsPicture"));
				phmc_phob_kyc.setPHOB_PersonalDetailsDob(phmc_rs.getDate("PHOB_PersonalDetailsDob"));
				phmc_phob_kyc.setPHOB_PersonalDetailsMotherName(phmc_rs.getString("PHOB_PersonalDetailsMotherName"));
				phmc_phob_kyc.setPHOB_PersonalDetailsGender(phmc_rs.getString("PHOB_PersonalDetailsGender"));
				phmc_phob_kyc
						.setPHOB_BusinessDetailsBusinessName(phmc_rs.getString("PHOB_BusinessDetailsBusinessName"));
				phmc_phob_kyc.setPHOB_BusinessDetailsNatureofBusiness(
						phmc_rs.getString("PHOB_BusinessDetailsNatureofBusiness"));
				phmc_phob_kyc.setPHOB_BusinessDetailsIfany(phmc_rs.getString("PHOB_BusinessDetailsIfany"));

				phmc_phob_kyc.setPHOB_CommunicationDetailsPersonalAddressAddressline1(
						phmc_rs.getString("PHOB_CommunicationDetailsPersonalAddressAddressline1"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsPersonalAddressAddressline2(
						phmc_rs.getString("PHOB_CommunicationDetailsPersonalAddressAddressline2"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsPersonalAddressAddressline3(
						phmc_rs.getString("PHOB_CommunicationDetailsPersonalAddressAddressline3"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsPersonalAddressPersonalcity(
						phmc_rs.getString("PHOB_CommunicationDetailsPersonalAddressPersonalcity"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsPersonalAddressPersonalState(
						phmc_rs.getString("PHOB_CommunicationDetailsPersonalAddressPersonalState"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsPersonalAddressPersonalpin(
						phmc_rs.getString("PHOB_CommunicationDetailsPersonalAddressPersonalpin"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsBusinessAddressAddressline1(
						phmc_rs.getString("PHOB_CommunicationDetailsBusinessAddressAddressline1"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsBusinessAddressAddressline2(
						phmc_rs.getString("PHOB_CommunicationDetailsBusinessAddressAddressline2"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsBusinessAddressAddressline3(
						phmc_rs.getString("PHOB_CommunicationDetailsBusinessAddressAddressline3"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsBusinessAddressBusinesscity(
						phmc_rs.getString("PHOB_CommunicationDetailsBusinessAddressBusinesscity"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsBusinessAddressBusinessstate(
						phmc_rs.getString("PHOB_CommunicationDetailsBusinessAddressBusinessstate"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsBusinessAddressBusinesspin(
						phmc_rs.getString("PHOB_CommunicationDetailsBusinessAddressBusinesspin"));
				phmc_phob_kyc.setPHOB_BankDetailsBankName(phmc_rs.getString("PHOB_BankDetailsBankName"));
				phmc_phob_kyc
						.setPHOB_BankDetailsBankAccountNumber(phmc_rs.getLong("PHOB_BankDetailsBankAccountNumber"));
				phmc_phob_kyc.setPHOB_BankDetailsBankBranch(phmc_rs.getString("PHOB_BankDetailsBankBranch"));
				phmc_phob_kyc.setPHOB_BankDetailsAccountType(phmc_rs.getString("PHOB_BankDetailsAccountType"));
				phmc_phob_kyc.setPHOB_BankDetailsIfscCode(phmc_rs.getString("PHOB_BankDetailsIfscCode"));
				phmc_phob_kyc.setPHOB_DocumentDetailsPanFileURL(phmc_rs.getString("PHOB_DocumentDetailsPanFileURL"));
				phmc_phob_kyc.setPHOB_DocumentDetailsPanFile(phmc_rs.getString("PHOB_DocumentDetailsPanFile"));
				phmc_phob_kyc.setPHOB_DocumentDetailsResidenceFileURLFrontSide(
						phmc_rs.getString("PHOB_DocumentDetailsResidenceFileURLFrontSide"));
				phmc_phob_kyc.setPHOB_DocumentDetailsResidenceFileFrontSide(
						phmc_rs.getString("PHOB_DocumentDetailsResidenceFileFrontSide"));
				phmc_phob_kyc.setPHOB_DocumentDetailsResidenceFileURLBackSide(
						phmc_rs.getString("PHOB_DocumentDetailsResidenceFileURLBackSide"));
				phmc_phob_kyc.setPHOB_DocumentDetailsResidenceFileBackSide(
						phmc_rs.getString("PHOB_DocumentDetailsResidenceFileBackSide"));
				phmc_phob_kyc.setPHOB_DocumentDetailsBusinessFileURL(
						phmc_rs.getString("PHOB_DocumentDetailsBusinessFileURL"));
				phmc_phob_kyc.setPHOB_DocumentDetailsBusinessFile(
						phmc_rs.getString("PHOB_DocumentDetailsBusinessFile"));
				phmc_phob_kyc.setPHOB_DocumentDetailsPCOSignatureURL(
						phmc_rs.getString("PHOB_DocumentDetailsPCOSignatureURL"));
				phmc_phob_kyc.setPHOB_DocumentDetailsPCOSignature(
						phmc_rs.getString("PHOB_DocumentDetailsPCOSignature"));
				phmc_phob_kyc.setPHOB_DocumentDetailsIfany(phmc_rs.getString("PHOB_DocumentDetailsIfany"));
				phmc_phob_kyc.setPHOB_DocumentDetailsAgreement(phmc_rs.getString("PHOB_DocumentDetailsAgreement"));
				phmc_phob_kyc.setPHOB_Created(phmc_rs.getDate("PHOB_kycDate"));
				phmc_phob_kyc.setPHOB_User(phmc_rs.getLong("PHOB_User"));
				phmc_phob_kyc.setPHOB_KYCUPdateDate(phmc_rs.getDate("PHOB_KYCUPdateDate"));
				phmc_phob_kyc.setPHOB_KYCUpdatedBy(phmc_rs.getString("PHOB_KYCUpdatedBy"));
				
				phmc_phob_pco.setOnBoard(phmc_phob_kyc);

			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return phmc_phob_pco;

	}
	/**
	 * @param phmc_phob_pcoID
	 * @return
	 */
	public ArrayList<PHMC_PHOB_USER> phmc_pco_readPCOWithOnboard(Integer phmc_om_pageStart, Integer phmc_om_size, String whereCluase) {

		String phmc_selectQuary = "SELECT u.PHOB_UserSrNo, u.PHOB_PCOID, u.PHOB_Email, u.PHOB_Phone , u.PHOB_Password, u.PHOB_Salt "
				+ ", u.PHOB_PCORoles, u.PHOB_UpdatedDate, u.PHOB_UpdatedBy, u.PHOB_Terms, u.PHOB_WelcomeMail, u.PHOB_Created as PHOB_userDate, u.PHOB_ResetPasswordToken "
				+ ", u.PHOB_SignUp, u.PHOB_ResetPasswordExpired, u.PHOB_PCONotes, u.PHOB_KycSrNo, u.PHOB_KYCEverythingValid, u.PHOB_FollowUpFollowUpStatus "
				+ ", u.PHOB_FollowUpFollowUpStatusList , u.PHOB_FollowUpGeneralSearch , u.PHOB_FollowUpGeneralsearchRange , u.PHOB_BasicDetailsIsFilled "
				+ ", u.PHOB_BasicDetailsFirstName , u.PHOB_BasicDetailsLastName , u.PHOB_BasicDetailsNatureOfBussiness, u.PHOB_BasicDetailsIfAnyAboutBussiness"
				+ ", u.PHOB_BasicDetailsHowYouKnow , u.PHOB_BasicDetailsComAddressOne ,u.PHOB_BasicDetailsComAddressTwo, u.PHOB_BasicDetailsComAddressThree "
				+ ", u.PHOB_BasicDetailsComCity, u.PHOB_BasicDetailsComState, u.PHOB_BasicDetailsComPincode "
				+ ", u.PHOB_KycStatusIsKycVerifiedByOfficial,u.PHOB_KycStatusIsWalletCreated , u.PHOB_KycStatusIsActivation, u.PHOB_KycStatusIsOtpSession "
				+ ", u.PHOB_KycStatusPremilinaryReview, u.PHOB_KycStatusRemarks, u.PHOB_Future_Field1 , u.PHOB_Future_Field2 , u.PHOB_Future_Field3 , u.PHOB_Future_Field4 , u.PHOB_Future_Field5"
				+ ", u.PHOB_Future_Field6, u.PHOB_OTPDate, u.PHOB_OTPTime, k.PHOB_KycSrNo, k.PHOB_PersonalDetailsFullName ,k.PHOB_PersonalDetailsPictureURL, k.PHOB_PersonalDetailsPicture "
				+ ", k.PHOB_PersonalDetailsDob, k.PHOB_PersonalDetailsMotherName, k.PHOB_PersonalDetailsGender, k.PHOB_BusinessDetailsBusinessName "
				+ ", k.PHOB_BusinessDetailsNatureofBusiness, k.PHOB_BusinessDetailsIfany, k.PHOB_CommunicationDetailsPersonalAddressAddressline1 "
				+ ", k.PHOB_CommunicationDetailsPersonalAddressAddressline2, k.PHOB_CommunicationDetailsPersonalAddressAddressline3, k.PHOB_CommunicationDetailsPersonalAddressPersonalcity "
				+ ", k.PHOB_CommunicationDetailsPersonalAddressPersonalState, k.PHOB_CommunicationDetailsPersonalAddressPersonalpin, k.PHOB_CommunicationDetailsBusinessAddressAddressline1 "
				+ ", k.PHOB_CommunicationDetailsBusinessAddressAddressline2, k.PHOB_CommunicationDetailsBusinessAddressAddressline3, k.PHOB_CommunicationDetailsBusinessAddressBusinesscity "
				+ ", k.PHOB_CommunicationDetailsBusinessAddressBusinessstate, k.PHOB_CommunicationDetailsBusinessAddressBusinesspin, k.PHOB_BankDetailsBankName "
				+ ", k.PHOB_BankDetailsBankAccountNumber, k.PHOB_BankDetailsBankBranch, k.PHOB_BankDetailsAccountType, k.PHOB_BankDetailsIfscCode, k.PHOB_DocumentDetailsPanFileURL, k.PHOB_DocumentDetailsPanFile "
				+ ", k.PHOB_DocumentDetailsResidenceFileURLFrontSide,k.PHOB_DocumentDetailsResidenceFileFrontSide,  k.PHOB_DocumentDetailsResidenceFileURLBackSide, k.PHOB_DocumentDetailsResidenceFileBackSide, k.PHOB_DocumentDetailsBusinessFileURL "
				+ ", k.PHOB_DocumentDetailsBusinessFile, k.PHOB_DocumentDetailsPCOSignatureURL, k.PHOB_DocumentDetailsPCOSignature, k.PHOB_DocumentDetailsIfany, k.PHOB_DocumentDetailsAgreement, k.PHOB_Created as PHOB_kycDate "
				+ ", k.PHOB_User, k.PHOB_KYCUPdateDate, k.PHOB_KYCUpdatedBy FROM PHMC_PHOB_USER as u Join PHMC_PHOB_ONBOARD as k on u.PHOB_PCOID=k.PHOB_User ";
		
		if (whereCluase != null && !whereCluase.equals("")){
			phmc_selectQuary  = phmc_selectQuary +  " WHERE "+whereCluase+" ";
		}
		if(phmc_om_pageStart != null && phmc_om_size != null){
			phmc_selectQuary = phmc_selectQuary + " ORDER BY u.PHOB_Created DESC"
					+ " OFFSET " + phmc_om_size*(phmc_om_pageStart-1)+ " ROWS FETCH NEXT " + phmc_om_size + " ROWS ONLY ";
		}	
		System.out.println(phmc_selectQuary);

		// get Database Connection
		try (Connection phmc_conn = Payhind_DBManager.payhind_getConnection();
				PreparedStatement phmc_pst = phmc_conn.prepareStatement(phmc_selectQuary)) {

			
			

			phmc_rs = phmc_pst.executeQuery();
			phmc_phob_pcoOnboardList =  new  ArrayList<>();
			while (phmc_rs.next()) {

				// System.out.println(sopdb_rs.getRow());
				phmc_phob_pco = new PHMC_PHOB_USER();
				PHMC_PHOB_ONBOARD phmc_phob_kyc = new PHMC_PHOB_ONBOARD();

				phmc_phob_pco.setPHOB_UserSrNo(phmc_rs.getLong("PHOB_UserSrNo"));
				phmc_phob_pco.setPHOB_PCOID(phmc_rs.getLong("PHOB_PCOID"));
				phmc_phob_pco.setPHOB_Email(phmc_rs.getString("PHOB_Email"));
				phmc_phob_pco.setPHOB_Phone(phmc_rs.getLong("PHOB_Phone"));
				phmc_phob_pco.setPHOB_Password(phmc_rs.getString("PHOB_Password"));
				phmc_phob_pco.setPHOB_Salt(phmc_rs.getString("PHOB_Salt"));
				phmc_phob_pco.setPHOB_PCORoles(phmc_rs.getString("PHOB_PCORoles"));
				phmc_phob_pco.setPHOB_UpdatedDate(phmc_rs.getDate("PHOB_UpdatedDate"));
				phmc_phob_pco.setPHOB_UpdatedBy(phmc_rs.getString("PHOB_UpdatedBy"));
				phmc_phob_pco.setPHOB_Terms(phmc_rs.getString("PHOB_Terms"));
				phmc_phob_pco.setPHOB_WelcomeMail(phmc_rs.getString("PHOB_WelcomeMail"));
				phmc_phob_pco.setPHOB_Created(phmc_rs.getDate("PHOB_userDate"));
				phmc_phob_pco.setPHOB_ResetPasswordToken(phmc_rs.getInt("PHOB_ResetPasswordToken"));
				phmc_phob_pco.setPHOB_SignUp(phmc_rs.getString("PHOB_SignUp"));
				phmc_phob_pco.setPHOB_ResetPasswordExpired(phmc_rs.getDate("PHOB_ResetPasswordExpired"));
				phmc_phob_pco.setPHOB_PCONotes(phmc_rs.getString("PHOB_PCONotes"));
				phmc_phob_pco.setPHOB_KycSrNo(phmc_rs.getLong("PHOB_KycSrNo"));
				phmc_phob_pco.setPHOB_KYCEverythingValid(phmc_rs.getString("PHOB_KYCEverythingValid"));
				phmc_phob_pco.setPHOB_FollowUpFollowUpStatus(phmc_rs.getString("PHOB_FollowUpFollowUpStatus"));
				phmc_phob_pco.setPHOB_FollowUpFollowUpStatusList(phmc_rs.getString("PHOB_FollowUpFollowUpStatusList"));
				phmc_phob_pco.setPHOB_FollowUpGeneralSearch(phmc_rs.getString("PHOB_FollowUpGeneralSearch"));
				phmc_phob_pco.setPHOB_FollowUpGeneralsearchRange(phmc_rs.getString("PHOB_FollowUpGeneralsearchRange"));
				phmc_phob_pco.setPHOB_BasicDetailsIsFilled(phmc_rs.getString("PHOB_BasicDetailsIsFilled"));
				phmc_phob_pco.setPHOB_BasicDetailsFirstName(phmc_rs.getString("PHOB_BasicDetailsFirstName"));
				phmc_phob_pco.setPHOB_BasicDetailsLastName(phmc_rs.getString("PHOB_BasicDetailsLastName"));
				phmc_phob_pco
						.setPHOB_BasicDetailsNatureOfBussiness(phmc_rs.getString("PHOB_BasicDetailsNatureOfBussiness"));
				phmc_phob_pco.setPHOB_BasicDetailsIfAnyAboutBussiness(
						phmc_rs.getString("PHOB_BasicDetailsIfAnyAboutBussiness"));
				phmc_phob_pco.setPHOB_BasicDetailsHowYouKnow(phmc_rs.getString("PHOB_BasicDetailsHowYouKnow"));
				phmc_phob_pco.setPHOB_BasicDetailsComAddressOne(phmc_rs.getString("PHOB_BasicDetailsComAddressOne"));
				phmc_phob_pco.setPHOB_BasicDetailsComAddressTwo(phmc_rs.getString("PHOB_BasicDetailsComAddressTwo"));
				phmc_phob_pco
						.setPHOB_BasicDetailsComAddressThree(phmc_rs.getString("PHOB_BasicDetailsComAddressThree"));
				phmc_phob_pco.setPHOB_BasicDetailsComCity(phmc_rs.getString("PHOB_BasicDetailsComCity"));
				phmc_phob_pco.setPHOB_BasicDetailsComState(phmc_rs.getString("PHOB_BasicDetailsComState"));
				phmc_phob_pco.setPHOB_BasicDetailsComPincode(phmc_rs.getInt("PHOB_BasicDetailsComPincode"));
				phmc_phob_pco.setPHOB_KycStatusIsKycVerifiedByOfficial(
						phmc_rs.getString("PHOB_KycStatusIsKycVerifiedByOfficial"));
				phmc_phob_pco.setPHOB_KycStatusIsWalletCreated(phmc_rs.getString("PHOB_KycStatusIsWalletCreated"));
				phmc_phob_pco.setPHOB_KycStatusIsActivation(phmc_rs.getString("PHOB_KycStatusIsActivation"));
				phmc_phob_pco.setPHOB_KycStatusIsOtpSession(phmc_rs.getString("PHOB_KycStatusIsOtpSession"));
				phmc_phob_pco.setPHOB_KycStatusPremilinaryReview(phmc_rs.getString("PHOB_KycStatusPremilinaryReview"));
				phmc_phob_pco.setPHOB_KycStatusRemarks(phmc_rs.getString("PHOB_KycStatusRemarks"));
				phmc_phob_pco.setPHOB_Future_Field1(phmc_rs.getString("PHOB_Future_Field1"));
				phmc_phob_pco.setPHOB_Future_Field2(phmc_rs.getString("PHOB_Future_Field2"));
				phmc_phob_pco.setPHOB_Future_Field3(phmc_rs.getString("PHOB_Future_Field3"));
				phmc_phob_pco.setPHOB_Future_Field4(phmc_rs.getString("PHOB_Future_Field4"));
				phmc_phob_pco.setPHOB_Future_Field5(phmc_rs.getString("PHOB_Future_Field5"));
				phmc_phob_pco.setPHOB_Future_Field6(phmc_rs.getString("PHOB_Future_Field6"));
				phmc_phob_pco.setPHOB_OTPDate(phmc_rs.getDate("PHOB_OTPDate"));
				phmc_phob_pco.setPHOB_OTPTime(phmc_rs.getString("PHOB_OTPTime"));

				phmc_phob_kyc.setPHOB_PersonalDetailsFullName(phmc_rs.getString("PHOB_PersonalDetailsFullName"));
				phmc_phob_kyc.setPHOB_PersonalDetailsPictureURL(phmc_rs.getString("PHOB_PersonalDetailsPictureURL"));
				phmc_phob_kyc.setPHOB_PersonalDetailsPicture(phmc_rs.getString("PHOB_PersonalDetailsPicture"));
				phmc_phob_kyc.setPHOB_PersonalDetailsDob(phmc_rs.getDate("PHOB_PersonalDetailsDob"));
				phmc_phob_kyc.setPHOB_PersonalDetailsMotherName(phmc_rs.getString("PHOB_PersonalDetailsMotherName"));
				phmc_phob_kyc.setPHOB_PersonalDetailsGender(phmc_rs.getString("PHOB_PersonalDetailsGender"));
				phmc_phob_kyc
						.setPHOB_BusinessDetailsBusinessName(phmc_rs.getString("PHOB_BusinessDetailsBusinessName"));
				phmc_phob_kyc.setPHOB_BusinessDetailsNatureofBusiness(
						phmc_rs.getString("PHOB_BusinessDetailsNatureofBusiness"));
				phmc_phob_kyc.setPHOB_BusinessDetailsIfany(phmc_rs.getString("PHOB_BusinessDetailsIfany"));

				phmc_phob_kyc.setPHOB_CommunicationDetailsPersonalAddressAddressline1(
						phmc_rs.getString("PHOB_CommunicationDetailsPersonalAddressAddressline1"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsPersonalAddressAddressline2(
						phmc_rs.getString("PHOB_CommunicationDetailsPersonalAddressAddressline2"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsPersonalAddressAddressline3(
						phmc_rs.getString("PHOB_CommunicationDetailsPersonalAddressAddressline3"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsPersonalAddressPersonalcity(
						phmc_rs.getString("PHOB_CommunicationDetailsPersonalAddressPersonalcity"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsPersonalAddressPersonalState(
						phmc_rs.getString("PHOB_CommunicationDetailsPersonalAddressPersonalState"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsPersonalAddressPersonalpin(
						phmc_rs.getString("PHOB_CommunicationDetailsPersonalAddressPersonalpin"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsBusinessAddressAddressline1(
						phmc_rs.getString("PHOB_CommunicationDetailsBusinessAddressAddressline1"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsBusinessAddressAddressline2(
						phmc_rs.getString("PHOB_CommunicationDetailsBusinessAddressAddressline2"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsBusinessAddressAddressline3(
						phmc_rs.getString("PHOB_CommunicationDetailsBusinessAddressAddressline3"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsBusinessAddressBusinesscity(
						phmc_rs.getString("PHOB_CommunicationDetailsBusinessAddressBusinesscity"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsBusinessAddressBusinessstate(
						phmc_rs.getString("PHOB_CommunicationDetailsBusinessAddressBusinessstate"));
				phmc_phob_kyc.setPHOB_CommunicationDetailsBusinessAddressBusinesspin(
						phmc_rs.getString("PHOB_CommunicationDetailsBusinessAddressBusinesspin"));
				phmc_phob_kyc.setPHOB_BankDetailsBankName(phmc_rs.getString("PHOB_BankDetailsBankName"));
				phmc_phob_kyc
						.setPHOB_BankDetailsBankAccountNumber(phmc_rs.getLong("PHOB_BankDetailsBankAccountNumber"));
				phmc_phob_kyc.setPHOB_BankDetailsBankBranch(phmc_rs.getString("PHOB_BankDetailsBankBranch"));
				phmc_phob_kyc.setPHOB_BankDetailsAccountType(phmc_rs.getString("PHOB_BankDetailsAccountType"));
				phmc_phob_kyc.setPHOB_BankDetailsIfscCode(phmc_rs.getString("PHOB_BankDetailsIfscCode"));
				phmc_phob_kyc.setPHOB_DocumentDetailsPanFileURL(phmc_rs.getString("PHOB_DocumentDetailsPanFileURL"));
				phmc_phob_kyc.setPHOB_DocumentDetailsPanFile(phmc_rs.getString("PHOB_DocumentDetailsPanFile"));
				phmc_phob_kyc.setPHOB_DocumentDetailsResidenceFileURLFrontSide(
						phmc_rs.getString("PHOB_DocumentDetailsResidenceFileURLFrontSide"));
				phmc_phob_kyc.setPHOB_DocumentDetailsResidenceFileFrontSide(
						phmc_rs.getString("PHOB_DocumentDetailsResidenceFileFrontSide"));
				phmc_phob_kyc.setPHOB_DocumentDetailsResidenceFileURLBackSide(
						phmc_rs.getString("PHOB_DocumentDetailsResidenceFileURLBackSide"));
				phmc_phob_kyc.setPHOB_DocumentDetailsResidenceFileBackSide(
						phmc_rs.getString("PHOB_DocumentDetailsResidenceFileBackSide"));
				phmc_phob_kyc.setPHOB_DocumentDetailsBusinessFileURL(
						phmc_rs.getString("PHOB_DocumentDetailsBusinessFileURL"));
				phmc_phob_kyc.setPHOB_DocumentDetailsBusinessFile(
						phmc_rs.getString("PHOB_DocumentDetailsBusinessFile"));
				phmc_phob_kyc.setPHOB_DocumentDetailsPCOSignatureURL(
						phmc_rs.getString("PHOB_DocumentDetailsPCOSignatureURL"));
				phmc_phob_kyc.setPHOB_DocumentDetailsPCOSignature(
						phmc_rs.getString("PHOB_DocumentDetailsPCOSignature"));
				phmc_phob_kyc.setPHOB_DocumentDetailsIfany(phmc_rs.getString("PHOB_DocumentDetailsIfany"));
				phmc_phob_kyc.setPHOB_DocumentDetailsAgreement(phmc_rs.getString("PHOB_DocumentDetailsAgreement"));
				phmc_phob_kyc.setPHOB_Created(phmc_rs.getDate("PHOB_kycDate"));
				phmc_phob_kyc.setPHOB_User(phmc_rs.getLong("PHOB_User"));
				phmc_phob_kyc.setPHOB_KYCUPdateDate(phmc_rs.getDate("PHOB_KYCUPdateDate"));
				phmc_phob_kyc.setPHOB_KYCUpdatedBy(phmc_rs.getString("PHOB_KYCUpdatedBy"));
				
				phmc_phob_pco.setOnBoard(phmc_phob_kyc);
				phmc_phob_pcoOnboardList.add(phmc_phob_pco);

			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return phmc_phob_pcoOnboardList;

	}

	/**
	 * @author Rahul makvana
	 * @param UserModel
	 * @return ErrorMessage with error code this class for Create(Insert)
	 *         operation for PHOB_KYCFORM table from PHMC-MASTER database.
	 *
	 */
	public ErrorMessage phmc_phob_createUserWithOnboard(PHMC_PHOB_USER userModel) {
		int isInsertSuccess = 0;
		Connection PHMC_conn = null;
		PreparedStatement PHMC_pst = null;
		String insertSetter = null;
		int isKycInsertSuccess = 0;

		ErrorMessage msg = new ErrorMessage();

		if (userModel != null) {

			try {

				PHMC_conn = Payhind_DBManager.payhind_getConnection();

				isInsertSuccess = Payhind_DBManager.phob_checkIfUserExist(PHMC_conn, userModel.getPHOB_PCOID(),
						"PHMC_PHOB_USER");
				isKycInsertSuccess = Payhind_DBManager.phob_checkIfUserExist(PHMC_conn, userModel.getPHOB_PCOID(),
						"PHMC_PHOB_ONBOARD");

				if (isInsertSuccess == PHMC_DB_ERROR.PHMC_USER_NOT_EXIST
						&& isKycInsertSuccess == PHMC_DB_ERROR.PHMC_USER_NOT_EXIST) {
					PHMC_conn.setAutoCommit(false);

					insertSetter = setterForInsertUserWithKyc(userModel);

					PHMC_pst = PHMC_conn.prepareStatement(insertSetter);

					isInsertSuccess = PHMC_pst.executeUpdate();

					msg.setErrorCode(PHMC_DB_ERROR.PHMC_SUCCESS);
					msg.setErrorMessage("PCO with ID " + userModel.getPHOB_PCOID() + " Created Successfully");
					PHMC_conn.commit();
				} else {
					msg.setErrorCode(PHMC_DB_ERROR.PHMC_USER_ALREADY_EXISTS);
					msg.setErrorMessage("PCO with ID " + userModel.getPHOB_PCOID() + " already exist");
				}

			} catch (ClassNotFoundException e) {
				isInsertSuccess = PHMC_DB_ERROR.PHMC_SCFG_FILE_NOT_FOUND;
				msg.setErrorCode(PHMC_DB_ERROR.PHMC_SCFG_FILE_NOT_FOUND);
				msg.setErrorMessage("PCO with ID " + userModel.getPHOB_PCOID() + " Not Found");
				e.printStackTrace();
			} catch (SQLException e) {
				isInsertSuccess = PHMC_DB_ERROR.PHMC_INSERT_FAILED;
				msg.setErrorCode(PHMC_DB_ERROR.PHMC_INSERT_FAILED);
				msg.setErrorMessage("PCO with ID " + userModel.getPHOB_PCOID() + " Creation Failed");
				e.printStackTrace();
			} finally {
				if (PHMC_pst != null) {
					try {
						PHMC_pst.close();
						PHMC_conn.close();
					} catch (SQLException e) {
						isInsertSuccess = PHMC_DB_ERROR.PHMC_INSERT_FAILED;
						msg.setErrorCode(PHMC_DB_ERROR.PHMC_INSERT_FAILED);
						msg.setErrorMessage("PCO with ID " + userModel.getPHOB_PCOID() + " Creation Failed");
						e.printStackTrace();
					}

				}
			}

		}

		System.out.println("Status code is=" + msg.getErrorCode());
		System.out.println("status msg is=" + msg.getErrorMessage());
		return msg;
	}

	private String setterForInsertUserWithKyc(PHMC_PHOB_USER userModel) {
		String setter = null;
		String columnName = null;
		String kycColumnName = null;
		String value = null;
		String kycValue = null;

		if (userModel.getPHOB_PCOID() != 0)
			columnName = "PHOB_PCOID ";
		value = "'" + userModel.getPHOB_PCOID() + "'";
		if (userModel.getPHOB_Email() != null) {
			if (columnName == null) {
				columnName = "PHOB_Email";
				value = "'" + userModel.getPHOB_Email() + "'";
			} else {
				columnName += ", PHOB_Email ";
				value += ", '" + userModel.getPHOB_Email() + "'";
			}
		}
		if (userModel.getPHOB_Phone() != null) {
			if (columnName == null) {
				columnName = "PHOB_Phone";
				value = "" + userModel.getPHOB_Phone() + "";
			} else {
				columnName += ", PHOB_Phone ";
				value += ", " + userModel.getPHOB_Phone() + "";
			}
		}
		if (userModel.getPHOB_Password() != null) {
			if (columnName == null) {
				columnName = "PHOB_Password ";
				value = "'" + userModel.getPHOB_Password() + "'";
			} else {
				columnName += ", PHOB_Password ";
				value += ", '" + userModel.getPHOB_Password() + "'";
			}
		}
		if (userModel.getPHOB_Salt() != null) {
			if (columnName == null) {
				columnName = "PHOB_Salt ";
				value = "'" + userModel.getPHOB_Salt() + "'";
			} else {
				columnName += ", PHOB_Salt ";
				value += ", '" + userModel.getPHOB_Salt() + "'";
			}
		}
		
		if (userModel.getPHOB_PCORoles() != null) {
			if (columnName == null) {
				columnName = "PHOB_PCORoles ";
				value = "'" + userModel.getPHOB_PCORoles() + "'";
			} else {
				columnName += ", PHOB_PCORoles ";
				value += ", '" + userModel.getPHOB_PCORoles() + "'";
			}
		}
		if (userModel.getPHOB_UpdatedDate() != null) {
			if (columnName == null) {
				columnName = "PHOB_UpdatedDate ";
				value = "'" + Payhind_DBManager.convertJavaDateToSqlDate(userModel.getPHOB_UpdatedDate()) + "'";
			} else {
				columnName += ", PHOB_UpdatedDate ";
				value += ", '" + Payhind_DBManager.convertJavaDateToSqlDate(userModel.getPHOB_UpdatedDate()) + "'";
			}
		}
		if (userModel.getPHOB_UpdatedBy() != null) {
			if (columnName == null) {
				columnName = "PHOB_UpdatedBy ";
				value = "'" + userModel.getPHOB_UpdatedBy() + "'";
			} else {
				columnName += ", PHOB_UpdatedBy ";
				value += ", '" + userModel.getPHOB_UpdatedBy() + "'";
			}
		}
		if (userModel.getPHOB_Terms() != null) {
			if (columnName == null) {
				columnName = "PHOB_Terms ";
				value = "'" + userModel.getPHOB_Terms() + "'";
			} else {
				columnName += ", PHOB_Terms ";
				value += ", '" + userModel.getPHOB_Terms() + "'";
			}
		}
		if (userModel.getPHOB_WelcomeMail() != null) {
			if (columnName == null) {
				columnName = "PHOB_WelcomeMail ";
				value = "'" + userModel.getPHOB_WelcomeMail() + "'";
			} else {
				columnName += ", PHOB_WelcomeMail ";
				value += ", '" + userModel.getPHOB_WelcomeMail() + "'";
			}
		}
		if (userModel.getPHOB_Created() != null) {
			if (columnName == null) {
				columnName = "PHOB_Created ";
				value = "'" + Payhind_DBManager.convertJavaDateToSqlDate(userModel.getPHOB_Created()) + "'";
			} else {
				columnName += ", PHOB_Created ";
				value += ", '" + Payhind_DBManager.convertJavaDateToSqlDate(userModel.getPHOB_Created()) + "'";
			}
		}
		if (userModel.getPHOB_ResetPasswordToken() != null) {
			if (columnName == null) {
				columnName = "PHOB_ResetPasswordToken ";
				value = "'" + userModel.getPHOB_ResetPasswordToken() + "'";
			} else {
				columnName += ", PHOB_ResetPasswordToken ";
				value += ", '" + userModel.getPHOB_ResetPasswordToken() + "'";
			}
		}
		if (userModel.getPHOB_SignUp() != null) {
			if (columnName == null) {
				columnName = "PHOB_SignUp ";
				value = "'" + userModel.getPHOB_SignUp() + "'";
			} else {
				columnName += ", PHOB_SignUp ";
				value += ", '" + userModel.getPHOB_SignUp() + "'";
			}
		}
		if (userModel.getPHOB_ResetPasswordExpired() != null) {
			if (columnName == null) {
				columnName = "PHOB_ResetPasswordExpired ";
				value = "'" + Payhind_DBManager.convertJavaDateToSqlDate(userModel.getPHOB_ResetPasswordExpired()) + "'";
			} else {
				columnName += ", PHOB_ResetPasswordExpired ";
				value += ", '" + Payhind_DBManager.convertJavaDateToSqlDate(userModel.getPHOB_ResetPasswordExpired())
						+ "'";
			}
		}
		if (userModel.getPHOB_PCONotes() != null) {
			if (columnName == null) {
				columnName = "PHOB_PCONotes ";
				value = "'" + userModel.getPHOB_PCONotes() + "'";
			} else {
				columnName += ", PHOB_PCONotes ";
				value += ", '" + userModel.getPHOB_PCONotes() + "'";
			}
		}
		if (userModel.getPHOB_KycSrNo() != null) {
			if (columnName == null) {
				columnName = "PHOB_KycSrNo ";
				value = "'" + userModel.getPHOB_KycSrNo() + "'";
			} else {
				columnName += ", PHOB_KycSrNo ";
				value += ", '" + userModel.getPHOB_KycSrNo() + "'";
			}
		}
		if (userModel.getPHOB_KYCEverythingValid() != null) {
			if (columnName == null) {
				columnName = "PHOB_KYCEverythingValid ";
				value = "'" + userModel.getPHOB_KYCEverythingValid() + "'";
			} else {
				columnName += ", PHOB_KYCEverythingValid ";
				value += ", '" + userModel.getPHOB_KYCEverythingValid() + "'";
			}
		}
		if (userModel.getPHOB_FollowUpFollowUpStatus() != null) {
			if (columnName == null) {
				columnName = "PHOB_FollowUpFollowUpStatus ";
				value = "'" + userModel.getPHOB_FollowUpFollowUpStatus() + "'";
			} else {
				columnName += ", PHOB_FollowUpFollowUpStatus ";
				value += ", '" + userModel.getPHOB_FollowUpFollowUpStatus() + "'";
			}
		}
		if (userModel.getPHOB_FollowUpFollowUpStatusList() != null) {
			if (columnName == null) {
				columnName = "PHOB_FollowUpFollowUpStatusList ";
				value = "'" + userModel.getPHOB_FollowUpFollowUpStatusList() + "'";
			} else {
				columnName += ", PHOB_FollowUpFollowUpStatusList ";
				value += ", '" + userModel.getPHOB_FollowUpFollowUpStatusList() + "'";
			}
		}
		if (userModel.getPHOB_FollowUpGeneralSearch() != null) {
			if (columnName == null) {
				columnName = "PHOB_FollowUpGeneralSearch ";
				value = "'" + userModel.getPHOB_FollowUpGeneralSearch() + "'";
			} else {
				columnName += ", PHOB_FollowUpGeneralSearch ";
				value += ", '" + userModel.getPHOB_FollowUpGeneralSearch() + "'";
			}
		}
		if (userModel.getPHOB_FollowUpGeneralsearchRange() != null) {
			if (columnName == null) {
				columnName = "PHOB_FollowUpGeneralsearchRange ";
				value = "'" + userModel.getPHOB_FollowUpGeneralsearchRange() + "'";
			} else {
				columnName += ", PHOB_FollowUpGeneralsearchRange ";
				value += ", '" + userModel.getPHOB_FollowUpGeneralsearchRange() + "'";
			}
		}
		if (userModel.getPHOB_BasicDetailsIsFilled() != null) {
			if (columnName == null) {
				columnName = "PHOB_BasicDetailsIsFilled ";
				value = "'" + userModel.getPHOB_BasicDetailsIsFilled() + "'";
			} else {
				columnName += ", PHOB_BasicDetailsIsFilled ";
				value += ", '" + userModel.getPHOB_BasicDetailsIsFilled() + "'";
			}
		}
		if (userModel.getPHOB_BasicDetailsFirstName() != null) {
			if (columnName == null) {
				columnName = "PHOB_BasicDetailsFirstName ";
				value = "'" + userModel.getPHOB_BasicDetailsFirstName() + "'";
			} else {
				columnName += ", PHOB_BasicDetailsFirstName ";
				value += ", '" + userModel.getPHOB_BasicDetailsFirstName() + "'";
			}
		}
		if (userModel.getPHOB_BasicDetailsLastName() != null) {
			if (columnName == null) {
				columnName = "PHOB_BasicDetailsLastName ";
				value = "'" + userModel.getPHOB_BasicDetailsLastName() + "'";
			} else {
				columnName += ", PHOB_BasicDetailsLastName ";
				value += ", '" + userModel.getPHOB_BasicDetailsLastName() + "'";
			}
		}
		if (userModel.getPHOB_BasicDetailsNatureOfBussiness() != null) {
			if (columnName == null) {
				columnName = "PHOB_BasicDetailsNatureOfBussiness ";
				value = "'" + userModel.getPHOB_BasicDetailsNatureOfBussiness() + "'";
			} else {
				columnName += ", PHOB_BasicDetailsNatureOfBussiness ";
				value += ", '" + userModel.getPHOB_BasicDetailsNatureOfBussiness() + "'";
			}
		}
		if (userModel.getPHOB_BasicDetailsIfAnyAboutBussiness() != null) {
			if (columnName == null) {
				columnName = "PHOB_BasicDetailsIfAnyAboutBussiness ";
				value = "'" + userModel.getPHOB_BasicDetailsIfAnyAboutBussiness() + "'";
			} else {
				columnName += ", PHOB_BasicDetailsIfAnyAboutBussiness ";
				value += ", '" + userModel.getPHOB_BasicDetailsIfAnyAboutBussiness() + "'";
			}
		}
		if (userModel.getPHOB_BasicDetailsHowYouKnow() != null) {
			if (columnName == null) {
				columnName = "PHOB_BasicDetailsHowYouKnow ";
				value = "'" + userModel.getPHOB_BasicDetailsHowYouKnow() + "'";
			} else {
				columnName += ", PHOB_BasicDetailsHowYouKnow ";
				value += ", '" + userModel.getPHOB_BasicDetailsHowYouKnow() + "'";
			}
		}
		if (userModel.getPHOB_BasicDetailsComAddressOne() != null) {
			if (columnName == null) {
				columnName = "PHOB_BasicDetailsComAddressOne ";
				value = "'" + userModel.getPHOB_BasicDetailsComAddressOne() + "'";
			} else {
				columnName += ", PHOB_BasicDetailsComAddressOne ";
				value += ", '" + userModel.getPHOB_BasicDetailsComAddressOne() + "'";
			}
		}
		if (userModel.getPHOB_BasicDetailsComAddressTwo() != null) {
			if (columnName == null) {
				columnName = "PHOB_BasicDetailsComAddressTwo ";
				value = "'" + userModel.getPHOB_BasicDetailsComAddressTwo() + "'";
			} else {
				columnName += ", PHOB_BasicDetailsComAddressTwo ";
				value += ", '" + userModel.getPHOB_BasicDetailsComAddressTwo() + "'";
			}
		}
		if (userModel.getPHOB_BasicDetailsComAddressThree() != null) {
			if (columnName == null) {
				columnName = "PHOB_BasicDetailsComAddressThree ";
				value = "'" + userModel.getPHOB_BasicDetailsComAddressThree() + "'";
			} else {
				columnName += ", PHOB_BasicDetailsComAddressThree ";
				value += ", '" + userModel.getPHOB_BasicDetailsComAddressThree() + "'";
			}
		}
		if (userModel.getPHOB_BasicDetailsComCity() != null) {
			if (columnName == null) {
				columnName = "PHOB_BasicDetailsComCity ";
				value = "'" + userModel.getPHOB_BasicDetailsComCity() + "'";
			} else {
				columnName += ", PHOB_BasicDetailsComCity ";
				value += ", '" + userModel.getPHOB_BasicDetailsComCity() + "'";
			}
		}
		if (userModel.getPHOB_BasicDetailsComState() != null) {
			if (columnName == null) {
				columnName = "PHOB_BasicDetailsComState ";
				value = "'" + userModel.getPHOB_BasicDetailsComState() + "'";
			} else {
				columnName += ", PHOB_BasicDetailsComState ";
				value += ", '" + userModel.getPHOB_BasicDetailsComState() + "'";
			}
		}
		if (userModel.getPHOB_BasicDetailsComPincode() != null) {
			if (columnName == null) {
				columnName = "PHOB_BasicDetailsComPincode ";
				value = "'" + userModel.getPHOB_BasicDetailsComPincode() + "'";
			} else {
				columnName += ", PHOB_BasicDetailsComPincode ";
				value += ", '" + userModel.getPHOB_BasicDetailsComPincode() + "'";
			}
		}
		if (userModel.getPHOB_KycStatusIsKycVerifiedByOfficial() != null) {
			if (columnName == null) {
				columnName = "PHOB_KycStatusIsKycVerifiedByOfficial ";
				value = "'" + userModel.getPHOB_KycStatusIsKycVerifiedByOfficial() + "'";
			} else {
				columnName += ", PHOB_KycStatusIsKycVerifiedByOfficial ";
				value += ", '" + userModel.getPHOB_KycStatusIsKycVerifiedByOfficial() + "'";
			}
		}
		if (userModel.getPHOB_KycStatusIsWalletCreated() != null) {
			if (columnName == null) {
				columnName = "PHOB_KycStatusIsWalletCreated ";
				value = "'" + userModel.getPHOB_KycStatusIsWalletCreated() + "'";
			} else {
				columnName += ", PHOB_KycStatusIsWalletCreated ";
				value += ", '" + userModel.getPHOB_KycStatusIsWalletCreated() + "'";
			}
		}
		if (userModel.getPHOB_KycStatusIsActivation() != null) {
			if (columnName == null) {
				columnName = "PHOB_KycStatusIsActivation ";
				value = "'" + userModel.getPHOB_KycStatusIsActivation() + "'";
			} else {
				columnName += ", PHOB_KycStatusIsActivation ";
				value += ", '" + userModel.getPHOB_KycStatusIsActivation() + "'";
			}
		}
		if (userModel.getPHOB_KycStatusIsOtpSession() != null) {
			if (columnName == null) {
				columnName = "PHOB_KycStatusIsOtpSession ";
				value = "'" + userModel.getPHOB_KycStatusIsOtpSession() + "'";
			} else {
				columnName += ", PHOB_KycStatusIsOtpSession ";
				value += ", '" + userModel.getPHOB_KycStatusIsOtpSession() + "'";
			}
		}
		if (userModel.getPHOB_KycStatusPremilinaryReview() != null) {
			if (columnName == null) {
				columnName = "PHOB_KycStatusPremilinaryReview ";
				value = "'" + userModel.getPHOB_KycStatusPremilinaryReview() + "'";
			} else {
				columnName += ", PHOB_KycStatusPremilinaryReview ";
				value += ", '" + userModel.getPHOB_KycStatusPremilinaryReview() + "'";
			}
		}
		if (userModel.getPHOB_KycStatusRemarks() != null) {
			if (columnName == null) {
				columnName = "PHOB_KycStatusRemarks ";
				value = "'" + userModel.getPHOB_KycStatusRemarks() + "'";
			} else {
				columnName += ", PHOB_KycStatusRemarks ";
				value += ", '" + userModel.getPHOB_KycStatusRemarks() + "'";
			}
		}
		if (userModel.getPHOB_Future_Field1() != null) {
			if (columnName == null) {
				columnName = "PHOB_Future_Field1 ";
				value = "'" + userModel.getPHOB_Future_Field1() + "'";
			} else {
				columnName += ", PHOB_Future_Field1 ";
				value += ", '" + userModel.getPHOB_Future_Field1() + "'";
			}
		}
		if (userModel.getPHOB_Future_Field2() != null) {
			if (columnName == null) {
				columnName = "PHOB_Future_Field2 ";
				value = "'" + userModel.getPHOB_Future_Field2() + "'";
			} else {
				columnName += ", PHOB_Future_Field2 ";
				value += ", '" + userModel.getPHOB_Future_Field2() + "'";
			}
		}
		if (userModel.getPHOB_Future_Field3() != null) {
			if (columnName == null) {
				columnName = "PHOB_Future_Field3 ";
				value = "'" + userModel.getPHOB_Future_Field3() + "'";
			} else {
				columnName += ", PHOB_Future_Field3 ";
				value += ", '" + userModel.getPHOB_Future_Field3() + "'";
			}
		}
		if (userModel.getPHOB_Future_Field4() != null) {
			if (columnName == null) {
				columnName = "PHOB_Future_Field4 ";
				value = "'" + userModel.getPHOB_Future_Field4() + "'";
			} else {
				columnName += ", PHOB_Future_Field4 ";
				value += ", '" + userModel.getPHOB_Future_Field4() + "'";
			}
		}
		if (userModel.getPHOB_Future_Field5() != null) {
			if (columnName == null) {
				columnName = "PHOB_Future_Field5 ";
				value = "'" + userModel.getPHOB_Future_Field5() + "'";
			} else {
				columnName += ", PHOB_Future_Field5 ";
				value += ", '" + userModel.getPHOB_Future_Field5() + "'";
			}
		}
		if (userModel.getPHOB_Future_Field6() != null) {
			if (columnName == null) {
				columnName = "PHOB_Future_Field6 ";
				value = "'" + userModel.getPHOB_Future_Field6() + "'";
			} else {
				columnName += ", PHOB_Future_Field6 ";
				value += ", '" + userModel.getPHOB_Future_Field6() + "'";
			}
		}
		if (userModel.getPHOB_OTPDate() != null) {
			if (columnName == null) {
				columnName = "PHOB_OTPDate ";
				value = "'" + Payhind_DBManager.convertJavaDateToSqlDate(userModel.getPHOB_OTPDate()) + "'";
			} else {
				columnName += ", PHOB_OTPDate ";
				value += ", '" + Payhind_DBManager.convertJavaDateToSqlDate(userModel.getPHOB_OTPDate()) + "'";
			}
		}
		if (userModel.getPHOB_OTPTime() != null) {
			if (columnName == null) {
				columnName = "PHOB_OTPTime ";
				value = "'" + userModel.getPHOB_OTPTime() + "'";
			} else {
				columnName += ", PHOB_OTPTime ";
				value += ", '" + userModel.getPHOB_OTPTime() + "'";
			}
		}

		if (userModel.getOnBoard().getPHOB_PersonalDetailsFullName() != null)
			kycColumnName = "PHOB_PersonalDetailsFullName ";
		kycValue = "'" + userModel.getOnBoard().getPHOB_PersonalDetailsFullName() + "' ";
		if (userModel.getOnBoard().getPHOB_PersonalDetailsPictureURL() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_PersonalDetailsPictureURL";
				kycValue = "'" + userModel.getOnBoard().getPHOB_PersonalDetailsPictureURL() + "'";
			} else {
				kycColumnName += ", PHOB_PersonalDetailsPictureURL ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_PersonalDetailsPictureURL() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_PersonalDetailsPicture() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_PersonalDetailsPicture";
				kycValue = "'" + userModel.getOnBoard().getPHOB_PersonalDetailsPicture() + "'";
			} else {
				kycColumnName += ", PHOB_PersonalDetailsPicture ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_PersonalDetailsPicture() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_PersonalDetailsDob() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_PersonalDetailsDob ";
				kycValue = "'"
						+ Payhind_DBManager.convertJavaDateToSqlDate(userModel.getOnBoard().getPHOB_PersonalDetailsDob())
						+ "'";
			} else {
				kycColumnName += ", PHOB_PersonalDetailsDob ";
				kycValue += ", '"
						+ Payhind_DBManager.convertJavaDateToSqlDate(userModel.getOnBoard().getPHOB_PersonalDetailsDob())
						+ "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_PersonalDetailsMotherName() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_PersonalDetailsMotherName ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_PersonalDetailsMotherName() + "'";
			} else {
				kycColumnName += ", PHOB_PersonalDetailsMotherName ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_PersonalDetailsMotherName() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_PersonalDetailsGender() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_PersonalDetailsGender ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_PersonalDetailsGender() + "'";
			} else {
				kycColumnName += ", PHOB_PersonalDetailsGender ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_PersonalDetailsGender() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_BusinessDetailsBusinessName() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_BusinessDetailsBusinessName ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_BusinessDetailsBusinessName() + "'";
			} else {
				kycColumnName += ", PHOB_BusinessDetailsBusinessName ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_BusinessDetailsBusinessName() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_BusinessDetailsNatureofBusiness() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_BusinessDetailsNatureofBusiness ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_BusinessDetailsNatureofBusiness() + "'";
			} else {
				kycColumnName += ", PHOB_BusinessDetailsNatureofBusiness ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_BusinessDetailsNatureofBusiness() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_BusinessDetailsIfany() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_BusinessDetailsIfany ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_BusinessDetailsIfany() + "'";
			} else {
				kycColumnName += ", PHOB_BusinessDetailsIfany ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_BusinessDetailsIfany() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressAddressline1() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_CommunicationDetailsPersonalAddressAddressline1 ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressAddressline1() + "'";
			} else {
				kycColumnName += ", PHOB_CommunicationDetailsPersonalAddressAddressline1 ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressAddressline1()
						+ "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressAddressline2() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_CommunicationDetailsPersonalAddressAddressline2 ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressAddressline2() + "'";
			} else {
				kycColumnName += ", PHOB_CommunicationDetailsPersonalAddressAddressline2 ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressAddressline2()
						+ "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressAddressline3() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_CommunicationDetailsPersonalAddressAddressline3 ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressAddressline3() + "'";
			} else {
				kycColumnName += ", PHOB_CommunicationDetailsPersonalAddressAddressline3 ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressAddressline3()
						+ "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressPersonalcity() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_CommunicationDetailsPersonalAddressPersonalcity ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressPersonalcity() + "'";
			} else {
				kycColumnName += ", PHOB_CommunicationDetailsPersonalAddressPersonalcity ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressPersonalcity()
						+ "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressPersonalState() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_CommunicationDetailsPersonalAddressPersonalState ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressPersonalState()
						+ "'";
			} else {
				kycColumnName += ", PHOB_CommunicationDetailsPersonalAddressPersonalState ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressPersonalState()
						+ "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressPersonalpin() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_CommunicationDetailsPersonalAddressPersonalpin ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressPersonalpin() + "'";
			} else {
				kycColumnName += ", PHOB_CommunicationDetailsPersonalAddressPersonalpin ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressPersonalpin()
						+ "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressAddressline1() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_CommunicationDetailsBusinessAddressAddressline1 ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressAddressline1() + "'";
			} else {
				kycColumnName += ", PHOB_CommunicationDetailsBusinessAddressAddressline1 ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressAddressline1()
						+ "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressAddressline2() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_CommunicationDetailsBusinessAddressAddressline2 ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressAddressline2() + "'";
			} else {
				kycColumnName += ", PHOB_CommunicationDetailsBusinessAddressAddressline2 ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressAddressline2()
						+ "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressAddressline3() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_CommunicationDetailsBusinessAddressAddressline3 ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressAddressline3() + "'";
			} else {
				kycColumnName += ", PHOB_CommunicationDetailsBusinessAddressAddressline3 ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressAddressline3()
						+ "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressBusinesscity() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_CommunicationDetailsBusinessAddressBusinesscity ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressBusinesscity() + "'";
			} else {
				kycColumnName += ", PHOB_CommunicationDetailsBusinessAddressBusinesscity ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressBusinesscity()
						+ "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressBusinessstate() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_CommunicationDetailsBusinessAddressBusinessstate ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressBusinessstate()
						+ "'";
			} else {
				kycColumnName += ", PHOB_CommunicationDetailsBusinessAddressBusinessstate ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressBusinessstate()
						+ "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressBusinesspin() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_CommunicationDetailsBusinessAddressBusinesspin ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressBusinesspin() + "'";
			} else {
				kycColumnName += ", PHOB_CommunicationDetailsBusinessAddressBusinesspin ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressBusinesspin()
						+ "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_BankDetailsBankName() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_BankDetailsBankName ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_BankDetailsBankName() + "'";
			} else {
				kycColumnName += ", PHOB_BankDetailsBankName ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_BankDetailsBankName() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_BankDetailsBankAccountNumber() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_BankDetailsBankAccountNumber ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_BankDetailsBankAccountNumber() + "'";
			} else {
				kycColumnName += ", PHOB_BankDetailsBankAccountNumber ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_BankDetailsBankAccountNumber() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_BankDetailsBankBranch() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_BankDetailsBankBranch ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_BankDetailsBankBranch() + "'";
			} else {
				kycColumnName += ", PHOB_BankDetailsBankBranch ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_BankDetailsBankBranch() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_BankDetailsAccountType() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_BankDetailsAccountType ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_BankDetailsAccountType() + "'";
			} else {
				kycColumnName += ", PHOB_BankDetailsAccountType ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_BankDetailsAccountType() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_BankDetailsIfscCode() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_BankDetailsIfscCode ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_BankDetailsIfscCode() + "'";
			} else {
				kycColumnName += ", PHOB_BankDetailsIfscCode ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_BankDetailsIfscCode() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsPanFileURL() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_DocumentDetailsPanFileURL ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_DocumentDetailsPanFileURL() + "'";
			} else {
				kycColumnName += ", PHOB_DocumentDetailsPanFileURL ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_DocumentDetailsPanFileURL() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsPanFile() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_DocumentDetailsPanFile ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_DocumentDetailsPanFile() + "'";
			} else {
				kycColumnName += ", PHOB_DocumentDetailsPanFile ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_DocumentDetailsPanFile() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileURLFrontSide() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_DocumentDetailsResidenceFileURLFrontSide ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileURLFrontSide() + "'";
			} else {
				kycColumnName += ", PHOB_DocumentDetailsResidenceFileURLFrontSide ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileURLFrontSide() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileFrontSide() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_DocumentDetailsResidenceFileFrontSide ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileFrontSide() + "'";
			} else {
				kycColumnName += ", PHOB_DocumentDetailsResidenceFileFrontSide ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileFrontSide() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileURLBackSide() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_DocumentDetailsResidenceFileURLBackSide ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileURLBackSide() + "'";
			} else {
				kycColumnName += ", PHOB_DocumentDetailsResidenceFileURLBackSide ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileURLBackSide() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileBackSide() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_DocumentDetailsResidenceFileBackSide ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileBackSide() + "'";
			} else {
				kycColumnName += ", PHOB_DocumentDetailsResidenceFileBackSide ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileBackSide() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsBusinessFileURL() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_DocumentDetailsBusinessFileURL ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_DocumentDetailsBusinessFileURL() + "'";
			} else {
				kycColumnName += ", PHOB_DocumentDetailsBusinessFileURL ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_DocumentDetailsBusinessFileURL() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsBusinessFile() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_DocumentDetailsBusinessFile ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_DocumentDetailsBusinessFile() + "'";
			} else {
				kycColumnName += ", PHOB_DocumentDetailsBusinessFile ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_DocumentDetailsBusinessFile() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsPCOSignatureURL() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_DocumentDetailsPCOSignatureURL ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_DocumentDetailsPCOSignatureURL() + "'";
			} else {
				kycColumnName += ", PHOB_DocumentDetailsPCOSignatureURL ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_DocumentDetailsPCOSignatureURL() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsPCOSignature() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_DocumentDetailsPCOSignature ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_DocumentDetailsPCOSignature() + "'";
			} else {
				kycColumnName += ", PHOB_DocumentDetailsPCOSignature ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_DocumentDetailsPCOSignature() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsIfany() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_DocumentDetailsIfany ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_DocumentDetailsIfany() + "'";
			} else {
				kycColumnName += ", PHOB_DocumentDetailsIfany ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_DocumentDetailsIfany() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsAgreement() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_DocumentDetailsAgreement ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_DocumentDetailsAgreement() + "'";
			} else {
				kycColumnName += ", PHOB_DocumentDetailsAgreement ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_DocumentDetailsAgreement() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_Created() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_Created ";
				kycValue = "'" + Payhind_DBManager.convertJavaDateToSqlDate(userModel.getOnBoard().getPHOB_Created())
						+ "'";
			} else {
				kycColumnName += ", PHOB_Created ";
				kycValue += ", '" + Payhind_DBManager.convertJavaDateToSqlDate(userModel.getOnBoard().getPHOB_Created())
						+ "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_User() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_User ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_User() + "'";
			} else {
				kycColumnName += ", PHOB_User ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_User() + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_KYCUPdateDate() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_KYCUPdateDate ";
				kycValue = "'" + Payhind_DBManager.convertJavaDateToSqlDate(userModel.getOnBoard().getPHOB_KYCUPdateDate()) + "'";
			} else {
				kycColumnName += ", PHOB_KYCUPdateDate ";
				kycValue += ", '" + Payhind_DBManager.convertJavaDateToSqlDate(userModel.getOnBoard().getPHOB_KYCUPdateDate()) + "'";
			}
		}
		if (userModel.getOnBoard().getPHOB_KYCUpdatedBy() != null) {
			if (kycColumnName == null) {
				kycColumnName = "PHOB_KYCUpdatedBy ";
				kycValue = "'" + userModel.getOnBoard().getPHOB_KYCUpdatedBy() + "'";
			} else {
				kycColumnName += ", PHOB_KYCUpdatedBy ";
				kycValue += ", '" + userModel.getOnBoard().getPHOB_KYCUpdatedBy() + "'";
			}
		}
		

		System.out.println(" KYC Column Name=" + kycColumnName);
		System.out.println("kycValue=" + kycValue);
		System.out.println("Column Name=" + columnName);
		System.out.println("Value=" + value);

		setter = "INSERT INTO PHMC_PHOB_USER(" + columnName + ") VALUES(" + value + "); " + "INSERT INTO PHMC_PHOB_ONBOARD("
				+ kycColumnName + ") VALUES(" + kycValue + ");";

		System.out.println("insert setter=" + setter);
		return setter;
	}

	/**
	 * @author rahul makvana
	 * @param UserModel
	 * @return isUpdateSuccess
	 * 
	 *         this class for Update operation for PHOBUSER and PHOB_ONBOARD table from
	 *         PHMC-MASTER database.
	 *
	 */

	public ErrorMessage phmc_phob_updateWithKycUser(long phob_pcoID, PHMC_PHOB_USER userModel) {

		int isUpdateSuccess = 0;
		int isKycUpdateSuccess = 0;
		Connection PHMC_conn = null;
		PreparedStatement PHMC_pst = null;
		String setter = "";

		ErrorMessage msg = new ErrorMessage();

		if (userModel != null) {

			try {
				PHMC_conn = Payhind_DBManager.payhind_getConnection();

				isUpdateSuccess = Payhind_DBManager.phob_checkIfUserExist(PHMC_conn, phob_pcoID, "PHMC_PHOB_USER");
				isKycUpdateSuccess = Payhind_DBManager.phob_checkIfUserExist(PHMC_conn, phob_pcoID, "PHMC_PHOB_ONBOARD");

				if (isUpdateSuccess == PHMC_DB_ERROR.PHMC_USER_ALREADY_EXISTS
						&& isKycUpdateSuccess == PHMC_DB_ERROR.PHMC_USER_ALREADY_EXISTS) {
					setter = setterForUpdateUserWithKyc(userModel, phob_pcoID);

					PHMC_conn.setAutoCommit(false);

					PHMC_pst = PHMC_conn.prepareStatement(setter);

					isUpdateSuccess = PHMC_pst.executeUpdate();

					msg.setErrorCode(PHMC_DB_ERROR.PHMC_SUCCESS);
					msg.setErrorMessage("PCO with ID " + userModel.getPHOB_PCOID() + " Updated Successfully");
					PHMC_conn.commit();
				} else {
					msg.setErrorCode(PHMC_DB_ERROR.PHMC_USER_NOT_EXIST);
					msg.setErrorMessage("PCO with ID " + userModel.getPHOB_PCOID() + " Not Exist");
				}

			} catch (ClassNotFoundException e) {
				isUpdateSuccess = PHMC_DB_ERROR.PHMC_SCFG_FILE_NOT_FOUND;
				msg.setErrorCode(PHMC_DB_ERROR.PHMC_SCFG_FILE_NOT_FOUND);
				msg.setErrorMessage("PCO with ID " + userModel.getPHOB_PCOID() + " Not Found");
				e.printStackTrace();
			} catch (NullPointerException | SQLException e) {
				isUpdateSuccess = PHMC_DB_ERROR.PHMC_UPDATE_FAILED;
				msg.setErrorCode(PHMC_DB_ERROR.PHMC_UPDATE_FAILED);
				msg.setErrorMessage("PCO with ID " + userModel.getPHOB_PCOID() + " Updation Failed");
				e.printStackTrace();
			} finally {
				if (PHMC_pst != null) {
					try {
						PHMC_pst.close();
						PHMC_conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

		}

		System.out.println("Status code is=" + msg.getErrorCode());
		System.out.println("Status msg is=" + msg.getErrorMessage());
		return msg;

	}

	/**
	 * @author rahul makvana
	 * @param userModel
	 * @return setter
	 */
	private String setterForUpdateUserWithKyc(PHMC_PHOB_USER userModel, long phob_pcoID) {
		String setter = null;
		String kycSetter = null;
		String mainSetter = null;

		if (userModel.getPHOB_PCOID() != null)
			setter = "PHOB_PCOID='" + userModel.getPHOB_PCOID() + "' ";
		if (userModel.getPHOB_Email() != null) {
			if (setter == null) {
				setter = "PHOB_Email ='" + userModel.getPHOB_Email() + "'";
			} else
				setter += ", PHOB_Email ='" + userModel.getPHOB_Email() + "'";
		}
		if (userModel.getPHOB_Phone() != null) {
			if (setter == null) {
				setter = "PHOB_Phone ='" + userModel.getPHOB_Phone() + "'";
			} else
				setter += ", PHOB_Phone ='" + userModel.getPHOB_Phone() + "'";
		}
		if (userModel.getPHOB_Password() != null) {
			if (setter == null) {
				setter = "PHOB_Password ='" + userModel.getPHOB_Password() + "'";
			} else
				setter += ", PHOB_Password ='" + userModel.getPHOB_Password() + "'";
		}
		if (userModel.getPHOB_Salt() != null) {
			if (setter == null) {
				setter = "PHOB_Salt ='" + userModel.getPHOB_Salt() + "'";
			} else
				setter += ", PHOB_Salt ='" + userModel.getPHOB_Salt() + "'";
		}
		if (userModel.getPHOB_PCORoles() != null) {
			if (setter == null) {
				setter = "PHOB_PCORoles ='" + userModel.getPHOB_PCORoles() + "'";
			} else
				setter += ", PHOB_PCORoles ='" + userModel.getPHOB_PCORoles() + "'";
		}
		if (userModel.getPHOB_UpdatedDate() != null) {
			if (setter == null) {
				setter = "PHOB_UpdatedDate ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(userModel.getPHOB_UpdatedDate()) + "'";
			} else
				setter += ", PHOB_UpdatedDate ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(userModel.getPHOB_UpdatedDate()) + "'";
		}
		if (userModel.getPHOB_UpdatedBy() != null) {
			if (setter == null) {
				setter = "PHOB_UpdatedBy ='" + userModel.getPHOB_UpdatedBy() + "'";
			} else
				setter += ", PHOB_UpdatedBy ='" + userModel.getPHOB_UpdatedBy() + "'";
		}
		if (userModel.getPHOB_Terms() != null) {
			if (setter == null) {
				setter = "PHOB_Terms ='" + userModel.getPHOB_Terms() + "'";
			} else
				setter += ", PHOB_Terms ='" + userModel.getPHOB_Terms() + "'";
		}
		if (userModel.getPHOB_WelcomeMail() != null) {
			if (setter == null) {
				setter = "PHOB_WelcomeMail ='" + userModel.getPHOB_WelcomeMail() + "'";
			} else
				setter += ", PHOB_WelcomeMail ='" + userModel.getPHOB_WelcomeMail() + "'";
		}
		if (userModel.getPHOB_Created() != null) {
			if (setter == null) {
				setter = "PHOB_Created ='" + Payhind_DBManager.convertJavaDateToSqlDate(userModel.getPHOB_Created()) + "'";
			} else
				setter += ", PHOB_Created ='" + Payhind_DBManager.convertJavaDateToSqlDate(userModel.getPHOB_Created())
						+ "'";
		}
		if (userModel.getPHOB_ResetPasswordToken() != null) {
			if (setter == null) {
				setter = "PHOB_ResetPasswordToken ='" + userModel.getPHOB_ResetPasswordToken() + "'";
			} else
				setter += ", PHOB_ResetPasswordToken ='" + userModel.getPHOB_ResetPasswordToken() + "'";
		}
		if (userModel.getPHOB_SignUp() != null) {
			if (setter == null) {
				setter = "PHOB_SignUp ='" + userModel.getPHOB_SignUp() + "'";
			} else
				setter += ", PHOB_SignUp ='" + userModel.getPHOB_SignUp() + "'";
		}
		if (userModel.getPHOB_ResetPasswordExpired() != null) {
			if (setter == null) {
				setter = "PHOB_ResetPasswordExpired ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(userModel.getPHOB_ResetPasswordExpired()) + "'";
			} else
				setter += ", PHOB_ResetPasswordExpired ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(userModel.getPHOB_ResetPasswordExpired()) + "'";
		}
		if (userModel.getPHOB_PCONotes() != null) {
			if (setter == null) {
				setter = "PHOB_PCONotes ='" + userModel.getPHOB_PCONotes() + "'";
			} else
				setter += ", PHOB_PCONotes ='" + userModel.getPHOB_PCONotes() + "'";
		}
		if (userModel.getPHOB_KycSrNo() != null) {
			if (setter == null) {
				setter = "PHOB_KycSrNo ='" + userModel.getPHOB_KycSrNo() + "'";
			} else
				setter += ", PHOB_KycSrNo ='" + userModel.getPHOB_KycSrNo() + "'";
		}
		if (userModel.getPHOB_KYCEverythingValid() != null) {
			if (setter == null) {
				setter = "PHOB_KYCEverythingValid ='" + userModel.getPHOB_KYCEverythingValid() + "'";
			} else
				setter += ", PHOB_KYCEverythingValid ='" + userModel.getPHOB_KYCEverythingValid() + "'";
		}
		if (userModel.getPHOB_FollowUpFollowUpStatus() != null) {
			if (setter == null) {
				setter = "PHOB_FollowUpFollowUpStatus ='" + userModel.getPHOB_FollowUpFollowUpStatus() + "'";
			} else
				setter += ", PHOB_FollowUpFollowUpStatus ='" + userModel.getPHOB_FollowUpFollowUpStatus() + "'";
		}
		if (userModel.getPHOB_FollowUpFollowUpStatusList() != null) {
			if (setter == null) {
				setter = "PHOB_FollowUpFollowUpStatusList ='" + userModel.getPHOB_FollowUpFollowUpStatusList() + "'";
			} else
				setter += ", PHOB_FollowUpFollowUpStatusList ='" + userModel.getPHOB_FollowUpFollowUpStatusList() + "'";
		}

		if (userModel.getPHOB_FollowUpGeneralSearch() != null) {
			if (setter == null) {
				setter = "PHOB_FollowUpGeneralSearch ='" + userModel.getPHOB_FollowUpGeneralSearch() + "'";
			} else
				setter += ", PHOB_FollowUpGeneralSearch ='" + userModel.getPHOB_FollowUpGeneralSearch() + "'";
		}
		if (userModel.getPHOB_FollowUpGeneralsearchRange() != null) {
			if (setter == null) {
				setter = "PHOB_FollowUpGeneralsearchRange ='" + userModel.getPHOB_FollowUpGeneralsearchRange() + "'";
			} else
				setter += ", PHOB_FollowUpGeneralsearchRange ='" + userModel.getPHOB_FollowUpGeneralsearchRange() + "'";
		}
		if (userModel.getPHOB_BasicDetailsIsFilled() != null) {
			if (setter == null) {
				setter = "PHOB_BasicDetailsIsFilled ='" + userModel.getPHOB_BasicDetailsIsFilled() + "'";
			} else
				setter += ", PHOB_BasicDetailsIsFilled ='" + userModel.getPHOB_BasicDetailsIsFilled() + "'";
		}
		if (userModel.getPHOB_BasicDetailsFirstName() != null) {
			if (setter == null) {
				setter = "PHOB_BasicDetailsFirstName ='" + userModel.getPHOB_BasicDetailsFirstName() + "'";
			} else
				setter += ", PHOB_BasicDetailsFirstName ='" + userModel.getPHOB_BasicDetailsFirstName() + "'";
		}

		if (userModel.getPHOB_BasicDetailsLastName() != null) {
			if (setter == null) {
				setter = "PHOB_BasicDetailsLastName ='" + userModel.getPHOB_BasicDetailsLastName() + "'";
			} else
				setter += ", PHOB_BasicDetailsLastName ='" + userModel.getPHOB_BasicDetailsLastName() + "'";
		}
		if (userModel.getPHOB_BasicDetailsNatureOfBussiness() != null) {
			if (setter == null) {
				setter = "PHOB_BasicDetailsNatureOfBussiness ='" + userModel.getPHOB_BasicDetailsNatureOfBussiness()
						+ "'";
			} else
				setter += ", PHOB_BasicDetailsNatureOfBussiness ='" + userModel.getPHOB_BasicDetailsNatureOfBussiness()
						+ "'";
		}
		if (userModel.getPHOB_BasicDetailsIfAnyAboutBussiness() != null) {
			if (setter == null) {
				setter = "PHOB_BasicDetailsIfAnyAboutBussiness ='" + userModel.getPHOB_BasicDetailsIfAnyAboutBussiness()
						+ "'";
			} else
				setter += ", PHOB_BasicDetailsIfAnyAboutBussiness ='"
						+ userModel.getPHOB_BasicDetailsIfAnyAboutBussiness() + "'";
		}
		if (userModel.getPHOB_BasicDetailsHowYouKnow() != null) {
			if (setter == null) {
				setter = "PHOB_BasicDetailsHowYouKnow ='" + userModel.getPHOB_BasicDetailsHowYouKnow() + "'";
			} else
				setter += ", PHOB_BasicDetailsHowYouKnow ='" + userModel.getPHOB_BasicDetailsHowYouKnow() + "'";
		}
		if (userModel.getPHOB_BasicDetailsComAddressOne() != null) {
			if (setter == null) {
				setter = "PHOB_BasicDetailsComAddressOne ='" + userModel.getPHOB_BasicDetailsComAddressOne() + "'";
			} else
				setter += ", PHOB_BasicDetailsComAddressOne ='" + userModel.getPHOB_BasicDetailsComAddressOne() + "'";
		}
		if (userModel.getPHOB_BasicDetailsComAddressTwo() != null) {
			if (setter == null) {
				setter = "PHOB_BasicDetailsComAddressTwo ='" + userModel.getPHOB_BasicDetailsComAddressTwo() + "'";
			} else
				setter += ", PHOB_BasicDetailsComAddressTwo ='" + userModel.getPHOB_BasicDetailsComAddressTwo() + "'";
		}
		if (userModel.getPHOB_BasicDetailsComAddressThree() != null) {
			if (setter == null) {
				setter = "PHOB_BasicDetailsComAddressThree ='" + userModel.getPHOB_BasicDetailsComAddressThree() + "'";
			} else
				setter += ", PHOB_BasicDetailsComAddressThree ='" + userModel.getPHOB_BasicDetailsComAddressThree()
						+ "'";
		}
		if (userModel.getPHOB_BasicDetailsComCity() != null) {
			if (setter == null) {
				setter = "PHOB_BasicDetailsComCity ='" + userModel.getPHOB_BasicDetailsComCity() + "'";
			} else
				setter += ", PHOB_BasicDetailsComCity ='" + userModel.getPHOB_BasicDetailsComCity() + "'";
		}
		if (userModel.getPHOB_BasicDetailsComState() != null) {
			if (setter == null) {
				setter = "PHOB_BasicDetailsComState ='" + userModel.getPHOB_BasicDetailsComState() + "'";
			} else
				setter += ", PHOB_BasicDetailsComState ='" + userModel.getPHOB_BasicDetailsComState() + "'";
		}
		if (userModel.getPHOB_BasicDetailsComPincode() != null) {
			if (setter == null) {
				setter = "PHOB_BasicDetailsComPincode ='" + userModel.getPHOB_BasicDetailsComPincode() + "'";
			} else
				setter += ", PHOB_BasicDetailsComPincode ='" + userModel.getPHOB_BasicDetailsComPincode() + "'";
		}
		if (userModel.getPHOB_KycStatusIsKycVerifiedByOfficial() != null) {
			if (setter == null) {
				setter = "PHOB_KycStatusIsKycVerifiedByOfficial ='"
						+ userModel.getPHOB_KycStatusIsKycVerifiedByOfficial() + "'";
			} else
				setter += ", PHOB_KycStatusIsKycVerifiedByOfficial ='"
						+ userModel.getPHOB_KycStatusIsKycVerifiedByOfficial() + "'";
		}
		if (userModel.getPHOB_KycStatusIsWalletCreated() != null) {
			if (setter == null) {
				setter = "PHOB_KycStatusIsWalletCreated ='" + userModel.getPHOB_KycStatusIsWalletCreated() + "'";
			} else
				setter += ", PHOB_KycStatusIsWalletCreated ='" + userModel.getPHOB_KycStatusIsWalletCreated() + "'";
		}
		if (userModel.getPHOB_KycStatusIsActivation() != null) {
			if (setter == null) {
				setter = "PHOB_KycStatusIsActivation ='" + userModel.getPHOB_KycStatusIsActivation() + "'";
			} else
				setter += ", PHOB_KycStatusIsActivation ='" + userModel.getPHOB_KycStatusIsActivation() + "'";
		}
		if (userModel.getPHOB_KycStatusIsOtpSession() != null) {
			if (setter == null) {
				setter = "PHOB_KycStatusIsOtpSession ='" + userModel.getPHOB_KycStatusIsOtpSession() + "'";
			} else
				setter += ", PHOB_KycStatusIsOtpSession ='" + userModel.getPHOB_KycStatusIsOtpSession() + "'";
		}
		if (userModel.getPHOB_KycStatusPremilinaryReview() != null) {
			if (setter == null) {
				setter = "PHOB_KycStatusPremilinaryReview ='" + userModel.getPHOB_KycStatusPremilinaryReview() + "'";
			} else
				setter += ", PHOB_KycStatusPremilinaryReview ='" + userModel.getPHOB_KycStatusPremilinaryReview() + "'";
		}
		if (userModel.getPHOB_KycStatusRemarks() != null) {
			if (setter == null) {
				setter = "PHOB_KycStatusRemarks ='" + userModel.getPHOB_KycStatusRemarks() + "'";
			} else
				setter += ", PHOB_KycStatusRemarks ='" + userModel.getPHOB_KycStatusRemarks() + "'";
		}
		if (userModel.getPHOB_Future_Field1() != null) {
			if (setter == null) {
				setter = "PHOB_Future_Field1 ='" + userModel.getPHOB_Future_Field1() + "'";
			} else
				setter += ", PHOB_Future_Field1 ='" + userModel.getPHOB_Future_Field1() + "'";
		}
		if (userModel.getPHOB_Future_Field2() != null) {
			if (setter == null) {
				setter = "PHOB_Future_Field2 ='" + userModel.getPHOB_Future_Field2() + "'";
			} else
				setter += ", PHOB_Future_Field2 ='" + userModel.getPHOB_Future_Field2() + "'";
		}
		if (userModel.getPHOB_Future_Field3() != null) {
			if (setter == null) {
				setter = "PHOB_Future_Field3 ='" + userModel.getPHOB_Future_Field3() + "'";
			} else
				setter += ", PHOB_Future_Field3 ='" + userModel.getPHOB_Future_Field3() + "'";
		}
		if (userModel.getPHOB_Future_Field4() != null) {
			if (setter == null) {
				setter = "PHOB_Future_Field4 ='" + userModel.getPHOB_Future_Field4() + "'";
			} else
				setter += ", PHOB_Future_Field4 ='" + userModel.getPHOB_Future_Field4() + "'";
		}
		if (userModel.getPHOB_Future_Field5() != null) {
			if (setter == null) {
				setter = "PHOB_Future_Field5 ='" + userModel.getPHOB_Future_Field5() + "'";
			} else
				setter += ", PHOB_Future_Field5 ='" + userModel.getPHOB_Future_Field5() + "'";
		}
		if (userModel.getPHOB_Future_Field6() != null) {
			if (setter == null) {
				setter = "PHOB_Future_Field6 ='" + userModel.getPHOB_Future_Field6() + "'";
			} else
				setter += ", PHOB_Future_Field6 ='" + userModel.getPHOB_Future_Field6() + "'";
		}
		if (userModel.getPHOB_OTPDate() != null) {
			if (setter == null) {
				setter = "PHOB_OTPDate ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(userModel.getPHOB_OTPDate()) + "'";
			} else
				setter += ", PHOB_OTPDate ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(userModel.getPHOB_OTPDate()) + "'";
		}
		if (userModel.getPHOB_OTPTime() != null) {
			if (setter == null) {
				setter = "PHOB_OTPTime ='" + userModel.getPHOB_OTPTime() + "'";
			} else
				setter += ", PHOB_OTPTime ='" + userModel.getPHOB_OTPTime() + "'";
		}

		System.out.println("Setter= " + setter);

		if (userModel.getOnBoard().getPHOB_PersonalDetailsFullName() != null)
			kycSetter = "PHOB_PersonalDetailsFullName='" + userModel.getOnBoard().getPHOB_PersonalDetailsFullName()
					+ "' ";
		if (userModel.getOnBoard().getPHOB_PersonalDetailsPictureURL() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_PersonalDetailsPictureURL ='"
						+ userModel.getOnBoard().getPHOB_PersonalDetailsPictureURL() + "'";
			} else
				kycSetter += ", PHOB_PersonalDetailsPictureURL ='"
						+ userModel.getOnBoard().getPHOB_PersonalDetailsPictureURL() + "'";
		}
		if (userModel.getOnBoard().getPHOB_PersonalDetailsPicture() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_PersonalDetailsPicture ='"
						+ userModel.getOnBoard().getPHOB_PersonalDetailsPicture() + "'";
			} else
				kycSetter += ", PHOB_PersonalDetailsPicture ='"
						+ userModel.getOnBoard().getPHOB_PersonalDetailsPicture() + "'";
		}
		if (userModel.getOnBoard().getPHOB_PersonalDetailsDob() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_PersonalDetailsDob ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(userModel.getOnBoard().getPHOB_PersonalDetailsDob())
						+ "'";
			} else
				kycSetter += ", PHOB_PersonalDetailsDob ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(userModel.getOnBoard().getPHOB_PersonalDetailsDob())
						+ "'";
		}
		if (userModel.getOnBoard().getPHOB_PersonalDetailsMotherName() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_PersonalDetailsMotherName ='"
						+ userModel.getOnBoard().getPHOB_PersonalDetailsMotherName() + "'";
			} else
				kycSetter += ", PHOB_PersonalDetailsMotherName ='"
						+ userModel.getOnBoard().getPHOB_PersonalDetailsMotherName() + "'";
		}
		if (userModel.getOnBoard().getPHOB_PersonalDetailsGender() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_PersonalDetailsGender ='" + userModel.getOnBoard().getPHOB_PersonalDetailsGender()
						+ "'";
			} else
				kycSetter += ", PHOB_PersonalDetailsGender ='" + userModel.getOnBoard().getPHOB_PersonalDetailsGender()
						+ "'";
		}
		if (userModel.getOnBoard().getPHOB_BusinessDetailsBusinessName() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_BusinessDetailsBusinessName ='"
						+ userModel.getOnBoard().getPHOB_BusinessDetailsBusinessName() + "'";
			} else
				kycSetter += ", PHOB_BusinessDetailsBusinessName ='"
						+ userModel.getOnBoard().getPHOB_BusinessDetailsBusinessName() + "'";
		}
		if (userModel.getOnBoard().getPHOB_BusinessDetailsNatureofBusiness() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_BusinessDetailsNatureofBusiness ='"
						+ userModel.getOnBoard().getPHOB_BusinessDetailsNatureofBusiness() + "'";
			} else
				kycSetter += ", PHOB_BusinessDetailsNatureofBusiness ='"
						+ userModel.getOnBoard().getPHOB_BusinessDetailsNatureofBusiness() + "'";
		}
		if (userModel.getOnBoard().getPHOB_BusinessDetailsIfany() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_BusinessDetailsIfany ='" + userModel.getOnBoard().getPHOB_BusinessDetailsIfany()
						+ "'";
			} else
				kycSetter += ", PHOB_BusinessDetailsIfany ='" + userModel.getOnBoard().getPHOB_BusinessDetailsIfany()
						+ "'";
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressAddressline1() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_CommunicationDetailsPersonalAddressAddressline1 ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressAddressline1() + "'";
			} else
				kycSetter += ", PHOB_CommunicationDetailsPersonalAddressAddressline1 ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressAddressline1() + "'";
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressAddressline2() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_CommunicationDetailsPersonalAddressAddressline2 ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressAddressline2() + "'";
			} else
				kycSetter += ", PHOB_CommunicationDetailsPersonalAddressAddressline2 ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressAddressline2() + "'";
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressAddressline3() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_CommunicationDetailsPersonalAddressAddressline3 ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressAddressline3() + "'";
			} else
				kycSetter += ", PHOB_CommunicationDetailsPersonalAddressAddressline3 ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressAddressline3() + "'";
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressPersonalcity() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_CommunicationDetailsPersonalAddressPersonalcity ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressPersonalcity() + "'";
			} else
				kycSetter += ", PHOB_CommunicationDetailsPersonalAddressPersonalcity ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressPersonalcity() + "'";
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressPersonalState() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_CommunicationDetailsPersonalAddressPersonalState ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressPersonalState() + "'";
			} else
				kycSetter += ", PHOB_CommunicationDetailsPersonalAddressPersonalState ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressPersonalState() + "'";
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressPersonalpin() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_CommunicationDetailsPersonalAddressPersonalpin ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressPersonalpin() + "'";
			} else
				kycSetter += ", PHOB_CommunicationDetailsPersonalAddressPersonalpin ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsPersonalAddressPersonalpin() + "'";
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressAddressline1() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_CommunicationDetailsBusinessAddressAddressline1 ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressAddressline1() + "'";
			} else
				kycSetter += ", PHOB_CommunicationDetailsBusinessAddressAddressline1 ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressAddressline1() + "'";
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressAddressline2() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_CommunicationDetailsBusinessAddressAddressline2 ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressAddressline2() + "'";
			} else
				kycSetter += ", PHOB_CommunicationDetailsBusinessAddressAddressline2 ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressAddressline2() + "'";
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressAddressline3() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_CommunicationDetailsBusinessAddressAddressline3 ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressAddressline3() + "'";
			} else
				kycSetter += ", PHOB_CommunicationDetailsBusinessAddressAddressline3 ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressAddressline3() + "'";
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressBusinesscity() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_CommunicationDetailsBusinessAddressBusinesscity ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressBusinesscity() + "'";
			} else
				kycSetter += ", PHOB_CommunicationDetailsBusinessAddressBusinesscity ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressBusinesscity() + "'";
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressBusinessstate() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_CommunicationDetailsBusinessAddressBusinessstate ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressBusinessstate() + "'";
			} else
				kycSetter += ", PHOB_CommunicationDetailsBusinessAddressBusinessstate ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressBusinessstate() + "'";
		}
		if (userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressBusinesspin() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_CommunicationDetailsBusinessAddressBusinesspin ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressBusinesspin() + "'";
			} else
				kycSetter += ", PHOB_CommunicationDetailsBusinessAddressBusinesspin ='"
						+ userModel.getOnBoard().getPHOB_CommunicationDetailsBusinessAddressBusinesspin() + "'";
		}
		if (userModel.getOnBoard().getPHOB_BankDetailsBankName() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_BankDetailsBankName ='" + userModel.getOnBoard().getPHOB_BankDetailsBankName() + "'";
			} else
				kycSetter += ", PHOB_BankDetailsBankName ='" + userModel.getOnBoard().getPHOB_BankDetailsBankName()
						+ "'";
		}
		if (userModel.getOnBoard().getPHOB_BankDetailsBankAccountNumber() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_BankDetailsBankAccountNumber ='"
						+ userModel.getOnBoard().getPHOB_BankDetailsBankAccountNumber() + "'";
			} else
				kycSetter += ", PHOB_BankDetailsBankAccountNumber ='"
						+ userModel.getOnBoard().getPHOB_BankDetailsBankAccountNumber() + "'";
		}
		if (userModel.getOnBoard().getPHOB_BankDetailsBankBranch() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_BankDetailsBankBranch ='" + userModel.getOnBoard().getPHOB_BankDetailsBankBranch()
						+ "'";
			} else
				kycSetter += ", PHOB_BankDetailsBankBranch ='" + userModel.getOnBoard().getPHOB_BankDetailsBankBranch()
						+ "'";
		}
		if (userModel.getOnBoard().getPHOB_BankDetailsAccountType() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_BankDetailsAccountType ='" + userModel.getOnBoard().getPHOB_BankDetailsAccountType()
						+ "'";
			} else
				kycSetter += ", PHOB_BankDetailsAccountType ='"
						+ userModel.getOnBoard().getPHOB_BankDetailsAccountType() + "'";
		}
		if (userModel.getOnBoard().getPHOB_BankDetailsIfscCode() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_BankDetailsIfscCode ='" + userModel.getOnBoard().getPHOB_BankDetailsIfscCode() + "'";
			} else
				kycSetter += ", PHOB_BankDetailsIfscCode ='" + userModel.getOnBoard().getPHOB_BankDetailsIfscCode()
						+ "'";
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsPanFileURL() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_DocumentDetailsPanFileURL ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsPanFileURL() + "'";
			} else
				kycSetter += ", PHOB_DocumentDetailsPanFileURL ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsPanFileURL() + "'";
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsPanFile() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_DocumentDetailsPanFile ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsPanFile() + "'";
			} else
				kycSetter += ", PHOB_DocumentDetailsPanFile ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsPanFile() + "'";
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileURLFrontSide() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_DocumentDetailsResidenceFileURLFrontSide ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileURLFrontSide() + "'";
			} else
				kycSetter += ", PHOB_DocumentDetailsResidenceFileURLFrontSide ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileURLFrontSide() + "'";
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileFrontSide() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_DocumentDetailsResidenceFileFrontSide ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileFrontSide() + "'";
			} else
				kycSetter += ", PHOB_DocumentDetailsResidenceFileFrontSide ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileFrontSide() + "'";
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileURLBackSide() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_DocumentDetailsResidenceFileURLBackSide ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileURLBackSide() + "'";
			} else
				kycSetter += ", PHOB_DocumentDetailsResidenceFileURLBackSide ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileURLBackSide() + "'";
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileBackSide() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_DocumentDetailsResidenceFileBackSide ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileBackSide() + "'";
			} else
				kycSetter += ", PHOB_DocumentDetailsResidenceFileBackSide ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsResidenceFileBackSide() + "'";
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsBusinessFileURL() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_DocumentDetailsBusinessFileURL ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsBusinessFileURL() + "'";
			} else
				kycSetter += ", PHOB_DocumentDetailsBusinessFileURL ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsBusinessFileURL() + "'";
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsBusinessFile() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_DocumentDetailsBusinessFile ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsBusinessFile() + "'";
			} else
				kycSetter += ", PHOB_DocumentDetailsBusinessFile ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsBusinessFile() + "'";
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsPCOSignatureURL() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_DocumentDetailsPCOSignatureURL ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsPCOSignatureURL() + "'";
			} else
				kycSetter += ", PHOB_DocumentDetailsPCOSignatureURL ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsPCOSignatureURL() + "'";
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsPCOSignature() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_DocumentDetailsPCOSignature ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsPCOSignature() + "'";
			} else
				kycSetter += ", PHOB_DocumentDetailsPCOSignature ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsPCOSignature() + "'";
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsIfany() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_DocumentDetailsIfany ='" + userModel.getOnBoard().getPHOB_DocumentDetailsIfany()
						+ "'";
			} else
				kycSetter += ", PHOB_DocumentDetailsIfany ='" + userModel.getOnBoard().getPHOB_DocumentDetailsIfany()
						+ "'";
		}
		if (userModel.getOnBoard().getPHOB_DocumentDetailsAgreement() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_DocumentDetailsAgreement ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsAgreement() + "'";
			} else
				kycSetter += ", PHOB_DocumentDetailsAgreement ='"
						+ userModel.getOnBoard().getPHOB_DocumentDetailsAgreement() + "'";
		}
		if (userModel.getOnBoard().getPHOB_Created() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_Created ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(userModel.getOnBoard().getPHOB_Created()) + "'";
			} else
				kycSetter += ", PHOB_Created ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(userModel.getOnBoard().getPHOB_Created()) + "'";
		}
		if (userModel.getOnBoard().getPHOB_User() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_User ='" + userModel.getOnBoard().getPHOB_User() + "'";
			} else
				kycSetter += ", PHOB_User ='" + userModel.getOnBoard().getPHOB_User() + "'";
		}
		if (userModel.getOnBoard().getPHOB_KYCUPdateDate() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_KYCUPdateDate ='" + Payhind_DBManager.convertJavaDateToSqlDate(userModel.getOnBoard().getPHOB_KYCUPdateDate()) + "'";
			} else
				kycSetter += ", PHOB_KYCUPdateDate ='" + Payhind_DBManager.convertJavaDateToSqlDate(userModel.getOnBoard().getPHOB_KYCUPdateDate()) + "'";
		}
		if (userModel.getOnBoard().getPHOB_KYCUpdatedBy() != null) {
			if (kycSetter == null) {
				kycSetter = "PHOB_KYCUpdatedBy ='" + userModel.getOnBoard().getPHOB_KYCUpdatedBy() + "'";
			} else
				kycSetter += ", PHOB_KYCUpdatedBy ='" + userModel.getOnBoard().getPHOB_KYCUpdatedBy() + "'";
		}
		

		System.out.println("kycSetter= " + kycSetter);

		mainSetter = "UPDATE PHMC_PHOB_USER SET " + setter + " WHERE PHOB_PCOID=" + phob_pcoID + "; "
				+ "UPDATE PHMC_PHOB_ONBOARD SET " + kycSetter + "WHERE PHOB_User=" + phob_pcoID + ";";

		return mainSetter;
	}

	
	
	
	/**
	 * @author rahul makvana
	 * @param KycFormModel
	 * @return isUpdateSuccess
	 * 
	 *         this method for create and Update operation for PHOB_USER and PHOB_ONBOARD table from
	 *         PHMC-MASTER database.
	 *
	 */

	public ErrorMessage phmc_phob_createUpdateKycWithUser(long phob_pcoID, PHMC_PHOB_USER userModel) {

		int isUpdateSuccess = 0;
		int isKycUpdateSuccess = 0;
		Connection PHMC_conn = null;
		PreparedStatement PHMC_pst = null;
		String setter = "";

		ErrorMessage msg = new ErrorMessage();

		if (userModel != null) {

			try {
				PHMC_conn = Payhind_DBManager.payhind_getConnection();

				isUpdateSuccess = Payhind_DBManager.phob_checkIfUserExist(PHMC_conn, phob_pcoID, "PHMC_PHOB_USER");
				isKycUpdateSuccess = Payhind_DBManager.phob_checkIfUserExist(PHMC_conn, phob_pcoID, "PHMC_PHOB_ONBOARD");

				if(isUpdateSuccess == PHMC_DB_ERROR.PHMC_USER_NOT_EXIST
						&& isKycUpdateSuccess == PHMC_DB_ERROR.PHMC_USER_NOT_EXIST){
					PHMC_conn.setAutoCommit(false);

					setter = setterForInsertUserWithKyc(userModel);

					PHMC_pst = PHMC_conn.prepareStatement(setter);

					isUpdateSuccess = PHMC_pst.executeUpdate();

					msg.setErrorCode(PHMC_DB_ERROR.PHMC_SUCCESS);
					msg.setErrorMessage("PCO with ID " + userModel.getPHOB_PCOID() + " Created Successfully");
					PHMC_conn.commit();
					
				}
				else if (isUpdateSuccess == PHMC_DB_ERROR.PHMC_USER_ALREADY_EXISTS
						&& isKycUpdateSuccess == PHMC_DB_ERROR.PHMC_USER_ALREADY_EXISTS) {
					setter = setterForUpdateUserWithKyc(userModel, phob_pcoID);

					PHMC_conn.setAutoCommit(false);

					PHMC_pst = PHMC_conn.prepareStatement(setter);
					isUpdateSuccess = PHMC_pst.executeUpdate();

					msg.setErrorCode(PHMC_DB_ERROR.PHMC_SUCCESS);
					msg.setErrorMessage("PCO with ID " + userModel.getPHOB_PCOID() + " Updated Successfully");
					PHMC_conn.commit();
					
				}
				else if(isUpdateSuccess == PHMC_DB_ERROR.PHMC_DUPLICATE_RECORD_FOUND
						&& isKycUpdateSuccess == PHMC_DB_ERROR.PHMC_DUPLICATE_RECORD_FOUND) {
					msg.setErrorCode(PHMC_DB_ERROR.PHMC_DUPLICATE_RECORD_FOUND);
					msg.setErrorMessage("PCO with ID " + userModel.getPHOB_PCOID() + " Duplicaate Record Found");
				}

			} catch (ClassNotFoundException e) {
				isUpdateSuccess = PHMC_DB_ERROR.PHMC_SCFG_FILE_NOT_FOUND;
				msg.setErrorCode(PHMC_DB_ERROR.PHMC_SCFG_FILE_NOT_FOUND);
				msg.setErrorMessage("PCO with ID " + userModel.getPHOB_PCOID() + " Not Found");
				e.printStackTrace();
			} catch (NullPointerException | SQLException e) {
				isUpdateSuccess = PHMC_DB_ERROR.PHMC_UPDATE_FAILED;
				msg.setErrorCode(PHMC_DB_ERROR.PHMC_UPDATE_FAILED);
				msg.setErrorMessage("PCO with ID " + userModel.getPHOB_PCOID() + " Updation Failed");
				e.printStackTrace();
			} finally {
				if (PHMC_pst != null) {
					try {
						PHMC_pst.close();
						PHMC_conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		System.out.println("Status code is=" + msg.getErrorCode());
		System.out.println("Status msg is=" + msg.getErrorMessage());
		return msg;

	}
}
