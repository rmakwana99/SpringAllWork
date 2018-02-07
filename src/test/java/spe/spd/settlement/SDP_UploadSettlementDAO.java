/*
	* Copyright (C) 2017 Srishti ESDM Pvt Ltd.
	*
	* This file is property of Srishti ESDM Pvt Ltd and must not be copied, reused or distributed
	* without prior approval and agreement with Srishti ESDM Pvt Ltd.
	*
	* This file is allowed only for Srishti internal use and is a confidential property.
	*/
package spe.spd.settlement;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import com.rahul.phmc.spe.sdp.dao.SPE_SDP_UploadSettlementDAO;
import com.rahul.phmc.spe.sdp.model.SPE_SDP_BankDailySettlementModel;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.persistance.PayhindHibernateUtil;

/**
 * @author SrishtiESDM-rahul
 * this is junit test case of DAO(create,update and read) of Bank Daily Settlement Model of SDP Module
 *
 */
public class SDP_UploadSettlementDAO {

	ErrorMessage spe_error= new ErrorMessage();
	SPE_SDP_UploadSettlementDAO sdpDAO=new SPE_SDP_UploadSettlementDAO();


	@Test
	public void testPhmc_spd_uploadBankSettlement() {
		SPE_SDP_BankDailySettlementModel sdpModel= new SPE_SDP_BankDailySettlementModel();
		sdpModel.setSPE_OrderNo("USRSH01VS01--1111111111A000001");
		sdpModel.setSPE_PaymentRefNo("Eva1228389192");
		sdpModel.setSPE_TransRefNo(14752866L);
		List<SPE_SDP_BankDailySettlementModel> sdpLIST=new ArrayList<>();
		sdpLIST.add(sdpModel);
		List<SPE_SDP_BankDailySettlementModel> resultLIST=new ArrayList<SPE_SDP_BankDailySettlementModel>();
		
		resultLIST=sdpDAO.spe_spd_uploadBankSettlement(sdpLIST);
		System.out.println(resultLIST);
		assertEquals("USRSH01VS01--1111111111A000001", resultLIST.get(0).getSPE_OrderNo());
		
		Session session=PayhindHibernateUtil.getSessionFactory().openSession();
		Transaction tx= null;
		try{
		
		tx=session.beginTransaction();
		Query query = session.createQuery("delete SPE_SDP_BankDailySettlementModel where SPE_OrderNo = :orderID");
		query.setParameter("orderID", "USRSH01VS01--1111111111A000001");
		
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

}
