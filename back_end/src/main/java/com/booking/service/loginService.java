package com.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.booking.config.BookingSession;
import com.booking.dto.loginDto;
import com.booking.entity.Login;
import com.booking.exception.DatabaseException;
import com.booking.repository.LoginRepository;

@Service
public class loginService {

	private final LoginRepository lRepository;
	private final BookingSession bookingSession;
	private final String MESSAGE_NOT_EXIST = "User does not exist";
	private final String PASSWORD_ERROR = "invalid password";

	public loginService(LoginRepository lRepository,BookingSession bookingSession) {
		super();
		this.lRepository = lRepository;
		this.bookingSession=bookingSession;
	}

	
	

	public Login adduser(loginDto loginDto) throws DatabaseException {

		Optional<Login> login = lRepository.findById(loginDto.getEmail() );
		if (!login.isPresent()) {
			throw new DatabaseException(MESSAGE_NOT_EXIST);

		} else {
			Login user = login.get();
			
			
			if(!loginDto.getPassword().equals(user.getPassword())) {
				throw new DatabaseException(PASSWORD_ERROR);
			}
			
			

			
		}
		return login.get();
	}

	public List<Login> getAllLogin() {
		return lRepository.findAll();
	}

	
	
	
}
