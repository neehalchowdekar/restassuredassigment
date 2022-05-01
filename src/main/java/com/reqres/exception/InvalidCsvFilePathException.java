package com.reqres.exception;

@SuppressWarnings("serial")
public class InvalidCsvFilePathException extends FrameworkException {

	public InvalidCsvFilePathException(String message) {
		super(message);
	}
	
	public InvalidCsvFilePathException(String message, Throwable cause) {
		super(message, cause);
	}
	

}
