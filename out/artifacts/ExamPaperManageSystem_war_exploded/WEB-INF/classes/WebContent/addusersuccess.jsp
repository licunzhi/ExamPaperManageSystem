 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrapvalidator-master/vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="bootstrapvalidator-master/dist/css/bootstrapValidator.css"/>

    <script type="text/javascript" src="bootstrapvalidator-master/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/dist/js/bootstrapValidator.js"></script>

<style type="text/css">
	.container{
		position: absolute;
		top: 100px;
	}
</style>
<title>增加用户的界面</title>
</head>
<body>
 	<s:include value="headeradmin.jsp"/>
	    <div class="container">
        <div class="row">
                <div class="page-header">
                    <h1>增加用户信息</h1>
                </div>
				<div align="center">
					<img alt="添加成功" src="image/addok.jpg">
				</div>
				<div align="center" style="color: green;">
					<h3><b>添加成功</b></h3>
				</div>
				<div align="center">
					<h4><a href="AdminAction_toAddUser">继续添加</a></h4>
				</div>
                
        </div>
    </div>
</body>
</html>