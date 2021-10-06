<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="example/test_1">
    <button>测试_link</button>
</a><br><br>
<%--默认参数类型绑定--%>
<a href="example/defaultParam_1">
    <button>请求转发</button>
</a>
<a href="example/defaultParam_2">
    <button>重定向</button>
</a><br><br>
<%--自定义类型，日期转换--%>
<form action="example/define" method="get">
    日期：<input type="date" name="date">
    <input type="submit" value="日期转换">
</form>
<br>

<%--传入简单数据类型--%>
<form action="example/test_2" method="get">
    角色：<input type="text" name="rolename"><br><br>
    等级：<input type="number" name="grade"><br><br>
    星级：<input type="number" name="star"><br><br>
    <input type="submit" value="一键突破">
</form>
<br>

<%--传入对象数据类型--%>
<form action="example/role" method="post">
    角色：<input type="text" name="rname"><br><br>
    地区：<input type="text" name="area"><br><br>
    年龄：<input type="number" name="age"><br><br>
    星级：<input type="number" name="star"><br><br>
    元素力：<input type="text" name="elementalForce"><br><br>
    <input type="submit" value="一键突破"><br><br>
</form>
<br>

<%--传入复杂数据类型--%>
<form action="example/weapon" method="post">
    <div>
        <div style="float: left;margin:20px;">
            角色：<input type="text" name="rname"><br>
            地区：<input type="text" name="area"><br>
            年龄：<input type="number" name="age"><br>
            星级：<input type="number" name="star"><br>
            元素力：<input type="text" name="elementalForce"><br>
            爱好：<input type="text" name="hobbies"><br>
            <input type="text" name="hobbies">
        </div>
        <div style="float: left;margin:20px;">
            武器：<br><br>
            武器名：<input type="text" name="weapon.wname"><br>
            武器类型：<input type="text" name="wapon.type">
        </div>
        <div style="float: left;margin:20px;">
            List武器库：<br><br>
            武器1名称：<input type="text" name="weaponList[0].wname"><br>
            武器1类型： <input type="text" name="weaponList[0].type"><br><br>
            武器2名称：<input type="text" name="weaponList[1].wname"><br>
            武器2类型 <input type="text" name="weaponList[1].type">
        </div>
        <div style="float: left;margin:20px;">
            Set武器库：<br><br>
            <%--Set集合无序，绑定参数是必须要先初始化--%>
            武器1名称：<input type="text" name="weaponSet[0].wname"><br>
            武器1类型： <input type="text" name="weaponSet[0].type"><br><br>
            武器2名称：<input type="text" name="weaponSet[1].wname"><br>
            武器2类型： <input type="text" name="weaponSet[1].type">
        </div>
        <div style="margin:20px;">
            Map武器库：<br><br>
            武器1名称：<input type="text" name="weaponMap['key1'].wname"><br>
            武器1类型： <input type="text" name="weaponMap['key1'].type"><br><br>
            武器2名称：<input type="text" name="weaponMap['key2'].wname"><br>
            武器2类型： <input type="text" name="weaponMap['key2'].type">
        </div>
    </div>
    <br>
    <input type="submit" value="一键变强">
</form>
</body>
</html>
