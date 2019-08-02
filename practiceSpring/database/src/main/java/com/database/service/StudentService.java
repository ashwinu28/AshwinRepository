package com.database.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.database.dto.studentDto;
import com.database.entity.Student;
import com.database.entity.Teacher;
import com.database.exception.DatabaseException;
import com.database.repository.StudentRepository;
import com.database.repository.TeacherRepository;

@Service
public class StudentService {

	private final StudentRepository sRepository;
	private final TeacherRepository tRepository;
	private final String MESSAGE_NOT_EXIST = "User does not exist";

	
	
//	@PostConstruct
//	public void createStudentInDatabase() {
//		List<Student>students = sRepository.findAll();
//		Teacher t = new Teacher(17154, "arjoon", "french");
//		if(students.isEmpty()) {
//		Student s = new Student();
//		s.setStudID(1l);
//		s.setName("testStudent");
//		s.setGrade("A");
//		s.setTeacher(t);
//		sRepository.save(s);
//		}
//	}

	/**
	 * @param sRepository
	 * @param tRepository
	 */
	public StudentService(StudentRepository sRepository, TeacherRepository tRepository) {
		super();
		this.sRepository = sRepository;
		this.tRepository = tRepository;
	}

	public Student addstudent(studentDto studentDto) throws DatabaseException {

		Optional<Teacher> teacher = tRepository.findById(studentDto.getTeacherID());
		if(teacher.isPresent()) {
			Student student = new Student();
			student.setStudID(studentDto.getStudID());
			student.setName(studentDto.getName());
			student.setGrade(studentDto.getGrade());
			student.setTeacher(teacher.get());
			return sRepository.save(student);
		
		}else {
			throw new DatabaseException(MESSAGE_NOT_EXIST);
		}
	}

	public Student AddStudent(Student studentDetails) throws DatabaseException {
		return sRepository.save(studentDetails);
	}

	public List<Student> getAllStudent() {
		return sRepository.findAll();
	}
	
	public ResponseEntity<Student> UpdateStudent(Student studentDetails) {
		
		Optional<Student> studentOptional = sRepository.findById(studentDetails.getStudID());
		
		
		if(studentOptional.isPresent()) {
			
			Student Studentexisting = studentOptional.get();
//			Studentexisting.setStudID(studentDetails.getStudID());
			Studentexisting.setName(studentDetails.getName());
			Studentexisting.setGrade(studentDetails.getGrade());
			Studentexisting.setTeacher(studentDetails.getTeacher());
			
			sRepository.save(Studentexisting);
		}
		return new ResponseEntity<Student>(HttpStatus.OK); 
	}

	public void deleteStudent(Long id) throws DatabaseException {
		Optional<Student> deleteStudent = sRepository.findById(id);
		if (deleteStudent.isPresent()) {

			sRepository.deleteById(id);

		}else {
			throw new DatabaseException("student not present in database");
		}
	}
	
	
	public Student getStudentId(Long studId) throws DatabaseException {
		Optional<Student> student = sRepository.findById(studId);
		if (student.isPresent()) {

			return student.get();

		}else {
			throw new DatabaseException("student not present in database");
		}
	}
	

	
	
	
	
	
}
