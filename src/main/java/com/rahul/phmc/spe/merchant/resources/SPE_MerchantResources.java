package com.rahul.phmc.spe.merchant.resources;

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

import com.rahul.phmc.spe.exception.SPE_Trxn_NotFoundException;
import com.rahul.phmc.spe.merchant.model.SPE_MerchantModel;
import com.rahul.phmc.spe.merchant.services.SPE_MerchantServices;
import com.rahul.phmc.spe.router.resources.SPE_XMonResources;
import com.rahul.phmc.util.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
@Path("merchants")
/**
 * @author rahul Makvana this method is Resource of Get input from user for
 *         getting merchant data, creating and updating the merchant.
 */
public class SPE_MerchantResources {
	// this is creation of logger so we can check what log created.
	static final Logger log = Logger.getLogger(SPE_MerchantResources.class);
	private SPE_MerchantServices service =new SPE_MerchantServices();
	private SPE_MerchantModel spe_mercahantmodel =new SPE_MerchantModel();
	List<SPE_MerchantModel> merchantmodellist=new ArrayList<SPE_MerchantModel>();
	ErrorMessage pay_error;
	
    @GET
	@Produces(MediaType.APPLICATION_JSON)
   public List<SPE_MerchantModel> SPE_readmerchantdetail(@QueryParam("SPE_UserName") String SPE_UserName,
		   @QueryParam("SPE_MerchantTable") String SPE_MerchantTable) throws SPE_Trxn_NotFoundException{
	   merchantmodellist=service.spe_readmerchantdata(SPE_UserName,SPE_MerchantTable);
	   if (merchantmodellist==null || merchantmodellist.size()==0) {
			log.info("Data not found");
			
				throw new SPE_Trxn_NotFoundException(" Record Not Found");
			
		} 
	return merchantmodellist;
	   
   }
		   
    @PUT
	@Path("/{Username}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
   public Response SPE_Createupdatemerchantdetail(@PathParam("Username")String spe_userName,SPE_MerchantModel spe_mercahantmodel){
	   ErrorMessage msg=service.payezee_createupdatemerchant(spe_userName,spe_mercahantmodel);
	   System.out.println("service errorcode=" + msg.getErrorCode());
	   return Response.status(msg.getErrorCode()).entity(msg).build();
	   
   }
}
