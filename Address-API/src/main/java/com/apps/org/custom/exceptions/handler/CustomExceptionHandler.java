package com.apps.org.custom.exceptions.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class CustomExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = -7806029002430564887L;

	private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

	private String errorMessage;
	private int errorCode;
	private HttpStatus httpStatus;

	public CustomExceptionHandler() {}

	public CustomExceptionHandler(String message) {
		this.errorMessage = message;
	}

	public CustomExceptionHandler(Throwable throwable) {
		super(throwable);
	}

	public CustomExceptionHandler(String message, int errorCode) {
		//super();
		this.errorCode = errorCode;
		this.errorMessage = message;
	}

	public CustomExceptionHandler(String message, Throwable throwable) {
		super(message, throwable);
	}

	public CustomExceptionHandler(String message, Throwable throwable, int errorCode) {
		super(message, throwable);
		this.errorCode = errorCode;
	}

	public CustomExceptionHandler(String message, int errorCode, HttpStatus httpStatus) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = message;
		this.httpStatus = httpStatus;
	}

	public void addExceptions(CustomExceptionHandler customExceptionHandler, int errorCode, String message, HttpStatus httpStatus) {
		this.errorCode = errorCode;
		this.errorMessage = message;
		this.httpStatus = httpStatus;
	}

	public CustomExceptionHandler(HttpStatus httpStatus, Integer errorCode, String... message) {
		logger.error("Exception : CustomExceptionHandler");
		System.out.println("Exception : CustomExceptionHandler");
		String messageString = "";
		for (int i=0; i < message.length; i+=2) {
			messageString += "{\n \"" + message[i] + "\": \"" + message[i+1] + "\" \n}"; 
		}
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
		this.errorMessage = messageString;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String message) {
		this.errorMessage = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	/*
	 * public Map<String, String> getCustomMessageMap() { return customMessageMap; }
	 * 
	 * public void setCustomMessageMap(Map<String, String> customMessageMap) {
	 * this.customMessageMap = customMessageMap; }
	 */

	@Override
	public String toString() {
		return " {/n" 
				+ " HttpStatus: " + this.httpStatus 
				+ " ErrorCode: " + this.errorCode 
				+ " ErrorMessage: " + this.errorMessage
				+ "/n }";
	}
}
