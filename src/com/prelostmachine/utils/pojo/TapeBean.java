package com.prelostmachine.utils.pojo;

public class TapeBean {

	String name;
	String date;
	String duration;// Ê±³¤

	public TapeBean(String name, String date, String duration) {
		this.name = name;
		this.date = date;
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}
