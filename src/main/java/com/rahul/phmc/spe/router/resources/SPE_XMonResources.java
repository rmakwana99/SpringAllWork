
package com.rahul.phmc.spe.router.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.rahul.phmc.spe.exception.SPE_Trxn_NotFoundException;
import com.rahul.phmc.spe.router.model.SPE_TRXNDetailsModel;
import com.rahul.phmc.spe.router.services.SPE_XMonService;
import com.rahul.phmc.util.ErrorMessage;

/**
 * @author rahul Makvana
 *
 */

@Path("transactions")
public class SPE_XMonResources {
	// this is creation of logger so we can check what log created.
	static final Logger log = Logger.getLogger(SPE_XMonResources.class);

	private SPE_XMonService spe_xmonservice = new SPE_XMonService();
	List<SPE_TRXNDetailsModel> xmon_modellist = new ArrayList<SPE_TRXNDetailsModel>();
	ErrorMessage msg = new ErrorMessage();

	// This method reads the query parameters from the user and provides data
	// according to that.
	// Here passing all those inputs to service method.

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SPE_TRXNDetailsModel> spe_getalltransactionids(
			@QueryParam("SPE_TransactionID") String SPE_TransactionID,
			@QueryParam("SPE_Txnstartdate") String Txnstartdate, @QueryParam("SPE_Txnenddate") String Txnenddate,
			@QueryParam("SPE_SettlementStatus") String SPE_SettlementStatus, @QueryParam("SPE_MID") String SPE_MID)
			throws SPE_Trxn_NotFoundException {
		System.out.println(Txnstartdate);
		System.out.println(Txnenddate);
		xmon_modellist = spe_xmonservice.spe_getalltransaction(SPE_TransactionID, Txnstartdate, Txnenddate,
				SPE_SettlementStatus, SPE_MID);

		if (xmon_modellist == null || xmon_modellist.size() == 0) {
			log.info("Data not found");

			throw new SPE_Trxn_NotFoundException(" Record Not Found");

		}

		return xmon_modellist;

	}

	/**
	 * Method handling HTTP POST(Create) requests for SPE_TRXNDetailsModel. The
	 * returned object will be sent to the client as ErrorCode and ErrorMessage
	 * as json media type.
	 */

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response spe_createTxnDetails(String spe_trxDetails) {

		log.info(spe_trxDetails);
		msg = spe_xmonservice.spe_createTxnDetails(spe_trxDetails);

		log.info("service errorcode=" + msg.getErrorCode());
		return Response.status(msg.getErrorCode()).entity(msg).build();
	}

	/**
	 * Method handling HTTP PUT(Update) requests for SPE_TRXNDetailsModel. The
	 * returned object will be sent to the client as ErrorCode and ErrorMessage
	 * as json media type.
	 */

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response spe_updateTxnDetails(String spe_trxDetails) {

		log.info(spe_trxDetails);
		msg = spe_xmonservice.spe_updateTxnDetails(spe_trxDetails);

		log.info("service errorcode=" + msg.getErrorCode());
		return Response.status(msg.getErrorCode()).entity(msg).build();
	}
}
