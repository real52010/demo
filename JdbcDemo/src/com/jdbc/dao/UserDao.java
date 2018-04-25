package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.jdbc.entity.User;
import com.jdbc.util.ConnectionUtil;

public class UserDao {
	/**
	 * 
	 * 插入数据（根据JavaBean的内容插入；所以要导入Dao类） 方法名：saveDao<BR>
	 * 创建人：ITDragon <BR>
	 * 时间：2015年2月6日-下午8:33:09 <BR>
	 * 
	 * @param dao
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static boolean saveDao(User user) {
		String sql = "insert into jdbc_user(name,password) values(?,?)";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, user.getName());
			pStatement.setString(2, user.getPassword());
			int count = pStatement.executeUpdate();
			return count > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			ConnectionUtil.closePreparedStatement(pStatement);
			ConnectionUtil.closeConnection(connection);
		}
	}

	/**
	 * 
	 * 查询数据 方法名：findDaos<BR>
	 * 创建人：ITDragon <BR>
	 * 时间：2015年2月6日-下午8:55:05 <BR>
	 * 
	 * @return List<Dao><BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static List<User> findUsers() {
		String sql = "select * from jdbc_user";
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		List<User> users = null;
		try {
			connection = ConnectionUtil.getConnection();
			pStatement = connection.prepareStatement(sql);
			rs = pStatement.executeQuery();
			users = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionUtil.closeResultSet(rs);
			ConnectionUtil.closePreparedStatement(pStatement);
			ConnectionUtil.closeConnection(connection);
		}
	}

	/**
	 * 
	 * 根据主键id删除 方法名：deleteUser<BR>
	 * 创建人：ITDragon <BR>
	 * 时间：2015年2月6日-下午9:03:55 <BR>
	 * 
	 * @param id
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static boolean deleteUser(Integer id) {
		String sql = "delete from jdbc_user where id = ?";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			int count = pStatement.executeUpdate();
			return count > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			ConnectionUtil.closePreparedStatement(pStatement);
			ConnectionUtil.closeConnection(connection);
		}
	}

	/**
	 * 
	 * 根据主键id修改数据 方法名：updateUser<BR>
	 * 创建人：ITDragon <BR>
	 * 时间：2015年2月6日-下午9:17:03 <BR>
	 * 
	 * @param name
	 * @param password
	 * @param id
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static boolean updateUser(String name, String password, Integer id) {
		// name 和 password之间只能用 ","隔开
		String sql = "update jdbc_user set name = ? , password = ?  where id = ?";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, name);
			pStatement.setString(2, password);
			pStatement.setInt(3, id);
			int count = pStatement.executeUpdate();
			return count > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			ConnectionUtil.closePreparedStatement(pStatement);
			ConnectionUtil.closeConnection(connection);
		}
	}

	public static void updateBusBankcard() {
		int start=0;
		String sql = "select * from t_bus_bankcard limit ?,500";
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		List<User> users = null;
		try {
			connection = ConnectionUtil.getConnection();
			pStatement = connection.prepareStatement(sql);
			rs = pStatement.executeQuery();
			users = new ArrayList<User>();
			while (rs.next()) {
//				User user = new User();
//				user.setId(rs.getInt("id"));
//				user.setName(rs.getString("name"));
//				user.setPassword(rs.getString("password"));
//				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeResultSet(rs);
			ConnectionUtil.closePreparedStatement(pStatement);
			ConnectionUtil.closeConnection(connection);
		}
	
	}

	public static void updateBusPerson() {

	}

	public static void updateBusUser() {

	}
}
