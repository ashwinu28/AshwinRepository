package com.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.database.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
//	@Query("SELECT new com.jeejava.dto.StudenTeachertDto(s.name,s.address,e.Tname,e.moduleName)"
//			+ "FROM Teacher t left JOIN t.Student e")
//	List<StudentTeacherDto> fetchStudentTeachertDataLeftJoin();
//	
//	@Query("SELECT new com.jeejava.dto.StudentTeacherDto(s.name,s.address,e.Tname,e.moduleName)"
//			+ "FROM Teacher t left JOIN d.Student e")
//	List<StudentTeacherDto> fetchStudentTeacherDataRightJoin();
}
