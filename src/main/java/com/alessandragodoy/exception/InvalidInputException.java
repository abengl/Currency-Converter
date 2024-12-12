package com.alessandragodoy.exception;

/**
 * Exception thrown when an invalid input is provided.
 */
public class InvalidInputException extends RuntimeException {
	private final String message;

	public InvalidInputException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
