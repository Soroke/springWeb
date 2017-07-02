<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="public/public.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>测试页</title>

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
                <form:form id="defaultForm" action="/settingEnvironmentPost" method="post" commandName="settingEnvironment" role="form">

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


    <hr style="height:10px;border:none;border-top:10px groove skyblue;" />

    <div class="starter-template">
        <h1>学法平台数据添加</h1>
        <p class="lead"><br>😁😌❤️👏😘😙😋😝🚪🏡🍚😁🚘🚴</p>
    </div>


</div><!-- /.container -->
<script type="text/javascript">
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
