package com.sysview.docauto.microservice.components.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysview.docauto.microservice.components.service.SystemService;

@RestController
@RequestMapping("/system")
public class SystemController {
	
	@Autowired SystemService systemService;
	
	@GetMapping("/getAll")
	public ResponseEntity<Object> getAll(){
		try {
			return ResponseEntity.ok(systemService.getAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
