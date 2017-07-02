<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 17/7/1
  Time: 下午10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- 支持移动设备的缩放 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
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


<!-- 适配移动端浏览器 -->
<script>window.jQuery || document.write('<script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"><\/script>')</script>
</body>
</html>
