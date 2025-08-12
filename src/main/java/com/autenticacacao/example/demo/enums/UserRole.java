package com.autenticacacao.example.demo.enums;

public enum UserRole {
	CLIENT("client"),
	ADMIN("admin");
	
	private String role;
	
	UserRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
}
