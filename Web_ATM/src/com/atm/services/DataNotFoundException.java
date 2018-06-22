package com.atm.services;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.atm.model.ErrorMessage;

@Provider
public class DataNotFoundException extends Exception implements ExceptionMapper<DataNotFoundException> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException() {
		super("No User Found");
	}
	public DataNotFoundException(String Message) {
		super(Message);  
	}
	
	@Override
	public Response toResponse(DataNotFoundException exception) {
		//System.out.println("about to return exception");
		ErrorMessage errorMessage=new ErrorMessage(exception.getMessage(),404);
		 return Response.status(404).entity(errorMessage)
                 .type("application/json").build();
	}

}
