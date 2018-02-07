/*
	* Copyright (C) 2017 Srishti ESDM Pvt Ltd.
	*
	* This file is property of Srishti ESDM Pvt Ltd and must not be copied, reused or distributed
	* without prior approval and agreement with Srishti ESDM Pvt Ltd.
	*
	* This file is allowed only for Srishti internal use and is a confidential property.
	*/
package com.rahul.phmc.spe.roles.service;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.rahul.phmc.spe.roles.model.SPE_Roles_ReadExcelModel;
import com.rahul.phmc.spe.sdp.services.SPE_SDP_GetListOfSettlement;

/**
 * @author rahul makvana this class is service of read data from Excel of PHMC-OPS-ROLES DDMONyyyy.XLSX 
 * 
 */
public class SPE_Roles_ReadExcelService {

	// this is creation of logger so we can check what log created.
	static final Logger log = Logger.getLogger(SPE_Roles_ReadExcelService.class);

	public List<SPE_Roles_ReadExcelModel> spe_getRoleList(InputStream inputstream) {
		List<SPE_Roles_ReadExcelModel> spe_rolesList = new ArrayList<SPE_Roles_ReadExcelModel>();

		Workbook workbook;
		try {
			workbook = new XSSFWorkbook(inputstream);
			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = firstSheet.iterator();

			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				if (nextRow.getRowNum() <= 2) {
					continue; // just skip the rows if row number is 0 or 1
				}

				int maxNoOfCell = firstSheet.getRow(0).getLastCellNum();
				SPE_Roles_ReadExcelModel rolesDetails = new SPE_Roles_ReadExcelModel();

				for (int counter = 0; counter < maxNoOfCell; counter++) {
					if (SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)).trim() != ""
							&& !SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)).trim().isEmpty()) {
						switch (counter) {

						case 0:
							BigDecimal bd1 = new BigDecimal(
									SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							rolesDetails.setSPE_roleCode(bd1.intValue());
							break;
						case 1:
							rolesDetails.setSPE_1(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 2:
							rolesDetails.setSPE_2(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 3:
							rolesDetails.setSPE_3(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 4:
							rolesDetails.setSPE_4(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 5:
							rolesDetails.setSPE_5(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 6:
							rolesDetails.setSPE_6(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 7:
							rolesDetails.setSPE_7(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 8:
							rolesDetails.setSPE_8(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 9:
							rolesDetails.setSPE_9(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 10:
							rolesDetails.setSPE_10(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 11:
							rolesDetails.setSPE_11(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 12:
							rolesDetails.setSPE_12(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 13:
							rolesDetails.setSPE_13(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 14:
							rolesDetails.setSPE_14(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 15:
							rolesDetails.setSPE_15(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 16:
							rolesDetails.setSPE_16(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 17:
							rolesDetails.setSPE_17(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 18:
							rolesDetails.setSPE_18(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 19:
							rolesDetails.setSPE_19(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 20:
							rolesDetails.setSPE_20(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 21:
							rolesDetails.setSPE_21(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 22:
							rolesDetails.setSPE_22(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						case 23:
							rolesDetails.setSPE_23(
									(String) SPE_SDP_GetListOfSettlement.cellToString(nextRow.getCell(counter)));
							break;
						}
					}
				}

				if (rolesDetails.getSPE_roleCode() != null) {
					spe_rolesList.add(rolesDetails);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		log.info(spe_rolesList);
		log.info("List Size is=" + spe_rolesList.size());
		return spe_rolesList;
	}

}
