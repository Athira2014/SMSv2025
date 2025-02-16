package com.athira.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.athira.demo.common.Validation;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "subjects")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subId", nullable = false)
	private Integer subId;

	@Column(name = "subName", nullable = false, length = 20)
	private String subName;

	@JsonIgnore
	@OneToMany(mappedBy = "subject")
	private List<Teacher> teachers;

	@JsonIgnore
	@OneToMany(mappedBy = "subject")
	private List<Grade> grades;

	public Subject() {

	}

	public Subject(Integer subId, String subName) {
		this.subId = subId;
		this.subName = subName;
	}

	public Integer getSubId() {
		return subId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		if (!Validation.isNameValid(subName)) {
			throw new IllegalArgumentException("Subject name should not be null and contain only alphabets.");
		}
		this.subName = subName;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

}
