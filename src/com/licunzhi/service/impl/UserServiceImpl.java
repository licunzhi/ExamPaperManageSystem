package com.licunzhi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.licunzhi.dao.BaseDao;
import com.licunzhi.model.User;
import com.licunzhi.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    /**
     * ��д�÷���,Ŀ����Ϊ�˸��ǳ����и÷�����ע��,ָ��ע��ָ����Dao����,����spring �޷�ȷ��ע���ĸ�Dao---���ĸ�����������Dao.
     */
    @Resource(name = "userDao")
    public void setDao(BaseDao<User> dao) {
        super.setDao(dao);
    }

    //�жϼ���Ľ�ְ���ĺ����ǲ���Ψһ��
    @Override
    public boolean isOnlyUserid(String userid) {
        // TODO Auto-generated method stub
        String hql = "from User u where u.userid = ?";
        User u = (User) this.uniqueResult(hql, userid);
        System.out.println(u);
        if (u == null) {
            return true;
        }
        return false;
    }

    @Override
    public User getUser(String userid, String password) {
        String hql = "From User u where u.userid = ? and u.password = ?";
        return (User) this.uniqueResult(hql, userid, password);
    }

    /**
     * ����admin��id�õ���������id���û�
     */
    @Override
    public List<User> finAllUserEntity(Integer id) {
        String hql = "From User u where u.admin.id = ?";
        List<User> ulist = this.findEntityByHQL(hql, id);
        return ulist;
    }

}
