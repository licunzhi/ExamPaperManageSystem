 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrapvalidator-master/vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="bootstrapvalidator-master/dist/css/bootstrapValidator.css"/>
	<link rel="shortcut icon" href="image/ahpu.ico" type="image/x-icon" />
    <script type="text/javascript" src="bootstrapvalidator-master/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/dist/js/bootstrapValidator.js"></script>
<title>显示所有属于我的用户信息的界面</title>
</head>
<body>
 	<s:include value="headeradmin.jsp"/>
	    <div class="container" style="margin-top: 100px;">
	    	<table class="table table-hover" style="table-layout:fixed">
	 			<tr class="active">
	 				<th><h4><b>ID</b></h4></th>
	 				<th><h4><b>用户</b></h4></th>
	 				<th><h4><b>职工号</b></h4></th>
	 				<th><h4><b>操作</b></h4></th>
	 			</tr>
	 		<s:iterator value="#session.userlist" id="ulist" status="unum">
	 			<tr class="success">
	 				<td><s:property value="#unum.index + 1"/></td>
	 				<td><s:property value="#ulist.name"/></td>
	 				<td><s:property value="#ulist.userid"/></td>
	 				<td>
	 					<a href="UserAction_toModifyUserInfo?id=<s:property value="#ulist.id"/>"><font color="red">修改</font></a>
	 						<font color="red">||</font>
	 					<a href="UserAction_toDeleteUserById?id=<s:property value="#ulist.id"/>"><font color="red">删除</font></a>
	 				</td>
	 			</tr>
	 		</s:iterator>
	 		</table>	
	    </div>
</body>
</html>