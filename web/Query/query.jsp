<%--
  Created by IntelliJ IDEA.
  User: Huang
  Date: 2023/5/20
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.6.1.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"></script>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background-size: cover;
            background-image: url("/tup/bj3.jpg");
        }
    </style>
</head>
<body>
<div>

    <div style="width: 100%;height: 50px;">
        <table style="width: 100%;height: 50px;">
            <tr>
                <form action="${pageContext.request.contextPath}/Query" method="get">
                    <td align="right"> <input type="text" name="username"></td>
                    <td align="left">  <input type="submit" class="btn btn-primary" value="按学号查询"></td>
                </form>

                <form action="${pageContext.request.contextPath}/QueryUsername" method="get">
                <td  align="right"> <input type="text" name="username"></td>
                <td align="left"> <input type="submit" class="btn btn-primary" value="按姓名查询"></td>
                </form>
            </tr>
        </table>
    </div>

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table">
                    <thead>
                    <tr>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>班级</th>
                        <th>课程名</th>
                        <th>成绩1</th>
                        <th>成绩2</th>
                        <th>成绩3</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${sno1}</td>
                        <td>${sname}</td>
                        <td>${clazz}</td>
                        <td>${cname}</td>
                        <td>${t1}</td>
                        <td>${t2}</td>
                        <td>${t3}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>

</body>
</html>
