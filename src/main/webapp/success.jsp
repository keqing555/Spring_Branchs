<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
请求成功！1s后返回...
<br>
model:${requestScope.model}<br>
modelMap:${requestScope.modelMap}<br>
modelAndView:${requestScope.modelAndView}
</body>
<script>
    setTimeout(back,1000);
    function back(){
       location.href="../index.jsp";
    }
</script>
</html>
