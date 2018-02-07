
package com.rahul.phmc.spe.roles.resource;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.rahul.phmc.spe.exception.SPE_Trxn_NotFoundException;
import com.rahul.phmc.spe.roles.model.SPE_Roles_ReadExcelModel;
import com.rahul.phmc.spe.roles.service.SPE_Roles_ReadExcelService;

/**
 * @author rahul makvana this class is Resource of Get data from Excel of
 *         PHMC-OPS-ROLES DDMONyyyy.XLSX and give the access the function to the Roles
 */
@Path("roles")
public class SPE_Roles_ReadExcelResource {

	// this is creation of logger so we can check what log created.
	static final Logger log = Logger.getLogger(SPE_Roles_ReadExcelResource.class);

	SPE_Roles_ReadExcelService service = new SPE_Roles_ReadExcelService();

	@Path("readAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response spe_readRoles() throws SPE_Trxn_NotFoundException{
		
		List<SPE_Roles_ReadExcelModel> spe_RoleList= new ArrayList<SPE_Roles_ReadExcelModel>();
		
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream("PHMC-OPS-ROLES V2.3 03AUG2017.xlsx");
		if(is == null){
			log.error("ops-Roles Excel Not Found");
			throw new SPE_Trxn_NotFoundException("ops-Roles Excel Not Found");
		}
		try{
		spe_RoleList=service.spe_getRoleList(is);
		}catch (NumberFormatException e) {
			log.error("ops-Roles Excel has wrong rolecode");
			throw new SPE_Trxn_NotFoundException("ops-Roles Excel has wrong rolecode.");
		}
		return Response.status(200).entity(new GenericEntity<List<SPE_Roles_ReadExcelModel>>(spe_RoleList) {}).build();
	}

}
