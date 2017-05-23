package com.dm.stu.model;

public class ResponseData {
	private int status;
	private String msg;
	private Object data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ResponseData() {
		this.status = 0;
	}

	public ResponseData(int status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	public ResponseData(Object data) {
		super();
		this.status = 0;
		this.data = data;
	}

	public ResponseData(int status, String msg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

}
