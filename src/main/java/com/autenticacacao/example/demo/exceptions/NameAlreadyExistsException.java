package com.autenticacacao.example.demo.exceptions;

public class NameAlreadyExistsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NameAlreadyExistsException() {
		super("Name already exists");
	}
}
