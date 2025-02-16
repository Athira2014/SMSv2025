package com.athira.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "StudentId", nullable = false)
	private Integer studentId;

	@Column(name = "SFirstName", nullable = false, length = 20)
	private String firstName;

	@Column(name = "SLastName", length = 20)
	private String lastName;

	@Column(name = "Address", nullable = false, length = 50)
	private String address;

	@Column(name = "DOB", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dob;

	@Column(name = "Phone", nullable = false, length = 10)
	private String phone;

	@Column(name = "IsActive")
	private Boolean isActive;

	@JsonIgnore
	@OneToMany(mappedBy = "student")
	private List<Grade> grades;

	// One-to-One relationship with Enrollment
	@JsonIgnore
	@OneToOne(mappedBy = "student")
	private Enrollment enrollment;

	public Student() {

	}

	public Student(Integer studentId, String firstName, String lastName, String address, DateTime dob, String phone,
			Boolean isActive) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.dob = dob;
		this.phone = phone;
		this.isActive = isActive;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.trim().isEmpty()) {
			throw new IllegalArgumentException("First name field must not be empty!");
		}
		if (firstName.length() > 20) {
			throw new IllegalArgumentException("First Name cannot exceed 20 characters.");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {

		if (lastName == null || lastName.trim().isEmpty()) {
			throw new IllegalArgumentException("Last name field must not be empty!");
		}
		if (lastName.length() > 20) {
			throw new IllegalArgumentException("Last Name cannot exceed 20 characters.");
		}
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {

		if (address == null || address.trim().isEmpty()) {
			throw new IllegalArgumentException("Address field must not be empty!");
		}
		if (address.length() > 50) {
			throw new IllegalArgumentException("Address cannot exceed 50 characters.");
		}
		this.address = address;
	}

	public DateTime getDob() {
		return dob;
	}

	public void setDob(DateTime dob) {
		this.dob = dob;
	}

	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {

		if (phone == null || phone.trim().isEmpty()) {
			throw new IllegalArgumentException("Phone field cannot be null or empty.");
		}
		this.phone = phone;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
