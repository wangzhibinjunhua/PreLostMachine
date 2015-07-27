package com.prelostmachine.utils.pojo;

public class SearchResultBean {

	String name;
	String address;
	boolean isconnected;

	public SearchResultBean(String name, String address, boolean isconnected) {
		this.name = name;
		this.address = address;
		this.isconnected = isconnected;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isIsconnected() {
		return isconnected;
	}

	public void setIsconnected(boolean isconnected) {
		this.isconnected = isconnected;
	}

}
