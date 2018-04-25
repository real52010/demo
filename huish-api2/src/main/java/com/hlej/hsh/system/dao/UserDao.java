package com.hlej.hsh.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.hlej.hsh.base.data.BaseDao;
import com.hlej.hsh.system.dao.entity.UserInfo;

public interface UserDao extends BaseDao<UserInfo> {

	@Select("select * from userinfo where phoneNumber = #{phoneNumber}")
	public List<UserInfo> getUserInfoByPhoneNumber(String phoneNumber);

	@Insert("INSERT into userinfo(userName,phoneNumber,password,address) VALUES(#{userName}, #{phoneNumber}, #{password},#{address})")
	public int saveUserInfo(UserInfo userInfo);
	
	
	

}
