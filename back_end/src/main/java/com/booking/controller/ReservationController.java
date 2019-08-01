package com.booking.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dto.ReservationDto;
import com.booking.dto.registerDto;
import com.booking.entity.MeetingRoom;
import com.booking.entity.Register;
import com.booking.entity.Reservation;
import com.booking.exception.DatabaseException;
import com.booking.service.ReservationService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/reserve")
public class ReservationController {

	
private final ReservationService reserveService;
	
	public ReservationController(ReservationService reserveService) {
		this.reserveService=reserveService;
	}
	
	
	
	@GetMapping("/search")
	public List<Reservation> getAllReservation() throws DatabaseException{
		return reserveService.getAllReservationByEmail();
		
	}
	

	
	
	
@GetMapping("/search/{date}")
public Reservation getDate(@PathVariable(value="date") Date date) throws DatabaseException{
		 try {
			 
			return reserveService.getDate(date);
		} catch (DatabaseException e) {
		return null;
		}
}
	

@GetMapping("/meeting/{meetingRoom}")
public List<Reservation> getRoom(@PathVariable("meetingRoom") String meetingRoom) throws DatabaseException{
		
		return reserveService.getRoom(meetingRoom);
		}

@GetMapping("/reservation/{name}/{date}")
public List<Reservation> getReservationByBuildingAndDate(@PathVariable("name")String buildingName, @PathVariable("date")String date){
	return reserveService.getReservedMeetingRomms(buildingName, date);
}


@GetMapping("/select/{building}/{start}/{end}/{date}")
public List<Reservation> getUnAvailableRoom(@PathVariable("building")String buildingName,@PathVariable("start") Integer startTime,@PathVariable("end") Integer endTime,@PathVariable("date") String date){
	return reserveService.getUnAvailableRooms(buildingName,startTime,endTime,date);
}

	


@PostMapping("/add")
public ResponseEntity<Reservation> newBooking(@RequestBody ReservationDto reserveDto){
	
	try {
		reserveService.newBooking(reserveDto);
		return new ResponseEntity<Reservation>(HttpStatus.CREATED);
		
	}catch (DatabaseException e) {
		return new ResponseEntity<Reservation>(HttpStatus.BAD_REQUEST);
	}
	
	
}

}



	
	


	
	
	

