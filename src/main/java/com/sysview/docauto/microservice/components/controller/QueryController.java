package com.sysview.docauto.microservice.components.controller;

import java.sql.Blob;

import javax.activation.MimetypesFileTypeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysview.docauto.microservice.components.models.Class;
import com.sysview.docauto.microservice.components.models.Platform;
import com.sysview.docauto.microservice.components.models.Query;
import com.sysview.docauto.microservice.components.models.System;
import com.sysview.docauto.microservice.components.service.QueryService;

@RestController
@RequestMapping("/query")
public class QueryController {

	@Autowired
	QueryService queryService;

	@GetMapping("/getSystemsByPlatform/{id}")
	public ResponseEntity<Object> getSystemsByPlatform(@PathVariable String id) {
		try {
			return ResponseEntity.ok(queryService.getSystemsByPlatform(new Platform(id)));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/getClasessBySystem/{id}")
	public ResponseEntity<Object> getClasessBySystem(@PathVariable String id) {
		try {
			return ResponseEntity.ok(queryService.getClasessBySystem(new System(id)));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/getLibrariesByClass/{id}")
	public ResponseEntity<Object> getLibrariesByClass(@PathVariable String id) {
		try {
			return ResponseEntity.ok(queryService.getLibrariesByClass(new Class(id)));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/getAllFiltered")
	public ResponseEntity<Object> getAllFiltered(@RequestBody Query query) {
		try {
			return ResponseEntity.ok(queryService.getAllFiltered(query));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/getDetailComponent/{id}")
	public ResponseEntity<Object> getDetailComponent(@PathVariable String id) {
		try {
			return ResponseEntity.ok(queryService.getDetailComponent(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping(path = "/download")
	public ResponseEntity<ByteArrayResource> download(@RequestBody Query query) {
		try {

			Blob blobFile = queryService.getFileComponent(query);
			String format = query.getProduct().getFormat();

			String fileName = query.getComponent() + "." + format.toLowerCase();
			
			String contentType = MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(fileName);

			if (contentType == null)
				contentType = "application/octet-stream";

			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"");
			
			return ResponseEntity.ok().headers(headers).contentLength(blobFile.length())
					.contentType(MediaType.parseMediaType(contentType)).body(new ByteArrayResource(blobFile.getBytes(1, (int) blobFile.length())));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

}
