package com.athira.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athira.demo.dao.ISubjectDao;
import com.athira.demo.entity.Subject;

@Transactional
@Service
public class SubjectService implements ISubjectService {
	
	@Autowired
	ISubjectDao subjectDao;

	@Transactional
	public List<Subject> getAllSubjects() {
		return subjectDao.findAll();
	}

	public Subject saveSubject(Subject subject) {
		return subjectDao.save(subject);
	}

	@Transactional
	public Optional<Subject> getSubjectById(Integer id) {
		return subjectDao.findById(id);
	}
	
	
	public Subject editSubject(Subject subject) {
		
		Optional<Subject> subjectOptional = subjectDao.findById(subject.getSubId());
		if(subjectOptional.isPresent()) {
			Subject subjectEntity = subjectOptional.get();
			subjectEntity.setSubName(subject.getSubName());
			return subjectDao.save(subject);
		}
		else {
            throw new Error("Subject with ID " + subject.getSubId() + " not found");
        }
	}

	public Optional<Subject> getSubjectByName(String name) {
		return subjectDao.findBySubName(name);
	}

	public void deleteSubject(Integer id) {
		subjectDao.deleteById(id);
	}

}
