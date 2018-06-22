package com.atm.model;

public class UserDetails {
	private int id;
	private long balance;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getBal() {
		return balance;
	}
	public void setBal(long bal) {
		this.balance = bal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
