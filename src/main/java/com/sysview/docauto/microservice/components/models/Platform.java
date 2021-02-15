package com.sysview.docauto.microservice.components.models;

import java.io.Serializable;

public class Platform implements Serializable {

	private String idPlatform;

	public Platform() {}
	
	public Platform(String idPlatform) {
		super();
		this.idPlatform = idPlatform;
	}

	public String getIdPlatform() {
		return idPlatform;
	}

	public void setIdPlatform(String idPlatform) {
		this.idPlatform = idPlatform;
	}

	@Override
	public String toString() {
		return "Platform [idPlatform=" + idPlatform + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
