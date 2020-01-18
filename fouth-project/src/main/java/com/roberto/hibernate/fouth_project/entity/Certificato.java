package com.roberto.hibernate.fouth_project.entity;

import java.io.Serializable;
import java.util.Set;

public class Certificato implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nomeCertificato;
	private Impiegato impiegato;
	
	public Certificato() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCertificato() {
		return nomeCertificato;
	}

	public void setNomeCertificato(String nomeCertificato) {
		this.nomeCertificato = nomeCertificato;
	}
	
	

	public Impiegato getImpiegato() {
		return impiegato;
	}

	public void setImpiegato(Impiegato impiegato) {
		this.impiegato = impiegato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeCertificato == null) ? 0 : nomeCertificato.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Certificato other = (Certificato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeCertificato == null) {
			if (other.nomeCertificato != null)
				return false;
		} else if (!nomeCertificato.equals(other.nomeCertificato))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Certificato [id=" + id + ", nomeCertificato=" + nomeCertificato + "]";
	}

}
