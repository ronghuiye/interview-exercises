package com.asurint.interview;

public class BaseResponse {

	private boolean isSuccessful = true;
	private Integer status = 200;
	private String message;
	
	public boolean getSuccess() {
		return isSuccessful;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccessful = isSuccess;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
