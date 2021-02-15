package com.sysview.docauto.microservice.components.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.docauto.microservice.components.dao.PlatformDAO;
import com.sysview.docauto.microservice.components.models.Platform;
import com.sysview.docauto.microservice.components.service.PlatformService;

@Service
public class PlatfformServiceImpl implements PlatformService {

	@Autowired PlatformDAO platformDAO; 
	
	@Override
	public List<Platform> getAll() {
		return platformDAO.getAll();
	}

}
