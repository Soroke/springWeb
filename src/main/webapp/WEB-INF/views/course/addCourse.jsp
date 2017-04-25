<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 17/4/25
  Time: 下午9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>添加课程</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <!-- 支持移动设备的缩放 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <script type="text/javascript">
        function tishi()
        {
            alert($(msg))
        }
    </script>
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
                <li class="active"><a href="/course/addCourse">学习模块</a></li>
                <li><a href="/">仁</a></li>
                <li><a href="/">坤</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container">
    <h1>添加课程</h1>
    <hr style="height:10px;border:none;border-top:10px groove skyblue;" />

    <form:form action="/course/addCoursePost" method="post" commandName="addCourse" role="form">
        <div class="form-group">
            <label>管理员账号</label>
            <input type="text" class="form-control" id="userAccount" name="userAccount" placeholder="请输入管理员账号:"/>
        </div>

        <div class="form-group">
            <label>课程类型</label>
            <select class="form-control" name="courseType" id="courseType">
                <option value="0">必修课</option>
                <option value="1">选修课</option>
            </select>
        </div>
        <div class="form-group">
            <label>课程添加数量</label>
            <input type="text" class="form-control" id="courseCount" name="courseCount" placeholder="请输课程添加数量:"/>
        </div>
        <div class="form-group"></div>
        <div class="form-group"></div>

        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">提交</button>
        </div>
    </form:form>

    <h1>添加一个课程并为其添加课件</h1>
    <hr style="height:10px;border:none;border-top:10px groove skyblue;" />

    <form:form action="/course/addCoursePost1" method="post" commandName="addCourse1" role="form">
        <div class="form-group">
            <label>管理员账号</label>
            <input type="text" class="form-control" id="userAccount1" name="userAccount" placeholder="请输入管理员账号:"/>
        </div>

        <div class="form-group">
            <label>课程类型</label>
            <select class="form-control" name="courseType" id="courseType1">
                <option value="0">必修课</option>
                <option value="1">选修课</option>
            </select>
        </div>
        <div class="form-group">
            <label>为该课程添加课件数量</label>
            <input type="text" class="form-control" id="coursewareCount" name="coursewareCount" placeholder="请输为课程添加课件的数量:"/>
        </div>
        <div class="form-group"></div>
        <div class="form-group"></div>

        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success" onclick="tishi()">提交</button>
        </div>
    </form:form>


</div><!-- /.container -->

</body>
</html>