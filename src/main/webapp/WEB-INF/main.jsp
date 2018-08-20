<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/17
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript" src="css/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        function exit() {
             var flag=confirm("确认要退出登录吗？");
          //   alert(flag);
            alert(flag);
             if(flag){
                 window.location.href="/index.jsp";

             }else{
                 window.location.href="/user/exit";
             }

        }

    </script>

<style type="text/css">

    #main{
        width:200px;
        height: 200px;

        position: absolute;
        left: 100px;
        left: 200px;
    }
</style>

</head>
<body>
欢迎  ${loginUser.userName}
<a href="javascript:" onclick="exit();">退出登录</a>
<a href="/user/product">销售</a>
<a href="/user/detail">销售信息查询</a>
<a href="/user/stock">查看库存</a>
<div id="main"><h2>欢迎使用小型进销存系统</h2></div>
</body>
</html>
