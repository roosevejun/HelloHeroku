<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>公路项目查询</title>
    <spring:url value="/resources" var="resources" htmlEscape="true"/>
    <style type="text/css">
        @import url("${resources}/bootstrap-3.2.0/css/bootstrap.min.css");
        @import url("${resources}/bootstrap-3.2.0/css/bootstrap-select.min.css");
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
                    url: "<c:url value="/zyzg/proj/queryRes.do"/>",
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
        });

    </script>

</head>
<body>
<div class="container">
    <form role="form" class="form-signin" name="supeComSearchForm" id="supeComSearchForm" action="">
        <input type="hidden" value="" name="ciphert">
        <input type="hidden" value="001000" name="INDUSTRYNO">
        <h2 class="form-signin-heading">公路项目查询</h2>
        <input type="text" autofocus="" id="PROJECTNAME" name="PROJECTNAME" required="" placeholder="项目名称"
               class="form-control">
        <select id='AREANO' name="AREANO" class="form-control selectpicker" title="所在省份">
            <optgroup label="所在省份">
                <option value="-1">==全部==</option>
                <option value="110000">北京市</option>
                <option value="120000">天津市</option>
                <option value="130000">河北省</option>
                <option value="140000">山西省</option>
                <option value="150000">内蒙古自治区</option>
                <option value="210000">辽宁省</option>
                <option value="220000">吉林省</option>
                <option value="230000">黑龙江省</option>
                <option value="310000">上海市</option>
                <option value="320000">江苏省</option>
                <option value="330000">浙江省</option>
                <option value="340000">安徽省</option>
                <option value="350000">福建省</option>
                <option value="360000">江西省</option>
                <option value="370000">山东省</option>
                <option value="410000">河南省</option>
                <option value="420000">湖北省</option>
                <option value="430000">湖南省</option>
                <option value="440000">广东省</option>
                <option value="450000">广西壮族自治区</option>
                <option value="460000">海南省</option>
                <option value="500000">重庆市</option>
                <option value="510000">四川省</option>
                <option value="520000">贵州省</option>
                <option value="530000">云南省</option>
                <option value="540000">西藏自治区</option>
                <option value="610000">陕西省</option>
                <option value="620000">甘肃省</option>
                <option value="630000">青海省</option>
                <option value="640000">宁夏回族自治区</option>
                <option value="650000">新疆维吾尔自治区</option>
                <option value="710000">长江航务局</option>
                <option value="720000">新疆建设兵团</option>
                <option value="730000">部质监局评价虚拟地区</option>
            </optgroup>
        </select>
        <select id="LEVELID" name="LEVELID" class="form-control selectpicker" title="项目类型">
            <optgroup label="项目类型">
            <option value="-1">==请选择==</option>
            <option value="1">高速</option>
            <option value="2">一级</option>
            <option value="3">二级</option>
            <option value="4">三级</option>
            <option value="5">四级</option>
            <option value="6">等外</option>
            </optgroup>
        </select>
        <select id="RANKID" name="RANKID" class="form-control selectpicker" title="项目子类型">
            <optgroup label="项目子类型">
                <option value="-1">==请选择==</option>
                <option value="1">国道</option>
                <option value="2">省道</option>
                <option value="3">县道</option>
                <option value="4">乡道</option>
                <option value="5">村道</option>
                <option value="6">专用</option>
            </optgroup>
        </select>
        <button type="button" id="doQuery" class="btn btn-lg btn-primary btn-block">查 询</button>
    </form>
</div>
<div class="container" id="queryRes">

</div>

</body>
</html>
