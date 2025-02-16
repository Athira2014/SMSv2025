package com.athira.demo.dao;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.Enrollment;

@Repository
public interface IEnrollmentDao extends JpaRepository<Enrollment, Integer> {

	@Procedure("sp_StudentEnrollment")
	void sp_StudentEnrollment(Integer studentId, Integer classId, DateTime enrollDate);

}
