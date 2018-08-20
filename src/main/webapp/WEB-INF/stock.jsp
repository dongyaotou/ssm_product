<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/19
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>库存量</title>
</head>
<body>
<script type="text/javascript" src="css/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
function query(){
    //  1:拿到select对象：
var name=document.getElementById("name");
// 2：拿到选中项的索引
var index=name.selectedIndex;
//3:拿到选中项options的value：
var value=name.options[index].value;

var divHtml=document.getElementsByTagName("div");

divHtml.innerText=value;





}



</script>
<h2>查看库存</h2>
<from action="/user/stock">

        商品名称：   <select id="name">
    <c:forEach items="${allProduct}" var="item">
        <option value="${quantity}">${item.productName}</option>
    </c:forEach>
            </select>
<input type="submit" value="查询" onclick="query();"/>
</from>
<div id="content"></div>
</body>
</html>
