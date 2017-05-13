package com.licunzhi.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.licunzhi.dao.BaseDao;
import com.licunzhi.model.Admin;
import com.licunzhi.service.AdminService;

@Service("adminService")
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {

	@Resource(name = "adminDao")
	public void setDao(BaseDao<Admin> dao) {
		super.setDao(dao);
	}

	/**
	 * 查询满足登陆条件的用户信息  
	 * 返回实现的对象
	 */
	@Override
	public Admin validateUser(String nameid, String password) {
		String hql = "From Admin a Where a.nameid = ? and a.password = ?";
		Admin admin = (Admin) this.uniqueResult(hql, nameid,password);
		return admin;
	}

}
