package com.athira.demo.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.athira.demo.common.Validation;
import com.athira.demo.dao.IStudentDao;
import com.athira.demo.entity.Student;

@Transactional
@Service
public class StudentService implements IStudentService {

	@Autowired
	IStudentDao studentDao;

	@Autowired
	private Validation validation;

	@Transactional
	public List<Student> getAllStudents() {
		// return studentDao.findAll();
		return studentDao.sp_AllStudentSummary();
	}

	public Optional<Student> getStudentById(Integer id) {
		// return studentDao.findById(id);
		return studentDao.sp_StudentsSummaryById(id);
	}

	@Transactional
	public Student saveStudent(Student student) {

		if (!validation.isNameValid(student.getFirstName()) || !validation.isNameValid(student.getLastName())) {
			throw new IllegalArgumentException("Name field should contain only alphabets.");
		}
		if (!validation.isPhoneNumberValid(student.getPhone())) {
			throw new IllegalArgumentException("Phone number format is invalid.");
		}
		if (student.getIsActive() == null) {
			student.setIsActive(true); // Default to true if null
		}
		return studentDao.save(student);
	}

	@Transactional
	public Student editStudent(Student student) {

		Optional<Student> stuOptional = studentDao.findById(student.getStudentId());
		if (!stuOptional.isPresent()) {
			throw new Error("Student not found.");
		}
		Student studentEntity = stuOptional.get();
		studentEntity.setAddress(student.getAddress());
		studentEntity.setDob(student.getDob());
		studentEntity.setFirstName(student.getFirstName());
		studentEntity.setLastName(student.getLastName());
		studentEntity.setPhone(student.getPhone());
		return studentDao.save(student);
	}

	public Student disableStudent(Integer id) {
		return studentDao.disableStudent(id);
	}

	public Object[] getStudentReportById(Integer id) {

		try {
			return studentDao.spRetrieveStudentPerfomanceReport(id);
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Enter valid id" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unexpected error occurred while getting student report", e);
		}
	}

}
