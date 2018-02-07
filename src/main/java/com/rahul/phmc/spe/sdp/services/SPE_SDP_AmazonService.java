
package com.rahul.phmc.spe.sdp.services;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.rahul.phmc.spe.router.model.*;
import com.rahul.phmc.spe.sdp.model.SPE_AMAZON_TRXN_DETAILSModel;
import com.rahul.phmc.spe.sdp.model.SPE_DAILY_AMAZON_EARNING_DEPOTModel;

/**
 * @author rahul Makvana
 *
 */
public class SPE_SDP_AmazonService {
	// this is creation of logger so we can check what log created.
	static final Logger log = Logger.getLogger(SPE_SDP_AmazonService.class);
	/**
	 * Amazon Earning Report excel conversion to internal Data Structure 
	 * @param iterator
	 * @param firstSheet
	 * @return
	 */
	public List<SPE_AMAZON_TRXN_DETAILSModel> convertAmazonOrderReportToList(Iterator<Row> iterator,
			Sheet firstSheet) {
		
		List<SPE_AMAZON_TRXN_DETAILSModel>  spe_amazonOrderList =	new ArrayList<SPE_AMAZON_TRXN_DETAILSModel>();
		//List<SPE_TRXNDetailsModel> spe_amazonEarningList = spe_amazonSRSHEarningList;
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() == 0) {
				continue; // just skip the rows if row number is 0 or 1
			}

			int maxNoOfCell = firstSheet.getRow(0).getLastCellNum();
			SPE_AMAZON_TRXN_DETAILSModel spe_orderModel = new SPE_AMAZON_TRXN_DETAILSModel();
			spe_orderModel.setSpe_excelcheck(true);
			for (int counter = 0; counter < maxNoOfCell; counter++) {
				//spe_orderModel.setSPE_AutoSrNo(UUID.randomUUID().toString());				
				if (cellToString(nextRow.getCell(counter)).trim() != ""
						&& !cellToString(nextRow.getCell(counter)).trim().isEmpty()) {
					switch (counter) {
					case 0:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 35) {
							spe_orderModel.setSpe_transactionID(cellToString(nextRow.getCell(counter)));
						} else {
							spe_orderModel.setSpe_excelcheck(false);
							spe_orderModel.setSpe_excelError("Transaction ID is more than 35 character");
						}
						break;
					case 1:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 15) {
							spe_orderModel.setSpe_storeID((String) cellToString(nextRow.getCell(counter)));
						} else {
							spe_orderModel.setSpe_excelcheck(false);
							spe_orderModel.setSpe_excelError("Strore ID is more than 15 character");
						}
						break;
					case 2:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 128) {							
							spe_orderModel.setSpe_categoryName((String) cellToString(nextRow.getCell(counter)));
						} else {
							spe_orderModel.setSpe_excelcheck(false);
							spe_orderModel.setSpe_excelError("Catagory Name is more than 128 character");
						}
						break;
					case 3:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 250) {
							spe_orderModel.setSpe_itemName((String) cellToString(nextRow.getCell(counter)));
						} else {
							spe_orderModel.setSpe_excelcheck(false);
							spe_orderModel.setSpe_excelError("Item Name is more than 250 character");
						}
						break;
					case 4:
						try {
							spe_orderModel.setSpe_itemQty((int)Math.round(nextRow.getCell(counter).getNumericCellValue()));
						} catch(IllegalStateException e) {
							log.error(e.getMessage());
							spe_orderModel.setSpe_excelcheck(false);
							spe_orderModel.setSpe_excelError("Item Quantity is not valid");
						}
						break;
					case 5:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 64) {
							spe_orderModel.setSpe_itemID((String) cellToString(nextRow.getCell(counter)));
						} else {
							spe_orderModel.setSpe_excelcheck(false);
							spe_orderModel.setSpe_excelError("Item ID is more than 64 character");
						}
						break;
					case 6:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							spe_orderModel.setSpe_AmazonTxnId((cellToString(nextRow.getCell(counter))));
						} else {
							spe_orderModel.setSpe_excelcheck(false);
							spe_orderModel.setSpe_excelError("Amazon Transaction ID is more than 20 character");
						}
						break;
					case 7:
						try {
							spe_orderModel.setSpe_itemPrice(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch(NumberFormatException e) {
							log.error(e.getMessage());
							spe_orderModel.setSpe_excelcheck(false);
							spe_orderModel.setSpe_excelError("Item Price is Not valid");
						}
						break;
					case 8:
						try{
							spe_orderModel.setSpe_itemDiscount(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch(NumberFormatException e) {
							log.error(e.getMessage());
							spe_orderModel.setSpe_excelcheck(false);
							spe_orderModel.setSpe_excelError("Item Discount is Not Valid");
						}
						break;
					case 9:
						try {
							spe_orderModel.setSpe_newCustDiscount(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch(NumberFormatException e) {
							log.error(e.getMessage());
							spe_orderModel.setSpe_excelcheck(false);
							spe_orderModel.setSpe_excelError("New Customer Discount is Not Valid");
						}
						break;
					case 10:
						try{
							spe_orderModel.setSpe_totalTxnAmount(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch(NumberFormatException e) {
							log.error(e.getMessage());
							spe_orderModel.setSpe_excelcheck(false);
							spe_orderModel.setSpe_excelError("Total Transaction Amount is Not Valid");
						}
						break;
					case 11:
						try {
							spe_orderModel.setSpe_shippingDate(SPE_convertStringToDate( cellToString(nextRow.getCell(counter))));
						} catch(ParseException e) {
							log.error(e.getMessage());
							spe_orderModel.setSpe_excelcheck(false);
							spe_orderModel.setSpe_excelError("Shipping Date is Not Valid");
						}
						break;
					case 12:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 10) {
							spe_orderModel.setSpe_deviceTypeGroup((cellToString(nextRow.getCell(counter))));
						} else {
							spe_orderModel.setSpe_excelcheck(false);
							spe_orderModel.setSpe_excelError("Device Type is more than 10 character");
						}
						break;
					
					}
				}
			}
			spe_amazonOrderList.add(spe_orderModel);
		}
		return spe_amazonOrderList;
	}
	/**
	 * Amazon Earning Report excel conversion to internal Data Structure 
	 * @param iterator
	 * @param firstSheet
	 * @return
	 */
	public List<SPE_DAILY_AMAZON_EARNING_DEPOTModel> convertAmazonEarningReportToList(Iterator<Row> iterator,
			Sheet firstSheet) {
		List<SPE_DAILY_AMAZON_EARNING_DEPOTModel> spe_amazonEarningList = new ArrayList<>();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() == 0) {
				continue; // just skip the rows if row number is 0 or 1
			}

			int maxNoOfCell = firstSheet.getRow(0).getLastCellNum();
			SPE_DAILY_AMAZON_EARNING_DEPOTModel spe_earningModel = new SPE_DAILY_AMAZON_EARNING_DEPOTModel();
			spe_earningModel.setSpe_excelcheck(true);
                  try{
			for (int counter = 0; counter < maxNoOfCell; counter++) {
				if (cellToString(nextRow.getCell(counter)).trim() != ""
						&& !cellToString(nextRow.getCell(counter)).trim().isEmpty()) {
					switch (counter) {
					case 0:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 128) {
							spe_earningModel.setSPE_ProductCategory(cellToString(nextRow.getCell(counter)));
						} else {
							spe_earningModel.setSpe_excelcheck(false);
							spe_earningModel.setSpe_excelError("Product Catagory is more than 128 character");
						}
						break;
					case 1:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 128) {
							spe_earningModel.setSPE_CommissionCategory((String) cellToString(nextRow.getCell(counter)));
						} else {
							spe_earningModel.setSpe_excelcheck(false);
							spe_earningModel.setSpe_excelError("Commission Catagory is more than 128 character");
						}
						break;
					case 2:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 128) {
							spe_earningModel.setSPE_ProductName((String) cellToString(nextRow.getCell(counter)));
						} else {
							spe_earningModel.setSpe_excelcheck(false);
							spe_earningModel.setSpe_excelError("Product Name is more than 128 character");
						}
						break;
					case 3:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 15) {
							spe_earningModel.setSPE_StoreID((String) cellToString(nextRow.getCell(counter)));
						} else {
							spe_earningModel.setSpe_excelcheck(false);
							spe_earningModel.setSpe_excelError("Store ID is more than 15 character");
						}
						break;
					case 4:
						try {
							spe_earningModel.setSPE_DateShipped(SPE_convertStringToDate( cellToString(nextRow.getCell(counter))));
						} catch(ParseException e) {
							log.error(e.getMessage());
							spe_earningModel.setSpe_excelcheck(false);
							spe_earningModel.setSpe_excelError("Shipped Date is not valid");
						}
						break;
					case 5:
						try{
							spe_earningModel.setSPE_Price(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch(NumberFormatException e) {
							log.error(e.getMessage());
							spe_earningModel.setSpe_excelcheck(false);
							spe_earningModel.setSpe_excelError("Price is not valid");
						}
						break;
					case 6:
						try{
							spe_earningModel.setSPE_ItemShipped((int)Math.round(nextRow.getCell(counter).getNumericCellValue()));
						} catch(IllegalStateException e) {
							log.error(e.getMessage());
							spe_earningModel.setSpe_excelcheck(false);
							spe_earningModel.setSpe_excelError("Item Shipped is more than 20 digit");
						}
						break;
					case 7:
						try{
							spe_earningModel.setSPE_ItemRetrun((int)Math.round(nextRow.getCell(counter).getNumericCellValue()));
						} catch(IllegalStateException e) {
							log.error(e.getMessage());
							spe_earningModel.setSpe_excelcheck(false);
							spe_earningModel.setSpe_excelError("Item Return is more than 20 digit");
						}
						break;
					case 8:
						try{
							spe_earningModel.setSPE_CommssionEarned(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch(NumberFormatException e) {
							log.error(e.getMessage());
							spe_earningModel.setSpe_excelcheck(false);
							spe_earningModel.setSpe_excelError("Commission Earned is not valid");
						}
						break;
					case 9:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 20) {
							spe_earningModel.setSPE_DeviceTypeGroup(cellToString(nextRow.getCell(counter)));
						} else {
							spe_earningModel.setSpe_excelcheck(false);
							spe_earningModel.setSpe_excelError("Device Type Group is more than 20 character");
						}
						break;		
					case 10:
						try {
							spe_earningModel.setSPE_TxnDate(SPE_convertStringToDate( cellToString(nextRow.getCell(counter))));
						} catch(ParseException e) {
							log.error(e.getMessage());
							spe_earningModel.setSpe_excelcheck(false);
							spe_earningModel.setSpe_excelError("Oreder Date is not valid");
						}
						break;		
					case 11:
						try {
							spe_earningModel.setSPE_TotalSellPrice(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch(NumberFormatException e) {
							log.error(e.getMessage());
							spe_earningModel.setSpe_excelcheck(false);
							spe_earningModel.setSpe_excelError("Total Sell Price is not valid");
						}
						break;		
					case 12:
						try {
							spe_earningModel.setSPE_DisctAmt(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						}catch(NumberFormatException e) {
							log.error(e.getMessage());
							spe_earningModel.setSpe_excelcheck(false);
							spe_earningModel.setSpe_excelError("Discount Amount is not valid");
						}
						break;		
					case 13:
						try {
							spe_earningModel.setSPE_NewCustDisctAmt(Float.parseFloat(cellToString(nextRow.getCell(counter))));
						} catch(NumberFormatException e) {
							log.error(e.getMessage());
							spe_earningModel.setSpe_excelcheck(false);
							spe_earningModel.setSpe_excelError("New Customer Discount Amount is not valid");
						}
						break;		
					case 14:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							spe_earningModel.setSPE_TxnID(cellToString(nextRow.getCell(counter)));
						} else {
							spe_earningModel.setSpe_excelcheck(false);
							spe_earningModel.setSpe_excelError("Transaction ID is more than 30 character");
						}
						break;		
					case 15:
						if (cellToString(nextRow.getCell(counter)).trim().length() <= 30) {
							spe_earningModel.setSPE_AMZ_SELL_TxnRef(cellToString(nextRow.getCell(counter)));
						} else {
							spe_earningModel.setSpe_excelcheck(false);
							spe_earningModel.setSpe_excelError("Amazon Transaction Reference Number is more than 30 character");
						}
						break;		
					}
					
				}
			}
			spe_amazonEarningList.add(spe_earningModel) ;
                  }catch(Exception e){
                	  log.error("Error in Excel Parsing: " + e.getMessage());
                	  throw new RuntimeException("Error in Excel Parsing");
                  }
		}
		return spe_amazonEarningList;
	}
	
	
	

	/**
	 * @param cell
	 * @return
	 */
	private static String cellToString(Cell cell) {
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
	
	
	/**
	 * @param date
	 * @return
	 * @throws ParseException 
	 */
	public static Date SPE_convertStringToDate(String date) throws ParseException {

		Date SPACE_SPLD_currentDate = new Date();
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
		sdf.format(SPACE_SPLD_currentDate);
		String SPACE_date2 = sdf.format(SPACE_SPLD_currentDate);
		SPACE_date2 = date;
		
			SPACE_SPLD_currentDate = sdf.parse(SPACE_date2);
		
		return SPACE_SPLD_currentDate;
	}
}
