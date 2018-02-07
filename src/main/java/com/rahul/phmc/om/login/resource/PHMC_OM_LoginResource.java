
package com.rahul.phmc.om.login.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rahul.phmc.om.login.model.PHMC_OM_LOGIN;
import com.rahul.phmc.om.login.services.PHMC_OM_LoginService;
import com.rahul.phmc.sopdb.exception.SOPDB_NotFoundException;
import com.rahul.phmc.util.ErrorMessage;

/**
 * @author rahul
 * This is http handler claass for all http request resources related to Login
 */
@Path("login")
public class PHMC_OM_LoginResource {
	
	
	

	PHMC_OM_LoginService service=new PHMC_OM_LoginService();
	

	
	/**
	 * Method handling HTTP GET(Read) requests. The returned object will be sent
	 * to the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Path("/{userName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response phmc_om_getLoginDetail(@PathParam("userName") String phmc_om_userName) {
		
		PHMC_OM_LOGIN login = service.phmc_om_readLoginDetail(phmc_om_userName);
		System.out.println();
		if (login == null) {
			throw new SOPDB_NotFoundException("PCO  with ID " + phmc_om_userName + " Not Found");
		} else
			return   Response.status(200).
	                entity(login).
	               header("Access-Control-Allow-Origin", "*").build();
	}
	/**
	 * Method handling HTTP GET(Read) requests. The returned object will be sent
	 * to the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PHMC_OM_LOGIN> phmc_om_getSearchedLoginDetail(@QueryParam("phmc_userName") String phmc_userName,
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
		
		List<PHMC_OM_LOGIN> login = service.phmc_om_readLoginBySearch(phmc_userName, phmc_pageNo, phmc_pageSize,
				phmc_cityName,  phmc_startPinCode, phmc_endPinCode, phmc_emailID, phmc_startDate,
				phmc_endDate, phmc_activeStatus, phmc_effectiveDate, phmc_effectiveEndDate, phmc_roleCode);
		if (login == null  || login.isEmpty()) {
			throw new SOPDB_NotFoundException("No record  Found");
		} else
			return login;
	}
	
	/**
	 * Method handling HTTP GET(Read) requests. The returned object will be sent
	 * to the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response phmc_om_createOMUser(PHMC_OM_LOGIN phmc_om_login) {
		
		ErrorMessage phmc_om_errorResponse = service.phmc_phob_createLoginDetail(phmc_om_login);
		
		return Response.status(phmc_om_errorResponse.getErrorCode()).entity(phmc_om_errorResponse).build();
		
	}
	
	
	
	/**
	 * Method handling HTTP POST(Create) requests for PHOB_KYCFORM. The returned
	 * object will be sent to the client as ErrorCode and ErrorMessage media
	 * type.
	 */
	@PUT
	@Path("/{Username}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response phmc_phob_createUpdateLogin(@PathParam("Username") String phmc_om_username,
			PHMC_OM_LOGIN phmc_om_login) {

		ErrorMessage msg = service.phmc_phob_createUpdateLoginDetail(phmc_om_username, phmc_om_login);

		System.out.println("service errorcode=" + msg.getErrorCode());
		return Response.status(msg.getErrorCode()).entity(msg).build();

	}

}
