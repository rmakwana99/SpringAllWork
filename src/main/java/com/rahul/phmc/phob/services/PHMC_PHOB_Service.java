
package com.rahul.phmc.phob.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rahul.phmc.phob.dao.PHMC_PHOB_ONBOARDDAO;
import com.rahul.phmc.phob.dao.PHMC_PHOB_USERDAO;
import com.rahul.phmc.phob.dao.PHMC_PHOB_USERONBOARDDAO;
import com.rahul.phmc.phob.model.PHMC_PHOB_ONBOARD;
import com.rahul.phmc.phob.model.PHMC_PHOB_USER;
import com.rahul.phmc.util.ErrorMessage;

/**
 * @author rahul Makvana
 *
 */
public class PHMC_PHOB_Service {
	static Logger phmc_logeer=LogManager.getLogger(PHMC_PHOB_Service.class.getName());
	private PHMC_PHOB_USER phmc_phob_pco;
	private ArrayList<PHMC_PHOB_USER> phmc_phob_pcoOnboardList;
	private PHMC_PHOB_USERDAO phmc_phob_userDAO;
	private PHMC_PHOB_ONBOARD phmc_phob_kycpco;
	private PHMC_PHOB_ONBOARDDAO phmc_phob_kycformDAO;
	private PHMC_PHOB_USERONBOARDDAO phmc_phob_userKycDAO;

	/**
	 * @param phmc_phob_pcoID
	 * @return
	 */
	public PHMC_PHOB_USER phmc_phob_getPCODetail(Long phmc_phob_pcoID) {

		phmc_phob_userDAO = new PHMC_PHOB_USERDAO();
		phmc_phob_pco = phmc_phob_userDAO.phmc_pco_readPCODetail(phmc_phob_pcoID);

		return phmc_phob_pco;
	}

	/**
	 * @param phmc_phob_pcoID
	 * @return
	 */
	public ErrorMessage phmc_phob_createPCODetail(PHMC_PHOB_USER phmc_phob_pco) {

		phmc_phob_userDAO = new PHMC_PHOB_USERDAO();
		ErrorMessage phmc_errorMsg = phmc_phob_userDAO.phmc_phob_createUser(phmc_phob_pco);
		System.out.println("Error=" + phmc_errorMsg);
		return phmc_errorMsg;
	}

	/**
	 * @param phmc_phob_pcoID
	 * @return
	 */
	public ErrorMessage phmc_phob_updatePCODetail(long phob_pcoID, PHMC_PHOB_USER phmc_phob_pco) {

		phmc_phob_userDAO = new PHMC_PHOB_USERDAO();
		ErrorMessage phmc_errorMsg = phmc_phob_userDAO.phmc_phob_updateUser(phob_pcoID, phmc_phob_pco);

		return phmc_errorMsg;
	}

	/**
	 * @param phmc_phob_pcoID
	 * @return
	 */
	public PHMC_PHOB_ONBOARD phmc_phob_getKycPCODetail(Long phmc_phob_pcoID) {

		phmc_phob_kycformDAO = new PHMC_PHOB_ONBOARDDAO();
		phmc_phob_kycpco = phmc_phob_kycformDAO.phmc_pco_readOnboardDetail(phmc_phob_pcoID);

		return phmc_phob_kycpco;
	}

	/**
	 * @param phmc_phob_pcoID
	 * @return
	 */
	public ErrorMessage phmc_phob_createKycPCODetail(PHMC_PHOB_ONBOARD phmc_phob_pco) {

		phmc_phob_kycformDAO = new PHMC_PHOB_ONBOARDDAO();
		ErrorMessage phmc_errorMsg = phmc_phob_kycformDAO.phmc_phob_createOnboard(phmc_phob_pco);

		return phmc_errorMsg;
	}

	/**
	 * @param phmc_phob_pcoID
	 * @return
	 */
	public ErrorMessage phmc_phob_updateKycPCODetail(long phob_pcoID, PHMC_PHOB_ONBOARD phmc_phob_pco) {

		phmc_phob_kycformDAO = new PHMC_PHOB_ONBOARDDAO();
		ErrorMessage phmc_errorMsg = phmc_phob_kycformDAO.phmc_phob_updateKycForm(phob_pcoID, phmc_phob_pco);

		return phmc_errorMsg;
	}

	/**
	 * @param phmc_phob_pcoID
	 * @return
	 */
	public PHMC_PHOB_USER phmc_phob_getKycWithPCODetail(Long phmc_phob_pcoID) {

		phmc_phob_userKycDAO = new PHMC_PHOB_USERONBOARDDAO();
		phmc_phob_pco = phmc_phob_userKycDAO.phmc_pco_readPCOWithOnboardDetail(phmc_phob_pcoID);

		return phmc_phob_pco;
	}

	/**
	 * @param phmc_phob_pcoID
	 * @return
	 */
	public ErrorMessage phmc_phob_createKycWithPCODetail(PHMC_PHOB_USER phmc_phob_pco) {

		phmc_phob_userKycDAO = new PHMC_PHOB_USERONBOARDDAO();
		ErrorMessage phmc_errorMsg = phmc_phob_userKycDAO.phmc_phob_createUserWithOnboard(phmc_phob_pco);

		return phmc_errorMsg;
	}

	/**
	 * @param phmc_phob_pcoID
	 * @return
	 */
	public ErrorMessage phmc_phob_updateKycWithPCODetail(long phob_pcoID, PHMC_PHOB_USER phmc_phob_pco) {

		phmc_phob_userKycDAO = new PHMC_PHOB_USERONBOARDDAO();
		ErrorMessage phmc_errorMsg = phmc_phob_userKycDAO.phmc_phob_updateWithKycUser(phob_pcoID, phmc_phob_pco);

		return phmc_errorMsg;
	}

	/**
	 * @param phmc_phob_pcoID
	 * @return
	 */
	public ErrorMessage phmc_phob_createUpdateKycWithPCO(long phob_pcoID, PHMC_PHOB_USER phmc_phob_pco) {

		phmc_phob_userKycDAO = new PHMC_PHOB_USERONBOARDDAO();
		ErrorMessage phmc_errorMsg = phmc_phob_userKycDAO.phmc_phob_createUpdateKycWithUser(phob_pcoID, phmc_phob_pco);

		return phmc_errorMsg;
	}

	/**
	 * @return
	 */
	public List<PHMC_PHOB_USER> phmc_om_readAllPCO(Integer phmc_om_pageStart, Integer phmc_om_size,
			Long phmc_om_startPCOID, Long phmc_om_endPCOID, String phmc_om_cityName, Integer phmc_om_startPinCode,
			Integer phmc_om_endPinCode, String phmc_om_emailID, String phmc_om_followUpStatusList,
			String phmc_om_kycStatusIsKycVerifiedByOfficial, String phmc_om_kycStatusIsWalletCreated,
			String phmc_om_kycStatusIsActivation, String phmc_om_kycStatusIsOtpSession,
			String phmc_om_kycStatusRemarks, String phmc_om_SignUp,
			String phmc_om_basicDetailsIsFilled, String phmc_om_welcomeMail,
			String phmc_om_kycStatusPremilinaryReview, String phmc_om_kycEverythingValid,
			String phmc_om_basicDetailsComState, String PHOB_DIST_ID) {
		
		phmc_phob_userDAO = new PHMC_PHOB_USERDAO();
		String whereCluase = "";
		if (phmc_om_startPCOID != null) {

			if (phmc_om_endPCOID != null) {
				whereCluase += " PHOB_PCOID BETWEEN " + phmc_om_startPCOID + " AND " + phmc_om_endPCOID + " ";
			} else {
				whereCluase += " PHOB_PCOID = '" + phmc_om_startPCOID + "'";
			}
		}
		if (phmc_om_startPinCode != null) {

			if (phmc_om_endPinCode != null) {
				whereCluase += " PHOB_BasicDetailsComPincode BETWEEN " + phmc_om_startPinCode + " AND "
						+ phmc_om_endPinCode + " ";
			} else {
				whereCluase += " PHOB_BasicDetailsComPincode = '" + phmc_om_startPinCode + "'";
			}
		}
		if (phmc_om_cityName != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_BasicDetailsComCity = '" + phmc_om_cityName + "' " ;
			else
				whereCluase = " PHOB_BasicDetailsComCity = '" + phmc_om_cityName + "' ";

		}
		if (phmc_om_emailID != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_Email = '" + phmc_om_emailID + "' ";
			else
				whereCluase = " PHOB_Email = '" + phmc_om_emailID + "' ";

		}
		if (phmc_om_followUpStatusList != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_FollowUpFollowUpStatusList = '" + phmc_om_followUpStatusList + "' " ;
			else
				whereCluase = " PHOB_FollowUpFollowUpStatusList = '" + phmc_om_followUpStatusList + "' ";

		}
		if (phmc_om_kycStatusIsKycVerifiedByOfficial != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_KycStatusIsKycVerifiedByOfficial"
						+ " = '" + phmc_om_kycStatusIsKycVerifiedByOfficial + "' ";
			else
				whereCluase = " PHOB_KycStatusIsKycVerifiedByOfficial "
						+ " = '" + phmc_om_kycStatusIsKycVerifiedByOfficial + "' ";

		}
		if (phmc_om_kycStatusIsWalletCreated != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_KycStatusIsWalletCreated = '" + phmc_om_kycStatusIsWalletCreated + "' ";
			else
				whereCluase = " PHOB_KycStatusIsWalletCreated = '" + phmc_om_kycStatusIsWalletCreated + "' ";

		}
		if (phmc_om_kycStatusIsActivation != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_KycStatusIsActivation = '" + phmc_om_kycStatusIsActivation + "' ";
			else
				whereCluase = " PHOB_KycStatusIsActivation = '" + phmc_om_kycStatusIsActivation + "' ";

		}
		if (phmc_om_kycStatusIsOtpSession != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_KycStatusIsOtpSession LIKE='%" + phmc_om_kycStatusIsOtpSession + "' ";
			else
				whereCluase = " PHOB_KycStatusIsOtpSession LIKE='%" + phmc_om_kycStatusIsOtpSession + "' ";

		}
		if (phmc_om_kycStatusRemarks != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_KycStatusRemarks = '" + phmc_om_kycStatusRemarks + "' ";
			else
				whereCluase = " PHOB_KycStatusRemarks = '" + phmc_om_kycStatusRemarks + "' ";

		}
		if (phmc_om_SignUp != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_SignUp = '" + phmc_om_SignUp + "' ";
			else
				whereCluase = " PHOB_SignUp = '" + phmc_om_SignUp + "' ";

		}
		if (phmc_om_basicDetailsIsFilled != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_BasicDetailsIsFilled = '" + phmc_om_basicDetailsIsFilled + "' ";
			else
				whereCluase = " PHOB_BasicDetailsIsFilled = '" + phmc_om_basicDetailsIsFilled + "' ";

		}
		if (phmc_om_welcomeMail != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_WelcomeMail = '" + phmc_om_welcomeMail + "' ";
			else
				whereCluase = " PHOB_WelcomeMail = '" + phmc_om_welcomeMail + "' ";

		}
		if (phmc_om_kycStatusPremilinaryReview != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_KycStatusPremilinaryReview = '" + phmc_om_kycStatusPremilinaryReview + "' ";
			else
				whereCluase = " PHOB_KycStatusPremilinaryReview = '" + phmc_om_kycStatusPremilinaryReview + "' ";

		}
		if (phmc_om_kycEverythingValid != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_KYCEverythingValid = '" + phmc_om_kycEverythingValid + "' ";
			else
				whereCluase = " PHOB_KYCEverythingValid = '" + phmc_om_kycEverythingValid + "' ";
		}
		if (phmc_om_basicDetailsComState != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_BasicDetailsComState = '" + phmc_om_basicDetailsComState + "' ";
			else
				whereCluase = " PHOB_BasicDetailsComState = '" + phmc_om_basicDetailsComState + "' ";
		}
		if (PHOB_DIST_ID != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_DIST_ID = '" + PHOB_DIST_ID + "' ";
			else
				whereCluase = " PHOB_DIST_ID = '" + PHOB_DIST_ID + "' ";
		}
		
		phmc_logeer.info("whereCluase :" + whereCluase);
		//System.out.println("whereCluase :" + whereCluase);

		return phmc_phob_userDAO.phmc_pco_readAllPCO(phmc_om_pageStart, phmc_om_size, whereCluase);
	}
	/**
	 * @return
	 */
	public ArrayList<PHMC_PHOB_USER> phmc_om_readPCOOnBoard(Integer phmc_om_pageStart, Integer phmc_om_size,
			Long phmc_om_startPCOID, Long phmc_om_endPCOID, String phmc_om_cityName, Integer phmc_om_startPinCode,
			Integer phmc_om_endPinCode, String phmc_om_emailID, String phmc_om_followUpStatusList,
			String phmc_om_kycStatusIsKycVerifiedByOfficial, String phmc_om_kycStatusIsWalletCreated,
			String phmc_om_kycStatusIsActivation, String phmc_om_kycStatusIsOtpSession,
			String phmc_om_kycStatusRemarks, String phmc_om_SignUp,
			String phmc_om_basicDetailsIsFilled, String phmc_om_welcomeMail,
			String phmc_om_kycStatusPremilinaryReview, String phmc_om_kycEverythingValid,
			String phmc_om_basicDetailsComState) {
		
		phmc_phob_userDAO = new PHMC_PHOB_USERDAO();
		String whereCluase = "";
		if (phmc_om_startPCOID != null) {

			if (phmc_om_endPCOID != null) {
				whereCluase += " u.PHOB_PCOID BETWEEN " + phmc_om_startPCOID + " AND " + phmc_om_endPCOID + " ";
			} else {
				whereCluase += "  u.PHOB_PCOID = '" + phmc_om_startPCOID + "' ";
			}
		}
		if (phmc_om_startPinCode != null) {

			if (phmc_om_endPinCode != null) {
				whereCluase += "  u.PHOB_BasicDetailsComPincode BETWEEN " + phmc_om_startPinCode + " AND "
						+ phmc_om_endPinCode + " ";
			} else {
				whereCluase += "  u.PHOB_BasicDetailsComPincode = '" + phmc_om_startPinCode + "' ";
			}
		}
		if (phmc_om_cityName != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND  u.PHOB_BasicDetailsComCity = '" + phmc_om_cityName + "' ";
			else
				whereCluase = "  u.PHOB_BasicDetailsComCity = '" + phmc_om_cityName + "' ";

		}
		if (phmc_om_emailID != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND  u.PHOB_Email = '" + phmc_om_emailID + "' ";
			else
				whereCluase = "  u.PHOB_Email = '" + phmc_om_emailID + "' ";

		}
		if (phmc_om_followUpStatusList != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND  u.PHOB_FollowUpFollowUpStatusList LIKE='%" + phmc_om_followUpStatusList + "' ";
			else
				whereCluase = "  u.PHOB_FollowUpFollowUpStatusList = '" + phmc_om_followUpStatusList + "' ";

		}
		if (phmc_om_kycStatusIsKycVerifiedByOfficial != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND  u.PHOB_KycStatusIsKycVerifiedByOfficial = '" + phmc_om_kycStatusIsKycVerifiedByOfficial + "' ";
			else
				whereCluase = "  u.PHOB_KycStatusIsKycVerifiedByOfficial = '" + phmc_om_kycStatusIsKycVerifiedByOfficial + "' ";

		}
		if (phmc_om_kycStatusIsWalletCreated != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND  u.PHOB_KycStatusIsWalletCreated = '" + phmc_om_kycStatusIsWalletCreated + "' ";
			else
				whereCluase = "  u.PHOB_KycStatusIsWalletCreated = '" + phmc_om_kycStatusIsWalletCreated + "' ";

		}
		if (phmc_om_kycStatusIsActivation != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND  u.PHOB_KycStatusIsActivation = '" + phmc_om_kycStatusIsActivation + "' ";
			else
				whereCluase = " PHOB_KycStatusIsActivation = '" + phmc_om_kycStatusIsActivation + "' ";

		}
		if (phmc_om_kycStatusIsOtpSession != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND  u.PHOB_KycStatusIsOtpSession = '" + phmc_om_kycStatusIsOtpSession + "' ";
			else
				whereCluase = "  u.PHOB_KycStatusIsOtpSession = '" + phmc_om_kycStatusIsOtpSession + "' ";

		}
		if (phmc_om_kycStatusRemarks != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND  u.PHOB_KycStatusRemarks = '" + phmc_om_kycStatusRemarks + "' ";
			else
				whereCluase = "  u.PHOB_KycStatusRemarks = '" + phmc_om_kycStatusRemarks + "' ";

		}
		if (phmc_om_SignUp != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND  u.PHOB_SignUp = '" + phmc_om_SignUp + "' ";
			else
				whereCluase = "  u.PHOB_SignUp = '" + phmc_om_SignUp + "' ";

		}
		if (phmc_om_basicDetailsIsFilled != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND  u.PHOB_BasicDetailsIsFilled = '" + phmc_om_basicDetailsIsFilled + "' ";
			else
				whereCluase = "  u.PHOB_BasicDetailsIsFilled = '" + phmc_om_basicDetailsIsFilled + "' ";

		}
		if (phmc_om_welcomeMail != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND  u.PHOB_WelcomeMail = '" + phmc_om_welcomeMail + "' ";
			else
				whereCluase = "  u.PHOB_WelcomeMail = '" + phmc_om_welcomeMail + "' ";

		}
		if (phmc_om_kycStatusPremilinaryReview != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND  u.PHOB_KycStatusPremilinaryReview = '" + phmc_om_kycStatusPremilinaryReview + "' ";
			else
				whereCluase = "  u.PHOB_KycStatusPremilinaryReview = '" + phmc_om_kycStatusPremilinaryReview + "' ";
		}
		if (phmc_om_kycEverythingValid != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_KYCEverythingValid = '" + phmc_om_kycEverythingValid + "' ";
			else
				whereCluase = " PHOB_KYCEverythingValid = '" + phmc_om_kycEverythingValid + "' ";
		}
		if (phmc_om_basicDetailsComState != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_BasicDetailsComState = '" + phmc_om_basicDetailsComState + "' ";
			else
				whereCluase = " PHOB_BasicDetailsComState = '" + phmc_om_basicDetailsComState + "' ";
		}

		System.out.println("whereCluase :" + whereCluase);
		phmc_phob_userKycDAO = new PHMC_PHOB_USERONBOARDDAO();
		phmc_phob_pcoOnboardList = phmc_phob_userKycDAO.phmc_pco_readPCOWithOnboard( phmc_om_pageStart,  phmc_om_size, whereCluase);
		return phmc_phob_pcoOnboardList;
	}
	
	/**
	 * @return
	 */
	public Integer phmc_om_readPCORecord(Long phmc_om_startPCOID, Long phmc_om_endPCOID, String phmc_om_cityName, Integer phmc_om_startPinCode,
			Integer phmc_om_endPinCode, String phmc_om_emailID, String phmc_om_followUpStatusList,
			String phmc_om_kycStatusIsKycVerifiedByOfficial, String phmc_om_kycStatusIsWalletCreated,
			String phmc_om_kycStatusIsActivation, String phmc_om_kycStatusIsOtpSession,
			String phmc_om_kycStatusRemarks, String phmc_om_SignUp,
			String phmc_om_basicDetailsIsFilled, String phmc_om_welcomeMail,
			String phmc_om_kycStatusPremilinaryReview, String phmc_om_kycEverythingValid,
			String phmc_om_basicDetailsComState) {
		phmc_phob_userDAO = new PHMC_PHOB_USERDAO();
		String whereCluase = "";
		if (phmc_om_startPCOID != null) {

			if (phmc_om_endPCOID != null) {
				whereCluase += " PHOB_PCOID BETWEEN " + phmc_om_startPCOID + " AND " + phmc_om_endPCOID + " ";
			} else {
				whereCluase += " PHOB_PCOID =" + phmc_om_startPCOID;
			}
		}
		if (phmc_om_startPinCode != null) {

			if (phmc_om_endPinCode != null) {
				whereCluase += " PHOB_BasicDetailsComPincode BETWEEN " + phmc_om_startPinCode + " AND "
						+ phmc_om_endPinCode + " ";
			} else {
				whereCluase += " PHOB_BasicDetailsComPincode =" + phmc_om_startPinCode;
			}
		}
		if (phmc_om_cityName != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_BasicDetailsComCity = '" + phmc_om_cityName + "'";
			else
				whereCluase = " PHOB_BasicDetailsComCity = '" + phmc_om_cityName + "' ";

		}
		if (phmc_om_emailID != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_Email = '" + phmc_om_emailID + "'";
			else
				whereCluase = " PHOB_Email = '" + phmc_om_emailID + "' ";

		}
		if (phmc_om_followUpStatusList != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_FollowUpFollowUpStatusList = '" + phmc_om_followUpStatusList + "'";
			else
				whereCluase = " PHOB_FollowUpFollowUpStatusList = '" + phmc_om_followUpStatusList + "' ";

		}
		if (phmc_om_kycStatusIsKycVerifiedByOfficial != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_KycStatusIsKycVerifiedByOfficial = '" + phmc_om_kycStatusIsKycVerifiedByOfficial + "'";
			else
				whereCluase = " PHOB_KycStatusIsKycVerifiedByOfficial = '" + phmc_om_kycStatusIsKycVerifiedByOfficial + "' ";

		}
		if (phmc_om_kycStatusIsWalletCreated != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_KycStatusIsWalletCreated = '" + phmc_om_kycStatusIsWalletCreated + "'";
			else
				whereCluase = " PHOB_KycStatusIsWalletCreated = '" + phmc_om_kycStatusIsWalletCreated + "' ";

		}
		if (phmc_om_kycStatusIsActivation != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_KycStatusIsActivation = '" + phmc_om_kycStatusIsActivation + "'";
			else
				whereCluase = " PHOB_KycStatusIsActivation = '" + phmc_om_kycStatusIsActivation + "' ";

		}
		if (phmc_om_kycStatusIsOtpSession != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_KycStatusIsOtpSession = '" + phmc_om_kycStatusIsOtpSession + "'";
			else
				whereCluase = " PHOB_KycStatusIsOtpSession = '" + phmc_om_kycStatusIsOtpSession + "' ";

		}
		if (phmc_om_kycStatusRemarks != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_KycStatusRemarks = '" + phmc_om_kycStatusRemarks + "'";
			else
				whereCluase = " PHOB_KycStatusRemarks = '" + phmc_om_kycStatusRemarks + "' ";

		}
		if (phmc_om_SignUp != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_SignUp = '" + phmc_om_SignUp + "'";
			else
				whereCluase = " PHOB_SignUp = '" + phmc_om_SignUp + "' ";

		}
		if (phmc_om_basicDetailsIsFilled != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_BasicDetailsIsFilled = '" + phmc_om_basicDetailsIsFilled + "'";
			else
				whereCluase = " PHOB_BasicDetailsIsFilled = '" + phmc_om_basicDetailsIsFilled + "' ";

		}
		if (phmc_om_welcomeMail != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_WelcomeMail = '" + phmc_om_welcomeMail + "'";
			else
				whereCluase = " PHOB_WelcomeMail = '" + phmc_om_welcomeMail + "' ";

		}
		if (phmc_om_kycStatusPremilinaryReview != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_KycStatusPremilinaryReview = '" + phmc_om_kycStatusPremilinaryReview + "'";
			else
				whereCluase = " PHOB_KycStatusPremilinaryReview = '" + phmc_om_kycStatusPremilinaryReview + "' ";
		}
		if (phmc_om_kycEverythingValid != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_KYCEverythingValid = '" + phmc_om_kycEverythingValid + "' ";
			else
				whereCluase = " PHOB_KYCEverythingValid = '" + phmc_om_kycEverythingValid + "' ";
		}
		if (phmc_om_basicDetailsComState != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHOB_BasicDetailsComState = '" + phmc_om_basicDetailsComState + "' ";
			else
				whereCluase = " PHOB_BasicDetailsComState = '" + phmc_om_basicDetailsComState + "' ";
		}
		

		System.out.println("whereCluase :" + whereCluase);

		return phmc_phob_userDAO.phmc_om_getPCORecord(whereCluase);
	}
}
