package com.autenticacacao.example.demo.domain.user;

import com.autenticacacao.example.demo.enums.UserRole;

import jakarta.validation.constraints.NotNull;

public class RegisterDto {
	@NotNull(message="Login cant be null")
	private String login;
	@NotNull(message="Password cant be null")
	private String password;
	
	private UserRole role;
	
	public RegisterDto(String login, String password, UserRole role) {
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
}

