package com.autenticacacao.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.autenticacacao.example.demo.domain.user.User;
import com.autenticacacao.example.demo.exceptions.LoginAlreadyExistsException;
import com.autenticacacao.example.demo.repository.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService {
	@Autowired
	UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repo.findByLogin(username);
		
	}
	
	public void saveUser(User user) throws LoginAlreadyExistsException {
		if(repo.findByLogin(user.getLogin()) != null) {
			throw new LoginAlreadyExistsException();
		}
		repo.save(user);
	}

}
