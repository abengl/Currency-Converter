package com.alessandragodoy.exception;

/**
 * Exception thrown when a client request fails.
 */
public class ClientRequestException extends RuntimeException {
	private final String message;

	public ClientRequestException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
