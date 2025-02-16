package com.athira.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athira.demo.common.Validation;
import com.athira.demo.dao.ISubjectDao;
import com.athira.demo.dao.ITeacherDao;
import com.athira.demo.entity.Subject;
import com.athira.demo.entity.Teacher;

@Transactional
@Service
public class TeacherService implements ITeacherService {

	@Autowired
	ITeacherDao teacherDao;

	@Autowired
	ISubjectDao subjectDao;

	@Autowired
	Validation validation;

	@Transactional
	public List<Teacher> getAllTeachers() {
		return teacherDao.findAll();
	}

	@Transactional
	public Optional<Teacher> getTeacherById(Integer id) {
		return teacherDao.findById(id);
	}

	@Transactional
	public Teacher saveTeacher(Teacher teacher) {

		// when saving a new teacher
		if (teacher.getTeacherId() == null && teacher.getJoiningDate() == null) {
			teacher.setJoiningDate(new DateTime());
		}

		return teacherDao.save(teacher);
	}

	public Teacher editTeacher(Teacher teacher) {

		Optional<Teacher> teacherOptional = teacherDao.findById(teacher.getTeacherId());

		if (!teacherOptional.isPresent()) {
			throw new Error("Teacher not found!");
		}

		Optional<Subject> subjectOptional = subjectDao.findById(teacher.getSubId());
		if (!subjectOptional.isPresent()) {
			throw new Error("Subject not found!");
		}

		Teacher teacherEntity = teacherOptional.get();
		teacherEntity.setFirstName(teacher.getFirstName());
		teacherEntity.setLastName(teacher.getLastName());
		teacherEntity.setStillWorkingHere(teacher.getStillWorkingHere());
		teacherEntity.setSubject(subjectOptional.get());

		return teacherDao.save(teacherEntity);
	}

	public List<Teacher> getTeacherByName(String firstName) {

		return teacherDao.findByFirstName(firstName);
	}

	public void disableTeacher(int id) {
		teacherDao.disableTeacher(id);
	}

	public List<Teacher> getAllTeacherSummary() {
		List<Object[]> summary = teacherDao.sp_TeachersSummary();
		List<Teacher> teacherSummary = new ArrayList<Teacher>();

		for (Object[] summaryObj : summary) {
			Teacher teacher = new Teacher();
			Subject subject = new Subject();
			teacher.setFirstName((String) summaryObj[0]);
			teacher.setLastName((String) summaryObj[1]);
			subject.setSubName((String) summaryObj[2]);
			teacher.setSubject(subject);
			teacherSummary.add(teacher);
		}
		return teacherSummary;
	}

	public List<Object[]> getAllTeacherSummaryObjs() {

		return teacherDao.sp_TeachersSummary();

	}

}
