<%--
  Created by IntelliJ IDEA.
  User: Huang
  Date: 2023/6/5
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
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
            background-image: url("/tup/nba1.jpg");

        }
        .w{
            width: 38%;
            margin: 300px auto 0;
        }
        .banner{
            height: 350px;
            background-color: wheat;

        }
        .tb{

            width:35%;
            margin: 70px auto 0;
            height:100px;
        }
    </style>
    <script>
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/LoginGo" method="post">
    <div class="banner w">
        <p style="text-align: center;font-size: 30px;font-family: 华文宋体">登录</p>
        <table class="tb" style="width:70%;height: 200px">
            <tr>
                <td style="font-size: 25px;text-align: right;font-family: 华文楷体">用户名:</td>
                <td><input type="text"  name="username" id="username" style="height: 30px;width: 100%;"  placeholder="请输入用户名" onchange="CherkErro()"></td>
            </tr>
            <tr>
                <td style="font-size: 25px;text-align: right;font-family: 华文楷体">密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
                <td><input name="password"  type="password" style="height: 25px;width: 100%"  placeholder="请输入密码"
                           id="password" ></td>
            </tr>
            <tr>
                <td colspan="2" style="width: 100%">
                    <input src="c" type="submit" style="font-size: 20px;width: 100%;font-family:
                 华文宋体" class="btn btn-primary" value="登录" >
                </td>
            </tr>

            <tr>
                <td>忘记密码?</td>
                <td style="text-align: right">没有账号,<a href="${pageContext.request.contextPath}/Admin/Register.jsp">立即注册</a></td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>

