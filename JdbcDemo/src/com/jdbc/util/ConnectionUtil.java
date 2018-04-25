package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * ���ݿ�������
 * @author ITDragon
 *
 */
public class ConnectionUtil {
	
	/**
	 * ��һ������������
	 * �ڶ������������ݿ�
	 * ��������һ��Ҫ�ر���
	 * ���Ĳ��������Ƿ����ӳɹ�
	 */
	
	private static String DRIVER = "com.mysql.jdbc.Driver"; 		// ���ݿ�����
	private static String URL = "jdbc:mysql://localhost:3306/test";	// �������ݿ�·��
	private static String NAME = "root";							// ���ݿ��û���
	private static String PASSWORD = "root";						// ���ݿ�����

	public static Connection getConnection() {
		Connection connection = null;
		try {
			// ��������
			Class.forName(DRIVER);
			// �������ݿ�
			connection = DriverManager.getConnection(URL, NAME, PASSWORD);
			return connection;
		} catch (Exception e) {
			return null;
		}
	}

	// �ر���
	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeStatement(Statement statement) {
		try {
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closePreparedStatement(PreparedStatement pStatement) {
		try {
			pStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeResultSet(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// �������ݿ��Ƿ����ӳɹ�
	public static void main(String[] args) {
		System.out.println(getConnection());
	}

}
