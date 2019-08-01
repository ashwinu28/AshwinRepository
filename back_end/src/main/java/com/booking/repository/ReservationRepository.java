package com.booking.repository;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.booking.entity.MeetingRoom;
import com.booking.entity.Register;
import com.booking.entity.Reservation;
import com.booking.entity.ReservationId;

public interface  ReservationRepository extends JpaRepository<Reservation, ReservationId> {

	@Query(value = "SELECT * FROM REGISTER WHERE DATE = ?1", nativeQuery = true)
	  public Optional<Reservation> findByDate(Date date);


	  public List<Reservation> findByMeetingRoom(MeetingRoom meetingRoom);

	  public List<Reservation>findByRegister(Register register);
	  
	 
}
