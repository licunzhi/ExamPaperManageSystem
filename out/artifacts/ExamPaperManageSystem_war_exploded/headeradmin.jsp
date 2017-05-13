 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入相关的脚本工具 -->
  <link rel="stylesheet" href="bootstrapvalidator-master/vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="bootstrapvalidator-master/dist/css/bootstrapValidator.css"/>
	<link rel="shortcut icon" href="image/ahpu.ico" type="image/x-icon" />
    <script type="text/javascript" src="bootstrapvalidator-master/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/dist/js/bootstrapValidator.js"></script>
<script type="text/javascript">
$(function(){
	$("#logout").click(function(){
		var flag = confirm("是否退出登录？")
		if(flag == true){
			return true;
		}
		return false;
	});
	
});
</script>
<style type="text/css">
.containername {
	position: absolute;
	top: 18px;
	left: 511px;
	font-size: 44px;
	font-weight: bold;
}

.worddd {
	position: absolute;
	top: 0px;
	left: 10px;
	font-size: 44px;
	font-weight: bold;
}

.worddd span {
	top: 0px;
	left: 10px;
	font-size: 44px;
	font-style: italic;
	font-family: "华文行楷";
}

.dropdown-menu>li>a:hover {
	background: #66CCFF;
}

.navbar {
	position: absolute;
	top: 24px;
	left: 516px;
	width: 581px;
	background-color: #5FB878;
}
	.userinfo{
		position:absolute;
		top:24px;
		left:966px;
		font-size: 44px;
		font-weight: bold;
	}
	
</style>
<title>所有的导航栏的上标题</title>
</head>
<body>
<div class="worddd btn btn-info"><span><a href="adminindex.jsp" style="color:white;">试卷管理系统后台系统</a></span></div>
<div class="containername">
		<div class="btn-group">
			<a href="AdminAction_toGetMyUserPaper" class="btn btn-primary" role="button" style="border-radius:20px;">待审核</a>
		</div>
		<!-- <div class="btn-group">
			<a class="btn btn-primary" role="button" style="border-radius:20px;">增加题库</a>
		</div>
		<div class="btn-group">
			<a class="btn btn-primary" role="button" style="border-radius:20px;">所有题库</a>
		</div> -->
		<div class="btn-group">
			<a class="btn btn-primary" href="AdminAction_toAddUser" role="button" style="border-radius:20px;">增加用户</a>
		</div>
		<div class="btn-group">
			<a class="btn btn-primary" href="AdminAction_toFindAllUser" role="button" style="border-radius:20px;">所有用户</a>
		</div>
	<!-- 	<div class="btn-group">
			<a class="btn btn-primary" href="AdminAction_toAddUser" role="button" style="border-radius:20px;">审核历史纪录</a>
		</div> -->
</div>
<div class="userinfo">
		<a href="AdminAction_toLogout" class="btn btn-success btn-lg" id="logout"
							style="border-radius:20px;">欢迎：<s:property value="#session['admin'].name"/> </a><!-- 之后需要实现注销的功能 -->
	</div>
</body>
</html>