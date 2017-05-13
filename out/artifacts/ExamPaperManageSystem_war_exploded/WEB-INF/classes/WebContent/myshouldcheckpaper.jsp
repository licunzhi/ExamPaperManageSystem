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
<title>检阅属于我的用户提交的试卷信息</title>
<style type="text/css">
	.happystyle{
	height:auto; 
	float:left;
	white-space:normal; 
	word-wrap:break-word; 
	word-break:break-all;
}
</style>
</head>
<body>
 	<s:include value="headeradmin.jsp"/>
	    <div class="container" style="margin-top: 100px;">
	    	<table class="table table-hover" style="table-layout:fixed">
	 			<tr class="active">
	 				<th><h4><b>ID</b></h4></th>
	 				<th><h4><b>职工号(用户)</b></h4></th>
	 				<th><h4><b>标题</b></h4></th>
	 				<th><h4><b>预览</b></h4></th>
	 			</tr>
	 		<s:iterator value="#session.userlist" id="ulist" status="unum">
					<s:iterator value="#session['paperllist']" id="pllist" status="ppnum">
						<s:if test="#pllist.user.id == #ulist.id">
				 		<tr class="success">
							<td><s:property value="#ppnum.index + 1" /></td>
							<td><s:property value="#ulist.userid" />(<s:property value="#ulist.name"/>)</td>
							<td><s:property value="#pllist.title" /></td>
							<td>
								<a href="PaperAction_toViewPaperIsOk?id=<s:property value="#pllist.id"/>" target="_blank"><img alt="预览" src="image/view.png" title="预览"></a>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="PaperAction_toSetPaperPast?id=<s:property value="#pllist.id"/>"><img alt="通过" src="image/success.jpg" title="通过"></a>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="PaperAction_toSetPaperNotPast?id=<s:property value="#pllist.id"/>"><img alt="否决" src="image/fail.jpg" title="否决"></a>
							</td>
						</tr>
					</s:if>
				</s:iterator>
	 		</s:iterator>
	 		</table>	
	    </div>
</body>
</html>