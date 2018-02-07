
package com.rahul.phmc.spe.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.rahul.phmc.util.ErrorMessage;



/**
 * @author rahul Makvana
 *
 */
@Provider
public class SPE_Trxn_NotFoundExceptionMapper implements ExceptionMapper<SPE_Trxn_NotFoundException> {

	
	
	@Override
	public Response toResponse(SPE_Trxn_NotFoundException ex) {
		// TODO Auto-generated method stub
		ErrorMessage msg = new ErrorMessage(ex.getMessage(), 404);
		return Response.status(Status.NOT_FOUND)
				.entity(msg)
				.build();
	}

}
