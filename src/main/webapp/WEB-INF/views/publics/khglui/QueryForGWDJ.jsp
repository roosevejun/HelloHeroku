<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>岗位查询</title>
    <spring:url value="/resources" var="resources" htmlEscape="true"/>
    <style type="text/css">
        @import url("${resources}/bootstrap-3.2.0/css/bootstrap.min.css");
        @import url("${resources}/bootstrap-3.2.0/css/bootstrap-select.min.css");
        @import url("${resources}/bootstrap-3.2.0/css/datepicker3.css");
        @import url("${resources}/bootstrap-3.2.0/css/bootstrap-theme.min.css");

        body {
            margin-bottom: 0px;
            border: 0px;
            border-radius: 0px;
            background-color: #eee;
            font-family: "微软雅黑";
        }

        .form-signin {
            padding: 15px;
            margin: 0 auto;
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            font-weight: normal;
        }

        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }

        .form-signin .form-control:focus {
            z-index: 2;
        }

        .form-signin input[type="text"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-signin select {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-signin button[type="button"] {
            margin-top: 10px;
        }
    </style>
    <script src="${resources}/jquery/jquery.min.js"></script>
    <script src="${resources}/bootstrap-3.2.0/js/bootstrap-select.min.js"></script>
    <script src="${resources}/bootstrap-3.2.0/js/bootstrap-datepicker.js"></script>
    <script src="${resources}/bootstrap-3.2.0/js/bootstrap.min.js"></script>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
        $(function () {
            $("#doQuery").click(function () {
                $.ajax({
                    cache: false,
                    type: "POST",
                    url: "<c:url value="/khglui/gwdj/queryRes.do"/>",
                    data: $('#supeComSearchForm').serialize(),// 你的formid
                    async: false,
                    error: function (request) {
                        alert("Connection error");
                    },
                    success: function (data) {
                        $("#queryRes").html(data);
                    }
                });
            });
            $('.selectpicker').selectpicker({
                style: 'btn-info',
                size: 4
            });
            $('#ctl00_ContentPlaceHolder2_txt_FaZhengShiJian').datepicker({
                format: 'yyyy-mm-dd',
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true
            });
            $('#ctl00_ContentPlaceHolder2_txt_YouXiaoQi').datepicker({
                format: 'yyyy-mm-dd',
                calendarWeeks: true,
                autoclose: true,
                todayHighlight: true
            });
        });

    </script>

</head>
<body>
<div class="container">
    <form role="form" class="form-signin" name="supeComSearchForm" id="supeComSearchForm" action="">
        <h2 class="form-signin-heading">岗位查询</h2>
        <input type="text" autofocus="" id="ctl00_ContentPlaceHolder2_txtXingMing" name="ctl00$ContentPlaceHolder2$txtXingMing" required="" placeholder=" 姓    名"
               class="form-control">
        <input type="text" autofocus="" id="ctl00_ContentPlaceHolder2_txtSFZ" name="ctl00$ContentPlaceHolder2$txtSFZ" required="" placeholder="证件号码"  class="form-control">
        <input type="text" autofocus="" id="ctl00_ContentPlaceHolder2_txtXiangMuMC" name="ctl00$ContentPlaceHolder2$txtXiangMuMC" required="" placeholder="项目名称"  class="form-control">
        <input type="text" autofocus="" id="ctl00_ContentPlaceHolder2_txtDanWei" name="ctl00$ContentPlaceHolder2$txtDanWei" required="" placeholder="建设单位"  class="form-control">
        <select id='ctl00_ContentPlaceHolder2_ddlZhuGuanBuMen' name="ctl00$ContentPlaceHolder2$ddlZhuGuanBuMen" class="form-control selectpicker" title="工程所在地">
            <optgroup label="工程所在地">
                <option selected="selected" value="%">全部</option>
                <option value="340000">安徽</option>
                <option value="110000">北京</option>
                <option value="990000">兵团</option>
                <option value="cjhd">长江航道</option>
                <option value="350000">福建</option>
                <option value="620000">甘肃</option>
                <option value="440000">广东</option>
                <option value="450000">广西</option>
                <option value="520000">贵州</option>
                <option value="460000">海南</option>
                <option value="130000">河北</option>
                <option value="410000">河南</option>
                <option value="230000">黑龙江</option>
                <option value="420000">湖北</option>
                <option value="430000">湖南</option>
                <option value="220000">吉林</option>
                <option value="320000">江苏</option>
                <option value="360000">江西</option>
                <option value="210000">辽宁</option>
                <option value="150000">内蒙古</option>
                <option value="640000">宁夏</option>
                <option value="630000">青海</option>
                <option value="370000">山东</option>
                <option value="140000">山西</option>
                <option value="610000">陕西</option>
                <option value="310000">上海</option>
                <option value="510000">四川</option>
                <option value="120000">天津</option>
                <option value="540000">西藏</option>
                <option value="650000">新疆</option>
                <option value="530000">云南</option>
                <option value="330000">浙江</option>
                <option value="500000">重庆</option>
            </optgroup>
        </select>
        <input type="text" autofocus="" id="ctl00_ContentPlaceHolder2_txtShangGangTime" name="ctl00$ContentPlaceHolder2$txtShangGangTime" required="" placeholder="发证时间"  class="form-control">
        <button type="button" id="doQuery" name="ctl00$ContentPlaceHolder2$btnGWSel" class="btn btn-lg btn-primary btn-block" value="查询">查 询</button>
    </form>
</div>
<div class="container" id="queryRes">

</div>

</body>
</html>
