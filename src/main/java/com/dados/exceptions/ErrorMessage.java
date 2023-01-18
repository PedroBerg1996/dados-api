package com.dados.exceptions;

import java.util.Date;

public class ErrorMessage {

	private Date timestamp;
	private int statusCode;
	private String error;
	private String message;
	private String path;

	public ErrorMessage(Date timestamp, int statusCode, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.statusCode = statusCode;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
