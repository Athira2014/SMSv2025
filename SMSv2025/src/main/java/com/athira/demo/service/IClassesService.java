package com.athira.demo.service;

import java.util.List;
import java.util.Optional;

import com.athira.demo.entity.Classes;

public interface IClassesService {

	List<Classes> getAllClasses();

	Optional<Classes> getClassesById(Integer id);

	Classes createNewClass(Classes classes);

	Classes updateAClass(Classes classes);

	List<Classes> getClassesByName(String name);

	Classes saveClasses(Classes classes);

	void deleteAClass(Integer id);

}
