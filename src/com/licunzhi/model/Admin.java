package com.licunzhi.model;

public class Admin {
	private Integer id;
	private String name;
	private String password;
	private String nameid;
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public Admin(Integer id, String name, String password, String nameid) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.nameid = nameid;
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
	public String getNameid() {
		return nameid;
	}
	public void setNameid(String nameid) {
		this.nameid = nameid;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password + ", nameid=" + nameid + "]";
	}
	

}
