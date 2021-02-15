package com.sysview.docauto.microservice.components.service.impl;

import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.docauto.microservice.components.dao.QueryDAO;
import com.sysview.docauto.microservice.components.models.Class;
import com.sysview.docauto.microservice.components.models.Library;
import com.sysview.docauto.microservice.components.models.Platform;
import com.sysview.docauto.microservice.components.models.Query;
import com.sysview.docauto.microservice.components.models.System;
import com.sysview.docauto.microservice.components.service.QueryService;

@Service
public class QueryServiceImpl implements QueryService {

	@Autowired QueryDAO queryDAO;

	@Override
	public List<System> getSystemsByPlatform(Platform platform) {
		return queryDAO.getSystemsByPlatform(platform);
	}

	@Override
	public List<Class> getClasessBySystem(System system) {
		return queryDAO.getClasessBySystem(system);
	}

	@Override
	public List<Library> getLibrariesByClass(Class clazz) {
		return queryDAO.getLibrariesByClass(clazz);
	}

	@Override
	public List<Query> getAllFiltered(Query query) {
		return queryDAO.getAllFiltered(query);
	}

	@Override
	public Map<String, Object> getDetailComponent(String component) {
		Map<String, Object> response = new HashMap<>();
		response.put("component", queryDAO.getComponentByName(component));
		response.put("detail", queryDAO.getComponentDetailByName(component));
		return response;
	}

	@Override
	public Blob getFileComponent(Query query) {
		return queryDAO.getFileComponent(query);
	} 

}
