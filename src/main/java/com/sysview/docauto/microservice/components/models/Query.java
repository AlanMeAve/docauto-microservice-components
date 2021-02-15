package com.sysview.docauto.microservice.components.models;

import java.io.Serializable;

public class Query implements Serializable {

	private Platform platform;
	private System system;
	private Library library;
	private Class clazz;
	private String component;
	private Product product;

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

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
