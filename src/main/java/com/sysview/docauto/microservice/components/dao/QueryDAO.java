package com.sysview.docauto.microservice.components.dao;

import java.sql.Blob;
import java.util.List;

import com.sysview.docauto.microservice.components.models.Library;
import com.sysview.docauto.microservice.components.models.Platform;
import com.sysview.docauto.microservice.components.models.Query;
import com.sysview.docauto.microservice.components.models.System;
import com.sysview.docauto.microservice.components.models.Class;

public interface QueryDAO {

	List<System> getSystemsByPlatform(Platform platform);
	
	List<Class> getClasessBySystem(System system);
	
	List<Library> getLibrariesByClass(Class clazz);

	List<Query> getAllFiltered(Query query);

	Query getComponentByName(String component);

	List<Query> getComponentDetailByName(String component);

	Blob getFileComponent(Query query);

}
