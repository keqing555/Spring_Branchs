<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>Title</title>
    <%--引入jQuery
        可能会不奏效，Rebuild Project--%>
    <script src="js/jquery-3.6.0.js"></script>

    <style>
        div {
            background-color: burlywood;
        }
    </style>
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
</a>
<a href="example/model">
    <button>ModelAndView</button>
</a>
<a href="html/static_resource_page.html">
    <button>访问静态资源</button>
</a>
<hr>
<a href="annotation/ann">
    <button>默认参数</button>
</a>
<a href="annotation/ann2">
    <button>获取请求头</button>
</a>
<button onclick="sendRole()">Ajax请求</button>
<a href="annotation/cookie">
    <button>Cookie</button>
</a>
<a href="annotation/publicParam">
    <button>公共参数</button>
</a>
<a href="annotation/session">
    <button>session域</button>
</a>
<hr>
<a href="/REST.jsp">
    <button>RESTful</button>
</a>
<a href="/data/json">
    <button>json</button>
</a>
<a href="/data/forward">
    <button>forward</button>
</a>
<a href="/data/redirect?data=刻晴">
    <button>redirect</button>
</a>


<br><br>
<%--自定义类型，日期转换--%>
<form action="example/define" method="get">
    日期：<input type="date" name="date">
    <input type="submit" value="日期转换">
</form>


<%--传入简单数据类型--%>
<form action="example/test_2" method="get">
    <div style="float: left;margin-right:100px;">
        <hr>
        角 色：<input type="text" name="rolename"><br><br>
        等 级：<input type="number" name="grade"><br><br>
        星 级：<input type="number" name="star"><br><br>
        <input type="submit" value="一键突破">
    </div>
</form>

<%--传入对象数据类型--%>
<form action="example/role" method="post">
    <div style="float: left;margin-right:100px;">
        <hr>
        角 色：<input type="text" name="rname"><br><br>
        地 区：<input type="text" name="area"><br><br>
        年 龄：<input type="number" name="age"><br><br>
        星 级：<input type="number" name="star"><br><br>
        元素力：<input type="text" name="elementalForce"><br><br>
        <input type="submit" value="一键突破">
    </div>
</form>

<%--传入复杂数据类型--%>
<form action="example/weapon" method="post">
    <div style="clear:left;float:left;margin:10px;">
        <hr>
        角 色：<input type="text" name="rname"><br>
        地 区：<input type="text" name="area"><br>
        年 龄：<input type="number" name="age"><br>
        星 级：<input type="number" name="star"><br>
        元素力：<input type="text" name="elementalForce"><br>
        爱 好：<input type="text" name="hobbies"><br>
        <input type="text" name="hobbies"><br><br>
        <input type="submit" value="一键变强">
    </div>
    <div style="float: left;margin:10px;">
        武器：<br><br>
        武器名称：<input type="text" name="weapon.wname"><br>
        武器类型：<input type="text" name="wapon.type">
        <hr>
    </div>
    <div style="float: left;margin:10px;">
        List武器库：<br><br>
        武器1名称：<input type="text" name="weaponList[0].wname"><br>
        武器1类型：<input type="text" name="weaponList[0].type"><br><br>
        武器2名称：<input type="text" name="weaponList[1].wname"><br>
        武器2类型：<input type="text" name="weaponList[1].type">
        <hr>
    </div>
    <div style="float: left;margin:10px;">
        Set武器库：<br><br>
        <%--Set集合无序，绑定参数是必须要先初始化--%>
        武器1名称：<input type="text" name="weaponSet[0].wname"><br>
        武器1类型：<input type="text" name="weaponSet[0].type"><br><br>
        武器2名称：<input type="text" name="weaponSet[1].wname"><br>
        武器2类型：<input type="text" name="weaponSet[1].type">
        <hr>
    </div>
    <div style="float: left;margin:10px;">
        Map武器库：<br><br>
        武器1名称：<input type="text" name="weaponMap['key1'].wname"><br>
        武器1类型：<input type="text" name="weaponMap['key1'].type"><br><br>
        武器2名称：<input type="text" name="weaponMap['key2'].wname"><br>
        武器2类型：<input type="text" name="weaponMap['key2'].type">
        <hr>
    </div>
</form>

<%--获取请求体--%>
<form action="annotation/ann3" method="post">
    <div style="clear:left;float:left;margin:10px;">
        名称：<input type="text" name="username"><br><br>
        密码：<input type="password" name="password"><br>
        <input type="submit" value="登录">
    </div>
</form>

</body>
<script>

    // testLink();
    //
    // function testLink() {
    //     location.href = "example/test_1";
    //
    // }

    function sendRole() {
        $.ajax({
            type: "POST",
            url: "annotation/ann4",
            data: '{"rname":"刻晴","star":"5星","elementalForce":"雷系"}',
            contentType: "application/json",    //设置数据格式
            success: function (msg) {
                alert(msg);
            }
        });
    }
</script>
</html>
