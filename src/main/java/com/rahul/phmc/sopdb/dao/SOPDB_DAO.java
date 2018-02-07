package com.rahul.phmc.sopdb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.rahul.phmc.sopdb.model.PHMC_SOPDB;
import com.rahul.phmc.util.PHMC_DateParser;
import com.rahul.phmc.util.persistance.PayhindHibernateUtil;
/**
 * @author rahul Makvana
 *
 */
public class SOPDB_DAO {
	
	
	/**
	 * Read total Number of records Based On Criteria like Date
	 * 
	 * @param sopdb_pcoID
	 * @return
	 */
	public Integer sopdb_getSOPDBRecord(String phmc_pcoID, String sopdb_startDate, String sopdb_endDate) {

		Integer phmc_sopdb_Record = 0;
		String whereClause = "";
		String whereLiteral = "WHERE ";
		try (Session phmc_session = PayhindHibernateUtil.getSessionFactory().openSession()) {

			if (phmc_pcoID != null) {
				whereClause = "SOPDB_PCOID = :phmc_pcoID";
			}

			if (sopdb_startDate != null) {
				if (!whereClause.equals("")) {
					if (sopdb_endDate != null) {
						whereClause += "  AND  SOPDB_TxnDate BETWEEN :sopdb_startDate AND :sopdb_endDate ";
					} else {
						whereClause += "  AND SOPDB_TxnDate = :sopdb_startDate";
					}
				} else {
					if (sopdb_endDate != null) {
						whereClause += " SOPDB_TxnDate BETWEEN :sopdb_startDate AND :sopdb_endDate ";
					} else {
						whereClause += " SOPDB_TxnDate = :sopdb_startDate";
					}
				}
			}
			

			if (!whereClause.equals(""))
				whereClause = whereLiteral + whereClause;

			Query quary = phmc_session.createQuery("SELECT COUNT(*) FROM PHMC_SOPDB  " + whereClause + " ");
			System.out.println("whereClause clouse : " + whereClause.toString());
			if (phmc_pcoID != null) {
				System.out.println("phmc_pcoID..................." + phmc_pcoID);
				quary.setParameter("phmc_pcoID", "" + phmc_pcoID);
			}

			if (sopdb_startDate != null) {
				quary.setParameter("sopdb_startDate", PHMC_DateParser.phmc_convertStringToSqlDate(sopdb_startDate));
			}
			if (sopdb_endDate != null) {
				quary.setParameter("sopdb_endDate", PHMC_DateParser.phmc_convertStringToSqlDate(sopdb_endDate));
			}
			
			phmc_sopdb_Record = (int)((long)quary.uniqueResult());

		} finally {

			//PayhindHibernateUtil.shutdown();
		}
	
		return phmc_sopdb_Record;

	}

	/**
	 * Reading SOPDB data by using Hibernate
	 * 
	 * @return
	 */
	public List<PHMC_SOPDB> phmc_readSOPDB(Integer phmc_sopdb_pageNo, Integer phmc_sopdb_pageSize, String phmc_pcoID,
			String sopdb_startDate, String sopdb_endDate) {
		String whereClause = "";
		String whereLiteral = "WHERE ";
		String orderBy = " ORDER BY SOPDB_TxnDate DESC";
		List<PHMC_SOPDB> phmc_sopdb=new ArrayList<PHMC_SOPDB>();
		
		try (Session phmc_session = PayhindHibernateUtil.getSessionFactory().openSession()){
			if (phmc_pcoID != null) {
				whereClause = "SOPDB_PCOID = :phmc_pcoID";
			}

			if (sopdb_startDate != null) {
				if (!whereClause.equals("")) {
					if (sopdb_endDate != null) {
						whereClause += "  AND  SOPDB_TxnDate BETWEEN :sopdb_startDate AND :sopdb_endDate ";
					} else {
						whereClause += "  AND SOPDB_TxnDate = :sopdb_startDate";
					}
				} else {
					if (sopdb_endDate != null) {
						whereClause += " SOPDB_TxnDate BETWEEN :sopdb_startDate AND :sopdb_endDate ";
					} else {
						whereClause += " SOPDB_TxnDate = :sopdb_startDate";
					}
				}
			}
			

			if (!whereClause.equals(""))
				whereClause = whereLiteral + whereClause + orderBy;

			Query<PHMC_SOPDB> quary = phmc_session.createQuery("FROM PHMC_SOPDB  " + whereClause + " ");
			System.out.println("whereClause clouse : " + whereClause.toString());
			if (phmc_pcoID != null) {
				System.out.println("phmc_pcoID..................." + phmc_pcoID);
				quary.setParameter("phmc_pcoID", "" + phmc_pcoID);
			}

			if (sopdb_startDate != null) {
				System.out.println("date...................");
				quary.setParameter("sopdb_startDate", PHMC_DateParser.phmc_convertStringToSqlDate(sopdb_startDate));
			}
			if (sopdb_endDate != null) {
				System.out.println("date2...................");
				quary.setParameter("sopdb_endDate", PHMC_DateParser.phmc_convertStringToSqlDate(sopdb_endDate));
			}
			if (phmc_sopdb_pageNo != null && phmc_sopdb_pageSize != null) {
				quary.setFirstResult(phmc_sopdb_pageNo - 1).setMaxResults(phmc_sopdb_pageSize);
			}
			phmc_sopdb = quary.getResultList();

		} finally {
			//PayhindHibernateUtil.shutdown();
		}
		return phmc_sopdb;
	}

}
