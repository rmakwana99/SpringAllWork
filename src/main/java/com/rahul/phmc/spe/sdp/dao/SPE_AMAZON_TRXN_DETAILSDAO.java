
package com.rahul.phmc.spe.sdp.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import com.rahul.phmc.spe.router.dao.SPE_XMonDao;
import com.rahul.phmc.spe.sdp.model.SPE_AMAZON_TRXN_DETAILSModel;
import com.rahul.phmc.spe.sdp.model.SPE_SDP_BankDailySettlementModel;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.PHMC_DB_ERROR;
import com.rahul.phmc.util.persistance.PayhindHibernateUtil;

/**
 * @author rahul Makvana
 *
 */
public class SPE_AMAZON_TRXN_DETAILSDAO {
	// this is creation of logger so we can check what log created.
		static final Logger log = Logger.getLogger(SPE_XMonDao.class);
		private Session session = null;
		private Transaction transaction = null;
		private int count = 0;
		private ErrorMessage phmc_errorMsg;

	/**
	 * @param spe_earningList
	 * @return
	 */
	public ErrorMessage spe_sdp_uploadAmazonOrder(List<SPE_AMAZON_TRXN_DETAILSModel> spe_amzonOrderList) {
		phmc_errorMsg = new ErrorMessage();
		try {
			session = PayhindHibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			for (SPE_AMAZON_TRXN_DETAILSModel amazonOrder : spe_amzonOrderList) {
				session.save(amazonOrder);

				if (++count % 20 == 0) {
					session.flush();
					session.clear();
				}
			}
			transaction.commit();
			phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_SUCCESS);
			phmc_errorMsg.setErrorMessage("File Upload Successfully");

		} 
		catch (ConstraintViolationException ex) {
			phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_USER_ALREADY_EXISTS);
			phmc_errorMsg.setErrorMessage("Data Already available in DB");
			log.error("Constraint Voilation", ex);
		} catch (Exception e) {
			transaction.rollback();
			phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_INSERT_FAILED);
			phmc_errorMsg.setErrorMessage("File Database Insertion Failed");
			log.error("File Upload Failed : " +e.getMessage());
			e.printStackTrace();
		} finally {
			session.close();
		}
		return phmc_errorMsg;

	}
	
	public int spe_readAmazonTxnDetails(String transactionID) {

		List<SPE_AMAZON_TRXN_DETAILSModel> sdpModel=new ArrayList<SPE_AMAZON_TRXN_DETAILSModel>();
		int size=0;
		Session session = PayhindHibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(
					"FROM SPE_AMAZON_TRXN_DETAILSModel WHERE SPE_TransactionID= '" + transactionID + "'");
			sdpModel = (List<SPE_AMAZON_TRXN_DETAILSModel>) query.list();

			log.info(sdpModel);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		size=sdpModel.size();
		return size;
	}

}
