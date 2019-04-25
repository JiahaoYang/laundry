<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../include/header.jsp" %>
<%@include file="nagivator.jsp" %>

<br>
<div>

    <ul class="nav nav-tabs">
        <li role="presentation" id="loginTab" class="active"><a href="#loginDiv" data-toggle="tab">重洗记录</a></li>
        <li role="presentation" id="registerTab"><a href="#registerDiv" data-toggle="tab">赔偿记录</a></li>
    </ul>


    <div class="tab-content">
        <div id="loginDiv" class="tab-pane fade in active">
            <table class="table table-hover">
                <tr>
                    <th>衣物名称</th>
                    <th>颜色</th>
                    <th>是否瑕疵</th>
                    <th>服务类型</th>
                    <th>洗衣用户</th>
                    <th>重洗日期</th>
                </tr>
                <c:forEach items="${rewashes}" var="r">
                    <tr>
                        <td>${r.voucherDetail.clothes.clothesName}</td>
                        <td>${r.voucherDetail.clothes.color}</td>
                        <td>${r.voucherDetail.clothes.flaw}</td>
                        <td>${r.voucherDetail.serverName}</td>
                        <td>${r.username}</td>
                        <td>${f:formatLocalDateTime(r.rewashDate, 'yyyy-MM-dd HH:mm:ss')}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div id="registerDiv" class="tab-pane fade">
            <table class="table table-hover">
                <tr>
                    <th>衣物名称</th>
                    <th>颜色</th>
                    <th>是否瑕疵</th>
                    <th>服务类型</th>
                    <th>洗衣用户</th>
                    <th>赔偿日期</th>
                </tr>
                <c:forEach items="${compensates}" var="c">
                    <tr>
                        <td>${c.voucherDetail.clothes.clothesName}</td>
                        <td>${c.voucherDetail.clothes.color}</td>
                        <td>${c.voucherDetail.clothes.flaw}</td>
                        <td>${c.voucherDetail.serverName}</td>
                        <td>${c.username}</td>
                        <td>${f:formatLocalDateTime(c.compensateDate, 'yyyy-MM-dd HH:mm:ss')}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
