<%--
  Created by IntelliJ IDEA.
  User: Huang
  Date: 2023/5/18
  Time: 22:14
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
    <title>$Title$</title>
    <style>
        body{
            background-size: cover;
            background-image: url("/tup/1.jpg");
        }
    </style>

    <script>
        function CheckCourse(){
            cno1=document.getElementsByName("cno")
            $.get("http://localhost:8080/StudentSystem_war_exploded/CourseAjax",
                {
                    cno:cno1[0].value
                },
                function (data,status){
                    if(data.cno){
                        alert("该课程号已被添加了")
                    }
                });
        }
    </script>
</head>
<body>
<div style="padding: 100px 100px 10px;width: 800px;height: 500px;margin: auto;margin-top: 60px;background-color: snow"align="center">
    <form action="${pageContext.request.contextPath}/CourseInsert" method="get">
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            课程号:
            <input type="text"  name="cno"  class="form-control" placeholder="请输入课程号" id="cno" onchange="CheckCourse()"  style="width: 350px;height: 30px"  >
        </div>
        <br>
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            课程名:
            <input type="text" id="username" name="cname" class="form-control" placeholder="请输入课程名" style="width: 350px;height: 30px" >
        </div>
        <br>
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            学分数:
            <input type="text"  name="score" class="form-control"  placeholder="请输入学分数" style="width: 350px;height: 30px">
        </div>
        <br>
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            学时数:
            <input type="text"  name="xs" class="form-control" placeholder="请输入学时数" style="width: 350px;height: 30px">
        </div>
        <br>
        <div class="input-group" style="font-size: 25px;font-family: 华文宋体">
            任课教师:
            <input type="text"  name="teacher" class="form-control" placeholder="请输入任课教师" style="width: 350px;height: 30px">
        </div>
        <br>
        <div class="input-group">
            <input  type="submit" style="font-size: 20px;width: 200px;font-family:
                 华文宋体" class="btn btn-primary" value="确定添加" >
        </div>
    </form>
</div>
</body>
</html>
