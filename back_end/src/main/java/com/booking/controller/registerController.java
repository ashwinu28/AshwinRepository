package com.booking.controller;

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

import com.booking.dto.registerDto;
import com.booking.entity.MeetingRoom;
import com.booking.entity.Register;
import com.booking.exception.DatabaseException;
import com.booking.service.registerService;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/register")
public class registerController {

	private final registerService rService;
	
	public registerController(registerService rService) {
		this.rService=rService;
	}
	
	
@PostMapping("/add")
public ResponseEntity<Register> NewUser(@RequestBody registerDto registerDto){
	
	try {
		rService.newuser(registerDto);
		return new ResponseEntity<Register>(HttpStatus.CREATED);
		
	}catch (DatabaseException e) {
		return new ResponseEntity<Register>(HttpStatus.BAD_REQUEST);
	}
	
}
@GetMapping("/search/{email}")
public Register findEmail(@PathVariable("email") String email)throws DatabaseException {
	return rService.findEmail(email);
	}
	


	
@GetMapping("/get")
public List<Register> getAllRegister(){
	return rService.getAllRegister();
	
}
	
	
	
@GetMapping("/return/{email}")
public Boolean getEmail(@PathVariable(value="email") String email) throws DatabaseException{
	 try {
		 
		return rService.getEmail(email);
	} catch (DatabaseException e) {
		return null;
	}
}
	
@GetMapping("/return/{password}")
public Boolean getPassword(@PathVariable(value="password") String password) throws DatabaseException{
	 try {
		 
		return rService.getPassword(password);
	} catch (DatabaseException e) {
		return null;
	}
}

@GetMapping("/register/{email}")
public Register findRegister(@PathVariable String email) {
	return rService.findRegister(email);
}

@GetMapping("/logout")
	public void logout(){
		rService.logout();
	}
}


