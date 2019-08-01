package com.booking.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Register")
public class Register implements Serializable {

	/**
	 * ,serial ID
	 */
	private static final long serialVersionUID = 1700281305410734790L;

	@Id
	@Column(name = "Email")
	private String email;

	@Column(name = "Name")
	private String name;

	@Column(name = "PhoneNo")

	private String phoneNo;

	@Column(name = "Password")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Reservation> reservation ;

	/**
	 * @return the reservation
	 */
	public Set<Reservation> getReservation() {
		return reservation;
	}

	/**
	 * @param reservation the reservation to set
	 */
	public void setReservation(Set<Reservation> reservation) {
		this.reservation = reservation;
	}

	public Register(String email, String name, String phoneNo, String password, Register emailReg,
			Register phoneNoReg) {
		super();
		this.email = email;
		this.name = name;
		this.phoneNo = phoneNo;
		this.password = password;

	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public Register() {
		super();
	}

}
