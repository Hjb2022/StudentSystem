<%--
  Created by IntelliJ IDEA.
  User: Huang
  Date: 2023/6/3
  Time: 7:40
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.6.1.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background-size: cover;
            background-image: url("/tup/1.jpg");
        }
    </style>
</head>
<body>
<div style="padding: 100px 100px 10px;width: 800px;height: 500px;margin: auto;margin-top: 60px;background-color: snow"align="center">
    <form action="${pageContext.request.contextPath}/AdminUpdate" method="get" role="form">
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            用户名:
            <input type="text" value="${username}" name="username" class="form-control" placeholder="请输入课程号" style="width: 350px;height: 30px" >
        </div>
        <br>
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            密码:
            <input type="text" value="${password1}" name="password" class="form-control" placeholder="请输入课程名" style="width: 350px;height: 30px" >
        </div>
        <br>
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            邮箱:
            <input type="text" value="${email}" name="email" class="form-control"  placeholder="请输入学分数" style="width: 350px;height: 30px">
        </div>
        <br>
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            电话:
            <input type="text" value="${phone}" name="phone" class="form-control" placeholder="请输入学时数" style="width: 350px;height: 30px">
        </div>
        <br>
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            性别:
            <input type="text" value="${sex}" name="sex" class="form-control" placeholder="请输入任课教师" style="width: 350px;height: 30px">
        </div>
        <br>
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            出生日期:
            <input type="text" value="${birthday}" name="birthday" class="form-control" placeholder="请输入任课教师" style="width: 350px;height: 30px">
        </div>
        <br>
        <br>
        <div class="input-group">
            <input  type="submit" style="font-size: 20px;width: 200px;font-family:
                 华文宋体" class="btn btn-primary" value="修改" >
        </div>
    </form>
</div>
</body>
</html>
