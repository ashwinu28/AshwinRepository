package com.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.booking.entity.Building;
import com.booking.entity.MeetingRoom;
import com.booking.repository.BuildingRepository;

@Service
public class buildingService {

	private final BuildingRepository bRepository;
	private final String MESSAGE_NOT_EXIST = "user already exists;";
	
	public buildingService(BuildingRepository bRepository) {
		super();
		this.bRepository=bRepository;
	}


	public List<Building> getAllBuilding(){
		return bRepository.findAll();
	}



	public Building findBuilding(String name) {
		Optional<Building> buildingOptional = bRepository.findById(name);
		
		if(buildingOptional.isPresent()) {
			return buildingOptional.get();
		}else {
			return null;
					
		}


	}








}
