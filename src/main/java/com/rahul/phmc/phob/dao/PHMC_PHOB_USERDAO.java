
package com.rahul.phmc.phob.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rahul.phmc.phob.model.PHMC_PHOB_USER;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.PHMC_DB_ERROR;
import com.rahul.phmc.util.Payhind_DBManager;

public class PHMC_PHOB_USERDAO {

	private PHMC_PHOB_USER phmc_phob_pco;
	private ResultSet phmc_rs;
	private ArrayList<PHMC_PHOB_USER> phmc_phob_pcoList;

	/**
	 * @param phmc_phob_pcoID
	 * @return phmc_phob_pco this method is for read data from PHMC_PHOB_USER
	 *         Table for particular PCOID.
	 */
	public PHMC_PHOB_USER phmc_pco_readPCODetail(Long phmc_phob_pcoID) {

		String sopdb_selectQuary = "SELECT PHOB_UserSrNo, PHOB_PCOID, PHOB_Email, PHOB_Phone , PHOB_Password, PHOB_Salt "
				+ ", PHOB_PCORoles, PHOB_UpdatedDate, PHOB_UpdatedBy, PHOB_Terms, PHOB_WelcomeMail, PHOB_Created, PHOB_ResetPasswordToken "
				+ ", PHOB_SignUp, PHOB_ResetPasswordExpired, PHOB_PCONotes, PHOB_KycSrNo, PHOB_KYCEverythingValid, PHOB_FollowUpFollowUpStatus "
				+ ", PHOB_FollowUpFollowUpStatusList , PHOB_FollowUpGeneralSearch , PHOB_FollowUpGeneralsearchRange , PHOB_BasicDetailsIsFilled "
				+ ", PHOB_BasicDetailsFirstName , PHOB_BasicDetailsLastName , PHOB_BasicDetailsNatureOfBussiness, PHOB_BasicDetailsIfAnyAboutBussiness"
				+ ", PHOB_BasicDetailsHowYouKnow , PHOB_BasicDetailsComAddressOne ,PHOB_BasicDetailsComAddressTwo, PHOB_BasicDetailsComAddressThree "
				+ ", PHOB_BasicDetailsComCity, PHOB_BasicDetailsComState, PHOB_BasicDetailsComPincode "
				+ ", PHOB_KycStatusIsKycVerifiedByOfficial,PHOB_KycStatusIsWalletCreated , PHOB_KycStatusIsActivation, PHOB_KycStatusIsOtpSession "
				+ ", PHOB_KycStatusPremilinaryReview, PHOB_KycStatusRemarks, PHOB_Future_Field1, PHOB_Future_Field2, PHOB_Future_Field3, PHOB_Future_Field4 "
				+ ", PHOB_Future_Field5 , PHOB_Future_Field6, PHOB_OTPDate, PHOB_OTPTime, PHOB_DIST_ID FROM PHMC_PHOB_USER WHERE PHOB_PCOID = ? ORDER BY PHOB_Created ";

		// get Database Connection
		try (Connection sopdb_conn = Payhind_DBManager.payhind_getConnection();
				PreparedStatement sopdb_pst = sopdb_conn.prepareStatement(sopdb_selectQuary)) {

			sopdb_pst.setLong(1, phmc_phob_pcoID);

			phmc_rs = sopdb_pst.executeQuery();

			while (phmc_rs.next()) {

				// System.out.println(sopdb_rs.getRow());
				phmc_phob_pco = new PHMC_PHOB_USER();

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
				phmc_phob_pco.setPHOB_Created(phmc_rs.getDate("PHOB_Created"));
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
				phmc_phob_pco.setPHOB_DIST_ID(phmc_rs.getString("PHOB_DIST_ID"));
				
				System.out.println(phmc_phob_pco);

			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return phmc_phob_pco;

	}

	/**
	 * @param phmc_om_pageStart
	 * @param phmc_om_size
	 * @return
	 */
	public ArrayList<PHMC_PHOB_USER> phmc_pco_readAllPCO(Integer phmc_om_pageStart, Integer phmc_om_size,
			String whereCluase) {

		String sql = "SELECT * from PHMC_PHOB_USER";
		System.out.println("phmc_om_pageStart :" + phmc_om_pageStart + "\n phmc_om_size : " + phmc_om_size);
		if (whereCluase != null && !whereCluase.equals("")) {
			sql = sql + " WHERE " + whereCluase + " ";
		}
		if (phmc_om_pageStart != null && phmc_om_size != null) {
			sql = sql + " ORDER BY PHOB_Created DESC" + " OFFSET " + phmc_om_size * (phmc_om_pageStart - 1)
					+ " ROWS FETCH NEXT " + phmc_om_size + " ROWS ONLY ";
		}

		System.out.println("sql : " + sql);
		try (Connection phmc_mo_con = Payhind_DBManager.payhind_getConnection();
				PreparedStatement phmc_om_pst = phmc_mo_con.prepareStatement(sql)) {

			ResultSet phmc_om_rs = phmc_om_pst.executeQuery();
			phmc_phob_pcoList = new ArrayList<>();
			while (phmc_om_rs.next()) {

				phmc_phob_pco = new PHMC_PHOB_USER();

				phmc_phob_pco.setPHOB_UserSrNo(phmc_om_rs.getLong("PHOB_UserSrNo"));
				phmc_phob_pco.setPHOB_PCOID(phmc_om_rs.getLong("PHOB_PCOID"));
				phmc_phob_pco.setPHOB_Email(phmc_om_rs.getString("PHOB_Email"));
				phmc_phob_pco.setPHOB_Phone(phmc_om_rs.getLong("PHOB_Phone"));
				phmc_phob_pco.setPHOB_Password(phmc_om_rs.getString("PHOB_Password"));
				phmc_phob_pco.setPHOB_Salt(phmc_om_rs.getString("PHOB_Salt"));
				phmc_phob_pco.setPHOB_PCORoles(phmc_om_rs.getString("PHOB_PCORoles"));
				phmc_phob_pco.setPHOB_UpdatedDate(phmc_om_rs.getDate("PHOB_UpdatedDate"));
				phmc_phob_pco.setPHOB_UpdatedBy(phmc_om_rs.getString("PHOB_UpdatedBy"));
				phmc_phob_pco.setPHOB_Terms(phmc_om_rs.getString("PHOB_Terms"));
				phmc_phob_pco.setPHOB_WelcomeMail(phmc_om_rs.getString("PHOB_WelcomeMail"));
				phmc_phob_pco.setPHOB_Created(phmc_om_rs.getDate("PHOB_Created"));
				phmc_phob_pco.setPHOB_ResetPasswordToken(phmc_om_rs.getInt("PHOB_ResetPasswordToken"));
				phmc_phob_pco.setPHOB_SignUp(phmc_om_rs.getString("PHOB_SignUp"));
				phmc_phob_pco.setPHOB_ResetPasswordExpired(phmc_om_rs.getDate("PHOB_ResetPasswordExpired"));
				phmc_phob_pco.setPHOB_PCONotes(phmc_om_rs.getString("PHOB_PCONotes"));
				phmc_phob_pco.setPHOB_KycSrNo(phmc_om_rs.getLong("PHOB_KycSrNo"));
				phmc_phob_pco.setPHOB_KYCEverythingValid(phmc_om_rs.getString("PHOB_KYCEverythingValid"));
				phmc_phob_pco.setPHOB_FollowUpFollowUpStatus(phmc_om_rs.getString("PHOB_FollowUpFollowUpStatus"));
				phmc_phob_pco
						.setPHOB_FollowUpFollowUpStatusList(phmc_om_rs.getString("PHOB_FollowUpFollowUpStatusList"));
				phmc_phob_pco.setPHOB_FollowUpGeneralSearch(phmc_om_rs.getString("PHOB_FollowUpGeneralSearch"));
				phmc_phob_pco
						.setPHOB_FollowUpGeneralsearchRange(phmc_om_rs.getString("PHOB_FollowUpGeneralsearchRange"));
				phmc_phob_pco.setPHOB_BasicDetailsIsFilled(phmc_om_rs.getString("PHOB_BasicDetailsIsFilled"));
				phmc_phob_pco.setPHOB_BasicDetailsFirstName(phmc_om_rs.getString("PHOB_BasicDetailsFirstName"));
				phmc_phob_pco.setPHOB_BasicDetailsLastName(phmc_om_rs.getString("PHOB_BasicDetailsLastName"));
				phmc_phob_pco.setPHOB_BasicDetailsNatureOfBussiness(
						phmc_om_rs.getString("PHOB_BasicDetailsNatureOfBussiness"));
				phmc_phob_pco.setPHOB_BasicDetailsIfAnyAboutBussiness(
						phmc_om_rs.getString("PHOB_BasicDetailsIfAnyAboutBussiness"));
				phmc_phob_pco.setPHOB_BasicDetailsHowYouKnow(phmc_om_rs.getString("PHOB_BasicDetailsHowYouKnow"));
				phmc_phob_pco.setPHOB_BasicDetailsComAddressOne(phmc_om_rs.getString("PHOB_BasicDetailsComAddressOne"));
				phmc_phob_pco.setPHOB_BasicDetailsComAddressTwo(phmc_om_rs.getString("PHOB_BasicDetailsComAddressTwo"));
				phmc_phob_pco
						.setPHOB_BasicDetailsComAddressThree(phmc_om_rs.getString("PHOB_BasicDetailsComAddressThree"));
				phmc_phob_pco.setPHOB_BasicDetailsComCity(phmc_om_rs.getString("PHOB_BasicDetailsComCity"));
				phmc_phob_pco.setPHOB_BasicDetailsComState(phmc_om_rs.getString("PHOB_BasicDetailsComState"));
				phmc_phob_pco.setPHOB_BasicDetailsComPincode(phmc_om_rs.getInt("PHOB_BasicDetailsComPincode"));
				phmc_phob_pco.setPHOB_KycStatusIsKycVerifiedByOfficial(
						phmc_om_rs.getString("PHOB_KycStatusIsKycVerifiedByOfficial"));
				phmc_phob_pco.setPHOB_KycStatusIsWalletCreated(phmc_om_rs.getString("PHOB_KycStatusIsWalletCreated"));
				phmc_phob_pco.setPHOB_KycStatusIsActivation(phmc_om_rs.getString("PHOB_KycStatusIsActivation"));
				phmc_phob_pco.setPHOB_KycStatusIsOtpSession(phmc_om_rs.getString("PHOB_KycStatusIsOtpSession"));
				phmc_phob_pco
						.setPHOB_KycStatusPremilinaryReview(phmc_om_rs.getString("PHOB_KycStatusPremilinaryReview"));
				phmc_phob_pco.setPHOB_KycStatusRemarks(phmc_om_rs.getString("PHOB_KycStatusRemarks"));
				phmc_phob_pco.setPHOB_Future_Field1(phmc_om_rs.getString("PHOB_Future_Field1"));
				phmc_phob_pco.setPHOB_Future_Field2(phmc_om_rs.getString("PHOB_Future_Field2"));
				phmc_phob_pco.setPHOB_Future_Field3(phmc_om_rs.getString("PHOB_Future_Field3"));
				phmc_phob_pco.setPHOB_Future_Field4(phmc_om_rs.getString("PHOB_Future_Field4"));
				phmc_phob_pco.setPHOB_Future_Field5(phmc_om_rs.getString("PHOB_Future_Field5"));
				phmc_phob_pco.setPHOB_Future_Field6(phmc_om_rs.getString("PHOB_Future_Field6"));
				phmc_phob_pco.setPHOB_OTPDate(phmc_om_rs.getDate("PHOB_OTPDate"));
				phmc_phob_pco.setPHOB_OTPTime(phmc_om_rs.getString("PHOB_OTPTime"));
				phmc_phob_pco.setPHOB_DIST_ID(phmc_om_rs.getString("PHOB_DIST_ID"));

				phmc_phob_pcoList.add(phmc_phob_pco);

				// System.out.println(phmc_om_rs.getString(1));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return phmc_phob_pcoList;
	}

	/**
	 * @param phmc_om_pageStart
	 * @param phmc_om_size
	 * @return
	 */
	public Integer phmc_om_getPCORecord(String whereCluase) {

		Integer phmc_om_PCORecord = 0;
		String sql = "SELECT COUNT(*) from PHMC_PHOB_USER";
		if (whereCluase != null && !whereCluase.equals("")) {
			sql = sql + " WHERE " + whereCluase + " ";
		}

		;

		System.out.println("sql : " + sql);
		try (Connection phmc_mo_con = Payhind_DBManager.payhind_getConnection();
				PreparedStatement phmc_om_pst = phmc_mo_con.prepareStatement(sql)) {

			ResultSet phmc_om_rs = phmc_om_pst.executeQuery();

			if (phmc_om_rs.next())
				phmc_om_PCORecord = phmc_om_rs.getInt(1);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return phmc_om_PCORecord;
	}

	/**
	 * @author Rahul makvana
	 * @param KycFormModel
	 * @return isInsertSuccess this class for Create(Insert) operation for
	 *         PHOB_KYCFORM table from PHMC-MASTER database.
	 *
	 */
	public ErrorMessage phmc_phob_createUser(PHMC_PHOB_USER userModel) {
		int isInsertSuccess = 0;
		Connection PHMC_conn = null;
		PreparedStatement PHMC_pst = null;
		String insertSetter = null;

		ErrorMessage msg = new ErrorMessage();

		if (userModel != null) {

			try {

				PHMC_conn = Payhind_DBManager.payhind_getConnection();

				isInsertSuccess = Payhind_DBManager.phob_checkIfUserExist(PHMC_conn, userModel.getPHOB_PCOID(),
						"PHMC_PHOB_USER");

				if (isInsertSuccess == PHMC_DB_ERROR.PHMC_USER_NOT_EXIST) {
					PHMC_conn.setAutoCommit(false);

					insertSetter = setterForInsertUser(userModel);

					PHMC_pst = PHMC_conn.prepareStatement("INSERT INTO PHMC_PHOB_USER" + insertSetter);

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

		System.out.println("Ststus code is=" + msg.getErrorCode());
		return msg;
	}

	private String setterForInsertUser(PHMC_PHOB_USER userModel) {
		String setter = null;
		String columnName = null;
		String value = null;

		if (userModel.getPHOB_PCOID() != null)
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
		if (userModel.getPHOB_DIST_ID() != null) {
			if (columnName == null) {
				columnName = "PHOB_DIST_ID ";
				value = "'" + userModel.getPHOB_DIST_ID() + "'";
			} else {
				columnName += ", PHOB_DIST_ID ";
				value += ", '" + userModel.getPHOB_DIST_ID() + "'";
			}
		}

		System.out.println("Column Name=" + columnName);
		System.out.println("Value=" + value);

		setter = "(" + columnName + ") values(" + value + ")";

		System.out.println("insert setter=" + setter);
		return setter;
	}

	/**
	 * @author rahul makvana
	 * @param PHMC_PHOB_USERModel
	 * @return isUpdateSuccess
	 * 
	 *         this class for Update operation for PHOB_USER table from
	 *         PHMC-MASTER database.
	 *
	 */

	public ErrorMessage phmc_phob_updateUser(long phob_pcoID, PHMC_PHOB_USER userModel) {

		int isUpdateSuccess = 0;
		Connection PHMC_conn = null;
		PreparedStatement PHMC_pst = null;
		String setter = "";

		ErrorMessage msg = new ErrorMessage();

		if (userModel != null) {

			try {
				PHMC_conn = Payhind_DBManager.payhind_getConnection();

				isUpdateSuccess = Payhind_DBManager.phob_checkIfUserExist(PHMC_conn, phob_pcoID, "PHMC_PHOB_USER");

				if (isUpdateSuccess == PHMC_DB_ERROR.PHMC_USER_ALREADY_EXISTS) {
					setter = setterForUpdateUser(userModel);

					PHMC_conn.setAutoCommit(false);

					PHMC_pst = PHMC_conn.prepareStatement(
							"UPDATE PHMC_PHOB_USER SET " + setter + " WHERE PHOB_PCOID=" + phob_pcoID);

					isUpdateSuccess = PHMC_pst.executeUpdate();

					msg.setErrorCode(PHMC_DB_ERROR.PHMC_SUCCESS);
					msg.setErrorMessage("PCO with ID " + phob_pcoID + " Updated Successfully");
					PHMC_conn.commit();
				} else {
					msg.setErrorCode(PHMC_DB_ERROR.PHMC_USER_NOT_EXIST);
					msg.setErrorMessage("PCO with ID " + phob_pcoID + " Not Exist");
				}

			} catch (ClassNotFoundException e) {
				isUpdateSuccess = PHMC_DB_ERROR.PHMC_SCFG_FILE_NOT_FOUND;
				msg.setErrorCode(PHMC_DB_ERROR.PHMC_SCFG_FILE_NOT_FOUND);
				msg.setErrorMessage("PCO with ID " +phob_pcoID + " Not Found");
				e.printStackTrace();
			} catch (SQLException e) {
				isUpdateSuccess = PHMC_DB_ERROR.PHMC_UPDATE_FAILED;
				msg.setErrorCode(PHMC_DB_ERROR.PHMC_UPDATE_FAILED);
				msg.setErrorMessage("PCO with ID " + phob_pcoID + " Updation Failed");
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

		System.out.println("Ststus code is=" + msg.getErrorMessage());
		return msg;

	}

	/**
	 * @author rahul makvana
	 * @param userModel
	 * @return setter
	 */
	private String setterForUpdateUser(PHMC_PHOB_USER userModel) {
		String setter = null;

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
	if (userModel.getPHOB_DIST_ID() != null) {
			if (setter == null) {
				if(userModel.getPHOB_DIST_ID()== "")
				setter = "PHOB_DIST_ID = " + null + "";
				else
					setter = "PHOB_DIST_ID = '" + userModel.getPHOB_DIST_ID() + "'";
					
			} else
				if(userModel.getPHOB_DIST_ID()== "")
					setter += ", PHOB_DIST_ID = " + null + "";
					else
						setter += ", PHOB_DIST_ID = '" + userModel.getPHOB_DIST_ID() + "'";
		}

		System.out.println("Setter= " + setter);

		return setter;
	}
}
