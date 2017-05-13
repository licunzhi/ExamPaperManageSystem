package com.licunzhi.service;

import java.util.List;

import com.licunzhi.model.User;

/**
 * UserService
 */
public interface UserService extends BaseService<User> {

	//判断用户的教职工的号码是不是唯一的
	boolean isOnlyUserid(String userid);
	//判断通过输入的职工号和密码能不能得到相应的信息
	public User getUser(String userid, String password);
	//通过admin的id得到所有的用户的id
	public List<User> finAllUserEntity(Integer id);

}
