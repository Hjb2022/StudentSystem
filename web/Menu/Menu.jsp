<%--
  Created by IntelliJ IDEA.
  User: Huang
  Date: 2023/6/5
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.6.1.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"></script>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .div1{
        background-size: cover;
        background-image: url("/tup/food.jpg");
        /*background-color: gray;*/
    }
    .div2{
        background-size: cover;
        background-image: url("/tup/bj3.jpg");
        /*background-color: gray;*/
    }

</style>
<body>
<div style="width: 100%;height: 100px;background-color:  wheat" class="div1">
    <h1 align="center" style="font-size:50px;font-family: 华文楷体">欢迎来到学生信息管理系统</h1>

    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid" style="background-color: whitesmoke">

            <ul class="nav navbar-nav navbar-right" >
                <li><a  >欢迎用户<span class="glyphicon glyphicon-user"></span >${username}</a></li>
                <li><a href="${pageContext.request.contextPath}/Logout"><span class="glyphicon glyphicon-log-in"></span> 退出</a></li>
            </ul>
        </div>
    </nav>

</div>


<div style="height:800px;width: 400px;margin-right: auto;float: left; " align="center" class="div2" >
    <div style="width: 300px;height: 400px;margin-top: 100px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/Display" target="main">学生信息管理</a><br><br>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/CourseDisplay" target="main">学生课程管理</a><br><br>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/TaskDisplay" target="main">学生成绩管理</a><br><br>
        <a class="btn btn-primary"  href="${pageContext.request.contextPath}/Query/query.jsp" target="main">学生信息查询</a><br><br>
        <a class="btn btn-primary"  href="${pageContext.request.contextPath}/StudentQuery" target="main">学生部分信息</a><br><br>
        <a  class="btn btn-primary" href="${pageContext.request.contextPath}/Admin" >个人用户管理</a><br><br>
    </div>


</div>

<div style="height: 760px;width: 1300px;margin-left: auto;float: left;" >
    <iframe name="main" style="width: 100%;height: 100%;border: 1px solid;" src="${pageContext.request.contextPath}/Display" class="if">

    </iframe>

</div>

</body>
</html>

