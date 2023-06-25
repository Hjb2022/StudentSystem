<%--
  Created by IntelliJ IDEA.
  User: Huang
  Date: 2023/5/21
  Time: 16:32
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
    <form action="${pageContext.request.contextPath}/TaskUpdate" method="get" role="form">
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            课程号:
            <input type="text" value="${cno}" name="cno" class="form-control" placeholder="请输入课程号" style="width: 350px;height: 30px" >
        </div>
        <br>
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            学号:
            <input type="text" value="${sno}" name="sno" class="form-control" placeholder="请输入课程名" style="width: 350px;height: 30px" >
        </div>
        <br>
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            成绩1:
            <input type="text" value="${t1}" name="t1" class="form-control"  placeholder="请输入学分数" style="width: 350px;height: 30px">
        </div>
        <br>
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            成绩2:
            <input type="text" value="${t2}" name="t2" class="form-control" placeholder="请输入学时数" style="width: 350px;height: 30px">
        </div>
        <br>
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            成绩3:
            <input type="text" value="${t3}" name="t3" class="form-control" placeholder="请输入任课教师" style="width: 350px;height: 30px">
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
