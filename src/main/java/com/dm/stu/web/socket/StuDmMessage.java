package com.dm.stu.web.socket;

public class StuDmMessage {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StuDmMessage() {
		super();
	}

	public StuDmMessage(String message) {
		this.message = message;
	}
}
