package com.hlej.hsh.system.web.reqmodel;

import com.hlej.hsh.base.web.model.BaseRequest;

/**
 * 登录时的请求参数 
 * @author Administrator
 *
 */
public class RegisterRequest extends BaseRequest{
	private String userName;
	private String phoneNumber;
	private String password;
	private String address;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
