package com.hlej.hsh.base.service;

import com.hlej.hsh.base.common.BaseReturnCode;

public class BaseResult<T> {
	private String returnCode =BaseReturnCode.SUCCESS;
	private String returnMsg;
	public BaseResult() {
		super(); 
	}
	public BaseResult(String returnCode, String returnMsg) {
		super();
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
	}

	private T data;

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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
