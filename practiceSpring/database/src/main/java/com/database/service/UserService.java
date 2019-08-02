package com.database.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.entity.User;
import com.database.exception.DatabaseException;
import com.database.repository.UserRepository;

@Service
public class UserService {
	
	private final String MESSAGE_NOT_EXIST = "User does not exist";

	@Autowired
	private UserRepository userRepository;

//	public User updateUser( User userDetails) throws DatabaseException {
//
//		Optional<User> optionalUser = userRepository.findById(userDetails.getId());
//		if (optionalUser.isPresent()) {
//			User user = optionalUser.get();
//			user.setName(userDetails.getName());
//			 return userRepository.save(user);
//
//		} else {
//			throw new DatabaseException(MESSAGE_NOT_EXIST);
//			
//		}
//
//	}

//	public User AddUser(User userDetails) throws DatabaseException {
//		return userRepository.save(userDetails);
//		
//	}

	public void deleteUser(String email) throws DatabaseException{
		Optional<User> emailUser = userRepository.findByEmail(email);
		if (emailUser.isPresent()) {
			

		userRepository.delete(emailUser.get());
		
		
	}
		
	 else {
		throw new DatabaseException(MESSAGE_NOT_EXIST);
		
	 }
	}


//	public void deleteUser(User userDetails) throws DatabaseException {
//	return userRepository.deleteAll(userDetails);
//
//
//	}














}
