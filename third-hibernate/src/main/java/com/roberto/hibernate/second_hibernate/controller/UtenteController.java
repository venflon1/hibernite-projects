package com.roberto.hibernate.second_hibernate.controller;

import com.roberto.hibernate.second_hibernate.entity.Utente;
import com.roberto.hibernate.second_hibernate.service.UtenteService;

public class UtenteController {
	
	private UtenteService utenteService = new UtenteService();
	
	public boolean login(Utente user) {
		Utente userStorage = utenteService.getUserById(user.getId());
		boolean loginSuccess = false;
		
		if(userStorage != null && user != null) {
			if( userStorage.getEmail().equalsIgnoreCase(user.getEmail()) && userStorage.getPassword().equals(user.getPassword()))
				loginSuccess =  true;
		}
		
		return loginSuccess;
	}
	
}
