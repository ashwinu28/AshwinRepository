package com.booking.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class ReservationId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 32338208334774673L;

	
	
	private Date date;
	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the meetingRoom
	 */
	public String getMeetingRoom() {
		return meetingRoom;
	}
	/**
	 * @param meetingRoom the meetingRoom to set
	 */
	public void setMeetingRoom(String meetingRoom) {
		this.meetingRoom = meetingRoom;
	}
	private Date startTime;
	
	 private String meetingRoom;
	public ReservationId() {
		super();
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((meetingRoom == null) ? 0 : meetingRoom.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
		ReservationId other = (ReservationId) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (meetingRoom == null) {
			if (other.meetingRoom != null)
				return false;
		} else if (!meetingRoom.equals(other.meetingRoom))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}
	
	

	



	
	
	
	
	
	
}
