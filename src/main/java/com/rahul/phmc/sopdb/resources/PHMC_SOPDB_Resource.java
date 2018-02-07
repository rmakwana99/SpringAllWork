
package com.rahul.phmc.sopdb.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.rahul.phmc.sopdb.exception.SOPDB_NotFoundException;
import com.rahul.phmc.sopdb.model.PHMC_SOPDB;
import com.rahul.phmc.sopdb.service.PHMC_SOPDB_Service;
import com.rahul.phmc.util.ErrorMessage;
import com.rahul.phmc.util.PHMC_Record;


/**
 * Handling SOPDB related request
 * @author rahul Makvana
 *
 */
@Path("sopdb")
public class PHMC_SOPDB_Resource {
	
	PHMC_SOPDB_Service phmc_om_service =  new PHMC_SOPDB_Service();
	List<PHMC_SOPDB>	sopdbList;
	ErrorMessage phm_om_error;
	
	/**
	 * @param phmc_sopdb_pageNo
	 * @param phmc_sopdb_pageSize
	 * @param pcoID
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public  List<PHMC_SOPDB> phmc_om_getALLSOPDBData(@QueryParam("phmc_pageNo") Integer phmc_pageNo,
			@QueryParam("phmc_pageSize") Integer phmc_pageSize,
			@QueryParam("phmc_pcoID") String phmc_pcoID,
			@QueryParam("phmc_startDate") String phmc_startDate,
			@QueryParam("phmc_endDate") String phmc_endDate){
		 
				sopdbList = phmc_om_service.phmc_getAllSOPDB(phmc_pageNo, phmc_pageSize, phmc_pcoID, phmc_startDate,
						phmc_endDate);
			
		System.out.println("sopdbList "  + sopdbList.isEmpty());
		 if(sopdbList.isEmpty()){
				throw new SOPDB_NotFoundException("No records found for PCO  ID " + phmc_pcoID + "");
			}	
		
	
		return sopdbList;
	}
	
	/**
	 * @param phmc_sopdb_pageNo
	 * @param phmc_sopdb_pageSize
	 * @param pcoID
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@GET
	@Path("/phmc_sopdbRecord")
	@Produces(MediaType.APPLICATION_JSON)
	public  PHMC_Record  phmc_om_getSOPDBRECORD(@QueryParam("phmc_pcoID") String phmc_pcoID,
			@QueryParam("phmc_startDate") String phmc_startDate,
			@QueryParam("phmc_endDate") String phmc_endDate){		
		
		Integer	phmc_sopdb_record = phmc_om_service.getSOPDBRecord(phmc_pcoID, phmc_startDate, phmc_endDate);
		
		PHMC_Record record= new PHMC_Record(phmc_sopdb_record);
	
		 return record;
	}
}
