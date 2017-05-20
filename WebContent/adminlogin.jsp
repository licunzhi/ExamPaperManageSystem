<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 引入相关的脚本工具 -->
    <link rel="stylesheet" href="bootstrapvalidator-master/vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="bootstrapvalidator-master/dist/css/bootstrapValidator.css"/>
    <link rel="shortcut icon" href="image/ahpu.ico" type="image/x-icon"/>
    <script type="text/javascript" src="bootstrapvalidator-master/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/dist/js/bootstrapValidator.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#tips").click(function () {
                alert("请去教务处重置密码信息，电话：0553-2871346 0553-2871043");
            });

            var sub = $(".comm");
            var content = "${session.admininf}".toString();

            sub.click(function () {
                //教职工账号的验证
                var nameid = $("#nameid").val().trim();
                $(".tip1 > b").empty();
                $(".tip2 > b").empty();
                if (nameid == "") {
                    alert("请输入教职工号！");
                    $(".tip1 input").after("<b><br><font color='red'>请输入教职工号！</font></b>");
                    return false;
                }
                $("#nameid").attr("value", nameid);

                //教职工密码的验证
                var password = $("#password").val();
                $(".tip2 > b").empty();
                if (password == "") {
                    alert("请输入密码！");
                    $(".tip2 input").after("<b><br><font color='red'>请输入密码！</font></b>");
                    return false;
                }
                $("#password").attr("value", password);

            });

            if (content != "") {
                alert(content + "-----");
                $(".tip2 input").after(
                    "<b><br><font color='red'>" + content + "</font></b>");
            }

        });
    </script>
    <style type="text/css">
        .container {
            width: 300px;
            height: 200px;
            position: absolute;
            top: 245px;
            left: 468px;
        }

        .grap {
            width: 300px;
            height: 200px;
            position: absolute;
            top: 246px;
            left: 479px;
            background-color: silver;
            filter: alpha(opacity=50);
            -moz-opacity: 0.5;
            -khtml-opacity: 0.5;
            opacity: 0.5;
        }

        .words {
            position: absolute;
            top: 0px;
            left: 10px;
            font-size: 44px;
            font-weight: bold;
        }

        .words span {
            top: 0px;
            left: 10px;
            font-size: 44px;
            font-style: italic;
            font-family: "华文行楷";
        }

        .titleword {
            top: 253px;
            left: 574px;
            position: absolute;
            color: red;
            font-size: 20px;
            font-weight: bold;
            font-family: "华文仿宋";
        }

        .userlogin {
            top: 12px;
            left: 1164px;
            position: absolute;
            font-size: 20px;
            font-weight: bold;
        }

        .adminpos {
            top: 17px;
            left: 1177px;
            position: absolute;
        }
    </style>
    <title>管理员登陆界面</title>
</head>
<body>
<div class="big" style="background-image: url('image/backimg1.jpg');height: 585px;width: 1300px"></div>
<div class="grap"></div>
<div class="words">高校试卷管理系统管理员登陆界面</div>
<div class="userlogin btn btn-primary" onclick="location='UserAction_toUserLogin'">用户登录</div>
<div class="titleword">管理员登陆</div>
<div class="container">
    <br><br>
    <form action="AdminAction_doLogin" method="post" class="form-horizontal" style="position: relative;left: 44px;">
        <div id="" class="form-group tip1">
            <label for="nameid" class="control-label">职工号</label>
            <input type="text" placeholder="教职工号" name="nameid" id="nameid" value="3130705121"/>
            <!--value="${nameid }"-->
        </div>
        <div class="form-group tip2">
            <label for="password" class="control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码 </label>
            <input type="password" placeholder="密码" name="password" id="password" value="123"/>
            <!--value="${password }"-->
        </div>
        <div class="form-group">
            <label class="control-label sr-only">登 陆</label>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" class="btn btn-primary comm" value="登陆" style="border-radius:20px;"/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a id="tips" class="btn btn-warning" style="border-radius:20px;"><u>密码丢失</u></a>
        </div>
    </form>
</div>

</body>
</html>