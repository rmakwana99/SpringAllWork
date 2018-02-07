package com.rahul.phmc.spe.merchant.dao;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rahul.phmc.spe.merchant.model.SPE_MerchantModel;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.PHMC_DB_ERROR;
import com.rahul.phmc.util.persistance.PayhindHibernateUtil;

/**
 * @author SrishtiESDM-Sasipriya
 *
 */
public class SPE_MerchantDao {
	// this is creation of logger so we can check what log created.
	static final Logger log = Logger.getLogger(SPE_MerchantDao.class);

	// SPE_MerchantModel modellist=new SPE_MerchantModel();
	// This method is to create merchant record data.
	public ErrorMessage spe_createmerchant(SPE_MerchantModel modellist) {
		ErrorMessage payezee_errormsg = new ErrorMessage();
		Session session = null;
		SPE_MerchantDao dao= new SPE_MerchantDao();

		Transaction transaction = null;
		try {
			session = PayhindHibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			modellist.setSPE_MerchantKey(dao.nextSessionId());
			session.save(modellist);
			// log.info(modellist);
			transaction.commit();
			payezee_errormsg.setErrorCode(PHMC_DB_ERROR.PHMC_SUCCESS);
			payezee_errormsg
					.setErrorMessage("Merchant with ID " + modellist.getSPE_UserName() + " Created Successfully");

		} catch (HibernateException e) {
			transaction.rollback();
			payezee_errormsg.setErrorCode(PHMC_DB_ERROR.PHMC_INSERT_FAILED);
			payezee_errormsg.setErrorMessage("Merchant with ID " + modellist.getSPE_UserName() + " Creation Failed");
			e.printStackTrace();
		} finally {

			session.close();

		}
		return payezee_errormsg;

	}

	// This method is to update the merchant data
	public ErrorMessage spe_updatemerchant(String SPE_UserName, SPE_MerchantModel modellist) {
		ErrorMessage payezee_errormsg = new ErrorMessage();
		Session session = null;
		Transaction transaction = null;
		if (modellist != null) {
			try {
				session = PayhindHibernateUtil.getSessionFactory().openSession();
				transaction = session.beginTransaction();

				String hql = "Update SPE_MerchantModel set SPE_email= :SPE_email,SPE_Password=:SPE_Password,SPE_Salt=:SPE_Salt,SPE_Address1= :SPE_Address1,SPE_Address2= :SPE_Address2,SPE_Address3= :SPE_Address3,"
						+ "SPE_City= :SPE_City,SPE_State= :SPE_State,SPE_UpdatedDate=:SPE_UpdatedDate,SPE_UpdatedBy=:SPE_UpdatedBy,SPE_Pincode= :SPE_Pincode,SPE_Phone= :SPE_Phone,"
						+ "SPE_ActiveStatus= :SPE_ActiveStatus,SPE_EffectiveDate= :SPE_EffectiveDate,SPE_EffectiveEndDate= :SPE_EffectiveEndDate,"
						+ "SPE_PrimaryBankName= :SPE_PrimaryBankName,SPE_CreatedDate=:SPE_CreatedDate,SPE_PrimaryBankAcountNo= :SPE_PrimaryBankAcountNo,SPE_PrimaryBankBranchName= :SPE_PrimaryBankBranchName,"
						+ "SPE_PrimaryBankAccountType=:SPE_PrimaryBankAccountType,SPE_PrimaryIFSCCode=:SPE_PrimaryIFSCCode,SPE_PrimaryBankLinkedAadhaarNo=:SPE_PrimaryBankLinkedAadhaarNo,"
						+ "SPE_PrimaryBankVPA=:SPE_PrimaryBankVPA,SPE_SecondaryBankName=:SPE_SecondaryBankName,SPE_SecondaryBankAcountNo=:SPE_SecondaryBankAcountNo,"
						+ "SPE_SecondaryBankBranchName=:SPE_SecondaryBankBranchName,SPE_SecondaryBankAccountType=:SPE_SecondaryBankAccountType,"
						+ "SPE_SecondaryIFSCCode=:SPE_SecondaryIFSCCode,SPE_SecondaryBankLinkedAadhaarNo=:SPE_SecondaryBankLinkedAadhaarNo,"
						+ "SPE_SecondaryBankVPA=:SPE_SecondaryBankVPA,SPE_PANCardNo=:SPE_PANCardNo,SPE_AadhaarNo=:SPE_AadhaarNo,"
						+ "SPE_GSTIN_Number=:SPE_GSTIN_Number,SPE_GSTIN_Flag=:SPE_GSTIN_Flag,SPE_MerchantID=:SPE_MerchantID,"
						+ "SPE_MerchantKey=:SPE_MerchantKey,SPE_MerchantTable=:SPE_MerchantTable,SPE_ServiceFlag1=:SPE_ServiceFlag1,"
						+ "SPE_ServiceFlag2=:SPE_ServiceFlag2,SPE_ServiceFlag3=:SPE_ServiceFlag3,SPE_ServiceFlag4=:SPE_ServiceFlag4,"
						+ "SPE_ServiceFlag5=:SPE_ServiceFlag5,SPE_ServiceFlag6=:SPE_ServiceFlag6,SPE_ServiceFlag7=:SPE_ServiceFlag7,"
						+ "SPE_ServiceFlag8=:SPE_ServiceFlag8,SPE_ServiceFlag9=:SPE_ServiceFlag9,SPE_ServiceFlag10=:SPE_ServiceFlag10 where SPE_UserName= :SPE_UserName";

				@SuppressWarnings("unchecked")
				Query<SPE_MerchantModel> query = session.createQuery(hql);
				query.setParameter("SPE_email", modellist.getSPE_email());
				query.setParameter("SPE_UserName", modellist.getSPE_UserName());
				query.setParameter("SPE_Password", modellist.getSPE_Password());
				query.setParameter("SPE_Salt", modellist.getSPE_Salt());
				query.setParameter("SPE_UserName", modellist.getSPE_UserName());
				query.setParameter("SPE_Address1", modellist.getSPE_Address1());
				query.setParameter("SPE_Address2", modellist.getSPE_Address2());
				query.setParameter("SPE_Address3", modellist.getSPE_Address3());
				query.setParameter("SPE_City", modellist.getSPE_City());
				query.setParameter("SPE_State", modellist.getSPE_State());
				query.setParameter("SPE_UpdatedDate", modellist.getSPE_UpdatedDate());
				query.setParameter("SPE_UpdatedBy", modellist.getSPE_UpdatedBy());
				query.setParameter("SPE_Pincode", modellist.getSPE_Pincode());
				query.setParameter("SPE_Phone", modellist.getSPE_Phone());
				query.setParameter("SPE_ActiveStatus", modellist.getSPE_ActiveStatus());
				query.setParameter("SPE_EffectiveDate", modellist.getSPE_EffectiveDate());
				query.setParameter("SPE_EffectiveEndDate", modellist.getSPE_EffectiveEndDate());
				query.setParameter("SPE_PrimaryBankName", modellist.getSPE_PrimaryBankName());
				query.setParameter("SPE_CreatedDate", modellist.getSPE_CreatedDate());
				query.setParameter("SPE_PrimaryBankAcountNo", modellist.getSPE_PrimaryBankAcountNo());
				query.setParameter("SPE_PrimaryBankBranchName", modellist.getSPE_PrimaryBankBranchName());
				query.setParameter("SPE_PrimaryBankAccountType", modellist.getSPE_PrimaryBankAccountType());
				query.setParameter("SPE_PrimaryIFSCCode", modellist.getSPE_PrimaryIFSCCode());
				query.setParameter("SPE_PrimaryBankLinkedAadhaarNo", modellist.getSPE_PrimaryBankLinkedAadhaarNo());
				query.setParameter("SPE_PrimaryBankVPA", modellist.getSPE_PrimaryBankVPA());
				query.setParameter("SPE_SecondaryBankName", modellist.getSPE_SecondaryBankName());
				query.setParameter("SPE_SecondaryBankAcountNo", modellist.getSPE_SecondaryBankAcountNo());
				query.setParameter("SPE_SecondaryBankBranchName", modellist.getSPE_SecondaryBankBranchName());
				query.setParameter("SPE_SecondaryBankAccountType", modellist.getSPE_SecondaryBankAccountType());
				query.setParameter("SPE_SecondaryIFSCCode", modellist.getSPE_SecondaryIFSCCode());
				query.setParameter("SPE_SecondaryBankLinkedAadhaarNo", modellist.getSPE_SecondaryBankLinkedAadhaarNo());
				query.setParameter("SPE_SecondaryBankVPA", modellist.getSPE_SecondaryBankVPA());
				query.setParameter("SPE_PANCardNo", modellist.getSPE_PANCardNo());
				query.setParameter("SPE_AadhaarNo", modellist.getSPE_AadhaarNo());
				query.setParameter("SPE_GSTIN_Number", modellist.getSPE_GSTIN_Number());
				query.setParameter("SPE_GSTIN_Flag", modellist.getSPE_GSTIN_Flag());
				query.setParameter("SPE_MerchantID", modellist.getSPE_MerchantID());
				query.setParameter("SPE_MerchantKey", modellist.getSPE_MerchantKey());
				query.setParameter("SPE_MerchantTable", modellist.getSPE_MerchantTable());
				query.setParameter("SPE_ServiceFlag1", modellist.getSPE_ServiceFlag1());
				query.setParameter("SPE_ServiceFlag2", modellist.getSPE_ServiceFlag2());
				query.setParameter("SPE_ServiceFlag3", modellist.getSPE_ServiceFlag3());
				query.setParameter("SPE_ServiceFlag4", modellist.getSPE_ServiceFlag4());
				query.setParameter("SPE_ServiceFlag5", modellist.getSPE_ServiceFlag5());
				query.setParameter("SPE_ServiceFlag6", modellist.getSPE_ServiceFlag6());
				query.setParameter("SPE_ServiceFlag7", modellist.getSPE_ServiceFlag7());
				query.setParameter("SPE_ServiceFlag8", modellist.getSPE_ServiceFlag8());
				query.setParameter("SPE_ServiceFlag9", modellist.getSPE_ServiceFlag9());
				query.setParameter("SPE_ServiceFlag10", modellist.getSPE_ServiceFlag10());
				// System.out.println(modellist.getSPE_UpdatedDate());
				// System.out.println("created
				// date"+modellist.getSPE_CreatedDate());
				int result = query.executeUpdate();
				if (result == 1) {
					System.out.println("updated successfully");
				}

				transaction.commit();
				/*
				 * 
				 * session.update(modellist); System.out.println(modellist);
				 * transaction.commit();
				 */
				payezee_errormsg.setErrorCode(PHMC_DB_ERROR.PHMC_SUCCESS);
				payezee_errormsg
						.setErrorMessage("Merchant with ID " + modellist.getSPE_UserName() + " Updated Successfully");
			} catch (HibernateException e) {
				if (transaction != null) {
					transaction.rollback();
				}
				payezee_errormsg.setErrorCode(PHMC_DB_ERROR.PHMC_UPDATE_FAILED);
				payezee_errormsg
						.setErrorMessage("Merchant with ID " + modellist.getSPE_UserName() + " Updation Failed");
				e.printStackTrace();
			} finally {
				session.close();
			}

		}

		return payezee_errormsg;
	}

	/**
	 * Read total Number of records Based On Criteria like Username and
	 * MerchantID
	 * 
	 * @param SPE_UserName,SPE_MerchantID
	 * @return
	 */

	// This method will reads the data from SPE_Merchant_Detail table based on
	// client query params.
	public List<SPE_MerchantModel> spe_readmerchant(String SPE_UserName, String SPE_MerchantTable) {
		List<SPE_MerchantModel> data1 = new ArrayList<SPE_MerchantModel>();
		Session session = null;
		log.info("method");
		String whereCluase = "";
		/*
		 * if(!whereCluase.trim().isEmpty()){ whereCluase=" WHERE "+whereCluase;
		 * }else{ whereCluase=""; }
		 */
		if (SPE_UserName != null) {
			whereCluase += " SPE_UserName LIKE '%" + SPE_UserName + "%'";
		}
		if (!whereCluase.equals("")) {
			if (SPE_MerchantTable != null) {
				whereCluase += " AND SPE_MerchantTable LIKE '%" + SPE_MerchantTable + "%'";
			}
		} else {
			if (SPE_MerchantTable != null) {
				whereCluase += " SPE_MerchantTable LIKE '%" + SPE_MerchantTable + "%'";
			}
		}
		if (!whereCluase.trim().isEmpty()) {
			whereCluase = " WHERE " + whereCluase;
		} else {
			whereCluase = "";
		}

		Transaction tx = null;
		try {
			session = PayhindHibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			data1 = session.createQuery("FROM SPE_MerchantModel" + whereCluase).list();
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
	
	/**
	 * Read total Number of records Based On Criteria like Username and
	 * MerchantID
	 * 
	 * @param SPE_UserName,SPE_MerchantID
	 * @return
	 */

	// This method will reads the data from SPE_Merchant_Detail table based on
	// client query params.
	public List<SPE_MerchantModel> spe_readAllMerchant() {
		List<SPE_MerchantModel> MerchantList = new ArrayList<SPE_MerchantModel>();
		Session session = null;
		log.info("method");
		
		Transaction tx = null;
		try {
			session = PayhindHibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			MerchantList = session.createQuery("FROM SPE_MerchantModel").list();
			log.info(MerchantList);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return MerchantList;

	}
	
	private SecureRandom random = new SecureRandom();

    public String nextSessionId() {
        return new BigInteger(160, random).toString(32);
    }

	/*public static void main(String args[]) {
		SPE_MerchantDao spe_mercahntdao = new SPE_MerchantDao();
		
		for(int i=0; i<20; i++){
		String id=spe_mercahntdao.nextSessionId();

		System.out.println(id);
		System.out.println(id.length());
		System.out.println("==================================================");
		}
	}*/

}
