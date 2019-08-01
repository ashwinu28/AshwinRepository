package com.booking.dto;

import com.booking.entity.Building;

public class MeetingRoomDto {
	
	private String roomNo;
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
	private Integer persons;
	private boolean WIFI;
	private Building building;
	
	
	
	
}
