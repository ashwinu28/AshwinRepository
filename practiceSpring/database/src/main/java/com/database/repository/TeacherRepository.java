package com.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.database.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
//	@Query("SELECT new com.jeejava.dto.TeacherDto(s.name,s.address,e.Tname,e.moduleName)"
//			+ "FROM Student s INNER JOIN s.Teacher t")
//	List<StudentTeacherDto> fetchStudentTeacherDataInnerJoin();
//	
//	@Query("SELECT new com.jeejava.dto.StudentDto(s.name,s.address,e.Tname,e.moduleName)"
//			+ "FROM Teacher t, Student s")
//	List<StudentTeacherDto> fetchStudentTeacherDataCrossJoin();
}

