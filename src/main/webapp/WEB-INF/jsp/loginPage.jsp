<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/header.jsp" %>
<script src="js/script.js"></script>
<script>
    $(function () {
        <c:if test="${!empty msg}">
        $("#errorMessage").text("${msg}");
        $("#errorDiv").show();
        </c:if>

        $("#registerName").blur(function() {
            var user = {"username": $("#registerName").val()};
            $.ajax(
                {
                    url: "checkName",
                    type: "post",
                    data: user,
                    success: function(data) {
                        if (data === "exist") {
                            $("#errorMessage").text("用户名已存在");
                            $("#errorDiv").show();
                            $("#registerBtn").attr("disabled", true);

                        } else {
                            $("#errorDiv").hide();
                            $("#registerBtn").attr("disabled", false);
                        }
                    }
                }
            )
        });
    });

</script>


<h2>洗衣店管理系统</h2>

<div class="nav bg-primary">
    <span class="pull-right">
        <a href="#">注册</a>
        <a href="#">登录</a>
    </span>
</div>

<div style="max-width:400px;margin:100px auto;" id="loginRegisterDiv">

    <div id="errorDiv" style="display:none" class="alert alert-danger alert-dismissable">
        <span id="errorMessage"></span>
    </div>

    <ul class="nav nav-tabs">
        <li role="presentation" id="loginTab" class="active"><a href="#loginDiv" data-toggle="tab">登录</a></li>
        <li role="presentation" id="registerTab"><a href="#registerDiv" data-toggle="tab">注册</a></li>
    </ul>

    <div class="tab-content">
        <div id="loginDiv" class="tab-pane fade in active">
            <form method="post" action="login">
                <br>
                <br>
                <input name="username" class="form-control" placeholder="用户名" required="required">
                <br>
                <input type="password" name="password" class="form-control" placeholder="密码" required="required">

                <br/>
                <br/>
                <button class="btn btn-lg btn-info btn-block " type="submit">登录</button>
            </form>
        </div>

        <div id="registerDiv" class="tab-pane fade">
            <form method="post" action="register">
                <br/>
                <br/>
                <input id="registerName" name="username" class="form-control" placeholder="用户名" required="required">
                <br>
                <input type="password" name="password" class="form-control" placeholder="密码" required="required"
                       aria-autocomplete="list">
                <br/>
                <select class="form-control" name="gender">
                    <option value="">性别（选填）</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
                <br>
                <input id="phone" name="phone" class="form-control" placeholder="手机号（选填）">
                <br>
                <input name="address" class="form-control" placeholder="住址（选填）">
                <br/>
                <br/>
                <button class="btn btn-lg btn-info btn-block " id="registerBtn" type="submit">注册</button>
            </form>
        </div>
    </div>
</div>
