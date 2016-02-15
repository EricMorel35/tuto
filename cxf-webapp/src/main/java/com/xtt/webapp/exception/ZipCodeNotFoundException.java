package com.xtt.webapp.exception;

public class ZipCodeNotFoundException extends Exception {

	private String zipCode;

	public ZipCodeNotFoundException(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
