package com.jdbc.test;

import java.util.List;

import org.junit.Test;

import com.jdbc.dao.UserDao;
import com.jdbc.entity.User;

/**
 * ����User��crud
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
		user.setPassword("����˵����̫�����׼ǵ�");
		boolean flag = UserDao.saveDao(user);
		if (flag) {
			System.out.println(user.getName()+"����ɹ�");
		} else {
			System.out.println("����ʧ��");
		}
	}
	
	@Test
	public void updateUserTest(){
		boolean flag = UserDao.updateUser("NewITDragon", "����˵����", 1);
		if (flag) {
			System.out.println("���³ɹ�");
		} else {
			System.out.println("����ʧ��");
		}
	}
	
	@Test
	public void deleteUserTest(){
		boolean flag = UserDao.deleteUser(1);
		if (flag) {
			System.out.println("ɾ���ɹ�");
		} else {
			System.out.println("ɾ��ʧ��");
		}
	}

}
