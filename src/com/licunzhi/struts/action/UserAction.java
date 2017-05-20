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

    //ȥ�û���½�Ľ���
    public String toUserLogin() {
        session.clear();
        return "toUserLoginPage";
    }

    //�����û���ʵ�ʹ���
    public String doAddUser() {
        session.remove("erroruserid");
        String userid = model.getUserid();
        String pwd = model.getPassword();
        pwd = pwd.substring(0, pwd.indexOf(","));
        model.setPassword(pwd);
        boolean flag = userService.isOnlyUserid(userid);
        session.put("usertemp", model);
        if (!flag) {//������������
            session.put("erroruserid", "wrong");
            return "toAddUserAction";
        }
        //����������ʱ��   �����û���Ϣ  ������ص�admin
        Admin admin = (Admin) session.get("admin");
        model.setAdmin(admin);
        userService.saveEntity(model);
        return "toAddUserSuccess";
    }

    //��֤��½���û��ǲ��Ƿ�������
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

    //ȥ�����Ծ�Ľ���
    public String toAddPaper() {
        session.remove("pagelist");
        session.remove("questionlist");
        session.remove("paper");
        return "toAddPaperPage";
    }

    //ɾ��ָ��id��User����
    public String toDeleteUserById() {
        String uid = request.getParameter("id");
        System.out.println(uid);
        Integer id = Integer.valueOf(uid);
        User user = userService.getEntity(id);
        userService.deleteEntity(user);
        return "toMyUserListAction";
    }

    //��Ҫ�޸�ָ���û�����Ϣ��
    public String toModifyUserInfo() {
        session.remove("uuuser");
        String uuid = request.getParameter("id");
        Integer id = Integer.valueOf(uuid);
        User uuuser = userService.getEntity(id);
        session.put("uuuser", uuuser);
        return "toModifyUserInfoPage";
    }

    //ֻ�Ǽ򵥵ĸ����û�����Ϣ
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
     * �û��ǳ�  ���session�е�������Ϣ  ֮����ת����½����
     */
    public String toLogout() {
        session.clear();//���session�е����е����� ��ֹ��һ���û�ʹ�õ�ʱ����
        return "toUserLoginPage";
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
