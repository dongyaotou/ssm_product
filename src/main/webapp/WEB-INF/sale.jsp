<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/18
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page language="java" import="java.util.*" pageEncoding="GB2312" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>销售表</title>
</head>

<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>

<script type="text/javascript">
$(function () {
    var productName= $("[name='goodsName']:checked").val();
    if(productName==null){
        alert("请选择商品");
    }

    var salePrice= $("salePrice").val();
    var salePrice1=parseInt(salePrice);
    if(isNaN(salePrice1)){
        alert("单价应为数字");
    }

    var saleNum=$("saleNum").val();
    var saleNum1=parseInt(saleNum);
    if(isNaN(saleNum1)){
        alert("数量应为数字");
    }

    var flag=$(flag);
    if(flag){
        alert("添加失败")
    }else{
        alert("添加成功");
    }

})

</script>

<%--onSubmit="return checkSale()"--%>
<body>
<h4>添加销售</h4>

<form action="/user/sale" method="post" name="sale">

    商品名称：<select name="goodsName" id="goodName">
    <option>--请选择商品名--</option>
    <c:forEach items="${allProduct}" var="item">
        <option>${item.productName}</option>
    </c:forEach>
</select>

    销售单价：<input type="text" name="salePrice">
    销售数量：<input type="text" name="saleNum">
    <input type="submit" value="保存">

</form>
</body>
</html>
