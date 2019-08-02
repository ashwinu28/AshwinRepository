 package com.database.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.entity.User;
import com.database.exception.DatabaseException;
import com.database.service.UserService;

@RestController
@RequestMapping(path = "/person")
public class MainController {

	private final UserService userService;

	public MainController(UserService userService) {
		this.userService = userService;
	}

//@PostMapping(path = "/add")
//	public ResponseEntity<User> AddUser(@RequestBody User user) {
//
//		try {
//			userService.AddUser(user);
//			return new ResponseEntity<User>(HttpStatus.CREATED);
//		}
//		catch (DatabaseException e) {
//			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
//			}
//		}

//	@PutMapping("/")
//	public ResponseEntity<User> updateUser(@RequestBody User user) {
//		try {
//			userService.updateUser(user);
//			return new ResponseEntity<User>(HttpStatus.ACCEPTED);
//		} catch (DatabaseException e) {
//			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
//		}
//	}

@DeleteMapping(path="/delete/{email}")
public ResponseEntity<User> deleteUser(@PathVariable("email")String email){
	try {
		userService.deleteUser (email);
		return new ResponseEntity<User>(HttpStatus.GONE);
	}
	catch(DatabaseException e) {
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}


}
	
//	@DeleteMapping("/delete/{id}")
//	public void deleteUser(@PathVariable int id) {
//		User user = userRepository.deleteById(id);
//		
//		if(user==null)
//			throw new UserNotFoundException("id-"+ id);		
//	}
}
