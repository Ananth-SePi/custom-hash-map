package com.sepi.exception;

/**
 * @author Ananth-SePi
 * Custom exception class when the given key not in the custom map.
 */

public class KeyNotFoundException extends Exception {
	
	private static final long serialVersionUID = -7011625487052455162L;
	private static final String EXCEPTION_MESSAGE = "Given key not found in the custom map.";
	
	public KeyNotFoundException() {
		super(EXCEPTION_MESSAGE);
	}

}
