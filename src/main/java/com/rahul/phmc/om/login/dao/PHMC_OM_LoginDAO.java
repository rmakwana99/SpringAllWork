
package com.rahul.phmc.om.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rahul.phmc.om.login.model.PHMC_OM_LOGIN;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.PHMC_DB_ERROR;
import com.rahul.phmc.util.Payhind_DBManager;
import com.rahul.phmc.util.persistance.PayhindHibernateUtil;

/**
 * @author rahul
 *
 */
public class PHMC_OM_LoginDAO {
	
	static Logger phmc_logeer=LogManager.getLogger(PHMC_OM_LoginDAO.class.getName());
	private Session phmc_om_session;
	private PHMC_OM_LOGIN phmc_om_login;
	private ResultSet phmc_rs;
	private List<PHMC_OM_LOGIN> phmc_om_userList= null;
	
	public List<PHMC_OM_LOGIN> phmc_om_readLoginBySearch(Integer phmc_om_pageStart, Integer phmc_om_size, String whereCluase){
		
		String sql = "SELECT * from PHMC_OM_LOGIN";
		System.out.println("phmc_om_pageStart :" + phmc_om_pageStart + "\n phmc_om_size : " + phmc_om_size);
		if (whereCluase != null && !whereCluase.equals("")) {
			sql = sql + " WHERE " + whereCluase + " ";
		}
		if (phmc_om_pageStart != null && phmc_om_size != null) {
			sql = sql + " ORDER BY PHMC_OM_CreatedDate DESC" + " OFFSET " + phmc_om_size * (phmc_om_pageStart - 1)
					+ " ROWS FETCH NEXT " + phmc_om_size + " ROWS ONLY ";
		}
			System.out.println("sql : " + sql);
			
			try (Connection phmc_mo_con = Payhind_DBManager.payhind_getConnection();
					PreparedStatement phmc_om_pst = phmc_mo_con.prepareStatement(sql)) {


				phmc_om_userList = new ArrayList<PHMC_OM_LOGIN>();
				
					phmc_rs = phmc_om_pst.executeQuery();

					while (phmc_rs.next()) {

						// System.out.println(sopdb_rs.getRow());
						phmc_om_login = new PHMC_OM_LOGIN();

						phmc_om_login.setPHMC_OM_LoginSrNo(phmc_rs.getLong("PHMC_OM_LoginSrNo"));
						phmc_om_login.setPHMC_OM_FirstName(phmc_rs.getString("PHMC_OM_FirstName"));
						phmc_om_login.setPHMC_OM_LastName(phmc_rs.getString("PHMC_OM_LastName"));
						phmc_om_login.setPHMC_OM_Dob(phmc_rs.getDate("PHMC_OM_Dob"));
						phmc_om_login.setPHMC_OM_Email(phmc_rs.getString("PHMC_OM_Email"));
						phmc_om_login.setPHMC_OM_UserName(phmc_rs.getString("PHMC_OM_UserName"));
						phmc_om_login.setPHMC_OM_Password(phmc_rs.getString("PHMC_OM_Password"));
						phmc_om_login.setPHMC_OM_Salt(phmc_rs.getString("PHMC_OM_Salt"));
						phmc_om_login.setPHMC_OM_Lead(phmc_rs.getString("PHMC_OM_Lead"));
						phmc_om_login.setPHMC_OM_OnBoard(phmc_rs.getString("PHMC_OM_OnBoard"));
						phmc_om_login.setPHMC_OM_Billing(phmc_rs.getString("PHMC_OM_Billing"));
						phmc_om_login.setPHMC_OM_Admin(phmc_rs.getString("PHMC_OM_Admin"));
						phmc_om_login.setPHMC_OM_Supervisor(phmc_rs.getString("PHMC_OM_Supervisor"));
						phmc_om_login.setPHMC_OM_UpdatedDate(phmc_rs.getDate("PHMC_OM_UpdatedDate"));
						phmc_om_login.setPHMC_OM_UpdatedBy(phmc_rs.getString("PHMC_OM_UpdatedBy"));
						phmc_om_login.setPHMC_OM_CreatedDate(phmc_rs.getDate("PHMC_OM_CreatedDate"));
						phmc_om_login.setPHMC_OM_PCOStatus(phmc_rs.getString("PHMC_OM_PCOStatus"));
						phmc_om_login.setPHMC_OM_PCOStatusList(phmc_rs.getString("PHMC_OM_PCOStatusList"));
						phmc_om_login.setPHMC_OM_PCOGeneralSearch(phmc_rs.getString("PHMC_OM_PCOGeneralSearch"));
						phmc_om_login.setPHMC_OM_PCOGeneralSearchRange(phmc_rs.getString("PHMC_OM_PCOGeneralSearchRange"));
						phmc_om_login.setPHMC_OM_FutureField1(phmc_rs.getString("PHMC_OM_FutureField1"));
						phmc_om_login.setPHMC_OM_FutureField2(phmc_rs.getString("PHMC_OM_FutureField2"));
						phmc_om_login.setPHMC_OM_RoleCode(phmc_rs.getInt("PHMC_OM_RoleCode"));
						phmc_om_login.setPHMC_OM_Address1(phmc_rs.getString("PHMC_OM_Address1"));
						phmc_om_login.setPHMC_OM_Address2(phmc_rs.getString("PHMC_OM_Address2"));
						phmc_om_login.setPHMC_OM_Address3(phmc_rs.getString("PHMC_OM_Address3"));
						phmc_om_login.setPHMC_OM_City(phmc_rs.getString("PHMC_OM_City"));
						phmc_om_login.setPHMC_OM_State(phmc_rs.getString("PHMC_OM_State"));
						phmc_om_login.setPHMC_OM_Pincode(phmc_rs.getInt("PHMC_OM_Pincode"));
						phmc_om_login.setPHMC_OM_Phone(phmc_rs.getLong("PHMC_OM_Phone"));
						phmc_om_login.setPHMC_OM_CreatedBy(phmc_rs.getString("PHMC_OM_CreatedBy"));
						phmc_om_login.setPHMC_OM_ActiveStatus(phmc_rs.getInt("PHMC_OM_ActiveStatus"));
						phmc_om_login.setPHMC_OM_EffectiveDate(phmc_rs.getDate("PHMC_OM_EffectiveDate"));
						phmc_om_login.setPHMC_OM_EffectiveEndDate(phmc_rs.getDate("PHMC_OM_EffectiveEndDate"));
						
						
						phmc_om_userList.add(phmc_om_login);
					}
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				

		return phmc_om_userList;
		
	}
public List<PHMC_OM_LOGIN> phmc_om_readDistributer(Integer phmc_om_pageStart, Integer phmc_om_size, String whereCluase){
		
	String sql = "SELECT * from PHMC_OM_LOGIN";
	System.out.println("phmc_om_pageStart :" + phmc_om_pageStart + "\n phmc_om_size : " + phmc_om_size);
	if (whereCluase != null && !whereCluase.equals("")) {
		sql = sql + " WHERE " + whereCluase + " ";
	}
	if (phmc_om_pageStart != null && phmc_om_size != null) {
		sql = sql + " ORDER BY PHMC_OM_CreatedDate DESC" + " OFFSET " + phmc_om_size * (phmc_om_pageStart - 1)
				+ " ROWS FETCH NEXT " + phmc_om_size + " ROWS ONLY ";
	}
		System.out.println("sql : " + sql);
		
		try (Connection phmc_mo_con = Payhind_DBManager.payhind_getConnection();
				PreparedStatement phmc_om_pst = phmc_mo_con.prepareStatement(sql)) {


			phmc_om_userList = new ArrayList<PHMC_OM_LOGIN>();
			
				phmc_rs = phmc_om_pst.executeQuery();

				while (phmc_rs.next()) {

					// System.out.println(sopdb_rs.getRow());
					phmc_om_login = new PHMC_OM_LOGIN();

					phmc_om_login.setPHMC_OM_LoginSrNo(phmc_rs.getLong("PHMC_OM_LoginSrNo"));
					phmc_om_login.setPHMC_OM_FirstName(phmc_rs.getString("PHMC_OM_FirstName"));
					phmc_om_login.setPHMC_OM_LastName(phmc_rs.getString("PHMC_OM_LastName"));
					phmc_om_login.setPHMC_OM_Dob(phmc_rs.getDate("PHMC_OM_Dob"));
					phmc_om_login.setPHMC_OM_Email(phmc_rs.getString("PHMC_OM_Email"));
					phmc_om_login.setPHMC_OM_UserName(phmc_rs.getString("PHMC_OM_UserName"));
					phmc_om_login.setPHMC_OM_Password(phmc_rs.getString("PHMC_OM_Password"));
					phmc_om_login.setPHMC_OM_Salt(phmc_rs.getString("PHMC_OM_Salt"));
					phmc_om_login.setPHMC_OM_Lead(phmc_rs.getString("PHMC_OM_Lead"));
					phmc_om_login.setPHMC_OM_OnBoard(phmc_rs.getString("PHMC_OM_OnBoard"));
					phmc_om_login.setPHMC_OM_Billing(phmc_rs.getString("PHMC_OM_Billing"));
					phmc_om_login.setPHMC_OM_Admin(phmc_rs.getString("PHMC_OM_Admin"));
					phmc_om_login.setPHMC_OM_Supervisor(phmc_rs.getString("PHMC_OM_Supervisor"));
					phmc_om_login.setPHMC_OM_UpdatedDate(phmc_rs.getDate("PHMC_OM_UpdatedDate"));
					phmc_om_login.setPHMC_OM_UpdatedBy(phmc_rs.getString("PHMC_OM_UpdatedBy"));
					phmc_om_login.setPHMC_OM_CreatedDate(phmc_rs.getDate("PHMC_OM_CreatedDate"));
					phmc_om_login.setPHMC_OM_PCOStatus(phmc_rs.getString("PHMC_OM_PCOStatus"));
					phmc_om_login.setPHMC_OM_PCOStatusList(phmc_rs.getString("PHMC_OM_PCOStatusList"));
					phmc_om_login.setPHMC_OM_PCOGeneralSearch(phmc_rs.getString("PHMC_OM_PCOGeneralSearch"));
					phmc_om_login.setPHMC_OM_PCOGeneralSearchRange(phmc_rs.getString("PHMC_OM_PCOGeneralSearchRange"));
					phmc_om_login.setPHMC_OM_FutureField1(phmc_rs.getString("PHMC_OM_FutureField1"));
					phmc_om_login.setPHMC_OM_FutureField2(phmc_rs.getString("PHMC_OM_FutureField2"));
					phmc_om_login.setPHMC_OM_RoleCode(phmc_rs.getInt("PHMC_OM_RoleCode"));
					phmc_om_login.setPHMC_OM_Address1(phmc_rs.getString("PHMC_OM_Address1"));
					phmc_om_login.setPHMC_OM_Address2(phmc_rs.getString("PHMC_OM_Address2"));
					phmc_om_login.setPHMC_OM_Address3(phmc_rs.getString("PHMC_OM_Address3"));
					phmc_om_login.setPHMC_OM_City(phmc_rs.getString("PHMC_OM_City"));
					phmc_om_login.setPHMC_OM_State(phmc_rs.getString("PHMC_OM_State"));
					phmc_om_login.setPHMC_OM_Pincode(phmc_rs.getInt("PHMC_OM_Pincode"));
					phmc_om_login.setPHMC_OM_Phone(phmc_rs.getLong("PHMC_OM_Phone"));
					phmc_om_login.setPHMC_OM_CreatedBy(phmc_rs.getString("PHMC_OM_CreatedBy"));
					phmc_om_login.setPHMC_OM_ActiveStatus(phmc_rs.getInt("PHMC_OM_ActiveStatus"));
					phmc_om_login.setPHMC_OM_EffectiveDate(phmc_rs.getDate("PHMC_OM_EffectiveDate"));
					phmc_om_login.setPHMC_OM_EffectiveEndDate(phmc_rs.getDate("PHMC_OM_EffectiveEndDate"));
					
					phmc_om_login.setPHMC_OM_PrimaryBankName(phmc_rs.getString("PHMC_OM_PrimaryBankName")); 
					phmc_om_login.setPHMC_OM_PrimaryBankAcountNo(phmc_rs.getLong("PHMC_OM_PrimaryBankAcountNo")); 
					phmc_om_login.setPHMC_OM_PrimaryBankBranchName(phmc_rs.getString("PHMC_OM_PrimaryBankBranchName")); 
					phmc_om_login.setPHMC_OM_PrimaryBankAccountType(phmc_rs.getString("PHMC_OM_PrimaryBankAccountType"));
					phmc_om_login.setPHMC_OM_PrimaryIFSCCode(phmc_rs.getString("PHMC_OM_PrimaryIFSCCode")); 
					phmc_om_login.setPHMC_OM_PrimaryBankLinkedAadhaarNo(phmc_rs.getLong("PHMC_OM_PrimaryBankLinkedAadhaarNo")); 
					phmc_om_login.setPHMC_OM_PrimaryBankVPA(phmc_rs.getString("PHMC_OM_PrimaryBankVPA")); 
					phmc_om_login.setPHMC_OM_SecondaryBankName(phmc_rs.getString("PHMC_OM_SecondaryBankName")); 
					phmc_om_login.setPHMC_OM_SecondaryBankAcountNo(phmc_rs.getLong("PHMC_OM_SecondaryBankAcountNo")); 
					phmc_om_login.setPHMC_OM_SecondaryBankBranchName(phmc_rs.getString("PHMC_OM_SecondaryBankBranchName")); 
					phmc_om_login.setPHMC_OM_SecondaryBankAccountType(phmc_rs.getString("PHMC_OM_SecondaryBankAccountType")); 
					phmc_om_login.setPHMC_OM_SecondaryIFSCCode(phmc_rs.getString("PHMC_OM_SecondaryIFSCCode")); ;
					phmc_om_login.setPHMC_OM_SecondaryBankLinkedAadhaarNo(phmc_rs.getLong("PHMC_OM_SecondaryBankLinkedAadhaarNo")); 
					phmc_om_login.setPHMC_OM_SecondaryBankVPA(phmc_rs.getString("PHMC_OM_SecondaryBankVPA")); 
					phmc_om_login.setPHMC_OM_PANCardNo(phmc_rs.getString("PHMC_OM_PANCardNo")); 
					phmc_om_login.setPHMC_OM_AadhaarNo(phmc_rs.getLong("PHMC_OM_AadhaarNo")); 
					
					String phmc_whereClause = "PHMC_OM_UserName= '" + phmc_om_login.getPHMC_OM_UserName() +"'";
					phmc_om_login.setPHMC_OM_TotalPCO(this.phmc_om_getTotalPCOForDistributer(phmc_mo_con, phmc_whereClause));
					phmc_om_userList.add(phmc_om_login);
				}
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		return phmc_om_userList;
	}

   /**
    * Getting total number of PCO for one Distributer
 * @param conn
 * @param whereCluse
 * @return
 * @throws SQLException
 */
public Integer phmc_om_getTotalPCOForDistributer(Connection conn, String whereCluse) throws SQLException{
	   Integer PHMC_OM_TotalPCO = 0;
	   
	   String sql = "SELECT  COUNT(PHMC_PHOB_USER.PHOB_UserSrNo)FROM PHMC_PHOB_USER "
	   		+ "LEFT JOIN PHMC_OM_LOGIN ON PHMC_PHOB_USER.PHOB_DIST_ID = PHMC_OM_LOGIN.PHMC_OM_UserName ";
	   if (whereCluse != null && !whereCluse.equals("")) {
			sql = sql + " WHERE " + whereCluse + " ";
		}
	   System.out.println("Count SQL :" + sql);
	   PreparedStatement phmc_om_pst = conn.prepareStatement(sql);
	   ResultSet phmc_om_rs = phmc_om_pst.executeQuery(); 

		while (phmc_om_rs.next()) {
			PHMC_OM_TotalPCO = phmc_om_rs.getInt(1);
		}
		
		return PHMC_OM_TotalPCO;
   }
	/**
	 * @param phmc_om_userName
	 * @return phmc_om_login this method is for read data from PHMC_OM_LOGIN
	 *         Table for particular UserName.
	 */
	public PHMC_OM_LOGIN phmc_om_readLoginDetail(String phmc_om_userName) {

		String sopdb_selectQuary = "SELECT  * FROM PHMC_OM_LOGIN WHERE PHMC_OM_UserName = ?";

		// get Database Connection
		try (Connection sopdb_conn = Payhind_DBManager.payhind_getConnection();
				PreparedStatement sopdb_pst = sopdb_conn.prepareStatement(sopdb_selectQuary)) {

			sopdb_pst.setString(1, phmc_om_userName);

			phmc_rs = sopdb_pst.executeQuery();

			while (phmc_rs.next()) {

				// System.out.println(sopdb_rs.getRow());
				phmc_om_login = new PHMC_OM_LOGIN();

				phmc_om_login.setPHMC_OM_LoginSrNo(phmc_rs.getLong("PHMC_OM_LoginSrNo"));
				phmc_om_login.setPHMC_OM_FirstName(phmc_rs.getString("PHMC_OM_FirstName"));
				phmc_om_login.setPHMC_OM_LastName(phmc_rs.getString("PHMC_OM_LastName"));
				phmc_om_login.setPHMC_OM_Dob(phmc_rs.getDate("PHMC_OM_Dob"));
				phmc_om_login.setPHMC_OM_Email(phmc_rs.getString("PHMC_OM_Email"));
				phmc_om_login.setPHMC_OM_UserName(phmc_rs.getString("PHMC_OM_UserName"));
				phmc_om_login.setPHMC_OM_Password(phmc_rs.getString("PHMC_OM_Password"));
				phmc_om_login.setPHMC_OM_Salt(phmc_rs.getString("PHMC_OM_Salt"));
				phmc_om_login.setPHMC_OM_Lead(phmc_rs.getString("PHMC_OM_Lead"));
				phmc_om_login.setPHMC_OM_OnBoard(phmc_rs.getString("PHMC_OM_OnBoard"));
				phmc_om_login.setPHMC_OM_Billing(phmc_rs.getString("PHMC_OM_Billing"));
				phmc_om_login.setPHMC_OM_Admin(phmc_rs.getString("PHMC_OM_Admin"));
				phmc_om_login.setPHMC_OM_Supervisor(phmc_rs.getString("PHMC_OM_Supervisor"));
				phmc_om_login.setPHMC_OM_UpdatedDate(phmc_rs.getDate("PHMC_OM_UpdatedDate"));
				phmc_om_login.setPHMC_OM_UpdatedBy(phmc_rs.getString("PHMC_OM_UpdatedBy"));
				phmc_om_login.setPHMC_OM_CreatedDate(phmc_rs.getDate("PHMC_OM_CreatedDate"));
				phmc_om_login.setPHMC_OM_PCOStatus(phmc_rs.getString("PHMC_OM_PCOStatus"));
				phmc_om_login.setPHMC_OM_PCOStatusList(phmc_rs.getString("PHMC_OM_PCOStatusList"));
				phmc_om_login.setPHMC_OM_PCOGeneralSearch(phmc_rs.getString("PHMC_OM_PCOGeneralSearch"));
				phmc_om_login.setPHMC_OM_PCOGeneralSearchRange(phmc_rs.getString("PHMC_OM_PCOGeneralSearchRange"));
				phmc_om_login.setPHMC_OM_FutureField1(phmc_rs.getString("PHMC_OM_FutureField1"));
				phmc_om_login.setPHMC_OM_FutureField2(phmc_rs.getString("PHMC_OM_FutureField2"));
				phmc_om_login.setPHMC_OM_RoleCode(phmc_rs.getInt("PHMC_OM_RoleCode"));
				phmc_om_login.setPHMC_OM_Address1(phmc_rs.getString("PHMC_OM_Address1"));
				phmc_om_login.setPHMC_OM_Address2(phmc_rs.getString("PHMC_OM_Address2"));
				phmc_om_login.setPHMC_OM_Address3(phmc_rs.getString("PHMC_OM_Address3"));
				phmc_om_login.setPHMC_OM_City(phmc_rs.getString("PHMC_OM_City"));
				phmc_om_login.setPHMC_OM_State(phmc_rs.getString("PHMC_OM_State"));
				phmc_om_login.setPHMC_OM_Pincode(phmc_rs.getInt("PHMC_OM_Pincode"));
				phmc_om_login.setPHMC_OM_Phone(phmc_rs.getLong("PHMC_OM_Phone"));
				phmc_om_login.setPHMC_OM_CreatedBy(phmc_rs.getString("PHMC_OM_CreatedBy"));
				phmc_om_login.setPHMC_OM_ActiveStatus(phmc_rs.getInt("PHMC_OM_ActiveStatus"));
				phmc_om_login.setPHMC_OM_EffectiveDate(phmc_rs.getDate("PHMC_OM_EffectiveDate"));
				phmc_om_login.setPHMC_OM_EffectiveEndDate(phmc_rs.getDate("PHMC_OM_EffectiveEndDate"));
				
				phmc_om_login.setPHMC_OM_PrimaryBankName(phmc_rs.getString("PHMC_OM_PrimaryBankName"));
				phmc_om_login.setPHMC_OM_PrimaryBankAcountNo(phmc_rs.getLong("PHMC_OM_PrimaryBankAcountNo"));
				phmc_om_login.setPHMC_OM_PrimaryBankBranchName(phmc_rs.getString("PHMC_OM_PrimaryBankBranchName"));
				phmc_om_login.setPHMC_OM_PrimaryBankAccountType(phmc_rs.getString("PHMC_OM_PrimaryBankAccountType"));
				phmc_om_login.setPHMC_OM_PrimaryIFSCCode(phmc_rs.getString("PHMC_OM_PrimaryIFSCCode"));
				phmc_om_login.setPHMC_OM_PrimaryBankLinkedAadhaarNo(phmc_rs.getLong("PHMC_OM_PrimaryBankLinkedAadhaarNo"));
				phmc_om_login.setPHMC_OM_PrimaryBankVPA(phmc_rs.getString("PHMC_OM_PrimaryBankVPA"));
				phmc_om_login.setPHMC_OM_SecondaryBankName(phmc_rs.getString("PHMC_OM_SecondaryBankName"));
				phmc_om_login.setPHMC_OM_SecondaryBankAcountNo(phmc_rs.getLong("PHMC_OM_SecondaryBankAcountNo"));
				phmc_om_login.setPHMC_OM_SecondaryBankBranchName(phmc_rs.getString("PHMC_OM_SecondaryBankBranchName"));
				phmc_om_login.setPHMC_OM_SecondaryBankAccountType(phmc_rs.getString("PHMC_OM_SecondaryBankAccountType"));
				phmc_om_login.setPHMC_OM_SecondaryIFSCCode(phmc_rs.getString("PHMC_OM_SecondaryIFSCCode"));
				phmc_om_login.setPHMC_OM_SecondaryBankLinkedAadhaarNo(phmc_rs.getLong("PHMC_OM_SecondaryBankLinkedAadhaarNo"));
				phmc_om_login.setPHMC_OM_SecondaryBankVPA(phmc_rs.getString("PHMC_OM_SecondaryBankVPA"));
				phmc_om_login.setPHMC_OM_PANCardNo(phmc_rs.getString("PHMC_OM_PANCardNo"));
				phmc_om_login.setPHMC_OM_AadhaarNo(phmc_rs.getLong("PHMC_OM_AadhaarNo"));			
				
				
				

			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return phmc_om_login;

	}

	/**
	 * @param phmc_om_login
	 * @return
	 */
	public ErrorMessage phmc_om_createLoginDetail(PHMC_OM_LOGIN phmc_om_login) {
		ErrorMessage msg = new ErrorMessage();
		Session session = PayhindHibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(phmc_om_login);
			transaction.commit();

			msg.setErrorCode(PHMC_DB_ERROR.PHMC_SUCCESS);
			msg.setErrorMessage("Login with ID " + phmc_om_login.getPHMC_OM_UserName() + " Created Successfully");
		}catch(org.hibernate.exception.ConstraintViolationException ex){
			transaction.rollback();
			transaction.rollback();
			msg.setErrorCode(PHMC_DB_ERROR.PHMC_USER_ALREADY_EXISTS);
			msg.setErrorMessage("Login with ID " + phmc_om_login.getPHMC_OM_UserName() + " Already Exist");
			ex.printStackTrace();
		}catch(Exception ex){
			transaction.rollback();
			msg.setErrorCode(PHMC_DB_ERROR.PHMC_INSERT_FAILED);
			msg.setErrorMessage("Login with ID " + phmc_om_login.getPHMC_OM_UserName() + " Creation Failed");
			ex.printStackTrace();
		}finally {
		
			session.close();
		}

		return msg;
	}

	/*
	 * public ErrorMessage phmc_om_updateLoginDetail(String phmc_om_userName,
	 * PHMC_OM_LOGIN phmc_om_login) { ErrorMessage msg = new ErrorMessage();
	 * Session session = PayhindHibernateUtil.getSessionFactory().openSession();
	 * Transaction transaction = null;
	 * 
	 * try { transaction = session.beginTransaction();
	 * session.update(phmc_om_login); transaction.commit();
	 * 
	 * msg.setErrorCode(PHMC_DB_ERROR.PHMC_SUCCESS); msg.setErrorMessage(
	 * "Login with ID " + phmc_om_login.getPHMC_OM_UserName() +
	 * " Updated Successfully");
	 * 
	 * } catch (HibernateException e) { transaction.rollback();
	 * msg.setErrorCode(PHMC_DB_ERROR.PHMC_UPDATE_FAILED); msg.setErrorMessage(
	 * "Login with ID " + phmc_om_login.getPHMC_OM_UserName() +
	 * " Updation Failed"); e.printStackTrace(); } finally {
	 * 
	 * session.close(); PayhindHibernateUtil.shutdown(); }
	 * 
	 * return msg; }
	 */

	public ErrorMessage phmc_om_updateLoginDetail(String phmc_om_userName, PHMC_OM_LOGIN phmc_om_login) {

		int isUpdateSuccess = 0;
		Connection PHMC_conn = null;
		PreparedStatement PHMC_pst = null;
		String setter = "";

		ErrorMessage msg = new ErrorMessage();

		if (phmc_om_login != null) {

			try {
				PHMC_conn = Payhind_DBManager.payhind_getConnection();

				setter = setterForUpdateUser(phmc_om_login);

				PHMC_conn.setAutoCommit(false);

				PHMC_pst = PHMC_conn.prepareStatement(
						"UPDATE PHMC_OM_LOGIN SET " + setter + " WHERE PHMC_OM_UserName='" + phmc_om_userName + "';");

				isUpdateSuccess = PHMC_pst.executeUpdate();

				msg.setErrorCode(PHMC_DB_ERROR.PHMC_SUCCESS);
				msg.setErrorMessage("PCO with ID " + phmc_om_userName + " Updated Successfully");
				PHMC_conn.commit();

			} catch (ClassNotFoundException e) {
				isUpdateSuccess = PHMC_DB_ERROR.PHMC_SCFG_FILE_NOT_FOUND;
				msg.setErrorCode(PHMC_DB_ERROR.PHMC_SCFG_FILE_NOT_FOUND);
				msg.setErrorMessage("PCO with ID " + phmc_om_userName + " Not Found");
				e.printStackTrace();
			} catch (SQLException e) {
				isUpdateSuccess = PHMC_DB_ERROR.PHMC_UPDATE_FAILED;
				msg.setErrorCode(PHMC_DB_ERROR.PHMC_UPDATE_FAILED);
				msg.setErrorMessage("PCO with ID " + phmc_om_userName + " Updation Failed");
				e.printStackTrace();
			} finally {
				if (PHMC_pst != null) {
					try {
						PHMC_pst.close();
						PHMC_conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

		}

		System.out.println("Ststus code is=" + msg.getErrorMessage());
		return msg;

	}

	/**
	 * @author rahul makvana
	 * @param phmc_om_login
	 * @return setter
	 */
	private String setterForUpdateUser(PHMC_OM_LOGIN phmc_om_login) {
		String setter = null;

		if (phmc_om_login.getPHMC_OM_FirstName() != null)
			setter = "PHMC_OM_FirstName='" + phmc_om_login.getPHMC_OM_FirstName() + "' ";
		if (phmc_om_login.getPHMC_OM_LastName() != null) {
			if (setter == null) {
				setter = "PHMC_OM_LastName ='" + phmc_om_login.getPHMC_OM_LastName() + "'";
			} else
				setter += ", PHMC_OM_LastName ='" + phmc_om_login.getPHMC_OM_LastName() + "'";
		}
		if (phmc_om_login.getPHMC_OM_Dob() != null) {
			if (setter == null) {
				setter = "PHMC_OM_Dob ='" + Payhind_DBManager.convertJavaDateToSqlDate(phmc_om_login.getPHMC_OM_Dob()) + "'";
			} else
				setter += ", PHMC_OM_Dob ='" + Payhind_DBManager.convertJavaDateToSqlDate(phmc_om_login.getPHMC_OM_Dob()) + "'";
		}
		if (phmc_om_login.getPHMC_OM_Email() != null) {
			if (setter == null) {
				setter = "PHMC_OM_Email ='" + phmc_om_login.getPHMC_OM_Email() + "'";
			} else
				setter += ", PHMC_OM_Email ='" + phmc_om_login.getPHMC_OM_Email() + "'";
		}
		if (phmc_om_login.getPHMC_OM_Password() != null) {
			if (setter == null) {
				setter = "PHMC_OM_Password ='" + phmc_om_login.getPHMC_OM_Password() + "'";
			} else
				setter += ", PHMC_OM_Password ='" + phmc_om_login.getPHMC_OM_Password() + "'";
		}
		if (phmc_om_login.getPHMC_OM_Salt() != null) {
			if (setter == null) {
				setter = "PHMC_OM_Salt ='" + phmc_om_login.getPHMC_OM_Salt() + "'";
			} else
				setter += ", PHMC_OM_Salt ='" + phmc_om_login.getPHMC_OM_Salt() + "'";
		}
		if (phmc_om_login.getPHMC_OM_Lead() != null) {
			if (setter == null) {
				setter = "PHMC_OM_Lead ='" + phmc_om_login.getPHMC_OM_Lead() + "'";
			} else
				setter += ", PHMC_OM_Lead ='" + phmc_om_login.getPHMC_OM_Lead() + "'";
		}
		if (phmc_om_login.getPHMC_OM_OnBoard() != null) {
			if (setter == null) {
				setter = "PHMC_OM_OnBoard ='" + phmc_om_login.getPHMC_OM_OnBoard() + "'";
			} else
				setter += ", PHMC_OM_OnBoard ='" + phmc_om_login.getPHMC_OM_OnBoard() + "'";
		}

		if (phmc_om_login.getPHMC_OM_Billing() != null) {
			if (setter == null) {
				setter = "PHMC_OM_Billing ='" + phmc_om_login.getPHMC_OM_Billing() + "'";
			} else
				setter += ", PHMC_OM_Billing ='" + phmc_om_login.getPHMC_OM_Billing() + "'";
		}
		if (phmc_om_login.getPHMC_OM_Admin() != null) {
			if (setter == null) {
				setter = "PHMC_OM_Admin ='" + phmc_om_login.getPHMC_OM_Admin() + "'";
			} else
				setter += ", PHMC_OM_Admin ='" + phmc_om_login.getPHMC_OM_Admin() + "'";
		}
		if (phmc_om_login.getPHMC_OM_Supervisor() != null) {
			if (setter == null) {
				setter = "PHMC_OM_Supervisor ='" + phmc_om_login.getPHMC_OM_Supervisor() + "'";
			} else
				setter += ", PHMC_OM_Supervisor ='" + phmc_om_login.getPHMC_OM_Supervisor() + "'";
		}
		if (phmc_om_login.getPHMC_OM_UpdatedDate() != null) {
			if (setter == null) {
				setter = "PHMC_OM_UpdatedDate ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(phmc_om_login.getPHMC_OM_UpdatedDate()) + "'";
			} else
				setter += ", PHMC_OM_UpdatedDate ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(phmc_om_login.getPHMC_OM_UpdatedDate()) + "'";
		}

		if (phmc_om_login.getPHMC_OM_UpdatedBy() != null) {
			if (setter == null) {
				setter = "PHMC_OM_UpdatedBy ='" + phmc_om_login.getPHMC_OM_UpdatedBy() + "'";
			} else
				setter += ", PHMC_OM_UpdatedBy ='" + phmc_om_login.getPHMC_OM_UpdatedBy() + "'";
		}
		if (phmc_om_login.getPHMC_OM_CreatedDate() != null) {
			if (setter == null) {
				setter = "PHMC_OM_CreatedDate ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(phmc_om_login.getPHMC_OM_CreatedDate()) + "'";
			} else
				setter += ", PHMC_OM_CreatedDate ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(phmc_om_login.getPHMC_OM_CreatedDate()) + "'";
		}
		if (phmc_om_login.getPHMC_OM_PCOStatus() != null) {
			if (setter == null) {
				setter = "PHMC_OM_PCOStatus ='" + phmc_om_login.getPHMC_OM_PCOStatus() + "'";
			} else
				setter += ", PHMC_OM_PCOStatus ='" + phmc_om_login.getPHMC_OM_PCOStatus() + "'";
		}
		if (phmc_om_login.getPHMC_OM_PCOStatusList() != null) {
			if (setter == null) {
				setter = "PHMC_OM_PCOStatusList ='" + phmc_om_login.getPHMC_OM_PCOStatusList() + "'";
			} else
				setter += ", PHMC_OM_PCOStatusList ='" + phmc_om_login.getPHMC_OM_PCOStatusList() + "'";
		}
		if (phmc_om_login.getPHMC_OM_PCOGeneralSearch() != null) {
			if (setter == null) {
				setter = "PHMC_OM_PCOGeneralSearch ='" + phmc_om_login.getPHMC_OM_PCOGeneralSearch() + "'";
			} else
				setter += ", PHMC_OM_PCOGeneralSearch ='" + phmc_om_login.getPHMC_OM_PCOGeneralSearch() + "'";
		}
		if (phmc_om_login.getPHMC_OM_PCOGeneralSearchRange() != null) {
			if (setter == null) {
				setter = "PHMC_OM_PCOGeneralSearchRange ='" + phmc_om_login.getPHMC_OM_PCOGeneralSearchRange() + "'";
			} else
				setter += ", PHMC_OM_PCOGeneralSearchRange ='" + phmc_om_login.getPHMC_OM_PCOGeneralSearchRange() + "'";
		}

		if (phmc_om_login.getPHMC_OM_FutureField1() != null) {
			if (setter == null) {
				setter = "PHMC_OM_FutureField1 ='" + phmc_om_login.getPHMC_OM_FutureField1() + "'";
			} else
				setter += ", PHMC_OM_FutureField1 ='" + phmc_om_login.getPHMC_OM_FutureField1() + "'";
		}
		if (phmc_om_login.getPHMC_OM_FutureField2() != null) {
			if (setter == null) {
				setter = "PHMC_OM_FutureField2 ='" + phmc_om_login.getPHMC_OM_FutureField2() + "'";
			} else
				setter += ", PHMC_OM_FutureField2 ='" + phmc_om_login.getPHMC_OM_FutureField2() + "'";
		}
		
		
		
		if (phmc_om_login.getPHMC_OM_RoleCode () != null) {
			if (setter == null) {
				setter = "PHMC_OM_RoleCode  ='" + phmc_om_login.getPHMC_OM_RoleCode() + "'";
			} else
				setter += ", PHMC_OM_RoleCode  ='" + phmc_om_login.getPHMC_OM_RoleCode() + "'";
		}
		if (phmc_om_login.getPHMC_OM_Address1() != null) {
			if (setter == null) {
				setter = "PHMC_OM_Address1 ='" + phmc_om_login.getPHMC_OM_Address1() + "'";
			} else
				setter += ", PHMC_OM_Address1 ='" + phmc_om_login.getPHMC_OM_Address1() + "'";
		}
		if (phmc_om_login.getPHMC_OM_Address2() != null) {
			if (setter == null) {
				setter = "PHMC_OM_Address2 ='" + phmc_om_login.getPHMC_OM_Address2() + "'";
			} else
				setter += ", PHMC_OM_Address2 ='" + phmc_om_login.getPHMC_OM_Address2() + "'";
		}	
		if (phmc_om_login.getPHMC_OM_Address3() != null) {
			if (setter == null) {
				setter = "PHMC_OM_Address3 ='" + phmc_om_login.getPHMC_OM_Address3() + "'";
			} else
				setter += ", PHMC_OM_Address3 ='" + phmc_om_login.getPHMC_OM_Address3() + "'";
		}	
		if (phmc_om_login.getPHMC_OM_City() != null) {
			if (setter == null) {
				setter = "PHMC_OM_City ='" + phmc_om_login.getPHMC_OM_City() + "'";
			} else
				setter += ", PHMC_OM_City ='" + phmc_om_login.getPHMC_OM_City() + "'";
		}
		if (phmc_om_login.getPHMC_OM_State() != null) {
			if (setter == null) {
				setter = "PHMC_OM_State ='" + phmc_om_login.getPHMC_OM_State() + "'";
			} else
				setter += ", PHMC_OM_State ='" + phmc_om_login.getPHMC_OM_State() + "'";
		}
		if (phmc_om_login.getPHMC_OM_Pincode() != null) {
			if (setter == null) {
				setter = "PHMC_OM_Pincode  ='" + phmc_om_login.getPHMC_OM_Pincode() + "'";
			} else
				setter += ", PHMC_OM_Pincode  ='" + phmc_om_login.getPHMC_OM_Pincode() + "'";
		}
		if (phmc_om_login.getPHMC_OM_Phone() != null) {
			if (setter == null) {
				setter = "PHMC_OM_Phone  ='" + phmc_om_login.getPHMC_OM_Phone() + "'";
			} else
				setter += ", PHMC_OM_Phone  ='" + phmc_om_login.getPHMC_OM_Phone() + "'";
		}
		if (phmc_om_login.getPHMC_OM_CreatedBy() != null) {
			if (setter == null) {
				setter = "PHMC_OM_CreatedBy  ='" + phmc_om_login.getPHMC_OM_CreatedBy() + "'";
			} else
				setter += ", PHMC_OM_CreatedBy  ='" + phmc_om_login.getPHMC_OM_CreatedBy() + "'";
		}
		if (phmc_om_login.getPHMC_OM_ActiveStatus() != null) {
			if (setter == null) {
				setter = "PHMC_OM_ActiveStatus  ='" + phmc_om_login.getPHMC_OM_ActiveStatus() + "'";
			} else
				setter += ", PHMC_OM_ActiveStatus  ='" + phmc_om_login.getPHMC_OM_ActiveStatus() + "'";
		}		
		
		if (phmc_om_login.getPHMC_OM_EffectiveDate() != null) {
			if (setter == null) {
				setter = "PHMC_OM_EffectiveDate  ='" + Payhind_DBManager.convertJavaDateToSqlDate(phmc_om_login.getPHMC_OM_EffectiveDate()) + "'";
			} else
				setter += ", PHMC_OM_EffectiveDate  ='" + Payhind_DBManager.convertJavaDateToSqlDate(phmc_om_login.getPHMC_OM_EffectiveDate()) + "'";
		}
		if (phmc_om_login.getPHMC_OM_EffectiveEndDate() != null) {
			if (setter == null) {
				setter = "PHMC_OM_EffectiveEndDate  ='" + Payhind_DBManager.convertJavaDateToSqlDate(phmc_om_login.getPHMC_OM_EffectiveEndDate()) + "'";
			} else
				setter += ", PHMC_OM_EffectiveEndDate  ='" + Payhind_DBManager.convertJavaDateToSqlDate(phmc_om_login.getPHMC_OM_EffectiveEndDate()) + "'";
		}
		
		if (phmc_om_login.getPHMC_OM_PrimaryBankName() != null) {
			if (setter == null) {
				setter = "PHMC_OM_PrimaryBankName  ='" + phmc_om_login.getPHMC_OM_PrimaryBankName() + "'";
			} else
				setter += ", PHMC_OM_PrimaryBankName  ='" + phmc_om_login.getPHMC_OM_PrimaryBankName() + "'";
		}
		if (phmc_om_login.getPHMC_OM_PrimaryBankAcountNo() != null) {
			if (setter == null) {
				setter = "PHMC_OM_PrimaryBankAcountNo  ='" + phmc_om_login.getPHMC_OM_PrimaryBankAcountNo() + "'";
			} else
				setter += ", PHMC_OM_PrimaryBankAcountNo  ='" + phmc_om_login.getPHMC_OM_PrimaryBankAcountNo() + "'";
		}
		if (phmc_om_login.getPHMC_OM_PrimaryBankBranchName() != null) {
			if (setter == null) {
				setter = "PHMC_OM_PrimaryBankBranchName  ='" + phmc_om_login.getPHMC_OM_PrimaryBankBranchName() + "'";
			} else
				setter += ", PHMC_OM_PrimaryBankBranchName  ='" + phmc_om_login.getPHMC_OM_PrimaryBankBranchName() + "'";
		}
		if (phmc_om_login.getPHMC_OM_PrimaryBankAccountType() != null) {
			if (setter == null) {
				setter = "PHMC_OM_PrimaryBankAccountType  ='" + phmc_om_login.getPHMC_OM_PrimaryBankAccountType() + "'";
			} else
				setter += ", PHMC_OM_PrimaryBankAccountType  ='" + phmc_om_login.getPHMC_OM_PrimaryBankAccountType() + "'";
		}
		if (phmc_om_login.getPHMC_OM_PrimaryIFSCCode() != null) {
			if (setter == null) {
				setter = "PHMC_OM_PrimaryIFSCCode  ='" + phmc_om_login.getPHMC_OM_PrimaryIFSCCode() + "'";
			} else
				setter += ", PHMC_OM_PrimaryIFSCCode  ='" + phmc_om_login.getPHMC_OM_PrimaryIFSCCode() + "'";
		}
		if (phmc_om_login.getPHMC_OM_PrimaryBankLinkedAadhaarNo() != null) {
			if (setter == null) {
				setter = "PHMC_OM_PrimaryBankLinkedAadhaarNo  ='" + phmc_om_login.getPHMC_OM_PrimaryBankLinkedAadhaarNo() + "'";
			} else
				setter += ", PHMC_OM_PrimaryBankLinkedAadhaarNo  ='" + phmc_om_login.getPHMC_OM_PrimaryBankLinkedAadhaarNo() + "'";
		}
		if (phmc_om_login.getPHMC_OM_PrimaryBankVPA() != null) {
			if (setter == null) {
				setter = "PHMC_OM_PrimaryBankVPA  ='" + phmc_om_login.getPHMC_OM_PrimaryBankVPA() + "'";
			} else
				setter += ", PHMC_OM_PrimaryBankVPA  ='" + phmc_om_login.getPHMC_OM_PrimaryBankVPA() + "'";
		}
		if (phmc_om_login.getPHMC_OM_SecondaryBankName() != null) {
			if (setter == null) {
				setter = "PHMC_OM_SecondaryBankName  ='" + phmc_om_login.getPHMC_OM_SecondaryBankName() + "'";
			} else
				setter += ", PHMC_OM_SecondaryBankName  ='" + phmc_om_login.getPHMC_OM_SecondaryBankName() + "'";
		}
		if (phmc_om_login.getPHMC_OM_SecondaryBankAcountNo() != null) {
			if (setter == null) {
				setter = "PHMC_OM_SecondaryBankAcountNo  ='" + phmc_om_login.getPHMC_OM_SecondaryBankAcountNo() + "'";
			} else
				setter += ", PHMC_OM_SecondaryBankAcountNo  ='" + phmc_om_login.getPHMC_OM_SecondaryBankAcountNo() + "'";
		}
		if (phmc_om_login.getPHMC_OM_SecondaryBankBranchName() != null) {
			if (setter == null) {
				setter = "PHMC_OM_SecondaryBankBranchName  ='" + phmc_om_login.getPHMC_OM_SecondaryBankBranchName() + "'";
			} else
				setter += ", PHMC_OM_SecondaryBankBranchName  ='" + phmc_om_login.getPHMC_OM_SecondaryBankBranchName() + "'";
		}
		if (phmc_om_login.getPHMC_OM_SecondaryBankAccountType() != null) {
			if (setter == null) {
				setter = "PHMC_OM_SecondaryBankAccountType  ='" + phmc_om_login.getPHMC_OM_SecondaryBankAccountType() + "'";
			} else
				setter += ", PHMC_OM_SecondaryBankAccountType  ='" + phmc_om_login.getPHMC_OM_SecondaryBankAccountType() + "'";
		}
		if (phmc_om_login.getPHMC_OM_SecondaryIFSCCode() != null) {
			if (setter == null) {
				setter = "PHMC_OM_SecondaryIFSCCode  ='" + phmc_om_login.getPHMC_OM_SecondaryIFSCCode() + "'";
			} else
				setter += ", PHMC_OM_SecondaryIFSCCode  ='" + phmc_om_login.getPHMC_OM_SecondaryIFSCCode() + "'";
		}
		if (phmc_om_login.getPHMC_OM_SecondaryBankLinkedAadhaarNo() != null) {
			if (setter == null) {
				setter = "PHMC_OM_SecondaryBankLinkedAadhaarNo  ='" + phmc_om_login.getPHMC_OM_SecondaryBankLinkedAadhaarNo() + "'";
			} else
				setter += ", PHMC_OM_SecondaryBankLinkedAadhaarNo  ='" + phmc_om_login.getPHMC_OM_SecondaryBankLinkedAadhaarNo() + "'";
		}
		if (phmc_om_login.getPHMC_OM_SecondaryBankVPA() != null) {
			if (setter == null) {
				setter = "PHMC_OM_SecondaryBankVPA  ='" + phmc_om_login.getPHMC_OM_SecondaryBankVPA() + "'";
			} else
				setter += ", PHMC_OM_SecondaryBankVPA  ='" + phmc_om_login.getPHMC_OM_SecondaryBankVPA() + "'";
		}
		if (phmc_om_login.getPHMC_OM_PANCardNo() != null) {
			if (setter == null) {
				setter = "PHMC_OM_PANCardNo  ='" + phmc_om_login.getPHMC_OM_PANCardNo() + "'";
			} else
				setter += ", PHMC_OM_PANCardNo  ='" + phmc_om_login.getPHMC_OM_PANCardNo() + "'";
		}
		if (phmc_om_login.getPHMC_OM_AadhaarNo() != null) {
			if (setter == null) {
				setter = "PHMC_OM_AadhaarNo  ='" + phmc_om_login.getPHMC_OM_AadhaarNo() + "'";
			} else
				setter += ", PHMC_OM_AadhaarNo  ='" + phmc_om_login.getPHMC_OM_AadhaarNo() + "'";
		}
		
		

		System.out.println("Setter= " + setter);

		return setter;
	}

	/**
	 * @param phmc_om_userName
	 * @return phmc_om_login this method is for read data from PHMC_OM_LOGIN
	 *         Table for particular UserName.
	 */
	public List<PHMC_OM_LOGIN> phmc_om_readOMUser() {
		String whereClause = "";
		
		phmc_om_session = PayhindHibernateUtil.getSessionFactory().openSession();
		Query<PHMC_OM_LOGIN> quary = phmc_om_session.createQuery("FROM PHMC_OM_LOGIN  " + whereClause + " ");
		
		phmc_om_userList = quary.getResultList();
		return phmc_om_userList;

	}
}
