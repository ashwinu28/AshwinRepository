package com.booking.config;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.booking.entity.Building;
import com.booking.entity.MeetingRoom;
import com.booking.entity.Register;
import com.booking.entity.Reservation;
import com.booking.repository.BuildingRepository;
import com.booking.repository.MeetingRoomRepository;
import com.booking.repository.RegisterRepository;
import com.booking.repository.ReservationRepository;

@Component
public class DatabaseInitialiser implements CommandLineRunner {
	
	
	 

		@Autowired
		private BuildingRepository buildingRepository;
		@Autowired
		private MeetingRoomRepository meetingRepository;
		@Autowired
		private ReservationRepository reserveRepository;
		
		@Autowired
		private RegisterRepository rRepository;

		@Override
		public void run(String... args) throws Exception {

			
			
			Building nex = new Building();
			nex.setName("Nex");
			
			Building atal = new Building();
			atal.setName("Atal Bihari vajpayee Tower");
			
			Building nexteracom1 = new Building();
			nexteracom1.setName("Nexteracom1");
			
			Building nexteracom2 = new Building();
			nexteracom2.setName("Nexteracom2");
			
			if(buildingRepository.findAll().isEmpty()) {
				buildingRepository.save(nex);
				buildingRepository.save(atal);
				buildingRepository.save(nexteracom1);
				buildingRepository.save(nexteracom2);
			}
			
			
			MeetingRoom meetingRoom1A = new MeetingRoom();
			meetingRoom1A.setBuilding(nex);;
			meetingRoom1A.setRoomNo("1A");
			meetingRoom1A.setPersons(5);
			meetingRoom1A.setWIFI(true);
			
			
			MeetingRoom meetingRoom1B = new MeetingRoom();
			meetingRoom1B.setBuilding(nex);;
			meetingRoom1B.setRoomNo("1B");
			meetingRoom1B.setPersons(5);
			meetingRoom1B.setWIFI(true);
			
			
			MeetingRoom meetingRoom1C = new MeetingRoom();
			meetingRoom1C.setBuilding(nex);;
			meetingRoom1C.setRoomNo("1C");
			meetingRoom1C.setPersons(8);
			meetingRoom1C.setWIFI(true);
			
			MeetingRoom meetingRoom2A = new MeetingRoom();
			meetingRoom2A.setBuilding(nex);;
			meetingRoom2A.setRoomNo("2A");
			meetingRoom2A.setPersons(8);
			meetingRoom2A.setWIFI(true);
			
			MeetingRoom meetingRoom2B = new MeetingRoom();
			meetingRoom2B.setBuilding(nex);;
			meetingRoom2B.setRoomNo("2B");
			meetingRoom2B.setPersons(8);
			meetingRoom2B.setWIFI(true);
			
			MeetingRoom meetingRoom2C = new MeetingRoom();
			meetingRoom2C.setBuilding(nex);;
			meetingRoom2C.setRoomNo("2C");
			meetingRoom2C.setPersons(8);
			meetingRoom2C.setWIFI(true);
			
			MeetingRoom meetingRoom6A = new MeetingRoom();
			meetingRoom6A.setBuilding(nex);;
			meetingRoom6A.setRoomNo("6A");
			meetingRoom6A.setPersons(8);
			meetingRoom6A.setWIFI(true);
			
			MeetingRoom meetingRoom6B = new MeetingRoom();
			meetingRoom6B.setBuilding(nex);;
			meetingRoom6B.setRoomNo("6B");
			meetingRoom6B.setPersons(8);
			meetingRoom6B.setWIFI(true);
			
			MeetingRoom meetingRoom6C = new MeetingRoom();
			meetingRoom6C.setBuilding(nex);;
			meetingRoom6C.setRoomNo("6B");
			meetingRoom6C.setPersons(8);
			meetingRoom6C.setWIFI(true);
			
			
			
			MeetingRoom nexteracom2A = new MeetingRoom();
			nexteracom2A.setBuilding(nexteracom1);;
			nexteracom2A.setRoomNo("2A");
			nexteracom2A.setPersons(8);
			nexteracom2A.setWIFI(true);
			
			MeetingRoom nexteracom2B = new MeetingRoom();
			nexteracom2B.setBuilding(nexteracom1);;
			nexteracom2B.setRoomNo("2B");
			nexteracom2B.setPersons(8);
			nexteracom2B.setWIFI(true);
			
			MeetingRoom nexteracom6A = new MeetingRoom();
			nexteracom6A.setBuilding(nexteracom1);;
			nexteracom6A.setRoomNo("6A");
			nexteracom6A.setPersons(8);
			nexteracom6A.setWIFI(true);
			
			MeetingRoom nexteracom6B = new MeetingRoom();
			nexteracom6B.setBuilding(nexteracom1);;
			nexteracom6B.setRoomNo("6B");
			nexteracom6B.setPersons(8);
			nexteracom6B.setWIFI(true);
			
			MeetingRoom nexteracom7A = new MeetingRoom();
			nexteracom7A.setBuilding(nexteracom1);;
			nexteracom7A.setRoomNo("7A");
			nexteracom7A.setPersons(8);
			nexteracom7A.setWIFI(true);
			
			MeetingRoom nexteracom7B = new MeetingRoom();
			nexteracom7B.setBuilding(nexteracom1);;
			nexteracom7B.setRoomNo("7B");
			nexteracom7B.setPersons(8);
			nexteracom7B.setWIFI(true);
			
			MeetingRoom nexteracom8A = new MeetingRoom();
			nexteracom8A.setBuilding(nexteracom1);;
			nexteracom8A.setRoomNo("8A");
			nexteracom8A.setPersons(7);
			nexteracom8A.setWIFI(true);
			
			
			MeetingRoom nexteracom8B = new MeetingRoom();
			nexteracom8B.setBuilding(nexteracom1);;
			nexteracom8B.setRoomNo("8B");
			nexteracom8B.setPersons(7);
			nexteracom8B.setWIFI(true);
			
			MeetingRoom nexteracom9A = new MeetingRoom();
			nexteracom9A.setBuilding(nexteracom1);;
			nexteracom9A.setRoomNo("9A");
			nexteracom9A.setPersons(10);
			nexteracom9A.setWIFI(true);
			
			
			MeetingRoom atalTower = new MeetingRoom();
			atalTower.setBuilding(atal);;
			atalTower.setRoomNo("6A");
			atalTower.setPersons(10);
			atalTower.setWIFI(true);
			
			if(meetingRepository.findAll().isEmpty()) {
				meetingRepository.save(meetingRoom1A);
				meetingRepository.save(meetingRoom1B);
				meetingRepository.save(meetingRoom1C);
				meetingRepository.save(meetingRoom2A);
				meetingRepository.save(meetingRoom2B);
				meetingRepository.save(meetingRoom2C);
				meetingRepository.save(meetingRoom6A);
				meetingRepository.save(meetingRoom6B);
				meetingRepository.save(meetingRoom6C);
				meetingRepository.save(nexteracom2A);
				meetingRepository.save(nexteracom2B);
				meetingRepository.save(nexteracom6A);
				meetingRepository.save(nexteracom6B);
				meetingRepository.save(nexteracom7A);
				meetingRepository.save(nexteracom7B);
				meetingRepository.save(nexteracom8A);
				meetingRepository.save(nexteracom8B);
				meetingRepository.save(nexteracom9A);
				meetingRepository.save(atalTower);
			}
			
			MeetingRoom meeting3 = new MeetingRoom();
			
			MeetingRoom meeting4 = new MeetingRoom();
			
			MeetingRoom meeting5 = new MeetingRoom();
			
			
			Register user = rRepository.findById("ashwin@hotmail.com").get();
			
			
			Date today = new Date(2019-1900, 07, 19);
			Date startTime = new Date(2019-1900, 07, 19, 8, 0);
			Date endTime = new Date(2019-1900, 07, 19, 9, 0);
			Reservation reserve = new Reservation();
			reserve.setEvent_name("Mentor Meeting");
			reserve.setEvent_type("training");
			reserve.setDate(today);
			reserve.setStartTime(startTime);
			reserve.setEndTime(endTime);
		
			reserve.setMeetingRoom(meetingRoom1A);
			reserve.setRegister(user);
		
//			Date today1 = new Date(2019-1900, 07, 19);
//			Date startTime1 = new Date(2019-1900, 07, 19, 13, 0);
//			Date endTime1 = new Date(2019-1900, 07, 19, 14, 0);
//			Reservation reserve1 = new Reservation();
//			reserve1.setEvent_name("Jeudi Du partage");
//			reserve1.setEvent_type("Accenture Business");
//			reserve1.setDate(today1);
//			reserve1.setStartTime(startTime1);
//			reserve1.setEndTime(endTime1);
//			reserve1.setMeetingRoom(meetingRoom1B);
//		
//			
//			reserve1.setRegister(user);
//			
//			
//			Date today2 = new Date(2019-1900, 07, 19);
//			Date startTime2 = new Date(2019-1900, 07, 19, 11, 0);
//			Date endTime2 = new Date(2019-1900, 07, 19, 12, 0);
//			Reservation reserve2 = new Reservation();
//			reserve2.setEvent_name("Mentor Meeting");
//			reserve2.setEvent_type("training");
//			reserve2.setDate(today2);
//			reserve2.setStartTime(startTime2);
//			reserve2.setEndTime(endTime2);
//		
//			reserve2.setMeetingRoom(meetingRoom1A);
//			reserve2.setRegister(user);
//			
//			Date today3 = new Date(2019-1900, 07, 19);
//			Date startTime3 = new Date(2019-1900, 07, 19, 15, 0);
//			Date endTime3  = new Date(2019-1900, 07, 19, 16, 0);
//			Reservation reserve3 = new Reservation();
//			reserve3.setEvent_name("Mentor Meeting");
//			reserve3.setEvent_type("training");
//			reserve3.setDate(today3);
//			reserve3.setStartTime(startTime3);
//			reserve3.setEndTime(endTime3);
//		
//			reserve3.setMeetingRoom(meetingRoom1A);
//			reserve3.setRegister(user);
			
			Date today4 = new Date(2019-1900, 07, 19);
			Date startTime4 = new Date(2019-1900, 07, 19, 8, 0);
			Date endTime4 = new Date(2019-1900, 07, 19, 9, 0);
			Reservation reserve4 = new Reservation();
			reserve4.setEvent_name("project presentation");
			reserve4.setEvent_type("internship");
			reserve4.setDate(today4);
			reserve4.setStartTime(startTime4);
			reserve4.setEndTime(endTime4);
		
			reserve4.setMeetingRoom(meetingRoom1B);
			reserve4.setRegister(user);
		
			
		

			if(reserveRepository.findAll().isEmpty()) {
				
				reserveRepository.saveAndFlush(reserve);
//				reserveRepository.saveAndFlush(reserve1);
//				reserveRepository.saveAndFlush(reserve2);
//				reserveRepository.saveAndFlush(reserve3);
				reserveRepository.saveAndFlush(reserve4);
				
			}
			
		}
		


		
		
		


}
	



