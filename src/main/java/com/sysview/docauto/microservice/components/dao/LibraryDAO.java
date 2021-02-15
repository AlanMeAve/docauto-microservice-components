package com.sysview.docauto.microservice.components.dao;

import java.util.List;

import com.sysview.docauto.microservice.components.models.Library;

public interface LibraryDAO {

	List<Library> getAll();

}
