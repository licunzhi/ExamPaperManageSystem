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

    <script type="text/javascript" src="bootstrapvalidator-master/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrapvalidator-master/dist/js/bootstrapValidator.js"></script>
<title>所有我提交的试卷的审核状态</title>
</head>
<body>
	 	<s:include value="header.jsp"/>
	 	<div class="container" style="margin-top: 100px;">
	 		<table class="table table-hover" style="table-layout:fixed">
	 			<tr class="active">
	 				<th><h4><b>ID</b></h4></th>
	 				<th><h4><b>标题</b></h4></th>
	 				<th><h4><b>日期</b></h4></th>
	 				<th><h4><b>审阅状态</b></h4></th>
	 			</tr>
	 			
	 			<!-- 使用迭代的方式查询出所有属于自己审核的试卷 -->
	 			<s:iterator value="#session.paperlistcoll" id="ppll" status="pppnum">
	 				<tr class="success">
	 					<td><s:property value="#pppnum.index + 1"/></td>
	 					<td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">
	 					<s:property value="#ppll.title"/>
	 					</td>
	 					<td><s:property value="#ppll.date"/></td>
	 					<td>
	 						<s:if test="#ppll.status == 2">审核中</s:if>
	 						<s:if test="#ppll.status == 4">审核通过&nbsp;&nbsp;&nbsp;&nbsp;
	 							<a href="PaperAction_toPrintPaperNiuBi?id=<s:property value="#ppll.id"/>" title="打印" target="_blank">
	 								<img alt="打印" src="image/print.jpg">
	 							</a>
								<a href="PaperAction_toPrintPaperAnswers?id=<s:property value="#ppll.id"/>" title="打印答案" target="_blank">
									<img alt="打印答案" src="image/ans.jpg">
								</a>
	 							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 							<a href="PaperAction_toTrashAndStayTrashPage?id=<s:property value="#ppll.id"/>" title="扔回垃圾箱">
	 								<img alt="垃圾箱" src="image/trash.jpg" style="width: 20px;height: 20px;">
	 							</a>
	 						</s:if>
	 						<s:if test="#ppll.status == 5">未通过&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 							<a href="PaperAction_toRebackTempArea?id=<s:property value="#ppll.id"/>" title="撤回草稿箱">
	 								<img alt="撤回草稿箱" src="image/rebacktemp.jpg">
	 							</a>
	 						</s:if>
	 					</td>
	 				</tr>
	 			</s:iterator>
	 		</table>
	 	</div>
</body>
</html>