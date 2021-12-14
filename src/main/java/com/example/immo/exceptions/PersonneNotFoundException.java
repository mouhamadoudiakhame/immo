package com.example.immo.exceptions;

public class PersonneNotFoundException extends RuntimeException {
	public PersonneNotFoundException(String message) {
		super(message);
	}
}
