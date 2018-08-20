<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/17
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
<style type="text/css">

    #shou{

        margin: 0 auto;
        margin-left: 500px;
        width: 400px;
        height: 300px;
        background-color: green;

    }
    #login{
        position: absolute;

        left:600px;
       top:200px;
        display: block;
        width: 50px;
        height: 50px;
    }



</style>

    <%--表单的非空验证--%>

<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/js/validator.js" charset="UTF-8"></script>
    <script type="text/javascript">
        var con=${con};
        if(con){

            alert("用户名或者密码错误");

        }
    </script>

</head>
<body>
<div id="shou">
<h2>小型进销存储系统</h2>
<form action="/user/login" method="post" name="myform" onSubmit="return checkLogin()">
    用户名：<input name="userName"><br/><br/><br/><%--必须是实体类的属性--%>
    密码：<input  type="password" name="password"><br/>
    <input type="submit" value="登录" id="login">
</form>
</div>


</body>
</html>




