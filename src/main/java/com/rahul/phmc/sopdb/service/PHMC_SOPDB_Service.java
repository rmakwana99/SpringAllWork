package com.rahul.phmc.sopdb.service;

import java.util.ArrayList;
import java.util.List;

import com.rahul.phmc.sopdb.dao.SOPDB_DAO;
import com.rahul.phmc.sopdb.model.PHMC_SOPDB;

/**
 * @author rahul Makvana
 *
 */
public class PHMC_SOPDB_Service {

	private SOPDB_DAO sopdb_dao;
	private List<PHMC_SOPDB> sopdbList;



	public PHMC_SOPDB_Service() {
		super();
		sopdb_dao = new SOPDB_DAO();
	}

	/**
	 * Getting all records of PCO
	 * 
	 * @param pcoID
	 * @return
	 */
	public List<PHMC_SOPDB> phmc_getAllSOPDB(Integer phmc_sopdb_pageNo, Integer phmc_sopdb_pageSize, String phmc_startpcoID,
			String phmc_sopdb_startDate, String phmc_sopdb_endDate) {

	//	sopdbList= new ArrayList<PHMC_SOPDB>();
		System.out.println(phmc_sopdb_pageNo+", "+phmc_sopdb_pageSize+", "+phmc_startpcoID+", "+phmc_sopdb_startDate+", "+phmc_sopdb_endDate);
	
			sopdbList = sopdb_dao.phmc_readSOPDB(phmc_sopdb_pageNo, phmc_sopdb_pageSize, phmc_startpcoID,
					phmc_sopdb_startDate, phmc_sopdb_endDate);
		
		System.out.println(sopdbList);
		return sopdbList;
	}

	/**
	 * Getting all records of PCO
	 * 
	 * @param pcoID
	 * @return
	 */
	public Integer getSOPDBRecord(String phmc_startpcoID, String phmc_sopdb_startDate,
			String phmc_sopdb_endDate) {
		Integer phmc_sopdb_rcord;

		phmc_sopdb_rcord = sopdb_dao.sopdb_getSOPDBRecord(phmc_startpcoID, phmc_sopdb_startDate, phmc_sopdb_endDate);

		return phmc_sopdb_rcord;
	}
	/**
	 * @return
	 */

}
