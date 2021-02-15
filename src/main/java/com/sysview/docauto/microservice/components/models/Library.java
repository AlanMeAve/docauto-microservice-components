package com.sysview.docauto.microservice.components.models;

import java.io.Serializable;

public class Library implements Serializable {

	private String idLibrary;
	private Platform platform;
	private System system;

	public Library() {}
	
	public Library(String idLibrary) {
		super();
		this.idLibrary = idLibrary;
	}

	public String getIdLibrary() {
		return idLibrary;
	}

	public void setIdLibrary(String idLibrary) {
		this.idLibrary = idLibrary;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public System getSystem() {
		return system;
	}

	public void setSystem(System system) {
		this.system = system;
	}

	@Override
	public String toString() {
		return "Library [idLibrary=" + idLibrary + ", platform=" + platform + ", system=" + system + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
