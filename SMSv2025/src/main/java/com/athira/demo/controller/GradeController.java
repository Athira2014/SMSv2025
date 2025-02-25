package com.athira.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athira.demo.common.APIResponse;
import com.athira.demo.dto.ClassStudentsGradeSubjectDto;
import com.athira.demo.entity.Grade;
import com.athira.demo.service.IGradeService;
import com.athira.demo.util.JwtUtils;

@RestController
@RequestMapping("api/")
public class GradeController {

	@Autowired
	IGradeService gradeService;
	
	@Autowired
	JwtUtils jwtUtils;

	// List all Grades
	@GetMapping("grades")
	public ResponseEntity<APIResponse> getAllGrades(Model model,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}

		try {
			List<Grade> grades = gradeService.getAllGrades();
			apiResponse.setStatus(200);
			apiResponse.setData(grades);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Get Grades by id
	@GetMapping("grades/{id}")
	public ResponseEntity<APIResponse> getGradeById(@PathVariable Integer id,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}
		
		try {
			Optional<Grade> grade = gradeService.getGradeById(id);
			apiResponse.setStatus(200);
			apiResponse.setData(grade);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Get students report by class id

	@GetMapping("grades/students/dto/{classId}")
	public ResponseEntity<APIResponse> getStudentsReportByClassId(@PathVariable Integer classId,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}

		try {
			List<ClassStudentsGradeSubjectDto> reports = gradeService.getStudentsReportByClassId(classId);
			apiResponse.setStatus(200);
			apiResponse.setData(reports);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// create a new Grade
	@PostMapping("grades")
	public ResponseEntity<APIResponse> createGrade(@RequestBody Grade grade,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}
		try {
			Grade gradeEntity = gradeService.saveGrade(grade);
			apiResponse.setStatus(200);
			apiResponse.setData(gradeEntity);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Edit and update Grade
	@PutMapping("grades")
	public ResponseEntity<APIResponse> editGrade(@RequestBody Grade grade,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}
		try {
			Grade gradeEntity = gradeService.saveGrade(grade);
			apiResponse.setStatus(200);
			apiResponse.setData(gradeEntity);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Delete Grade
	@DeleteMapping("grades")
	public ResponseEntity<APIResponse> deleteGrade(@RequestBody Grade grade,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}
		try {
			gradeService.deleteGrade(grade);
			apiResponse.setStatus(200);
			apiResponse.setData("Grade Deleted succesfully");
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

}
