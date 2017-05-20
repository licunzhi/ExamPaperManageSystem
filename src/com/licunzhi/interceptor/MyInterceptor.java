package com.licunzhi.interceptor;

import java.util.Map;

import com.licunzhi.model.Admin;
import com.licunzhi.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyInterceptor extends MethodFilterInterceptor {

    private static final long serialVersionUID = 1L;

    //重写其中过滤的具体方法的实现   初步是过滤除了某些不需要登陆的界面
    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {
        //需要首先得到的是这个加载器
        ActionContext ac = invocation.getInvocationContext();
        Map<String, Object> session = ac.getSession();
        //在session中存储的无论是admin还是user都是应该准许通过的
        User user = (User) session.get("user");
        Admin admin = (Admin) session.get("admin");
        if (user == null && admin == null) {
            return "toUserLoginPage";
        }
        return invocation.invoke();
    }

}
