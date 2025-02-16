package com.athira.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.athira.demo.entity.Classes;

@Repository
public interface IClassesDao extends JpaRepository<Classes, Integer> {

	@Query("from Classes WHERE className LIKE %?1%")
	List<Classes> findByClassName(String name);

}
