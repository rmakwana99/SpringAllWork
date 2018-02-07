package com.rahul.phmc.phob.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rahul.phmc.phob.model.PHMC_PHOB_ONBOARD;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.PHMC_DB_ERROR;
import com.rahul.phmc.util.Payhind_DBManager;

public class PHMC_PHOB_ONBOARDDAO {

	private PHMC_PHOB_ONBOARD phmc_phob_kycpco;
	private ResultSet phmc_rs;


	/**
	 * @param phmc_phob_pcoID
	 * @return
	 */
	public PHMC_PHOB_ONBOARD phmc_pco_readOnboardDetail(Long phmc_phob_pcoID) {

		String phmc_selectQuary = "SELECT PHOB_KycSrNo,  PHOB_PersonalDetailsFullName ,PHOB_PersonalDetailsPictureURL, PHOB_PersonalDetailsPicture, "
				+ "PHOB_PersonalDetailsDob, PHOB_PersonalDetailsMotherName, PHOB_PersonalDetailsGender, PHOB_BusinessDetailsBusinessName, "
				+ "PHOB_BusinessDetailsNatureofBusiness, PHOB_BusinessDetailsIfany, PHOB_CommunicationDetailsPersonalAddressAddressline1, "
				+ "PHOB_CommunicationDetailsPersonalAddressAddressline2, PHOB_CommunicationDetailsPersonalAddressAddressline3, PHOB_CommunicationDetailsPersonalAddressPersonalcity, "
				+ "PHOB_CommunicationDetailsPersonalAddressPersonalState, PHOB_CommunicationDetailsPersonalAddressPersonalpin, PHOB_CommunicationDetailsBusinessAddressAddressline1, "
				+ "PHOB_CommunicationDetailsBusinessAddressAddressline2, PHOB_CommunicationDetailsBusinessAddressAddressline3, PHOB_CommunicationDetailsBusinessAddressBusinesscity, "
				+ "PHOB_CommunicationDetailsBusinessAddressBusinessstate, PHOB_CommunicationDetailsBusinessAddressBusinesspin, PHOB_BankDetailsBankName, "
				+ "PHOB_BankDetailsBankAccountNumber, PHOB_BankDetailsBankBranch, PHOB_BankDetailsAccountType, PHOB_BankDetailsIfscCode, PHOB_DocumentDetailsPanFileURL, PHOB_DocumentDetailsPanFile, "
				+ "PHOB_DocumentDetailsResidenceFileURLFrontSide, PHOB_DocumentDetailsResidenceFileFrontSide, PHOB_DocumentDetailsResidenceFileURLBackSide, PHOB_DocumentDetailsResidenceFileBackSide, "
				+ "PHOB_DocumentDetailsBusinessFileURL, PHOB_DocumentDetailsBusinessFile, PHOB_DocumentDetailsPCOSignatureURL, PHOB_DocumentDetailsPCOSignature, PHOB_DocumentDetailsIfany, PHOB_DocumentDetailsAgreement, "
				+ "PHOB_Created, PHOB_User, PHOB_KYCUPdateDate, PHOB_KYCUpdatedBy FROM PHMC_PHOB_ONBOARD WHERE PHOB_User=?";

		// get Database Connection
		try (Connection phmc_conn = Payhind_DBManager.payhind_getConnection();
				PreparedStatement phmc_pst = phmc_conn.prepareStatement(phmc_selectQuary)) {

			phmc_pst.setLong(1, phmc_phob_pcoID);

			phmc_rs = phmc_pst.executeQuery();

			while (phmc_rs.next()) {

				// System.out.println(sopdb_rs.getRow());
				phmc_phob_kycpco = new PHMC_PHOB_ONBOARD();

				phmc_phob_kycpco.setPHOB_KycSrNo(phmc_rs.getLong("PHOB_KycSrNo"));
				phmc_phob_kycpco.setPHOB_PersonalDetailsFullName(phmc_rs.getString("PHOB_PersonalDetailsFullName"));
				phmc_phob_kycpco.setPHOB_PersonalDetailsPictureURL(phmc_rs.getString("PHOB_PersonalDetailsPictureURL"));
				phmc_phob_kycpco.setPHOB_PersonalDetailsPicture(phmc_rs.getString("PHOB_PersonalDetailsPicture"));
				phmc_phob_kycpco.setPHOB_PersonalDetailsDob(phmc_rs.getDate("PHOB_PersonalDetailsDob"));
				phmc_phob_kycpco.setPHOB_PersonalDetailsMotherName(phmc_rs.getString("PHOB_PersonalDetailsMotherName"));
				phmc_phob_kycpco.setPHOB_PersonalDetailsGender(phmc_rs.getString("PHOB_PersonalDetailsGender"));
				phmc_phob_kycpco
						.setPHOB_BusinessDetailsBusinessName(phmc_rs.getString("PHOB_BusinessDetailsBusinessName"));
				phmc_phob_kycpco.setPHOB_BusinessDetailsNatureofBusiness(
						phmc_rs.getString("PHOB_BusinessDetailsNatureofBusiness"));
				phmc_phob_kycpco.setPHOB_BusinessDetailsIfany(phmc_rs.getString("PHOB_BusinessDetailsIfany"));
				phmc_phob_kycpco.setPHOB_CommunicationDetailsPersonalAddressAddressline1(
						phmc_rs.getString("PHOB_CommunicationDetailsPersonalAddressAddressline1"));
				phmc_phob_kycpco.setPHOB_CommunicationDetailsPersonalAddressAddressline2(
						phmc_rs.getString("PHOB_CommunicationDetailsPersonalAddressAddressline2"));
				phmc_phob_kycpco.setPHOB_CommunicationDetailsPersonalAddressAddressline3(
						phmc_rs.getString("PHOB_CommunicationDetailsPersonalAddressAddressline3"));
				phmc_phob_kycpco.setPHOB_CommunicationDetailsPersonalAddressPersonalcity(
						phmc_rs.getString("PHOB_CommunicationDetailsPersonalAddressPersonalcity"));
				phmc_phob_kycpco.setPHOB_CommunicationDetailsPersonalAddressPersonalState(
						phmc_rs.getString("PHOB_CommunicationDetailsPersonalAddressPersonalState"));
				phmc_phob_kycpco.setPHOB_CommunicationDetailsPersonalAddressPersonalpin(
						phmc_rs.getString("PHOB_CommunicationDetailsPersonalAddressPersonalpin"));
				phmc_phob_kycpco.setPHOB_CommunicationDetailsBusinessAddressAddressline1(
						phmc_rs.getString("PHOB_CommunicationDetailsBusinessAddressAddressline1"));
				phmc_phob_kycpco.setPHOB_CommunicationDetailsBusinessAddressAddressline2(
						phmc_rs.getString("PHOB_CommunicationDetailsBusinessAddressAddressline2"));
				phmc_phob_kycpco.setPHOB_CommunicationDetailsBusinessAddressAddressline3(
						phmc_rs.getString("PHOB_CommunicationDetailsBusinessAddressAddressline3"));
				phmc_phob_kycpco.setPHOB_CommunicationDetailsBusinessAddressBusinesscity(
						phmc_rs.getString("PHOB_CommunicationDetailsBusinessAddressBusinesscity"));
				phmc_phob_kycpco.setPHOB_CommunicationDetailsBusinessAddressBusinessstate(
						phmc_rs.getString("PHOB_CommunicationDetailsBusinessAddressBusinessstate"));
				phmc_phob_kycpco.setPHOB_CommunicationDetailsBusinessAddressBusinesspin(
						phmc_rs.getString("PHOB_CommunicationDetailsBusinessAddressBusinesspin"));
				phmc_phob_kycpco.setPHOB_BankDetailsBankName(phmc_rs.getString("PHOB_BankDetailsBankName"));
				phmc_phob_kycpco
						.setPHOB_BankDetailsBankAccountNumber(phmc_rs.getLong("PHOB_BankDetailsBankAccountNumber"));
				phmc_phob_kycpco.setPHOB_BankDetailsBankBranch(phmc_rs.getString("PHOB_BankDetailsBankBranch"));
				phmc_phob_kycpco.setPHOB_BankDetailsAccountType(phmc_rs.getString("PHOB_BankDetailsAccountType"));
				phmc_phob_kycpco.setPHOB_BankDetailsIfscCode(phmc_rs.getString("PHOB_BankDetailsIfscCode"));
				phmc_phob_kycpco.setPHOB_DocumentDetailsPanFileURL(phmc_rs.getString("PHOB_DocumentDetailsPanFileURL"));
				phmc_phob_kycpco.setPHOB_DocumentDetailsPanFile(phmc_rs.getString("PHOB_DocumentDetailsPanFile"));
				phmc_phob_kycpco.setPHOB_DocumentDetailsResidenceFileURLFrontSide(
						phmc_rs.getString("PHOB_DocumentDetailsResidenceFileURLFrontSide"));
				phmc_phob_kycpco.setPHOB_DocumentDetailsResidenceFileFrontSide(
						phmc_rs.getString("PHOB_DocumentDetailsResidenceFileFrontSide"));
				phmc_phob_kycpco.setPHOB_DocumentDetailsResidenceFileURLBackSide(
						phmc_rs.getString("PHOB_DocumentDetailsResidenceFileURLBackSide"));
				phmc_phob_kycpco.setPHOB_DocumentDetailsResidenceFileBackSide(
						phmc_rs.getString("PHOB_DocumentDetailsResidenceFileBackSide"));
				phmc_phob_kycpco.setPHOB_DocumentDetailsBusinessFileURL(
						phmc_rs.getString("PHOB_DocumentDetailsBusinessFileURL"));
				phmc_phob_kycpco.setPHOB_DocumentDetailsPCOSignatureURL(
						phmc_rs.getString("PHOB_DocumentDetailsPCOSignatureURL"));
				phmc_phob_kycpco.setPHOB_DocumentDetailsPCOSignature(
						phmc_rs.getString("PHOB_DocumentDetailsPCOSignature"));
				phmc_phob_kycpco.setPHOB_DocumentDetailsIfany(phmc_rs.getString("PHOB_DocumentDetailsIfany"));
				phmc_phob_kycpco.setPHOB_DocumentDetailsAgreement(phmc_rs.getString("PHOB_DocumentDetailsAgreement"));
				phmc_phob_kycpco.setPHOB_Created(phmc_rs.getDate("PHOB_Created"));
				phmc_phob_kycpco.setPHOB_User(phmc_rs.getLong("PHOB_User"));
				phmc_phob_kycpco.setPHOB_KYCUPdateDate(phmc_rs.getDate("PHOB_KYCUPdateDate"));
				phmc_phob_kycpco.setPHOB_KYCUpdatedBy(phmc_rs.getString("PHOB_KYCUpdatedBy"));
				

			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return phmc_phob_kycpco;

	}
	

	/**
	 * @author Rahul makvana
	 * @param onBoardModel
	 * @return isInsertSuccess this class for Create(Insert) operation for
	 *         PHOB_KYCFORM table from PHMC-MASTER database.
	 *
	 */
	public ErrorMessage phmc_phob_createOnboard(PHMC_PHOB_ONBOARD onBoardModel) {
		int isInsertSuccess = 0;
		Connection PHMC_conn = null;
		PreparedStatement PHMC_pst = null;
		String insertSetter = null;

		ErrorMessage msg = new ErrorMessage();

		if (onBoardModel != null) {

			try {

				PHMC_conn = Payhind_DBManager.payhind_getConnection();

				isInsertSuccess = Payhind_DBManager.phob_checkIfUserExist(PHMC_conn, onBoardModel.getPHOB_User(),"PHMC_PHOB_ONBOARD");

				if (isInsertSuccess == PHMC_DB_ERROR.PHMC_USER_NOT_EXIST) {

					PHMC_conn.setAutoCommit(false);

					insertSetter = setterForInsertKycForm(onBoardModel);

					PHMC_pst = PHMC_conn.prepareStatement("INSERT INTO PHMC_PHOB_ONBOARD" + insertSetter);

					isInsertSuccess = PHMC_pst.executeUpdate();

					msg.setErrorCode(PHMC_DB_ERROR.PHMC_SUCCESS);
					msg.setErrorMessage("PCO with ID " + onBoardModel.getPHOB_User() + " Created Successfully");
					PHMC_conn.commit();
				} else {
					msg.setErrorCode(PHMC_DB_ERROR.PHMC_USER_ALREADY_EXISTS);
					msg.setErrorMessage("PCO with ID " + onBoardModel.getPHOB_User() + " already exist");
				}

			} catch (ClassNotFoundException e) {
				isInsertSuccess = PHMC_DB_ERROR.PHMC_SCFG_FILE_NOT_FOUND;
				msg.setErrorCode(PHMC_DB_ERROR.PHMC_SCFG_FILE_NOT_FOUND);
				msg.setErrorMessage("PCO with ID " + onBoardModel.getPHOB_User() + " Not Found");
				e.printStackTrace();
			} catch (SQLException e) {
				isInsertSuccess = PHMC_DB_ERROR.PHMC_INSERT_FAILED;
				msg.setErrorCode(PHMC_DB_ERROR.PHMC_INSERT_FAILED);
				msg.setErrorMessage("PCO with ID " + onBoardModel.getPHOB_User() + " Creation Failed");
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

		return msg;
	}

	private String setterForInsertKycForm(PHMC_PHOB_ONBOARD onBoardModel) {
		String setter = null;
		String columnName = null;
		String value = null;

		if (onBoardModel.getPHOB_PersonalDetailsFullName() != null)
			columnName = "PHOB_PersonalDetailsFullName ";
		value = "'" + onBoardModel.getPHOB_PersonalDetailsFullName() + "' ";
		if (onBoardModel.getPHOB_PersonalDetailsPictureURL() != null) {
			if (columnName == null) {
				columnName = "PHOB_PersonalDetailsPictureURL";
				value = "'" + onBoardModel.getPHOB_PersonalDetailsPictureURL() + "'";
			} else {
				columnName += ", PHOB_PersonalDetailsPictureURL ";
				value += ", '" + onBoardModel.getPHOB_PersonalDetailsPictureURL() + "'";
			}
		}
		if (onBoardModel.getPHOB_PersonalDetailsPicture() != null) {
			if (columnName == null) {
				columnName = "PHOB_PersonalDetailsPicture";
				value = "'" + onBoardModel.getPHOB_PersonalDetailsPicture() + "'";
			} else {
				columnName += ", PHOB_PersonalDetailsPicture ";
				value += ", '" + onBoardModel.getPHOB_PersonalDetailsPicture() + "'";
			}
		}
		if (onBoardModel.getPHOB_PersonalDetailsDob() != null) {
			if (columnName == null) {
				columnName = "PHOB_PersonalDetailsDob ";
				value = "'" + Payhind_DBManager.convertJavaDateToSqlDate(onBoardModel.getPHOB_PersonalDetailsDob()) + "'";
			} else {
				columnName += ", PHOB_PersonalDetailsDob ";
				value += ", '" + Payhind_DBManager.convertJavaDateToSqlDate(onBoardModel.getPHOB_PersonalDetailsDob())
						+ "'";
			}
		}
		if (onBoardModel.getPHOB_PersonalDetailsMotherName() != null) {
			if (columnName == null) {
				columnName = "PHOB_PersonalDetailsMotherName ";
				value = "'" + onBoardModel.getPHOB_PersonalDetailsMotherName() + "'";
			} else {
				columnName += ", PHOB_PersonalDetailsMotherName ";
				value += ", '" + onBoardModel.getPHOB_PersonalDetailsMotherName() + "'";
			}
		}
		if (onBoardModel.getPHOB_PersonalDetailsGender() != null) {
			if (columnName == null) {
				columnName = "PHOB_PersonalDetailsGender ";
				value = "'" + onBoardModel.getPHOB_PersonalDetailsGender() + "'";
			} else {
				columnName += ", PHOB_PersonalDetailsGender ";
				value += ", '" + onBoardModel.getPHOB_PersonalDetailsGender() + "'";
			}
		}
		if (onBoardModel.getPHOB_BusinessDetailsBusinessName() != null) {
			if (columnName == null) {
				columnName = "PHOB_BusinessDetailsBusinessName ";
				value = "'" + onBoardModel.getPHOB_BusinessDetailsBusinessName() + "'";
			} else {
				columnName += ", PHOB_BusinessDetailsBusinessName ";
				value += ", '" + onBoardModel.getPHOB_BusinessDetailsBusinessName() + "'";
			}
		}
		if (onBoardModel.getPHOB_BusinessDetailsNatureofBusiness() != null) {
			if (columnName == null) {
				columnName = "PHOB_BusinessDetailsNatureofBusiness ";
				value = "'" + onBoardModel.getPHOB_BusinessDetailsNatureofBusiness() + "'";
			} else {
				columnName += ", PHOB_BusinessDetailsNatureofBusiness ";
				value += ", '" + onBoardModel.getPHOB_BusinessDetailsNatureofBusiness() + "'";
			}
		}
		if (onBoardModel.getPHOB_BusinessDetailsIfany() != null) {
			if (columnName == null) {
				columnName = "PHOB_BusinessDetailsIfany ";
				value = "'" + onBoardModel.getPHOB_BusinessDetailsIfany() + "'";
			} else {
				columnName += ", PHOB_BusinessDetailsIfany ";
				value += ", '" + onBoardModel.getPHOB_BusinessDetailsIfany() + "'";
			}
		}
		if (onBoardModel.getPHOB_CommunicationDetailsPersonalAddressAddressline1() != null) {
			if (columnName == null) {
				columnName = "PHOB_CommunicationDetailsPersonalAddressAddressline1 ";
				value = "'" + onBoardModel.getPHOB_CommunicationDetailsPersonalAddressAddressline1() + "'";
			} else {
				columnName += ", PHOB_CommunicationDetailsPersonalAddressAddressline1 ";
				value += ", '" + onBoardModel.getPHOB_CommunicationDetailsPersonalAddressAddressline1() + "'";
			}
		}
		if (onBoardModel.getPHOB_CommunicationDetailsPersonalAddressAddressline2() != null) {
			if (columnName == null) {
				columnName = "PHOB_CommunicationDetailsPersonalAddressAddressline2 ";
				value = "'" + onBoardModel.getPHOB_CommunicationDetailsPersonalAddressAddressline2() + "'";
			} else {
				columnName += ", PHOB_CommunicationDetailsPersonalAddressAddressline2 ";
				value += ", '" + onBoardModel.getPHOB_CommunicationDetailsPersonalAddressAddressline2() + "'";
			}
		}
		if (onBoardModel.getPHOB_CommunicationDetailsPersonalAddressAddressline3() != null) {
			if (columnName == null) {
				columnName = "PHOB_CommunicationDetailsPersonalAddressAddressline3 ";
				value = "'" + onBoardModel.getPHOB_CommunicationDetailsPersonalAddressAddressline3() + "'";
			} else {
				columnName += ", PHOB_CommunicationDetailsPersonalAddressAddressline3 ";
				value += ", '" + onBoardModel.getPHOB_CommunicationDetailsPersonalAddressAddressline3() + "'";
			}
		}
		if (onBoardModel.getPHOB_CommunicationDetailsPersonalAddressPersonalcity() != null) {
			if (columnName == null) {
				columnName = "PHOB_CommunicationDetailsPersonalAddressPersonalcity ";
				value = "'" + onBoardModel.getPHOB_CommunicationDetailsPersonalAddressPersonalcity() + "'";
			} else {
				columnName += ", PHOB_CommunicationDetailsPersonalAddressPersonalcity ";
				value += ", '" + onBoardModel.getPHOB_CommunicationDetailsPersonalAddressPersonalcity() + "'";
			}
		}
		if (onBoardModel.getPHOB_CommunicationDetailsPersonalAddressPersonalState() != null) {
			if (columnName == null) {
				columnName = "PHOB_CommunicationDetailsPersonalAddressPersonalState ";
				value = "'" + onBoardModel.getPHOB_CommunicationDetailsPersonalAddressPersonalState() + "'";
			} else {
				columnName += ", PHOB_CommunicationDetailsPersonalAddressPersonalState ";
				value += ", '" + onBoardModel.getPHOB_CommunicationDetailsPersonalAddressPersonalState() + "'";
			}
		}
		if (onBoardModel.getPHOB_CommunicationDetailsPersonalAddressPersonalpin() != null) {
			if (columnName == null) {
				columnName = "PHOB_CommunicationDetailsPersonalAddressPersonalpin ";
				value = "'" + onBoardModel.getPHOB_CommunicationDetailsPersonalAddressPersonalpin() + "'";
			} else {
				columnName += ", PHOB_CommunicationDetailsPersonalAddressPersonalpin ";
				value += ", '" + onBoardModel.getPHOB_CommunicationDetailsPersonalAddressPersonalpin() + "'";
			}
		}
		if (onBoardModel.getPHOB_CommunicationDetailsBusinessAddressAddressline1() != null) {
			if (columnName == null) {
				columnName = "PHOB_CommunicationDetailsBusinessAddressAddressline1 ";
				value = "'" + onBoardModel.getPHOB_CommunicationDetailsBusinessAddressAddressline1() + "'";
			} else {
				columnName += ", PHOB_CommunicationDetailsBusinessAddressAddressline1 ";
				value += ", '" + onBoardModel.getPHOB_CommunicationDetailsBusinessAddressAddressline1() + "'";
			}
		}
		if (onBoardModel.getPHOB_CommunicationDetailsBusinessAddressAddressline2() != null) {
			if (columnName == null) {
				columnName = "PHOB_CommunicationDetailsBusinessAddressAddressline2 ";
				value = "'" + onBoardModel.getPHOB_CommunicationDetailsBusinessAddressAddressline2() + "'";
			} else {
				columnName += ", PHOB_CommunicationDetailsBusinessAddressAddressline2 ";
				value += ", '" + onBoardModel.getPHOB_CommunicationDetailsBusinessAddressAddressline2() + "'";
			}
		}
		if (onBoardModel.getPHOB_CommunicationDetailsBusinessAddressAddressline3() != null) {
			if (columnName == null) {
				columnName = "PHOB_CommunicationDetailsBusinessAddressAddressline3 ";
				value = "'" + onBoardModel.getPHOB_CommunicationDetailsBusinessAddressAddressline3() + "'";
			} else {
				columnName += ", PHOB_CommunicationDetailsBusinessAddressAddressline3 ";
				value += ", '" + onBoardModel.getPHOB_CommunicationDetailsBusinessAddressAddressline3() + "'";
			}
		}
		if (onBoardModel.getPHOB_CommunicationDetailsBusinessAddressBusinesscity() != null) {
			if (columnName == null) {
				columnName = "PHOB_CommunicationDetailsBusinessAddressBusinesscity ";
				value = "'" + onBoardModel.getPHOB_CommunicationDetailsBusinessAddressBusinesscity() + "'";
			} else {
				columnName += ", PHOB_CommunicationDetailsBusinessAddressBusinesscity ";
				value += ", '" + onBoardModel.getPHOB_CommunicationDetailsBusinessAddressBusinesscity() + "'";
			}
		}
		if (onBoardModel.getPHOB_CommunicationDetailsBusinessAddressBusinessstate() != null) {
			if (columnName == null) {
				columnName = "PHOB_CommunicationDetailsBusinessAddressBusinessstate ";
				value = "'" + onBoardModel.getPHOB_CommunicationDetailsBusinessAddressBusinessstate() + "'";
			} else {
				columnName += ", PHOB_CommunicationDetailsBusinessAddressBusinessstate ";
				value += ", '" + onBoardModel.getPHOB_CommunicationDetailsBusinessAddressBusinessstate() + "'";
			}
		}
		if (onBoardModel.getPHOB_CommunicationDetailsBusinessAddressBusinesspin() != null) {
			if (columnName == null) {
				columnName = "PHOB_CommunicationDetailsBusinessAddressBusinesspin ";
				value = "'" + onBoardModel.getPHOB_CommunicationDetailsBusinessAddressBusinesspin() + "'";
			} else {
				columnName += ", PHOB_CommunicationDetailsBusinessAddressBusinesspin ";
				value += ", '" + onBoardModel.getPHOB_CommunicationDetailsBusinessAddressBusinesspin() + "'";
			}
		}
		if (onBoardModel.getPHOB_BankDetailsBankName() != null) {
			if (columnName == null) {
				columnName = "PHOB_BankDetailsBankName ";
				value = "'" + onBoardModel.getPHOB_BankDetailsBankName() + "'";
			} else {
				columnName += ", PHOB_BankDetailsBankName ";
				value += ", '" + onBoardModel.getPHOB_BankDetailsBankName() + "'";
			}
		}
		if (onBoardModel.getPHOB_BankDetailsBankAccountNumber() != null) {
			if (columnName == null) {
				columnName = "PHOB_BankDetailsBankAccountNumber ";
				value = "'" + onBoardModel.getPHOB_BankDetailsBankAccountNumber() + "'";
			} else {
				columnName += ", PHOB_BankDetailsBankAccountNumber ";
				value += ", '" + onBoardModel.getPHOB_BankDetailsBankAccountNumber() + "'";
			}
		}
		if (onBoardModel.getPHOB_BankDetailsBankBranch() != null) {
			if (columnName == null) {
				columnName = "PHOB_BankDetailsBankBranch ";
				value = "'" + onBoardModel.getPHOB_BankDetailsBankBranch() + "'";
			} else {
				columnName += ", PHOB_BankDetailsBankBranch ";
				value += ", '" + onBoardModel.getPHOB_BankDetailsBankBranch() + "'";
			}
		}
		if (onBoardModel.getPHOB_BankDetailsAccountType() != null) {
			if (columnName == null) {
				columnName = "PHOB_BankDetailsAccountType ";
				value = "'" + onBoardModel.getPHOB_BankDetailsAccountType() + "'";
			} else {
				columnName += ", PHOB_BankDetailsAccountType ";
				value += ", '" + onBoardModel.getPHOB_BankDetailsAccountType() + "'";
			}
		}
		if (onBoardModel.getPHOB_BankDetailsIfscCode() != null) {
			if (columnName == null) {
				columnName = "PHOB_BankDetailsIfscCode ";
				value = "'" + onBoardModel.getPHOB_BankDetailsIfscCode() + "'";
			} else {
				columnName += ", PHOB_BankDetailsIfscCode ";
				value += ", '" + onBoardModel.getPHOB_BankDetailsIfscCode() + "'";
			}
		}
		if (onBoardModel.getPHOB_DocumentDetailsPanFileURL() != null) {
			if (columnName == null) {
				columnName = "PHOB_DocumentDetailsPanFileURL ";
				value = "'" + onBoardModel.getPHOB_DocumentDetailsPanFileURL() + "'";
			} else {
				columnName += ", PHOB_DocumentDetailsPanFileURL ";
				value += ", '" + onBoardModel.getPHOB_DocumentDetailsPanFileURL() + "'";
			}
		}
		if (onBoardModel.getPHOB_DocumentDetailsPanFile() != null) {
			if (columnName == null) {
				columnName = "PHOB_DocumentDetailsPanFile ";
				value = "'" + onBoardModel.getPHOB_DocumentDetailsPanFile() + "'";
			} else {
				columnName += ", PHOB_DocumentDetailsPanFile ";
				value += ", '" + onBoardModel.getPHOB_DocumentDetailsPanFile() + "'";
			}
		}
		if (onBoardModel.getPHOB_DocumentDetailsResidenceFileURLFrontSide() != null) {
			if (columnName == null) {
				columnName = "PHOB_DocumentDetailsResidenceFileURLFrontSide ";
				value = "'" + onBoardModel.getPHOB_DocumentDetailsResidenceFileURLFrontSide() + "'";
			} else {
				columnName += ", PHOB_DocumentDetailsResidenceFileURLFrontSide ";
				value += ", '" + onBoardModel.getPHOB_DocumentDetailsResidenceFileURLFrontSide() + "'";
			}
		}
		if (onBoardModel.getPHOB_DocumentDetailsResidenceFileFrontSide() != null) {
			if (columnName == null) {
				columnName = "PHOB_DocumentDetailsResidenceFileFrontSide ";
				value = "'" + onBoardModel.getPHOB_DocumentDetailsResidenceFileFrontSide() + "'";
			} else {
				columnName += ", PHOB_DocumentDetailsResidenceFileFrontSide ";
				value += ", '" + onBoardModel.getPHOB_DocumentDetailsResidenceFileFrontSide() + "'";
			}
		}
		if (onBoardModel.getPHOB_DocumentDetailsResidenceFileURLBackSide() != null) {
			if (columnName == null) {
				columnName = "PHOB_DocumentDetailsResidenceFileURLBackSide ";
				value = "'" + onBoardModel.getPHOB_DocumentDetailsResidenceFileURLBackSide() + "'";
			} else {
				columnName += ", PHOB_DocumentDetailsResidenceFileURLBackSide ";
				value += ", '" + onBoardModel.getPHOB_DocumentDetailsResidenceFileURLBackSide() + "'";
			}
		}
		if (onBoardModel.getPHOB_DocumentDetailsResidenceFileBackSide() != null) {
			if (columnName == null) {
				columnName = "PHOB_DocumentDetailsResidenceFileBackSide ";
				value = "'" + onBoardModel.getPHOB_DocumentDetailsResidenceFileBackSide() + "'";
			} else {
				columnName += ", PHOB_DocumentDetailsResidenceFileBackSide ";
				value += ", '" + onBoardModel.getPHOB_DocumentDetailsResidenceFileBackSide() + "'";
			}
		}
		if (onBoardModel.getPHOB_DocumentDetailsBusinessFileURL() != null) {
			if (columnName == null) {
				columnName = "PHOB_DocumentDetailsBusinessFileURL ";
				value = "'" + onBoardModel.getPHOB_DocumentDetailsBusinessFileURL() + "'";
			} else {
				columnName += ", PHOB_DocumentDetailsBusinessFileURL ";
				value += ", '" + onBoardModel.getPHOB_DocumentDetailsBusinessFileURL() + "'";
			}
		}
		if (onBoardModel.getPHOB_DocumentDetailsBusinessFile() != null) {
			if (columnName == null) {
				columnName = "PHOB_DocumentDetailsBusinessFile ";
				value = "'" + onBoardModel.getPHOB_DocumentDetailsBusinessFile() + "'";
			} else {
				columnName += ", PHOB_DocumentDetailsBusinessFile ";
				value += ", '" + onBoardModel.getPHOB_DocumentDetailsBusinessFile() + "'";
			}
		}
		if (onBoardModel.getPHOB_DocumentDetailsPCOSignatureURL() != null) {
			if (columnName == null) {
				columnName = "PHOB_DocumentDetailsPCOSignatureURL ";
				value = "'" + onBoardModel.getPHOB_DocumentDetailsPCOSignatureURL() + "'";
			} else {
				columnName += ", PHOB_DocumentDetailsPCOSignatureURL ";
				value += ", '" + onBoardModel.getPHOB_DocumentDetailsPCOSignatureURL() + "'";
			}
		}
		if (onBoardModel.getPHOB_DocumentDetailsPCOSignature() != null) {
			if (columnName == null) {
				columnName = "PHOB_DocumentDetailsPCOSignature ";
				value = "'" + onBoardModel.getPHOB_DocumentDetailsPCOSignature() + "'";
			} else {
				columnName += ", PHOB_DocumentDetailsPCOSignature ";
				value += ", '" + onBoardModel.getPHOB_DocumentDetailsPCOSignature() + "'";
			}
		}
		if (onBoardModel.getPHOB_DocumentDetailsIfany() != null) {
			if (columnName == null) {
				columnName = "PHOB_DocumentDetailsIfany ";
				value = "'" + onBoardModel.getPHOB_DocumentDetailsIfany() + "'";
			} else {
				columnName += ", PHOB_DocumentDetailsIfany ";
				value += ", '" + onBoardModel.getPHOB_DocumentDetailsIfany() + "'";
			}
		}
		if (onBoardModel.getPHOB_DocumentDetailsAgreement() != null) {
			if (columnName == null) {
				columnName = "PHOB_DocumentDetailsAgreement ";
				value = "'" + onBoardModel.getPHOB_DocumentDetailsAgreement() + "'";
			} else {
				columnName += ", PHOB_DocumentDetailsAgreement ";
				value += ", '" + onBoardModel.getPHOB_DocumentDetailsAgreement() + "'";
			}
		}
		if (onBoardModel.getPHOB_Created() != null) {
			if (columnName == null) {
				columnName = "PHOB_Created ";
				value = "'" + Payhind_DBManager.convertJavaDateToSqlDate(onBoardModel.getPHOB_Created()) + "'";
			} else {
				columnName += ", PHOB_Created ";
				value += ", '" + Payhind_DBManager.convertJavaDateToSqlDate(onBoardModel.getPHOB_Created()) + "'";
			}
		}
		if (onBoardModel.getPHOB_User() != null) {
			if (columnName == null) {
				columnName = "PHOB_User ";
				value = "'" + onBoardModel.getPHOB_User() + "'";
			} else {
				columnName += ", PHOB_User ";
				value += ", '" + onBoardModel.getPHOB_User() + "'";
			}
		}
		if (onBoardModel.getPHOB_KYCUPdateDate() != null) {
			if (columnName == null) {
				columnName = "PHOB_KYCUPdateDate ";
				value = "'" + Payhind_DBManager.convertJavaDateToSqlDate(onBoardModel.getPHOB_KYCUPdateDate()) + "'";
			} else {
				columnName += ", PHOB_KYCUPdateDate ";
				value += ", '" + Payhind_DBManager.convertJavaDateToSqlDate(onBoardModel.getPHOB_KYCUPdateDate()) + "'";
			}
		}
		if (onBoardModel.getPHOB_KYCUpdatedBy() != null) {
			if (columnName == null) {
				columnName = "PHOB_KYCUpdatedBy ";
				value = "'" + onBoardModel.getPHOB_KYCUpdatedBy() + "'";
			} else {
				columnName += ", PHOB_KYCUpdatedBy ";
				value += ", '" + onBoardModel.getPHOB_KYCUpdatedBy() + "'";
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
	 * @param onBoardModel
	 * @return isUpdateSuccess
	 * 
	 *         this class for Update operation for PHOB_KYCFORM table from
	 *         PHMC-MASTER database.
	 *
	 */

	public ErrorMessage phmc_phob_updateKycForm(long phob_pcoID, PHMC_PHOB_ONBOARD onBoardModel) {

		int isUpdateSuccess = 0;
		Connection PHMC_conn = null;
		PreparedStatement PHMC_pst = null;
		String setter = "";

		ErrorMessage msg = new ErrorMessage();

		if (onBoardModel != null) {

			try {
				PHMC_conn = Payhind_DBManager.payhind_getConnection();
				isUpdateSuccess = Payhind_DBManager.phob_checkIfUserExist(PHMC_conn, phob_pcoID, "PHMC_PHOB_ONBOARD");

				if (isUpdateSuccess == PHMC_DB_ERROR.PHMC_USER_ALREADY_EXISTS) {

					setter = setterForUpdateKycForm(onBoardModel);

					PHMC_conn.setAutoCommit(false);
					PHMC_pst = PHMC_conn
							.prepareStatement("UPDATE PHMC_PHOB_ONBOARD SET " + setter + " WHERE PHOB_User=" + phob_pcoID);

					isUpdateSuccess = PHMC_pst.executeUpdate();
					msg.setErrorCode(PHMC_DB_ERROR.PHMC_SUCCESS);
					msg.setErrorMessage("PCO with ID " + onBoardModel.getPHOB_User() + " Updated Successfully");
					PHMC_conn.commit();
				} else {
					msg.setErrorCode(PHMC_DB_ERROR.PHMC_USER_NOT_EXIST);
					msg.setErrorMessage("PCO with ID " + onBoardModel.getPHOB_User() + " Not Exist");
				}

			} catch (ClassNotFoundException e) {
				isUpdateSuccess = PHMC_DB_ERROR.PHMC_SCFG_FILE_NOT_FOUND;
				msg.setErrorCode(PHMC_DB_ERROR.PHMC_SCFG_FILE_NOT_FOUND);
				msg.setErrorMessage("PCO with ID " + onBoardModel.getPHOB_User() + " Not Found");
				e.printStackTrace();
			} catch (SQLException e) {
				isUpdateSuccess = PHMC_DB_ERROR.PHMC_UPDATE_FAILED;
				msg.setErrorCode(PHMC_DB_ERROR.PHMC_UPDATE_FAILED);
				msg.setErrorMessage("PCO with ID " + onBoardModel.getPHOB_User() + " Updation Failed");
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
		if (isUpdateSuccess == 1) {
			System.out.println("Updated Sucessfully");
			isUpdateSuccess = PHMC_DB_ERROR.PHMC_SUCCESS;
		}
		return msg;

	}

	/**
	 * @author rahul makvana
	 * @param onBoardModel
	 * @return setter
	 */
	private String setterForUpdateKycForm(PHMC_PHOB_ONBOARD onBoardModel) {
		String setter = null;

		if (onBoardModel.getPHOB_PersonalDetailsFullName() != null)
			setter = "PHOB_PersonalDetailsFullName='" + onBoardModel.getPHOB_PersonalDetailsFullName() + "' ";
		if (onBoardModel.getPHOB_PersonalDetailsPictureURL() != null) {
			if (setter == null) {
				setter = "PHOB_PersonalDetailsPictureURL ='" + onBoardModel.getPHOB_PersonalDetailsPictureURL() + "'";
			} else
				setter += ", PHOB_PersonalDetailsPictureURL ='" + onBoardModel.getPHOB_PersonalDetailsPictureURL()
						+ "'";
		}
		if (onBoardModel.getPHOB_PersonalDetailsPicture() != null) {
			if (setter == null) {
				setter = "PHOB_PersonalDetailsPicture ='" + onBoardModel.getPHOB_PersonalDetailsPicture() + "'";
			} else
				setter += ", PHOB_PersonalDetailsPicture ='" + onBoardModel.getPHOB_PersonalDetailsPicture()
						+ "'";
		}
		if (onBoardModel.getPHOB_PersonalDetailsDob() != null) {
			if (setter == null) {
				setter = "PHOB_PersonalDetailsDob ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(onBoardModel.getPHOB_PersonalDetailsDob()) + "'";
			} else
				setter += ", PHOB_PersonalDetailsDob ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(onBoardModel.getPHOB_PersonalDetailsDob()) + "'";
		}
		if (onBoardModel.getPHOB_PersonalDetailsMotherName() != null) {
			if (setter == null) {
				setter = "PHOB_PersonalDetailsMotherName ='" + onBoardModel.getPHOB_PersonalDetailsMotherName() + "'";
			} else
				setter += ", PHOB_PersonalDetailsMotherName ='" + onBoardModel.getPHOB_PersonalDetailsMotherName()
						+ "'";
		}
		if (onBoardModel.getPHOB_PersonalDetailsGender() != null) {
			if (setter == null) {
				setter = "PHOB_PersonalDetailsGender ='" + onBoardModel.getPHOB_PersonalDetailsGender() + "'";
			} else
				setter += ", PHOB_PersonalDetailsGender ='" + onBoardModel.getPHOB_PersonalDetailsGender() + "'";
		}
		if (onBoardModel.getPHOB_BusinessDetailsBusinessName() != null) {
			if (setter == null) {
				setter = "PHOB_BusinessDetailsBusinessName ='" + onBoardModel.getPHOB_BusinessDetailsBusinessName()
						+ "'";
			} else
				setter += ", PHOB_BusinessDetailsBusinessName ='" + onBoardModel.getPHOB_BusinessDetailsBusinessName()
						+ "'";
		}
		if (onBoardModel.getPHOB_BusinessDetailsNatureofBusiness() != null) {
			if (setter == null) {
				setter = "PHOB_BusinessDetailsNatureofBusiness ='"
						+ onBoardModel.getPHOB_BusinessDetailsNatureofBusiness() + "'";
			} else
				setter += ", PHOB_BusinessDetailsNatureofBusiness ='"
						+ onBoardModel.getPHOB_BusinessDetailsNatureofBusiness() + "'";
		}
		if (onBoardModel.getPHOB_BusinessDetailsIfany() != null) {
			if (setter == null) {
				setter = "PHOB_BusinessDetailsIfany ='" + onBoardModel.getPHOB_BusinessDetailsIfany() + "'";
			} else
				setter += ", PHOB_BusinessDetailsIfany ='" + onBoardModel.getPHOB_BusinessDetailsIfany() + "'";
		}
		if (onBoardModel.getPHOB_CommunicationDetailsPersonalAddressAddressline1() != null) {
			if (setter == null) {
				setter = "PHOB_CommunicationDetailsPersonalAddressAddressline1 ='"
						+ onBoardModel.getPHOB_CommunicationDetailsPersonalAddressAddressline1() + "'";
			} else
				setter += ", PHOB_CommunicationDetailsPersonalAddressAddressline1 ='"
						+ onBoardModel.getPHOB_CommunicationDetailsPersonalAddressAddressline1() + "'";
		}
		if (onBoardModel.getPHOB_CommunicationDetailsPersonalAddressAddressline2() != null) {
			if (setter == null) {
				setter = "PHOB_CommunicationDetailsPersonalAddressAddressline2 ='"
						+ onBoardModel.getPHOB_CommunicationDetailsPersonalAddressAddressline2() + "'";
			} else
				setter += ", PHOB_CommunicationDetailsPersonalAddressAddressline2 ='"
						+ onBoardModel.getPHOB_CommunicationDetailsPersonalAddressAddressline2() + "'";
		}
		if (onBoardModel.getPHOB_CommunicationDetailsPersonalAddressAddressline3() != null) {
			if (setter == null) {
				setter = "PHOB_CommunicationDetailsPersonalAddressAddressline3 ='"
						+ onBoardModel.getPHOB_CommunicationDetailsPersonalAddressAddressline3() + "'";
			} else
				setter += ", PHOB_CommunicationDetailsPersonalAddressAddressline3 ='"
						+ onBoardModel.getPHOB_CommunicationDetailsPersonalAddressAddressline3() + "'";
		}
		if (onBoardModel.getPHOB_CommunicationDetailsPersonalAddressPersonalcity() != null) {
			if (setter == null) {
				setter = "PHOB_CommunicationDetailsPersonalAddressPersonalcity ='"
						+ onBoardModel.getPHOB_CommunicationDetailsPersonalAddressPersonalcity() + "'";
			} else
				setter += ", PHOB_CommunicationDetailsPersonalAddressPersonalcity ='"
						+ onBoardModel.getPHOB_CommunicationDetailsPersonalAddressPersonalcity() + "'";
		}
		if (onBoardModel.getPHOB_CommunicationDetailsPersonalAddressPersonalState() != null) {
			if (setter == null) {
				setter = "PHOB_CommunicationDetailsPersonalAddressPersonalState ='"
						+ onBoardModel.getPHOB_CommunicationDetailsPersonalAddressPersonalState() + "'";
			} else
				setter += ", PHOB_CommunicationDetailsPersonalAddressPersonalState ='"
						+ onBoardModel.getPHOB_CommunicationDetailsPersonalAddressPersonalState() + "'";
		}
		if (onBoardModel.getPHOB_CommunicationDetailsPersonalAddressPersonalpin() != null) {
			if (setter == null) {
				setter = "PHOB_CommunicationDetailsPersonalAddressPersonalpin ='"
						+ onBoardModel.getPHOB_CommunicationDetailsPersonalAddressPersonalpin() + "'";
			} else
				setter += ", PHOB_CommunicationDetailsPersonalAddressPersonalpin ='"
						+ onBoardModel.getPHOB_CommunicationDetailsPersonalAddressPersonalpin() + "'";
		}
		if (onBoardModel.getPHOB_CommunicationDetailsBusinessAddressAddressline1() != null) {
			if (setter == null) {
				setter = "PHOB_CommunicationDetailsBusinessAddressAddressline1 ='"
						+ onBoardModel.getPHOB_CommunicationDetailsBusinessAddressAddressline1() + "'";
			} else
				setter += ", PHOB_CommunicationDetailsBusinessAddressAddressline1 ='"
						+ onBoardModel.getPHOB_CommunicationDetailsBusinessAddressAddressline1() + "'";
		}
		if (onBoardModel.getPHOB_CommunicationDetailsBusinessAddressAddressline2() != null) {
			if (setter == null) {
				setter = "PHOB_CommunicationDetailsBusinessAddressAddressline2 ='"
						+ onBoardModel.getPHOB_CommunicationDetailsBusinessAddressAddressline2() + "'";
			} else
				setter += ", PHOB_CommunicationDetailsBusinessAddressAddressline2 ='"
						+ onBoardModel.getPHOB_CommunicationDetailsBusinessAddressAddressline2() + "'";
		}
		if (onBoardModel.getPHOB_CommunicationDetailsBusinessAddressAddressline3() != null) {
			if (setter == null) {
				setter = "PHOB_CommunicationDetailsBusinessAddressAddressline3 ='"
						+ onBoardModel.getPHOB_CommunicationDetailsBusinessAddressAddressline3() + "'";
			} else
				setter += ", PHOB_CommunicationDetailsBusinessAddressAddressline3 ='"
						+ onBoardModel.getPHOB_CommunicationDetailsBusinessAddressAddressline3() + "'";
		}
		if (onBoardModel.getPHOB_CommunicationDetailsBusinessAddressBusinesscity() != null) {
			if (setter == null) {
				setter = "PHOB_CommunicationDetailsBusinessAddressBusinesscity ='"
						+ onBoardModel.getPHOB_CommunicationDetailsBusinessAddressBusinesscity() + "'";
			} else
				setter += ", PHOB_CommunicationDetailsBusinessAddressBusinesscity ='"
						+ onBoardModel.getPHOB_CommunicationDetailsBusinessAddressBusinesscity() + "'";
		}
		if (onBoardModel.getPHOB_CommunicationDetailsBusinessAddressBusinessstate() != null) {
			if (setter == null) {
				setter = "PHOB_CommunicationDetailsBusinessAddressBusinessstate ='"
						+ onBoardModel.getPHOB_CommunicationDetailsBusinessAddressBusinessstate() + "'";
			} else
				setter += ", PHOB_CommunicationDetailsBusinessAddressBusinessstate ='"
						+ onBoardModel.getPHOB_CommunicationDetailsBusinessAddressBusinessstate() + "'";
		}
		if (onBoardModel.getPHOB_CommunicationDetailsBusinessAddressBusinesspin() != null) {
			if (setter == null) {
				setter = "PHOB_CommunicationDetailsBusinessAddressBusinesspin ='"
						+ onBoardModel.getPHOB_CommunicationDetailsBusinessAddressBusinesspin() + "'";
			} else
				setter += ", PHOB_CommunicationDetailsBusinessAddressBusinesspin ='"
						+ onBoardModel.getPHOB_CommunicationDetailsBusinessAddressBusinesspin() + "'";
		}
		if (onBoardModel.getPHOB_BankDetailsBankName() != null) {
			if (setter == null) {
				setter = "PHOB_BankDetailsBankName ='" + onBoardModel.getPHOB_BankDetailsBankName() + "'";
			} else
				setter += ", PHOB_BankDetailsBankName ='" + onBoardModel.getPHOB_BankDetailsBankName() + "'";
		}
		if (onBoardModel.getPHOB_BankDetailsBankAccountNumber() >= 0) {
			if (setter == null) {
				setter = "PHOB_BankDetailsBankAccountNumber ='" + onBoardModel.getPHOB_BankDetailsBankAccountNumber()
						+ "'";
			} else
				setter += ", PHOB_BankDetailsBankAccountNumber ='" + onBoardModel.getPHOB_BankDetailsBankAccountNumber()
						+ "'";
		}
		if (onBoardModel.getPHOB_BankDetailsBankBranch() != null) {
			if (setter == null) {
				setter = "PHOB_BankDetailsBankBranch ='" + onBoardModel.getPHOB_BankDetailsBankBranch() + "'";
			} else
				setter += ", PHOB_BankDetailsBankBranch ='" + onBoardModel.getPHOB_BankDetailsBankBranch() + "'";
		}
		if (onBoardModel.getPHOB_BankDetailsAccountType() != null) {
			if (setter == null) {
				setter = "PHOB_BankDetailsAccountType ='" + onBoardModel.getPHOB_BankDetailsAccountType() + "'";
			} else
				setter += ", PHOB_BankDetailsAccountType ='" + onBoardModel.getPHOB_BankDetailsAccountType() + "'";
		}
		if (onBoardModel.getPHOB_BankDetailsIfscCode() != null) {
			if (setter == null) {
				setter = "PHOB_BankDetailsIfscCode ='" + onBoardModel.getPHOB_BankDetailsIfscCode() + "'";
			} else
				setter += ", PHOB_BankDetailsIfscCode ='" + onBoardModel.getPHOB_BankDetailsIfscCode() + "'";
		}
		if (onBoardModel.getPHOB_DocumentDetailsPanFileURL() != null) {
			if (setter == null) {
				setter = "PHOB_DocumentDetailsPanFileURL ='" + onBoardModel.getPHOB_DocumentDetailsPanFileURL() + "'";
			} else
				setter += ", PHOB_DocumentDetailsPanFileURL ='" + onBoardModel.getPHOB_DocumentDetailsPanFileURL()
						+ "'";
		}
		if (onBoardModel.getPHOB_DocumentDetailsPanFile() != null) {
			if (setter == null) {
				setter = "PHOB_DocumentDetailsPanFile ='" + onBoardModel.getPHOB_DocumentDetailsPanFile() + "'";
			} else
				setter += ", PHOB_DocumentDetailsPanFile ='" + onBoardModel.getPHOB_DocumentDetailsPanFile()
						+ "'";
		}
		if (onBoardModel.getPHOB_DocumentDetailsResidenceFileURLFrontSide() != null) {
			if (setter == null) {
				setter = "PHOB_DocumentDetailsResidenceFileURLFrontSide ='"
						+ onBoardModel.getPHOB_DocumentDetailsResidenceFileURLFrontSide() + "'";
			} else
				setter += ", PHOB_DocumentDetailsResidenceFileURLFrontSide ='"
						+ onBoardModel.getPHOB_DocumentDetailsResidenceFileURLFrontSide() + "'";
		}
		if (onBoardModel.getPHOB_DocumentDetailsResidenceFileFrontSide() != null) {
			if (setter == null) {
				setter = "PHOB_DocumentDetailsResidenceFileFrontSide ='"
						+ onBoardModel.getPHOB_DocumentDetailsResidenceFileFrontSide() + "'";
			} else
				setter += ", PHOB_DocumentDetailsResidenceFileFrontSide ='"
						+ onBoardModel.getPHOB_DocumentDetailsResidenceFileFrontSide() + "'";
		}
		if (onBoardModel.getPHOB_DocumentDetailsResidenceFileURLBackSide() != null) {
			if (setter == null) {
				setter = "PHOB_DocumentDetailsResidenceFileURLBackSide ='"
						+ onBoardModel.getPHOB_DocumentDetailsResidenceFileURLBackSide() + "'";
			} else
				setter += ", PHOB_DocumentDetailsResidenceFileURLBackSide ='"
						+ onBoardModel.getPHOB_DocumentDetailsResidenceFileURLBackSide() + "'";
		}
		if (onBoardModel.getPHOB_DocumentDetailsResidenceFileBackSide() != null) {
			if (setter == null) {
				setter = "PHOB_DocumentDetailsResidenceFileBackSide ='"
						+ onBoardModel.getPHOB_DocumentDetailsResidenceFileBackSide() + "'";
			} else
				setter += ", PHOB_DocumentDetailsResidenceFileBackSide ='"
						+ onBoardModel.getPHOB_DocumentDetailsResidenceFileBackSide() + "'";
		}
		if (onBoardModel.getPHOB_DocumentDetailsBusinessFileURL() != null) {
			if (setter == null) {
				setter = "PHOB_DocumentDetailsBusinessFileURL ='"
						+ onBoardModel.getPHOB_DocumentDetailsBusinessFileURL() + "'";
			} else
				setter += ", PHOB_DocumentDetailsBusinessFileURL ='"
						+ onBoardModel.getPHOB_DocumentDetailsBusinessFileURL() + "'";
		}
		if (onBoardModel.getPHOB_DocumentDetailsBusinessFile() != null) {
			if (setter == null) {
				setter = "PHOB_DocumentDetailsBusinessFile ='"
						+ onBoardModel.getPHOB_DocumentDetailsBusinessFile() + "'";
			} else
				setter += ", PHOB_DocumentDetailsBusinessFile ='"
						+ onBoardModel.getPHOB_DocumentDetailsBusinessFile() + "'";
		}
		if (onBoardModel.getPHOB_DocumentDetailsPCOSignatureURL() != null) {
			if (setter == null) {
				setter = "PHOB_DocumentDetailsPCOSignatureURL ='"
						+ onBoardModel.getPHOB_DocumentDetailsPCOSignatureURL() + "'";
			} else
				setter += ", PHOB_DocumentDetailsPCOSignatureURL ='"
						+ onBoardModel.getPHOB_DocumentDetailsPCOSignatureURL() + "'";
		}
		if (onBoardModel.getPHOB_DocumentDetailsPCOSignature() != null) {
			if (setter == null) {
				setter = "PHOB_DocumentDetailsPCOSignature ='"
						+ onBoardModel.getPHOB_DocumentDetailsPCOSignature() + "'";
			} else
				setter += ", PHOB_DocumentDetailsPCOSignature ='"
						+ onBoardModel.getPHOB_DocumentDetailsPCOSignature() + "'";
		}
		if (onBoardModel.getPHOB_DocumentDetailsIfany() != null) {
			if (setter == null) {
				setter = "PHOB_DocumentDetailsIfany ='" + onBoardModel.getPHOB_DocumentDetailsIfany() + "'";
			} else
				setter += ", PHOB_DocumentDetailsIfany ='" + onBoardModel.getPHOB_DocumentDetailsIfany() + "'";
		}
		if (onBoardModel.getPHOB_DocumentDetailsAgreement() != null) {
			if (setter == null) {
				setter = "PHOB_DocumentDetailsAgreement ='" + onBoardModel.getPHOB_DocumentDetailsAgreement() + "'";
			} else
				setter += ", PHOB_DocumentDetailsAgreement ='" + onBoardModel.getPHOB_DocumentDetailsAgreement() + "'";
		}
		if (onBoardModel.getPHOB_Created() != null) {
			if (setter == null) {
				setter = "PHOB_Created ='" + Payhind_DBManager.convertJavaDateToSqlDate(onBoardModel.getPHOB_Created())
						+ "'";
			} else
				setter += ", PHOB_Created ='" + Payhind_DBManager.convertJavaDateToSqlDate(onBoardModel.getPHOB_Created())
						+ "'";
		}
		if (onBoardModel.getPHOB_User() >= 0) {
			if (setter == null) {
				setter = "PHOB_User ='" + onBoardModel.getPHOB_User() + "'";
			} else
				setter += ", PHOB_User ='" + onBoardModel.getPHOB_User() + "'";
		}
		if (onBoardModel.getPHOB_KYCUPdateDate() != null) {
			if (setter == null) {
				setter = "PHOB_KYCUPdateDate ='" + Payhind_DBManager.convertJavaDateToSqlDate(onBoardModel.getPHOB_KYCUPdateDate()) + "'";
			} else
				setter += ", PHOB_KYCUPdateDate ='" + Payhind_DBManager.convertJavaDateToSqlDate(onBoardModel.getPHOB_KYCUPdateDate()) + "'";
		}
		if (onBoardModel.getPHOB_KYCUpdatedBy() != null) {
			if (setter == null) {
				setter = "PHOB_KYCUpdatedBy ='" + onBoardModel.getPHOB_KYCUpdatedBy() + "'";
			} else
				setter += ", PHOB_KYCUpdatedBy ='" + onBoardModel.getPHOB_KYCUpdatedBy() + "'";
		}
		

		System.out.println("Setter= " + setter);

		return setter;
	}

}
