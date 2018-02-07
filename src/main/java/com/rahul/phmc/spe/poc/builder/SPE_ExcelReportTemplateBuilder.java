/*
	* Copyright (C) 2017 Srishti ESDM Pvt Ltd.
	*
	* This file is property of Srishti ESDM Pvt Ltd and must not be copied, reused or distributed
	* without prior approval and agreement with Srishti ESDM Pvt Ltd.
	*
	* This file is allowed only for Srishti internal use and is a confidential property.
	*/
package com.rahul.phmc.spe.poc.builder;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.rahul.phmc.spe.poc.constant.SPE_StyleAttribute;

public class SPE_ExcelReportTemplateBuilder {
	
	private Workbook workbook;
	private Sheet sheet = null;
	private Row row = null;
	private Integer nextRowIdx = 0;
	private Set<SPE_StyleAttribute> rowStyleAttributes;
	private Integer nextColumnIdx = 0;
	private Map<Set<SPE_StyleAttribute>, CellStyle> styleBank = new HashMap<>();

	/**
	 * Creates new instance.
	 */
	public SPE_ExcelReportTemplateBuilder() {
		workbook = new XSSFWorkbook();
	}

	/**
	 * Starts sheet.
	 *
	 * @param name
	 *            sheet name
	 * @return this instance
	 */
	public SPE_ExcelReportTemplateBuilder startSheet(String name) {
		sheet = workbook.createSheet(name);
		nextRowIdx = 0;
		nextColumnIdx = 0;
		rowStyleAttributes = new HashSet<>();
		return this;
	}

	/**
	 * Sets auto sizing columns.
	 *
	 * @param idx
	 *            column index, starting from 0
	 * @return this instance
	 */
	public SPE_ExcelReportTemplateBuilder setAutoSizeColumn(int idx) {
		sheet.autoSizeColumn(idx);
		return this;
	}

	/**
	 * Sets column size.
	 *
	 * @param idx
	 *            column index, starting from 0
	 * @param m
	 *            number of 'M' standard characters to use for size calculation
	 * @return this instance
	 */
	public SPE_ExcelReportTemplateBuilder setColumnSize(int idx, int m) {
		sheet.setColumnWidth(idx, (m + 1) * 256);
		return this;
	}

	/**
	 * Starts new row.
	 *
	 * @return this instance
	 */
	public SPE_ExcelReportTemplateBuilder startRow() {
		row = sheet.createRow(nextRowIdx);
		nextRowIdx = nextRowIdx + 1;
		nextColumnIdx = 0;
		rowStyleAttributes = new HashSet<>();
		return this;
	}

	/**
	 * @param SPE_StyleAttribute
	 * @return this instance
	 */
	public SPE_ExcelReportTemplateBuilder setRowBorder(SPE_StyleAttribute styleAttribute) {
		guardEquals(0, nextColumnIdx, "must be called before inserting columns");
		row.setRowStyle(getCellStyle(styleAttribute));
		rowStyleAttributes.add(styleAttribute);
		return this;
	}

	/**
	 * Sets row height to capture the title.
	 *
	 * @return this instance
	 */
	public SPE_ExcelReportTemplateBuilder setRowTitleHeight() {
		guardEquals(0, nextColumnIdx, "must be called before inserting columns");
		row.setHeightInPoints(30);
		return this;
	}

	/**
	 * @param text
	 * @param attributes
	 * @return this instance
	 */
	public SPE_ExcelReportTemplateBuilder addTextColumn(String text, SPE_StyleAttribute... attributes) {
		Cell cell = row.createCell(nextColumnIdx);
		CellStyle style = getCellStyle(attributes);
		style.setWrapText(true);
		cell.setCellStyle(style);
		cell.setCellValue(StringUtils.stripToEmpty(text));
		nextColumnIdx = nextColumnIdx + 1;
		return this;
	}

	/**
	 * @param val
	 * @param attributes
	 * @return
	 */
	public SPE_ExcelReportTemplateBuilder addNumberColumn(double val, SPE_StyleAttribute... attributes) {
		Cell cell = row.createCell(nextColumnIdx);
		CellStyle style = getCellStyle(attributes);

		//short format = (short)BuiltinFormats.getBuiltinFormat("#,##0");
		//style.setDataFormat(format);
		cell.setCellStyle(style);
		cell.setCellValue(val);
		nextColumnIdx = nextColumnIdx + 1;
		return this;
	}

	/**
	 * @param val
	 * @param attributes
	 * @return
	 */
	public SPE_ExcelReportTemplateBuilder addDateColumn(Date date, SPE_StyleAttribute... attributes) {
		Cell cell = row.createCell(nextColumnIdx);
		cell.setCellValue(date);
		CreationHelper creationHelper = workbook.getCreationHelper();
		CellStyle cellStyle = getCellStyle(attributes);
		cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dddd dd/mm/yyyy"));
		cell.setCellStyle(cellStyle);
		nextColumnIdx = nextColumnIdx + 1;
		return this;
	}

	/**
	 * Builds the result object. Object cannot be reused after calling this method.
	 *
	 * @return created object
	 */
	public byte[] build() {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			IOUtils.closeQuietly(bos);
			return bos.toByteArray();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Returns cell style.
	 *
	 * @param attrs
	 *            attributes
	 * @return cell style
	 */
	private CellStyle getCellStyle(SPE_StyleAttribute... attrs) {
		Set<SPE_StyleAttribute> allattrs = new HashSet<>();
		allattrs.addAll(rowStyleAttributes);
		allattrs.addAll(Arrays.asList(attrs));
		if (styleBank.containsKey(allattrs)) {
			return styleBank.get(allattrs);
		}
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		style.setFont(font);
		
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		

		for (SPE_StyleAttribute attr : allattrs) {
			switch (attr) {
			case TITLE_SIZE:
				font.setFontHeightInPoints((short) 12);
				break;
			case BOLD:
				font.setBoldweight(Font.BOLDWEIGHT_BOLD);
				break;
			case THIN_TOP_BORDER:
				style.setBorderTop(CellStyle.BORDER_THIN);
				break;
			case THIN_BOTTOM_BORDER:
				style.setBorderBottom(CellStyle.BORDER_THIN);
				break;
			case THICK_TOP_BORDER:
				style.setBorderTop(CellStyle.BORDER_THICK);
				break;
			case THICK_BOTTOM_BORDER:
				style.setBorderBottom(CellStyle.BORDER_THICK);
				break;
			case ALIGN_LEFT:
				style.setAlignment(CellStyle.ALIGN_LEFT);
				break;
			case ALIGN_CENTER:
				style.setAlignment(CellStyle.ALIGN_CENTER);
				break;
			case ALIGN_RIGHT:
				style.setAlignment(CellStyle.ALIGN_RIGHT);
				break;
			case SET_BACKGROUND:
				style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				break;
			default:
				throw new RuntimeException("unknown cell style attribute: " + attr);
			}
		}
		styleBank.put(allattrs, style);
		return style;
	}

	/**
	 * Guards two object to be equal. This is null safe, where two null objects are
	 * considered to be equal.
	 *
	 * @param obj1
	 *            object one
	 * @param obj2
	 *            object two
	 * @param msg
	 *            message to appear in the exception
	 */
	public static void guardEquals(Object obj1, Object obj2, String msg) {
		if (obj1 == obj2) {
			return;
		}
		if (obj1 == null || !obj1.equals(obj2)) {
			throw new IllegalArgumentException("Equality check failed for " + obj1 + " and " + obj2 + ": " + msg);
		}
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
