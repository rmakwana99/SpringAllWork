
package com.rahul.phmc.spe.router.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import com.rahul.phmc.spe.router.model.SPE_TRXNDetailsISROModel;
import com.rahul.phmc.spe.router.model.SPE_TRXNDetailsModel;
import com.rahul.phmc.spe.router.model.SPE_TRXNDetailsPYHDModel;
import com.rahul.phmc.spe.router.model.SPE_TRXNDetailsSPAYModel;
import com.rahul.phmc.spe.router.model.SPE_TRXNDetailsSRSHModel;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.PHMC_DB_ERROR;
import com.rahul.phmc.util.persistance.PayhindHibernateUtil;

/**
 * @author rahul Makvana
 *
 */
public class SPE_XMonDao {

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
	public ErrorMessage spe_sdp_uploadAmazonOrder(List<SPE_TRXNDetailsSRSHModel> spe_amzonOrderList) {
		phmc_errorMsg = new ErrorMessage();
		try {
			
			session = PayhindHibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			for (SPE_TRXNDetailsSRSHModel amazonOrder : spe_amzonOrderList) {
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

	// This method checks to which table the merchant id belongs to and gets the
	// data based on wherecluase.
	@SuppressWarnings("unchecked")
	public List<SPE_TRXNDetailsModel> spe_getalltransactionthruid(String whereCluase, String MID) {

		List<SPE_TRXNDetailsModel> data1 = new ArrayList<SPE_TRXNDetailsModel>();
		// String mID="SRSH";
		String tableName = "";

		if (MID.equalsIgnoreCase("SRSH")) {
			tableName = "SPE_TRXNDetailsSRSHModel";
		} else if (MID.equalsIgnoreCase("ISRO")) {
			tableName = "SPE_TRXNDetailsISROModel";
		} else if (MID.equalsIgnoreCase("PYHD")) {
			tableName = "SPE_TRXNDetailsPYHDModel";
		} else if (MID.equalsIgnoreCase("SPAY")) {
			tableName = "SPE_TRXNDetailsSPAYModel";
		}else {
			tableName = "";
		}
		if (!whereCluase.trim().isEmpty()) {
			whereCluase = " WHERE " + whereCluase;
		}
		System.out.println(tableName);
		Session session = PayhindHibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		// System.out.println("This is inside method");
		try {
			// System.out.println("This is try block");
			tx = session.beginTransaction();
			data1 = session.createQuery("FROM " + tableName + whereCluase).list();
			log.info(data1);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return data1;
	}

	public SPE_TRXNDetailsModel spe_readSPETRXNDetails(String transactionID) {
		String tableName = null;
		SPE_TRXNDetailsModel trxmodel = null;
		tableName = SPE_XMonDao.getTableName(transactionID);

		if (!tableName.equals("") && tableName != null) {
			Session session = PayhindHibernateUtil.getSessionFactory().openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				Query query = session
						.createQuery("FROM " + tableName + " WHERE SPE_TransactionID= '" + transactionID + "'");
				if (tableName.equals("SPE_TRXNDetailsSRSHModel")) {
					trxmodel = (SPE_TRXNDetailsSRSHModel) query.uniqueResult();
				} else if (tableName.equals("SPE_TRXNDetailsISROModel")) {
					trxmodel = (SPE_TRXNDetailsISROModel) query.uniqueResult();
				} else if (tableName.equals("SPE_TRXNDetailsPYHDModel")) {
					trxmodel = (SPE_TRXNDetailsPYHDModel) query.uniqueResult();
				}else if (tableName.equals("SPE_TRXNDetailsSPAYModel")) {
					trxmodel = (SPE_TRXNDetailsSPAYModel) query.uniqueResult();
				} else {
					trxmodel = (SPE_TRXNDetailsModel) query.uniqueResult();
				}
				log.info(trxmodel);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				log.error(e.getMessage());
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		return trxmodel;
	}

	public static String getTableName(String transactionID) {
		String clientID = null;
		String tableName = null;

		if (!transactionID.trim().isEmpty()) {
			clientID = transactionID.substring(1, 5);
			if (clientID != null) {
				tableName = "SPE_TRXNDetails" + clientID.trim() + "Model";
			}

		} else {
			transactionID = "";
		}

		return tableName;
	}

	/**
	 * @param spe_TxnDeatails
	 * @return
	 */
	public ErrorMessage spe_UpdateTrxDetails(SPE_TRXNDetailsModel spe_TxnDeatails) {
		ErrorMessage spe_error = new ErrorMessage();

		Session session = null;
		if (spe_TxnDeatails != null) {
			// SPE_HibernateUtil.shutdown();
			session = PayhindHibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();

				session.update(spe_TxnDeatails);
				transaction.commit();

				log.info("Transaction Details updated Successfully");
				spe_error.setErrorCode(PHMC_DB_ERROR.PHMC_SUCCESS);
				spe_error.setErrorMessage(spe_TxnDeatails.getSPE_TransactionID() + " updated Successfully");
			} catch (Exception e) {
				transaction.rollback();
				spe_error.setErrorCode(PHMC_DB_ERROR.PHMC_UPDATE_FAILED);
				spe_error.setErrorMessage(spe_TxnDeatails.getSPE_TransactionID() + " updation Failed");
				log.error("File Upload Failed");
				log.error(e.getMessage());
			} finally {
				session.close();
			}
		} else {
			spe_error.setErrorCode(PHMC_DB_ERROR.PHMC_DATA_NOT_FOUND);
			spe_error.setErrorMessage("Data not found");
			log.error("Data not found");
		}

		return spe_error;
	}

	/**
	 * @param spe_TxnDeatails
	 * @return
	 */
	public ErrorMessage spe_CreateTrxDetails(SPE_TRXNDetailsModel spe_TxnDeatails) {
		ErrorMessage spe_error = new ErrorMessage();

		if (spe_TxnDeatails != null) {
			Session session = PayhindHibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();

				System.out.println(spe_TxnDeatails);
				session.persist(spe_TxnDeatails);
				transaction.commit();
				System.out.println("create sucessfully");
				log.info("Transaction Details updated Successfully");
				spe_error.setErrorCode(PHMC_DB_ERROR.PHMC_SUCCESS);
				spe_error.setErrorMessage(spe_TxnDeatails.getSPE_TransactionID() + " created Successfully");
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
				spe_error.setErrorCode(PHMC_DB_ERROR.PHMC_INSERT_FAILED);
				spe_error.setErrorMessage(spe_TxnDeatails.getSPE_TransactionID() + " creation Failed");
				log.error("File Upload Failed");
				log.error(e.getMessage());
			} finally {
				session.close();
			}
		} else {
			spe_error.setErrorCode(PHMC_DB_ERROR.PHMC_DATA_NOT_FOUND);
			spe_error.setErrorMessage("Data not found");
			log.error("Data not found");
		}

		return spe_error;
	}


}
