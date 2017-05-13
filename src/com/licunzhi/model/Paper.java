package com.licunzhi.model;

import java.util.Date;
/**
 * �½��Ծ���Ϣ����
 * @author LiCunzhi
 *
 */
public class Paper {
	private Integer id;
	private String title;
	private Date date;//�����Ծ��ʱ��
	private User user;//һ���û����Դ�������Ծ����Ϣ
	

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
