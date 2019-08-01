package com.booking.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;


@Entity
@IdClass(ReservationId.class)
@Table(name="reservation")
public class Reservation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -509563087762244022L;

	

	
	@Id
	@Column(name="Date")
	@Temporal(TemporalType.DATE)
	private Date date;
	


	@Id
	@Column(name="start_Time")
	@Temporal(TemporalType.TIME)
	private Date startTime;
	
	
	@Column(name="End_Time")
	@Temporal(TemporalType.TIME)
	private Date endTime;

	

	@Column(name="event_name")
	private String event_name;
	
	@Column(name="event_type")
	private String event_type;
	

	
	@Column(name="additional_info")
	private String info;
	
	
	@ManyToOne
	@JoinColumn( referencedColumnName = "Email")
	@Fetch(org.hibernate.annotations.FetchMode.JOIN)
	private Register register;

	@Id
	@ManyToOne
	@JoinColumn( referencedColumnName = "roomNo")
	@Fetch(org.hibernate.annotations.FetchMode.JOIN)
	private MeetingRoom meetingRoom;


	


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
	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}


	/**
	 * @param meetingRoom the meetingRoom to set
	 */
	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}


	
//	public Reservation(Date date, Date time, Date endTime, String event_name, String event_type, String info,
//			Register register, MeetingRoom meetingRoom) {
//		super();
//		this.date = date;
//		this.time = time;
//		this.endTime = endTime;
//		this.event_name = event_name;
//		this.event_type = event_type;
//		this.info = info;
//		this.register = register;
//		this.meetingRoom = meetingRoom;
//	}


	public Reservation() {
		super();
	}
	
	
	
	
	
	
	
}
