package com.abcmover.exception;

public class NoRecordFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoRecordFoundException() {
		super("No data found.");
	}
}
