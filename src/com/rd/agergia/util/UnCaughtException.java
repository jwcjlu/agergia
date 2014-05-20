package com.rd.agergia.util;



@SuppressWarnings("serial")
public class UnCaughtException extends RuntimeException {

	public UnCaughtException() {
		super();
	}

	public UnCaughtException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnCaughtException(String message) {
		super(message);
	}

	public UnCaughtException(Throwable cause) {
		super(cause);
	}
}
