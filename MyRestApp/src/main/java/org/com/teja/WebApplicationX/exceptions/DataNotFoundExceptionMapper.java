package org.com.teja.WebApplicationX.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.com.teja.WebApplicationX.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException DNFeX) {
	
		ErrorMessage errormessage = new ErrorMessage(DNFeX.getMessage(),808," you can do better! ");
		return Response.status(Status.NOT_FOUND).entity(errormessage).build();
	}

}
