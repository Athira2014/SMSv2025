package com.athira.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.athira.demo.dao.IGradeDao;
import com.athira.demo.dao.IStudentDao;
import com.athira.demo.dao.ISubjectDao;
import com.athira.demo.dto.ClassStudentsGradeSubjectDto;
import com.athira.demo.entity.Grade;
import com.athira.demo.entity.Student;
import com.athira.demo.entity.Subject;

@Service
public class GradeService implements IGradeService {

	@Autowired
	IGradeDao gradeDao;

	@Autowired
	IStudentDao studentDao;

	@Autowired
	ISubjectDao subjectDao;

	@Transactional
	public List<Grade> getAllGrades() {
		return gradeDao.findAll();
	}

	@Transactional
	public Optional<Grade> getGradeById(Integer id) {
		return gradeDao.findById(id);
	}

	@Transactional
	public Grade createGrade(Grade grade) {

		Optional<Student> studentOptional = studentDao.findById(grade.getStudentId());

		if (studentOptional.isPresent()) {
			Student student = studentOptional.get();
			grade.setStudent(student);
		} else {
			throw new Error("Student not found!");
		}

		Optional<Subject> subjectOptional = subjectDao.findById(grade.getSubId());

		if (subjectOptional.isPresent()) {
			Subject subject = subjectOptional.get();
			grade.setSubject(subject);
		} else {
			throw new Error("Subject not found!");
		}
		grade.setScoreDate(new DateTime());
		return gradeDao.save(grade);
	}

	@Transactional
	public Grade editGrade(Grade grade) {
		System.out.println("grade.toString():" + grade.toString());
		Optional<Grade> gradeOptional = gradeDao.findById(grade.getgId());

		if (!gradeOptional.isPresent()) {
			throw new Error("Grade not found!");
		}
		Grade gradeEntity = gradeOptional.get();

		Optional<Student> studentOptional = studentDao.findById(grade.getStudentId());

		if (studentOptional.isPresent()) {
			Student student = studentOptional.get();
			gradeEntity.setStudent(student);
		} else {
			throw new Error("Student not found!");
		}

		Optional<Subject> subjectOptional = subjectDao.findById(grade.getSubId());

		if (subjectOptional.isPresent()) {
			Subject subject = subjectOptional.get();
			gradeEntity.setSubject(subject);
		} else {
			throw new Error("Subject not found!");
		}
		gradeEntity.setGrade(grade.getGrade());
		gradeEntity.setScoreDate(grade.getScoreDate() != null ? grade.getScoreDate() : gradeEntity.getScoreDate());

		return gradeDao.save(gradeEntity);
	}

	public Grade saveGrade(Grade grade) {
		try {
			return gradeDao.save(grade);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Invalid data: " + e.getMessage(), e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unexpected error occurred while saving grade", e);

		}
		

	}

	public void deleteGrade(Grade grade) {
		gradeDao.delete(grade);
	}

	public List<ClassStudentsGradeSubjectDto> getStudentsReportByClassId(Integer classId) {
		return gradeDao.getStudentsReportByClassId(classId);
	}

}
