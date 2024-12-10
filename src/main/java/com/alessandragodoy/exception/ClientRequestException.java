package com.alessandragodoy.exception;

public class ClientRequestException extends RuntimeException {
	private String message;
	public ClientRequestException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
