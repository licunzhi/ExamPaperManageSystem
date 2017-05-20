<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- 引入相关的脚本工具 -->
    <link rel="stylesheet" href="bootstrapvalidator-master/vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="bootstrapvalidator-master/dist/css/bootstrapValidator.css"/>
    <link rel="shortcut icon" href="image/ahpu.ico" type="image/x-icon"/>
    <script type="text/javascript" src="bootstrapvalidator-master/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/dist/js/bootstrapValidator.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#logout").click(function () {
                var flag = confirm("是否退出登录？")
                if (flag == true) {
                    return true;
                }
                return false;
            });

        });
    </script>
    <style type="text/css">
        .btn-toolbar {
            position: absolute;
            top: 29px;
            left: 580px;
            font-size: 44px;
            font-weight: bold;
        }

        .userinfo {
            position: absolute;
            top: -12px;
            left: 412px;
            font-size: 44px;
            font-weight: bold;
            border-radius: 10px;
        }

        .words {
            position: absolute;
            top: 0px;
            left: 10px;
            font-size: 44px;
            font-weight: bold;
            background-color: black;
        }

        .words span {
            top: 0px;
            left: 10px;
            font-size: 44px;
            font-style: italic;
            font-family: "华文行楷";
            color: white;
        }

        .containername {
            position: absolute;
            width: 248px;
            left: 693px;
            top: 39px;
            background-color: black;
            border-radius: 15px;
        }

        a:hover {
            color: green;
        }

        a {
            color: white;
        }

        .trash {
            width: 50px;
            height: 50px;
            position: absolute;
            left: 298px;
            top: -16px;
            border-radius: 50px;
        }

        .index {
            width: 50px;
            height: 50px;
            position: absolute;
            left: -81px;
            top: -18px;
            border-radius: 50px;
        }
    </style>
    <title>所有的导航栏的上标题</title>
</head>
<body>
<div class="words btn"><span>高校试卷管理系统</span></div>
<div class="containername">
    <div class="index">
        <a href="userindex.jsp"><img style="width: 50px;height: 50px;" alt="主页" src="image/index.jpg" title="主页"></a>
    </div>
    <div class="btn-group">
        <div class="btn">
            <a style="border-radius:20px;" href="PaperAction_getMyAllPaper">我的试卷</a>
        </div>
    </div>

    <div class="btn-group">
        <div class="btn">
            <a href="UserAction_toAddPaper">新建试卷</a>
        </div>
    </div>

    <div class="btn-group">
        <div class="btn">
            <a href="PaperAction_getTempAllPaper">草稿箱</a>
        </div>
    </div>

    <div class="trash">
        <a href="PaperAction_getTrashAllPaper"><img style="width: 50px;height: 50px;" alt="垃圾箱" src="image/trash.jpg"
                                                    title="垃圾箱"></a>
    </div>

    <div class="userinfo">
        <a class="btn btn-default btn-lg" id="logout" href="UserAction_toLogout"
           style="border-radius:20px;">欢迎用户：${session.user.name }</a>
    </div>
</div>


</body>
</html>