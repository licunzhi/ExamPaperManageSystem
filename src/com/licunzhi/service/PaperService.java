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

	//�����Ծ�
	public void saveEntity(Paper paper);
	//�޸��Ծ�
	public void updateEntity(Paper paper);
	//����ҳ��
	public void saveEntity(Page page);
	//�����Ծ�id��ѯ�������Ծ��ȫ����Ϣ
	public List<Page> getPaperWithAllChild(Integer paperid);
	//����idɾ��ָ����ҳ��
	public void deletePageEntity(Integer id);
	//����ָ������
	public void saveEntity(Questions questions);
	//����pageid��ѯ������Ӧ����ʾ���⼯��
	public List<Questions> getQuestionsByPagelist(List<Page> pagelist);
	//����id��ѯ��ָ����page����
	public Page getEntity(Integer pid);
	//����id��ѯ��ָ����paper����
	public Paper getPaperEntity(Integer pid);
	//����idɾ��ָ�����������
	public void deleteQuestionsEntity(Integer quesid);
	//����id�õ�����Ķ���
	public Questions getQuestionEntity(Integer quesid);
	//�õ�user������paper
	public List<Paper> getPaperEntity(User user);
	//��ѯ�ݸ���Ϣ
	public List<Paper> getTempPaperEntity(User user);
	//��ѯ������������Ϣ
	public List<Paper> getTrashPaperEntity(User user);
	//��������Ծ��亢��
	public void deletePaperAndChild(Integer id);
	//��ѯ��Ҫ��˵��Ծ����Ϣ
	public List<Paper> getPaperCheckEntity(User u);
	
}
