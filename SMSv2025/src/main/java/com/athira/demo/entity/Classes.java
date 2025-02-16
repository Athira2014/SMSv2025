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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "classes")
public class Classes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ClassId", nullable = false)
	private Integer classId;
	
	@Column(name = "ClassName", nullable = false, length = 20)
    private String className;
	
	@ManyToOne
	@JoinColumn(name = "TeacherId", insertable = false, updatable = false)
	private Teacher teacher; 
	
	@Column(name = "TeacherId", nullable = false)
	private Integer teacherId;
	
	@Column(name = "Details", nullable = false, length = 200)
    private String details;
    
	@JsonIgnore
    @OneToMany(mappedBy = "classes")
    private List<Enrollment> enrollments; // One class can have many enrollments
    
    public Classes() {
      
    }

	public Classes(Integer classId, String className, Integer teacherId, String details) {
		super();
		this.classId = classId;
		this.className = className;
		this.teacherId = teacherId;
		this.details = details;
	}



	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		if (className == null || className.trim().isEmpty()) {
			throw new IllegalArgumentException("class field must not be empty!");
		}
		if (className.length() > 20) {
			throw new IllegalArgumentException("class cannot exceed 20 characters.");
		}
		this.className = className;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		if (details == null || details.trim().isEmpty()) {
			throw new IllegalArgumentException("Details field must not be empty!");
		}
		if (details.length() > 200) {
			throw new IllegalArgumentException("Details cannot exceed 200 characters.");
		}
		this.details = details;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}
	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", className=" + className + ", teacher=" + teacher + ", teacherId="
				+ teacherId + ", details=" + details + ", enrollments=" + enrollments + "]";
	}

}
