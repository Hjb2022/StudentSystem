<%--
  Created by IntelliJ IDEA.
  User: Huang
  Date: 2023/5/19
  Time: 15:57
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

<div class="container" align="right">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/Task/TaskInsert.jsp">添加</a>
        </div>
    </div>
</div>
<form action=" " method="get">
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table">
                    <thead>
                    <tr>
                        <th>课程号</th>
                        <th>学号</th>
                        <th>成绩1</th>
                        <th>成绩2</th>
                        <th>成绩3</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}"  var="stu" varStatus="vs"  >
                        <tr <c:if test="${vs.count%2==0}" >class="success"</c:if>>
                            <td>${stu.cno}</td>
                            <td>${stu.sno}</td>
                            <td>${stu.t1}</td>
                            <td>${stu.t2}</td>
                            <td>${stu.t3}</td>
                            <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/TaskDelete?stusno=${stu.sno}">删除</a>
                                <a class="btn btn-primary" href="${pageContext.request.contextPath}/TaskSelect?stusno=${stu.sno}">修改</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</form>
</body>
</html>
