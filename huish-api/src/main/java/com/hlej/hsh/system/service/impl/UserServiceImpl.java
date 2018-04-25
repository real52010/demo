package com.hlej.hsh.system.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlej.hsh.system.dao.UserDao;
import com.hlej.hsh.system.entity.User;
import com.hlej.hsh.system.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void saveUser(User user){
		userDao.insert(user);
	}
}
