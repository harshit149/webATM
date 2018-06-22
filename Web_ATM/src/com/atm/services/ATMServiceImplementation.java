package com.atm.services;
import com.atm.model.UserDetails;
import com.atm.persistance.*;
import java.util.Map;

import com.atm.database.*;
public class ATMServiceImplementation implements ATMService {
	
	
	public User validateUser(int id,int password) throws DataNotFoundException {
		Map<Integer, User> usermap;
		usermap=LocalDatabse.getusermap();
		if(usermap.containsKey(id)) {
			User luser=usermap.get(id);
			 if(luser.getPin()==password) 
				 return luser;
			 else
				 throw new DataNotFoundException("Pin incorrect");
			 
		}else {
			throw new DataNotFoundException("User Not Found");
		}
		
		
	}
	
	
	public Operator validateOperator(int id,int password) throws DataNotFoundException {
		Map<Integer, Operator> operatormap;
		operatormap=LocalDatabse.getoperatormap();
		if(operatormap.containsKey(id)) {
			 Operator loperator=operatormap.get(id);
			 if(loperator.getPassword()==password) 
				 return loperator;
			 else
				 throw new DataNotFoundException("Pin incorrect");
			 
		}else {
			throw new DataNotFoundException("Operator Not Found");
		}
	}
	
	@Override
	public long depositMoney(int id, int password, int amount) throws DataNotFoundException {
		if(amount<=0)
			throw new DataNotFoundException("Amount should be greater than zero");
		Operator loperator=validateOperator(id,password);
		if(loperator==null)
			throw new DataNotFoundException("Operator Not Found");
		//error msgs
		else {Atm latm=LocalDatabse.getatmobject();
			latm.setBal(latm.getBal()+amount);
			return latm.getBal();
		}
		
	}

	@Override
	public long checkBalanceByUser(int id, int password) throws DataNotFoundException {
		User luser=validateUser(id,password);
		if(luser!=null) {
			System.out.println(luser.getName());
			System.out.println("Your Balance is "+luser.getBal());
			return luser.getBal();
		}else
			throw new DataNotFoundException("User Not Found");
	}

	@Override
	public UserDetails withdrawMoney(int id, int password, int amount) throws DataNotFoundException{
		if(amount<=0)
			throw new DataNotFoundException("Amount should be greater than zero");
		UserDetails luserdetails=new UserDetails();
		User luser=validateUser(id,password);
		if(luser==null)
			throw new DataNotFoundException("User Not Found");
		else {Atm latm=LocalDatabse.getatmobject();
			if(amount>luser.getBal())
				throw new DataNotFoundException("Your account balance is not sufficient");
			else if(amount>latm.getBal())
				throw new DataNotFoundException("Atm is out of cash");
			latm.setBal(latm.getBal()-amount);
			luser.setBal(luser.getBal()-amount);
			luserdetails.setId(luser.getId());
			luserdetails.setBal(luser.getBal());
			luserdetails.setName(luser.getName());
			
			return luserdetails;
		}
		
	}

	@Override
	public long checkBalanceByOperator(int id, int password) throws DataNotFoundException {
		Operator lOperator=validateOperator(id,password);
		if(lOperator!=null) {
			Atm lAtm=LocalDatabse.getatmobject();
			System.out.println("The current balance in this ATM Machine is "+lAtm.getBal());
			return lAtm.getBal();
		}else
			throw new DataNotFoundException("Operator Not Found");
	}

	@Override
	public String pinChange(int id, int oldpin, int newpin, int confirmnewpin) throws DataNotFoundException {
		User luser=validateUser(id,oldpin);
		if(luser==null)
			throw new DataNotFoundException("User Not Found");
		else {
			if(newpin!=confirmnewpin&&newpin!=oldpin)
				throw new DataNotFoundException("New Pin and Old pin same");
			else {
				luser.setPin(newpin);
			}
			return "PIN changed";
		}
	}

	@Override
	public UserDetails getUserDetails(int id, int password) throws DataNotFoundException {
		User luser=validateUser(id,password);
		if(luser==null)
			throw new DataNotFoundException("User Not Found");
		else {
			UserDetails luserview=new UserDetails();
			luserview.setId(luser.getId());
			luserview.setName(luser.getName());
			luserview.setBal(luser.getBal());
			return luserview;
		}
	}
	

}
