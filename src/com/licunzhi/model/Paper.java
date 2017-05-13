package com.licunzhi.model;

import java.util.Date;
/**
 * 新建试卷信息的类
 * @author LiCunzhi
 *
 */
public class Paper {
	private Integer id;
	private String title;
	private Date date;//创建试卷的时间
	private User user;//一个用户可以创建多个试卷的信息
	

	private Integer status;
	
	public Paper(Integer id, String title, Date date, User user,Integer status) {
		this.id = id;
		this.title = title;
		this.date = date;
		this.user = user;
		this.status = status;
	}
	public Paper() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getStatus() {
		return status;
	}
	@Override
	public String toString() {
		return "Paper [id=" + id + ", title=" + title + ", date=" + date + ", user=" + user + "]";
	}
	
}
