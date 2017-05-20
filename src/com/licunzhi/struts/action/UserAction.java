package com.licunzhi.struts.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.licunzhi.model.Admin;
import com.licunzhi.model.User;
import com.licunzhi.service.UserService;
import com.opensymphony.xwork2.Action;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> implements SessionAware, Action {

    private static final long serialVersionUID = 1L;

    @Resource(name = "userService")
    private UserService userService;

    private HttpServletRequest request = ServletActionContext.getRequest();
    private Map<String, Object> session;

    //去用户登陆的界面
    public String toUserLogin() {
        session.clear();
        return "toUserLoginPage";
    }

    //增加用户的实际过程
    public String doAddUser() {
        session.remove("erroruserid");
        String userid = model.getUserid();
        String pwd = model.getPassword();
        pwd = pwd.substring(0, pwd.indexOf(","));
        model.setPassword(pwd);
        boolean flag = userService.isOnlyUserid(userid);
        session.put("usertemp", model);
        if (!flag) {//并不满足条件
            session.put("erroruserid", "wrong");
            return "toAddUserAction";
        }
        //满足条件的时候   保存用户信息  关联相关的admin
        Admin admin = (Admin) session.get("admin");
        model.setAdmin(admin);
        userService.saveEntity(model);
        return "toAddUserSuccess";
    }

    //验证登陆的用户是不是符合条件
    public String doCheckUser() {
        String userid = model.getUserid();
        String password = model.getPassword();
        User user = userService.getUser(userid, password);
        if (user == null) {
            return "toUserLoginAction";
        } else {
            System.out.println(user);
            session.put("user", user);
            return "toSysIndextPage";
        }
    }

    //去增加试卷的界面
    public String toAddPaper() {
        session.remove("pagelist");
        session.remove("questionlist");
        session.remove("paper");
        return "toAddPaperPage";
    }

    //删除指定id的User对象
    public String toDeleteUserById() {
        String uid = request.getParameter("id");
        System.out.println(uid);
        Integer id = Integer.valueOf(uid);
        User user = userService.getEntity(id);
        userService.deleteEntity(user);
        return "toMyUserListAction";
    }

    //需要修改指定用户的信息了
    public String toModifyUserInfo() {
        session.remove("uuuser");
        String uuid = request.getParameter("id");
        Integer id = Integer.valueOf(uuid);
        User uuuser = userService.getEntity(id);
        session.put("uuuser", uuuser);
        return "toModifyUserInfoPage";
    }

    //只是简单的更新用户的信息
    public String doJustUpdateUserInfo() {
        String pass = model.getPassword();
        String pwd = pass.substring(0, pass.indexOf(","));
        Admin admin = (Admin) session.get("admin");
        model.setPassword(pwd);
        model.setAdmin(admin);
        userService.updateEntity(model);
        return "toMyUserListAction";
    }

    /**
     * 用户登出  清除session中的所有信息  之后跳转到登陆界面
     */
    public String toLogout() {
        session.clear();//清除session中的所有的数据 防止下一个用户使用的时候串联
        return "toUserLoginPage";
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
