package com.autenticacacao.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autenticacacao.example.demo.domain.user.AuthenticationDto;
import com.autenticacacao.example.demo.domain.user.LoginResponseDto;
import com.autenticacacao.example.demo.domain.user.RegisterDto;
import com.autenticacacao.example.demo.domain.user.User;
import com.autenticacacao.example.demo.exceptions.LoginAlreadyExistsException;
import com.autenticacacao.example.demo.infra.security.TokenService;
import com.autenticacacao.example.demo.service.AuthorizationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private AuthorizationService authorizationService;
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity login(@Valid @RequestBody AuthenticationDto data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken((User) auth.getPrincipal());
		return ResponseEntity.ok(new LoginResponseDto(token));
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@Valid @RequestBody RegisterDto register) throws LoginAlreadyExistsException {
		String encryptedPassword = new BCryptPasswordEncoder().encode(register.getPassword());
		User user = new User(register.getLogin(), encryptedPassword, register.getRole());
		
		authorizationService.saveUser(user);
		
		return ResponseEntity.created(null).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getUser(@PathVariable Long id) {
		return ResponseEntity.ok(authorizationService.getUserById(id));
	}
}
