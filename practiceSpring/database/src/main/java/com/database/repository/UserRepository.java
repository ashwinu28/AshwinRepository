package com.database.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.database.entity.Student;
import com.database.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Query(value = "select * from user where user.name = ?1", nativeQuery = true)
	public List<User> findByXYZ(String name);

	@Query(value = "select * from user where user.id = ?1", nativeQuery = true)
	public Optional<User> findById(Integer id);

	@Query(value = "select * from user where user.email = ?1", nativeQuery = true)
	public Optional<User> findByEmail(String email);

//	@Query("SELECT new com.jeejava.dto.StudentDto(s.name,s.address,e.Tname,e.moduleName)"
//			+ "FROM Teacher t left JOIN d.Student e")
//	List<Student> fetchStudentDataLeftJoin();
//	
//	@Query("SELECT new com.jeejava.dto.StudentDto(s.name,s.address,e.Tname,e.moduleName)"
//			+ "FROM Teacher t left JOIN d.Student e")
//	List<Student> fetchStudentDataRightJoin();
}
