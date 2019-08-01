package com.booking.dto;

import java.util.Set;

import com.booking.entity.MeetingRoom;

public class BuildingDto {

	private String building;
	/**
	 * @return the building
	 */
	public String getBuilding() {
		return building;
	}
	/**
	 * @param building the building to set
	 */
	public void setBuilding(String building) {
		this.building = building;
	}
	/**
	 * @return the meetingRoom
	 */
	public Set<MeetingRoom> getMeetingRoom() {
		return MeetingRoom;
	}
	/**
	 * @param meetingRoom the meetingRoom to set
	 */
	public void setMeetingRoom(Set<MeetingRoom> meetingRoom) {
		MeetingRoom = meetingRoom;
	}
	private Set<MeetingRoom> MeetingRoom;

}
