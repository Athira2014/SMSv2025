package com.athira.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.Student;

@Repository
public interface IStudentDao extends JpaRepository<Student, Integer> {

	@Modifying
	@Query("UPDATE Student SET isActive = 0 WHERE studentId = :id")
	Student disableStudent(@Param("id") Integer id);

	@Procedure("sp_AllStudentSummary")
	List<Student> sp_AllStudentSummary();

	@Procedure("sp_StudentsSummaryById")
	Optional<Student> sp_StudentsSummaryById(Integer id);

	@Procedure("spRetrieveStudentPerfomanceReport")
	Object[] spRetrieveStudentPerfomanceReport(Integer id);

}
