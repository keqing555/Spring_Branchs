<%--
  Created by IntelliJ IDEA.
  User: 晚饭-泡面
  Date: 2021/10/8
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        div {
            background-color: burlywood;
        }
    </style>
</head>
<body>
<form action="/annotation/login" method="post">
    用户名：<input type="text" name="username"><br><br>
    密 码： <input type="password" name="password"><br><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
