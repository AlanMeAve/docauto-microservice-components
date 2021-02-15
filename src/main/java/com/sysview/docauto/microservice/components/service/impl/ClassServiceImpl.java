package com.sysview.docauto.microservice.components.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.docauto.microservice.components.dao.ClassDAO;
import com.sysview.docauto.microservice.components.models.Class;
import com.sysview.docauto.microservice.components.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService {

	@Autowired ClassDAO classDAO; 
	
	@Override
	public List<Class> getAll() {
		return classDAO.getAll();
	}

}
