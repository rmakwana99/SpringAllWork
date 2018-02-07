package com.rahul.phmc.om.login.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rahul.phmc.om.login.dao.PHMC_OM_LoginDAO;
import com.rahul.phmc.om.login.model.PHMC_OM_LOGIN;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.PHMC_DB_ERROR;
import com.rahul.phmc.util.persistance.PayhindHibernateUtil;

/**
 * @author rahul
 *  THis is login service class to invoke all db
 *         related operation
 */
public class PHMC_OM_LoginService {
	static Logger phmc_logeer=LogManager.getLogger(PHMC_OM_LoginService.class.getName());
	private PHMC_OM_LoginDAO phmc_om_loginDAO;
	private PHMC_OM_LOGIN phmc_om_login;
	private List<PHMC_OM_LOGIN> phmc_om_userList = null;
	

	public PHMC_OM_LoginService() {
		super();
		phmc_om_loginDAO =  new PHMC_OM_LoginDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * this method reads login details from database access api and returns login details
	 */
	public PHMC_OM_LOGIN phmc_om_readLoginDetail(String phmc_om_userName) {

		phmc_om_loginDAO = new PHMC_OM_LoginDAO();
		phmc_om_login = phmc_om_loginDAO.phmc_om_readLoginDetail(phmc_om_userName);

		return phmc_om_login;
	}
	
	/**
	 * @param phmc_om_userName
	 * @param phmc_pageNo
	 * @param phmc_pageSize
	 * @param phmc_cityName
	 * @param phmc_startPinCode
	 * @param phmc_endPinCode
	 * @param phmc_emailID
	 * @param phmc_startDate
	 * @param phmc_endDate
	 * @param phmc_activeStatus
	 * @param phmc_effectiveDate
	 * @param phmc_effectiveEndDate
	 * @param phmc_roleCode
	 * @return
	 */
	public List<PHMC_OM_LOGIN>phmc_om_readLoginBySearch(String phmc_userName, Integer phmc_pageNo, Integer phmc_pageSize,
			String phmc_cityName,Integer phmc_startPinCode, Integer phmc_endPinCode, String phmc_emailID, String phmc_startDate,
			String phmc_endDate, Integer phmc_activeStatus, String phmc_effectiveDate, String phmc_effectiveEndDate,
			Integer phmc_roleCode){
		
		String whereCluase = "";
		System.out.println("phmc_userName :" + phmc_userName);
		if (phmc_userName != null) {

			
				whereCluase += " PHMC_OM_UserName LIKE '%" + phmc_userName + "%'";
			
		}
		if (phmc_startPinCode != null) {

			if (phmc_endPinCode != null) {
				whereCluase += " PHMC_OM_Pincode BETWEEN " + phmc_startPinCode + " AND "
						+ phmc_endPinCode + " ";
			} else {
				whereCluase += " PHMC_OM_Pincode LIKE '%" + phmc_startPinCode + "%'";
			}
		}
		if (phmc_startDate != null) {

			if (phmc_endDate != null) {
				whereCluase += " PHMC_OM_CreatedDate BETWEEN " + phmc_startDate + " AND "
						+ phmc_endDate + " ";
			} else {
				whereCluase += " PHMC_OM_CreatedDate LIKE '%" + phmc_startDate + "%'";
			}
		}
		if (phmc_cityName != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHMC_OM_City LIKE '%" + phmc_cityName + "%' " ;
			else
				whereCluase = " PHMC_OM_City LIKE '%" + phmc_cityName + "%' ";

		}
		if (phmc_emailID != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHMC_OM_Email LIKE '%" + phmc_emailID + "%' " ;
			else
				whereCluase = " PHMC_OM_Email LIKE '%" + phmc_emailID + "%' ";

		}
		if (phmc_activeStatus != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHMC_OM_ActiveStatus LIKE '%" + phmc_activeStatus + "%' " ;
			else
				whereCluase = " PHMC_OM_ActiveStatus LIKE '%" + phmc_activeStatus + "%' ";

		}
		if (phmc_effectiveDate != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHMC_OM_EffectiveDate LIKE '%" + phmc_effectiveDate + "%' ";
			else
				whereCluase = " PHMC_OM_EffectiveDate LIKE '%" + phmc_effectiveDate + "%' ";

		}
		if (phmc_effectiveEndDate != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHMC_OM_EffectiveEndDate LIKE '%" + phmc_effectiveEndDate + "%' ";
			else
				whereCluase = " PHMC_OM_EffectiveEndDate LIKE '%" + phmc_effectiveEndDate + "%' ";

		}
		if (phmc_roleCode != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHMC_OM_RoleCode LIKE '%" + phmc_roleCode + "%' ";
			else
				whereCluase = " PHMC_OM_RoleCode LIKE '%" + phmc_roleCode + "%' ";

		}
		phmc_logeer.info("phmc_logeer : " + whereCluase );
		System.out.println("whereCluase : " + whereCluase);
		phmc_om_userList = phmc_om_loginDAO.phmc_om_readLoginBySearch(phmc_pageNo,  phmc_pageSize , whereCluase);
		return phmc_om_userList;
	}
	 

	/**
	 * Provides service for new login creation
	 * @param phmc_om_login
	 * @return
	 */
	public ErrorMessage phmc_phob_createLoginDetail(PHMC_OM_LOGIN phmc_om_login) {

		phmc_om_loginDAO = new PHMC_OM_LoginDAO();
		ErrorMessage phmc_errorMsg = phmc_om_loginDAO.phmc_om_createLoginDetail(phmc_om_login);

		return phmc_errorMsg;
	}

	/**
	 * Provides service for new login update
	 * @param phmc_om_userName
	 * @param phmc_om_login
	 * @return
	 */
	public ErrorMessage phmc_phob_updateLoginDetail(String phmc_om_userName, PHMC_OM_LOGIN phmc_om_login) {

		phmc_om_loginDAO = new PHMC_OM_LoginDAO();
		ErrorMessage phmc_errorMsg = phmc_om_loginDAO.phmc_om_updateLoginDetail(phmc_om_userName, phmc_om_login);

		return phmc_errorMsg;
	}

	
	
	
	@SuppressWarnings({ "null", "unchecked" })
	public ErrorMessage phmc_phob_createUpdateLoginDetail(String phmc_om_userName, PHMC_OM_LOGIN phmc_om_login) {

		Session session = PayhindHibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<PHMC_OM_LOGIN> phmc_phob_loginlist = new ArrayList<PHMC_OM_LOGIN>();
		if(phmc_om_userName !=null)
		phmc_om_login.setPHMC_OM_UserName(phmc_om_userName);;
		phmc_om_loginDAO = new PHMC_OM_LoginDAO();
		ErrorMessage phmc_errorMsg = null;

		try {
			System.out.println("enter in connection");
			transaction = session.beginTransaction();

			Query<PHMC_OM_LOGIN> query = session.createQuery("From PHMC_OM_LOGIN where PHMC_OM_UserName=?");
			query.setParameter(0, phmc_om_userName);
			phmc_phob_loginlist = query.getResultList();
			transaction.commit();

			if (phmc_phob_loginlist.size() == 0) {
				phmc_errorMsg = phmc_om_loginDAO.phmc_om_createLoginDetail(phmc_om_login);
			} else if (phmc_phob_loginlist.size() == 1) {
				phmc_errorMsg = phmc_om_loginDAO.phmc_om_updateLoginDetail(phmc_om_userName, phmc_om_login);
			} else if (phmc_phob_loginlist.size() >= 2) {
				phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_DUPLICATE_RECORD_FOUND);
				phmc_errorMsg.setErrorMessage(
						"Login with ID " + phmc_om_login.getPHMC_OM_UserName() + " Duplicate Record Found");
			}

		} catch (HibernateException e1) {
			phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_INSERT_FAILED);
			phmc_errorMsg.setErrorMessage("Login with ID " + phmc_om_login.getPHMC_OM_UserName() + " Creation Failed");
			e1.printStackTrace();
		} finally {
			session.close();
		}

		return phmc_errorMsg;
	}
}
