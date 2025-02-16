package com.athira.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athira.demo.dao.IClassesDao;
import com.athira.demo.dao.ITeacherDao;
import com.athira.demo.entity.Classes;
import com.athira.demo.entity.Teacher;

@Transactional
@Service
public class ClassesService implements IClassesService {

	@Autowired
	IClassesDao classesDao;
	
	@Autowired
	ITeacherDao teacherDao;

	@Transactional
	public List<Classes> getAllClasses() {
		return classesDao.findAll();
	}

	public Optional<Classes> getClassesById(Integer id) {
		return classesDao.findById(id);
	}

	@Transactional
	public Classes createNewClass(Classes classes) {

		// If teacherId is provided, update the teacher as well

		if (classes.getTeacherId() != null) {
			Teacher teacher = teacherDao.findById(classes.getTeacherId()).orElse(null);
			if (teacher != null) {
				classes.setTeacher(teacher);
			}
		}

		return classesDao.save(classes);
	}

	@Transactional
	public Classes updateAClass(Classes classes) {
		Optional<Classes> classesOptional = classesDao.findById(classes.getClassId());
		if (!classesOptional.isPresent()) {
			throw new Error("Class not found!");
		}
		Classes classesEntity = classesOptional.get();
		classesEntity.setClassName(classes.getClassName());
		classesEntity.setDetails(classes.getDetails());

		// If teacherId is provided, update the teacher as well
		
		  if (classes.getTeacherId() != null) {
		  classesEntity.setTeacherId(classes.getTeacherId()); Teacher teacher =
		  teacherDao.findById(classes.getTeacherId()).orElse(null); if (teacher !=
		  null) { classesEntity.setTeacher(teacher); } }
		 
		return classesDao.save(classesEntity);

	}

	public List<Classes> getClassesByName(String name) {
		return classesDao.findByClassName(name);
	}

	public Classes saveClasses(Classes classes) {
		return classesDao.save(classes);
	}

	public void deleteAClass(Integer id) {
		 classesDao.deleteById(id);
	}

}
