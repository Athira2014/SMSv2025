package com.athira.demo.dto;

import org.joda.time.DateTime;

public class ClassStudentsGradeSubjectDto {

	private Integer studentId;
	private Integer classId;
	private String className;
	private String firstName;
	private String lastName;
	private String subName;
	private char grade;
	private DateTime scoreDate;

	public ClassStudentsGradeSubjectDto() {
		super();
	}

	public ClassStudentsGradeSubjectDto(Integer studentId, Integer classId, String className, String firstName,
			String lastName, String subName, char grade, DateTime scoreDate) {
		super();
		this.studentId = studentId;
		this.classId = classId;
		this.className = className;
		this.firstName = firstName;
		this.lastName = lastName;
		this.subName = subName;
		this.grade = grade;
		this.scoreDate = scoreDate;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
