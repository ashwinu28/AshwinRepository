package com.booking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.booking.entity.Register;


public interface RegisterRepository extends JpaRepository<Register, String> {

	@Query(value = "SELECT * FROM REGISTER WHERE PASSWORD = ?1", nativeQuery = true)
	  public Optional<Register> findByPassword(String password);

	public Optional<Register> findByEmail(String email);
	
	
}
