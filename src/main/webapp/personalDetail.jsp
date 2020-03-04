<%--
  Created by IntelliJ IDEA.
  User: Sherman
  Date: 2020/3/4
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人主页</title>
    <style type="text/css">
        .personal-content {
            width: 100%;
        }

        .personal-form label {
            margin: 10px 5px;
            display: block;
        }

        .personal-form {
            width: 100%;
        }

        .text-field {
            display: block;
            width: 100%;
            color: #a3a3a3;
            border: #3BD9FF solid 1px;
            height: 30px;
            line-height: 30px;
        }

        .text-field:focus {
            background-color: #e5e5e5;
        }

        .btn-submit {
            font-size: 14px;
            font-family: 宋体, serif;
            width: 120px;
            height: 28px;
            line-height: 28px;
            text-align: center;
            color: white;
            background-color: #3BD9FF;
            border-radius: 6px;
            border: 0;
            float: left;
            margin: 0 auto;
        }

        .oper-tip {
            font-size: 0.8em;
            color: #3BD9FF;
        }


    </style>
</head>
<body>
<div class="personal-content">
    <h4>个人信息</h4>
    <br/>
    <p class="oper-tip"><a>查看/修改</a></p>
    <form action="" id="personalForm" class="personal-form">
        <label>
            <p>管理员工号</p>
            <input type="text" class="text-field"/>
        </label>
        <label>
            <p>管理员类型</p>
            <select name="" class="text-field" disabled>
                <option>系统管理员</option>
                <option>物业管理员</option>
            </select>
        </label>
        <label>
            <p>管理员性别</p>
            <select name="" class="text-field" disabled>
                <option>男</option>
                <option>女</option>
            </select>
        </label>
        <label>
            <p>管理员电话号码</p>
            <input type="text" class="text-field"/>
        </label>
        <label>
            <p>管理员职称</p>
            <input type="text" class="text-field"/>
        </label>
        <label>
            <p>管理员身份证号码</p>
            <input type="text" class="text-field"/>
        </label>
        <input class="btn-submit" type="submit" value="提交">
    </form>
</div>
</body>
</html>
