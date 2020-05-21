package com.abcmover.exception;

public class ContainerNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ContainerNotFoundException(Long id) {
		super(String.format("Container with Id %id not found", id));
	}
}
