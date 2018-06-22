package com.atm.utility;

public class UserPinDTO {
	private int id;
	private int password;
	private int new_password1;
	private int new_password2;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getNew_password1() {
		return new_password1;
	}
	public void setNew_password1(int new_password1) {
		this.new_password1 = new_password1;
	}
	public int getNew_password2() {
		return new_password2;
	}
	public void setNew_password2(int new_password2) {
		this.new_password2 = new_password2;
	}
}
