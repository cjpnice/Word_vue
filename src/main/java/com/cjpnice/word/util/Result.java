package com.cjpnice.word.util;

import java.io.Serializable;

/**
 * @author cjpnice
 */
public class Result implements Serializable {
	//状态,成功：0，失败：1
	private int status;
	//消息
	private String msg;
	//数据
	private Object data;
	//get、set方法
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
	//toString方法
	@Override
	public String toString() {
		return "Result [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}
}
