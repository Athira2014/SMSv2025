package com.athira.demo.service;

import java.util.List;
import java.util.Optional;

import com.athira.demo.entity.Student;

public interface IStudentService {

	List<Student> getAllStudents();

	Optional<Student> getStudentById(Integer id);

	Student saveStudent(Student student);

	Student editStudent(Student student);

	Student disableStudent(Integer id);

	Object[] getStudentReportById(Integer id);

}
