package com.booking.entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Login")
public class Login implements Serializable{

	
	/**
	 * serial version ID.
	 */
	private static final long serialVersionUID = -3375541687500218098L;
	
	
	@Id
	@Column(name = "Email")
	private String email;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Column(name = "Password")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	public Login() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
