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
  Date: 17/4/25
  Time: 下午9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../public/public.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>添加课程</title>
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
                <form:form id="defaultForm" action="/course/settingEnvironmentPost" method="post" commandName="settingEnvironment" role="form">

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

    <h1>添加课程</h1>
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
        params.put("paperType",0);
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
            info += "<label class='checkbox-inline'><input type='checkbox' name='paper1' value='" + id + "'>" + name + "</label>";
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
                info += "<label class='checkbox-inline'><input type='checkbox' name='paper" + (i+1) + "' value='" + id + "'>" + name + "</label>";
            }
        }

    %>
    <form:form id="Form1" action="/course/addCoursePost" method="post" commandName="addCourse" role="form">

        <div class="form-group">
            <label>课程类型</label>
            <select class="form-control" name="courseType" id="courseType">
                <option value="0">必修课</option>
                <option value="1">选修课</option>
            </select>
        </div>
        <div class="form-group">
            <label>请选择为课程添加的课件(不选为不添加)</label>
            <div class="alert alert-info">
                <label class="checkbox-inline">
                    <input type="checkbox" id="plaintext" name="plaintext" value=1>纯文字课件
                </label>
                <label class="checkbox-inline">
                    <input type="checkbox" id="imagetext" name="imagetext" value=1>图文课件
                </label>
                <label class="checkbox-inline">
                    <input type="checkbox" id="image" name="image" value=1>图片课件
                </label>
                <label class="checkbox-inline">
                    <input type="checkbox" id="video" name="video" value=1>视频课件
                </label>
            </div>
        </div>

        <div class="form-group">
            <label>请选择为课程关联的练习题(不选为不添加)</label>
            <div class="alert alert-success">
               <%=info%>
            </div>
        </div>

        <div class="form-group">
            <label>发布目标单位编码(空为不发布)</label>
            <input type="text" class="form-control" id="domainCode" name="domainCode" placeholder="请输入目标单位编码:"/>
        </div>


        <div class="form-group">
            <label>课程添加数量</label>
            <input type="text" class="form-control" id="courseCount" name="courseCount" placeholder="请输入课程添加数量:"/>
        </div>
        <div class="form-group"></div>
        <div class="form-group"></div>

        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">提交</button>
        </div>
    </form:form>


</div><!-- /.container -->

<script type="text/javascript">
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