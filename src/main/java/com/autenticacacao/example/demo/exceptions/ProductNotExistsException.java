package com.autenticacacao.example.demo.exceptions;

public class ProductNotExistsException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotExistsException() {
		super("Product doesnt Exists");
	}
}
