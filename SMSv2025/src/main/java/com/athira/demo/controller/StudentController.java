package com.athira.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athira.demo.common.APIResponse;
import com.athira.demo.entity.Student;
import com.athira.demo.service.IGradeService;
import com.athira.demo.service.IStudentService;

@RestController
@RequestMapping("api/")
public class StudentController {

	@Autowired
	IStudentService studentService;
	
	@Autowired
	IGradeService gradeService;

	// List all students
	@GetMapping("students")
	public ResponseEntity<APIResponse> getAllStudents() {

		APIResponse apiResponse = new APIResponse();
		try {
			List<Student> students = studentService.getAllStudents();
			apiResponse.setStatus(200);
			apiResponse.setData(students);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Get student by id
	@GetMapping("students/{id}")
	public ResponseEntity<APIResponse> getStudentById(@PathVariable Integer id) {

		APIResponse apiResponse = new APIResponse();
		try {
			Optional<Student> student = studentService.getStudentById(id);
			apiResponse.setStatus(200);
			apiResponse.setData(student.get());
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// create a new student record
	@PostMapping("students")
	public ResponseEntity<APIResponse> addStudent(@RequestBody Student student) {

		APIResponse apiResponse = new APIResponse();
		try {
			Student studentEntity = studentService.saveStudent(student);
			apiResponse.setStatus(200);
			apiResponse.setData(studentEntity);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Update student record
	@PutMapping("students")
	public ResponseEntity<APIResponse> editStudent(@RequestBody Student student) {

		APIResponse apiResponse = new APIResponse();
		try {
			Student studentEntity = studentService.saveStudent(student);
			apiResponse.setStatus(200);
			apiResponse.setData(studentEntity);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Disable student
	@DeleteMapping("students/{id}")
	public ResponseEntity<APIResponse> disableStudent(@PathVariable Integer id) {

		APIResponse apiResponse = new APIResponse();
		try {
			Student studentEntity = studentService.disableStudent(id);
			apiResponse.setStatus(200);
			apiResponse.setData(studentEntity);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	// student report by student id
	@GetMapping("students/report/{id}")
	public ResponseEntity<APIResponse> getStudentReportById(@PathVariable Integer id) {

		APIResponse apiResponse = new APIResponse();
		try {
			Object[] report = studentService.getStudentReportById(id);
			apiResponse.setStatus(200);
			apiResponse.setData(report);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}


}
