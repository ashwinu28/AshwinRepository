package com.database.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.dto.studentDto;
import com.database.entity.Student;
import com.database.entity.Teacher;
import com.database.exception.DatabaseException;
import com.database.repository.StudentRepository;
import com.database.service.StudentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/student")
public class StudentController {

	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService=studentService;
	}

@PostMapping("/add")
public ResponseEntity<Student> AddStudent(@RequestBody studentDto studentDto){
	
	System.out.print(studentDto.getStudID());
	try {
		studentService.addstudent(studentDto);
		return new ResponseEntity<Student>(HttpStatus.CREATED);
	}
	catch(DatabaseException e) {
		return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
	}

}



@GetMapping("/get")
public List<Student> getAllStudent() {
	return studentService.getAllStudent();
}



@PutMapping("/update")
public ResponseEntity<Student> updateStudent(@RequestBody Student studentDetails){
	return studentService.UpdateStudent(studentDetails);
	

}

@DeleteMapping("/delete/{id}")
public ResponseEntity<Student> deleteStudent(@PathVariable(value="id") Long id)  {
 try {
	studentService.deleteStudent(id);
	
	return new ResponseEntity<Student>(HttpStatus.ACCEPTED);
} 
 catch (DatabaseException e) {
	
	 return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
 		}
 }



@GetMapping("/search/{studId}")
public Student getStudentId(@PathVariable(value="studId") Long studId21){
	 try {
		return studentService.getStudentId(studId21);
	} catch (DatabaseException e) {
		return null;
	}
}



//@SuppressWarnings("unchecked")
//@GetMapping("/search/{name}")
//public List<Student> getStudentName(@PathVariable(value="name") String name) {
//	return (List<Student>) studentService.getStudentName(name);
}

