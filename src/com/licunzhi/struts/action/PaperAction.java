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
	 * 创建新的试卷 并且可以重复点击 
	 * 实现在一个界面中可以不断修改试卷的标题 
	 * 但是不建议这样操作 
	 * 原因是读取和写操作并不适合同时在一个代码段中
	 * @return
	 */
	public String toNewPaper() {
		//净化session
		session.remove("pagelist");
		session.remove("questionlist");
		session.remove("paper");
		Date date = new Date();
		model.setDate(date);
		model.setStatus(1);
		User user = (User) session.get("user");
		model.setUser(user);
		session.put("paper", model);
		//之后保存相应的实体类就行了
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
	 * 那就让试卷丢到垃圾箱
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
	 * 丢到垃圾箱之后还是显示草稿箱的界面
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
	 * 设置试卷处于审核的状态
	 * 
	 * 提交审阅的时候 设置状态位的信息为2
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
	 * 设置试卷的状态信息为草稿箱的信息位
	 */
	public String setPaperTempStatus(){
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		model = paperService.getPaperEntity(id);
		model.setStatus(1);//草稿箱的信息状态位
		paperService.updateEntity(model);
		return "toChangeIndexPage";
	}
	
	/**
	 * 得到属于我自己的所有试卷的简单信息
	 */
	public String getMyAllPaper(){
		session.remove("paperlistcoll");
		User user = (User) session.get("user");
		List<Paper> paperlistcoll = paperService.getPaperEntity(user);
		session.put("paperlistcoll", paperlistcoll);
		return "toMyNewPaperPage";
	}
	/**
	 * 查找所有属于我的草稿纸
	 */
	public String getTempAllPaper(){
		User user = (User) session.get("user");
		List<Paper> paperlisttemp = paperService.getTempPaperEntity(user);
		session.put("paperlisttemp", paperlisttemp);
		return "toMyTempPaperPage";
	}
	/**
	 * 查看垃圾箱的相关试卷
	 */
	public String getTrashAllPaper(){
		User user = (User) session.get("user");
		List<Paper> paperlisttrash = paperService.getTrashPaperEntity(user);
		session.put("paperlisttrash", paperlisttrash);
		return "toMyTrashPaperPage";
	}
	/**
	 * 设置试卷的状态重新出现在草稿箱中
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
	 * 从垃圾像中删除
	 */
	public String toRemoveTrash(){
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		//根据paper的id删除paper相关的任何信息
		paperService.deletePaperAndChild(id);
		return "toMyTrashPageAction";
	}
	/**
	 * 从我的试卷中撤回到草稿箱
	 */
	public String toRebackTempArea(){
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		model = paperService.getPaperEntity(id);
		model.setStatus(1);//草稿箱的信息状态位
		paperService.updateEntity(model);
		return "toMyAllPaperAction";
	}
	
	/**
	 * 真的是草稿箱的然后到添加修改的界面重新加工了
	 */
	public String toModifyPaperMethod(){
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		Paper paper = paperService.getPaperEntity(id);
		session.put("paper", paper);
		return "toModifyPaperPageAction";
	}
	
	/**
	 * 丢弃试卷之后还是保持在我的试卷的信息的界面
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
	 * 直接到达可以打印的界面
	 * 毫不犹豫
	 */
	public String toPrintPaperNiuBi(){
		//试卷章节
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		Paper paper = paperService.getPaperEntity(id);
		session.put("paper", paper);
		//保存创建的页面
		Integer paperid = paper.getId();
		//查询出所有的page的集合
		List<Page> pagelist = paperService.getPaperWithAllChild(paperid);
		System.out.println(pagelist);
		session.put("pagelist", pagelist);

		//根据page的集合的方式查询出每一个需要显示问题集合
		List<Questions> questionlist = paperService.getQuestionsByPagelist(pagelist);
		System.out.println(questionlist);
		session.put("questionlist", questionlist);
		return "toShouldPrintPage";
	}

	/**
	 * 直接到达可以打印的界面
	 * 毫不犹豫
	 */
	public String toPrintPaperAnswers(){
		//试卷章节
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		Paper paper = paperService.getPaperEntity(id);
		session.put("paper", paper);
		//保存创建的页面
		Integer paperid = paper.getId();
		//查询出所有的page的集合
		List<Page> pagelist = paperService.getPaperWithAllChild(paperid);
		System.out.println(pagelist);
		session.put("pagelist", pagelist);

		//根据page的集合的方式查询出每一个需要显示问题集合
		List<Questions> questionlist = paperService.getQuestionsByPagelist(pagelist);
		System.out.println(questionlist);
		session.put("questionlist", questionlist);
		return "toShouldPrintAnswer";
	}
	/**
	 * niubi哄哄之后的另一个可以预览的界面
	 */
	public String toViewPaperIsOk(){
		//试卷章节
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		Paper paper = paperService.getPaperEntity(id);
		session.put("paper", paper);
		//保存创建的页面
		Integer paperid = paper.getId();
		//查询出所有的page的集合
		List<Page> pagelist = paperService.getPaperWithAllChild(paperid);
		System.out.println(pagelist);
		session.put("pagelist", pagelist);

		//根据page的集合的方式查询出每一个需要显示问题集合
		List<Questions> questionlist = paperService.getQuestionsByPagelist(pagelist);
		System.out.println(questionlist);
		session.put("questionlist", questionlist);
		return "toShouldPrintPageok";
	}
	
	/**
	 * 设置试卷经过了检验
	 */
	public String toSetPaperPast(){
		//试卷章节
		String pid = request.getParameter("id");
		Integer id = Integer.valueOf(pid);
		Paper paper = paperService.getPaperEntity(id);
		paper.setStatus(4);
		paperService.updateEntity(paper);
		return "toMyShouldCheckPaperAction";
	}
	/**
	 * 设置试卷没有通过检验
	 */
	public String toSetPaperNotPast(){
		//试卷章节
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
