package com.athira.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.Teacher;

@Repository
public interface ITeacherDao extends JpaRepository<Teacher, Integer> {
	
	@Query("from Teacher WHERE firstName LIKE %?1%")
	List<Teacher> findByFirstName(String firstName);

	@Modifying
	@Query("update com.athira.demo.entity.Teacher SET stillWorkingHere = 'NO' WHERE teacherId = :id")
	void disableTeacher(@Param("id") Integer id);
	
	 // Call the stored procedure using @Procedure annotation
    @Procedure("sp_TeachersSummary")
    List<Object[]> sp_TeachersSummary(); 

}
