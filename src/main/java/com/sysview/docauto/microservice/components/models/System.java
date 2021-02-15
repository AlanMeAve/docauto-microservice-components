package com.sysview.docauto.microservice.components.models;

import java.io.Serializable;

public class System implements Serializable {

	private String idSystem;
	private Platform platform;

	public System() {}
	
	public System(String idSystem) {
		super();
		this.idSystem = idSystem;
	}

	public String getIdSystem() {
		return idSystem;
	}

	public void setIdSystem(String idSystem) {
		this.idSystem = idSystem;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	@Override
	public String toString() {
		return "System [idSystem=" + idSystem + ", platform=" + platform + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
