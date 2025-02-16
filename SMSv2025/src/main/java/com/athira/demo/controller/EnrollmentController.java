package com.athira.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athira.demo.common.APIResponse;
import com.athira.demo.entity.Enrollment;
import com.athira.demo.service.IEnrollmentService;
import com.athira.demo.service.IGradeService;

@RestController
@RequestMapping("api/")
public class EnrollmentController {

	@Autowired
	IEnrollmentService enrollmentService;
	
	// List all Enrollments
	@GetMapping("enrollments")
	public List<Enrollment> getAllEnrollments(Model model) {		
		return enrollmentService.getAllEnrollments();
	}

	// get Enrollment by id
	@GetMapping("enrollments/{id}")
	public Optional<Enrollment> getEnrollmentById(@PathVariable Integer id) {		
		return enrollmentService.getEnrollmentById(id);
	}
	
	//Add new Enrollment
	@PostMapping("enrollments") 
	public ResponseEntity<APIResponse> createEnrollment(@RequestBody Enrollment enrollment) { 

		APIResponse apiResponse = new APIResponse();
		try {
			enrollmentService.createEnrollment(enrollment);
			apiResponse.setStatus(200);
			apiResponse.setData("Enrollment created succesfully!");
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	//Edit Enrollment
	@PutMapping("enrollments") 
	public ResponseEntity<APIResponse> editEnrollment(@RequestBody Enrollment enrollment) {
		
		APIResponse apiResponse = new APIResponse();
		try {
			Enrollment enrollmentEntity = enrollmentService.updateEnrollment(enrollment);
			apiResponse.setStatus(200);
			apiResponse.setData(enrollmentEntity);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	
	/*
	 * //Add new Enrollment
	 * 
	 * @GetMapping("/addEnrollment") public String addEnrollment(Model model) {
	 * model.addAttribute("students", studentService.getAllStudents());
	 * model.addAttribute("classes", classesService.getAllClasses()); return
	 * "AddEnrollment"; }
	 * 
	 * // insert new Enrollment
	 * 
	 * @PostMapping("/insertEnrollment") public String
	 * insertEnrollment(@ModelAttribute Enrollment enrollment, Model model) { try {
	 * // Add new students details to the database
	 * enrollmentService.insertEnrollment(enrollment);
	 * 
	 * // Redirect to the students list or success page return
	 * "redirect:/enrollment/list"; } catch (Exception e) {
	 * System.out.println(e.getMessage()); return "AddEnrollment"; }
	 * 
	 * }
	 * 
	 * //Edit a Enrollment
	 * 
	 * @GetMapping("/editEnrollment/{id}") public String
	 * editEnrollment(@PathVariable(value = "id") int id, Model model) { Enrollment
	 * enrollment = enrollmentService.getEnrollmentById(id); if (enrollment != null)
	 * { model.addAttribute("enrollment", enrollment);
	 * model.addAttribute("students", studentService.getAllStudents());
	 * model.addAttribute("classes", classesService.getAllClasses()); } return
	 * "EditEnrollment"; }
	 * 
	 * //update a Enrollment
	 * 
	 * @PostMapping("/editEnrollment/updateEnrollment") public String
	 * updateEnrollment(@ModelAttribute Enrollment enrollment, Model model) {
	 * enrollmentService.updateEnrollment(enrollment); return
	 * "redirect:/enrollment/list"; }
	 * 
	 * //delete a Enrollment
	 * 
	 * @GetMapping("/deleteEnrollment/{id}") public String
	 * deleteEnrollment(@PathVariable(value = "id") int id, Model model) {
	 * enrollmentService.deleteEnrollment(id); return "redirect:/enrollment/list"; }
	 */
}
