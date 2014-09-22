<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>监理考试成绩查询</title>
    <spring:url value="/resources" var="resources" htmlEscape="true"/>
    <style type="text/css">
        @import url("${resources}/bootstrap-3.2.0/css/bootstrap.min.css");
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

        .form-signin button[type="submit"] {
            margin-top: 10px;
        }
    </style>
    <script src="${resources}/jquery/jquery.min.js"></script>
    <script src="${resources}/bootstrap-3.2.0/js/bootstrap.min.js"></script>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
        $(function () {

        });

    </script>

</head>
<body>
<div class="container">
    <form role="form" class="form-signin" name="supeComSearchForm" method="post" action="">
        <h2 class="form-signin-heading">监理考试成绩查询</h2>
        <input type="text" autofocus="" id="name" name="name" required="" placeholder="姓 名" class="form-control">
        <input type="text" required="" id='idCard' name="idCard" placeholder="证件号码" class="form-control">
        <input type="text" required=""  id="examId" name="examId"placeholder="准考证号" class="form-control">
        <button type="submit"  id="doQuery" class="btn btn-lg btn-primary btn-block">查 询</button>
    </form>
</div>
</body>
</html>
