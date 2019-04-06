<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../include/header.jsp" %>
<script>
    $(function () {

        $("#username").blur(function () {
            var user = {"username": $("#username").val()};
            $.ajax(
                {
                    url: "checkExist",
                    type: "post",
                    data: user,
                    success: function (data) {
                        if (data === "unknown") {
                            $("#errorMessage").text("用户不存在");
                            $("#errorDiv").show();
                            $("#editUserBtn").attr("disabled", true);

                        } else {
                            $("#errorDiv").hide();
                            $("#editUserBtn").attr("disabled", false);
                        }
                    }
                }
            )
        });
    });

</script>

<%@include file="nagivator.jsp" %>
<br>
<br>

<div class="panel panel-warning addDiv">

    <div id="errorDiv" style="display:none" class="alert alert-danger alert-dismissable">
        <span id="errorMessage"></span>
    </div>

    <div class="panel-heading">收衣清单</div>
    <div class="panel-body">
        <form method="post" id="addForm" action="getClothes">
            <input id="username" required="required" placeholder="洗衣用户" name="username" class="form-control">
            <br>
            <c:forEach begin="1" end="${num}" step="1">
                <table class="addTable">
                    <tr>
                        <td>衣物名称</td>
                        <td><input name="clothesName" class="form-control" required="required" placeholder="必填"></td>
                    </tr>
                    <tr>
                        <td>衣物品牌</td>
                        <td><input name="brand" class="form-control" placeholder="选填"></td>
                    </tr>
                    <tr>
                        <td>衣物颜色</td>
                        <td><input name="color" class="form-control" placeholder="选填"></td>
                    </tr>
                    <tr>
                        <td>瑕疵描述</td>
                        <td><input name="flaw" class="form-control" placeholder="必填"></td>
                    </tr>
                    <tr>
                        <td>服务名称</td>
                        <td><input name="serverName" class="form-control" required="required" placeholder="必填"></td>
                    </tr>
                    <tr>
                        <td>单价</td>
                        <td><input name="washPrice" type="number" class="form-control" required="required"
                                   oninput="this.value = this.value.replace(/[^0-9]/g, '');" placeholder="必填"></td>
                    </tr>
                </table>
                <br>
                <br>
            </c:forEach>
            <button id="editUserBtn" type="submit" class="btn btn-success btn-lg btn-block">提 交</button>
        </form>
    </div>
</div>
