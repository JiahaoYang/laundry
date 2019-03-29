<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../include/header.jsp" %>


<%@include file="nagivator.jsp" %>
<br>
<br>

<div class="panel panel-warning addDiv">
    <div class="panel-heading">修改衣物</div>
    <div class="panel-body">
        <form method="post" id="editForm" action="editInfo">
            <table class="editTable">
                <tr>
                    <td>衣物名称</td>
                    <td><input name="name" class="form-control" required="required" value="${info.name}"></td>
                </tr>
                <tr>
                    <td>衣物描述</td>
                    <td><input name="description" type="text" class="form-control" value="${info.description}"></td>
                </tr>
                <tr>
                    <td>参考价格</td>
                    <td><input name="price" type="number" class="form-control" required="required" value="${info.price}"></td>
                </tr>
                <tr class="submitTR">
                    <td colspan="2" align="center">
                        <input type="hidden" name="infoId" value="${info.infoId}">
                        <button type="submit" class="btn btn-success">提 交</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>