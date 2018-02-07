
package com.rahul.phmc.spe.sdp.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import com.rahul.phmc.spe.sdp.dao.SPE_AMAZON_TRXN_DETAILSDAO;
import com.rahul.phmc.spe.sdp.dao.SPE_DAILY_AMAZON_EARNING_DEPOTModelDAO;
import com.rahul.phmc.spe.sdp.dao.SPE_SDP_UploadSettlementDAO;
import com.rahul.phmc.spe.sdp.model.SPE_AMAZON_TRXN_DETAILSModel;
import com.rahul.phmc.spe.sdp.model.SPE_DAILY_AMAZON_EARNING_DEPOTModel;
import com.rahul.phmc.spe.sdp.model.SPE_SDP_BankDailySettlementModel;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.PHMC_DB_ERROR;

/**
 * @author rahul makvana this class is Service of Upload Settlement data and
 *         identify the provider and payment mode then create List of
 *         SPE_SDP_BankDailySettlementModel
 */
public class SPE_SDP_UploadSettlementService {

	private SPE_SDP_UploadSettlementDAO sdpDAO;
	private SPE_SDP_GetListOfSettlement sdpGetList;
	private ArrayList<SPE_SDP_BankDailySettlementModel> SDP_settlement;
	private SPE_SDP_SettlementValidation sdp_validator;
	private SPE_SDP_AmazonService spe_amazonService;
	private List<SPE_DAILY_AMAZON_EARNING_DEPOTModel> spe_amazonEarningList;
	private List<SPE_AMAZON_TRXN_DETAILSModel> spe_amazonOrderList;
	private SPE_DAILY_AMAZON_EARNING_DEPOTModelDAO spe_amazonEarningdao;
	ErrorMessage phmc_errorMsg;

	public SPE_SDP_UploadSettlementService() {
		sdpDAO = new SPE_SDP_UploadSettlementDAO();
		SDP_settlement = new ArrayList<SPE_SDP_BankDailySettlementModel>();
		sdpGetList = new SPE_SDP_GetListOfSettlement();
		sdp_validator = new SPE_SDP_SettlementValidation();
		spe_amazonService = new SPE_SDP_AmazonService();

	}

	// this is creation of logger so we can check what log created.
	static final Logger log = Logger.getLogger(SPE_SDP_UploadSettlementService.class);

	public Response spe_sdp_uploadSettlement(InputStream inputStream, FormDataContentDisposition fileDetail,
			String SPE_ProviderName, int SPE_PaymentMode) {

		phmc_errorMsg = new ErrorMessage();
		Response response = null;
		Workbook workbook;
		try {
			workbook = this.getWorkbook(inputStream, fileDetail.getFileName());
			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = firstSheet.iterator();
			// ProviderName= Amazon, Mode : 1 = Earning Report
			// ProviderName= Amazon, Mode : 2 = Order Report
			if (SPE_ProviderName.equalsIgnoreCase("Amazon") && SPE_PaymentMode == 2) {

				spe_amazonOrderList = spe_amazonService.convertAmazonOrderReportToList(iterator, firstSheet);
				log.info("spe_amazonOrderList " + spe_amazonOrderList);
				List<SPE_AMAZON_TRXN_DETAILSModel> spe_orderInsertList = new ArrayList<SPE_AMAZON_TRXN_DETAILSModel>();
				SPE_AMAZON_TRXN_DETAILSDAO orderDAO = new SPE_AMAZON_TRXN_DETAILSDAO();
				if (spe_amazonOrderList != null) {
					for (SPE_AMAZON_TRXN_DETAILSModel orderDetails : spe_amazonOrderList) {
						String TransactionId = orderDetails.getSpe_transactionID();
						if (orderDetails.getSpe_excelcheck()) {
							int isOrder = orderDAO.spe_readAmazonTxnDetails(TransactionId);
							if (isOrder == 0) {
								spe_orderInsertList.add(orderDetails);
							} else {
								orderDetails.setSpe_insertCheck(false);
								orderDetails.setSpe_insertError("Data already exist");
							}
						}
					}
					if (spe_orderInsertList.size() != 0) {
						phmc_errorMsg = orderDAO.spe_sdp_uploadAmazonOrder(spe_orderInsertList);

						if (phmc_errorMsg.getErrorCode() == PHMC_DB_ERROR.PHMC_SUCCESS) {
							for (SPE_AMAZON_TRXN_DETAILSModel earningModel : spe_orderInsertList) {
								earningModel.setSpe_insertCheck(true);
								earningModel.setSpe_insertError("Insertted Successfully");
							}
						} else {
							for (SPE_AMAZON_TRXN_DETAILSModel earningModel : spe_orderInsertList) {
								earningModel.setSpe_insertCheck(false);
								earningModel.setSpe_insertError("Batch Insertion Failed");
							}
						}
					}

					response = Response.status(200)
							.entity(new GenericEntity<List<SPE_AMAZON_TRXN_DETAILSModel>>(spe_amazonOrderList) {
							}).build();

				} else {
					phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_NO_RECORD_IN_EXCEL);
					phmc_errorMsg.setErrorMessage("No Record Found in Excel File");
					log.error("File Upload Failed");
					response = Response.status(phmc_errorMsg.getErrorCode()).entity(phmc_errorMsg).build();
				}
				// ProviderName= Amazon, Mode : 1 = Earning Report
			} else if (SPE_ProviderName.equalsIgnoreCase("Amazon") && SPE_PaymentMode == 1) {

				spe_amazonEarningList = spe_amazonService.convertAmazonEarningReportToList(iterator, firstSheet);
				log.info("spe_amazonEarningList " + spe_amazonEarningList);
				spe_amazonEarningdao = new SPE_DAILY_AMAZON_EARNING_DEPOTModelDAO();
				if (spe_amazonEarningList != null) {
					
					phmc_errorMsg = spe_amazonEarningdao.spe_sdp_uploadAmazonEaring(spe_amazonEarningList);
					if (phmc_errorMsg.getErrorCode() == PHMC_DB_ERROR.PHMC_SUCCESS) {
						for (SPE_DAILY_AMAZON_EARNING_DEPOTModel earningModel : spe_amazonEarningList) {
							if(earningModel.getSpe_excelcheck()){
							earningModel.setSpe_insertCheck(true);
							earningModel.setSpe_insertError("Inserted Successfully");
							}
						}
					} else {
						for (SPE_DAILY_AMAZON_EARNING_DEPOTModel earningModel : spe_amazonEarningList) {
							earningModel.setSpe_insertCheck(false);
							earningModel.setSpe_insertError("Batch Insertion Failed");
						}
					}
					response = Response.status(200).entity(
							new GenericEntity<List<SPE_DAILY_AMAZON_EARNING_DEPOTModel>>(spe_amazonEarningList) {
							}).build();
				} else {
					phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_NO_RECORD_IN_EXCEL);
					phmc_errorMsg.setErrorMessage("No Record Found in Excel File");
					log.error("File Upload Failed");
					response = Response.status(phmc_errorMsg.getErrorCode()).entity(phmc_errorMsg).build();
				}

			} else if (SPE_ProviderName.equalsIgnoreCase("YesBank") && SPE_PaymentMode == 1) {
				List<SPE_SDP_BankDailySettlementModel> sdpList = new ArrayList<SPE_SDP_BankDailySettlementModel>();
				SDP_settlement = (ArrayList<SPE_SDP_BankDailySettlementModel>) sdpGetList
						.getListSettlementUPIYesBank(iterator, firstSheet);
				log.info(SDP_settlement);
				if(SDP_settlement != null && SDP_settlement.size()>0){
				sdpList = sdp_validator.spe_sdv_settlementValidation(SDP_settlement);
				response = Response.status(200)
						.entity(new GenericEntity<List<SPE_SDP_BankDailySettlementModel>>(sdpList) {}).build();
				}else{
					phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_NO_RECORD_IN_EXCEL);
					phmc_errorMsg.setErrorMessage("No Valid Record Found in Excel File");
					log.error("No Valid Record Found in Excel File");
					response = Response.status(phmc_errorMsg.getErrorCode()).entity(phmc_errorMsg).build();
				}

			} else if (SPE_ProviderName.equalsIgnoreCase("YesBank") && SPE_PaymentMode == 2) {
				List<SPE_SDP_BankDailySettlementModel> sdpList = new ArrayList<SPE_SDP_BankDailySettlementModel>();
				SDP_settlement = (ArrayList<SPE_SDP_BankDailySettlementModel>) sdpGetList
						.getListSettlementAEPSYesBank(iterator, firstSheet);
				if(SDP_settlement != null && SDP_settlement.size()>0){
					sdpList = sdp_validator.spe_sdv_settlementValidation(SDP_settlement);
					response = Response.status(200)
							.entity(new GenericEntity<List<SPE_SDP_BankDailySettlementModel>>(sdpList) {
							}).build();
				}else{
					phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_NO_RECORD_IN_EXCEL);
					phmc_errorMsg.setErrorMessage("No Valid Record Found in Excel File");
					log.error("No Valid Record Found in Excel File");
					response = Response.status(phmc_errorMsg.getErrorCode()).entity(phmc_errorMsg).build();
				}
				
				
			} else if (SPE_ProviderName.equalsIgnoreCase("YesBank") && SPE_PaymentMode == 3) {
				List<SPE_SDP_BankDailySettlementModel> sdpList = new ArrayList<SPE_SDP_BankDailySettlementModel>();
				SDP_settlement = (ArrayList<SPE_SDP_BankDailySettlementModel>) sdpGetList
						.getListSettlementIQRYesBank(iterator, firstSheet);
				if(SDP_settlement != null && SDP_settlement.size()>0){
				sdpList = sdp_validator.spe_sdv_settlementValidation(SDP_settlement);
				response = Response.status(200)
						.entity(new GenericEntity<List<SPE_SDP_BankDailySettlementModel>>(sdpList) {
						}).build();
				}else{
					phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_NO_RECORD_IN_EXCEL);
					phmc_errorMsg.setErrorMessage("No Valid Record Found in Excel File");
					log.error("No Valid Record Found in Excel File");
					response = Response.status(phmc_errorMsg.getErrorCode()).entity(phmc_errorMsg).build();
				}
			} else {
				phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_DATA_NOT_FOUND);
				phmc_errorMsg.setErrorMessage("Service not found");
				response = Response.status(phmc_errorMsg.getErrorCode()).entity(phmc_errorMsg).build();
			}
		} catch (IOException | IllegalArgumentException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			phmc_errorMsg.setErrorCode(400);
			phmc_errorMsg.setErrorMessage("uploaded File is not in Excel Format");
			log.fatal("uploaded File is not in Excel Format");
			response = Response.status(phmc_errorMsg.getErrorCode()).entity(phmc_errorMsg).build();
		}

		return response;
	}

	private Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
		Workbook workbook = null;

		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
			log.info("this is XLSX format");
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook(inputStream);
			log.info("this is XLS format");
		} else {
			log.fatal("The specified file is not Excel file");
			throw new IllegalArgumentException("The specified file is not Excel file");

		}

		return workbook;
	}

}
