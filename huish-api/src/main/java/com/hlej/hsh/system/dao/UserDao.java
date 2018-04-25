package com.hlej.hsh.system.dao;


import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.hlej.hsh.common.BaseDao;
import com.hlej.hsh.system.entity.User;

public interface UserDao extends BaseDao<User>{
	
	@Select("select * from user where state = #{state}")
	public List<User> selectByState(Integer state);
}
