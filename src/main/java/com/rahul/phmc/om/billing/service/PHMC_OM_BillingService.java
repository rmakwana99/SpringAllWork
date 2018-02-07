package com.rahul.phmc.om.billing.service;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rahul.phmc.om.billing.dao.PHMC_OM_BillingDAO;
import com.rahul.phmc.om.billing.model.PHMC_OM_BILLING;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.PHMC_DB_ERROR;
import com.rahul.phmc.util.persistance.PayhindHibernateUtil;

/**
 * @author rahul
 *
 */
public class PHMC_OM_BillingService {

	private PHMC_OM_BillingDAO phmc_om_billDAO;
	private PHMC_OM_BILLING phmc_om_billing;

	public PHMC_OM_BillingService() {

		phmc_om_billing = new PHMC_OM_BILLING();
		phmc_om_billDAO = new PHMC_OM_BillingDAO();

	}

	public PHMC_OM_BILLING phmc_phob_readBillDetail(Long phmc_om_pcoID) {

		phmc_om_billing = phmc_om_billDAO.phmc_om_readBilling(phmc_om_pcoID);

		return phmc_om_billing;
	}

	public List<PHMC_OM_BILLING> phmc_om_readAllBill(Integer phmc_om_pageStart, Integer phmc_om_size,
			Long phmc_om_startPCOID, int phmc_isStatementSent) {

		String whereCluase = "";
		if (phmc_om_startPCOID != null) {

			whereCluase += " PHMC_OM_PCOID = '" + phmc_om_startPCOID + "'";

		}
		if (phmc_isStatementSent >= 0) {

			if (!whereCluase.equals("")) {
				whereCluase += "AND PHMC_IsStatementSent = " + phmc_isStatementSent + "";
			}else{
				whereCluase += " PHMC_IsStatementSent = " + phmc_isStatementSent + "";
			}
		}

		System.out.println("whereCluase :" + whereCluase);

		return phmc_om_billDAO.phmc_om_readAllBill(phmc_om_pageStart, phmc_om_size, whereCluase);
	}

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ErrorMessage phmc_om_addUpdateBill(long phmc_om_pco, PHMC_OM_BILLING phmc_om_billing) {

		
		
		ErrorMessage phmc_errorMsg = new ErrorMessage();
		Session session = PayhindHibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<PHMC_OM_BILLING> phmc_om_billList = new ArrayList<PHMC_OM_BILLING>();

		try {
			System.out.println("enter in connection");
			transaction = session.beginTransaction();

			Query<PHMC_OM_BILLING> query = session.createQuery("From PHMC_OM_BILLING where PHMC_OM_PCOID=?");
			query.setParameter(0, phmc_om_pco);
			phmc_om_billList = query.getResultList();
			transaction.commit();

			if (phmc_om_billList.size() == 0) {
				phmc_errorMsg = phmc_om_billDAO.phmc_om_createBill(phmc_om_billing);
			} else if (phmc_om_billList.size() == 1) {
				phmc_errorMsg = phmc_om_billDAO.phmc_om_updateBill(phmc_om_pco, phmc_om_billing);
			} else if (phmc_om_billList.size() >= 2) {
				phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_DUPLICATE_RECORD_FOUND);
				phmc_errorMsg.setErrorMessage("PCO with ID " + phmc_om_pco + " Duplicate Record Found");
			}

		} catch (HibernateException e1) {
			phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_INSERT_FAILED);
			phmc_errorMsg.setErrorMessage("PCO with ID " + phmc_om_pco + " Creation Failed");
			e1.printStackTrace();
		} finally {
			session.close();
		}
		return phmc_errorMsg;
	}

}
