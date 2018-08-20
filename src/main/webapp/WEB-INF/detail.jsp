<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/19
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--要放在head标签中--%>
    <link href="/js/bootstrap.min.css"/>
</head>
<body>

<%--创建表格--%>
<table border="1px">
    <thead>
    <tr>
        <th>ID</th>
        <th>商品</th>
        <th>单价</th>
        <th>数量</th>
        <th>总价</th>
        <th>销售日期</th>
        <th>销售员</th>
    </tr>
    </thead>

    <%--下面要显示的信息--%>

    <tbody id="content">

    </tbody>
    <tr>
        <td>ID</td>
        <td>商品</td>
        <td>单价</td>
        <td>数量</td>
        <td>总价</td>
        <td>销售日期</td>
        <td>销售员</td>
    </tr>

    </table>
<div class="pagination" id="pagination"></div>



</body>



<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>

<script type="text/javascript" src="/js/jquery.pagination.js"></script>

<script type="text/javascript">
    loadData(0);//当前是第几页
    /*ajax中的参数是用逗号进行分割的*/
function loadData(pageNum) {
    $.ajax({
        url:"/user/saleDetail",
        type:"post",
        data:{"pageNum":pageNum},
        success:function(data){
            //清空tbody中的内容
            $("#content").html("");
            //遍历数据
            $.each(data.list,function(i,dom){
                $("#content").append("  <tr>\n" +
                    "        <td>"+dom.id+"</td>\n" +
                    "        <td>"+dom.product+"</td>\n" +
                    "        <td>"+dom.price+"</td>\n" +
                    "        <td>"+dom.quantity+"</td>\n" +
                    "        <td>"+dom.totalPrice+"</td>\n" +
                    "        <td>"+dom.date+"</td>\n" +
                    "        <td>"+dom.name+"</td>\n" +
                    "    </tr>");
            })
            //使用pagination插件
            $("#pagination").pagination(data.total,{

                current_page:data.pageNum,//当前页
                items_per_page:data.pageSize,//总页数
                prev_text:"上一页",
                next_text:"下一页",
                callback:loadData  //回调函数



            })

        } //success结束的标志


    })
}

</script>


</html>
