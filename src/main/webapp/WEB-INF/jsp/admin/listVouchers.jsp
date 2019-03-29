<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../include/header.jsp" %>


<script>
    $(function () {
        $("button.showDetails").click(function () {
            var vid = $(this).attr("vid");
            $("tr.voucherDetails[vid=" + vid + "]").toggle();
        });
    });
</script>


<script>
    $(function () {
        $("#confirm").click(function () {
            window.location.href = 'getClothesPage?num=' + $("#num").val();
        })
    });

    function showModal() {
        $("#myModal").modal("show");
    }
</script>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title">收衣</h4>
            </div>
            <div class="modal-body">
                <p>请输入衣物件数</p>
                <input type="number" class="form-control" id="num">
            </div>
            <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                <button id="confirm" class="btn btn-primary" type="button">提交</button>
            </div>
        </div>
    </div>
</div>

<%@include file="nagivator.jsp" %>
<br>
<a class="btn btn-success" onclick="showModal()">收衣</a>
<br>
<br>
<table class="table table-hover">
    <tr>
        <th>ID</th>
        <th>状态</th>
        <th>金额</th>
        <th>洗衣用户</th>
        <th>收衣时间</th>
        <th>取衣时间</th>
        <th colspan="3" align="center">操作</th>
    </tr>
    <c:forEach items="${vouchers}" var="voucher">
        <tr>
            <td>${voucher.voucherId}</td>
            <td>${voucher.state}</td>
            <td>${voucher.price}</td>
            <td>${voucher.user.username}</td>
            <td>${f:formatLocalDateTime(voucher.getDate, 'yyyy-MM-dd HH:mm:ss')}</td>
            <td>
                <c:if test="${!empty voucher.takeDate}">
                    ${voucher.takeDate}
                </c:if>
            </td>
            <td>
                <button class="showDetails btn btn-primary btn-xs" vid="${voucher.voucherId}">
                    查看详情
                </button>
            </td>
            <td>
                <c:if test="${voucher.state == '正在洗衣'}">
                    <a href="informTakeClothes?voucherId=${voucher.voucherId}&userId=${voucher.userId}">
                        <button class="btn btn-info btn-xs">通知取衣</button>
                    </a>
                </c:if>
            </td>
            <td>
                <c:if test="${voucher.state == '洗衣完成'}">
                    <a href="completeVoucher?voucherId=${voucher.voucherId}">
                        <button class="btn btn-success btn-xs">完成订单</button>
                    </a>
                </c:if>
            </td>
        </tr>

        <tr class="voucherDetails" vid="${voucher.voucherId}" style="display: none">
            <td colspan="10px" align="center">
                <div class="voucherDetail">
                    <table class="voucherDetailTable" align="center" width="800px">
                        <c:forEach items="${voucher.voucherDetailList}" var="v">
                            <tr>
                                <td align="left">
                                        ${v.clothes.clothesName}
                                </td>
                                <td>
                                        ${v.serverName}
                                </td>
                                <td>
                                        ${v.washPrice}
                                </td>
                                <c:if test="${'洗衣完成'.equals(voucher.state)}">
                                    <c:if test="${empty v.isRewash && empty v.isCompensate}">
                                        <td>
                                            <a href="rewash?vdId=${v.voucherDetailId}&uid=${voucher.userId}"
                                               class="btn btn-warning btn-xs"
                                               role="button">重洗</a>
                                        </td>
                                        <td>
                                            <a href="compensate?vdId=${v.voucherDetailId}&uid=${voucher.userId}"
                                               class="btn btn-danger btn-xs"
                                               role="button">赔偿</a>
                                        </td>
                                    </c:if>
                                    <c:if test="${!empty v.isRewash}">
                                        <td>
                                                ${v.isRewash}
                                        </td>
                                        <c:if test="${!'重洗完成'.equals(v.isRewash)}">
                                            <td>
                                                <a href="informRewash?vdId=${v.voucherDetailId}&userId=${voucher.userId}">
                                                    <button class="btn btn-info btn-xs">通知取衣</button>
                                                </a>
                                            </td>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${!empty v.isCompensate}">
                                        <td>
                                                ${v.isCompensate}
                                        </td>
                                    </c:if>
                                </c:if>
                                <c:if test="${'订单完成'.equals(voucher.state)}">
                                    <td align="right">
                                        <c:if test="${!empty v.isRewash}">
                                            ${v.isRewash}
                                        </c:if>
                                    </td>
                                    <td align="right">
                                        <c:if test="${!empty v.isCompensate}">
                                            ${v.isCompensate}
                                        </c:if>
                                    </td>
                                    <td align="right">
                                        <c:if test="${!empty v.isTaken}">
                                            ${v.isTaken}
                                        </c:if>
                                    </td>
                                </c:if>
                                <td align="right">
                                    <c:if test="${!empty v.comment}">
                                        ${v.comment}
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>

<%@include file="../include/page.jsp" %>