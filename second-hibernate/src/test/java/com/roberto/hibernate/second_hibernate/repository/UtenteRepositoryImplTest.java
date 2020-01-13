package com.roberto.hibernate.second_hibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;

import com.roberto.hibernate.second_hibernate.entity.Utente;

public class UtenteRepositoryImplTest {

	@Test
	public void findAllTest() {
		UtenteRepository userRepository = new UtenteRepositoryImpl();
		List<Utente> listMessages = userRepository.findAll();
		assertNotNull(listMessages);
	}
	
	@Test
	public void findByIdTest() {
		UtenteRepository userRepository = new UtenteRepositoryImpl();
		long id = 1;
		Utente msg = userRepository.findById(id);
		assertNotNull(msg);
		assertEquals(new Long(id), msg.getId());
	}
	
	@Test
	public void saveTest() {
		UtenteRepository userRepository = new UtenteRepositoryImpl();
		Utente usr = new Utente("pippo91", "paolo.rossi@email.it", "qwertyui", Timestamp.valueOf(LocalDateTime.now()));
		Long ID = userRepository.save(usr);
		assertNotNull(ID);
	}
	
	@Test
	public void updateTest() {
		UtenteRepository userRepository = new UtenteRepositoryImpl();
		Utente msgToUpdate = new Utente("pluto", "pluto.disney@email.it", "pppppaaaa", Timestamp.valueOf(LocalDateTime.now()));
		long id = 1;
		Utente msgUpdated = userRepository.update(id, msgToUpdate);
		assertEquals("pluto", userRepository.findById(new Long(id)).getUsername());
	}
	
	@Test
	public void deleteTest() {
		UtenteRepository userRepository = new UtenteRepositoryImpl();
		long id = 4;
		userRepository.delete(id);
		assertNull(userRepository.findById(new Long(id)));
		
	}
}