package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.entity.Building;

public interface  BuildingRepository extends JpaRepository<Building, String> {

}
