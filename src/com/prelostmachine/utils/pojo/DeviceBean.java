package com.prelostmachine.utils.pojo;

public class DeviceBean {

	int resource;//ͼƬ��Դ
	String name;//�豸��
	boolean isbind;//�Ƿ��

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
