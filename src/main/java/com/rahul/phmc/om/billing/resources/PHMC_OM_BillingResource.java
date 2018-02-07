
package com.rahul.phmc.om.billing.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rahul.phmc.om.billing.model.PHMC_OM_BILLING;
import com.rahul.phmc.om.billing.service.PHMC_OM_BillingService;
import com.rahul.phmc.sopdb.exception.SOPDB_NotFoundException;
import com.rahul.phmc.util.ErrorMessage;


/**
 * @author rahul makvana
 *
 */
@Path("billings")
public class PHMC_OM_BillingResource {

	PHMC_OM_BillingService billingService =  new PHMC_OM_BillingService();
	ErrorMessage phm_om_error;
	/**
	 * @return
	 */
	@GET
	@Path("/{pcoID}")
	@Produces(MediaType.APPLICATION_JSON)
	public PHMC_OM_BILLING  phmc_om_getBilling(@PathParam("pcoID") Long pcoID){
		
		PHMC_OM_BILLING billing = billingService.phmc_phob_readBillDetail(pcoID);
		if (billing == null) {
			throw new SOPDB_NotFoundException("Billing  with ID " + pcoID + " Not Found");
		} else
			return billing;
	}
	
	
	@GET		
	@Produces(MediaType.APPLICATION_JSON)
	public List<PHMC_OM_BILLING> phmc_phob_getALLBill(@QueryParam("phmc_pageNo") Integer phmc_pageNo,
			@QueryParam("phmc_pageSize") Integer phmc_pageSize,
			@QueryParam("phmc_pcoID") Long phmc_pcoID,
			@QueryParam("phmc_isStatementSent") int phmc_isStatementSent) {
		
		System.out.println("pcoID : " + phmc_pcoID);

		List<PHMC_OM_BILLING> billing = billingService.phmc_om_readAllBill( phmc_pageNo,  phmc_pageSize,
				phmc_pcoID,  phmc_isStatementSent  );
		if (billing == null || billing.isEmpty()) {
			throw new SOPDB_NotFoundException("No record  Found");
		} else
			return billing;
	}
	
		
	/**
	 * @return
	 */
	@PUT
	@Path("/{pcoID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response phmc_om_addBill(@PathParam("pcoID") Long pcoID, PHMC_OM_BILLING phmc_om_bill){
		
		 phm_om_error =  billingService.phmc_om_addUpdateBill(pcoID, phmc_om_bill);
		 
		 System.out.println("service errorcode=" + phm_om_error.getErrorCode());
		return Response.status(phm_om_error.getErrorCode()).entity(phm_om_error).build();
	}
}
