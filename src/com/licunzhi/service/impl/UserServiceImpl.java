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
     * 重写该方法,目的是为了覆盖超类中该方法的注解,指明注入指定的Dao对象,否则spring 无法确定注入哪个Dao---有四个满足条件的Dao.
     */
    @Resource(name = "userDao")
    public void setDao(BaseDao<User> dao) {
        super.setDao(dao);
    }

    //判断加入的教职工的号码是不是唯一的
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
     * 更具admin的id得到所有属于id的用户
     */
    @Override
    public List<User> finAllUserEntity(Integer id) {
        String hql = "From User u where u.admin.id = ?";
        List<User> ulist = this.findEntityByHQL(hql, id);
        return ulist;
    }

}
