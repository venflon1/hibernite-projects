package com.roberto.hibernate.second_hibernate.service;

import java.util.regex.Pattern;

import com.roberto.hibernate.second_hibernate.entity.Utente;
import com.roberto.hibernate.second_hibernate.repository.UtenteRepository;
import com.roberto.hibernate.second_hibernate.repository.UtenteRepositoryImpl;

public class UtenteService {
	
	private UtenteRepository userRepository = new UtenteRepositoryImpl();
	
	public Long createUser(Utente user) {
		Long id = user.getId();
		String username = user.getUsername().trim();
		String emailUser = user.getEmail();
		String password = user.getPassword().trim();
		
		if(username == null || emailUser == null || password == null)
			return -2L; // error type
		
		boolean match = Pattern.matches(".*@.*\\.[it | com | de | uk | fr]", emailUser);
		
		if(id < 0 || username.equals("") || !match || password.equals(""))
			return -1L; // error type
		
		return userRepository.save(user);
	}
	
	public boolean updateUser(Utente userUpdated) {
		// TODO
		return true;
	}
	
	public Utente getUserById(Long id) {
		if(id == null || id < 0)
			return null;
		return userRepository.findById(id);
	}
	
	public boolean deleteUser(Long id) {
		// TODO
		return true;
	}
}
