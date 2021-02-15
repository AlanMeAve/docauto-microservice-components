package com.sysview.docauto.microservice.components.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.docauto.microservice.components.dao.LibraryDAO;
import com.sysview.docauto.microservice.components.models.Library;
import com.sysview.docauto.microservice.components.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired LibraryDAO libraryDAO; 
	
	@Override
	public List<Library> getAll() {
		return libraryDAO.getAll();
	}

}
