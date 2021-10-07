
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>REST风格编程</h3>

<h4>新增</h4>
<form action="/restful/role" method="post">
  名称：<input type="text" name="rname"><br><br>
  年龄：<input type="number" name="age">
  <input type="submit" value="新增">
</form>

<h4>修改</h4>
<form action="/restful/role" method="post">
  <!--指定修改请求方式-->
  <input type="hidden" name="_method" value="PUT">
  名称：<input type="text" name="rname"><br><br>
  年龄：<input type="number" name="age">
  <input type="submit" value="修改">
</form>

<h4>删除</h4>
<form action="/restful/role/1" method="post">
  <!--指定删除请求方式-->
  <input type="hidden" name="_method" value="DELETE">
  <input type="submit" value="删除">
</form>

<h4>查询</h4>
<a href="/restful/role/1">查询</a>

</body>
</html>
