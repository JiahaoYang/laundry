<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../include/header.jsp" %>


<%@include file="navigator.jsp" %>


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

<%@include file="../include/page.jsp" %>






