<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>测试页</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <!-- 支持移动设备的缩放 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">测试项目</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/course/addCourse">学习模块</a></li>
                <li><a href="/">仁</a></li>
                <li><a href="/">坤</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container">
    <h1>设置环境和管理员账号</h1>
    <hr style="height:10px;border:none;border-top:10px groove skyblue;" />

    <form:form action="/settingEnvironmentPost" method="post" commandName="settingEnvironment" role="form">

        <div class="form-group">
            <label>请选择学法平台环境</label>
            <select class="form-control" name="environment" id="environment">
                <option value="0">测试环境</option>
                <option value="1">预上线环境</option>
                <option value="2">线上环境</option>
            </select>
        </div>

        <div class="form-group">
            <label>管理员账号</label>
            <input type="text" class="form-control" id="userAccount" name="userAccount" placeholder="请输入管理员账号:"/>
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">保存</button>
        </div>
    </form:form>
</div><!-- /.container -->
<!-- 适配移动端浏览器 -->
<script>window.jQuery || document.write('<script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"><\/script>')</script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
