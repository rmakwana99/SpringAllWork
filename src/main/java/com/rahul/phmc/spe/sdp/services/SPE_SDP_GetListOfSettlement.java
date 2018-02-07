
package com.rahul.phmc.spe.sdp.services;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.rahul.phmc.spe.sdp.model.SPE_SDP_BankDailySettlementModel;

/**
 * @author rahul makvana this class is Service of Upload Settlement data and
 *         identify the provider and payment mode then create List of
 *         SPE_SDP_BankDailySettlementModel
 */
public class SPE_SDP_GetListOfSettlement {

	// this is creation of logger so we can check what log created.
	static final Logger log = Logger.getLogger(SPE_SDP_UploadSettlementService.class);

	public static String cellToString(Cell cell) {
		Object result;
		if (cell == null) {
			result = " ";
		} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			result = cell.getStringCellValue();
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			result = cell.getNumericCellValue();
		} else {
			result = "";
		}
		return result.toString();
	}

	/*
	 * Function for create list of Settlement from "Yes bank" and payment mode
	 * is "UPI"
	 * 
	 * @param Iterator
	 * 
	 * @param Sheet
	 * 
	 * @return List<SPE_SDP_BankDailySettlementModel>
	 * 
	 */

	public List<SPE_SDP_BankDailySettlementModel> getListSettlementUPIYesBank(Iterator<Row> iterator,
			Sheet firstSheet) {
		List<SPE_SDP_BankDailySettlementModel> sdpSettlementList = new ArrayList<SPE_SDP_BankDailySettlementModel>();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() == 0) {
				continue; // just skip the rows if row number is 0 or 1
			}

			int maxNoOfCell = firstSheet.getRow(0).getLastCellNum();
			SPE_SDP_BankDailySettlementModel settlementDetails = new SPE_SDP_BankDailySettlementModel();
			settlementDetails.setExcelCheck(true);
			// log.info("maximum cell=" + maxNoOfCell);

			for (int counter = 0; counter < maxNoOfCell; counter++) {
				if (cellToString(nextRow.getCell(counter)).trim() != ""
						&& !cellToString(nextRow.getCell(counter)).trim().isEmpty()) {
					switch (counter) {

					case 0:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 20) {
							settlementDetails.setSPE_PGMerchantID((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("merchant ID is more than 20 character");
						}
						break;
					case 1:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 20) {
							settlementDetails.setSPE_LegalName((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Legal Name is more than 20 character");
						}
						break;
					case 2:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 20) {
							settlementDetails.setSPE_DBAName((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Store Name is more than 20 character");
						}
						break;
					case 3:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 10) {
							settlementDetails.setSPE_MCC((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("MCC is more than 10 character");
						}
						break;
					case 4:
						if (cellToString(nextRow.getCell(counter)).trim().length() > 0) {
							if (cellToString(nextRow.getCell(counter)).trim().startsWith("U")) {
								if (cellToString(nextRow.getCell(counter)).trim().length() == 30) {
									settlementDetails.setSPE_OrderNo((String) cellToString(nextRow.getCell(counter)));
								} else {
									settlementDetails.setExcelCheck(false);
									settlementDetails.setExcelError("Transaction ID is not 30 character");
								}
							} else {
								settlementDetails.setExcelCheck(false);
								settlementDetails.setExcelError("Transaction is Not Valid for UPI");
							}
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction ID is Empty");
						}
						break;
					case 5:
						if (!cellToString(nextRow.getCell(counter)).trim().isEmpty()) {
							try {
								BigDecimal bd1 = new BigDecimal(cellToString(nextRow.getCell(counter)));
								settlementDetails.setSPE_TransRefNo((bd1.longValue()));
							} catch (IllegalStateException | NumberFormatException e) {
								log.error(e.getMessage());
								settlementDetails.setExcelCheck(false);
								settlementDetails.setExcelError("Transaction Reference No. not Valid");
							}
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction Reference No. is Empty");
						}
						break;

					case 6:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 20) {
							settlementDetails.setSPE_PaymentRefNo((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payment Reference No. is more than 20 character");
						}
						break;
					case 7:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 2) {
							settlementDetails.setSPE_NPCIResponseCode((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("NPCI Response Code is more than 2 character");
						}
						break;
					case 8:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 10) {
							settlementDetails.setSPE_TransType((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction Type is more than 10 character");
						}
						break;
					case 9:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 10) {
							settlementDetails.setSPE_CROrDR((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Cr/Dr is more than 10 character");
						}
						break;
					case 10:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 20) {
							settlementDetails.setSPE_TransactionStatus((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction Status is more than 20 character");
						}
						break;
					case 11:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							settlementDetails
									.setSPE_TransactionRemarks((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction Remark is more than 30 character");
						}
						break;
					case 12:
						try {
							settlementDetails.setSPE_TransReqDate(
									SPE_convertStringToDate(cellToString(nextRow.getCell(counter))));
						} catch (ParseException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction Date is not valid");
						}
						break;
					case 13:
						try {
							settlementDetails
									.setSPE_TransactionAmount(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch (NumberFormatException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction Amount is not valid");
						}
						break;
					case 14:
						if (!cellToString(nextRow.getCell(counter)).trim().isEmpty()) {
							try {
								BigDecimal bd = new BigDecimal(cellToString(nextRow.getCell(counter)));
								settlementDetails.setSPE_PayerAccNo((bd.longValue()));
							} catch (IllegalStateException | NumberFormatException e) {
								log.error(e.getMessage());
								settlementDetails.setExcelCheck(false);
								settlementDetails.setExcelError("Payer Account No. is not valid");
							}
						} else {
							log.info("Empty Value");
						}
						break;

					case 15:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							settlementDetails.setSPE_PayerVirtualAddr((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payer Virtual Address is more than 30 character");
						}
						break;
					case 16:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							settlementDetails.setSPE_PayerAccName((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payer Account Name is more than 30 character");
						}
						break;

					case 17:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 11) {
							settlementDetails.setSPE_PayerIFSCCode((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payer IFSC Code is not valid");
						}
						break;
					case 18:
						if (!cellToString(nextRow.getCell(counter)).trim().isEmpty()) {
							try {
								BigDecimal bd1 = new BigDecimal(cellToString(nextRow.getCell(counter)));
								settlementDetails.setSPE_PayeeAccNo((bd1.longValue()));
							} catch (IllegalStateException | NumberFormatException e) {
								log.error(e.getMessage());
								settlementDetails.setExcelCheck(false);
								settlementDetails.setExcelError("Payee Account No. is not valid");
							}
						} else {
							log.info("Empty Value");
						}
						break;

					case 19:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							settlementDetails.setSPE_PayeeVirtualAddr((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payee Virtual Address is more than 30 character");
						}
						break;
					case 20:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							settlementDetails.setSPE_PayeeAccName((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payee Account Name is more than 30 character");
						}
						break;
					case 21:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 11) {
							settlementDetails.setSPE_PayeeIFSCCode((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payee IFSC Code is not valid");
						}
						break;
					case 22:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 10) {
							settlementDetails.setSPE_PayType((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Pay Type is not valid");
						}
						break;
					case 23:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 10) {
							settlementDetails.setSPE_DeviceType((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Device Type is more than 30 character");
						}
						break;
					case 24:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 64) {
							settlementDetails.setSPE_App((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("App is more than 64 character");
						}
						break;
					case 25:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							settlementDetails.setSPE_DeviceOS((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Device OS is more than 30 character");
						}
						break;
					case 26:
						if (!cellToString(nextRow.getCell(counter)).trim().isEmpty()) {
							try {
								BigDecimal bd1 = new BigDecimal(cellToString(nextRow.getCell(counter)));
								settlementDetails.setSPE_DeviceMobileNo((bd1.longValue()));
							} catch (IllegalStateException | NumberFormatException e) {
								log.error(e.getMessage());
								settlementDetails.setExcelCheck(false);
								settlementDetails.setExcelError("Device Mobile No. is not valid");
							}
						} else {
							log.info("Empty Value");
						}
						break;

					case 27:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 128) {
							settlementDetails.setSPE_DeviceLocation((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Device Location is more than 128 character");
						}
						break;
					case 28:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 15) {
							settlementDetails.setSPE_IPAddress((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("IP Address is more than 15 character");
						}
						break;
					case 29:
						if (cellToString(nextRow.getCell(counter)).trim().equals("Unreconcilied")) {
							settlementDetails.setSPE_SettlementStatus("N");
						} else {
							settlementDetails.setSPE_SettlementStatus("Y");
						}
						break;

					case 30:
						try {
							settlementDetails.setSPE_SettlementDate(
									SPE_convertStringToDate(cellToString(nextRow.getCell(counter))));
						} catch (ParseException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Settlement Date is not valid");
						}
						break;

					case 31:
						try {
							settlementDetails
									.setSPE_SettlementAmount(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch (NumberFormatException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Settlement Amount is not valid");
						}
						break;

					case 32:
						try {
							settlementDetails
									.setSPE_MSFAmount(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch (NumberFormatException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("MSF Amount is not valid");
						}
						break;
					case 33:

						try {
							settlementDetails
									.setSPE_MSFTaxAmount(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch (NumberFormatException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("MSF Tax Amount is not valid");
						}

						break;
					case 34:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							settlementDetails.setSPE_PayoutStatus((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payout Status is more than 30 character");
						}
						break;
					}

				}
			}

			if (settlementDetails.getSPE_OrderNo() != null) {
				sdpSettlementList.add(settlementDetails);
			}

		}
		log.info("settlement List=" + sdpSettlementList);
		System.out.println("settlement List=" + sdpSettlementList);
		return sdpSettlementList;

	}

	/**
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date SPE_convertStringToDate(String date) throws ParseException {

		Date SPACE_SPLD_currentDate = new Date();
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		sdf.format(SPACE_SPLD_currentDate);
		String SPACE_date2 = sdf.format(SPACE_SPLD_currentDate);
		SPACE_date2 = date;

		SPACE_SPLD_currentDate = sdf.parse(SPACE_date2);

		return SPACE_SPLD_currentDate;
	}

	/*
	 * Function for create list of Settlement from "Yes bank" and payment mode
	 * is "Aadhar Pay/AEPS"
	 * 
	 * @param Iterator
	 * 
	 * @param Sheet
	 * 
	 * @return List<SPE_SDP_BankDailySettlementModel>
	 * 
	 */
	public List<SPE_SDP_BankDailySettlementModel> getListSettlementAEPSYesBank(Iterator<Row> iterator,
			Sheet firstSheet) {
		List<SPE_SDP_BankDailySettlementModel> sdpSettlementList = new ArrayList<SPE_SDP_BankDailySettlementModel>();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() == 0) {
				continue; // just skip the rows if row number is 0 or 1
			}

			int maxNoOfCell = firstSheet.getRow(0).getLastCellNum();
			SPE_SDP_BankDailySettlementModel settlementDetails = new SPE_SDP_BankDailySettlementModel();
			settlementDetails.setExcelCheck(true);

			for (int counter = 0; counter < maxNoOfCell; counter++) {
				if (cellToString(nextRow.getCell(counter)).trim() != ""
						&& !cellToString(nextRow.getCell(counter)).trim().isEmpty()) {
					switch (counter) {

					case 0:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 20) {
							settlementDetails.setSPE_PGMerchantID((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("merchant ID is more than 20 character");
						}
						break;
					case 1:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 20) {
							settlementDetails.setSPE_LegalName((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Legal Name is more than 20 character");
						}
						break;
					case 2:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 20) {
							settlementDetails.setSPE_DBAName((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Store Name is more than 20 character");
						}
						break;
					case 3:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 10) {
							settlementDetails.setSPE_MCC((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("MCC is more than 10 character");
						}
						break;
					case 4:
						if (cellToString(nextRow.getCell(counter)).trim().length() > 0) {
							if (cellToString(nextRow.getCell(counter)).trim().startsWith("A")) {
								if (cellToString(nextRow.getCell(counter)).trim().length() == 30) {
									settlementDetails.setSPE_OrderNo((String) cellToString(nextRow.getCell(counter)));
								} else {
									settlementDetails.setExcelCheck(false);
									settlementDetails.setExcelError("Transaction ID is not 30 character");
								}
							} else {
								settlementDetails.setExcelCheck(false);
								settlementDetails.setExcelError("Transaction is Not Valid for UPI");
							}
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction ID is Empty");
						}
						break;
					case 5:
						try {
							BigDecimal bd1 = new BigDecimal(cellToString(nextRow.getCell(counter)));
							settlementDetails.setSPE_TransRefNo((bd1.longValue()));
						} catch (IllegalStateException | NumberFormatException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction Reference No. not Valid");
						}

					case 6:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 20) {
							settlementDetails.setSPE_PaymentRefNo((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payment Reference No. is more than 20 character");
						}
						break;
					case 7:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 2) {
							settlementDetails.setSPE_NPCIResponseCode((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("NPCI Response Code is more than 2 character");
						}
						break;
					case 8:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 10) {
							settlementDetails.setSPE_TransType((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction Type is more than 10 character");
						}
						break;
					case 9:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 10) {
							settlementDetails.setSPE_CROrDR((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Cr/Dr is more than 10 character");
						}
						break;
					case 10:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 20) {
							settlementDetails.setSPE_TransactionStatus((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction Status is more than 20 character");
						}
						break;
					case 11:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							settlementDetails
									.setSPE_TransactionRemarks((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction Remark is more than 30 character");
						}
						break;
					case 12:
						try {
							settlementDetails.setSPE_TransReqDate(
									SPE_convertStringToDate(cellToString(nextRow.getCell(counter))));
						} catch (ParseException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction Date is not valid");
						}
						break;
					case 13:
						try {
							settlementDetails
									.setSPE_TransactionAmount(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch (NumberFormatException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction Amount is not valid");
						}
						break;
					case 14:
						try {
							BigDecimal bd = new BigDecimal(cellToString(nextRow.getCell(counter)));
							settlementDetails.setSPE_PayerAccNo((bd.longValue()));
						} catch (IllegalStateException | NumberFormatException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payer Account No. is not valid");
						}
						break;

					case 15:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							settlementDetails.setSPE_PayerAccName((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payer Account Name is more than 30 character");
						}
						break;

					case 16:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 11) {
							settlementDetails.setSPE_PayerIFSCCode((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payer IFSC Code is not valid");
						}
						break;
					case 17:
						try {
							BigDecimal bd1 = new BigDecimal(cellToString(nextRow.getCell(counter)));
							settlementDetails.setSPE_PayeeAccNo((bd1.longValue()));
						} catch (IllegalStateException | NumberFormatException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payee Account No. is not valid");
						}
						break;

					case 18:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							settlementDetails.setSPE_PayeeAccName((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payee Account Name is more than 30 character");
						}
						break;
					case 19:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 11) {
							settlementDetails.setSPE_PayeeIFSCCode((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payee IFSC Code is not valid");
						}
						break;
					case 20:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 10) {
							settlementDetails.setSPE_PayType((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Pay Type is not valid");
						}
						break;
					case 21:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 10) {
							settlementDetails.setSPE_DeviceType((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Device Type is more than 30 character");
						}
						break;
					case 22:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 64) {
							settlementDetails.setSPE_App((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("App is more than 64 character");
						}
						break;
					case 23:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							settlementDetails.setSPE_DeviceOS((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Device OS is more than 30 character");
						}
						break;
					case 24:
						try {
							BigDecimal bd1 = new BigDecimal(cellToString(nextRow.getCell(counter)));
							settlementDetails.setSPE_DeviceMobileNo((bd1.longValue()));
						} catch (IllegalStateException | NumberFormatException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Device Mobile No. is not valid");
						}
						break;

					case 25:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 128) {
							settlementDetails.setSPE_DeviceLocation((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Device Location is more than 128 character");
						}
						break;
					case 26:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 15) {
							settlementDetails.setSPE_IPAddress((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("IP Address is more than 15 character");
						}
						break;
					case 27:
						if (cellToString(nextRow.getCell(counter)).trim().equals("Unreconcilied")) {
							settlementDetails.setSPE_SettlementStatus("N");
						} else {
							settlementDetails.setSPE_SettlementStatus("Y");
						}
						break;

					case 28:
						try {
							settlementDetails.setSPE_SettlementDate(
									SPE_convertStringToDate(cellToString(nextRow.getCell(counter))));
						} catch (ParseException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Settlement Date is not valid");
						}
						break;

					case 29:
						try {
							settlementDetails
									.setSPE_SettlementAmount(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch (NumberFormatException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Settlement Amount is not valid");
						}
						break;

					case 30:
						try {
							settlementDetails
									.setSPE_MSFAmount(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch (NumberFormatException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("MSF Amount is not valid");
						}
						break;
					case 31:
						try {
							settlementDetails
									.setSPE_MSFTaxAmount(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch (NumberFormatException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("MSF Tax Amount is not valid");
						}
						break;
					case 32:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							settlementDetails.setSPE_PayoutStatus((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payout Status is more than 30 character");
						}
						break;
					}

				}
			}

			if (settlementDetails.getSPE_OrderNo() != null) {
				sdpSettlementList.add(settlementDetails);
			}

		}
		log.info("settlement List=" + sdpSettlementList);
		return sdpSettlementList;

	}

	/*
	 * Function for create list of Settlement from "Yes bank" and payment mode
	 * is "Bharat QR"
	 * 
	 * @param Iterator
	 * 
	 * @param Sheet
	 * 
	 * @return List<SPE_SDP_BankDailySettlementModel>
	 * 
	 */
	public List<SPE_SDP_BankDailySettlementModel> getListSettlementIQRYesBank(Iterator<Row> iterator,
			Sheet firstSheet) {
		List<SPE_SDP_BankDailySettlementModel> sdpSettlementList = new ArrayList<SPE_SDP_BankDailySettlementModel>();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() == 0) {
				continue; // just skip the rows if row number is 0 or 1
			}

			int maxNoOfCell = firstSheet.getRow(0).getLastCellNum();
			SPE_SDP_BankDailySettlementModel settlementDetails = new SPE_SDP_BankDailySettlementModel();
			settlementDetails.setExcelCheck(true);

			for (int counter = 0; counter < maxNoOfCell; counter++) {
				if (cellToString(nextRow.getCell(counter)).trim() != ""
						&& !cellToString(nextRow.getCell(counter)).trim().isEmpty()) {
					switch (counter) {

					case 0:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 20) {
							settlementDetails.setSPE_PGMerchantID((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("merchant ID is more than 20 character");
						}
						break;
					case 1:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 20) {
							settlementDetails.setSPE_LegalName((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Legal Name is more than 20 character");
						}
						break;
					case 2:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 20) {
							settlementDetails.setSPE_DBAName((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Store Name is more than 20 character");
						}
						break;
					case 3:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 10) {
							settlementDetails.setSPE_MCC((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("MCC is more than 10 character");
						}
						break;
					case 4:
						if (cellToString(nextRow.getCell(counter)).trim().length() > 0) {
							if (cellToString(nextRow.getCell(counter)).trim().startsWith("Q")) {
								if (cellToString(nextRow.getCell(counter)).trim().length() == 30) {
									settlementDetails.setSPE_OrderNo((String) cellToString(nextRow.getCell(counter)));
								} else {
									settlementDetails.setExcelCheck(false);
									settlementDetails.setExcelError("Transaction ID is not 30 character");
								}
							} else {
								settlementDetails.setExcelCheck(false);
								settlementDetails.setExcelError("Transaction is Not Valid for UPI");
							}
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction ID is Empty");
						}
						break;
					case 5:
						if (!cellToString(nextRow.getCell(counter)).trim().isEmpty()) {
							try {
								BigDecimal bd1 = new BigDecimal(cellToString(nextRow.getCell(counter)));
								settlementDetails.setSPE_TransRefNo((bd1.longValue()));
							} catch (IllegalStateException | NumberFormatException e) {
								log.error(e.getMessage());
								settlementDetails.setExcelCheck(false);
								settlementDetails.setExcelError("Transaction Reference No. not Valid");
							}
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction Reference No. is Empty");
						}
						break;

					case 6:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 20) {
							settlementDetails.setSPE_PaymentRefNo((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payment Reference No. is more than 20 character");
						}
						break;
					case 7:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 2) {
							settlementDetails.setSPE_NPCIResponseCode((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("NPCI Response Code is more than 2 character");
						}
						break;
					case 8:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 10) {
							settlementDetails.setSPE_TransType((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction Type is more than 10 character");
						}
						break;
					case 9:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 10) {
							settlementDetails.setSPE_CROrDR((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Cr/Dr is more than 10 character");
						}
						break;
					case 10:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 20) {
							settlementDetails.setSPE_TransactionStatus((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction Status is more than 20 character");
						}
						break;
					case 11:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							settlementDetails
									.setSPE_TransactionRemarks((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction Remark is more than 30 character");
						}
						break;
					case 12:
						try {
							settlementDetails.setSPE_TransReqDate(
									SPE_convertStringToDate(cellToString(nextRow.getCell(counter))));
						} catch (ParseException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction Date is not valid");
						}
						break;
					case 13:
						try {
							settlementDetails
									.setSPE_TransactionAmount(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch (NumberFormatException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Transaction Amount is not valid");
						}
						break;
					case 14:
						try {
							BigDecimal bd = new BigDecimal(cellToString(nextRow.getCell(counter)));
							settlementDetails.setSPE_PayerAccNo((bd.longValue()));
						} catch (IllegalStateException | NumberFormatException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payer Account No. is not valid");
						}
						break;

					case 15:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							settlementDetails.setSPE_PayerAccName((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payer Account Name is more than 30 character");
						}
						break;

					case 16:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 11) {
							settlementDetails.setSPE_PayerIFSCCode((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payer IFSC Code is not valid");
						}
						break;
					case 17:
						try {
							BigDecimal bd1 = new BigDecimal(cellToString(nextRow.getCell(counter)));
							settlementDetails.setSPE_PayeeAccNo((bd1.longValue()));
						} catch (IllegalStateException | NumberFormatException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payee Account No. is not valid");
						}
						break;

					case 18:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							settlementDetails.setSPE_PayeeAccName((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payee Account Name is more than 30 character");
						}
						break;
					case 19:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 11) {
							settlementDetails.setSPE_PayeeIFSCCode((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payee IFSC Code is not valid");
						}
						break;
					case 20:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 10) {
							settlementDetails.setSPE_PayType((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Pay Type is not valid");
						}
						break;
					case 21:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 10) {
							settlementDetails.setSPE_DeviceType((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Device Type is more than 30 character");
						}
						break;
					case 22:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 64) {
							settlementDetails.setSPE_App((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("App is more than 64 character");
						}
						break;
					case 23:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							settlementDetails.setSPE_DeviceOS((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Device OS is more than 30 character");
						}
						break;
					case 24:
						try {
							BigDecimal bd1 = new BigDecimal(cellToString(nextRow.getCell(counter)));
							settlementDetails.setSPE_DeviceMobileNo((bd1.longValue()));
						} catch (IllegalStateException | NumberFormatException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Device Mobile No. is not valid");
						}
						break;

					case 25:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 128) {
							settlementDetails.setSPE_DeviceLocation((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Device Location is more than 128 character");
						}
						break;
					case 26:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 15) {
							settlementDetails.setSPE_IPAddress((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("IP Address is more than 15 character");
						}
						break;
					case 27:
						if (cellToString(nextRow.getCell(counter)).trim().equals("Unreconcilied")) {
							settlementDetails.setSPE_SettlementStatus("N");
						} else {
							settlementDetails.setSPE_SettlementStatus("Y");
						}
						break;

					case 28:
						try {
							settlementDetails.setSPE_SettlementDate(
									SPE_convertStringToDate(cellToString(nextRow.getCell(counter))));
						} catch (ParseException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Settlement Date is not valid");
						}
						break;

					case 29:
						try {
							settlementDetails
									.setSPE_SettlementAmount(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch (NumberFormatException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Settlement Amount is not valid");
						}
						break;

					case 30:
						try {
							settlementDetails
									.setSPE_MSFAmount(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch (NumberFormatException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("MSF Amount is not valid");
						}
						break;
					case 31:
						try {
							settlementDetails
									.setSPE_MSFTaxAmount(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch (NumberFormatException e) {
							log.error(e.getMessage());
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("MSF Tax Amount is not valid");
						}
						break;
					case 32:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							settlementDetails.setSPE_PayoutStatus((String) cellToString(nextRow.getCell(counter)));
						} else {
							settlementDetails.setExcelCheck(false);
							settlementDetails.setExcelError("Payout Status is more than 30 character");
						}
						break;
					}

				}
			}

			if (settlementDetails.getSPE_OrderNo() != null) {
				sdpSettlementList.add(settlementDetails);
			}

		}
		log.info("settlement List=" + sdpSettlementList);
		return sdpSettlementList;

	}

}
