<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<h2>洗衣店管理系统</h2>

<div class="nav bg-primary">
    <span class="pull-left">
        <a href="userHome">参考价格</a>
        <a href="myVouchers">我的订单</a>
    </span>
    <span class="pull-right">
        <a href="user?userId=${pageContext.session.getAttribute("user").userId}">
            ${pageContext.session.getAttribute("user").username}
        </a>
        <a href="logout">退出</a>
    </span>
</div>