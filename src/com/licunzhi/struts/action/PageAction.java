package com.licunzhi.struts.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.licunzhi.model.Page;
import com.licunzhi.model.Paper;
import com.licunzhi.model.Questions;
import com.licunzhi.service.PaperService;
@Controller
@Scope("prototype")
public class PageAction extends BaseAction<Page> implements SessionAware{

	private static final long serialVersionUID = 1L;
	
	@Resource(name="paperService")
	private PaperService paperService;
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	private Map<String,Object> session ;
	
	/*
	 * 创建一个新的页面
	 * */
	public String toNewPage(){
		//保存创建的页面
		Paper paper = (Paper) session.get("paper");
		model.setPaper(paper);
		paperService.saveEntity(model);
		Integer paperid = paper.getId();
		System.out.println(paperid);
		List<Page> pagelist = paperService.getPaperWithAllChild(paperid);
		System.out.println(pagelist);
		session.put("pagelist", pagelist);
		return "toAddPaperPage";
	}
	/**
	 * 删除指定添加的页面
	 */
	public String doDeletePage(){
		Integer id = Integer.valueOf((request.getParameter("id")));
		paperService.deletePageEntity(id);
		return "toAddPageAction";
	}
	
	/**
	 * 作为中间的跳转  主要是更新缓存中的已经查询到的pagelist
	 * 
	 * 作为跳转还需要查询出相应的页面之中包含的题目的信息
	 */
	public String doFlushPageSession(){
		//保存创建的页面
		Paper paper = (Paper) session.get("paper");
		Integer paperid = paper.getId();
		//查询出所有的page的集合
		List<Page> pagelist = paperService.getPaperWithAllChild(paperid);
		System.out.println(pagelist);
		session.put("pagelist", pagelist);
		
		//根据page的集合的方式查询出每一个需要显示问题集合
		List<Questions> questionlist = paperService.getQuestionsByPagelist(pagelist);
		System.out.println(questionlist);
		session.put("questionlist", questionlist);
		
		return "toAddPaperPage";
	}

	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session= session;
	}
}
