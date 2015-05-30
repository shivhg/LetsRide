package com.mvc;

public class MvcException extends Exception {

	private static final long serialVersionUID = 1L;

	public MvcException() {
		super();
	}

	public MvcException(String message, Throwable cause) {
		super(message, cause);
	}

	public MvcException(String message) {
		super(message);
	}

	public MvcException(Throwable cause) {
		super(cause);
	}

}
