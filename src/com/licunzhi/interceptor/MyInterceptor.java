package com.licunzhi.interceptor;

import java.util.Map;

import com.licunzhi.model.Admin;
import com.licunzhi.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyInterceptor extends MethodFilterInterceptor {

    private static final long serialVersionUID = 1L;

    //��д���й��˵ľ��巽����ʵ��   �����ǹ��˳���ĳЩ����Ҫ��½�Ľ���
    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {
        //��Ҫ���ȵõ��������������
        ActionContext ac = invocation.getInvocationContext();
        Map<String, Object> session = ac.getSession();
        //��session�д洢��������admin����user����Ӧ��׼��ͨ����
        User user = (User) session.get("user");
        Admin admin = (Admin) session.get("admin");
        if (user == null && admin == null) {
            return "toUserLoginPage";
        }
        return invocation.invoke();
    }

}
