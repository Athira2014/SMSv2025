package com.athira.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "grades")
public class Grade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GId", nullable = false)
	private Integer gId;

	@ManyToOne
	@JoinColumn(name = "StudentId", insertable = false, updatable = false)
	private Student student;

	@Column(name = "StudentId", nullable = false)
	private Integer studentId;

	@ManyToOne
	@JoinColumn(name = "subId", insertable = false, updatable = false)
	private Subject subject;

	@Column(name = "subId", nullable = false)
	private Integer subId;

	@Column(name = "Grade", nullable = false, length = 1)
	private char grade;

	@Column(name = "ScoreDate", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime scoreDate;

	public Grade() {
	}

	public Grade(Integer gId, Student student, Subject subject, char grade, DateTime scoreDate) {
		super();
		this.gId = gId;
		this.student = student;
		this.subject = subject;
		this.grade = grade;
		this.scoreDate = scoreDate;
	}

	public Integer getgId() {
		return gId;
	}

	public void setgId(Integer gId) {
		this.gId = gId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public DateTime getScoreDate() {
		return scoreDate;
	}

	public void setScoreDate(DateTime scoreDate) {
		this.scoreDate = scoreDate;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getSubId() {
		return subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	@Override
	public String toString() {
		return "Grade [gId=" + gId + ", student=" + student + ", studentId=" + studentId + ", subject=" + subject
				+ ", subId=" + subId + ", grade=" + grade + ", scoreDate=" + scoreDate + "]";
	}

}
