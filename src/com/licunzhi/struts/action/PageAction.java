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
	 * ����һ���µ�ҳ��
	 * */
	public String toNewPage(){
		//���洴����ҳ��
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
	 * ɾ��ָ����ӵ�ҳ��
	 */
	public String doDeletePage(){
		Integer id = Integer.valueOf((request.getParameter("id")));
		paperService.deletePageEntity(id);
		return "toAddPageAction";
	}
	
	/**
	 * ��Ϊ�м����ת  ��Ҫ�Ǹ��»����е��Ѿ���ѯ����pagelist
	 * 
	 * ��Ϊ��ת����Ҫ��ѯ����Ӧ��ҳ��֮�а�������Ŀ����Ϣ
	 */
	public String doFlushPageSession(){
		//���洴����ҳ��
		Paper paper = (Paper) session.get("paper");
		Integer paperid = paper.getId();
		//��ѯ�����е�page�ļ���
		List<Page> pagelist = paperService.getPaperWithAllChild(paperid);
		System.out.println(pagelist);
		session.put("pagelist", pagelist);
		
		//����page�ļ��ϵķ�ʽ��ѯ��ÿһ����Ҫ��ʾ���⼯��
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
