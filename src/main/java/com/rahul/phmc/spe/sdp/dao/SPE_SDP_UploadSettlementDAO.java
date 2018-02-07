
package com.rahul.phmc.spe.sdp.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import com.rahul.phmc.spe.sdp.model.SPE_SDP_BankDailySettlementModel;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.PHMC_DB_ERROR;
import com.rahul.phmc.util.persistance.PayhindHibernateUtil;

/**
 * @author rahul Makvana
 *
 */
public class SPE_SDP_UploadSettlementDAO {

	// this is creation of logger so we can check what log created.
	static final Logger log = Logger.getLogger(SPE_SDP_UploadSettlementDAO.class);

	public List<SPE_SDP_BankDailySettlementModel> spe_spd_uploadBankSettlement(List<SPE_SDP_BankDailySettlementModel> spdList) {
		
		int count = 0;
		ErrorMessage phmc_errorMsg= new ErrorMessage();
		Session session = null;
		// long starttime = 0;
		// long endtime = 0;
		if (spdList.size() > 0 && spdList != null) {

			Transaction transaction = null;
			// starttime=System.currentTimeMillis();
			try {
				session = PayhindHibernateUtil.getSessionFactory().openSession();
				transaction = session.beginTransaction();

				for (SPE_SDP_BankDailySettlementModel spdModel : spdList) {
					session.save(spdModel);

					if (++count % 20 == 0) {
						session.flush();
						session.clear();
					}
					
					spdModel.setInsertCheck(true);
					spdModel.setInsertError("Inserted Successfully");
				}
				transaction.commit();
				// endtime=System.currentTimeMillis();
				// System.out.println(endtime-starttime);
				log.info(count);
				log.info("File Upload Successfully");

			} catch (ConstraintViolationException e) {
				transaction.rollback();
				phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_USER_ALREADY_EXISTS);
				phmc_errorMsg.setErrorMessage("Data Already available in DB");
				log.error("Some unique key override");
			} catch (Exception e) {
				transaction.rollback();
				phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_INSERT_FAILED);
				phmc_errorMsg.setErrorMessage("File Upload Failed");
				log.error("File Upload Failed");
				e.printStackTrace();
			} finally {
				session.close();
			}
		} else {
			phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_NO_RECORD_IN_EXCEL);
			phmc_errorMsg.setErrorMessage("No Record Found in Excel File");
			log.error("File Upload Failed");
		}
		return spdList;
	}

	public int spe_readDailySettlement(String transactionID) {

		List<SPE_SDP_BankDailySettlementModel> sdpModel=new ArrayList<SPE_SDP_BankDailySettlementModel>();
		int size=0;
		Session session = PayhindHibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(
					"FROM SPE_SDP_BankDailySettlementModel WHERE SPE_OrderNo= '" + transactionID + "'");
			sdpModel = (List<SPE_SDP_BankDailySettlementModel>) query.list();

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
