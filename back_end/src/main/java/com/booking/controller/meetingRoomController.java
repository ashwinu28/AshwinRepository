package com.booking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.entity.MeetingRoom;
import com.booking.entity.Register;
import com.booking.exception.DatabaseException;
import com.booking.service.buildingService;
import com.booking.service.meetingRoomService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/meeting")
public class meetingRoomController{

private final meetingRoomService mService;


	
	public meetingRoomController(meetingRoomService mService) {
		this.mService=mService;
	}
	
	@GetMapping("/get")
	public List<MeetingRoom> getAllRooms(){
		return mService.getAllRooms();
		
	}
	

	

	@GetMapping("/search/{roomNo}")
	public MeetingRoom findRoomNo(@PathVariable("meeting") String roomNo)throws DatabaseException {
		return mService.findRoomNo(roomNo);
	}
	
	@GetMapping("/find/{building}")
	public List<MeetingRoom> findBuilding(@PathVariable("building") String name) throws DatabaseException {
		return mService.findBuilding(name);
	}
	
	
	@GetMapping("/search/{meeting}")
	public MeetingRoom getRoom(@PathVariable(value="roomNo") String roomNo) throws DatabaseException{
		 try {
			 
			return mService.getRoom(roomNo);
		} catch (DatabaseException e) {
			return null;
		}
	}

	
	

	
	
	
}
