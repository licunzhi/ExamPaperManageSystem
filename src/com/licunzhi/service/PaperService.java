package com.licunzhi.service;

import java.util.List;

import com.licunzhi.model.Page;
import com.licunzhi.model.Paper;
import com.licunzhi.model.Questions;
import com.licunzhi.model.User;

/**
 * PaperService
 */
public interface PaperService {

	//保存试卷
	public void saveEntity(Paper paper);
	//修改试卷
	public void updateEntity(Paper paper);
	//保存页面
	public void saveEntity(Page page);
	//根据试卷id查询出本章试卷的全部信息
	public List<Page> getPaperWithAllChild(Integer paperid);
	//根据id删除指定的页面
	public void deletePageEntity(Integer id);
	//保存指定问题
	public void saveEntity(Questions questions);
	//根据pageid查询出所有应该显示问题集合
	public List<Questions> getQuestionsByPagelist(List<Page> pagelist);
	//根据id查询出指定的page对象
	public Page getEntity(Integer pid);
	//根据id查询出指定的paper对象
	public Paper getPaperEntity(Integer pid);
	//根据id删除指定的问题对象
	public void deleteQuestionsEntity(Integer quesid);
	//更具id得到问题的对象
	public Questions getQuestionEntity(Integer quesid);
	//得到user创建的paper
	public List<Paper> getPaperEntity(User user);
	//查询草稿信息
	public List<Paper> getTempPaperEntity(User user);
	//查询垃圾箱的相关信息
	public List<Paper> getTrashPaperEntity(User user);
	//彻底清除试卷及其孩子
	public void deletePaperAndChild(Integer id);
	//查询需要审核的试卷的信息
	public List<Paper> getPaperCheckEntity(User u);
	
}
