package com.booking.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;


@Entity
@Table(name="Meeting_Room")
public class MeetingRoom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8110394643875757105L;


	@Id
	@Column
	private String roomNo;

	@Column(name="persons")
	private Integer persons;

	@Column(name="WIFI")
	private boolean WIFI;
	
	
	@ManyToOne
	@JoinColumn( referencedColumnName = "building")
	@Fetch(org.hibernate.annotations.FetchMode.JOIN)
	private Building building;

	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Reservation> reservation ;
	/**
	 * @return the roomNo
	 */
	public String getRoomNo() {
		return roomNo;
	}


	/**
	 * @param roomNo the roomNo to set
	 */
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}


	/**
	 * @return the persons
	 */
	public Integer getPersons() {
		return persons;
	}


	/**
	 * @param persons the persons to set
	 */
	public void setPersons(Integer persons) {
		this.persons = persons;
	}


	/**
	 * @return the wIFI
	 */
	public boolean isWIFI() {
		return WIFI;
	}


	/**
	 * @param wIFI the wIFI to set
	 */
	public void setWIFI(boolean wIFI) {
		WIFI = wIFI;
	}


	/**
	 * @return the building
	 */
	public Building getBuilding() {
		return building;
	}


	/**
	 * @param building the building to set
	 */
	public void setBuilding(Building building) {
		this.building = building;
	}


	public MeetingRoom(String roomNo, Integer persons, boolean WIFI, Building building) {
		super();
		this.roomNo = roomNo;
		this.persons = persons;
		this.WIFI = WIFI;
		this.building = building;
	}

	

	public MeetingRoom() {
		super();
	}

}
