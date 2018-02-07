
package com.rahul.phmc.sdp.commssion.dist.service;

import org.apache.log4j.Logger;

import com.rahul.phmc.sdp.commssion.dist.dao.SPE_CommssionDistDAO;

/**
 * @author rahul Makvana
 *
 */
public class SPE_CommssionDistService {

	static final Logger log = Logger.getLogger(SPE_CommssionDistDAO.class);
	private SPE_CommssionDistDAO cmsnDao;

	/**
	 * Call commission distribution method of Dao 
	 */
	public boolean callCommissionDist(String startDate) {
		cmsnDao = new SPE_CommssionDistDAO();

		return cmsnDao.updateCommission(startDate);
	}

}
