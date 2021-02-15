package com.sysview.docauto.microservice.components.models;

import java.io.Serializable;

public class Product implements Serializable {

	private String idProduct;
	private String description;
	private String format;

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", description=" + description + ", format=" + format + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
