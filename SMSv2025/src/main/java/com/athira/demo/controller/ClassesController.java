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
import com.athira.demo.entity.Classes;
import com.athira.demo.service.IClassesService;
import com.athira.demo.util.JwtUtils;

@RestController
@RequestMapping("api/")
public class ClassesController {

	@Autowired
	IClassesService classesService;
	
	@Autowired
	JwtUtils jwtUtils;

	// List all classes
	@GetMapping("classes")
	public ResponseEntity<APIResponse> getAllClasses(Model model) {

		APIResponse apiResponse = new APIResponse();

		try {
			List<Classes> classesEntity = classesService.getAllClasses();
			apiResponse.setStatus(200);
			apiResponse.setData(classesEntity);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// get classes by id
	@GetMapping("classes/{id}")
	public ResponseEntity<APIResponse> getClassesById(@PathVariable Integer id) {

		APIResponse apiResponse = new APIResponse();

		try {
			Optional<Classes> classesEntity = classesService.getClassesById(id);
			apiResponse.setStatus(200);
			apiResponse.setData(classesEntity);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	// get classes by id
	@GetMapping("classes/search/{name}")
	public ResponseEntity<APIResponse> getClassesByName(@PathVariable String name) {

		APIResponse apiResponse = new APIResponse();

		try {
			List<Classes> classesEntity = classesService.getClassesByName(name);
			apiResponse.setStatus(200);
			apiResponse.setData(classesEntity);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	// Create a new class details
	@PostMapping("classes")
	public ResponseEntity<APIResponse> createNewClass(@RequestBody Classes classes,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}
		try {
			Classes classesEntity = classesService.saveClasses(classes);
			apiResponse.setStatus(200);
			apiResponse.setData(classesEntity);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// Update class details
	@PutMapping("classes")
	public ResponseEntity<APIResponse> updateAClass(@RequestBody Classes classes,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}

		try {
			Classes classesEntity = classesService.saveClasses(classes);
			apiResponse.setStatus(200);
			apiResponse.setData(classesEntity);
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}
	
	// Delete class details
	@DeleteMapping("classes")
	public ResponseEntity<APIResponse> deleteAClass(@PathVariable Integer id,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) {

		APIResponse apiResponse = new APIResponse();

		ResponseEntity<APIResponse> tokenVerificationResponse = jwtUtils.verifyToken(auth);

		if (tokenVerificationResponse != null) {
			return tokenVerificationResponse;
		}

		try {
			classesService.deleteAClass(id);
			apiResponse.setStatus(200);
			apiResponse.setData("Class deleted successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(500);
			apiResponse.setError(e.getMessage());
		}
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}
	/*
	 * //Add new class
	 * 
	 * @GetMapping("/addClasses") public String addClasses(Model model) {
	 * model.addAttribute("teachers", teacherService.getAllTeacherObjects()); return
	 * "AddClasses"; }
	 * 
	 * // insert new class
	 * 
	 * @PostMapping("/insertClasses") public String insertClasses(@ModelAttribute
	 * Classes classes, Model model) { try { // Add new class details to the
	 * database classesService.insertClasses(classes);
	 * 
	 * // Redirect to the author list or success page return
	 * "redirect:/classes/list"; } catch (Exception e) {
	 * System.out.println(e.getMessage()); return "AddClasses"; }
	 * 
	 * }
	 * 
	 * //Edit a class
	 * 
	 * @GetMapping("/editClasses/{id}") public String
	 * editClasses(@PathVariable(value = "id") int id, Model model) { Classes
	 * classes = classesService.getClassesById(id); if (classes != null) {
	 * model.addAttribute("classModel", classes); model.addAttribute("teachers",
	 * teacherService.getAllTeacherObjects()); } return "EditClasses"; }
	 * 
	 * //update a class
	 * 
	 * @PostMapping("/editClasses/updateClasses") public String
	 * updateClasses(@ModelAttribute Classes classes, Model model) {
	 * classesService.updateClasses(classes); return "redirect:/classes/list"; }
	 * 
	 * //Edit a class
	 * 
	 * @GetMapping("/deleteClasses/{id}") public String
	 * deleteClasses(@PathVariable(value = "id") int id, Model model) {
	 * classesService.deleteClassById(id); return "redirect:/classes/list"; }
	 */
}
