package com.sysview.docauto.microservice.components.models;

import java.io.Serializable;

public class Class implements Serializable {

	private String idClass;
	private Platform platform;
	private System system;

	public Class() {}
	
	public Class(String idClass) {
		super();
		this.idClass = idClass;
	}

	public String getIdClass() {
		return idClass;
	}

	public void setIdClass(String idClass) {
		this.idClass = idClass;
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
		return "Class [idClass=" + idClass + ", platform=" + platform + ", system=" + system + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
