package com.rahul.phmc.sdp.commssion.dist.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.rahul.phmc.sdp.commssion.dist.dao.SPE_CommssionDistDAO;
import com.rahul.phmc.sdp.commssion.dist.service.SPE_CommssionDistService;
import com.rahul.phmc.util.ErrorMessage;

/**
 * @author rahul Makvana
 *
 */
@Path("/commission")
public class SPE_CommissionResource {
	static final Logger log = Logger.getLogger(SPE_CommssionDistDAO.class);
	private SPE_CommssionDistService  cmsnService;
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public Response calculateCommission(@QueryParam("spe_startDate") String startDate){
		cmsnService = new SPE_CommssionDistService();
	boolean isDone = cmsnService.callCommissionDist(startDate);
		if(isDone){
			return Response.status(200)
					.entity( new ErrorMessage("Commission Distributed successfully!!", 200))
					.build();
		}else
			return Response.status(500)
					.entity(new ErrorMessage("Commission Distribution failed!!", 500))
					.build();
	}

}
