package com.atm.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.atm.utility.*;

@Path("/Operators")
public class AtmRestInterfaceOperators {
	ATMServiceImplementation lOperation=new ATMServiceImplementation();
	@POST
	@Path("/depositMoney")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public long depositMoney(OperatorDTO operator) throws DataNotFoundException {
		return lOperation.depositMoney(operator.getId(), operator.getPassword(), operator.getAmount());
	}
	@POST
	@Path("/checkbalancebyoperator")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public long checkBalanceByOperator(OperatorBalanceDTO operator) throws DataNotFoundException {
		return lOperation.checkBalanceByOperator(operator.getId(), operator.getPassword());
	}
}
