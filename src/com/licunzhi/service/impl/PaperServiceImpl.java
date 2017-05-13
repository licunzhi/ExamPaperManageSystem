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
 * PaperServiceʵ��
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
	 * �����Ծ�
	 */
	@Override
	public void saveEntity(Paper paper) {
		// TODO Auto-generated method stub
		paperDao.saveEntity(paper);;
	}
	/**
	 * �����Ծ����Ϣ
	 */
	@Override
	public void updateEntity(Paper paper) {
		// TODO Auto-generated method stub
		paperDao.updateEntity(paper);
	}
	/**
	 * ����ҳ��
	 */
	@Override
	public void saveEntity(Page page){
			pageDao.saveEntity(page);
		}
	/**
	 * �����Ծ�id��ѯ�������Ծ��ȫ����Ϣ
	 */
	@Override
	public List<Page> getPaperWithAllChild(Integer paperid) {
		// TODO Auto-generated method stub
		Paper paper = paperDao.getEntity(paperid);
		String hql = "From Page p where p.paper.id = ? order by p.pageid";
		return pageDao.findEntityByHQL(hql, paperid);
	}
	/**
	 * ����idɾ��ָ����ҳ�� 
	 * 
	 * ˳��ɾ��ҳ�����������
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
	 * ��������
	 */
	@Override
	public void saveEntity(Questions questions) {
		// TODO Auto-generated method stub
		questionDao.saveEntity(questions);
	}
	/**
	 * ����pageid��ѯ��Ӧ����ʾ�����е�����ļ���  ���Ұ���һ��˳���������
	 */
	@Override
	public List<Questions> getQuestionsByPagelist(List<Page> pagelist) {
		List<Questions> questionlist = new ArrayList<>();
		String hql = "From Questions q where q.page.id = ? order by q.id";
		for(Page p : pagelist){
			//ÿ�β�ѯ����������˺ܶ�Ķ���
			System.out.println(p.getId());
			questionlist.addAll(questionDao.findEntityByHQL(hql, p.getId()));
		}
		return questionlist;
	}
	/**
	 * ����id��ѯ��ָ����page����
	 */
	@Override
	public Page getEntity(Integer pid) {
		return pageDao.getEntity(pid);
	}
	/**
	 * ɾ��ҳ���е�����Ķ���
	 */
	@Override
	public void deleteQuestionsEntity(Integer quesid) {
		Questions q = questionDao.getEntity(quesid);
		questionDao.deleteEntity(q);
	}
	/**
	 * �õ�����Ķ���
	 */
	@Override
	public Questions getQuestionEntity(Integer quesid) {
		return questionDao.getEntity(quesid);
	}
	/**
	 * �õ�paper����
	 */
	@Override
	public Paper getPaperEntity(Integer pid) {
		// TODO Auto-generated method stub
		return paperDao.getEntity(pid);
	}
	
	/**
	 * �õ��û�������paper
	 */
	@Override
	public List<Paper> getPaperEntity(User user) {
		Integer uid = user.getId();
		String hql = "From Paper p where p.user.id = ? and (p.status=2 or p.status=4 or p.status=5) order by p.date desc";
		List<Paper> palist = paperDao.findEntityByHQL(hql, uid);
		return palist;
	}
	/**
	 * �����û���ѯ�ݸ���Ϣ
	 */
	@Override
	public List<Paper> getTempPaperEntity(User user) {
		Integer uid = user.getId();
		String hql = "From Paper p where p.user.id = ? and p.status=1 order by p.date desc";
		List<Paper> palist = paperDao.findEntityByHQL(hql, uid);
		return palist;
	}
	/**
	 * ��ѯ�������е������Ծ����Ϣ
	 */
	@Override
	public List<Paper> getTrashPaperEntity(User user) {
		Integer uid = user.getId();
		String hql = "From Paper p where p.user.id = ? and p.status=3 order by p.date desc";
		List<Paper> palist = paperDao.findEntityByHQL(hql, uid);
		return palist;
	}
	/**
	 * ����Ծ��亢��
	 * 
	 * ѭ����������ҳ��   �Լ�����ҳ������� 
	 * ����������ȫ��ɾ����
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
	 * ��ѯ����Ҫ��˵��Ծ����Ϣ
	 */
	@Override
	public List<Paper> getPaperCheckEntity(User u) {
		Integer uid = u.getId();
		String hql = "From Paper p where p.user.id = ? and p.status=2 order by p.date desc";
		List<Paper> palist = paperDao.findEntityByHQL(hql, uid);
		return palist;
	}


	
}
