/*
	* Copyright (C) 2017 Srishti ESDM Pvt Ltd.
	*
	* This file is property of Srishti ESDM Pvt Ltd and must not be copied, reused or distributed
	* without prior approval and agreement with Srishti ESDM Pvt Ltd.
	*
	* This file is allowed only for Srishti internal use and is a confidential property.
	*/
package spe.router.txnDetails;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.FixMethodOrder;
import org.junit.runners.*;
import org.junit.Test;

import com.rahul.phmc.spe.router.dao.SPE_XMonDao;
import com.rahul.phmc.spe.router.model.SPE_TRXNDetailsModel;
import com.rahul.phmc.spe.router.model.SPE_TRXNDetailsSRSHModel;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.persistance.PayhindHibernateUtil;

import junit.framework.Assert;

/**
 * @author SrishtiESDM-rahul
 * this is junit test case of DAO(create,update and read) of TrxDeatailsModel of Router Module
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SPE_TxnDetailsDAO {

	ErrorMessage spe_error= new ErrorMessage();
	SPE_XMonDao dao = new SPE_XMonDao();
	
	@Test
	public void updateTxnDetailsTest() {
		SPE_TRXNDetailsModel trxnDetails=dao.spe_readSPETRXNDetails("USRSH01VS01--1111111110A000001");
		trxnDetails.setSPE_SettlementStatus("Y");
		trxnDetails.setSPE_ErrorCode(3F);
		
		spe_error = dao.spe_UpdateTrxDetails(trxnDetails);
		
		assertEquals(200, spe_error.getErrorCode());
		
		Session session=PayhindHibernateUtil.getSessionFactory().openSession();
		Transaction tx= null;
		try{
		
		tx=session.beginTransaction();
		Query query = session.createQuery("delete SPE_TRXNDetailsSRSHModel where SPE_TransactionID = :transactionID");
		query.setParameter("transactionID", "USRSH01VS01--1111111110A000001");
		
		int result =query.executeUpdate();
		tx.commit();
		assertEquals(1, result);
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}
	
	
	
	@Test
	public void readTxnDetailsTest() {
		SPE_TRXNDetailsModel trxnDetails=dao.spe_readSPETRXNDetails("USRSH01VS01--1111111110A000001");
		
		assertEquals("N", trxnDetails.getSPE_SettlementStatus());
		assertEquals("PRVDID01725373", trxnDetails.getSPE_Provider_TransactionID());
	}
	
	
	@Test
	public void createTxnDetailsTest() {
		SPE_TRXNDetailsSRSHModel trxnDetailsList = new SPE_TRXNDetailsSRSHModel();
		trxnDetailsList.setSPE_AutoSrNo("gdjadj-66146-wdwd");
		trxnDetailsList.setSPE_TransactionID("USRSH01VS01--1111111110A000001");
		trxnDetailsList.setSPE_Provider_TransactionID("PRVDID01725373");
		trxnDetailsList.setSPE_SettlementStatus("N");
		trxnDetailsList.setSPE_SettlementDate(new Date());
		trxnDetailsList.setSPE_ErrorCode(3F);
		
		spe_error = dao.spe_CreateTrxDetails(trxnDetailsList);
		
		assertEquals(200, spe_error.getErrorCode());
		
	}
	

}
