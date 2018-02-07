
package com.rahul.phmc.sdp.commssion.dist.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.*;

import com.rahul.phmc.sdp.commssion.dist.model.SPE_CommissionDist;
import com.rahul.phmc.spe.router.model.SPE_TRXNDetailsModel;
import com.rahul.phmc.spe.router.model.SPE_TRXNDetailsSRSHModel;
import com.rahul.phmc.spe.router.services.SPE_XMonService;
import com.rahul.phmc.util.PHMC_DateParser;
import com.rahul.phmc.util.persistance.PayhindHibernateUtil;

/**
 * @author rahul Makvana
 *
 */
public class SPE_CommssionDistDAO {
	static final Logger log = Logger.getLogger(SPE_CommssionDistDAO.class);
	private SPE_CommissionDist commissionDist;
	List<SPE_CommissionDist> commissionDistList;
	List<SPE_TRXNDetailsModel> txnDetailList;
	private SPE_CommissionDist commissionStrucureLevel;
	private Session session;
	private Transaction txn;
	private int batchSize = 25;
	ScrollableResults scrollableResults = null;
	private Double calcutedCommission;
	private SPE_TRXNDetailsSRSHModel person;

	/**
	 * @return
	 */
	private  List<SPE_CommissionDist> getCommissionDist() {

		// commissionDist = new SPE_CommissionDist();
		// Get session
		// session = PayhindHibernateUtil.getSessionFactory().openSession();
		// txn = session.beginTransaction();
		List<SPE_CommissionDist> commissionDist = session.createQuery("FROM SPE_CommissionDist").getResultList();
		// txn.commit();
		// session.close();
		return commissionDist;
	}

	/**
	 * Calculates commission distribution anf
	 */
	public boolean updateCommission(String startDate) {
          boolean isUpdated = false;
          String whereClause = "";
		try {
			session = PayhindHibernateUtil.getSessionFactory().openSession();
			txn = session.beginTransaction();
			log.info(txn.getStatus());
			if(startDate != null){
				whereClause = "and p.SPE_SettlementDate = '"+startDate+"'";
			}
			scrollableResults = session
					.createQuery("select p from SPE_TRXNDetailsSRSHModel AS p"
							+ " where p.SPE_SettlementStatus = 'Y'  and p.SPE_ValidationStatus = 0  and p.SPE_ProcessingStatus = 1 " + whereClause)
					.setCacheMode(CacheMode.IGNORE).scroll(ScrollMode.FORWARD_ONLY);
			commissionDistList = this.getCommissionDist();
			int count = 0;
			// log.debug(scrollableResults.next());
			while (scrollableResults.next()) {
				person = (SPE_TRXNDetailsSRSHModel) scrollableResults.get(0);
				log.debug("Before :" + person);

				this.calculateCommission(commissionDistList, person);
				log.debug("after : " + person);

				if (++count % batchSize == 0) {
					log.debug(count);
					// flush a batch of updates and release memory:
					session.flush();
					session.clear();
				}
				log.info(txn.getStatus());
				isUpdated =  true;
			}
			
			txn.commit();

		} catch (RuntimeException e) {
			log.error(e.getMessage());
			if (txn != null && txn.isActive()) {

				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				log.error("\n.......Transaction Is Being Rolled Back.......");
				txn.rollback();

			}
			throw e;
		} finally {
			if (scrollableResults != null) {
				scrollableResults.close();
			}
			if (session != null) {
				session.close();
				// PayhindHibernateUtil.shutdown();
			}
		}
		log.debug("isupdted : " + isUpdated);
		return isUpdated;
	}
	
	
	public void updateCommissionForTransactions(SPE_TRXNDetailsModel transactionDetail) {
		
	}
	
	public List<SPE_CommissionDist> getCommissionDistribution() {
		List<SPE_CommissionDist> commDistList = null;
		try {
			session = PayhindHibernateUtil.getSessionFactory().openSession();
			txn = session.beginTransaction();
			log.info(txn.getStatus());
			commDistList = (List<SPE_CommissionDist>)session.createQuery("FROM SPE_CommissionDist").getResultList();
			txn.commit();

		} catch (RuntimeException e) {
			log.error(e.getMessage());
			if (txn != null && txn.isActive()) {

				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				log.error("\n.......Transaction Is Being Rolled Back.......");
				txn.rollback();
			}
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return commDistList;
	}

	/**
	 * @param commissionDistList
	 * @param txnDetailList
	 */
	public void calculateCommission(List<SPE_CommissionDist> commissionDistList,
			SPE_TRXNDetailsModel spe_TRXNDetailsModel) {

		this.commissionDistList = commissionDistList;

		// calculation of bank Commission
		commissionStrucureLevel = commissionDistList.get(0);

		this.commissionLogic(spe_TRXNDetailsModel);
		log.info("Bank Commission : " + calcutedCommission);
		spe_TRXNDetailsModel.setSPE_ComsnBank((Float.parseFloat(String.valueOf(calcutedCommission))));

		// calculation of L2 Merchant Commission
		commissionStrucureLevel = commissionDistList.get(1);

		this.commissionLogic(spe_TRXNDetailsModel);
		log.info("Merchant Commission : " + calcutedCommission);
		spe_TRXNDetailsModel.setSPE_ComsnMerchant((Float.parseFloat(String.valueOf(calcutedCommission))));

		// calculation of L4 Distributer Commission
		commissionStrucureLevel = commissionDistList.get(2);
		this.commissionLogic(spe_TRXNDetailsModel);
		log.info("Distributer Commission : " + calcutedCommission);
		spe_TRXNDetailsModel.setSPE_ComsnTerminalHub((Float.parseFloat(String.valueOf(calcutedCommission))));

		// calculation of L5 PCO Commission
		commissionStrucureLevel = commissionDistList.get(3);
		this.commissionLogic(spe_TRXNDetailsModel);
		log.info("PCO Commission : " + calcutedCommission);
		spe_TRXNDetailsModel.setSPE_ComsnTerminID((Float.parseFloat(String.valueOf(calcutedCommission))));
		spe_TRXNDetailsModel.setSPE_ProcessingStatus(00);
		spe_TRXNDetailsModel.setSPE_ComsnProcessDate(PHMC_DateParser.getCurrentDate());

	}

	/**
	 * If Fixed amount as 2 and min value as 3 and max value as 10 for Yesbank.
	 * So in that case for 10 Rs transaction Yesbank will charge Rs 3 even
	 * though the summation of fixed amount (Rs 2) and calculated commission
	 * value (Rs. 0.1) is < 3 because that is the minimum value defined in the
	 * table. For the same configuration if the transaction amount is 1000 then
	 * Yesbank will charge Rs 10 even though fixed amount (2) + calculated
	 * commission value (10) > Rs 10 which is defined as the max value. If the
	 * transaction amount is Rs 100 then Yesbank will deduct fixed amount (2) +
	 * calculated commission (1) = 3 as it is between the min and max value
	 * range
	 * 
	 * 
	 */
	private  void commissionLogic(SPE_TRXNDetailsModel spe_TRXNDetailsModel) {
		// log.info(spe_TRXNDetailsModel.getSPE_TransactionID() +
		// spe_TRXNDetailsModel.getSPE_PaymentAmount());
		if (null == spe_TRXNDetailsModel.getSPE_PaymentAmount()) {
			spe_TRXNDetailsModel.setSPE_PaymentAmount(0F);
		}
		if (null == commissionStrucureLevel.getFixedAmount()) {
			commissionStrucureLevel.setFixedAmount(0D);
		}
		calcutedCommission = commissionStrucureLevel.getFixedAmount()
				+ (spe_TRXNDetailsModel.getSPE_PaymentAmount() * commissionStrucureLevel.getCommissionPCTN() / 100);

		if (null != commissionStrucureLevel.getCommssionMinValue()
				&& calcutedCommission < commissionStrucureLevel.getCommssionMinValue()) {
			calcutedCommission = commissionStrucureLevel.getCommssionMinValue();
		} else if (null != commissionStrucureLevel.getCommssionMinValue()
				&& null != commissionStrucureLevel.getCommssionMaxValue()
				&& calcutedCommission > commissionStrucureLevel.getCommssionMinValue()
				&& calcutedCommission > commissionStrucureLevel.getCommssionMaxValue()) {
			calcutedCommission = commissionStrucureLevel.getCommssionMaxValue();
		}
	}
}
