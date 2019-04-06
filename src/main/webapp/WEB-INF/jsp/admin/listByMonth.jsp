<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../include/header.jsp" %>
<%@include file="nagivator.jsp" %>

<script src="${pageContext.request.contextPath}/static/js/echarts.min.js"></script>
<script>
    function getByMonth() {
        var now = {"now": $("#month").val()};
        var dates = [];
        var incomes = [];
        $.ajax(
            {
                url: "listByMonth",
                type: "get",
                data: now,
                success: function (data) {
                    if (data) {
                        for (var i = 0; i < data.length; ++i) {
                            dates.push(data[i].date);
                            incomes.push(data[i].income);
                        }
                    }
                    myChart.setOption({
                        xAxis: {
                            data: dates
                        },
                        series: [{
                            // 根据名字对应到相应的系列
                            name: "营业额",
                            data: incomes
                        }]
                    });
                },
                error : function() {
                    alert("图表请求数据失败!");
                    myChart.hideLoading();
                }

            }
        )
    }
</script>
<br>

<select class="form-control" id="month" style="width: 15%" onchange="getByMonth()">
    <option value="">日期</option>
    <c:forEach items="${months}" var="month">
        <option value="${month}">${month}</option>
    </c:forEach>
</select>
<br>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" align="center" style="width: 1350px;height:550px;"></div>

<script>
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '月收入统计'
        },
        tooltip: {
            //坐标轴触发，主要用于柱状图，折线图等
            trigger: 'axis'
        },
        //图例
        legend: {
            data: ['营业额']
        },

        xAxis: {
            data: []
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            name: "营业额",
            type: 'line',
            data: []
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
