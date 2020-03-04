<%--
  Created by IntelliJ IDEA.
  User: Sherman
  Date: 2020/3/5
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>缴费管理</title>
    <style>
        .btn-group button {
            font-size: 14px;
            font-family: 宋体, serif;
            width: 60px;
            height: 28px;
            line-height: 28px;
            text-align: center;
            color: white;
            background-color: #3BD9FF;
            border-radius: 5%;
            border: 0;
            float: left;
            margin: 5px 10px;
        }

        body, table {
            font-size: 14px;
        }

        table {
            width: 100%;
            table-layout: fixed;
            empty-cells: show;
            border-collapse: collapse;
            margin: 0 auto;
        }

        td {
            height: 30px;
        }

        h1, h2, h3 {
            font-size: 12px;
            margin: 0;
            padding: 0;
        }

        .member-table {
            border: 1px solid #cad9ea;
            color: #666;
        }

        .member-table th {
            background-repeat: repeat-x;
            height: 30px;
            font-weight: bolder;
        }

        .member-table td, .member-table th {
            border: 1px solid #cad9ea;
            padding: 0 1em 0;
        }

        .member-table tr.alter {
            background-color: #f5fafe;
        }

        tr input {
            margin: 0 50%;
        }
    </style>
</head>
<body>
<div>
    <h4>物业缴费管理</h4>
    <br/>
    <div class="btn-group">
        <button id="add_member">新增</button>
        <button id="update_member">修改</button>
        <button id="delete">删除</button>
    </div>
    <br/>
    <table>
        <table class="member-table">
            <tr>
                <th><input type="checkbox"></th>
                <th>家政/维修预约项目类型</th>
                <th>预约项目费用</th>
            </tr>
            <tr>
                <td><input type="checkbox"></td>
                <td>xxx</td>
                <td>xxx</td>
            </tr>
        </table>
        <p>显示第 x 到 第 x 条记录,总共 x 条记录</p>


</div>

</body>
</html>
