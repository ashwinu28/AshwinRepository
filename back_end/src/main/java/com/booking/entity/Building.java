package com.booking.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;;

@Entity
@Table(name="Building")
public class Building implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3890616245660314094L;

	@Id
	@Column(name="building")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<MeetingRoom> MeetingRoom;


	
	




	public Building(String name, Set<MeetingRoom> MeetingRoom) {
		super();
		this.name = name;
		this.MeetingRoom = MeetingRoom;
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
	 * @return the roomNo
	 */
	public Set<MeetingRoom> getMeetingRoom() {
		return MeetingRoom;
	}





	/**
	 * @param roomNo the roomNo to set
	 */
	public void setRoomNo(Set<MeetingRoom> MeetingRoom) {
		this.MeetingRoom = MeetingRoom;
	}





	public Building() {
		super();
	}
}
