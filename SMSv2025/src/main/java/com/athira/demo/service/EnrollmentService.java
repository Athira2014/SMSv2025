package com.athira.demo.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athira.demo.dao.IClassesDao;
import com.athira.demo.dao.IEnrollmentDao;
import com.athira.demo.dao.IStudentDao;
import com.athira.demo.entity.Classes;
import com.athira.demo.entity.Enrollment;
import com.athira.demo.entity.Student;

@Service
public class EnrollmentService implements IEnrollmentService {

	@Autowired
	IEnrollmentDao enrollmentDao;

	@Autowired
	IClassesDao classesDao;

	@Autowired
	IStudentDao studentDao;

	@Transactional
	public List<Enrollment> getAllEnrollments() {
		return enrollmentDao.findAll();
	}

	@Transactional
	public Optional<Enrollment> getEnrollmentById(Integer id) {
		return enrollmentDao.findById(id);
	}

	/*
	 * @Transactional public Enrollment createEnrollment(Enrollment enrollment) {
	 * 
	 * Optional<Classes> classesOptional =
	 * classesDao.findById(enrollment.getClassId()); Optional<Student>
	 * studentOptional = studentDao.findById(enrollment.getStudentId());
	 * 
	 * if (classesOptional.isPresent()) { Classes classes = classesOptional.get();
	 * enrollment.setClasses(classes); } else { throw new Error("Class not found!");
	 * }
	 * 
	 * if (studentOptional.isPresent()) { Student student = studentOptional.get();
	 * enrollment.setStudent(student); } else { throw new
	 * Error("Student not found!"); }
	 * 
	 * enrollment.setEnrollDate(new DateTime()); return
	 * enrollmentDao.save(enrollment); }
	 */

	@Transactional
	public Enrollment editEnrollment(Enrollment enrollment) {

		Optional<Enrollment> enOptional = enrollmentDao.findById(enrollment.getEnrollId());
		if (!enOptional.isPresent()) {
			throw new Error("Enrollment not found!");
		}
		Enrollment enrollmentEntity = enOptional.get();

		Optional<Classes> classesOptional = classesDao.findById(enrollment.getClassId());
		Optional<Student> studentOptional = studentDao.findById(enrollment.getStudentId());

		if (classesOptional.isPresent()) {
			Classes classes = classesOptional.get();
			enrollmentEntity.setClasses(classes);
		} else {
			throw new Error("Class not found!");
		}

		if (studentOptional.isPresent()) {
			Student student = studentOptional.get();
			enrollmentEntity.setStudent(student);
		} else {
			throw new Error("Student not found!");
		}

		// enrollment.setEnrollDate(new DateTime());
		return enrollmentDao.save(enrollmentEntity);
	}

	public void createEnrollment(Enrollment enrollment) {

		if (enrollment.getEnrollId() == null && enrollment.getEnrollDate() == null) {
			enrollment.setEnrollDate(new DateTime());
		}

		try {
			enrollmentDao.sp_StudentEnrollment(enrollment.getStudentId(), enrollment.getClassId(),
					enrollment.getEnrollDate());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Enter valid input" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unexpected error occurred while saving enrollment", e);
		}
	}

	public Enrollment updateEnrollment(Enrollment enrollment) {
		try {
			return enrollmentDao.save(enrollment);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Enter valid input" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unexpected error occurred while updating enrollment", e);
		}
	}

}
