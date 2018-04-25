package com.jdbc.entity;

/**
 * �û�ʵ���� ������� get / set �����Ƚ����࣬���Կ���ʹ��lombok
 * 
 * @author ITDragon
 * 
 */
public class User implements java.io.Serializable {
	
	/**
	 * ��һ����ʵ�������л�
	 * �ڶ�������������
	 * ������������get/set����
	 * ���Ĳ������������������Ĺ��췽��
	 * ���岽������toString()���㿴���
	 */

	private Integer id; // �û�id
	private String name; // �û���
	private String password; // �û�����

	public User() {
	}

	public User(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ "]";
	}

}
