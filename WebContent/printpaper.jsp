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
<title>${session.paper.title }</title>
<script type="text/javascript">
	$(function(){
		window.print();	
	});
</script>
<style type="text/css">
.happystyle {
	height: auto;
	white-space: normal;
	word-wrap: break-word;
	word-break: break-all;
}

.ttititle {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<!-- 显示试卷的标题部分   如果没有此部分 是不能新建页面的 -->
		<s:if test="#session['paper'].title != null">
			<div class="row">
				<div class="ttititle happystyle">
					 <h1><b>${session.paper.title }</b></h1>
				</div>
			</div>
		</s:if>
		<!-- 试卷页面的显示  根据paperID查询的page如果是不为空的 就显示page界面 -->
		<s:if test="#session['pagelist'] != null">
			<s:iterator value="#session['pagelist']" id="pl" status="num">
				<div class="row"><!-- 试卷的标题 -->
					<div class=""><h4><b>(<s:property value="#pl.pageid"/>):<s:property value="#pl.qtype"/></b></h4></div>
					<s:iterator value="#session['questionlist']" id="ql" status="qnum">
						<s:if test="#ql.page.id == #pl.id">
								<div class="happystyle"><font size="1px"><s:property value="#qnum.index + 1"/>、<s:property value="#ql.qtitle"/></font></div>
							<s:if test="#ql.qtype == '单选题' || #ql.qtype == '多选题'">
							<s:iterator value="#ql.qoptionsAttr" id="qop">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<font size="1px"><s:property value="qop"/><br></font>
								</s:iterator>
								<br>
							</s:if>
						</s:if>
					</s:iterator>
				</div>
			</s:iterator>
		</s:if>
	</div>

</body>
</html>