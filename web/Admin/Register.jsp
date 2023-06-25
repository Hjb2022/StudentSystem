<%--
  Created by IntelliJ IDEA.
  User: Huang
  Date: 2023/5/10
  Time: 22:12
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
    <style>
        body{
            background-image: url("/tup/1.jpg");
            background-size: cover;

        }
        .rg_layout{
            /*border: 3px solid lawngreen;*/
            width: 900px;
            height: 500px;
            background: wheat;
            margin: auto;
            margin-top: 100px;
        }
        .rg_left{
            /*border: 1px solid black;*/
            float: left;
            margin-left: 20px;
        }
        .rg_right{
            /*border: 1px solid black;*/
            float: right;
            margin-top: 400px;
            padding-top: 20px;

        }
        .rg_center{
            /*border: 1px solid black;*/
            width: 400px;
            height: 450px;
            margin-left: 150px;
            margin-top: 20px;
            float: left;
        }

        .td_left{
            width:100px;
            text-align: right;
            height:40px;
            font-family: 华文楷体;
            font-size: 20px;
        }
        .td_right{
            padding-left: 30px;
        }
        #username,#password,#name,#email,#tel,#birth,#check{
            width: 200px;
            height: 30px;
            border:1px solid gold;
            border-radius: 5px;/*设置为圆角*/
            padding-left:15px;
        }
        #check{
            width: 100px;
        }
        #check_jpg{
            width: 100px;
            height: 30px;
            vertical-align: middle;/*垂直居中*/
        }


    </style>
    <script>
        function chekUsername(){
            username1=document.getElementsByName("username")
         $.get("http://localhost:8080/StudentSystem_war_exploded/RegisterAjax",
             {
             username:username1[0].value
             },
         function (data,status){
             if(data.username){
                 alert("该用户已被注册了")
             }
         });

        }
    </script>
</head>
<body>
<div class="rg_layout">
    <div class="rg_left">
        <p>新用户注册</p>
    </div>
    <div class="rg_center">
        <form action="${pageContext.request.contextPath}/Register" method="post">
            <table>
                <tr>
                    <td class="td_left">用户名</td>
                    <td class="td_right"><input type="text" name="username" placeholder="请输入用户名" id="username" onchange="chekUsername()"></td>
                </tr>
                <tr>
                    <td class="td_left">密码</td>
                    <td class="td_right"><input type="password" name="password" placeholder="请输入密码" id="password"></td>
                </tr>
                <tr>
                    <td class="td_left">E_mail</td>
                    <td class="td_right"><input type="text" name="email" placeholder="请输入邮箱" id="email"></td>
                </tr>
                <tr>
                    <td class="td_left">手机号</td>
                    <td class="td_right"><input type="text" name="phone" placeholder="请输入手机号" id="tel"></td>
                </tr>
                <tr>
                    <td class="td_left">性别</td>
                    <td class="td_right"><input type="radio" name="sex" value="male">男
                        <input type="radio" name="sex" value="female">女</td>
                </tr>
                <tr>
                    <td class="td_left">出生日期</td>
                    <td class="td_right"><input type="date" name="birthday" id="birth"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="注册" id="regist" class="btn btn-primary"></td>
                </tr>
            </table>
        </form>
    </div>
    <div class="rg_right">已有账号？<a href="${pageContext.request.contextPath}/Admin/Login.jsp">点击登录</a></div>
</div>
</body>
</html>
