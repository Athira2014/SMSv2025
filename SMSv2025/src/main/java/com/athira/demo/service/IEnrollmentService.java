package com.athira.demo.service;

import java.util.List;
import java.util.Optional;

import com.athira.demo.entity.Enrollment;

public interface IEnrollmentService {

	List<Enrollment> getAllEnrollments();

	Optional<Enrollment> getEnrollmentById(Integer id);

	Enrollment editEnrollment(Enrollment enrollment);

	void createEnrollment(Enrollment enrollment);

	Enrollment updateEnrollment(Enrollment enrollment);

}
