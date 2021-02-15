package com.sysview.docauto.microservice.components.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysview.docauto.microservice.components.service.ClassService;

@RestController
@RequestMapping("/class")
public class ClassController {
	
	@Autowired ClassService classService;
	
	@GetMapping("/getAll")
	public ResponseEntity<Object> getAll(){
		try {
			return ResponseEntity.ok(classService.getAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
