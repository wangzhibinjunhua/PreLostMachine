package com.prelostmachine.utils.pojo;

public class DeviceBean {

	int resource;//图片资源
	String name;//设备名
	boolean isbind;//是否绑定

	public DeviceBean(int resource,String name,boolean isbind){
		this.resource = resource;
		this.name = name;
		this.isbind = isbind;
	}
	
	public int getResource() {
		return resource;
	}

	public void setResource(int resource) {
		this.resource = resource;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isIsbind() {
		return isbind;
	}

	public void setIsbind(boolean isbind) {
		this.isbind = isbind;
	}

}
