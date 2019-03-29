<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../include/header.jsp" %>


<script>
    $(function () {
        $("#confirmDelete").click(function () {
            window.location.href = 'deleteInfo?infoId=' + $("#deleteInfoId").val();
        })
    });
    function showDeleteModal(infoId) {
        $("#deleteInfoId").val(infoId);
        $("#myModal").modal("show");
    }
</script>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title">确认删除该条记录？</h4>
                <input id="deleteInfoId"type="hidden" value="">
            </div>
            <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                <button id="confirmDelete" class="btn btn-primary" type="button">提交</button>
            </div>
        </div>
    </div>
</div>

<%@include file="nagivator.jsp" %>


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
            <td><a href="editInfoPage?infoId=${info.infoId}"><span class="glyphicon glyphicon-edit"></span></a></td>
            <td><a id="deleteLink" deleteLink="true"><span
                    class="glyphicon glyphicon-trash" onclick="showDeleteModal(${info.infoId})"></span></a></td>
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
                    <td><input name="name" type="text" class="form-control" required="required"></td>
                </tr>
                <tr>
                    <td>衣物描述</td>
                    <td><input name="description" type="text" class="form-control"></td>
                </tr>
                <tr>
                    <td>参考价格</td>
                    <td><input id="price" name="price" type="number" class="form-control" required="required"></td>
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