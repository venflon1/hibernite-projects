package it.roberto.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//@Entity
//@Table(name="USER_H8")
public class User {
	
//	@Id
//	@GeneratedValue(generator="increment")
//	@GenericGenerator(name="increment", strategy = "increment")
	private int id;
	
//	@Column
	private String username;
	
//	@Column
	private String email;
	
//	@Column
	private String password;
	
	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
