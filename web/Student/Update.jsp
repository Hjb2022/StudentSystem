<%--
  Created by IntelliJ IDEA.
  User: Huang
  Date: 2023/5/16
  Time: 8:47
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
<div style="padding: 100px 100px 10px;width: 800px;height: 500px;margin: 60px auto auto;background-color: snow" align="center">
    <form action="${pageContext.request.contextPath}/Update" method="get" role="form">
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            学号:
            <input type="text" value="${sno}" name="sno" class="form-control" placeholder="请输入学号" style="width: 350px;height: 30px" >
        </div>
        <br>
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            姓名:
            <input type="text" value="${sname}" name="username" class="form-control" placeholder="请输入姓名" style="width: 350px;height: 30px" >
        </div>
        <br>
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            性别:
            <input type="text" value="${sex}" name="sex" class="form-control"  placeholder="请输入性别" style="width: 350px;height: 30px">
        </div>
        <br>
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
          班级:
            <input type="text" value="${clazz}" name="clazz" class="form-control" placeholder="请输入班级" style="width: 350px;height: 30px">
        </div>
        <br>
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            出生:
            <input type="text" value="${birthday}" name="birthday" class="form-control" placeholder="请输入出生日期" style="width: 350px;height: 30px">
        </div>
        <br>
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            号码:
            <input type="text" value="${tel}" name="tel" class="form-control"  placeholder="请输入号码" style="width: 350px;height: 30px">
        </div>
        <br>
        <div class="input-group">
            <input  type="submit" style="font-size: 20px;width: 200px;font-family:
                 华文宋体" class="btn btn-primary" value="修改" >
        </div>
    </form>
</div>
</body>
</html>
