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
    <link rel="shortcut icon" href="image/ahpu.ico" type="image/x-icon" />
    <script type="text/javascript" src="bootstrapvalidator-master/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/dist/js/bootstrapValidator.js"></script>
<title>管理员菜单主界面</title>
</head>
<
<style>
    p{
        color:blue;
    }
</style>
<body>
	<s:include value="headeradmin.jsp"></s:include>
    <div class="container">
     <br><br><br><br><br><br>
     <hr>
        <h1><p>使用指南</p></h1>
     <img alt="使用指南" src="image/adminguide.png" style="width: 1000px">
    </div>
</body>
</html>