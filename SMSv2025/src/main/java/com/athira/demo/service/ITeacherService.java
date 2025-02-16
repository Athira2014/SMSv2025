package com.athira.demo.service;

import java.util.List;
import java.util.Optional;

import com.athira.demo.entity.Teacher;

public interface ITeacherService {

	List<Teacher> getAllTeachers();
	
	Optional<Teacher> getTeacherById(Integer id);
	
	Teacher saveTeacher(Teacher teacher);

	Teacher editTeacher(Teacher teacher);

	List<Teacher> getTeacherByName(String name);

	void disableTeacher(int id);

	List<Teacher> getAllTeacherSummary();

	List<Object[]> getAllTeacherSummaryObjs();

}
