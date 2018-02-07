package com.rahul.phmc.om.distributer.resource;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.rahul.phmc.om.distributer.service.PHMC_OM_DIST_Service;
import com.rahul.phmc.om.login.model.PHMC_OM_LOGIN;
import com.rahul.phmc.sopdb.exception.SOPDB_NotFoundException;


/**
 * @author rahul
 *
 */
@Path("distributor")
public class PHMC_OM_DIST_Resource {
	
	PHMC_OM_DIST_Service  phmc_om_dist_service ;
	
	public PHMC_OM_DIST_Resource() {
		super();
		phmc_om_dist_service = new PHMC_OM_DIST_Service();
	}

	/**
	 * Method handling HTTP GET(Read) requests. The returned object will be sent
	 * to the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PHMC_OM_LOGIN> phmc_om_getDistributerList(@QueryParam("phmc_userName") String phmc_userName,
			@QueryParam("phmc_pageNo") Integer phmc_pageNo,
			@QueryParam("phmc_pageSize") Integer phmc_pageSize,
			@QueryParam("phmc_cityName") String phmc_cityName,
			@QueryParam("phmc_startPinCode") Integer phmc_startPinCode,
			@QueryParam("phmc_endPinCode") Integer phmc_endPinCode,
			@QueryParam("phmc_emailID") String phmc_emailID,
			@QueryParam("phmc_startDate") String phmc_startDate,
			@QueryParam("phmc_endDate") String phmc_endDate,
			@QueryParam("phmc_activeStatus") Integer phmc_activeStatus,			
			@QueryParam("phmc_effectiveDate") String phmc_effectiveDate,
			@QueryParam("phmc_effectiveEndDate") String phmc_effectiveEndDate,
			@QueryParam("phmc_roleCode") Integer phmc_roleCode) {
		
		if(phmc_roleCode == null && phmc_userName == null ){
			throw new SOPDB_NotFoundException("Please Provide distributer ID or distributer user name.");
		}
		List<PHMC_OM_LOGIN> login = phmc_om_dist_service.phmc_om_readDistributer(phmc_userName, phmc_pageNo, phmc_pageSize,
				phmc_cityName,  phmc_startPinCode, phmc_endPinCode, phmc_emailID, phmc_startDate,
				phmc_endDate, phmc_activeStatus, phmc_effectiveDate, phmc_effectiveEndDate, phmc_roleCode);
		if (login == null  || login.isEmpty()) {
			throw new SOPDB_NotFoundException("No record  Found");
		} else
			return login;
	}

}
