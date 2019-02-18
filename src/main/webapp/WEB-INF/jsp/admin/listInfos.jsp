<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../include/header.jsp" %>

<h2>洗衣店管理系统</h2>

<div class="nav bg-primary">
    <span class="pull-left">
        <a href="#">衣物设置</a>
        <a href="#">收衣</a>
        <a href="#">取衣</a>
        <a href="#">会员管理</a>
        <a href="#">统计中心</a>
    </span>
    <span class="pull-right">
        <a href="#">你好XXX</a>
        <a href="#">退出</a>
    </span>
</div>

<table class="table table-hover">
    <tr>
        <th>ID</th>
        <th>衣物名称</th>
        <th>详细描述</th>
        <th>参考价格</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>
    <c:forEach items="${infos}" var="info">
        <tr>
            <td>${info.infoId}</td>
            <td>${info.name}</td>
            <td>${info.description}</td>
            <td>${info.price}</td>
            <td><a href="editInfo?infoId=${info.infoId}"><span class="glyphicon glyphicon-edit"></span></a></td>
            <td><a deleteLink="true" href="deleteInfo?infoId=${info.infoId}"><span
                    class="glyphicon glyphicon-trash"></span></a></td>
        </tr>
    </c:forEach>
</table>

<div class="panel panel-warning addDiv">
    <div class="panel-heading">新增衣物</div>
    <div class="panel-body">
        <form method="post" id="addForm" action="addInfo">
            <table class="addTable">
                <tr>
                    <td>衣物名称</td>
                    <td><input name="name" type="text" class="form-control"></td>
                </tr>
                <tr>
                    <td>衣物描述</td>
                    <td><input name="description" type="text" class="form-control"></td>
                </tr>
                <tr>
                    <td>参考价格</td>
                    <td><input name="price" type="text" class="form-control"></td>
                </tr>
                <tr class="submitTR">
                    <td colspan="2" align="center">
                        <button type="submit" class="btn btn-success">提 交</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

<%@include file="../include/page.jsp" %>