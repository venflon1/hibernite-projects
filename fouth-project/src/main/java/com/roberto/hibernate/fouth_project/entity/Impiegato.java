package com.roberto.hibernate.fouth_project.entity;

import java.io.Serializable;
import java.util.Set;

public class Impiegato implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private double salario;
	private Set<Certificato> certificati;
	
	public Impiegato() {
		super();
	}

}
