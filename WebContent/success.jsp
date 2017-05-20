<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Refresh" content="5;url=userindex.jsp">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrapvalidator-master/vendor/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="bootstrapvalidator-master/dist/css/bootstrapValidator.css"/>
    <link rel="shortcut icon" href="image/ahpu.ico" type="image/x-icon"/>
    <script type="text/javascript" src="bootstrapvalidator-master/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/dist/js/bootstrapValidator.js"></script>

    <style type="text/css">
        .container {
            position: absolute;
            top: 100px;
        }
    </style>
    <script type="text/javascript">
        var times = 6;
        function clock() {
            var time = document.getElementById("time");
            window.setTimeout('clock()', 1000);
            times = times - 1;
            time.innerHTML = times;
        }
    </script>
    <title>成功界面跳转到主页面的界面</title>
</head>
<body onload="clock()">
<div class="container">
    <div class="row">
        <div class="page-header" style="color: red">
            <h1>操作成功<span id="time">3</span>秒后返回主界面！</h1>
        </div>
        <div align="center">
            <img alt="添加成功" src="image/addok.jpg">
        </div>
        <div align="center" style="color: green;">
            <h3><b>操作成功</b></h3>
        </div>
        <div align="center">
            <h4><a href="userindex.jsp">直接返回主界面</a></h4>
        </div>

    </div>
</div>
</body>
</html>