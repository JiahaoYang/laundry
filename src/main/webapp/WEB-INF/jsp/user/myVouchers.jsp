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


<%@include file="navigator.jsp" %>
<br>
<br>
<table class="table table-hover">
    <tr>
        <th>ID</th>
        <th>金额</th>
        <th>收衣时间</th>
        <th>取衣时间</th>
        <th>状态</th>
        <th colspan="3" align="center">操作</th>
    </tr>
    <c:forEach items="${vouchers}" var="voucher">
        <tr>
            <td>${voucher.voucherId}</td>
            <td>${voucher.price}</td>
            <td>${voucher.getDate}</td>
            <td>
                <c:if test="${!empty voucher.takeDate}">
                    ${voucher.takeDate}
                </c:if>
            </td>
            <td>${voucher.state}</td>
            <td>
                <button class="showDetails btn btn-primary btn-xs" vid="${voucher.voucherId}">
                    查看详情
                </button>
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

                                <c:if test="${'正在洗衣'.equals(voucher.state)}">
                                    <td>正在洗衣</td>
                                </c:if>
                                <c:if test="${'洗衣完成'.equals(voucher.state)}">
                                    <td>洗衣完成</td>
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