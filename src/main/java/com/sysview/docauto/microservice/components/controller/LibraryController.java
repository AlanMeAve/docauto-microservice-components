package com.sysview.docauto.microservice.components.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysview.docauto.microservice.components.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {
	
	@Autowired LibraryService libraryService;
	
	@GetMapping("/getAll")
	public ResponseEntity<Object> getAll(){
		try {
			return ResponseEntity.ok(libraryService.getAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
