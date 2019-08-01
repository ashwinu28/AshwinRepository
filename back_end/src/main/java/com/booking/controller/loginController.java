package com.booking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dto.loginDto;
import com.booking.entity.Login;
import com.booking.exception.DatabaseException;
import com.booking.service.loginService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/login")
public class loginController {

	private final loginService lService;

	public loginController(loginService lService) {
		this.lService = lService;
	}
	
	

	@PostMapping("/login")
	public ResponseEntity<?> LoginUser(@RequestBody loginDto loginDto) {

		try {
			Login login = lService.adduser(loginDto);
			return new ResponseEntity(HttpStatus.OK).ok(login);
		} catch (DatabaseException e) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
 		

	}

	@GetMapping("/get")
	public List<Login> getAllLogin() {
		return lService.getAllLogin();
	}




}
