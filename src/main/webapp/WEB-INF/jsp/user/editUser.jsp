<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../include/header.jsp" %>
<script src="js/script.js"></script>
<script>
    $(function () {
        <c:if test="${!empty user.gender}">
            $("#gender").val("${user.gender}");
        </c:if>

        $("#username").blur(function () {
            var user = {"username": $("#username").val(), "oldName": $("#oldName").val()};
            $.ajax(
                {
                    url: "checkName_",
                    type: "post",
                    data: user,
                    success: function (data) {
                        if (data === "exist") {
                            $("#errorMessage").text("用户名已存在");
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

        $("#oldPassword").blur(function () {
            var user = {"username": $("#name").val(), "password": $("#oldPassword").val()};
            $.ajax(
                {
                    url: "checkPassword",
                    type: "post",
                    data: user,
                    success: function (data) {
                        if (data === "wrong") {
                            $("#errorMessage").text("密码错误");
                            $("#errorDiv").show();
                            $("#editPasswordBtn").attr("disabled", true);

                        } else {
                            $("#errorDiv").hide();
                            $("#editPasswordBtn").attr("disabled", false);
                        }
                    }
                }
            )
        });
    });

</script>

<%@include file="navigator.jsp" %>
<br>
<br>

<div style="max-width:400px;margin:100px auto;" id="userDiv">

    <div id="errorDiv" style="display:none" class="alert alert-danger alert-dismissable">
        <span id="errorMessage"></span>
    </div>

    <ul class="nav nav-tabs">
        <li role="presentation" id="userInfoTab" class="active"><a href="#userInfoDiv" data-toggle="tab" onclick="$('#errorDiv').hide()">个人信息</a></li>
        <li role="presentation" id="passwordTab"><a href="#passwordDiv" data-toggle="tab" onclick="$('#errorDiv').hide()">修改密码</a></li>
        <li role="presentation" id="balanceTab"><a href="#balanceDiv" data-toggle="tab" onclick="$('#errorDiv').hide()">账户信息</a></li>
    </ul>

    <div class="tab-content">
        <div id="userInfoDiv" class="tab-pane fade in active">
            <form method="post" action="editUser">
                <br>
                <br>
                <input name="userId" type="hidden" value="${user.userId}">
                <input id="oldName" name="oldName" type="hidden" value="${user.username}">
                <input id="username" name="username" class="form-control" placeholder="用户名" required="required" value="${user.username}">
                <br>
                <input name="userType" class="form-control" placeholder="用户类型" value="${user.userType}" readonly="readonly">
                <br>
                <select class="form-control" name="gender" id="gender">
                    <option value="">性别（选填）</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>                <br>
                <input id="phone" name="phone" class="form-control" placeholder="联系方式（选填）" value="${user.phone}">
                <br>
                <input name="address" class="form-control" placeholder="地址（选填）" value="${user.address}">
                <br>
                <br>
                <button class="btn btn-lg btn-info btn-block " id="editUserBtn" type="submit">更新</button>
            </form>
        </div>

        <div id="passwordDiv" class="tab-pane fade">
            <form method="post" action="editPassword">
                <br/>
                <br/>
                <input id="name" name="username" type="hidden" value="${user.username}">
                <input type="password" id="oldPassword" name="oldPassword" class="form-control" placeholder="旧密码" required="required">
                <br>
                <input type="password" name="password" class="form-control" placeholder="新密码" required="required">
                <br/>
                <br/>
                <button class="btn btn-lg btn-info btn-block " id="editPasswordBtn" type="submit">更新</button>
            </form>
        </div>



        <div id="balanceDiv" class="tab-pane fade">
            <br>
            <label>账户余额</label>
            <input name="balance" class="form-control" placeholder="账户余额" value="${user.balance}" readonly="readonly">
            <br>
            <label>消费总额</label>
            <input name="totalConsume" class="form-control" placeholder="消费总额" value="${user.totalConsume}" readonly="readonly">
            <br>
            <label>消费次数</label>
            <input name="consumeTimes" class="form-control" placeholder="消费次数" value="${user.consumeTimes}" readonly="readonly">
            <br>
        </div>
    </div>
</div>

