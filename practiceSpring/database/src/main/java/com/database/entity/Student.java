package com.database.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "Student")
public class Student implements Serializable {

	/**
	 * Serial Version ID.
	 */
	private static final long serialVersionUID = 1171357120813236163L;

	@Id
	@Column(name = "studID")
	private Long studID;

	@Column(name = "name")
	private String name;

	@Column(name = "grade")
	private String grade;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "teacher_id", referencedColumnName = "tID")
//	private Teacher teacher;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "moduleName", insertable = false, updatable = false)
	@Fetch(org.hibernate.annotations.FetchMode.JOIN)
	private Teacher teacher;

	/**
	 * @return the studID
	 */
	public long getStudID() {
		return studID;
	}

	/**
	 * @param studID the studID to set
	 */
	public void setStudID(long studID) {
		this.studID = studID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}


	/**
	 * @param studID
	 * @param name
	 * @param grade
	 * @param teacher
	 */
	public Student(Long studID, String name, String grade, Teacher teacher) {
		super();
		this.studID = studID;
		this.name = name;
		this.grade = grade;
		this.teacher = teacher;
	}

	public Student() {
		super();
	}



	/**
	 * @return the teacher
	 */
	public Teacher getTeacher() {

		return teacher;
	}

	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
