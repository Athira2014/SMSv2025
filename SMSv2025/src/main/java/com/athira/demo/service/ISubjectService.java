package com.athira.demo.service;

import java.util.List;
import java.util.Optional;

import com.athira.demo.entity.Subject;

public interface ISubjectService {

	List<Subject> getAllSubjects();

	Subject saveSubject(Subject subject);

	Optional<Subject> getSubjectById(Integer id);

	Subject editSubject(Subject subject);

	Optional<Subject> getSubjectByName(String name);

	void deleteSubject(Integer id);

}
