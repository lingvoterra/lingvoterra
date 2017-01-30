package com.lingvoterra.exception;

public class BadDataException extends RuntimeException {

	private static final long serialVersionUID = 4293429490189710200L;

	public BadDataException(String message) {
		super(message);
	}
}
