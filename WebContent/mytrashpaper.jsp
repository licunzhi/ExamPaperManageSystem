<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <title>我的垃圾箱</title>
</head>
<body>
<s:include value="header.jsp"/>
<div class="container" style="margin-top: 100px;">
    <table class="table table-hover" style="table-layout:fixed">
        <tr class="active">
            <th><h4><b>ID</b></h4></th>
            <th><h4><b>标题</b></h4></th>
            <th><h4><b>日期</b></h4></th>
            <th><h4><b>操作</b></h4></th>
        </tr>

        <!-- 使用迭代的方式查询出所有属于自己审核的试卷 -->
        <s:iterator value="#session.paperlisttrash" id="ppll" status="pppnum">
            <tr class="success">
                <td><s:property value="#pppnum.index + 1"/></td>
                <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">
                    <s:property value="#ppll.title"/>
                </td>
                <td><s:property value="#ppll.date"/></td>
                <td>
                    <a href="PaperAction_toRebackTemp?id=<s:property value="#ppll.id"/>"><font color="red">还原到草稿箱</font></a>
                    <font color="red">||</font>
                    <a href="PaperAction_toRemoveTrash?id=<s:property value="#ppll.id"/>"><font color="red">彻底清除</font></a>
                </td>
            </tr>
        </s:iterator>
    </table>
</div>
</body>
</html>