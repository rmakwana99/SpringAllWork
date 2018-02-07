
package com.rahul.phmc.om.billing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rahul.phmc.om.billing.model.PHMC_OM_BILLING;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.PHMC_DB_ERROR;
import com.rahul.phmc.util.Payhind_DBManager;
import com.rahul.phmc.util.persistance.PayhindHibernateUtil;

/**
 * @author rahul
 * 
 * This class deals with all database access related methods
 */
public class PHMC_OM_BillingDAO {
	
	
	/**
	 * @param phmc_om_PCOID
	 * @return phmc_om_billing this method is for read data from PHMC_OM_BILLING
	 *         Table for particular UserName.
	 */
	public PHMC_OM_BILLING phmc_om_readBilling(Long phmc_om_pcoID) {

		PHMC_OM_BILLING phmc_om_bill= null;
		ResultSet phmc_rs= null;
		
		String sopdb_selectQuary = "SELECT PHMC_OM_BillingID, PHMC_OM_PCOID, PHMC_PATH_JAN, PHMC_PATH_FEB, PHMC_PATH_MAR, PHMC_PATH_APR, "
				+ "PHMC_PATH_MAY, PHMC_PATH_JUN, PHMC_PATH_JUL, PHMC_PATH_AUG, PHMC_PATH_SEP, PHMC_PATH_OCT, PHMC_PATH_NOV, PHMC_PATH_DEC, "
				+ "PHMC_PDF_JAN, PHMC_PDF_FEB, PHMC_PDF_MAR, PHMC_PDF_APR, PHMC_PDF_MAY, PHMC_PDF_JUN, PHMC_PDF_JUL, PHMC_PDF_AUG, PHMC_PDF_SEP, "
				+ "PHMC_PDF_OCT, PHMC_PDF_NOV, PHMC_PDF_DEC, PHMC_IsStatementSent, PHMC_BillingRecycleDate, PHMC_LastBilledDate, PHMC_PATH_CurrentBill, "
				+ "PHMC_PDF_CurrentBill FROM PHMC_OM_BILLING WHERE PHMC_OM_PCOID = ?";

		// get Database Connection
		try (Connection sopdb_conn = Payhind_DBManager.payhind_getConnection();
				PreparedStatement sopdb_pst = sopdb_conn.prepareStatement(sopdb_selectQuary)) {

			sopdb_pst.setLong(1, phmc_om_pcoID);

			phmc_rs = sopdb_pst.executeQuery();

			while (phmc_rs.next()) {

				// System.out.println(sopdb_rs.getRow());
				phmc_om_bill = new PHMC_OM_BILLING();

				phmc_om_bill.setPHMC_OM_BillingID(phmc_rs.getLong("PHMC_OM_BillingID"));
				phmc_om_bill.setPHMC_OM_PCOID(phmc_rs.getLong("PHMC_OM_PCOID"));
				phmc_om_bill.setPHMC_PATH_JAN(phmc_rs.getString("PHMC_PATH_JAN"));
				phmc_om_bill.setPHMC_PATH_FEB(phmc_rs.getString("PHMC_PATH_FEB"));
				phmc_om_bill.setPHMC_PATH_MAR(phmc_rs.getString("PHMC_PATH_MAR"));
				phmc_om_bill.setPHMC_PATH_APR(phmc_rs.getString("PHMC_PATH_APR"));
				phmc_om_bill.setPHMC_PATH_MAY(phmc_rs.getString("PHMC_PATH_MAY"));
				phmc_om_bill.setPHMC_PATH_JUN(phmc_rs.getString("PHMC_PATH_JUN"));
				phmc_om_bill.setPHMC_PATH_JUL(phmc_rs.getString("PHMC_PATH_JUL"));
				phmc_om_bill.setPHMC_PATH_AUG(phmc_rs.getString("PHMC_PATH_AUG"));
				phmc_om_bill.setPHMC_PATH_SEP(phmc_rs.getString("PHMC_PATH_SEP"));
				phmc_om_bill.setPHMC_PATH_OCT(phmc_rs.getString("PHMC_PATH_OCT"));
				phmc_om_bill.setPHMC_PATH_NOV(phmc_rs.getString("PHMC_PATH_NOV"));
				phmc_om_bill.setPHMC_PATH_DEC(phmc_rs.getString("PHMC_PATH_DEC"));
				phmc_om_bill.setPHMC_PDF_JAN(phmc_rs.getString("PHMC_PDF_FEB"));
				phmc_om_bill.setPHMC_PDF_MAR(phmc_rs.getString("PHMC_PDF_MAR"));
				phmc_om_bill.setPHMC_PDF_APR(phmc_rs.getString("PHMC_PDF_APR"));
				phmc_om_bill.setPHMC_PDF_MAY(phmc_rs.getString("PHMC_PDF_MAY"));
				phmc_om_bill.setPHMC_PDF_JUN(phmc_rs.getString("PHMC_PDF_JUN"));
				phmc_om_bill.setPHMC_PDF_JUL(phmc_rs.getString("PHMC_PDF_JUL"));
				phmc_om_bill.setPHMC_PDF_AUG(phmc_rs.getString("PHMC_PDF_AUG"));
				phmc_om_bill.setPHMC_PDF_SEP(phmc_rs.getString("PHMC_PDF_SEP"));
				phmc_om_bill.setPHMC_PDF_OCT(phmc_rs.getString("PHMC_PDF_OCT"));
				phmc_om_bill.setPHMC_PDF_NOV(phmc_rs.getString("PHMC_PDF_NOV"));
				phmc_om_bill.setPHMC_PDF_DEC(phmc_rs.getString("PHMC_PDF_DEC"));
				phmc_om_bill.setPHMC_IsStatementSent(phmc_rs.getInt("PHMC_IsStatementSent"));
				phmc_om_bill.setPHMC_BillingRecycleDate(phmc_rs.getDate("PHMC_BillingRecycleDate"));
				phmc_om_bill.setPHMC_LastBilledDate(phmc_rs.getDate("PHMC_LastBilledDate"));
				phmc_om_bill.setPHMC_PATH_CurrentBill(phmc_rs.getString("PHMC_PATH_CurrentBill"));
				phmc_om_bill.setPHMC_PDF_CurrentBill(phmc_rs.getString("PHMC_PDF_CurrentBill"));

			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return phmc_om_bill;

	}
	
	/**
	 * @param phmc_om_PCOID
	 * @return phmc_om_billing this method is for read data from PHMC_OM_BILLING
	 *         Table for particular UserName.
	 */
	public List<PHMC_OM_BILLING> phmc_om_readAllBill(Integer phmc_om_pageStart, Integer phmc_om_size,
			String whereCluase) {

		List<PHMC_OM_BILLING> phmc_om_billList=new ArrayList<PHMC_OM_BILLING>();
		PHMC_OM_BILLING phmc_om_bill= null;
		ResultSet phmc_rs= null;
		
		String sopdb_selectQuary = "SELECT PHMC_OM_BillingID, PHMC_OM_PCOID, PHMC_PATH_JAN, PHMC_PATH_FEB, PHMC_PATH_MAR, PHMC_PATH_APR, "
				+ "PHMC_PATH_MAY, PHMC_PATH_JUN, PHMC_PATH_JUL, PHMC_PATH_AUG, PHMC_PATH_SEP, PHMC_PATH_OCT, PHMC_PATH_NOV, PHMC_PATH_DEC, "
				+ "PHMC_PDF_JAN, PHMC_PDF_FEB, PHMC_PDF_MAR, PHMC_PDF_APR, PHMC_PDF_MAY, PHMC_PDF_JUN, PHMC_PDF_JUL, PHMC_PDF_AUG, PHMC_PDF_SEP, "
				+ "PHMC_PDF_OCT, PHMC_PDF_NOV, PHMC_PDF_DEC, PHMC_IsStatementSent, PHMC_BillingRecycleDate, PHMC_LastBilledDate, PHMC_PATH_CurrentBill, "
				+ "PHMC_PDF_CurrentBill FROM PHMC_OM_BILLING ";

		System.out.println("phmc_om_pageStart :" + phmc_om_pageStart + "\n phmc_om_size : " + phmc_om_size);
		if (whereCluase != null && !whereCluase.equals("")) {
			sopdb_selectQuary = sopdb_selectQuary + " WHERE " + whereCluase + " ";
		}
		if (phmc_om_pageStart != null && phmc_om_size != null) {
			sopdb_selectQuary = sopdb_selectQuary + " ORDER BY PHMC_LastBilledDate DESC" + " OFFSET " + phmc_om_size * (phmc_om_pageStart - 1)
					+ " ROWS FETCH NEXT " + phmc_om_size + " ROWS ONLY ";
		}

		System.out.println("sql Query : " + sopdb_selectQuary);

		
		// get Database Connection
		try (Connection sopdb_conn = Payhind_DBManager.payhind_getConnection();
				PreparedStatement sopdb_pst = sopdb_conn.prepareStatement(sopdb_selectQuary)) {


			phmc_rs = sopdb_pst.executeQuery();

			while (phmc_rs.next()) {

				// System.out.println(sopdb_rs.getRow());
				phmc_om_bill = new PHMC_OM_BILLING();

				phmc_om_bill.setPHMC_OM_BillingID(phmc_rs.getLong("PHMC_OM_BillingID"));
				phmc_om_bill.setPHMC_OM_PCOID(phmc_rs.getLong("PHMC_OM_PCOID"));
				phmc_om_bill.setPHMC_PATH_JAN(phmc_rs.getString("PHMC_PATH_JAN"));
				phmc_om_bill.setPHMC_PATH_FEB(phmc_rs.getString("PHMC_PATH_FEB"));
				phmc_om_bill.setPHMC_PATH_MAR(phmc_rs.getString("PHMC_PATH_MAR"));
				phmc_om_bill.setPHMC_PATH_APR(phmc_rs.getString("PHMC_PATH_APR"));
				phmc_om_bill.setPHMC_PATH_MAY(phmc_rs.getString("PHMC_PATH_MAY"));
				phmc_om_bill.setPHMC_PATH_JUN(phmc_rs.getString("PHMC_PATH_JUN"));
				phmc_om_bill.setPHMC_PATH_JUL(phmc_rs.getString("PHMC_PATH_JUL"));
				phmc_om_bill.setPHMC_PATH_AUG(phmc_rs.getString("PHMC_PATH_AUG"));
				phmc_om_bill.setPHMC_PATH_SEP(phmc_rs.getString("PHMC_PATH_SEP"));
				phmc_om_bill.setPHMC_PATH_OCT(phmc_rs.getString("PHMC_PATH_OCT"));
				phmc_om_bill.setPHMC_PATH_NOV(phmc_rs.getString("PHMC_PATH_NOV"));
				phmc_om_bill.setPHMC_PATH_DEC(phmc_rs.getString("PHMC_PATH_DEC"));
				phmc_om_bill.setPHMC_PDF_JAN(phmc_rs.getString("PHMC_PDF_FEB"));
				phmc_om_bill.setPHMC_PDF_MAR(phmc_rs.getString("PHMC_PDF_MAR"));
				phmc_om_bill.setPHMC_PDF_APR(phmc_rs.getString("PHMC_PDF_APR"));
				phmc_om_bill.setPHMC_PDF_MAY(phmc_rs.getString("PHMC_PDF_MAY"));
				phmc_om_bill.setPHMC_PDF_JUN(phmc_rs.getString("PHMC_PDF_JUN"));
				phmc_om_bill.setPHMC_PDF_JUL(phmc_rs.getString("PHMC_PDF_JUL"));
				phmc_om_bill.setPHMC_PDF_AUG(phmc_rs.getString("PHMC_PDF_AUG"));
				phmc_om_bill.setPHMC_PDF_SEP(phmc_rs.getString("PHMC_PDF_SEP"));
				phmc_om_bill.setPHMC_PDF_OCT(phmc_rs.getString("PHMC_PDF_OCT"));
				phmc_om_bill.setPHMC_PDF_NOV(phmc_rs.getString("PHMC_PDF_NOV"));
				phmc_om_bill.setPHMC_PDF_DEC(phmc_rs.getString("PHMC_PDF_DEC"));
				phmc_om_bill.setPHMC_IsStatementSent(phmc_rs.getInt("PHMC_IsStatementSent"));
				phmc_om_bill.setPHMC_BillingRecycleDate(phmc_rs.getDate("PHMC_BillingRecycleDate"));
				phmc_om_bill.setPHMC_LastBilledDate(phmc_rs.getDate("PHMC_LastBilledDate"));
				phmc_om_bill.setPHMC_PATH_CurrentBill(phmc_rs.getString("PHMC_PATH_CurrentBill"));
				phmc_om_bill.setPHMC_PDF_CurrentBill(phmc_rs.getString("PHMC_PDF_CurrentBill"));

				phmc_om_billList.add(phmc_om_bill);
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return phmc_om_billList;

	}
	
	
	/**
	 * @param phmc_om_billing
	 * @return
	 */
	public ErrorMessage phmc_om_createBill(PHMC_OM_BILLING phmc_om_billing){
		ErrorMessage phmc_errorMsg  = new ErrorMessage();
		Session session = PayhindHibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(phmc_om_billing);
			transaction.commit();

			phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_SUCCESS);
			phmc_errorMsg.setErrorMessage("PCO with ID " + phmc_om_billing.getPHMC_OM_PCOID() + " Created Successfully");

		} catch ( Exception e) {
			transaction.rollback();
			phmc_errorMsg.setErrorCode(PHMC_DB_ERROR.PHMC_INSERT_FAILED);
			phmc_errorMsg.setErrorMessage("PCO with ID " + phmc_om_billing.getPHMC_OM_PCOID() + " Creation Failed");
			e.printStackTrace();
		} finally {
			
			session.close();
			
		}

		return phmc_errorMsg;
	}

	
	public ErrorMessage phmc_om_updateBill(long phmc_om_pco, PHMC_OM_BILLING phmc_om_billing ) {

		int isUpdateSuccess = 0;
		Connection PHMC_conn = null;
		PreparedStatement PHMC_pst = null;
		String setter = "";

		ErrorMessage msg = new ErrorMessage();

		if (phmc_om_billing != null) {

			try {
				PHMC_conn = Payhind_DBManager.payhind_getConnection();

				setter = setterForUpdateUser(phmc_om_billing);

				PHMC_conn.setAutoCommit(false);

				PHMC_pst = PHMC_conn.prepareStatement(
						"UPDATE PHMC_OM_BILLING SET " + setter + " WHERE PHMC_OM_PCOID='" + phmc_om_pco+"';");

				isUpdateSuccess = PHMC_pst.executeUpdate();

				msg.setErrorCode(PHMC_DB_ERROR.PHMC_SUCCESS);
				msg.setErrorMessage("PCO with ID " + phmc_om_pco + " Updated Successfully");
				PHMC_conn.commit();

			} catch (ClassNotFoundException e) {
				isUpdateSuccess = PHMC_DB_ERROR.PHMC_SCFG_FILE_NOT_FOUND;
				msg.setErrorCode(PHMC_DB_ERROR.PHMC_SCFG_FILE_NOT_FOUND);
				msg.setErrorMessage("PCO with ID " + phmc_om_pco + " Not Found");
				e.printStackTrace();
			} catch (SQLException e) {
				isUpdateSuccess = PHMC_DB_ERROR.PHMC_UPDATE_FAILED;
				msg.setErrorCode(PHMC_DB_ERROR.PHMC_UPDATE_FAILED);
				msg.setErrorMessage("PCO with ID " + phmc_om_pco + " Updation Failed");
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
	 * @param phmc_om_billing
	 * @return setter
	 */
	private String setterForUpdateUser(PHMC_OM_BILLING phmc_om_billing) {
		String setter = null;

		if (phmc_om_billing.getPHMC_OM_PCOID() != null)
			setter = "PHMC_OM_PCOID='" + phmc_om_billing.getPHMC_OM_PCOID() + "' ";
		if (phmc_om_billing.getPHMC_PATH_JAN() != null) {
			if (setter == null) {
				setter = "PHMC_PATH_JAN ='" + phmc_om_billing.getPHMC_PATH_JAN() + "'";
			} else
				setter += ", PHMC_PATH_JAN ='" + phmc_om_billing.getPHMC_PATH_JAN() + "'";
		}
		if (phmc_om_billing.getPHMC_PATH_FEB() != null) {
			if (setter == null) {
				setter = "PHMC_PATH_FEB ='" + phmc_om_billing.getPHMC_PATH_FEB() + "'";
			} else
				setter += ", PHMC_PATH_FEB ='" + phmc_om_billing.getPHMC_PATH_FEB() + "'";
		}
		if (phmc_om_billing.getPHMC_PATH_MAR() != null) {
			if (setter == null) {
				setter = "PHMC_PATH_MAR ='" + phmc_om_billing.getPHMC_PATH_MAR() + "'";
			} else
				setter += ", PHMC_PATH_MAR ='" + phmc_om_billing.getPHMC_PATH_MAR() + "'";
		}
		if (phmc_om_billing.getPHMC_PATH_APR() != null) {
			if (setter == null) {
				setter = "PHMC_PATH_APR ='" + phmc_om_billing.getPHMC_PATH_APR() + "'";
			} else
				setter += ", PHMC_PATH_APR ='" + phmc_om_billing.getPHMC_PATH_APR() + "'";
		}
		if (phmc_om_billing.getPHMC_PATH_MAY() != null) {
			if (setter == null) {
				setter = "PHMC_PATH_MAY ='" + phmc_om_billing.getPHMC_PATH_MAY() + "'";
			} else
				setter += ", PHMC_PATH_MAY ='" + phmc_om_billing.getPHMC_PATH_MAY() + "'";
		}
		if (phmc_om_billing.getPHMC_PATH_JUN() != null) {
			if (setter == null) {
				setter = "PHMC_PATH_JUN ='" + phmc_om_billing.getPHMC_PATH_JUN() + "'";
			} else
				setter += ", PHMC_PATH_JUN ='" + phmc_om_billing.getPHMC_PATH_JUN() + "'";
		}
		if (phmc_om_billing.getPHMC_PATH_JUL() != null) {
			if (setter == null) {
				setter = "PHMC_PATH_JUL ='" + phmc_om_billing.getPHMC_PATH_JUL() + "'";
			} else
				setter += ", PHMC_PATH_JUL ='" + phmc_om_billing.getPHMC_PATH_JUL() + "'";
		}

		if (phmc_om_billing.getPHMC_PATH_AUG() != null) {
			if (setter == null) {
				setter = "PHMC_PATH_AUG ='" + phmc_om_billing.getPHMC_PATH_AUG() + "'";
			} else
				setter += ", PHMC_PATH_AUG ='" + phmc_om_billing.getPHMC_PATH_AUG() + "'";
		}
		if (phmc_om_billing.getPHMC_PATH_SEP() != null) {
			if (setter == null) {
				setter = "PHMC_PATH_SEP ='" + phmc_om_billing.getPHMC_PATH_SEP() + "'";
			} else
				setter += ", PHMC_PATH_SEP ='" + phmc_om_billing.getPHMC_PATH_SEP() + "'";
		}
		if (phmc_om_billing.getPHMC_PATH_OCT() != null) {
			if (setter == null) {
				setter = "PHMC_PATH_OCT ='" + phmc_om_billing.getPHMC_PATH_OCT() + "'";
			} else
				setter += ", PHMC_PATH_OCT ='" + phmc_om_billing.getPHMC_PATH_OCT() + "'";
		}
		if (phmc_om_billing.getPHMC_PATH_NOV() != null) {
			if (setter == null) {
				setter = "PHMC_PATH_NOV ='" + phmc_om_billing.getPHMC_PATH_NOV() + "'";
			} else
				setter += ", PHMC_PATH_NOV ='" + phmc_om_billing.getPHMC_PATH_NOV() + "'";
		}
		if (phmc_om_billing.getPHMC_PATH_DEC() != null) {
			if (setter == null) {
				setter = "PHMC_PATH_DEC ='" + phmc_om_billing.getPHMC_PATH_DEC() + "'";
			} else
				setter += ", PHMC_PATH_DEC ='" + phmc_om_billing.getPHMC_PATH_DEC() + "'";
		}
		if (phmc_om_billing.getPHMC_PDF_JAN() != null) {
			if (setter == null) {
				setter = "PHMC_PDF_JAN ='" + phmc_om_billing.getPHMC_PDF_JAN() + "'";
			} else
				setter += ", PHMC_PDF_JAN ='" + phmc_om_billing.getPHMC_PDF_JAN() + "'";
		}
		if (phmc_om_billing.getPHMC_PDF_FEB() != null) {
			if (setter == null) {
				setter = "PHMC_PDF_FEB ='" + phmc_om_billing.getPHMC_PDF_FEB() + "'";
			} else
				setter += ", PHMC_PDF_FEB ='" + phmc_om_billing.getPHMC_PDF_FEB() + "'";
		}
		if (phmc_om_billing.getPHMC_PDF_MAR() != null) {
			if (setter == null) {
				setter = "PHMC_PDF_MAR ='" + phmc_om_billing.getPHMC_PDF_MAR() + "'";
			} else
				setter += ", PHMC_PDF_MAR ='" + phmc_om_billing.getPHMC_PDF_MAR() + "'";
		}

		if (phmc_om_billing.getPHMC_PDF_APR() != null) {
			if (setter == null) {
				setter = "PHMC_PDF_APR ='" + phmc_om_billing.getPHMC_PDF_APR() + "'";
			} else
				setter += ", PHMC_PDF_APR ='" + phmc_om_billing.getPHMC_PDF_APR() + "'";
		}
		if (phmc_om_billing.getPHMC_PDF_MAY() != null) {
			if (setter == null) {
				setter = "PHMC_PDF_MAY ='" + phmc_om_billing.getPHMC_PDF_MAY() + "'";
			} else
				setter += ", PHMC_PDF_MAY ='" + phmc_om_billing.getPHMC_PDF_MAY() + "'";
		}
		if (phmc_om_billing.getPHMC_PDF_JUN() != null) {
			if (setter == null) {
				setter = "PHMC_PDF_JUN ='" + phmc_om_billing.getPHMC_PDF_JUN() + "'";
			} else
				setter += ", PHMC_PDF_JUN ='" + phmc_om_billing.getPHMC_PDF_JUN() + "'";
		}
		if (phmc_om_billing.getPHMC_PDF_JUL() != null) {
			if (setter == null) {
				setter = "PHMC_PDF_JUL ='" + phmc_om_billing.getPHMC_PDF_JUL() + "'";
			} else
				setter += ", PHMC_PDF_JUL ='" + phmc_om_billing.getPHMC_PDF_JUL() + "'";
		}
		if (phmc_om_billing.getPHMC_PDF_AUG() != null) {
			if (setter == null) {
				setter = "PHMC_PDF_AUG ='" + phmc_om_billing.getPHMC_PDF_AUG() + "'";
			} else
				setter += ", PHMC_PDF_AUG ='" + phmc_om_billing.getPHMC_PDF_AUG() + "'";
		}
		if (phmc_om_billing.getPHMC_PDF_SEP() != null) {
			if (setter == null) {
				setter = "PHMC_PDF_SEP ='" + phmc_om_billing.getPHMC_PDF_SEP() + "'";
			} else
				setter += ", PHMC_PDF_SEP ='" + phmc_om_billing.getPHMC_PDF_SEP() + "'";
		}

		if (phmc_om_billing.getPHMC_PDF_OCT() != null) {
			if (setter == null) {
				setter = "PHMC_PDF_OCT ='" + phmc_om_billing.getPHMC_PDF_OCT() + "'";
			} else
				setter += ", PHMC_PDF_OCT ='" + phmc_om_billing.getPHMC_PDF_OCT() + "'";
		}
		if (phmc_om_billing.getPHMC_PDF_NOV() != null) {
			if (setter == null) {
				setter = "PHMC_PDF_NOV ='" + phmc_om_billing.getPHMC_PDF_NOV() + "'";
			} else
				setter += ", PHMC_PDF_NOV ='" + phmc_om_billing.getPHMC_PDF_NOV() + "'";
		}
		if (phmc_om_billing.getPHMC_PDF_DEC() != null) {
			if (setter == null) {
				setter = "PHMC_PDF_DEC ='" + phmc_om_billing.getPHMC_PDF_DEC() + "'";
			} else
				setter += ", PHMC_PDF_DEC ='" + phmc_om_billing.getPHMC_PDF_DEC() + "'";
		}
		if (phmc_om_billing.getPHMC_IsStatementSent() != null) {
			if (setter == null) {
				setter = "PHMC_IsStatementSent ='" + phmc_om_billing.getPHMC_IsStatementSent() + "'";
			} else
				setter += ", PHMC_IsStatementSent ='" + phmc_om_billing.getPHMC_IsStatementSent() + "'";
		}
		if (phmc_om_billing.getPHMC_BillingRecycleDate() != null) {
			if (setter == null) {
				setter = "PHMC_BillingRecycleDate ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(phmc_om_billing.getPHMC_BillingRecycleDate()) + "'";
			} else
				setter += ", PHMC_BillingRecycleDate ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(phmc_om_billing.getPHMC_BillingRecycleDate()) + "'";
		}
		if (phmc_om_billing.getPHMC_LastBilledDate() != null) {
			if (setter == null) {
				setter = "PHMC_LastBilledDate ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(phmc_om_billing.getPHMC_LastBilledDate()) + "'";
			} else
				setter += ", PHMC_LastBilledDate ='"
						+ Payhind_DBManager.convertJavaDateToSqlDate(phmc_om_billing.getPHMC_LastBilledDate()) + "'";
		}
		if (phmc_om_billing.getPHMC_PATH_CurrentBill() != null) {
			if (setter == null) {
				setter = "PHMC_PATH_CurrentBill ='" + phmc_om_billing.getPHMC_PATH_CurrentBill() + "'";
			} else
				setter += ", PHMC_PATH_CurrentBill ='" + phmc_om_billing.getPHMC_PATH_CurrentBill() + "'";
		}
		if (phmc_om_billing.getPHMC_PDF_CurrentBill() != null) {
			if (setter == null) {
				setter = "PHMC_PDF_CurrentBill ='" + phmc_om_billing.getPHMC_PDF_CurrentBill() + "'";
			} else
				setter += ", PHMC_PDF_CurrentBill ='" + phmc_om_billing.getPHMC_PDF_CurrentBill() + "'";
		}

		System.out.println("Setter= " + setter);

		return setter;
	}
}
