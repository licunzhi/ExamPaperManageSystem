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
    <script type="text/javascript" src="bootstrapvalidator-master/dist/js/bootstrapValidator.js"></script>
    <title>新建、修改试卷的界面</title>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#subForm').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    title: {
                        message: 'The username is not valid',
                        validators: {
                            notEmpty: {
                                message: '标题不能为空'
                            },
                        }
                    },

                }
            });
            var content = "${session.paper.title }";
            $("#add").click(function () {
                if (content.trim() == "") {
                    alert("请先创建试卷标题后， 再增加新的页面！");
                    return false;
                }
            });
            $('#subForm1').bootstrapValidator({

                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    qtype: {
                        message: 'The username is not valid',
                        validators: {
                            notEmpty: {
                                message: '题目类型不能为空'
                            },
                        }
                    },
                    pageid: {
                        message: 'The username is not valid',
                        validators: {
                            notEmpty: {
                                message: '页号不能为空'
                            },
                        }
                    }

                }
            });
        });
    </script>
    <style type="text/css">
        .row {
            border: 2px solid #e1e1e8;
            border-radius: 20px;
            margin-left: auto;
            margin-top: auto;
        }

        div .col-md-1 {
            border-radius: 20px;
        }

        .onlytitle {
            display: block;
            overflow: hidden; /*注意不要写在最后了*/
            white-space: nowrap;
            -o-text-overflow: ellipsis;
            text-overflow: ellipsis;
        }

        .happystyle {
            height: auto;
            float: left;
            white-space: normal;
            word-wrap: break-word;
            word-break: break-all;
        }
    </style>
</head>
<body>
<s:include value="header.jsp"/><br><br><br><br>
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <h3>您正在创建、修改试卷信息</h3>
        </div>
        <div class="col-md-2 col-md-offset-4">
            <button class="btn btn-info" style="border-radius:20px;margin-top:20px;" data-toggle="modal"
                    data-target="#myModal">标题增加、修改
            </button>
        </div>
        <div class="col-md-2">
            <a class="btn btn-info" id="add" style="border-radius:20px;margin-top:20px;" data-toggle="modal"
               data-target="#myModal1">增加页面</a>
        </div>
    </div>
    <!-- 显示试卷的标题部分   如果没有此部分 是不能新建页面的 -->
    <s:if test="#session['paper'].title != null">
        <div class="row">
            <div class="col-md-12 happystyle" align="center">
                <h1>${session.paper.title }</h1><h4>---标题</h4>
            </div>
        </div>
    </s:if>
    <!-- 试卷页面的显示  根据paperID查询的page如果是不为空的 就显示page界面 -->
    <s:if test="#session['pagelist'] != null">
        <s:iterator value="#session['pagelist']" id="pl" status="num">
            <div class="row">
                <div class="col-md-2">页号：<s:property value="#pl.pageid"/></div>
                <div class="col-md-2">题型：<s:property value="#pl.qtype"/></div>
                <div class="col-md-1 col-md-offset-6 btn btn-info"><a
                        href="QuestionsAction_toAddQuestionPage?qtype=<s:property value='#pl.qtype'/>&pid=<s:property value="#pl.id"/>"
                        style="color:white;">添加问题</a></div>
                <div class="col-md-1 btn btn-danger"><a href="PageAction_doDeletePage?id=<s:property value='#pl.id'/>"
                                                        style="color:white">删除本页</a></div>
                <!--
                    恐怕是需要迭代中间增加新的迭代了
                    迭代过程中需要增加很多的判断   其中最典型的对于id的判断
                -->
                <s:iterator value="#session['questionlist']" id="ql" status="qnum">
                    <s:if test="#ql.page.id == #pl.id">
                        <div class="col-md-12 happystyle">
                            <s:property value="#qnum.index + 1"/>、<s:property value="#ql.qtitle"/>
                            <a href="QuestionsAction_doDeleteQuestion?id=<s:property value="#ql.id"/>"
                               class="btn btn-danger btn-xs">删除</a>
                        </div>
                        <s:if test="#ql.qtype == '单选题' || #ql.qtype == '多选题'">
                            <s:iterator value="#ql.qoptionsAttr" id="qop">
                                <div class="col-md-offset-1 col-md-11 happystyle"><!-- 显示问题的每一个选项  每个选项至少独占一行 -->
                                    <s:property value="qop"/>
                                </div>
                            </s:iterator>
                            <br>
                        </s:if>
                        <br>
                    </s:if>
                </s:iterator>
            </div>
        </s:iterator>
    </s:if>
    <s:if test="#session['paper'].title != null">
        <div class="row">
            <div class="col-md-offset-9 col-md-1 btn btn-primary">
                <a href="PaperAction_setPaperTempStatus?id=<s:property value="#session['paper'].id"/>"
                   style="color: white">保存草稿箱</a>
            </div>
            <div class="col-md-1 btn btn-success">
                <a href="PaperAction_setPaperCheckStatus?id=<s:property value="#session['paper'].id"/>"
                   style="color: white">提交审阅</a>
            </div>
            <div class="col-md-1 btn btn-warning">
                <a href="PaperAction_setPaperDispearStatus?id=<s:property value="#session['paper'].id"/>"
                   style="color: white">丢弃试卷</a>
            </div>
        </div>
    </s:if>
</div>
<!-- 本地弹窗实现标题的存储 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <form action="PaperAction_toNewPaper" method="post" class="form-horizontal" id="subForm">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">请输入新标题或修改现有标题</h4>
                </div>
                <div class="modal-body">
                    <fieldset>
                        <div class="form-group">
                            <label class="control-label">试卷标题</label>
                            <input type="text" name="title" class="form-control" value="${session.paper.title }"/>
                            <input type="hidden" name="id" value="${session.paper.id }"><!-- 增加隐藏域就是为了实现update方法 -->
                        </div>
                    </fieldset>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success" style="border-radius:20px;">确认</button>
                    <button type="button" class="btn btn-default" style="border-radius:20px;" data-dismiss="modal">取消
                    </button>
                </div>
            </div>
        </div>
    </form>
</div>

<!-- 本地弹窗实现页面的存储 -->
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <form action="PageAction_toNewPage" method="post" class="form-horizontal" id="subForm1">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">填充相应的页面信息</h4>
                </div>
                <div class="modal-body">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">请输入页码</label>
                            <div class="col-lg-4">
                                <input class="form-control" type="number" name="pageid" id="pageid" step="1"
                                       min="0" data-bv-greaterthan-inclusive="false"
                                       data-bv-greaterthan-message="页数从1开始最大为10"
                                       max="10" data-bv-lessthan-inclusive="true" data-bv-lessthan-message="页数从1开始最大为10"
                                />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-3">请选择题型</label>
                            <div class="col-lg-4">
                                <select name="qtype" class="form-control" id="qtype">
                                    <option value="">请选择题型</option>
                                    <option value="单选题">单选题</option>
                                    <option value="多选题">多选题</option>
                                    <option value="填空题">填空题</option>
                                    <option value="判断题">判断题</option>
                                    <option value="简答题">简答题</option>
                                    <option value="综合题">综合题</option>
                                </select>
                            </div>
                        </div>
                    </fieldset>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success" style="border-radius:20px;">确认</button>
                    <button type="button" class="btn btn-default" style="border-radius:20px;" data-dismiss="modal">取消
                    </button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>