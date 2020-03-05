<%--
  Created by IntelliJ IDEA.
  User: Sherman
  Date: 2020/3/4
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>头部</title>
    <style type="text/css">
        * {
            padding: 0;
            margin: 0;
        }

        body{
            background-color: #e3e3;
        }


        .header {
            background-color: #fff;
            padding: 10px 20px;
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: flex-end;
        }

        .app-title {
            color: #3BD9FF;
            font-family: "微软雅黑";
            display: inline-block;
        }

        .header p{
            font-weight: bold;
        }

    </style>
</head>
<body>
<div class="header">
    <h2 class="app-title">智能小区服务系统</h2>
    <p>下午好,<span id="current-user"></span></p>
</div>

</body>
</html>
