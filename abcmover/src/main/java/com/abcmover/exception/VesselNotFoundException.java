package com.abcmover.exception;

public class VesselNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public VesselNotFoundException(Long id) {
		super(String.format("Vessel with Id %id not found", id));
	}
}
