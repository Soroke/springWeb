<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 17/7/1
  Time: 下午5:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../public/public.jsp" %>
<html>
<head>
    <title>test</title>



</head>
<body>



<div class="container">
    <label>环境：</label>
    <label>${environment.environment}</label><br>
    <label>用户：</label>
    <label>${environment.userAccount}</label><br>
</div>


<div class="container">
    <!-- class都是bootstrap定义好的样式，验证是根据input中的name值 -->

    <form:form id="defaultForm" method="post" class="form-horizontal" action="ajaxSubmit.php">
        <!-- 下面这个div必须要有，插件根据这个进行添加提示 -->
        <div class="form-group">
            <label class="col-lg-3 control-label">Username</label>
            <div class="col-lg-5">
                <input type="text" class="form-control" name="username" />
            </div>
        </div>

        <div class="form-group">
            <label class="col-lg-3 control-label">Email address</label>
            <div class="col-lg-5">
                <input type="text" class="form-control" name="email" />
            </div>
        </div>

        <div class="form-group">
            <label class="col-lg-3 control-label">Password</label>
            <div class="col-lg-5">
                <input type="password" class="form-control" name="password" />
            </div>
        </div>

        <div class="form-group">
            <div class="col-lg-9 col-lg-offset-3">
                <button type="submit" class="btn btn-primary">Sign up</button>
            </div>
        </div>
    </form:form>
</div>

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
                username: {/*键名username和input name值对应*/
                    message: 'The username is not valid',
                    validators: {
                        notEmpty: {/*非空提示*/
                            message: '用户名不能为空'
                        },
                        stringLength: {/*长度提示*/
                            min: 6,
                            max: 30,
                            message: '用户名长度必须在6到30之间'
                        }/*最后一个没有逗号*/
                    }
                },
                password: {
                    message:'密码无效',
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 30,
                            message: '用户名长度必须在6到30之间'
                        }
                    }
                },
                email: {
                    validators: {
                        notEmpty: {
                            message: 'The email address is required and can\'t be empty'
                        },
                        emailAddress: {
                            message: 'The input is not a valid email address'
                        }
                    }
                }
            }
        });
    });
</script>

</body>
</html>
