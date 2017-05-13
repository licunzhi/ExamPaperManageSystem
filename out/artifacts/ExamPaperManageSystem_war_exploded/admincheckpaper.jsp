 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入相关的脚本工具 -->
  <link rel="stylesheet" href="bootstrapvalidator-master/vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="bootstrapvalidator-master/dist/css/bootstrapValidator.css"/>

    <script type="text/javascript" src="bootstrapvalidator-master/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/dist/js/bootstrapValidator.js"></script>
<title>需要审阅的试卷信息一览</title>
</head>
<body>
	 	<s:include value="headeradmin.jsp"/>
	 	<div class="container" style="margin-top: 100px;">
	 		<table class="table table-hover">
	 			<tr>
	 				<th><h4><b>ID</b></h4></th>
	 				<th><h4><b>标题</b></h4></th>
	 				<th><h4><b>出卷人</b></h4></th>
	 				<th><h4><b>日期</b></h4></th>
	 			</tr>
	 			
	 			<!-- 使用迭代的方式查询出所有属于自己审核的试卷 -->
	 			
	 		</table>
	 	</div>
</body>
</html>