package com.licunzhi.service;

import com.licunzhi.model.Admin;

/**
 * AdminService
 */
public interface AdminService extends BaseService<Admin> {

	public Admin validateUser(String nameid, String password);

}
