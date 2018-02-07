package com.rahul.phmc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * @author rahul Makvana
 * DB connection manager to establish database connection.
 */
public class Payhind_DBManager {

	
	private static Connection phmc_conn;
	/**
	 * use for getting PHMC database connection
	 * 
	 * @return Connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection payhind_getConnection() throws ClassNotFoundException, SQLException{		
		
		//read db properties file
		Properties phmc_prop = PHMC_ConfigFilesReader.phmc_readConfigFiles("payhind-db.properties");
		
		//connection strings
		String phmc_drivers = phmc_prop.getProperty("payhind.jdbc.drive");
        String phmc_connectionURL = phmc_prop.getProperty("payhind.jdbc.url");
        String phmc_username = phmc_prop.getProperty("payhind.jdbc.username");
        String phmc_password = phmc_prop.getProperty("payhind.jdbc.password");
        System.out.println("connection name : "+phmc_drivers+"\t"+phmc_connectionURL+"\t"+phmc_username);
        
        //load driver class
		Class.forName(phmc_drivers);
			
		//establish Connection
		phmc_conn = DriverManager.getConnection(phmc_connectionURL, phmc_username, phmc_password);
			
		//return connection
		return phmc_conn;
		
	}
	
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
	
	
	
	public static int phob_checkIfUserExist(Connection PHMC_conn, long phob_pcoID, String tableName ){
		int PHMC_status=0;
		String whereColumn="";
		
		PreparedStatement PHMC_pst = null;
		ResultSet PHMC_rs = null;
		
		if(tableName.equals("PHMC_PHOB_USER")){
			whereColumn="PHOB_PCOID";
		}else if(tableName.equals("PHMC_PHOB_ONBOARD")){
			whereColumn="PHOB_User";
		}else{
			
		}
		try {
			// prepare statement for query
			PHMC_pst = PHMC_conn
					.prepareStatement("select count(*) from " + tableName + " where "+whereColumn+" = "+phob_pcoID+";" );
			
			// 3. execute the query stmt
			PHMC_rs = PHMC_pst.executeQuery();

			// 4. extract data from the result set:

			while (PHMC_rs.next()) {

				int count = PHMC_rs.getInt(1);
				System.out.println("Count of records" + count);
				if (count > 1) {
					PHMC_status = PHMC_DB_ERROR.PHMC_DUPLICATE_RECORD_FOUND;
				} else if (count == 1) {
					PHMC_status = PHMC_DB_ERROR.PHMC_USER_ALREADY_EXISTS;
				} else {
					PHMC_status = PHMC_DB_ERROR.PHMC_USER_NOT_EXIST;
				}
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			if (PHMC_pst != null)
				try {
					PHMC_pst.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
		}

		return PHMC_status;
		
		
	}
}
