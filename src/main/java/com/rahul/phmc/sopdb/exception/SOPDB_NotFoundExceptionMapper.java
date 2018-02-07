package com.rahul.phmc.sopdb.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.rahul.phmc.util.ErrorMessage;


/**
 * @author rahul
 *
 */
@Provider
public class SOPDB_NotFoundExceptionMapper implements ExceptionMapper<SOPDB_NotFoundException> {

	
	
	@Override
	public Response toResponse(SOPDB_NotFoundException ex) {
		// TODO Auto-generated method stub
		ErrorMessage msg = new ErrorMessage(ex.getMessage(), 404);
		return Response.status(Status.NOT_FOUND)
				.entity(msg)
				.build();
	}

}
