
package com.rahul.phmc.spe.router.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rahul.phmc.spe.router.dao.*;
import com.rahul.phmc.spe.router.model.SPE_TRXNDetailsISROModel;
import com.rahul.phmc.spe.router.model.SPE_TRXNDetailsModel;
import com.rahul.phmc.spe.router.model.SPE_TRXNDetailsPYHDModel;
import com.rahul.phmc.spe.router.model.SPE_TRXNDetailsSPAYModel;
import com.rahul.phmc.spe.router.model.SPE_TRXNDetailsSRSHModel;
import com.rahul.phmc.util.ErrorMessage;
/**
 * @author rahul Makvana
 *
 */

public class SPE_XMonService {
	// this is creation of logger so we can check what log created.
	static final Logger log = Logger.getLogger(SPE_XMonService.class);
	private SPE_XMonDao spe_xmondao = new SPE_XMonDao();
	List<SPE_TRXNDetailsModel> spe_xmon_model = new ArrayList<SPE_TRXNDetailsModel>();
	
   /*This method will read all the inputs from resource file and taking the result into whereclause , 
	later passing these to dao class
	*/
	public List<SPE_TRXNDetailsModel> spe_getalltransaction(String SPE_TransactionID, String Txnstartdate, String Txnenddate,
			String SPE_SettlementStatus, String SPE_MID) {
		String whereCluase = "";
		if (SPE_TransactionID != null) {
			whereCluase += " SPE_TransactionID LIKE '%" + SPE_TransactionID + "%'";
		}
		/*if (!whereCluase.equals("")) {
			if (SPE_MID != null) {
				whereCluase += " AND SPE_MID LIKE '%" + SPE_MID + "%'";
			}
		} else {
			if (SPE_MID != null) {
				whereCluase += " SPE_MID LIKE '%" + SPE_MID + "%'";
			}
		}*/

		if (!whereCluase.equals("")) {
			if (Txnstartdate != null) {
				if (Txnenddate != null) {
					whereCluase += " AND SPE_TxnDate BETWEEN '" + Txnstartdate + "' AND '" + Txnenddate + "' ";
				} else {
					whereCluase += " AND SPE_TxnDate = '" + Txnstartdate + "'";
				}
			}
		} else {
			if (Txnstartdate != null) {
				if (Txnenddate != null) {
					whereCluase += " SPE_TxnDate BETWEEN '" + Txnstartdate + "' AND '" + Txnenddate + "' ";
				} else {
					whereCluase += " SPE_TxnDate = '" + Txnstartdate + "'";
				}
			}
		}

		if (!whereCluase.equals("")) {
			if (SPE_SettlementStatus != null) {
				whereCluase += " AND SPE_SettlementStatus='" + SPE_SettlementStatus + "'";
			}
		} else {
			if (SPE_SettlementStatus != null) {
				whereCluase += "SPE_SettlementStatus='" + SPE_SettlementStatus + "'";
			}
		}

		log.info("Wherecluase =" + whereCluase);

		spe_xmon_model = spe_xmondao.spe_getalltransactionthruid(whereCluase,SPE_MID);
		log.info("see the data from service :" + spe_xmon_model);

		return spe_xmon_model;

	}
	
	
	public ErrorMessage spe_createTxnDetails(String spe_TxnDetails){
		ErrorMessage msg= new ErrorMessage();
		
		SPE_TRXNDetailsModel model=SPE_XMonService.getTxnModel(spe_TxnDetails);
		
		msg=spe_xmondao.spe_CreateTrxDetails(model);
		return msg;
	}
	
	public ErrorMessage spe_updateTxnDetails(String spe_TxnDetails){
		ErrorMessage msg= new ErrorMessage();
		SPE_TRXNDetailsModel model=SPE_XMonService.getTxnModel(spe_TxnDetails);
		System.out.println(model);
		msg=spe_xmondao.spe_UpdateTrxDetails(model);
		
		return msg;
	}
	
	public static SPE_TRXNDetailsModel getTxnModel(String spe_TxnDetails){
		SPE_TRXNDetailsModel model=null;
		
		ObjectMapper mapper= new ObjectMapper();
		try {
			model=mapper.readValue(spe_TxnDetails, SPE_TRXNDetailsModel.class);
			log.info(model);
			log.info(model.getSPE_TransactionID());
			String ClientId=model.getSPE_TransactionID().substring(1, 5);
			
			if(ClientId.equals("SRSH")){
				model=mapper.readValue(spe_TxnDetails, SPE_TRXNDetailsSRSHModel.class);
			}else if(ClientId.equals("ISRO")){
				model=mapper.readValue(spe_TxnDetails, SPE_TRXNDetailsISROModel.class);
			}else if(ClientId.equals("PYHD")){
				model=mapper.readValue(spe_TxnDetails, SPE_TRXNDetailsPYHDModel.class);
			}else if(ClientId.equals("SPAY")){
				model=mapper.readValue(spe_TxnDetails, SPE_TRXNDetailsSPAYModel.class);
			}else{
				model=mapper.readValue(spe_TxnDetails, SPE_TRXNDetailsModel.class);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return model;
	}

}
