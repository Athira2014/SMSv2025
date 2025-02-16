package com.athira.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Integer id;

	@Column(nullable = false, length = 30)
	private String className;

	@Column(nullable = false, length = 30)
	private String methodName;

	@Column(nullable = false, length = 300)
	private String errorMessage;

	@Column(nullable = false, length = 1000)
	private String stackTrace;

	public Log() {

	}

	public Log(String className, String methodName, String errorMessage, String stackTrace) {
		super();
		this.className = className;
		this.methodName = methodName;
		this.errorMessage = errorMessage;
		this.stackTrace = stackTrace;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

}
