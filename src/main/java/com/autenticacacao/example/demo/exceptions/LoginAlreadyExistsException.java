package com.autenticacacao.example.demo.exceptions;

public class LoginAlreadyExistsException extends Exception {
	public LoginAlreadyExistsException() {
		super("Login already exists.");
	}
}
