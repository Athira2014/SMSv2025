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
import com.athira.demo.entity.Subject;
import com.athira.demo.service.ISubjectService;

@RestController
@RequestMapping("api/")
public class SubjectController {

	@Autowired
	ISubjectService subjectService;

	// List all Subjects
	@GetMapping("subjects")
	public List<Subject> getAllSubjects() {
		return subjectService.getAllSubjects();
	}

	// Get Subject by id
	@GetMapping("subjects/{id}")
	public ResponseEntity<APIResponse> getSubjectById(@PathVariable Integer id) {

		APIResponse apiResponse = new APIResponse();

		try {
			Optional<Subject> subject = subjectService.getSubjectById(id);
			apiResponse.setStatus(200);
			apiResponse.setData(subject.get());
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Get Subject by id
	@GetMapping("subjects/search/{name}")
	public ResponseEntity<APIResponse> getSubjectByName(@PathVariable String name) {

		APIResponse apiResponse = new APIResponse();

		try {
			Optional<Subject> subject = subjectService.getSubjectByName(name);
			apiResponse.setStatus(200);
			apiResponse.setData(subject.get());
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Add Subjects
	@PostMapping("subjects")
	public ResponseEntity<APIResponse> addSubject(@RequestBody Subject subject) {

		APIResponse apiResponse = new APIResponse();

		try {
			Subject subjectEntity = subjectService.saveSubject(subject);
			apiResponse.setStatus(200);
			apiResponse.setData("Subject created succesfully ! :" + subjectEntity);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	// Update Subject
	@PutMapping("subjects")
	public ResponseEntity<APIResponse> editSubject(@RequestBody Subject subject) {
		APIResponse apiResponse = new APIResponse();

		try {
			Subject subjectEntity = subjectService.saveSubject(subject);
			apiResponse.setStatus(200);
			apiResponse.setData("Subject updated succesfully ! :" + subjectEntity);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Delete subject permenantly.
	@DeleteMapping("subjects/{id}")
	public ResponseEntity<APIResponse> deleteSubject(@PathVariable Integer id) {

		APIResponse apiResponse = new APIResponse();

		try {
			subjectService.deleteSubject(id);
			apiResponse.setStatus(200);
			apiResponse.setData("Subject deleted succesfully ! :");
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
}
