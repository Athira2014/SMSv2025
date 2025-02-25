package com.athira.demo.common;

import org.springframework.stereotype.Component;

@Component
public class APIResponse {
	
	//instance variable
	private Integer status;
	private Object data;
	private Object error;
	
	public APIResponse() {
	}

	public APIResponse(Integer status, Object data, Object error) {
		super();
		this.status = status;
		this.data = data;
		this.error = error;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}
	
}