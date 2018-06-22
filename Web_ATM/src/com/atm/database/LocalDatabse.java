package com.atm.database;
import java.util.HashMap;
import java.util.Map;

import com.atm.persistance.*;
public class LocalDatabse {
	private static final Map<Integer,User> usermap;
	private static final Map<Integer,Operator> operatormap;
	private static final Atm atmsingle;
	static {
		usermap=new HashMap<Integer,User>();
		operatormap=new HashMap<Integer,Operator>();
		atmsingle=new Atm();
		atmsingle.setId(1);
		atmsingle.setBal(500);
		for(int i=0;i<2;i++) {
			Operator o=new Operator();
			o.setId(i+10);
			o.setPassword(4321);
			operatormap.put(i+10, o);
		}
		for(int i=0;i<10;i++) {
			User u=new User();
			u.setId(i+1);
			u.setBal((i+1)*1000);
			u.setName("User"+(i+1));
			u.setPin(1234);
			usermap.put(i+1,u);
		}
		
	}
	public static Map<Integer, Operator> getoperatormap() {
		return operatormap;
	}
	public static Atm getatmobject() {
		return atmsingle;
	}
	public static Map<Integer, User> getusermap() {
		return usermap;
	}
}
