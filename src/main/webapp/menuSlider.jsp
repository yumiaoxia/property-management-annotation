<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>侧边导航栏</title>
    <style type="text/css">
        .menu-header {
            padding: 5px 30px;
            margin-bottom: 30px;
        }

        .menu-header>span {
            font-size: 18px;
            font-weight: bolder;
        }

        .menu-item-container {
            list-style-type: null;
            font-size: 14px;
            text-decoration-line: none;
        }


        .menu-item:hover {
            background-color: #e3e3e3;
        }

        .menu-item:focus {
            background-color: #e3e3e3;
        }

        .menu-item a {
            display: block;
            height: 40px;
            line-height: 40px;
            padding: 0 25px;
        }
    </style>
</head>
<body>
<div id="menu" class="menu-container">
    <div class="menu-header">
        <span>菜单</span>
    </div>
    <ul class="menu-item-container">
        <li class="menu-item">
            <a id="owner-menu-item">业主管理</a>
        </li>
        <li class="menu-item">
            <a id="tenant-menu-item">租客管理</a>
        </li>
        <li class="menu-item">
            <a id="owner-view-menu-item">业主评价查看</a>
        </li>
        <li class="menu-item">
            <a id="fee-menu-item">物业缴费管理</a>
        </li>
        <li class="menu-item">
            <a id="bulletin-menu-item">小区公告管理</a>
        </li>
        <li class="menu-item">
            <a id="personal-menu-item">个人信息</a>
        </li>
    </ul>
</div>
</body>
</html>
