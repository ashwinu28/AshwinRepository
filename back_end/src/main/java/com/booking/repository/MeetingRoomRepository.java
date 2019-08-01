package com.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.entity.Building;
import com.booking.entity.MeetingRoom;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, String>{

	public List<MeetingRoom> findByBuilding(Building building);

}
