<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人事管理</title>
    <style>
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

        tr input {
            margin: 0 50%;
        }
    </style>
</head>
<body>
<div>
    <h4>人事管理</h4>
    <br/>
    <div class="btn-group">
        <button id="add_member">新增</button>
        <button id="update_member">修改</button>
        <button id="delete">删除</button>
    </div>
    <br/>
    <table class="member-table">
        <tr>
            <th class="tr-first"><input type="checkbox"></th>
            <th>管理员工号</th>
            <th>管理员类型</th>
            <th>管理员登录密码</th>
            <th>管理员姓名</th>
            <th>管理员性别</th>
            <th>电话号码</th>
            <th>职称</th>
            <th>身份证号</th>
        </tr>
        <tr>
            <td class="tr-first">
                <input type="checkbox">
            </td>
            <td>xxx</td>
            <td>xxx</td>
            <td>xxx</td>
            <td>xxx</td>
            <td>xxx</td>
            <td>xxx</td>
            <td>xxx</td>
            <td>xxx</td>
        </tr>
    </table>
    <p>显示第 x 到 第 x 条记录,总共 x 条记录</p>
</div>

</body>
</html>
