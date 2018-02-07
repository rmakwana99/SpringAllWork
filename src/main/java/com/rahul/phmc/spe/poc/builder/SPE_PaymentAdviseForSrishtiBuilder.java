
package com.rahul.phmc.spe.poc.builder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.rahul.phmc.spe.merchant.dao.SPE_MerchantDao;
import com.rahul.phmc.spe.merchant.model.SPE_MerchantModel;
import com.rahul.phmc.spe.poc.constant.SPE_ReportConstants;
import com.rahul.phmc.spe.poc.constant.SPE_StyleAttribute;
import com.rahul.phmc.spe.poc.model.SPE_MerchantForAdviceModel;
import com.rahul.phmc.spe.poc.model.SPE_PaymentAdviceForSrishtiModel;
import com.rahul.phmc.spe.router.dao.SPE_XMonDao;
import com.rahul.phmc.spe.router.model.SPE_TRXNDetailsModel;

public class SPE_PaymentAdviseForSrishtiBuilder {

	/**
	 * @param reportFileLocation
	 * @throws IOException
	 */
	public void generateReport(String reportFileLocation, SPE_PaymentAdviceForSrishtiModel dataModel)
			throws IOException {

		SPE_ExcelReportTemplateBuilder excelbuilder = new SPE_ExcelReportTemplateBuilder()
				.startSheet(SPE_ReportConstants.PAYMENT_ADVICE_NAME)// start
																	// with
																	// sheet
				.startRow() // then go row by row
				.setRowTitleHeight().addTextColumn("") // set row style, add
														// borders and so on
				.addTextColumn(SPE_ReportConstants.ADVICE_REPORT_TITLE, SPE_StyleAttribute.TITLE_SIZE,
						SPE_StyleAttribute.BOLD) // add columns
				.startRow().startRow() // another row
				.addTextColumn(SPE_ReportConstants.REPORT_START_DATE, SPE_StyleAttribute.ALIGN_LEFT,
						SPE_StyleAttribute.BOLD, SPE_StyleAttribute.SET_BACKGROUND)
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
						SPE_StyleAttribute.BOLD, SPE_StyleAttribute.SET_BACKGROUND)
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
				.startRow().startRow()
				.addTextColumn(SPE_ReportConstants.TOTAL_PAYMENT_TO_SRISHTI, SPE_StyleAttribute.ALIGN_LEFT,
						SPE_StyleAttribute.BOLD, SPE_StyleAttribute.SET_BACKGROUND)
				.addNumberColumn(dataModel.getTotalPaymentToSrishti(), SPE_StyleAttribute.ALIGN_LEFT)
				.addTextColumn("", SPE_StyleAttribute.ALIGN_LEFT)
				.addTextColumn(SPE_ReportConstants.TOTAL_PAYMENT_TO_DISTRIBUTED, SPE_StyleAttribute.ALIGN_LEFT,
						SPE_StyleAttribute.BOLD, SPE_StyleAttribute.SET_BACKGROUND)
				.addNumberColumn(dataModel.getTotalAmntToDistributed(), SPE_StyleAttribute.ALIGN_LEFT)
				.startRow() 
				.startRow()// empty row
				.addTextColumn(SPE_ReportConstants.TOTAL_EARNING_TO_SRISHTI, SPE_StyleAttribute.ALIGN_LEFT,
						SPE_StyleAttribute.BOLD, SPE_StyleAttribute.SET_BACKGROUND)
				.addNumberColumn(dataModel.getTotalEarningToSrishti(), SPE_StyleAttribute.ALIGN_CENTER).startRow().startRow()
				.addTextColumn(SPE_ReportConstants.PAYMNET_DETAILS_FROM_BANK, SPE_StyleAttribute.ALIGN_LEFT,
						SPE_StyleAttribute.BOLD)
				.startRow()// header row
				.setRowBorder(SPE_StyleAttribute.THIN_TOP_BORDER)
				.addTextColumn(SPE_ReportConstants.BANK_NAME, SPE_StyleAttribute.BOLD, SPE_StyleAttribute.ALIGN_CENTER,
						SPE_StyleAttribute.SET_BACKGROUND)
				.addTextColumn(SPE_ReportConstants.PAYMENT_TO_SRISHTI, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER, SPE_StyleAttribute.SET_BACKGROUND)
				.addTextColumn(SPE_ReportConstants.MODE_OF_PAYMENT, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER, SPE_StyleAttribute.SET_BACKGROUND)
				.addTextColumn(SPE_ReportConstants.PAYMENT_REFERENCE_NUMBER, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER, SPE_StyleAttribute.SET_BACKGROUND)
				.addTextColumn(SPE_ReportConstants.DATE_OF_PAYMENT, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER, SPE_StyleAttribute.SET_BACKGROUND)

				.startRow().setRowBorder(SPE_StyleAttribute.THIN_TOP_BORDER);

		// rows with records (usually within a loop)
		// for (SPE_L2MerchantSettlementReportGridModel grid :
		// dataModel.getReportGrid()) {
		excelbuilder.addTextColumn("YES Bank", SPE_StyleAttribute.ALIGN_CENTER);
		excelbuilder.addTextColumn("", SPE_StyleAttribute.ALIGN_RIGHT);
		excelbuilder.addTextColumn("UPI", SPE_StyleAttribute.ALIGN_CENTER);
		excelbuilder.addTextColumn("REFERENCEFORBANK", SPE_StyleAttribute.ALIGN_CENTER);
		excelbuilder.addTextColumn("Thursday 24-08-2017", SPE_StyleAttribute.ALIGN_CENTER);
		// create a new row
		excelbuilder.startRow();
		// }

		excelbuilder.startRow().setRowBorder(SPE_StyleAttribute.THIN_TOP_BORDER).startRow().startRow()
				.addTextColumn(SPE_ReportConstants.MERCHANT_SETTLEMENT, SPE_StyleAttribute.ALIGN_LEFT,
						SPE_StyleAttribute.BOLD)
				.startRow()// header row
				.setRowBorder(SPE_StyleAttribute.THIN_TOP_BORDER)
				.addTextColumn(SPE_ReportConstants.MERCHANT_ID, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER, SPE_StyleAttribute.SET_BACKGROUND)
				.addTextColumn(SPE_ReportConstants.MERCHANT_NAME, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER, SPE_StyleAttribute.SET_BACKGROUND)
				.addTextColumn(SPE_ReportConstants.TRANSACTION_AMOUNT_RS, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER, SPE_StyleAttribute.SET_BACKGROUND)
				.addTextColumn(SPE_ReportConstants.AMOUNT_RECEIVED_FROM_BANK, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER, SPE_StyleAttribute.SET_BACKGROUND)
				.addTextColumn(SPE_ReportConstants.SRISHTI_INCOME, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER, SPE_StyleAttribute.SET_BACKGROUND)
				.addTextColumn(SPE_ReportConstants.AMOUNT_PAYABLE_MERCHANT, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER, SPE_StyleAttribute.SET_BACKGROUND)
				.startRow().setRowBorder(SPE_StyleAttribute.THIN_TOP_BORDER);

		for (SPE_MerchantForAdviceModel grid : dataModel.getReportaccountGrid()) {
			excelbuilder.addTextColumn(grid.getMerchantID(), SPE_StyleAttribute.ALIGN_LEFT);
			excelbuilder.addTextColumn(grid.getMerchantName(), SPE_StyleAttribute.ALIGN_LEFT);
			excelbuilder.addNumberColumn(grid.getTransactionAmt(), SPE_StyleAttribute.ALIGN_CENTER);
			excelbuilder.addNumberColumn(grid.getAmtFromBank(), SPE_StyleAttribute.ALIGN_CENTER);
			excelbuilder.addNumberColumn(grid.getSrishtiIncome(), SPE_StyleAttribute.ALIGN_CENTER);
			excelbuilder.addNumberColumn(grid.getAmtForMerchant(), SPE_StyleAttribute.ALIGN_CENTER);
			// create a new row
			excelbuilder.startRow();
		}

		excelbuilder.startRow().setRowBorder(SPE_StyleAttribute.THIN_TOP_BORDER).startRow().startRow()
				.addTextColumn(SPE_ReportConstants.FOLLOWING_TABLE_FOR_MERCHANT, SPE_StyleAttribute.ALIGN_LEFT,
						SPE_StyleAttribute.BOLD)
				.startRow()// header row
				.setRowBorder(SPE_StyleAttribute.THIN_TOP_BORDER)
				.addTextColumn(SPE_ReportConstants.MERCHANT_ID, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER, SPE_StyleAttribute.SET_BACKGROUND)
				.addTextColumn(SPE_ReportConstants.DATE, SPE_StyleAttribute.BOLD, SPE_StyleAttribute.ALIGN_CENTER,
						SPE_StyleAttribute.SET_BACKGROUND)
				.addTextColumn(SPE_ReportConstants.TRANSACTION_AMOUNT_RS, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER, SPE_StyleAttribute.SET_BACKGROUND)
				.addTextColumn(SPE_ReportConstants.MODE_OF_PAYMENT, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER, SPE_StyleAttribute.SET_BACKGROUND)
				.addTextColumn(SPE_ReportConstants.AMOUNT_RECEIVED_FROM_BANK, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER, SPE_StyleAttribute.SET_BACKGROUND)
				.addTextColumn(SPE_ReportConstants.SRISHTI_INCOME, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER, SPE_StyleAttribute.SET_BACKGROUND)
				.addTextColumn(SPE_ReportConstants.AMOUNT_PAYABLE_MERCHANT, SPE_StyleAttribute.BOLD,
						SPE_StyleAttribute.ALIGN_CENTER, SPE_StyleAttribute.SET_BACKGROUND)
				.startRow().setRowBorder(SPE_StyleAttribute.THIN_TOP_BORDER);

		for (SPE_MerchantForAdviceModel grid : dataModel.getReportaccountGrid()) {
			excelbuilder.addTextColumn(grid.getMerchantID(), SPE_StyleAttribute.ALIGN_CENTER);
			excelbuilder.addDateColumn(new Date(), SPE_StyleAttribute.ALIGN_RIGHT);
			excelbuilder.addNumberColumn(grid.getTransactionAmt(), SPE_StyleAttribute.ALIGN_CENTER);
			excelbuilder.addTextColumn("UPI", SPE_StyleAttribute.ALIGN_CENTER);
			excelbuilder.addNumberColumn(grid.getAmtFromBank(), SPE_StyleAttribute.ALIGN_CENTER);
			excelbuilder.addNumberColumn(grid.getSrishtiIncome(), SPE_StyleAttribute.ALIGN_CENTER);
			excelbuilder.addNumberColumn(grid.getAmtForMerchant(), SPE_StyleAttribute.ALIGN_CENTER);
			// create a new row
			excelbuilder.startRow();
		}

		byte[] xlsdata = null;
		xlsdata = excelbuilder.setAutoSizeColumn(0).setAutoSizeColumn(1).setAutoSizeColumn(2).setAutoSizeColumn(3)
				.setAutoSizeColumn(4).setAutoSizeColumn(5).setAutoSizeColumn(6).setAutoSizeColumn(7)
				.setAutoSizeColumn(8).setAutoSizeColumn(9).setAutoSizeColumn(10).build();

		// now deal with byte array (e.g. write to the file or database)

		FileUtils.writeByteArrayToFile(new File(reportFileLocation), xlsdata);

	}

	public static void main(String[] args) {
		SPE_PaymentAdviceForSrishtiModel model = new SPE_PaymentAdviceForSrishtiModel();
		// List<SPE_L2MerchantSettlementReportGridModel> gridList = new
		// ArrayList<>();
		SPE_MerchantDao SPE_MerchantDao = new SPE_MerchantDao();
		SPE_XMonDao txnDao = new SPE_XMonDao();
		float totalTxnAmount = 0.0F;
		float amountReciveedFromBank = 0.0F;
		float srishiIncome = 0.0F;
		float amountpaybaletomerchant = 0.0F;
		float totalAmountpaybaletomerchant=0.0F;
		float totalSrishiIncome =0.0F;
		float totalAmountReciveedFromBank =0.0F;

		List<SPE_MerchantForAdviceModel> merchantAdviceList=new ArrayList<SPE_MerchantForAdviceModel>();
		List<SPE_MerchantModel> merchantList = SPE_MerchantDao.spe_readAllMerchant();
		System.out.println(merchantList);
		for (SPE_MerchantModel merchant : merchantList) {
			totalTxnAmount=0.0F;
			amountReciveedFromBank=0.0F;
			srishiIncome=0.0F;
			List<SPE_TRXNDetailsModel> trxDeatailsList = txnDao.spe_getalltransactionthruid("",merchant.getSPE_MerchantTable());
			System.out.println(trxDeatailsList);
			for (SPE_TRXNDetailsModel txnModel : trxDeatailsList) {
				
				if (txnModel.getSPE_ProcessingStatus() == 0) {
					totalTxnAmount += txnModel.getSPE_PaymentAmount();
					amountReciveedFromBank += txnModel.getSPE_SettlementAmount();
					srishiIncome += txnModel.getSPE_ComsnMerchant();
				}
			}
			SPE_MerchantForAdviceModel adviceModel=new SPE_MerchantForAdviceModel();
			amountpaybaletomerchant = amountReciveedFromBank - srishiIncome;
			adviceModel.setMerchantID(merchant.getSPE_MerchantTable());
			adviceModel.setMerchantName(merchant.getSPE_MerchantID());
			adviceModel.setTransactionAmt(totalTxnAmount);
			adviceModel.setAmtFromBank(amountReciveedFromBank);
			adviceModel.setSrishtiIncome(srishiIncome);
			adviceModel.setAmtForMerchant(amountpaybaletomerchant);
			
			totalAmountpaybaletomerchant += amountpaybaletomerchant;
			totalAmountReciveedFromBank += amountReciveedFromBank;
			totalSrishiIncome += srishiIncome;
			
			merchantAdviceList.add(adviceModel);
			
			
		}
		// System.out.println(gridList);
		model.setReportaccountGrid(merchantAdviceList);
		model.setReportStartDate(new Date());
		model.setReportEndDate(new Date());
		model.setTotalPaymentToSrishti(totalAmountReciveedFromBank);
		model.setTotalAmntToDistributed(totalAmountpaybaletomerchant);
		model.setTotalEarningToSrishti(totalSrishiIncome);

		SPE_PaymentAdviseForSrishtiBuilder reportBuilder = new SPE_PaymentAdviseForSrishtiBuilder();
		try {
			reportBuilder.generateReport("/tmp/Payment_Advice_Srishti.xlsx", model);
			System.out.println("Report Created Successfully");
		} catch (IOException e) {
			System.out.println("Report Not Created");
		}

	}

}
