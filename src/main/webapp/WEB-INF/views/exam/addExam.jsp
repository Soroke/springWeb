<%@ page import="com.web.core.Http" %>
<%@ page import="com.web.core.Request" %>
<%@ page import="com.web.util.JsonHelper" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.web.util.UserInfo" %>
<%@ page import="com.web.Return.Environment" %>
<%@ page import="com.web.controller.GetEnvironment" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 2017/7/19
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../public/public.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>添加考试</title>
</head>
<style type="text/css">
    body {
        padding-top: 50px;
    }
    .starter-template {
        padding: 40px 15px;
        text-align: center;
    }
</style>
<body>
<div class="container">

    <button type="button" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">
        <span class="glyphicon glyphicon-globe"></span> ${environment.environment}
    </button>
    <button type="button" class="btn btn-primary btn-lg" style="text-shadow: black 5px 3px 3px;">
        <span class="glyphicon glyphicon-user"></span> ${environment.userAccount}
    </button>
    <!-- 按钮触发模态框 -->
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" style="text-shadow: black 5px 3px 3px;">修改环境和管理员用户</button>

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form:form id="defaultForm" action="/exam/settingEnvironmentPost" method="post" commandName="settingEnvironment" role="form">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">修改环境和管理员用户</h4>
                    </div>
                    <div class="modal-body">

                        <div class="form-group">
                            <label>请选择学法平台环境</label>
                            <select class="form-control" name="environment" id="environment">
                                <option value="测试环境">测试环境</option>
                                <option value="预上线环境">预上线环境</option>
                                <option value="线上环境">线上环境</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>管理员账号</label>
                            <input type="text" class="form-control" id="userAccount" name="userAccount" placeholder="请输入管理员账号:"/>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <div class="form-group">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="submit" class="btn btn-primary">提交更改</button>
                        </div>
                    </div>
                </form:form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <h1>添加考试</h1>
    <hr style="height:10px;border:none;border-top:10px groove skyblue;" />

    <%
        String info = "";
        Environment environment = new GetEnvironment().getInfo();
        String userAccount = environment.getUserAccount();
        Map<Object,Object> params = new HashMap<Object, Object>();
        params.put("dc",new Date().getTime());
        params.put("domainCode",new UserInfo(userAccount).getDomainCode());
        params.put("page",1);
        params.put("paperName","");
        params.put("paperType",1);
        params.put("rows",10);
        Request request1 = new Http().setUrl("/ess/service/paper/paperAo!doGetList.do").setParam(params).post();
        String result = request1.getResult();

        int count = Integer.valueOf(JsonHelper.getValue(result,"total").toString().toString());
        if(count == 0) {
            info += "<label>该用户下没有练习题</label>";
        } else if(count == 1) {
            String paper = JsonHelper.getValue(result,"rows").toString();
            paper = paper.substring(1);
            paper = paper.substring(0,paper.length()-1);
            String id = JsonHelper.getValue(paper,"id").toString();
            String name = JsonHelper.getValue(paper,"paperName").toString();
            info += "<option value='" + id + "'>" + name + "</option>";
        } else {
            String[] papers = JsonHelper.getValue(result,"rows").toString().split("},\\{");
            papers[0] += "}";
            papers[0] = papers[0].substring(1);
            papers[papers.length-1] = "{" + papers[papers.length-1];
            papers[papers.length-1] = papers[papers.length-1].substring(0,papers[papers.length-1].length()-1);
            for(int i=1;i<papers.length-1;i++) {
                papers[i] = "{" + papers[i] + "}";
            }

            for (int i=0;i<papers.length;i++) {
                String id = JsonHelper.getValue(papers[i],"id").toString();
                String name = JsonHelper.getValue(papers[i],"paperName").toString();
                info += "<option value='" + id + "'>" + name + "</option>";
            }
        }

    %>
    <form:form id="Form1" action="/exam/addExamPost" method="post" commandName="addCourse" role="form">

        <div class="form-group">
            <label>考试类型</label>
            <select class="form-control" name="examType" id="examType">
                <option value="0">正式考试</option>
                <option value="1">补考考试</option>
            </select>
        </div>

        <div class="form-group">
            <label>语言标签</label>
            <select class="form-control" name="languageType" id="languageType">
                <option value="0">全部</option>
                <option value="1">汉语</option>
                <option value="2">维语</option>
                <option value="3">蒙语</option>
                <option value="4">哈语</option>
            </select>
        </div>

        <div class="form-group">
            <label>请选择为考试关联的试卷</label>
            <select class="form-control" name="examPaper" id="examPaper">
                <%=info%>
            </select>
        </div>

        <div class="alert alert-success">
            <label>默认考试开始时间是当前时间，考试结束时间为1周后</label>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label">考试开始时间</label>
            <div class="input-group date form_datetime col-md-5">
                <input size="16" type="text" id="datetimeStart" readonly class="form-control">
                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label">考试结束时间</label>
            <div class="input-group date form_datetime col-md-5">
                <input size="16" type="text" id="datetimeEnd" readonly class="form-control">
                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
            </div>
        </div>

        <div class="form-group">
            <label>发布目标单位编码(空为不发布)</label>
            <input type="text" class="form-control" id="domainCode" name="domainCode" placeholder="请输入目标单位编码:"/>
        </div>


        <div class="form-group">
            <label>考试添加数量</label>
            <input type="text" class="form-control" id="courseCount" name="courseCount" placeholder="请输入考试添加数量:"/>
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">提交</button>
        </div>
    </form:form>


</div><!-- /.container -->

<script language="JavaScript">
    function isLeapYear(obj) {
        if ( (obj/100)%1 ===0 ){
            return (obj/400)%1 ===0
        } else {
            var a = obj/4;
            var b = obj/100;
            return a%1 === 0 && b%1 !=0
        }
    }
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    var strYear = date.getFullYear();


    var month1 = month;
    var strDate1 = strDate;
    if (month >= 1 && month <= 9) {
        month1 = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate1 = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month1 + seperator1 + strDate1
        + " " + date.getHours() + seperator2 + date.getMinutes();
    $("#datetimeStart").attr('value',currentdate);

    if ( month === 1 || month === 3 || month === 5 || month ===7 || month === 8 || month ===10) {
        if( strDate > 24) {
            strDate = (strDate + 7) - 31;
            month = month + 1;
        } else {
            strDate = strDate + 7;
        }
    } else if(month ===12) {
        if( strDate > 24) {
            strYear = strYear + 1;
            month = 1;
            strDate = (strDate + 7) - 31;
        }else {
            strDate = strDate + 7;
        }
    } else if (month ===2) {
        if( isLeapYear(strYear) ) {
            if ( strDate > 22 ) {
                strDate = (strDate + 7) - 29;
                month = month + 1;
            } else {
                strDate = strDate + 7;
            }
        } else {
            if ( strDate > 21 ) {
                strDate = (strDate + 7) - 28;
                month = month + 1;
            } else {
                strDate = strDate + 7;
            }
        }
    } else {
        if( strDate > 23) {
            strDate = (strDate + 7) - 30;
            month = month + 1;
        }else {
            strDate = strDate + 7;
        }
    }

    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }

    var currentdate = strYear + seperator1 + month + seperator1 + strDate
        + " " + date.getHours() + seperator2 + date.getMinutes();

    $("#datetimeEnd").attr('value',currentdate);
</script>
<script type="text/javascript">
    $('#datetimeStart').datetimepicker({
        language:  'zh-CN',
        format: 'yyyy-mm-dd hh:ii',
        minView:'hour',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
    $('#datetimeEnd').datetimepicker({
        language:  'zh-CN',
        format: 'yyyy-mm-dd hh:ii',
        minView:'hour',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });

    $(document).ready(function() {
        /**
         * 下面是进行插件初始化
         * 你只需传入相应的键值对
         * */
        $('#Form1').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {/*输入框不同状态，显示图片的样式*/
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {/*验证*/
                courseCount: {/*键名username和input name值对应*/
                    message: 'The username is not valid',
                    validators: {
                        notEmpty: {/*非空提示*/
                            message: '课程数量不能为空'
                        },
                        regexp: {/* 只需加此键值对，包含正则表达式，和提示 */
                            regexp: /^[0-9_\.]+$/,
                            message: '只能是数字'
                        },
                        stringLength: {/*长度提示*/
                            min: 1,
                            max: 3,
                            message: '长度必须在1到3之间'
                        }/*最后一个没有逗号*/
                    }
                },
                domainCode: {/*键名username和input name值对应*/
                    message: 'The username is not valid',
                    validators: {
                        regexp: {/* 只需加此键值对，包含正则表达式，和提示 */
                            regexp: /^[0-9]+$/,
                            message: '单位编码只能是数字'
                        },
                        stringLength: {/*长度提示*/
                            min: 15,
                            max: 19,
                            message: '单位编码长度必须在15到19之间'
                        }/*最后一个没有逗号*/
                    }
                }
            }
        });
    });

    $(document).ready(function() {
        /**
         * 下面是进行插件初始化
         * 你只需传入相应的键值对
         * */
        $('#defaultForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {/*输入框不同状态，显示图片的样式*/
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {/*验证*/
                userAccount: {/*键名username和input name值对应*/
                    message: 'The username is not valid',
                    validators: {
                        notEmpty: {/*非空提示*/
                            message: '管理员账号不能为空'
                        },
                        regexp: {/* 只需加此键值对，包含正则表达式，和提示 */
                            regexp: /^[a-zA-Z0-9]+$/,
                            message: '管理员账号只能是数字和字母的组合'
                        },
                        stringLength: {/*长度提示*/
                            min: 2,
                            max: 30,
                            message: '管理员账号长度必须在2到30之间'
                        }/*最后一个没有逗号*/
                    }
                }
            }
        });
    });
</script>
</body>
</html>