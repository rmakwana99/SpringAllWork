
package com.rahul.phmc.spe.sdp.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.rahul.phmc.sdp.commssion.dist.dao.SPE_CommssionDistDAO;
import com.rahul.phmc.sdp.commssion.dist.model.SPE_CommissionDist;
import com.rahul.phmc.spe.router.dao.SPE_XMonDao;
import com.rahul.phmc.spe.router.model.SPE_TRXNDetailsModel;
import com.rahul.phmc.spe.sdp.dao.SPE_SDP_UploadSettlementDAO;
import com.rahul.phmc.spe.sdp.model.SPE_SDP_BankDailySettlementModel;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.PHMC_DB_ERROR;

/**
 * @author rahul makvana this class is Service of validate Settlement data with
 *         SPE_TXN_Details_ClientID and update Settlement status and date and
 *         also validation status and validation error
 *
 */
public class SPE_SDP_SettlementValidation {

	// this is creation of logger so we can check what log created.
	static final Logger log = Logger.getLogger(SPE_SDP_SettlementValidation.class);

	SPE_SDP_UploadSettlementDAO sdpDAO = new SPE_SDP_UploadSettlementDAO();
	SPE_XMonDao spdxMonDAO = new SPE_XMonDao();
	ErrorMessage spe_errorMsg = new ErrorMessage();

	public List<SPE_SDP_BankDailySettlementModel> spe_sdv_settlementValidation(
			List<SPE_SDP_BankDailySettlementModel> sdp_settlementList) {
		List<SPE_SDP_BankDailySettlementModel> sdp_updatedList = new ArrayList<SPE_SDP_BankDailySettlementModel>();
		ErrorMessage spe_updateerror = new ErrorMessage();
		String transactionID = null;

		SPE_CommssionDistDAO commDistDao = new SPE_CommssionDistDAO();
		List<SPE_CommissionDist> commDistList = commDistDao.getCommissionDistribution();

		for (SPE_SDP_BankDailySettlementModel sdp_settlement : sdp_settlementList) {
			transactionID = sdp_settlement.getSPE_OrderNo();
			log.info(transactionID);
			if (transactionID != null && sdp_settlement.getExcelCheck()) {
				// if (sdp_settlement.getExcelCheck()) {

				SPE_TRXNDetailsModel spe_TxnModel = spdxMonDAO.spe_readSPETRXNDetails(transactionID);

				if (spe_TxnModel != null) {

					if (Float.compare(sdp_settlement.getSPE_TransactionAmount(),
							spe_TxnModel.getSPE_PaymentAmount()) != 0) {
						spe_TxnModel.setSPE_ValidationStatus(01);
						sdp_settlement.setSPE_SPE_Validationstatus("N");
						sdp_settlement.setSPE_ValidationError("Amount Disputed");
						sdp_settlement.setUpdateCheck(false);
						sdp_settlement.setUpdateError("Transaction Amount not matched");

					} else if (!new SimpleDateFormat("yyyy-MM-dd").format(sdp_settlement.getSPE_TransReqDate())
							.equals(new SimpleDateFormat("yyyy-MM-dd").format(spe_TxnModel.getSPE_TxnDate()))) {
						spe_TxnModel.setSPE_ValidationStatus(03);
						sdp_settlement.setSPE_SPE_Validationstatus("N");
						sdp_settlement.setSPE_ValidationError("Transaction Date Disputed");
						sdp_settlement.setUpdateCheck(false);
						sdp_settlement.setUpdateError("Transaction Date not matched");
					} else if (sdp_settlement.getSPE_SettlementDate() != null
							&& sdp_settlement.getSPE_SettlementDate().before(spe_TxnModel.getSPE_TxnDate())) {
						// if () {
						spe_TxnModel.setSPE_ValidationStatus(04);
						sdp_settlement.setSPE_SPE_Validationstatus("N");
						sdp_settlement.setSPE_ValidationError("Settlement Date is less then transaction date");
						sdp_settlement.setUpdateCheck(false);
						sdp_settlement.setUpdateError("Settlement Date is less then transaction date");
						// }
					} else {
						log.info("success");
						spe_TxnModel.setSPE_ValidationStatus(00);
						sdp_settlement.setSPE_SPE_Validationstatus("Y");
						sdp_settlement.setSPE_ValidationError("Validation Success");
						sdp_settlement.setUpdateCheck(true);
						sdp_settlement.setUpdateError("Validation Success");
					}

					spe_TxnModel.setSPE_SettlementDate(sdp_settlement.getSPE_SettlementDate());
					spe_TxnModel.setSPE_SettlementStatus(sdp_settlement.getSPE_SettlementStatus());
					spe_TxnModel.setSPE_SettlementAmount(sdp_settlement.getSPE_SettlementAmount());
					spe_TxnModel.setSPE_ProcessingStatus(01);

					log.info("updated txnModel" + spe_TxnModel);
					// calculate commission for only those transactions which
					// have been validated successfully
					if (00 == spe_TxnModel.getSPE_ValidationStatus()
							&& "Y".equals(spe_TxnModel.getSPE_SettlementStatus())) {
						commDistDao.calculateCommission(commDistList, spe_TxnModel);
						log.info("Updated commission in txnModel :" + spe_TxnModel);
					}
					if (sdp_settlement.getUpdateCheck()) {
						spe_updateerror = spdxMonDAO.spe_UpdateTrxDetails(spe_TxnModel);

						if (spe_updateerror.getErrorCode() == PHMC_DB_ERROR.PHMC_SUCCESS) {
							sdp_settlement.setUpdateCheck(true);
							sdp_settlement.setUpdateError("Settlement Updated");
						} else {
							sdp_settlement.setUpdateCheck(false);
							sdp_settlement.setUpdateError("Updation Failed");
						}
					}
				} else {
					sdp_settlement.setUpdateCheck(false);
					sdp_settlement.setUpdateError("Data Not exist in Transaction Details");
					sdp_settlement.setSPE_SPE_Validationstatus("N");
					sdp_settlement.setSPE_ValidationError("Transaction Id Disputed");
				}
				int isdata = sdpDAO.spe_readDailySettlement(transactionID);
				log.info("is Data=" + isdata);
				if (isdata == 0) {
					sdp_updatedList.add(sdp_settlement);
				} else {
					sdp_settlement.setInsertCheck(false);
					sdp_settlement.setInsertError("Data already exist");

				}
				// }
			}
		}
		log.info("size=" + sdp_updatedList.size());
		if (sdp_updatedList.size() > 0) {
			log.info("updated list=" + sdp_updatedList);

			// insert all valid data in SPE_DAILY_SETTLEMENT_DEPOT table using
			// Batch insert
			sdp_updatedList = sdpDAO.spe_spd_uploadBankSettlement(sdp_updatedList);
		}
		log.info(sdp_settlementList);

		return sdp_settlementList;
	}

}
