package com.dm.stu.enums;

public enum IDType {
	USER("U"), FILE("F");

	private String vaule;

	public String getVaule() {
		return vaule;
	}

	private IDType(String value) {
		this.vaule = value;
	}
}
