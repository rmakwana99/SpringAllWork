
package com.rahul.phmc.phob.resources;

import java.util.ArrayList;
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

import com.rahul.phmc.phob.model.PHMC_PHOB_ONBOARD;
import com.rahul.phmc.phob.model.PHMC_PHOB_USER;
import com.rahul.phmc.phob.services.PHMC_PHOB_Service;
import com.rahul.phmc.sopdb.exception.SOPDB_NotFoundException;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.PHMC_Record;

/**
 * @author rahul
 *
 */
@Path("phob")
public class PHMC_PHOB_Resource {

	private PHMC_PHOB_Service service;
	private ArrayList<PHMC_PHOB_USER> phmc_phob_userList;

	/**
	 * 
	 */
	public PHMC_PHOB_Resource() {
		super();
		service = new PHMC_PHOB_Service();
	}

	// --this is resource for PHOB_USER----
	/**
	 * Method handling HTTP GET(Read) requests. The returned object will be sent
	 * to the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PHMC_PHOB_USER> phmc_phob_getALLPCO(@QueryParam("phmc_pageNo") Integer phmc_pageNo,
			@QueryParam("phmc_pageSize") Integer phmc_pageSize, @QueryParam("phmc_pcoID") Long phmc_pcoID,
			@QueryParam("phmc_endPCOID") Long phmc_endPCOID, @QueryParam("phmc_cityName") String phmc_cityName,
			@QueryParam("phmc_startPinCode") Integer phmc_startPinCode,
			@QueryParam("phmc_endPinCode") Integer phmc_endPinCode, @QueryParam("phmc_emailID") String phmc_emailID,
			@QueryParam("phmc_followUpStatusList") String phmc_followUpStatusList,
			@QueryParam("phmc_kycStatusIsKycVerifiedByOfficial") String phmc_kycStatusIsKycVerifiedByOfficial,
			@QueryParam("phmc_kycStatusIsWalletCreated") String phmc_kycStatusIsWalletCreated,
			@QueryParam("phmc_kycStatusIsOtpSession") String phmc_kycStatusIsOtpSession,
			@QueryParam("phmc_kycStatusIsActivation") String phmc_kycStatusIsActivation,
			@QueryParam("phmc_kycStatusRemarks") String phmc_kycStatusRemarks,
			@QueryParam("phmc_SignUp") String phmc_SignUp, @QueryParam("phmc_welcomeMail") String phmc_welcomeMail,
			@QueryParam("phmc_basicDetailsIsFilled") String phmc_basicDetailsIsFilled,
			@QueryParam("phmc_kycStatusPremilinaryReview") String phmc_kycStatusPremilinaryReview,
			@QueryParam("phmc_kycEverythingValid") String phmc_kycEverythingValid,
			@QueryParam("phmc_stateName") String phmc_basicDetailsComState,
			@QueryParam("phmc_userName") String phmc_userName) {

		System.out.println("pcoID : " + phmc_pcoID);

		List<PHMC_PHOB_USER> user = service.phmc_om_readAllPCO(phmc_pageNo, phmc_pageSize, phmc_pcoID, phmc_endPCOID,
				phmc_cityName, phmc_startPinCode, phmc_endPinCode, phmc_emailID, phmc_followUpStatusList,
				phmc_kycStatusIsKycVerifiedByOfficial, phmc_kycStatusIsWalletCreated, phmc_kycStatusIsActivation,
				phmc_kycStatusIsOtpSession, phmc_kycStatusRemarks, phmc_SignUp, phmc_basicDetailsIsFilled,
				phmc_welcomeMail, phmc_kycStatusPremilinaryReview, phmc_kycEverythingValid, phmc_basicDetailsComState,
				phmc_userName);
		if (user == null || user.isEmpty()) {
			throw new SOPDB_NotFoundException("No record  Found");
		} else
			return user;
	}

	// --this is resource for PHOB_USER----
	/**
	 * Method handling HTTP GET(Read) requests. The returned object will be sent
	 * to the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Path("/phmc_pcoRecord")
	@Produces(MediaType.APPLICATION_JSON)
	public PHMC_Record phmc_phob_getPCORecord(@QueryParam("phmc_pcoID") Long phmc_pcoID,
			@QueryParam("phmc_endPCOID") Long phmc_endPCOID, @QueryParam("phmc_cityName") String phmc_cityName,
			@QueryParam("phmc_startPinCode") Integer phmc_startPinCode,
			@QueryParam("phmc_endPinCode") Integer phmc_endPinCode, @QueryParam("phmc_emailID") String phmc_emailID,
			@QueryParam("phmc_followUpStatusList") String phmc_followUpStatusList,
			@QueryParam("phmc_kycStatusIsKycVerifiedByOfficial") String phmc_kycStatusIsKycVerifiedByOfficial,
			@QueryParam("phmc_kycStatusIsWalletCreated") String phmc_kycStatusIsWalletCreated,
			@QueryParam("phmc_kycStatusIsOtpSession") String phmc_kycStatusIsOtpSession,
			@QueryParam("phmc_kycStatusIsActivation") String phmc_kycStatusIsActivation,
			@QueryParam("phmc_kycStatusRemarks") String phmc_kycStatusRemarks,
			@QueryParam("phmc_SignUp") String phmc_SignUp, @QueryParam("phmc_welcomeMail") String phmc_welcomeMail,
			@QueryParam("phmc_basicDetailsIsFilled") String phmc_basicDetailsIsFilled,
			@QueryParam("phmc_kycStatusPremilinaryReview") String phmc_kycStatusPremilinaryReview,
			@QueryParam("phmc_kycEverythingValid") String phmc_kycEverythingValid,
			@QueryParam("phmc_stateName") String phmc_basicDetailsComState) {

		System.out.println("pcoID : " + phmc_pcoID);

		Integer phmc_pco = service.phmc_om_readPCORecord(phmc_pcoID, phmc_endPCOID, phmc_cityName, phmc_startPinCode,
				phmc_endPinCode, phmc_emailID, phmc_followUpStatusList, phmc_kycStatusIsKycVerifiedByOfficial,
				phmc_kycStatusIsWalletCreated, phmc_kycStatusIsActivation, phmc_kycStatusIsOtpSession,
				phmc_kycStatusRemarks, phmc_SignUp, phmc_basicDetailsIsFilled, phmc_welcomeMail,
				phmc_kycStatusPremilinaryReview, phmc_kycEverythingValid, phmc_basicDetailsComState);

		PHMC_Record record = new PHMC_Record(phmc_pco);
		return record;
	}

	// --this is resource for PHOB_USER----
	/**
	 * Method handling HTTP GET(Read) requests. The returned object will be sent
	 * to the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Path("/{pcoID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response phmc_phob_getPCODetail(@PathParam("pcoID") Long pcoID) {
		System.out.println("pcoID : " + pcoID);

		PHMC_PHOB_USER user = service.phmc_phob_getPCODetail(pcoID);
		if (user == null) {
			throw new SOPDB_NotFoundException("PCO  with ID " + pcoID + " Not Found");
		} else
			return Response.status(200).entity(user).build();
	}

	/**
	 * Method handling HTTP POST(Create) requests for PHOB_USER. The returned
	 * object will be sent to the client as ErrorCode and ErrorMessage media
	 * type.
	 */

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response phmc_phob_createPCO(PHMC_PHOB_USER phmc_phob_pco) {

		ErrorMessage msg = service.phmc_phob_createPCODetail(phmc_phob_pco);

		// System.out.println("service errorcode=" + msg.getErrorCode());
		return Response.status(msg.getErrorCode()).entity(msg).build();
	}

	/**
	 * Method handling HTTP PUT(Update) requests for PHOB_USER. The returned
	 * object will be sent to the client as ErrorCode and ErrorMessage media
	 * type.
	 */
	@PUT
	@Path("/{pcoID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response phmc_phob_updatePCO(@PathParam("pcoID") Long pcoID, PHMC_PHOB_USER phmc_phob_pco) {

		System.out.println("updating pco");
		ErrorMessage msg = service.phmc_phob_updatePCODetail(pcoID, phmc_phob_pco);

		return Response.status(msg.getErrorCode()).entity(msg).build();

	}

	/**
	 * Method handling HTTP GET(Read) requests for PHOB_KYCFORM. The returned
	 * object will be sent to the client as "text/plain" media type.
	 */
	@GET
	@Path("/phobonboard")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<PHMC_PHOB_USER> phmc_pco_getPCOOnboard(@QueryParam("phmc_pageNo") Integer phmc_pageNo,
			@QueryParam("phmc_pageSize") Integer phmc_pageSize, @QueryParam("phmc_pcoID") Long phmc_pcoID,
			@QueryParam("phmc_endPCOID") Long phmc_endPCOID, @QueryParam("phmc_cityName") String phmc_cityName,
			@QueryParam("phmc_startPinCode") Integer phmc_startPinCode,
			@QueryParam("phmc_endPinCode") Integer phmc_endPinCode, @QueryParam("phmc_emailID") String phmc_emailID,
			@QueryParam("phmc_followUpStatusList") String phmc_followUpStatusList,
			@QueryParam("phmc_kycStatusIsKycVerifiedByOfficial") String phmc_kycStatusIsKycVerifiedByOfficial,
			@QueryParam("phmc_kycStatusIsWalletCreated") String phmc_kycStatusIsWalletCreated,
			@QueryParam("phmc_kycStatusIsOtpSession") String phmc_kycStatusIsOtpSession,
			@QueryParam("phmc_kycStatusIsActivation") String phmc_kycStatusIsActivation,
			@QueryParam("phmc_kycStatusRemarks") String phmc_kycStatusRemarks,
			@QueryParam("phmc_SignUp") String phmc_SignUp, @QueryParam("phmc_welcomeMail") String phmc_welcomeMail,
			@QueryParam("phmc_basicDetailsIsFilled") String phmc_basicDetailsIsFilled,
			@QueryParam("phmc_kycStatusPremilinaryReview") String phmc_kycStatusPremilinaryReview,
			@QueryParam("phmc_kycEverythingValid") String phmc_kycEverythingValid,
			@QueryParam("phmc_stateName") String phmc_basicDetailsComState) {

		phmc_phob_userList = service.phmc_om_readPCOOnBoard(phmc_pageNo, phmc_pageSize, phmc_pcoID, phmc_endPCOID,
				phmc_cityName, phmc_startPinCode, phmc_endPinCode, phmc_emailID, phmc_followUpStatusList,
				phmc_kycStatusIsKycVerifiedByOfficial, phmc_kycStatusIsWalletCreated, phmc_kycStatusIsActivation,
				phmc_kycStatusIsOtpSession, phmc_kycStatusRemarks, phmc_SignUp, phmc_basicDetailsIsFilled,
				phmc_welcomeMail, phmc_kycStatusPremilinaryReview, phmc_kycEverythingValid, phmc_basicDetailsComState);
		if (phmc_phob_userList == null || phmc_phob_userList.size() == 0) {
			throw new SOPDB_NotFoundException("PCO  with ID " + phmc_pcoID + " Not Found");
		} else
			return phmc_phob_userList;
	}

	/**
	 * Method handling HTTP GET(Read) requests for PHOB_KYCFORM. The returned
	 * object will be sent to the client as "text/plain" media type.
	 */
	@GET
	@Path("/onboard/{pcoID}")
	@Produces(MediaType.APPLICATION_JSON)
	public PHMC_PHOB_ONBOARD phmc_pco_getKycPCODetail(@PathParam("pcoID") Long pcoID) {
		System.out.println("pcoID : " + pcoID);

		PHMC_PHOB_ONBOARD user = service.phmc_phob_getKycPCODetail(pcoID);
		if (user == null) {
			throw new SOPDB_NotFoundException("PCO  with ID " + pcoID + " Not Found");
		} else
			return user;
	}

	/**
	 * Method handling HTTP POST(Create) requests for PHOB_KYCFORM. The returned
	 * object will be sent to the client as ErrorCode and ErrorMessage media
	 * type.
	 */
	@POST
	@Path("/onboard")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response phmc_phob_createKycPCO(PHMC_PHOB_ONBOARD phmc_phob_pco) {

		ErrorMessage msg = service.phmc_phob_createKycPCODetail(phmc_phob_pco);

		System.out.println("service errorcode=" + msg.getErrorCode());
		return Response.status(msg.getErrorCode()).entity(msg).build();

	}

	/**
	 * Method handling HTTP PUT(Update) requests for PHOB_KYCFORM. The returned
	 * object will be sent to the client as ErrorCode and ErrorMessage media
	 * type.
	 */
	@PUT
	@Path("/onboard/{pcoID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response phmc_phob_updateKycPCO(@PathParam("pcoID") Long pcoID, PHMC_PHOB_ONBOARD phmc_phob_pco) {

		ErrorMessage msg = service.phmc_phob_updateKycPCODetail(pcoID, phmc_phob_pco);

		return Response.status(msg.getErrorCode()).entity(msg).build();
	}

	// --this is resource for both PHOB_USER and PHOB_KYCFORM join query----

	/**
	 * Method handling HTTP GET(Read) requests for both PHOB_USER and
	 * PHOB_KYCFORM. The returned object will be sent to the client as
	 * "text/plain" media type.
	 */

	@GET
	@Path("/phobonboard/{pcoID}")
	@Produces(MediaType.APPLICATION_JSON)
	public PHMC_PHOB_USER phmc_pco_getKycWithPCODetail(@PathParam("pcoID") Long pcoID) {
		System.out.println("pcoID : " + pcoID);

		PHMC_PHOB_USER user = service.phmc_phob_getKycWithPCODetail(pcoID);
		if (user == null) {
			throw new SOPDB_NotFoundException("PCO  with ID " + pcoID + " Not Found");
		} else
			return user;
	}

	/**
	 * Method handling HTTP PUT(Update) requests for both PHOB_USER and
	 * PHOB_KYCFORM. The returned object will be sent to the client as ErrorCode
	 * and ErrorMessage media type.
	 */
	@PUT
	@Path("/phobonboard/{pcoID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response phmc_phob_createupdateKycWithPCO(@PathParam("pcoID") Long pcoID, PHMC_PHOB_USER phmc_phob_pco) {

		ErrorMessage msg = service.phmc_phob_createUpdateKycWithPCO(pcoID, phmc_phob_pco);

		return Response.status(msg.getErrorCode()).entity(msg).build();
	}

}
