package com.hlej.hsh.system.service;

import com.hlej.hsh.base.service.BaseResult;
import com.hlej.hsh.system.service.pojo.UserInfoPojo;

public interface UserService {
	public BaseResult<String> registerUser(UserInfoPojo user);
	/**
	 * 业务方法5个参数以上可使用对象传参数 ，参数列表的方式，便于理解
	 * @param phoneNumber
	 * @param password
	 */
	public BaseResult<String> UserLogin(UserInfoPojo user);
	public BaseResult<UserInfoPojo> getUserInfo(UserInfoPojo user);
}
