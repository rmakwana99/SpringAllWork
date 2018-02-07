	
package com.rahul.phmc.om.distributer.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rahul.phmc.om.login.dao.PHMC_OM_LoginDAO;
import com.rahul.phmc.om.login.model.PHMC_OM_LOGIN;
import com.rahul.phmc.om.login.services.PHMC_OM_LoginService;

/**
 * @author rahul
 *
 */
public class PHMC_OM_DIST_Service {
	
	static Logger phmc_logeer=LogManager.getLogger(PHMC_OM_LoginService.class.getName());
	private PHMC_OM_LoginDAO phmc_om_loginDAO;
	private PHMC_OM_LOGIN phmc_om_login;
	private List<PHMC_OM_LOGIN> phmc_om_userList = null;
	
	
	
	public PHMC_OM_DIST_Service() {
		super();
		phmc_om_loginDAO =  new PHMC_OM_LoginDAO();
	}



	/**
	 * @param phmc_userName
	 * @param phmc_pageNo
	 * @param phmc_pageSize
	 * @param phmc_cityName
	 * @param phmc_startPinCode
	 * @param phmc_endPinCode
	 * @param phmc_emailID
	 * @param phmc_startDate
	 * @param phmc_endDate
	 * @param phmc_activeStatus
	 * @param phmc_effectiveDate
	 * @param phmc_effectiveEndDate
	 * @param phmc_roleCode
	 * @return
	 */
	public List<PHMC_OM_LOGIN>phmc_om_readDistributer(String phmc_userName, Integer phmc_pageNo, Integer phmc_pageSize,
			String phmc_cityName,Integer phmc_startPinCode, Integer phmc_endPinCode, String phmc_emailID, String phmc_startDate,
			String phmc_endDate, Integer phmc_activeStatus, String phmc_effectiveDate, String phmc_effectiveEndDate,
			Integer phmc_roleCode){
		
		String whereCluase = "";
		System.out.println("phmc_userName :" + phmc_userName);
		if (phmc_userName != null) {

			
				whereCluase += " PHMC_OM_UserName = '" + phmc_userName +"'";
			
		}
		if (phmc_startPinCode != null) {

			if (phmc_endPinCode != null) {
				whereCluase += " PHMC_OM_Pincode BETWEEN " + phmc_startPinCode + " AND "
						+ phmc_endPinCode + " ";
			} else {
				whereCluase += " PHMC_OM_Pincode=  "+ phmc_startPinCode +" ";
			}
		}
		if (phmc_startDate != null) {

			if (phmc_endDate != null) {
				whereCluase += " PHMC_OM_CreatedDate BETWEEN " + phmc_startDate + " AND "
						+ phmc_endDate + " ";
			} else {
				whereCluase += " PHMC_OM_CreatedDate= '" + phmc_startDate + "'";
			}
		}
		if (phmc_cityName != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHMC_OM_City= '" + phmc_cityName + "' " ;
			else
				whereCluase = " PHMC_OM_City= '" + phmc_cityName + "' ";

		}
		if (phmc_emailID != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHMC_OM_Email= '" + phmc_emailID + "' " ;
			else
				whereCluase = " PHMC_OM_Email= '" + phmc_emailID + "' ";

		}
		if (phmc_activeStatus != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHMC_OM_ActiveStatus= " + phmc_activeStatus + " " ;
			else
				whereCluase = " PHMC_OM_ActiveStatus= " + phmc_activeStatus + " ";

		}
		if (phmc_effectiveDate != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHMC_OM_EffectiveDate= '" + phmc_effectiveDate + "' ";
			else
				whereCluase = " PHMC_OM_EffectiveDate= '" + phmc_effectiveDate + "' ";

		}
		if (phmc_effectiveEndDate != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHMC_OM_EffectiveEndDate= '" + phmc_effectiveEndDate + "' ";
			else
				whereCluase = " PHMC_OM_EffectiveEndDate= '" + phmc_effectiveEndDate + "' ";

		}
		if (phmc_roleCode != null) {
			if (!whereCluase.equals(""))
				whereCluase += " AND PHMC_OM_RoleCode= " + phmc_roleCode + " ";
			else
				whereCluase = " PHMC_OM_RoleCode= " + phmc_roleCode + " ";

		}
		phmc_logeer.info("phmc_logeer : " + whereCluase );
		System.out.println("whereCluase : " + whereCluase);
		phmc_om_userList = phmc_om_loginDAO.phmc_om_readDistributer(phmc_pageNo,  phmc_pageSize , whereCluase);
		return phmc_om_userList;
	}
	 

}
