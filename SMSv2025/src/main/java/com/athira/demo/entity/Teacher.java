package com.athira.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TeacherId", nullable = false)
	private Integer teacherId;

	@Column(name = "TFirstName", nullable = false, length = 20)
	private String firstName;

	@Column(name = "TLastName", nullable = false, length = 20)
	private String lastName;

	@Column(name = "JoiningDate", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime joiningDate;

	@Column(name = "StillWorkingHere", nullable = false)
	private String stillWorkingHere;

	@ManyToOne()
	@JoinColumn(name = "subId", insertable = false, updatable = false)
	private Subject subject;

	@Column(name = "subId", nullable = false)
	private Integer subId;
	
	@OneToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;  
	
	@Column(name = "userId", nullable = false)
    private Integer userId; 

	@JsonIgnore
	@OneToMany(mappedBy = "teacher")
	private List<Classes> classes;

	public Teacher(Integer teacherId, String firstName, String lastName, DateTime joiningDate, String stillWorkingHere,
			Integer subId, Integer userId, List<Classes> classes) {
		super();
		this.teacherId = teacherId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.joiningDate = joiningDate;
		this.stillWorkingHere = stillWorkingHere;
		this.subId = subId;
		this.userId = userId;
		this.classes = classes;
	}

	public Teacher() {
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.trim().isEmpty()) {
			throw new IllegalArgumentException("First Name cannot be null or empty.");
		}
		if (firstName.length() > 50) {
			throw new IllegalArgumentException("First Name cannot exceed 50 characters.");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		
		if (lastName == null || lastName.trim().isEmpty()) {
			throw new IllegalArgumentException("Last Name cannot be null or empty.");
		}
		if (lastName.length() > 50) {
			throw new IllegalArgumentException("Last Name cannot exceed 50 characters.");
		}
		this.lastName = lastName;
	}

	public DateTime getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(DateTime joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getStillWorkingHere() {
		return stillWorkingHere;
	}

	public void setStillWorkingHere(String stillWorkingHere) {
		this.stillWorkingHere = stillWorkingHere;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Classes> getClasses() {
		return classes;
	}

	public void setClasses(List<Classes> classes) {
		this.classes = classes;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getSubId() {
		return subId;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", joiningDate=" + joiningDate + ", stillWorkingHere=" + stillWorkingHere + ", subId=" + subId
				+ ", userId=" + userId + ", classes=" + classes + "]";
	}

}
