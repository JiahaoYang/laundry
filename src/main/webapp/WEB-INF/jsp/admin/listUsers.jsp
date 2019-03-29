<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../include/header.jsp" %>
<%@include file="nagivator.jsp" %>


<table class="table table-hover">
    <tr>
        <th>用户名</th>
        <th>用户类型</th>
        <th>性别</th>
        <th>联系方式</th>
        <th>住址</th>
        <th>余额</th>
        <th>总消费</th>
        <th>消费次数</th>
        <th>注册日期</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>${user.userType}</td>
            <td>${user.gender}</td>
            <td>${user.phone}</td>
            <td>${user.address}</td>
            <td>${user.balance}</td>
            <td>${user.totalConsume}</td>
            <td>${user.consumeTimes}</td>
            <td>${f:formatLocalDateTime(user.registerDate, 'yyyy-MM-dd HH:mm:ss')}</td>
        </tr>
    </c:forEach>
</table>

<%@include file="../include/page.jsp" %>