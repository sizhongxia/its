package com.dm.stu.model;

public class MapResult {
	private int state = 0;
	private String msg = "";
	private Object data = null;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
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

	public MapResult(int state, String msg) {
		super();
		this.state = state;
		this.msg = msg;
	}

	public MapResult(int state, Object data) {
		super();
		this.state = state;
		this.data = data;
	}

	public MapResult(int state, String msg, Object data) {
		super();
		this.state = state;
		this.msg = msg;
		this.data = data;
	}

}
