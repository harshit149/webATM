package com.atm.persistance;
public class User {
	private int id;
	private int pin;
	private String name;
	private long balance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getBal() {
		return balance;
	}
	public void setBal(long bal) {
		this.balance = bal;
	}
}
