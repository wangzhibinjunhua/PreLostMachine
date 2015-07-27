package com.prelostmachine.utils.pojo;

public class GoodsBean {

	String name;
	boolean istick;// ÊÇ·ñ´ò¹´

	public GoodsBean(String name, boolean istick) {
		this.name = name;
		this.istick = istick;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isIstick() {
		return istick;
	}

	public void setIstick(boolean istick) {
		this.istick = istick;
	}

}
