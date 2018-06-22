package com.atm.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private String errorMessage;
	private int errorCode;
	public ErrorMessage() {
		
	}
	public ErrorMessage(String message, int i) {
		this.errorMessage=message;
		this.errorCode=i;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	@Override
	public String toString() {
		return "ErrorMessage [errorMessage=" + errorMessage + ", errorCode=" + errorCode + "]";
	}
	
	
}
