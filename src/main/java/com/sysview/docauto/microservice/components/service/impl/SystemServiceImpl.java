package com.sysview.docauto.microservice.components.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.docauto.microservice.components.dao.SystemDAO;
import com.sysview.docauto.microservice.components.models.System;
import com.sysview.docauto.microservice.components.service.SystemService;

@Service
public class SystemServiceImpl implements SystemService {

	@Autowired SystemDAO systemDAO; 
	
	@Override
	public List<System> getAll() {
		return systemDAO.getAll();
	}

}
