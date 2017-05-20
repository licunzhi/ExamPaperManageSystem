package com.licunzhi.struts.action;

import java.util.Date;
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
import com.licunzhi.model.User;
import com.licunzhi.service.PaperService;
import com.opensymphony.xwork2.Action;
@Controller
@Scope("prototype")
public class PaperAction extends BaseAction<Paper> implements SessionAware,Action{

	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	@Resource(name="paperService")
	private PaperService paperService;
	
	private Map<String,Object> session ;
	
	/**
	 * �����µ��Ծ� ���ҿ����ظ���� 
	 * ʵ����һ�������п��Բ����޸��Ծ�ı��� 
	 * ���ǲ������������� 
	 * ԭ���Ƕ�ȡ��д���������ʺ�ͬʱ��һ���������
	 * @return
	 */
	public String toNewPaper() {
		//����session
		session.remove("pagelist");
		session.remove("questionlist");
		session.remove("paper");
		Date date = new Date();
		model.setDate(date);
		model.setStatus(1);
		User user = (User) session.get("user");
		model.setUser(user);
		session.put("paper", model);
		//֮�󱣴���Ӧ��ʵ���������
		Integer id = model.getId();
		System.out.println(id);
		if (id != null) {
			paperService.updateEntity(model);
		} else {
			paperService.saveEntity(model);
		}
		return "toAddPaperPage";
	}
	
	
	/**
	 * �Ǿ����Ծ���������
	 * @return
	 */
	public String setPaperDispearStatus(){
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		model = paperService.getPaperEntity(id);
		model.setStatus(3);
		paperService.updateEntity(model);
		return "toChangeIndexPage";
	}
	/**
	 * ����������֮������ʾ�ݸ���Ľ���
	 */
	public String setPaperDispearStatusAndToTempPage(){
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		model = paperService.getPaperEntity(id);
		model.setStatus(3);
		paperService.updateEntity(model);
		return "toGetTempParperListAction";
	}
	/**
	 * �����Ծ�����˵�״̬
	 * 
	 * �ύ���ĵ�ʱ�� ����״̬λ����ϢΪ2
	 */
	public String setPaperCheckStatus(){
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		model = paperService.getPaperEntity(id);
		Date date = new Date();
		model.setDate(date);
		model.setStatus(2);
		paperService.updateEntity(model);
		return "toChangeIndexPage";
	}
	
	/**
	 * �����Ծ��״̬��ϢΪ�ݸ������Ϣλ
	 */
	public String setPaperTempStatus(){
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		model = paperService.getPaperEntity(id);
		model.setStatus(1);//�ݸ������Ϣ״̬λ
		paperService.updateEntity(model);
		return "toChangeIndexPage";
	}
	
	/**
	 * �õ��������Լ��������Ծ�ļ���Ϣ
	 */
	public String getMyAllPaper(){
		session.remove("paperlistcoll");
		User user = (User) session.get("user");
		List<Paper> paperlistcoll = paperService.getPaperEntity(user);
		session.put("paperlistcoll", paperlistcoll);
		return "toMyNewPaperPage";
	}
	/**
	 * �������������ҵĲݸ�ֽ
	 */
	public String getTempAllPaper(){
		User user = (User) session.get("user");
		List<Paper> paperlisttemp = paperService.getTempPaperEntity(user);
		session.put("paperlisttemp", paperlisttemp);
		return "toMyTempPaperPage";
	}
	/**
	 * �鿴�����������Ծ�
	 */
	public String getTrashAllPaper(){
		User user = (User) session.get("user");
		List<Paper> paperlisttrash = paperService.getTrashPaperEntity(user);
		session.put("paperlisttrash", paperlisttrash);
		return "toMyTrashPaperPage";
	}
	/**
	 * �����Ծ��״̬���³����ڲݸ�����
	 */
	public String toRebackTemp(){
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		Paper p = paperService.getPaperEntity(id);
		p.setStatus(1);
		paperService.updateEntity(p);
		return "toMyTrashPageAction";
	}
	/**
	 * ����������ɾ��
	 */
	public String toRemoveTrash(){
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		//����paper��idɾ��paper��ص��κ���Ϣ
		paperService.deletePaperAndChild(id);
		return "toMyTrashPageAction";
	}
	/**
	 * ���ҵ��Ծ��г��ص��ݸ���
	 */
	public String toRebackTempArea(){
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		model = paperService.getPaperEntity(id);
		model.setStatus(1);//�ݸ������Ϣ״̬λ
		paperService.updateEntity(model);
		return "toMyAllPaperAction";
	}
	
	/**
	 * ����ǲݸ����Ȼ������޸ĵĽ������¼ӹ���
	 */
	public String toModifyPaperMethod(){
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		Paper paper = paperService.getPaperEntity(id);
		session.put("paper", paper);
		return "toModifyPaperPageAction";
	}
	
	/**
	 * �����Ծ�֮���Ǳ������ҵ��Ծ����Ϣ�Ľ���
	 */
	public String toTrashAndStayTrashPage(){
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		model = paperService.getPaperEntity(id);
		model.setStatus(3);
		paperService.updateEntity(model);
		return "toRebackMyAllNewAction";
	}
	
	/**
	 * ֱ�ӵ�����Դ�ӡ�Ľ���
	 * ������ԥ
	 */
	public String toPrintPaperNiuBi(){
		//�Ծ��½�
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		Paper paper = paperService.getPaperEntity(id);
		session.put("paper", paper);
		//���洴����ҳ��
		Integer paperid = paper.getId();
		//��ѯ�����е�page�ļ���
		List<Page> pagelist = paperService.getPaperWithAllChild(paperid);
		System.out.println(pagelist);
		session.put("pagelist", pagelist);

		//����page�ļ��ϵķ�ʽ��ѯ��ÿһ����Ҫ��ʾ���⼯��
		List<Questions> questionlist = paperService.getQuestionsByPagelist(pagelist);
		System.out.println(questionlist);
		session.put("questionlist", questionlist);
		return "toShouldPrintPage";
	}

	/**
	 * ֱ�ӵ�����Դ�ӡ�Ľ���
	 * ������ԥ
	 */
	public String toPrintPaperAnswers(){
		//�Ծ��½�
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		Paper paper = paperService.getPaperEntity(id);
		session.put("paper", paper);
		//���洴����ҳ��
		Integer paperid = paper.getId();
		//��ѯ�����е�page�ļ���
		List<Page> pagelist = paperService.getPaperWithAllChild(paperid);
		System.out.println(pagelist);
		session.put("pagelist", pagelist);

		//����page�ļ��ϵķ�ʽ��ѯ��ÿһ����Ҫ��ʾ���⼯��
		List<Questions> questionlist = paperService.getQuestionsByPagelist(pagelist);
		System.out.println(questionlist);
		session.put("questionlist", questionlist);
		return "toShouldPrintAnswer";
	}
	/**
	 * niubi���֮�����һ������Ԥ���Ľ���
	 */
	public String toViewPaperIsOk(){
		//�Ծ��½�
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		Paper paper = paperService.getPaperEntity(id);
		session.put("paper", paper);
		//���洴����ҳ��
		Integer paperid = paper.getId();
		//��ѯ�����е�page�ļ���
		List<Page> pagelist = paperService.getPaperWithAllChild(paperid);
		System.out.println(pagelist);
		session.put("pagelist", pagelist);

		//����page�ļ��ϵķ�ʽ��ѯ��ÿһ����Ҫ��ʾ���⼯��
		List<Questions> questionlist = paperService.getQuestionsByPagelist(pagelist);
		System.out.println(questionlist);
		session.put("questionlist", questionlist);
		return "toShouldPrintPageok";
	}
	
	/**
	 * �����Ծ����˼���
	 */
	public String toSetPaperPast(){
		//�Ծ��½�
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		Paper paper = paperService.getPaperEntity(id);
		paper.setStatus(4);
		paperService.updateEntity(paper);
		return "toMyShouldCheckPaperAction";
	}
	/**
	 * �����Ծ�û��ͨ������
	 */
	public String toSetPaperNotPast(){
		//�Ծ��½�
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		Paper paper = paperService.getPaperEntity(id);
		paper.setStatus(5);
		paperService.updateEntity(paper);
		return "toMyShouldCheckPaperAction";
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session= session;
	}
}
