package com.example.immo.exceptions;

public class AppartementNotFoundException extends RuntimeException{
	public AppartementNotFoundException(String message) {
		super(message);
	}
}
