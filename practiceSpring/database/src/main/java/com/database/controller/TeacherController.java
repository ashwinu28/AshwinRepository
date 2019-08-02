package com.database.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.entity.Student;
import com.database.entity.Teacher;
import com.database.exception.DatabaseException;
import com.database.service.TeacherService;

@CrossOrigin
@RestController
@RequestMapping(path="/teacher")
public class TeacherController {

	private final TeacherService teacherService;
	
	public TeacherController(TeacherService teacherService) {
		this.teacherService=teacherService;
	}

@DeleteMapping("/delete/{tid}")
	public ResponseEntity<Teacher> deleteTeacher(@PathVariable(value="tid") Long tid)  {
	 try {
		teacherService.deleteTeacher(tid);
		return new ResponseEntity<Teacher>(HttpStatus.ACCEPTED);
	} catch (DatabaseException e) {
		return new ResponseEntity<Teacher>(HttpStatus.BAD_REQUEST);
	}
	 
}
	 
	 
	 @GetMapping("/{teacherId}")
	 public Teacher getTeacherByid(@PathVariable(value="teacherId") Long teacherId) {
		 try {
			return teacherService.getTeacherById(teacherId);
		} catch (DatabaseException e) {
			return null;
		}
	 }


//	 @GetMapping("/get")
//	 public List<Teacher> getAllTeacher() {
//	 	return teacherService.getAllTeacher();
//	 }




}
	
	
	
	
	
	
	
	
	
	
	
	
	

