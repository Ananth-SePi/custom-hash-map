package com.sepi.exception;

/**
 * @author Ananth-SePi
 * Custom exception class when the given key already in the custom map.
 */

public class DuplicateKeyException extends Exception {
	
	private static final long serialVersionUID = 353356461388672917L;
	private static final String EXCEPTION_MESSAGE = "Given key already present in the custom map.";

	public DuplicateKeyException() {
		super(EXCEPTION_MESSAGE);
	}
}
