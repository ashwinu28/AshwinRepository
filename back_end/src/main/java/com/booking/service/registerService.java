package com.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.booking.config.BookingSession;
import com.booking.dto.registerDto;
import com.booking.entity.MeetingRoom;
import com.booking.entity.Register;
import com.booking.exception.DatabaseException;
import com.booking.repository.RegisterRepository;


@Service
public class registerService {
	
	private final RegisterRepository rRepository;
	private final BookingSession bookingSession;
	
	private final String MESSAGE_NOT_EXIST = "user already exists;";
	
	
	public registerService(RegisterRepository rRepository,BookingSession bookingSession) {
		super();
		this.rRepository=rRepository;
		this.bookingSession=bookingSession;
		
	}
	

	public Register newuser(registerDto registerDto) throws DatabaseException{
		
		Optional<Register> register = rRepository.findById(registerDto.getEmail());
		if(register.isPresent()) {
			throw new DatabaseException(MESSAGE_NOT_EXIST);
		}
	
		else {
			Register user = new Register();
			user.setEmail(registerDto.getEmail());
			user.setName(registerDto.getName());
			user.setPhoneNo(registerDto.getPhoneNo());
			user.setPassword(registerDto.getPassword());
		
			
			
			return rRepository.save(user);
		}
	
	}
	
	
	
public List<Register> getAllRegister(){
	return rRepository.findAll();
}


public Boolean getEmail(String email) throws DatabaseException {
	Optional<Register> register = rRepository.findById(email);
	return register.isPresent();
}



public Boolean getPassword(String password) throws DatabaseException{
		Optional<Register> register = rRepository.findByPassword(password);
		return register.isPresent();
	}

public Register findRegister(String email) {
	Optional<Register> registerOptional = rRepository.findById(email);
	
	if(registerOptional.isPresent()) {
		this.bookingSession.setEmail(email);
		return registerOptional.get();
	}else {
		return null;
				
	}
}

public void logout() {
	this.bookingSession.setEmail(null);
}


public Register findEmail(String email) {
	Optional<Register> registeroptional = rRepository.findById(email);
	
	if(registeroptional.isPresent()) {
		return registeroptional.get();
	}else {
		return null;
				
	}
}





}
