 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script type="text/javascript">
$(document).ready(function() {
		$("#tips").click(function(){
				alert("请联系管理员进行登陆密码的重新设定");			
		});
	
    $('#loginform').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	userid: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: '职工号不能为空'
                    },
                    stringLength: {
                        min: 10,
                        max: 10,
                        message: '职工号一共10位 ',
                        },
                        regexp: {
                        regexp: /^[0-9]+$/,
                        message: '只能为数字组合',
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码要求不为空'
                    },
                }
            }
        }
    });
});
       
 </script>
<style type="text/css">
	.container{
		width: 300px;
		height:200px;
		position:absolute;
		top: 245px;
		left:746px;
	}
	.grap{
		width: 300px;
		height:200px;
		position:absolute;
		top: 246px;
		left:750px;
		background-color: silver;
		filter:alpha(opacity=50); 
		-moz-opacity:0.5; 
		-khtml-opacity: 0.5; 
		opacity: 0.5; 
		 border-radius:20px;
	}
	.words{
		position:absolute;
		top:0px;
		left:10px;
		font-size: 44px;
		font-weight: bold;
	}
	.words span{
		top:0px;
		left:10px;
		font-size: 44px;
		font-style: italic;
		font-family: "华文行楷";
	}
	.titleword{
		top:253px;
		left:853px;
		position:absolute;
		font-size: 20px;
		font-style: italic;
		font-family: "华文行楷";
	}
	.adminpos{
		top:17px;
		left:1177px;
		position:absolute;
	}
</style>
<title>首页显示界面--试卷管理系统的登陆</title>
</head>
<body>
<div class="big" style="background-image: url('image/backimg.jpg');height: 585px;width: 1300px"></div>
<div class="grap"></div>
<div class="words"><span>安徽工程大学</span>试卷管理系统</div>
<div class="titleword">用户登陆</div>
<div class="adminpos"><a href="adminlogin.jsp" class="btn btn-success btn-lg"  style="border-radius:20px;">管理员登陆</a></div>
	<div class="container">
	<br><br>
		<form id="loginform" action="UserAction_doCheckUser" method="post" class="form-horizontal" style="position:absolute; left: 60px;">
			<fieldset>
			<div id="" class="form-group">
				<label for="userid" class="control-label">职工号</label>
				<input type="text" placeholder="教职工号" name="userid" id="userid" value="3130705121"/>
			</div>
			<div class="form-group">
				<label for="password" class="control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码  </label>
				<input type="password" placeholder="密码" name="password" id="password" value="123"/>
			</div>
			<div class="form-group">
				<label class="control-label sr-only">登  陆</label>
				<input  style="border-radius:20px;" type="submit" class="btn btn-primary" value="登陆"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input  style="border-radius:20px;" type="button" id="tips" class="btn btn-danger" value="忘记密码"/>
			</div>
			</fieldset>
		</form>
</div>	


</body>
</html>