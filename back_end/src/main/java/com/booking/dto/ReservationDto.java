package com.booking.dto;


import java.util.Date;

import com.booking.entity.MeetingRoom;
import com.booking.entity.Register;


public class ReservationDto {

	
	private Date date;
	private Date startTime;
	private Date endTime;
	private String event_name;
	private String event_type;
	
	private String info;
	private Register register;
	private String meetingRoom;
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
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the event_name
	 */
	public String getEvent_name() {
		return event_name;
	}
	/**
	 * @param event_name the event_name to set
	 */
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	/**
	 * @return the event_type
	 */
	public String getEvent_type() {
		return event_type;
	}
	/**
	 * @param event_type the event_type to set
	 */
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * @return the register
	 */
	public Register getRegister() {
		return register;
	}
	/**
	 * @param register the register to set
	 */
	public void setRegister(Register register) {
		this.register = register;
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
	
	
	
}
	