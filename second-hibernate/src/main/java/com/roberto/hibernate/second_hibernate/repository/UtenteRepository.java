package com.roberto.hibernate.second_hibernate.repository;

import java.util.List;

import com.roberto.hibernate.second_hibernate.entity.Utente;

public interface UtenteRepository {

	public List<Utente> findAll();
	
	public Utente findById(Long id);
	
	public Long save(Utente message);
	
	public Utente update(Long id, Utente message);
	
	public void delete(Long id);
}
