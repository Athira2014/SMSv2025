package com.athira.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name= "enrollments")
public class Enrollment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EnrollId", nullable = false)
	private Integer enrollId;
	
	@OneToOne
    @JoinColumn(name = "StudentId", insertable = false, updatable = false)
    private Student student;
	
	@Column(name = "StudentId", nullable = false)
	private Integer studentId;
	
	@ManyToOne
    @JoinColumn(name = "classId", insertable = false, updatable = false)
    private Classes classes;
	
	@Column(name = "ClassId", nullable = false)
	private Integer classId;
	
	@Column(name = "EnrollDate")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime enrollDate;

	public Enrollment(Integer enrollId, Student student, Integer studentId, Classes classes, Integer classId, DateTime enrollDate) {
		super();
		this.enrollId = enrollId;
		this.student = student;
		this.studentId = studentId;
		this.classes = classes;
		this.classId = classId;
		this.enrollDate = enrollDate;
	}

	public Enrollment() {
	}

	public Integer getEnrollId() {
		return enrollId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public DateTime getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(DateTime enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public void setEnrollId(Integer enrollId) {
		this.enrollId = enrollId;
	}
    
 }
