package com.abcmover.exception;

public class ShippingLineNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ShippingLineNotFoundException(Long id) {
		super(String.format("Container with Id %id not found", id));
	}
}
