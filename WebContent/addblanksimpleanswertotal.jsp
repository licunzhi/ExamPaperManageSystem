<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="bootstrapvalidator-master/vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="bootstrapvalidator-master/dist/css/bootstrapValidator.css"/>

    <script type="text/javascript" src="bootstrapvalidator-master/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/dist/js/bootstrapValidator.js"></script>
<title>添加<s:property value="#session.qt"/>界面</title>
<script type="text/javascript">
	$(function(){
		 $('#formdate').bootstrapValidator({
			 message: 'This value is not valid',
		        feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields: {
		        	qtitle: {
		                message: 'The username is not valid',
		                validators: {
		                    notEmpty: {
		                        message: '题目信息输入不能为空'
		                    },
		                }
		            },
		            qanswer: {
		                message: 'The username is not valid',
		                validators: {
		                    notEmpty: {
		                        message: '答案不能为空'
		                    },
		                }
		            },
		        }
		        	
		 });
		
	});
	
</script>
</head>
<body>
	<div class="container">
		<h2>请添加<font color="red"><s:property value="#session.qt"/></font>相关信息</h2>
		<div style="border:2px groove;border-radius:15px;">
		<form action="QuestionsAction_doAddQuestion?pid=<s:property value="#session.pid"/>" method="post" class="form-horizontal" id="formdate">
		<input type="hidden" id="qtype" name="qtype" value="<s:property value="#session.qt"/>"/>
		<!-- 问题的显示部分 -->
			<div class="form-group" style="margin-top: 20px;">
				<label class="col-sm-2 control-label">问题:</label>
				<div class="col-sm-6">
					<textarea rows="4" class="form-control" name="qtitle" id="qtitle"></textarea>
				</div>
			</div>
			
			<!-- 答案的显示部分 -->
			<div class="form-group" style="margin-top: 20px;">
				<label class="col-sm-2 control-label">答案:</label>
				<div class="col-sm-6">
					<textarea rows="4" class="form-control" name="qanswer" id="qanswer"></textarea>
				</div>
			</div>
			
			<!-- 按钮部分代码 -->
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-1">
						<button type="submit" class="btn btn-success" style="border-radius: 20px;">确认添加</button>
					</div>
					<div class="col-sm-1">
						<button type="button" class="btn btn-default" style="border-radius: 20px;">取消</button>
					</div>
				</div>
			
		</form>
	</div>
	</div>
</body>
</html>