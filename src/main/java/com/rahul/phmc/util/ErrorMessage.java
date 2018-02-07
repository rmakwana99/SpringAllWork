package com.rahul.phmc.util;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rahul Makvana
 *
 */
@XmlRootElement
public class ErrorMessage {
	
	private String errorMessage;
	private int errorCode;
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ErrorMessage(String errorMessage, int errorCode) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
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
	

}
