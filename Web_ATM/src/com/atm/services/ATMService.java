package com.atm.services;
import com.atm.model.*;
public interface ATMService {
	/**
	 * 
	 * @param id
	 * @param password
	 * @param amount
	 * @return
	 */
	public long depositMoney(int id,int password,int amount) throws DataNotFoundException;
	/**
	 * 
	 * @param id
	 * @param password
	 * @return
	 */
	public long checkBalanceByUser(int id,int password) throws DataNotFoundException;
	public UserDetails withdrawMoney(int id,int password,int amount) throws DataNotFoundException;
	public long checkBalanceByOperator(int id,int password) throws DataNotFoundException;
	public String pinChange(int id,int oldp,int newp1,int newp2) throws DataNotFoundException;
	public UserDetails getUserDetails(int id,int password) throws DataNotFoundException;
}
