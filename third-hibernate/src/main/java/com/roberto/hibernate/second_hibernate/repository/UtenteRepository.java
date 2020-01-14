package com.roberto.hibernate.second_hibernate.repository;

import java.util.List;

import com.roberto.hibernate.second_hibernate.entity.Utente;

public interface UtenteRepository {

	public List<Utente> findAll();
	
	public Utente findById(Long id);
	
	public Long save(Utente message);
	
	public boolean update(Long id, Utente message);
	
	public boolean delete(Long id);
}
