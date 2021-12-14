package com.example.immo.exceptions;

public class MaisonNotFoundException extends RuntimeException{
	public MaisonNotFoundException(String message) {
		super(message);
	}
}
