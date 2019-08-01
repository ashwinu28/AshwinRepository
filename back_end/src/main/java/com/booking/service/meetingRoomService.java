package com.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.booking.entity.Building;
import com.booking.entity.MeetingRoom;
import com.booking.entity.Register;
import com.booking.entity.Reservation;
import com.booking.exception.DatabaseException;
import com.booking.repository.MeetingRoomRepository;

@Service
public class meetingRoomService {
	private final MeetingRoomRepository mRepository;
	private final buildingService bservice;
	
	public meetingRoomService(MeetingRoomRepository mRepository,buildingService bservice) {
		super();
		this.mRepository=mRepository;
		this.bservice=bservice;
	}
	
	public List<MeetingRoom> getAllRooms(){
		return mRepository.findAll();
	}

	public MeetingRoom findRoomNo(String roomNo) {
		Optional<MeetingRoom> roomOptional = mRepository.findById(roomNo);
		
		if(roomOptional.isPresent()) {
			return roomOptional.get();
		}else {
			return null;
					
		}
	}
	
	
	public  List<MeetingRoom> findBuilding(String name) throws DatabaseException {
		Building building = bservice.findBuilding(name);
		List<MeetingRoom> meeting = mRepository.findByBuilding(building);
		
		if(!meeting.isEmpty()) {
			return meeting;
		}else {
			return null;
					
		}
					
		}

		
	public MeetingRoom getRoom(String roomNo) throws DatabaseException {
		Optional<MeetingRoom> room = mRepository.findById(roomNo);
		return room.get();
	}				
	
	


	
	
}
	
	
	
	
	
	
	
	
	
	
	
	

