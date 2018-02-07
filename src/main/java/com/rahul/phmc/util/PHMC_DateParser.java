package com.rahul.phmc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author rahul Makvana
 *
 */
public class PHMC_DateParser {
	/**
	 * @param date
	 * @return
	 */
	public static java.util.Date phmc_convertStringToSqlDate(String date) {

		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//format.setTimeZone(TimeZone.getTimeZone("IST"));
		Date parsed;
		java.util.Date sql = null;
		try {
			parsed = format.parse(date);
			sql = new java.util.Date(parsed.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sql;
	}

	/**
	 * @param date
	 * @return
	 */
	public static java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {

		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String SCIDR_date1 = sdf.format(date);

			try {
				date = sdf.parse(SCIDR_date1);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("date1 " + date);

			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			System.out.println("jdj " + sqlDate);
			return sqlDate;
		} else {
			return null;
		}
	}
	
    /**
     * @return
     */
    public static Date getCurrentDate(){
    	
    	Date date =  new Date();
    	SimpleDateFormat  sdf =  new SimpleDateFormat("yyyy-MM-dd");
    	String formatedDate = sdf.format(date);
    	try {
			date = sdf.parse(formatedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return date;
    }
}
