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
import com.athira.demo.entity.Teacher;
import com.athira.demo.service.ISubjectService;
import com.athira.demo.service.ITeacherService;

@RestController
@RequestMapping("api/")
public class TeacherController {

	@Autowired
	ITeacherService teacherService;

	@Autowired
	ISubjectService subjectService;

	// List all Teachers
	@GetMapping("teachers")
	public ResponseEntity<APIResponse> getAllTeachers() {

		APIResponse apiResponse = new APIResponse();

		try {
			List<Teacher> teachers = teacherService.getAllTeachers();
			apiResponse.setStatus(200);
			apiResponse.setData(teachers);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	// get a Teacher
	@GetMapping("teachers/{id}")
	public ResponseEntity<APIResponse> getTeacherById(@PathVariable Integer id) {

		APIResponse apiResponse = new APIResponse();

		try {
			Optional<Teacher> teacher = teacherService.getTeacherById(id);
			apiResponse.setStatus(200);
			apiResponse.setData(teacher);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	// get a Teacher
	@GetMapping("teachers/search/{name}")
	public ResponseEntity<APIResponse> getTeacherByName(@PathVariable String name) {

		APIResponse apiResponse = new APIResponse();

		try {
			List<Teacher> teacher = teacherService.getTeacherByName(name);
			apiResponse.setStatus(200);
			apiResponse.setData(teacher);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}
	

	// get a Teacher
	@GetMapping("teachers/teachersummary")
	public ResponseEntity<APIResponse> getAllTeacherSummary() {

		APIResponse apiResponse = new APIResponse();

		try {
			List<Teacher> summary = teacherService.getAllTeacherSummary();
			apiResponse.setStatus(200);
			apiResponse.setData(summary);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	// get a Teacher
	@GetMapping("teachers/summary")
	public ResponseEntity<APIResponse> getAllTeacherSummaryObjs() {

		APIResponse apiResponse = new APIResponse();

		try {
			List<Object[]> summary = teacherService.getAllTeacherSummaryObjs();
			apiResponse.setStatus(200);
			apiResponse.setData(summary);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}


	// Add Teacher
	@PostMapping("teachers")
	public ResponseEntity<APIResponse> addTeacher(@RequestBody Teacher teacher) {

		APIResponse apiResponse = new APIResponse();

		try {
			Teacher teacherEntity = teacherService.saveTeacher(teacher);
			apiResponse.setStatus(200);
			apiResponse.setData(teacherEntity);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	// Edit Teacher
	@PutMapping("teachers")
	public ResponseEntity<APIResponse> editTeacher(@RequestBody Teacher teacher) {

		APIResponse apiResponse = new APIResponse();

		try {
			Teacher teacherEntity = teacherService.saveTeacher(teacher);
			apiResponse.setStatus(200);
			apiResponse.setData(teacherEntity);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	

	// INACTIVE Teacher
	@DeleteMapping("teachers/disable/{id}")
	public ResponseEntity<APIResponse> disableTeacher(@PathVariable int id) {

		APIResponse apiResponse = new APIResponse();

		try {
			teacherService.disableTeacher(id);
			apiResponse.setStatus(200);
			apiResponse.setData("Teacher status disabled succesfully!");
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
}
