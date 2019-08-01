package com.booking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.entity.Building;
import com.booking.entity.MeetingRoom;
import com.booking.service.buildingService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/building")
public class buildingController {

private final buildingService bService;
	
	public buildingController(buildingService bService) {
		this.bService=bService;
	}
	
	@GetMapping("/get")
	public List<Building> getAllBuilding(){
		return bService.getAllBuilding();
		
	}
	

	@GetMapping("/search/{building}")
	public Building findBuilding(@PathVariable String name) {
		return bService.findBuilding(name);
	}




}
