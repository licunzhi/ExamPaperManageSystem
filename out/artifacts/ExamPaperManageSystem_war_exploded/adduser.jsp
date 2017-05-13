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
<script type="text/javascript">
$(document).ready(function() {
    $('#defaultForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: '用户姓名不能为空'
                    },
                    stringLength: {
                        min: 2,
                        max: 4,
                        message: '请输入姓名汉字个数为:2-4个 ',
                        },
                        regexp: {
                        regexp: /^[a-zA-Z0-9\u4E00-\u9FA5]+$/,
                        message: '姓名组合不能包含特殊字符',
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码要求不为空'
                    },
                    identical: {
                        field: 'password',
                        message: '请保证两次密码输入的一致性'
                    }
                }
            },
            userid: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: '职工号不能为空'
                    },
                    stringLength: {
                        min: 10,
                        max: 10,
                        message: '输入10位职工号',
                    },
                    regexp: {
                        regexp: /* /^[0-9]+$/ */ /^${session.regxstr }/,
                        message: '前五位学院代码必须一致'
                    },
                }
            },
        }
    });
   
    
    $('#resetBtn').click(function() {
        $('#defaultForm').data('bootstrapValidator').resetForm(true);
    });
	
    var content = "${session.erroruserid }";
    if(content == "wrong"){
    	$("#userid > b").empty();
    	$("#userid").addClass("alert-danger");
    	$("#userid").after("<b><font color='red'>职工号被占用 确认后输入</font></b>");
    }
    
});
</script>
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
            <!-- form: -->
            <section>
                <div class="page-header">
                    <h1>增加用户信息</h1>
                </div>

                <div class="col-lg-8 col-lg-offset-2">
                    <form id="defaultForm" method="post" action="UserAction_doAddUser" class="form-horizontal">
                        <fieldset>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">
                                	姓名<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                </label>
                                <div class="col-lg-5">
                                    <input type="text" class="form-control" name="name" value="${session.usertemp.name }"/>
                                </div>
                            </div>
                            
                             <div class="form-group">
                                <label class="col-lg-3 control-label">
                         	       密码<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                                </label>
                                <div class="col-lg-5">
                                    <input type="password" class="form-control" name="password" value="${session.usertemp.password }"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-3 control-label">
                                	确认密码<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                                	</label>
                                <div class="col-lg-5">
                                    <input type="password" class="form-control" name="password" value="${session.usertemp.password }"/>
                                </div>
                            </div>
                            
                             <div class="form-group">
                                <label class="col-lg-3 control-label">
                                	职工号<span class="glyphicon glyphicon glyphicon-th-list" aria-hidden="true"></span>
                                </label>
                                <div class="col-lg-5">
                                    <input type="text" class="form-control" id="userid" name="userid" value="${session.usertemp.userid }"/>
                                </div>
                            </div>

                        </fieldset>

                        <div class="form-group">
                            <div class="col-lg-9 col-lg-offset-3">
                                <button type="submit" class="btn btn-primary sub"  style="border-radius:20px;">提交</button>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-info" id="resetBtn"  style="border-radius:20px;">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
            </section>
            <!-- :form -->
        </div>
    </div>
</body>
</html>