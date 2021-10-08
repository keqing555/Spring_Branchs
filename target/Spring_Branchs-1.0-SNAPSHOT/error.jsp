<%--
  Created by IntelliJ IDEA.
  User: Jarvis
  Date: 2021/10/7
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>出错了，正在返回主页面...</h3>
</body>
<script>
    setTimeout(back, 2000);
    function back() {
        location.href = "/index.jsp";
    }
</script>
</html>
