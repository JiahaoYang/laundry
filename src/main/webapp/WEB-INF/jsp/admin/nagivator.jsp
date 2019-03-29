<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<h2>洗衣店管理系统</h2>
<div class="nav bg-primary">
    <span class="pull-left">
        <a href="adminHome">衣物设置</a>
        <a href="listVouchers">订单管理</a>
        <a href="listUsers">会员管理</a>
        <a href="#">统计中心</a>
    </span>
    <span class="pull-right">
        <a href="user?userId=${pageContext.session.getAttribute("user").userId}">
            ${pageContext.session.getAttribute("user").username}
        </a>
        <a href="logout">退出</a>
    </span>
</div>