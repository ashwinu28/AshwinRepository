package com.database.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.entity.Student;
import com.database.entity.Teacher;
import com.database.exception.DatabaseException;
import com.database.repository.TeacherRepository;

@Service
public class TeacherService {

	private final TeacherRepository tRepository;

	public TeacherService(TeacherRepository tRepository) {
		this.tRepository = tRepository;
	}
	
	@PostConstruct
	public void createStudentInDatabase() {
		List<Teacher> teachers = tRepository.findAll();
		if(teachers.isEmpty()) {
		Teacher t = new Teacher();
		t.setModuleName("English");
		t.settID(1l);
		t.settName("testTeacher");
		
		tRepository.save(t);
		}
	}

	public void deleteTeacher(long tid) throws DatabaseException {
		Optional<Teacher> deleteTeacher = tRepository.findById(tid);
		if (deleteTeacher.isPresent()) {

			tRepository.deleteById(tid);

		}else {
			throw new DatabaseException("Teacher not present in database");
		}
	}
	
	public Teacher getTeacherById(Long id) throws DatabaseException {
		Optional<Teacher> teacher = tRepository.findById(id);
		if (teacher.isPresent()) {

			return teacher.get();

		}else {
			throw new DatabaseException("Teacher not present in database");
		}
	}
	
	
	public List<Teacher> getAllTeacher() {
		return tRepository.findAll();
	}

	
	
	
	
	
	
	

}
