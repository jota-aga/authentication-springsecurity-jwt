package com.autenticacacao.example.demo.domain.user;

import jakarta.validation.constraints.NotNull;

public class AuthenticationDto {
	@NotNull(message="Login cant be null")
	private String login;
	@NotNull(message="Password cant be null")
	private String password;
	
	public AuthenticationDto(String login, String password) {
		this.login = login;
		this.password = password;
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
}
