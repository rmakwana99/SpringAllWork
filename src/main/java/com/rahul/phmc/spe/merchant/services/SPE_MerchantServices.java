package com.rahul.phmc.spe.merchant.services;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rahul.phmc.spe.merchant.dao.SPE_MerchantDao;
import com.rahul.phmc.spe.merchant.model.SPE_MerchantModel;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.PHMC_DB_ERROR;
import com.rahul.phmc.util.persistance.PayhindHibernateUtil;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.query.Query;
/**
 * @author rahul Makvana this class is Service of reading and creating, updating merchant data 
 
 */
public class SPE_MerchantServices {
	// this is creation of logger so we can check what log created.
		static final Logger log = Logger.getLogger(SPE_MerchantServices.class);

	private SPE_MerchantDao spe_merchantdao = new SPE_MerchantDao();
	private SPE_MerchantModel spe_mercahantmodel =new SPE_MerchantModel();
	List<SPE_MerchantModel> spe_mercahantmodellist =new ArrayList<SPE_MerchantModel>();
	Session session=null;
	
public ErrorMessage payezee_createupdatemerchant(String SPE_UserName,SPE_MerchantModel spe_mercahantmodel) {

		ErrorMessage payezee_errormsg = new ErrorMessage();
		Transaction transaction = null;
		
		try {
			session = PayhindHibernateUtil.getSessionFactory().openSession();
			System.out.println("enter in connection");
			transaction = session.beginTransaction();

			
			Query<SPE_MerchantModel> query = session.createQuery("From SPE_MerchantModel where SPE_UserName=?");
			query.setParameter(0,SPE_UserName);
			spe_mercahantmodellist = query.getResultList();
			System.out.println(spe_mercahantmodellist);
			transaction.commit();

			if (spe_mercahantmodellist.size() == 0) {
				payezee_errormsg = spe_merchantdao.spe_createmerchant(spe_mercahantmodel);
			}
			else if(spe_mercahantmodellist.size() == 1){
			payezee_errormsg = spe_merchantdao.spe_updatemerchant(SPE_UserName,spe_mercahantmodel);
			}
			else if(spe_mercahantmodellist.size()>=2){
				payezee_errormsg.setErrorCode(PHMC_DB_ERROR.PHMC_DUPLICATE_RECORD_FOUND);
				payezee_errormsg.setErrorMessage("Merchant with ID " + spe_mercahantmodel.getSPE_UserName() + " Duplicate Record Found");
			}
		}
		    catch (HibernateException e1) {
			payezee_errormsg.setErrorCode(PHMC_DB_ERROR.PHMC_INSERT_FAILED);
			payezee_errormsg.setErrorMessage("Merchant with ID " + spe_mercahantmodel.getSPE_UserName() + "Creation Failed");
			e1.printStackTrace();
		} finally {
			session.close();
		}
		return payezee_errormsg;
	}
	

	
	 public List<SPE_MerchantModel> spe_readmerchantdata(String SPE_UserName,String SPE_MerchantTable){
		/*
		 String whereCluase="";
			if(SPE_UserName!=null){
				whereCluase += " SPE_UserName LIKE '%" + SPE_UserName + "%'";
			}
			if (!whereCluase.equals("")) {
				if (SPE_MerchantID != null) {
					whereCluase += " AND SPE_MerchantID LIKE '%" + SPE_MerchantID + "%'";
				}
			}
			else {
				if (SPE_MerchantID != null) {
					whereCluase += " SPE_MerchantID LIKE '%" + SPE_MerchantID + "%'";
				}
			}
			
			
			log.info("Wherecluase ="+whereCluase);
			spe_mercahantmodellist=spe_merchantdao.spe_readmerchant(whereCluase);
			*/
		 spe_mercahantmodellist=spe_merchantdao.spe_readmerchant(SPE_UserName,SPE_MerchantTable);
			log.info("see the data from service :"+spe_mercahantmodellist);
		return spe_mercahantmodellist;
		 
	 }
	
	
	
}
