package com.booking.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.booking.config.BookingSession;
import com.booking.dto.ReservationDto;
import com.booking.entity.MeetingRoom;
import com.booking.entity.Register;
import com.booking.entity.Reservation;
import com.booking.entity.ReservationId;
import com.booking.exception.DatabaseException;
import com.booking.repository.ReservationRepository;



@Service
public class ReservationService {

	
	private final ReservationRepository reserveRepository;
	private final BookingSession bookingSession;
	private final registerService rService;
	private final String MESSAGE_NOT_EXIST = "error placing booking;";
	private final meetingRoomService mservice;
	
	public ReservationService(ReservationRepository reserveRepository,meetingRoomService mservice, BookingSession bookingSession, registerService rService) {
		super();
		this.reserveRepository=reserveRepository;
		this.mservice=mservice;
		this.bookingSession = bookingSession;
		this.rService = rService;
	}
	
	
	
	public List<Reservation> getAllReservationByEmail(){
		String email = bookingSession.getEmail();
	
		//String email = "ashwin@hotmail.com";
		Register register = rService.findEmail(email);
		return reserveRepository.findByRegister(register);
	}
	
	
	public Reservation getDate(Date date) throws DatabaseException {
		Optional<Reservation> reservationOptional = reserveRepository.findByDate(date);
		
	
		if(reservationOptional.isPresent()) {
			return reservationOptional.get();
		}else {
			return null;
					
		}

	}
	
	
	public  List<Reservation> getRoom(String meetingRoom) throws DatabaseException {
		MeetingRoom room = mservice.findRoomNo(meetingRoom);
		List<Reservation> reservations = reserveRepository.findByMeetingRoom(room);
		
	
		if(!reservations.isEmpty()) {
			return reservations;
		}else {
			return null;
					
		}

	}
	
	
	public List<Reservation> getReservedMeetingRomms(String buildingName, String date) {
		Date parseDate = parseDate(date);
		List<Reservation> reservationsObtained = new ArrayList<>();
		List<MeetingRoom> meetingroooms;
		try {
			meetingroooms = mservice.findBuilding(buildingName);
		
		for (MeetingRoom meetingRoom : meetingroooms) {
			
			
				List<Reservation>reservations = getRoom(meetingRoom.getRoomNo());
				
				if(reservations != null) {
					for (Reservation reservation : reservations) {
						if(parseDate.equals(reservation.getDate())) {

							reservationsObtained.add(reservation);
						}
					}
				}

		}
		
		} catch (DatabaseException e) {
			System.out.println(e.getMessage());
		}
		
		return reservationsObtained;
	}
	
	
	private Date parseDate(String date) {
		Date date1=null;
		    try {
				date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			} catch (ParseException e) {
				System.err.println(e.getMessage());
			}  
		    
		    return date1;

	}
	
	
	
	public List<Reservation> getUnAvailableRooms(String buildingName, Integer start, Integer end,String date){
		Date startTime = parseTime(date,start);
		Date endTime = parseTime(date,end);
		List<Reservation> reservationsObtained = new ArrayList<>();
		List<MeetingRoom> meetingrooms;

		try {
			meetingrooms = mservice.findBuilding(buildingName);
		
		for (MeetingRoom meetingRoom : meetingrooms) {
			
			List<Reservation>reservations = getRoom(meetingRoom.getRoomNo());
		
			if(reservations != null) {
				
				for (Reservation reservation : reservations) {
					Date dateReservation = reservation.getDate();
					Date startTimeReservation = setTimeToDate(dateReservation,reservation.getStartTime().getHours());
					Date endTimeReservation = setTimeToDate(dateReservation,reservation.getEndTime().getHours());

					if((startTime.after(startTimeReservation) ||startTime.equals(startTimeReservation)) && (endTime.before(endTimeReservation) || endTime.equals(endTimeReservation))) {
						reservationsObtained.add(reservation);
					}

			}
			

			}
		}
		}catch (DatabaseException e) {
			System.out.println(e.getMessage());
		}
		
			return reservationsObtained;
}
	

	
	private Date parseTime(String date,Integer startTime) {
		Date start=null;
		    try {
		    	start = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		    	return setTimeToDate(start, startTime);
			} catch (ParseException e) {
				System.err.println(e.getMessage());
			}  
		    
		    return start;

	}
	

	
	private static Date setTimeToDate(Date date, int hour) {    
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        cal.set(Calendar.HOUR_OF_DAY, hour);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0);  
        return cal.getTime(); 
    }
	
	
	
	

	
public void newBooking(ReservationDto reserveDto) throws DatabaseException{
	
	
	MeetingRoom room = mservice.findRoomNo(reserveDto.getMeetingRoom());
	Register register = null;
	if(bookingSession.getEmail() != null) {
		register = this.rService.findRegister(bookingSession.getEmail());
	}

	
	if(room == null) {
		throw new DatabaseException("No such room exists");
	}
	
	
	
	
		ReservationId reservationId = new ReservationId();
		reservationId.setDate(reserveDto.getDate());
		reservationId.setStartTime(reserveDto.getStartTime());
		reservationId.setMeetingRoom(reserveDto.getMeetingRoom());
		
		
		Optional<Reservation> reserve = reserveRepository.findById(reservationId);
	if(reserve.isPresent()) {
			throw new DatabaseException(MESSAGE_NOT_EXIST);
		}
			else {
			Reservation user = new Reservation();
			user.setDate(reserveDto.getDate());
			user.setStartTime(reserveDto.getStartTime());
			user.setEndTime(reserveDto.getEndTime());
			user.setEvent_name(reserveDto.getEvent_name());
			user.setEvent_type(reserveDto.getEvent_type());
			user.setInfo(reserveDto.getInfo());
			user.setMeetingRoom(room);
			user.setRegister(register);
			
			if(register != null) {
				 reserveRepository.save(user);
			}
			
	}
	
	
	}




	
	
	
}
