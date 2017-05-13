<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 引入相关的脚本工具 -->
   <link rel="stylesheet" href="bootstrapvalidator-master/vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="bootstrapvalidator-master/dist/css/bootstrapValidator.css"/>

    <script type="text/javascript" src="bootstrapvalidator-master/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/dist/js/bootstrapValidator.js"></script>
<title>用户菜单主界面</title>
<style type="text/css">
	font{
		color: red;
	}
</style>
</head>
<body>
	<s:include value="header.jsp"/><br><br><br><br>
	<div class="container">
		<h1><font>使用指南</font></h1>
		<h4><font>主页面</font></h4>
		<img alt="使用指南" src="image/guider.png" style="width: 1000px">
		<h4><font>新建试卷页面</font></h4>
		<img alt="使用指南" src="image/temp.png" style="width: 1000px">
		<h4><font>我的试卷页面</font></h4>
		<img alt="使用指南" src="image/mypaper.png" style="width: 1000px">
		
	</div>
</body>
</html>