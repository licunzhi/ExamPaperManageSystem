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
	
	//�û�������ת����½����
	public String toAdminLogin(){
		return "adminloginpage";
	}
	
	/**
	 * �û��ǳ�  ���session�е�������Ϣ  ֮����ת����½����
	 */
	public String toLogout(){
		session.clear();//���session�е����е����� ��ֹ��һ���û�ʹ�õ�ʱ����
		return "adminloginpage";
	}
	
	//����Ա��½���̵Ĵ���
	public String doLogin(){
		String nameid = model.getNameid();
		String password = model.getPassword();
		Admin admin = adminService.validateUser(nameid,password);
		System.out.println(admin);
		if(admin == null){//�û�����Ϣ������
			session.put("admininf", "ְ���Ż��������");
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

	//toAddUserȥ�����û��Ľ��� ѧԺΪһ������
	//���ӵ���һ��ѧԺ����ص�רҵ����ʦ���ڲ���Ϣ
	public String toAddUser(){
		session.remove("usertemp");
		return "addUserPage";
	}
	
	/**
	 * ��ѯ�����е������ҵ��û�
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
	 * ��ѯ�����������ҵ��û��ύ���Ծ�Ĵ�����Ϣ  ��ȷ��paper
	 */
	public String toGetMyUserPaper(){
		Admin admin = (Admin) session.get("admin");
		Integer id = admin.getId();
		List<User> userlist = userService.finAllUserEntity(id);
		session.put("userlist", userlist);
		//���������û���idȫ������ѯ������
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
