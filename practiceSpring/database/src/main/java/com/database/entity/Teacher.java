package com.database.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher")
public class Teacher implements Serializable {

	/**
	 * Serial Version ID.
	 */
	private static final long serialVersionUID = -7668987392340652674L;

	@Id
	@Column(name = "tID")
	private Long tID;

	@Column(name = "TName")
	private String tName;

	@Column(name = "moduleName")
	private String moduleName;
	
	@OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
	private Set<Student> student;

	/**
	 * @return the tID
	 */
	public Long gettID() {
		return tID;
	}

	/**
	 * @param tID the tID to set
	 */
	public void settID(Long tID) {
		this.tID = tID;
		
	}

	/**
	 * @return the tName
	 */
	public String gettName() {
		return tName;
	}

	/**
	 * @param tName the tName to set
	 */
	public void settName(String tName) {
		this.tName = tName;
	}

	

	/**
	 * @return the student
	 */
	public Set<Student> getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	/**
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * @param moduleName the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Teacher(long tID, String tName, String moduleName) {
		super();
		this.tID = tID;
		this.tName = tName;
		this.moduleName = moduleName;

	}

	public Teacher() {
		super();
	}

}
