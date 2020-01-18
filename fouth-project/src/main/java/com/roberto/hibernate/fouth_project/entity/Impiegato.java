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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Set<Certificato> getCertificati() {
		return certificati;
	}

	public void setCertificati(Set<Certificato> certificati) {
		this.certificati = certificati;
	}

	@Override
	public String toString() {
		return "Impiegato [id=" + id + ", nome=" + nome + ", salario=" + salario + ", certificati=" + certificati + "]";
	}
	
}
