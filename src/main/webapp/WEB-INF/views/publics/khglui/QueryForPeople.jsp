<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册证书查询</title>
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
                    url: "<c:url value="/khglui/people/queryRes.do"/>",
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
        <h2 class="form-signin-heading">注册证书查询</h2>
        <input type="text" autofocus="" id="ctl00$ContentPlaceHolder2$txt_ZSBH" name="ctl00$ContentPlaceHolder2$txt_ZSBH" required="" placeholder="证书编号可进行多个编号查询，请使用空格隔开。"
               class="form-control">
        <input type="text" autofocus="" id="ctl00_ContentPlaceHolder2_txtName" name="ctl00$ContentPlaceHolder2$txtName" required="" placeholder="姓    名"  class="form-control">
        <input type="text" autofocus="" id="ctl00_ContentPlaceHolder2_txtShenFenZheng" name="ctl00$ContentPlaceHolder2$txtShenFenZheng" required="" placeholder="证件号码"  class="form-control">
        <input type="text" autofocus="" id="ctl00_ContentPlaceHolder2_txtCompanyName" name="ctl00$ContentPlaceHolder2$txtCompanyName" required="" placeholder="企业名称"  class="form-control">
        <select id='ctl00_ContentPlaceHolder2_Ddl_ZSleiXing' name="ctl00$ContentPlaceHolder2$Ddl_ZSleiXing" class="form-control selectpicker" title="证书类型">
            <optgroup label="证书类型">
                <option selected="selected" value="%">全部</option>
                <option value="A">企业主要负责人（A证）</option>
                <option value="B">项目负责人（B证）</option>
                <option value="C1">企业专职安全员（C1证）</option>
                <option value="C2">施工现场专职安全员（C2证）</option>
            </optgroup>
        </select>
        <input type="text" autofocus="" id="ctl00_ContentPlaceHolder2_txt_FaZhengShiJian" name="ctl00$ContentPlaceHolder2$txt_FaZhengShiJian" required="" placeholder="发证时间"  class="form-control">
        <input type="text" autofocus="" id="ctl00_ContentPlaceHolder2_txt_YouXiaoQi" name="ctl00$ContentPlaceHolder2$txt_YouXiaoQi" required="" placeholder="有效时间"  class="form-control">
        <button type="button" id="doQuery" name="ctl00$ContentPlaceHolder2$btnSeach" class="btn btn-lg btn-primary btn-block" value="查询">查 询</button>
    </form>
</div>
<div class="container" id="queryRes">

</div>

</body>
</html>
