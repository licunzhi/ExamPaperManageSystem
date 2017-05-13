package com.licunzhi.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 所有的问题的集合
 * @author LiCunzhi
 *
 */
public class Page {
	private Integer id;
	private Integer pageid;
	private String qtype;
	private Paper paper;//多对一的链接
	
	
	public Page() {
		// TODO Auto-generated constructor stub
	}
	public Page(Integer id,Integer pageid, String qtype, Paper paper) {
		super();
		this.id = id;
		this.pageid = pageid;
		this.qtype = qtype;
		this.paper = paper;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setPageid(Integer pageid) {
		this.pageid = pageid;
	}
	public Integer getPageid() {
		return pageid;
	}
	public String getQtype() {
		return qtype;
	}
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	@Override
	public String toString() {
		return "Page [id=" + id + ", qtype=" + qtype + ", paper=" + paper + "]";
	}
}
