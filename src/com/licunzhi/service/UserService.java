package com.licunzhi.service;

import java.util.List;

import com.licunzhi.model.User;

/**
 * UserService
 */
public interface UserService extends BaseService<User> {

	//�ж��û��Ľ�ְ���ĺ����ǲ���Ψһ��
	boolean isOnlyUserid(String userid);
	//�ж�ͨ�������ְ���ź������ܲ��ܵõ���Ӧ����Ϣ
	public User getUser(String userid, String password);
	//ͨ��admin��id�õ����е��û���id
	public List<User> finAllUserEntity(Integer id);

}
