package com.athira.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.athira.demo.dto.ClassStudentsGradeSubjectDto;
import com.athira.demo.entity.Grade;

@Repository
public interface IGradeDao extends JpaRepository<Grade, Integer> {

	@Query("SELECT new com.athira.demo.dto.ClassStudentsGradeSubjectDto(s.studentId, c.classId, c.className, "
		       + "s.firstName, s.lastName, sub.subName, g.grade, g.scoreDate) "
		       + "FROM Enrollment e "
		       + "INNER JOIN e.student s "
		       + "INNER JOIN e.classes c "
		       + "INNER JOIN Grade g ON g.studentId = e.studentId "
		       + "INNER JOIN Subject sub ON sub.subId = g.subId "
		       + "WHERE c.classId = :id")
		List<ClassStudentsGradeSubjectDto> getStudentsReportByClassId(@Param("id") Integer id);

}
