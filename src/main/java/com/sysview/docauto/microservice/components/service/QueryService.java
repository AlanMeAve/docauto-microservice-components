package com.sysview.docauto.microservice.components.service;

import java.sql.Blob;
import java.util.List;
import java.util.Map;

import com.sysview.docauto.microservice.components.models.Class;
import com.sysview.docauto.microservice.components.models.Library;
import com.sysview.docauto.microservice.components.models.Platform;
import com.sysview.docauto.microservice.components.models.Query;
import com.sysview.docauto.microservice.components.models.System;

public interface QueryService {

	List<System> getSystemsByPlatform(Platform platform);
	
	List<Class> getClasessBySystem(System system);
	
	List<Library> getLibrariesByClass(Class clazz);
	
	List<Query> getAllFiltered(Query query);
	
	Map<String, Object> getDetailComponent(String component);
	
	Blob getFileComponent(Query query);

}
