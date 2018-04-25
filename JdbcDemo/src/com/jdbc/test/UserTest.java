package com.jdbc.test;

import java.util.List;

import org.junit.Test;

import com.jdbc.dao.UserDao;
import com.jdbc.entity.User;

/**
 * 测试User的crud
 * @author ITDragon
 *
 */
public class UserTest {
	
	@Test
	public void findUserTest(){
		List<User> users= UserDao.findUsers();
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void saveUserTest(){
		User user = new User();
		user.setName("ITDragon");
		user.setPassword("麻麻说密码太长容易记得");
		boolean flag = UserDao.saveDao(user);
		if (flag) {
			System.out.println(user.getName()+"保存成功");
		} else {
			System.out.println("保存失败");
		}
	}
	
	@Test
	public void updateUserTest(){
		boolean flag = UserDao.updateUser("NewITDragon", "麻麻说错了", 1);
		if (flag) {
			System.out.println("更新成功");
		} else {
			System.out.println("更新失败");
		}
	}
	
	@Test
	public void deleteUserTest(){
		boolean flag = UserDao.deleteUser(1);
		if (flag) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}

}
