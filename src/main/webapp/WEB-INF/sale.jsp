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
    <title>���۱�</title>
</head>

<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>

<script type="text/javascript">
$(function () {
    var productName= $("[name='goodsName']:checked").val();
    if(productName==null){
        alert("��ѡ����Ʒ");
    }

    var salePrice= $("salePrice").val();
    var salePrice1=parseInt(salePrice);
    if(isNaN(salePrice1)){
        alert("����ӦΪ����");
    }

    var saleNum=$("saleNum").val();
    var saleNum1=parseInt(saleNum);
    if(isNaN(saleNum1)){
        alert("����ӦΪ����");
    }

    var flag=$(flag);
    if(flag){
        alert("���ʧ��")
    }else{
        alert("��ӳɹ�");
    }

})

</script>

<%--onSubmit="return checkSale()"--%>
<body>
<h4>�������</h4>

<form action="/user/sale" method="post" name="sale">

    ��Ʒ���ƣ�<select name="goodsName" id="goodName">
    <option>--��ѡ����Ʒ��--</option>
    <c:forEach items="${allProduct}" var="item">
        <option>${item.productName}</option>
    </c:forEach>
</select>

    ���۵��ۣ�<input type="text" name="salePrice">
    ����������<input type="text" name="saleNum">
    <input type="submit" value="����">

</form>
</body>
</html>
