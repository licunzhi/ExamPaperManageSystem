package com.licunzhi.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.stereotype.Service;

import com.licunzhi.dao.BaseDao;
import com.licunzhi.model.Page;
import com.licunzhi.model.Paper;
import com.licunzhi.model.Questions;
import com.licunzhi.model.User;
import com.licunzhi.service.PaperService;

/**
 * PaperService实现
 */
@Service("paperService")
public class PaperServiceImpl implements PaperService {

	@Resource(name="paperDao")
	private BaseDao<Paper> paperDao ;
	
	@Resource(name="pageDao")
	private BaseDao<Page> pageDao ;
	
	@Resource(name="questionsDao")
	private BaseDao<Questions> questionDao ;
	/**
	 * 保存试卷
	 */
	@Override
	public void saveEntity(Paper paper) {
		// TODO Auto-generated method stub
		paperDao.saveEntity(paper);;
	}
	/**
	 * 更新试卷的信息
	 */
	@Override
	public void updateEntity(Paper paper) {
		// TODO Auto-generated method stub
		paperDao.updateEntity(paper);
	}
	/**
	 * 保存页面
	 */
	@Override
	public void saveEntity(Page page){
			pageDao.saveEntity(page);
		}
	/**
	 * 根据试卷id查询出本章试卷的全部信息
	 */
	@Override
	public List<Page> getPaperWithAllChild(Integer paperid) {
		// TODO Auto-generated method stub
		Paper paper = paperDao.getEntity(paperid);
		String hql = "From Page p where p.paper.id = ? order by p.pageid";
		return pageDao.findEntityByHQL(hql, paperid);
	}
	/**
	 * 根据id删除指定的页面 
	 * 
	 * 顺带删除页面连襟的问题
	 */
	@Override
	public void deletePageEntity(Integer id) {
		// TODO Auto-generated method stub
		Page p = pageDao.getEntity(id);
		String hql = "delete Questions q where q.page.id = ?";
		questionDao.batchEntityByHQL(hql, id);
		pageDao.deleteEntity(p);
	}
	/**
	 * 保存问题
	 */
	@Override
	public void saveEntity(Questions questions) {
		// TODO Auto-generated method stub
		questionDao.saveEntity(questions);
	}
	/**
	 * 根据pageid查询出应该显示的所有的问题的集合  并且按照一定顺序进行排列
	 */
	@Override
	public List<Questions> getQuestionsByPagelist(List<Page> pagelist) {
		List<Questions> questionlist = new ArrayList<>();
		String hql = "From Questions q where q.page.id = ? order by q.id";
		for(Page p : pagelist){
			//每次查询都批量添加了很多的对象
			System.out.println(p.getId());
			questionlist.addAll(questionDao.findEntityByHQL(hql, p.getId()));
		}
		return questionlist;
	}
	/**
	 * 根据id查询出指定的page对象
	 */
	@Override
	public Page getEntity(Integer pid) {
		return pageDao.getEntity(pid);
	}
	/**
	 * 删除页面中的问题的对象
	 */
	@Override
	public void deleteQuestionsEntity(Integer quesid) {
		Questions q = questionDao.getEntity(quesid);
		questionDao.deleteEntity(q);
	}
	/**
	 * 得到问题的对象
	 */
	@Override
	public Questions getQuestionEntity(Integer quesid) {
		return questionDao.getEntity(quesid);
	}
	/**
	 * 得到paper对象
	 */
	@Override
	public Paper getPaperEntity(Integer pid) {
		// TODO Auto-generated method stub
		return paperDao.getEntity(pid);
	}
	
	/**
	 * 得到用户创建的paper
	 */
	@Override
	public List<Paper> getPaperEntity(User user) {
		Integer uid = user.getId();
		String hql = "From Paper p where p.user.id = ? and (p.status=2 or p.status=4 or p.status=5) order by p.date desc";
		List<Paper> palist = paperDao.findEntityByHQL(hql, uid);
		return palist;
	}
	/**
	 * 根据用户查询草稿信息
	 */
	@Override
	public List<Paper> getTempPaperEntity(User user) {
		Integer uid = user.getId();
		String hql = "From Paper p where p.user.id = ? and p.status=1 order by p.date desc";
		List<Paper> palist = paperDao.findEntityByHQL(hql, uid);
		return palist;
	}
	/**
	 * 查询垃圾箱中的所有试卷的信息
	 */
	@Override
	public List<Paper> getTrashPaperEntity(User user) {
		Integer uid = user.getId();
		String hql = "From Paper p where p.user.id = ? and p.status=3 order by p.date desc";
		List<Paper> palist = paperDao.findEntityByHQL(hql, uid);
		return palist;
	}
	/**
	 * 清除试卷及其孩子
	 * 
	 * 循环便利各个页面   以及各个页面的问题 
	 * 最后把他们呢全部删除吊
	 */
	@Override
	public void deletePaperAndChild(Integer id) {
		Paper paper = paperDao.getEntity(id);
		paperDao.deleteEntity(paper);
		String hql = "From Page p where p.paper.id =?";
		List<Page> ppagelist = pageDao.findEntityByHQL(hql, id);
		for(Page page : ppagelist){
			this.deletePageEntity(page.getId());
		}
	}
	/**
	 * 查询出需要审核的试卷的信息
	 */
	@Override
	public List<Paper> getPaperCheckEntity(User u) {
		Integer uid = u.getId();
		String hql = "From Paper p where p.user.id = ? and p.status=2 order by p.date desc";
		List<Paper> palist = paperDao.findEntityByHQL(hql, uid);
		return palist;
	}


	
}
