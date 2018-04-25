package com.hlej.hsh.base.web.model;

public class BaseResponse {
	private String returnCode="0";
	private String returnMsg;
	public BaseResponse() {
		// TODO Auto-generated constructor stub
	}
	public BaseResponse(String returnCode, String returnMsg) {
		super();
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnMsg() {
		return returnMsg;
	}
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
}
