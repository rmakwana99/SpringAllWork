
package com.rahul.phmc.spe.poc.builder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.rahul.phmc.spe.poc.constant.SPE_ReportConstants;
import com.rahul.phmc.spe.poc.constant.SPE_StyleAttribute;
import com.rahul.phmc.spe.poc.model.SPE_L2MerchantSettlementReportGridModel;
import com.rahul.phmc.spe.poc.model.SPE_L2MerchantSettlementReportModel;
import com.rahul.phmc.spe.router.dao.SPE_XMonDao;
import com.rahul.phmc.spe.router.model.SPE_TRXNDetailsModel;

public class SPE_L2MerchantSettlementReportBuilder {

	/**
	 * @param reportFileLocation
	 * @throws IOException 
	 */
	public void generateReport(String reportFileLocation, SPE_L2MerchantSettlementReportModel dataModel) throws IOException {

		SPE_ExcelReportTemplateBuilder excelbuilder = new SPE_ExcelReportTemplateBuilder()
				.startSheet(SPE_ReportConstants.SETTLEMENT_SHEET_NAME)// start with sheet
				.startRow() // then go row by row
				.setRowTitleHeight().addTextColumn("") // set row style, add borders and so on
				.addTextColumn(SPE_ReportConstants.REPORT_TITLE, SPE_StyleAttribute.TITLE_SIZE, SPE_StyleAttribute.BOLD) // add columns
				.startRow().startRow() // another row
				.addTextColumn(SPE_ReportConstants.MERCHANT_ID, SPE_StyleAttribute.ALIGN_LEFT, SPE_StyleAttribute.BOLD)
				.addTextColumn(dataModel.getMerchantID(), SPE_StyleAttribute.ALIGN_LEFT) // This needs to be populated from the data object
				.addTextColumn("", SPE_StyleAttribute.ALIGN_LEFT)
				.addTextColumn(SPE_ReportConstants.MERCHANT_NAME, SPE_StyleAttribute.ALIGN_LEFT,
						SPE_StyleAttribute.BOLD)
				.addTextColumn(dataModel.getMerchantName(), SPE_StyleAttribute.ALIGN_LEFT) // This
																							// needs
																							// to
																							// be
																							// populated
																							// from
																							// the
																							// data
																							// object
				.startRow() // empty row
				.startRow()
				.addTextColumn(SPE_ReportConstants.REPORT_START_DATE, SPE_StyleAttribute.ALIGN_LEFT,
						SPE_StyleAttribute.BOLD)
				.addDateColumn(dataModel.getReportStartDate(), SPE_StyleAttribute.ALIGN_LEFT) // This
																								// needs
																								// to
																								// be
																								// populated
																								// from
																								// the
																								// data
																								// object
				.addTextColumn("", SPE_StyleAttribute.ALIGN_LEFT)
				.addTextColumn(SPE_ReportConstants.REPORT_END_DATE, SPE_StyleAttribute.ALIGN_LEFT,
						SPE_StyleAttribute.BOLD)
				.addDateColumn(dataModel.getReportEndDate(), SPE_StyleAttribute.ALIGN_LEFT) // This
																							// needs
																							// to
																							// be
																							// populated
																							// from
																							// the
																							// data
																							// object
				.startRow() // empty row
				.startRow()
				.addTextColumn(SPE_ReportConstants.TOTAL_TRANS_AMOUNT, SPE_StyleAttribute.ALIGN_LEFT,
						SPE_StyleAttribute.BOLD)
				.addNumberColumn(dataModel.getTotalTransAmount(), SPE_StyleAttribute.ALIGN_CENTER) // This
																									// needs
																									// to
																									// be
																									// populated
																									// from
																									// the
																									// data
																									// object
				.addTextColumn("", SPE_StyleAttribute.ALIGN_LEFT)
				.addTextColumn(SPE_ReportConstants.TOTAL_AMOUNT_FROM_SRISHTI, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_LEFT)
				.addNumberColumn(dataModel.getTotalAmntRcvbleFrmSrishti(), SPE_StyleAttribute.ALIGN_CENTER) // This
																											// needs
																											// to
																											// be
																											// populated
																											// from
																											// the
																											// data
																											// object
				.startRow() // header row
				.setRowBorder(SPE_StyleAttribute.THIN_TOP_BORDER)
				.addTextColumn(SPE_ReportConstants.TRANSACTION_ID, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER)
				.addTextColumn(SPE_ReportConstants.TRANSACTION_DATE_TIME, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER)
				.addTextColumn(SPE_ReportConstants.TRANSACTION_AMOUNT_RS, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER)
				.addTextColumn(SPE_ReportConstants.TERMINAL_ID, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER)
				.addTextColumn(SPE_ReportConstants.DEVICE_ID, SPE_StyleAttribute.BOLD, SPE_StyleAttribute.ALIGN_CENTER)
				.addTextColumn(SPE_ReportConstants.MODE_OF_PAYMENT, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER)
				.addTextColumn(SPE_ReportConstants.AMOUNT_RECEIVABLE, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER)
				.addTextColumn(SPE_ReportConstants.AMOUNT_RECEIVED_RS, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER)
				.addTextColumn(SPE_ReportConstants.AMOUNT_RECEIVED_ON, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER)
				.addTextColumn(SPE_ReportConstants.MONEY_TRANSFER_REF_NO, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER)
				.addTextColumn(SPE_ReportConstants.COMMENTS, SPE_StyleAttribute.BOLD, SPE_StyleAttribute.ALIGN_CENTER)
				.startRow().setRowBorder(SPE_StyleAttribute.THIN_TOP_BORDER);

		byte[] xlsdata = null;

		// rows with records (usually within a loop)
		for (SPE_L2MerchantSettlementReportGridModel grid : dataModel.getReportGrid()) {
			excelbuilder.addTextColumn(grid.getTransationId(), SPE_StyleAttribute.ALIGN_CENTER);
			excelbuilder.addDateColumn(grid.getTransDateTime(), SPE_StyleAttribute.ALIGN_RIGHT);
			excelbuilder.addNumberColumn(grid.getTransAmount(), SPE_StyleAttribute.ALIGN_CENTER);
			excelbuilder.addTextColumn(grid.getTerminalId(), SPE_StyleAttribute.ALIGN_CENTER);
			excelbuilder.addTextColumn(grid.getDeviceId(), SPE_StyleAttribute.ALIGN_CENTER);
			excelbuilder.addTextColumn(grid.getModeOfPayment(), SPE_StyleAttribute.ALIGN_CENTER);
			excelbuilder.addNumberColumn(grid.getAmountReceivable(), SPE_StyleAttribute.ALIGN_CENTER);
			excelbuilder.addNumberColumn(grid.getAmountReceived(), SPE_StyleAttribute.ALIGN_CENTER);
			excelbuilder.addDateColumn(grid.getAmountReceivedDate(), SPE_StyleAttribute.ALIGN_RIGHT);
			excelbuilder.addTextColumn(grid.getMoneyTrnsfrRefNum(), SPE_StyleAttribute.ALIGN_CENTER);
			excelbuilder.addTextColumn(grid.getComments(), SPE_StyleAttribute.ALIGN_CENTER);
			// create a new row
			excelbuilder.startRow();
		}
		
		

		xlsdata = excelbuilder.setAutoSizeColumn(0).setAutoSizeColumn(1).setAutoSizeColumn(2).setAutoSizeColumn(3)
				.setAutoSizeColumn(4).setAutoSizeColumn(5).setAutoSizeColumn(6).setAutoSizeColumn(7)
				.setAutoSizeColumn(8).setAutoSizeColumn(9).setAutoSizeColumn(10).build();

		// now deal with byte array (e.g. write to the file or database)
		
			FileUtils.writeByteArrayToFile(new File(reportFileLocation), xlsdata);
		

	}

	public static void main(String[] args) {
		SPE_L2MerchantSettlementReportModel model = new SPE_L2MerchantSettlementReportModel();
		List<SPE_L2MerchantSettlementReportGridModel> gridList = new ArrayList<>();
		SPE_XMonDao txnDao = new SPE_XMonDao();
		float totalTxnAmount = 0.0F;
		float totalreceiedAmount = 0.0F;

		List<SPE_TRXNDetailsModel> trxDeatailsList = txnDao.spe_getalltransactionthruid("", "SRSH");
		System.out.println(trxDeatailsList);
		for (SPE_TRXNDetailsModel txnModel : trxDeatailsList) {
			if (txnModel.getSPE_SettlementStatus().equals("Y")) {
				SPE_L2MerchantSettlementReportGridModel grid = new SPE_L2MerchantSettlementReportGridModel();
				grid.setTransationId(txnModel.getSPE_TransactionID());
				grid.setTransDateTime(txnModel.getSPE_TxnDate());
				grid.setTransAmount(txnModel.getSPE_TransactionAmount());
				grid.setTerminalId(txnModel.getSPE_TerminalID());
				grid.setDeviceId(txnModel.getSPE_DeviceID());
				grid.setModeOfPayment("UPI");
				grid.setAmountReceivable(txnModel.getSPE_PaymentAmount());
				grid.setAmountReceived(txnModel.getSPE_SettlementAmount());
				grid.setAmountReceivedDate(txnModel.getSPE_SettlementDate());
				grid.setMoneyTrnsfrRefNum(txnModel.getSPE_Option3());
				grid.setComments(txnModel.getSPE_Response_Code());
				
				gridList.add(grid);
				
				totalTxnAmount += txnModel.getSPE_TransactionAmount();
				if (txnModel.getSPE_SettlementAmount() != null) {
					totalreceiedAmount += txnModel.getSPE_SettlementAmount();
				}
			}

		}
		System.out.println(gridList);
		model.setReportGrid(gridList);
		model.setMerchantID("SRSH");
		model.setMerchantName("Srishti");
		model.setReportStartDate(new Date());
		model.setReportEndDate(new Date());
		model.setTotalTransAmount(totalTxnAmount);
		model.setTotalAmntRcvbleFrmSrishti(totalreceiedAmount);

		SPE_L2MerchantSettlementReportBuilder reportBuilder = new SPE_L2MerchantSettlementReportBuilder();
		try{
			reportBuilder.generateReport("/tmp/SettlementReport_" + model.getMerchantID() + ".xlsx", model);
			System.out.println("Report Created Successfully");
		}catch(IOException e){
			System.out.println("Report Not Created");
		}
		
	}

}
