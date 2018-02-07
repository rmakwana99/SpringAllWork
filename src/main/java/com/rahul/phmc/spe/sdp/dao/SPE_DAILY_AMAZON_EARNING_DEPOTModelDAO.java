
package com.rahul.phmc.spe.sdp.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.rahul.phmc.spe.sdp.model.SPE_DAILY_AMAZON_EARNING_DEPOTModel;
import com.rahul.phmc.spe.sdp.model.SPE_SDP_BankDailySettlementModel;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.PHMC_DB_ERROR;
import com.rahul.phmc.util.persistance.PayhindHibernateUtil;

/**
 * @author rahul Makvana
 *
 */
public class SPE_DAILY_AMAZON_EARNING_DEPOTModelDAO {
	// this is creation of logger so we can check what log created.
	static final Logger log = Logger.getLogger(SPE_DAILY_AMAZON_EARNING_DEPOTModelDAO.class);
	private Session session = null;
	private Transaction transaction = null;
	private int count = 0;
	ErrorMessage phmc_errorMsg;

	public ErrorMessage spe_sdp_uploadAmazonEaring(List<SPE_DAILY_AMAZON_EARNING_DEPOTModel> spe_earningList) {

		phmc_errorMsg = new ErrorMessage();
		try {
			session = PayhindHibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			for (SPE_DAILY_AMAZON_EARNING_DEPOTModel amazonEarningDepot : spe_earningList) {
				if (amazonEarningDepot.getSpe_excelcheck()) {
					session.save(amazonEarningDepot);

					if (++count % 20 == 0) {
						session.flush();
						session.clear();
					}
				}else{
					amazonEarningDepot.setSpe_insertCheck(false);
				}
			}
			transaction.commit();
			phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_SUCCESS);
			phmc_errorMsg.setErrorMessage("File Upload Successfully");

		} catch (ConstraintViolationException ex) {
			phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_USER_ALREADY_EXISTS);
			phmc_errorMsg.setErrorMessage("Data Already available in DB");
			log.error("Constraint Voilation", ex);
		} catch (Exception e) {
			transaction.rollback();
			phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_INSERT_FAILED);
			phmc_errorMsg.setErrorMessage("File Upload Failed");
			log.error("File Upload Failed");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return phmc_errorMsg;
	}
}
