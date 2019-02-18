<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/header.jsp" %>


<script>
    $(function () {
        $("form.loginForm input").keyup(function () {
            $("div.loginErrorMessageDiv").hide();
        });
        var left = window.innerWidth / 2 + 162;
        $("div.loginSmallDiv").css("left", left);
    })
</script>

<h2>洗衣店管理系统</h2>

<div class="nav bg-primary">
    <span class="pull-left">
        <a href="#">参考价格</a>
    </span>
    <span class="pull-right">
        <a href="registerPage">注册</a>
        <a href="loginPage">登录</a>
    </span>
</div>

<table class="table table-hover">
    <tr>
        <th>ID</th>
        <th>衣物名称</th>
        <th>详细描述</th>
        <th>参考价格</th>
    </tr>
    <c:forEach items="${infos}" var="info">
        <tr>
            <td>${info.infoId}</td>
            <td>${info.name}</td>
            <td>${info.description}</td>
            <td>${info.price}</td>
        </tr>
    </c:forEach>
</table>


<%@include file="include/page.jsp" %>