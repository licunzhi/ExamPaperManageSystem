package com.licunzhi.model;

/**
 * ��ְ���û���
 * @author LiCunzhi
 *
 */
public class User {
	private Integer id;
	private String name;
	private String password;
	private String userid;//��ְ����
	private Admin admin;
	public User(Integer id, String name, String password, String userid,Admin admin) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.userid = userid;
		this.admin = admin;
	}
	public User() {
		// TODO Auto-generated constructor stub
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
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Admin getAdmin() {
		return admin;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", userid=" + userid + ", admin="
				+ admin + "]";
	}

}
