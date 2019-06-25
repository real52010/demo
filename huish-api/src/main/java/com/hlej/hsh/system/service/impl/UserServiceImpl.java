package com.hlej.hsh.system.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlej.hsh.base.service.BaseResult;
import com.hlej.hsh.system.common.ReturnCode;
import com.hlej.hsh.system.dao.UserDao;
import com.hlej.hsh.system.dao.entity.UserInfo;
import com.hlej.hsh.system.service.UserService;
import com.hlej.hsh.system.service.pojo.UserInfoPojo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public BaseResult registerUser(UserInfoPojo user) {
		BaseResult result = new BaseResult<String>();
		List<UserInfo> userinfoList = userDao.getUserInfoByPhoneNumber(user.getPhoneNumber());
		if (userinfoList.size() > 0) {
			return new BaseResult<String>(ReturnCode.S_USER_ISEXIST, "电话号码已注册");
		}
		UserInfo info = new UserInfo();
		BeanUtils.copyProperties(user, info);
		int resultsize = userDao.saveUserInfo(info);

		if (resultsize >= 1) {
			return new BaseResult<String>();
		}
		return new BaseResult<String>(ReturnCode.DB_ERROR, "保存用户注册信息发生异常");
	}

	@Override
	public BaseResult UserLogin(UserInfoPojo user) {

		BaseResult result = new BaseResult<UserInfoPojo>();

		BaseResult returnUser = new BaseResult<UserInfoPojo>();
		List<UserInfo> userinfoList = userDao.getUserInfoByPhoneNumber(user.getPhoneNumber());
		if (userinfoList.size() <=0) {
			return new BaseResult<String>(ReturnCode.S_USER_ISNOTEXIST, "该用户不存在");
		}

		UserInfo dbser = userinfoList.get(0);
		if (!dbser.getPassword().equals(user.getPassword())) {
			return new BaseResult<String>(ReturnCode.S_USER_PASSWORDERROR, "用户密码不正确");
		}
		return result;
	}

	@Override
	public BaseResult getUserInfo(UserInfoPojo user) {

		BaseResult result = new BaseResult<UserInfoPojo>();

		BaseResult returnUser = new BaseResult<UserInfoPojo>();
		List<UserInfo> userinfoList = userDao.getUserInfoByPhoneNumber(user.getPhoneNumber());
		if (userinfoList.size() < 0) {
			return new BaseResult<String>(ReturnCode.S_USER_ISNOTEXIST, "该用户不存在");
		}

		UserInfo dbser = userinfoList.get(0);

		BeanUtils.copyProperties(dbser, returnUser);
		result.setData(returnUser);
		return result;

	}

}
