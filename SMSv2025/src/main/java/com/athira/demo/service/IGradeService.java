package com.athira.demo.service;

import java.util.List;
import java.util.Optional;

import com.athira.demo.dto.ClassStudentsGradeSubjectDto;
import com.athira.demo.entity.Grade;

public interface IGradeService {

	List<Grade> getAllGrades();

	Optional<Grade> getGradeById(Integer id);

	Grade createGrade(Grade grade);

	Grade editGrade(Grade grade);

	Grade saveGrade(Grade grade);

	void deleteGrade(Grade grade);

	List<ClassStudentsGradeSubjectDto> getStudentsReportByClassId(Integer classId);

}
