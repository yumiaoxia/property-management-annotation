<%--
  Created by IntelliJ IDEA.
  User: Sherman
  Date: 2020/3/1
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>欢迎使用智能小区服务平台</title>
    <style>
        .header-container {
            height: 80px;
            background-color: #fff;
        }

        .left-slider{
            background-color: #fff;
            float: left;
            width: 240px;
            height: 800px;
        }

        .main-container{
            background-color: #e3e3e3;
        }

        .content {
            padding: 25px;
        }
    </style>
</head>
<body>
<div class="header-container">
    <%@ include file="header.jsp"%>
</div>
<div class="main-container">
    <div class="left-slider">
        <%@ include file="menuSlider.jsp"%>
    </div>
    <div id="content-box" class="content">

    </div>
</div>


</body>
</html>
