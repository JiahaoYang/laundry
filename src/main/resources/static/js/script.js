$(function () {
    $("form.input").keyup(function () {
        $("#errorDiv").hide();
    });

    $("#phone").blur(function () {
        var reg=/^[1][3,4,5,7,8][0-9]{9}$/;
        var phone = $("#phone").val();
        if (phone !== "" && !reg.test(phone)) {
            $("#errorMessage").text("请填写正确的联系方式");
            $("#errorDiv").show();
            $("#registerBtn").attr("disabled", true);
        } else {
            $("#errorDiv").hide();
            $("#registerBtn").attr("disabled", false);
        }
    });
});