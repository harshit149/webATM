package com.atm.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.atm.utility.*;
import com.atm.model.UserDetails;

@Path("/Users")
public class AtmRestInterfaceUsers {
	ATMServiceImplementation lOperation=new ATMServiceImplementation();
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String Hello() {
		return "HelloWorld";
	}
	@POST
	@Path("/withdrawMoney")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response withdrawMoney(UserDTO user) throws DataNotFoundException{
		UserDetails luser=lOperation.withdrawMoney(user.getId(), user.getPassword(), user.getAmount());
		return Response.status(200).entity(luser).type(MediaType.APPLICATION_JSON).build(); 
		
	}
	@POST
	@Path("/depositMoney")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public  Response depositMoney(OperatorDTO operator) throws DataNotFoundException {
		long atmBalance= lOperation.depositMoney(operator.getId(), operator.getPassword(), operator.getAmount());
		return Response.status(200).entity(atmBalance).type(MediaType.APPLICATION_JSON).build(); 
	}
	@POST
	@Path("/checkbalancebyuser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public  Response checkBalanceByUser(UserBalanceDTO user) throws DataNotFoundException{
		long userBalance= lOperation.checkBalanceByUser(user.getId(), user.getPassword());
		return Response.status(200).entity(userBalance).type(MediaType.APPLICATION_JSON).build(); 
		
	}
	@POST
	@Path("/checkbalancebyoperator")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public  Response checkBalanceByOperator(OperatorBalanceDTO operator) throws DataNotFoundException{
		long atmBalance= lOperation.checkBalanceByOperator(operator.getId(), operator.getPassword());
		return Response.status(200).entity(atmBalance).type(MediaType.APPLICATION_JSON).build(); 
	}
	@POST
	@Path("/pinchange")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public  Response pinChange(UserPinDTO user) throws DataNotFoundException{
		String response=lOperation.pinChange(user.getId(),user.getPassword(),user.getNew_password1(),user.getNew_password2());
		return Response.status(200).entity(response).type(MediaType.APPLICATION_JSON).build(); 
	}
	@POST
	@Path("/getuserdetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserDetails(UserBalanceDTO user)throws DataNotFoundException {
		UserDetails luserDetails=lOperation.getUserDetails(user.getId(), user.getPassword());
		return Response.status(200).entity(luserDetails).type(MediaType.APPLICATION_JSON).build(); 
	}
}
