package com.licunzhi.struts.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.licunzhi.model.Admin;
import com.licunzhi.model.Paper;
import com.licunzhi.model.User;
import com.licunzhi.service.AdminService;
import com.licunzhi.service.PaperService;
import com.licunzhi.service.UserService;
@Controller
@Scope("prototype")
public class AdminAction extends BaseAction<Admin> implements SessionAware{

	private static final long serialVersionUID = 1L;
	
	@Resource(name="adminService")
	private AdminService adminService;
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="paperService")
	private PaperService paperService;
	
	private Map<String,Object> session ;
	
	//用户界面跳转到登陆界面
	public String toAdminLogin(){
		return "adminloginpage";
	}
	
	/**
	 * 用户登出  清除session中的所有信息  之后跳转到登陆界面
	 */
	public String toLogout(){
		session.clear();//清除session中的所有的数据 防止下一个用户使用的时候串联
		return "adminloginpage";
	}
	
	//管理员登陆过程的处理
	public String doLogin(){
		String nameid = model.getNameid();
		String password = model.getPassword();
		Admin admin = adminService.validateUser(nameid,password);
		System.out.println(admin);
		if(admin == null){//用户的信息不存在
			session.put("admininf", "职工号或密码错误");
			session.put("nameid", nameid);
			session.put("password", password);
			return "adminloginpage";
		}
		session.put("admin", admin);
		String regxstr = admin.getNameid();
		regxstr = regxstr.substring(0,5);
		session.put("regxstr", regxstr);
		return "adminindex";
	}

	//toAddUser去增加用户的界面 学院为一个整体
	//增加的是一个学院的相关的专业的老师的内部信息
	public String toAddUser(){
		session.remove("usertemp");
		return "addUserPage";
	}
	
	/**
	 * 查询出所有的属于我的用户
	 */
	public String toFindAllUser(){
		session.remove("userlist");
		Admin admin = (Admin) session.get("admin");
		Integer id = admin.getId();
		List<User> userlist = userService.finAllUserEntity(id);
		session.put("userlist", userlist);
		return "toMyUserListPage";
	}
	
	/**
	 * 查询出所有属于我的用户提交的试卷的大致信息  精确到paper
	 */
	public String toGetMyUserPaper(){
		Admin admin = (Admin) session.get("admin");
		Integer id = admin.getId();
		List<User> userlist = userService.finAllUserEntity(id);
		session.put("userlist", userlist);
		//所有属于用户的id全部都查询出来了
		List<Paper> paperllist = new ArrayList<>();
		for(User u : userlist){
			paperllist.addAll(paperService.getPaperCheckEntity(u));
		}
		session.put("paperllist", paperllist);
		return "toMyShouldCheckPaperPage";
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session= session;
	}
}
