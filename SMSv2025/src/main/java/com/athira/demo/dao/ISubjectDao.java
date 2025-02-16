package com.athira.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.Subject;

@Repository
public interface ISubjectDao extends JpaRepository<Subject, Integer> {

	@Query("from Subject WHERE subName LIKE %?1%")
	Optional<Subject> findBySubName(String name);

}
