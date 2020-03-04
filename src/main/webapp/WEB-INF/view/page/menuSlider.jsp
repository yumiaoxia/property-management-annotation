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

        .menu-item-container a {
            display: inline-block;
            height: 40px;
            line-height: 40px;
            padding: 0 25px;
        }

        .menu-item:hover {
            background-color: #e3e3e3;
        }

        .menu-item:focus {
            background-color: #e3e3e3;
        }



    </style>
</head>
<body>
<div id="menu" class="menu-container">
    <div class="menu-header">
        <span>菜单</span>
    </div>
    <ul class="menu-item-container">
        <li class="menu-item" onclick="listOwner()">
            <a>业主管理</a>
        </li>
        <li class="menu-item">
            <a>租客管理</a>
        </li>
        <li class="menu-item">
            <a>业主评价查看</a>
        </li>
        <li class="menu-item">
            <a>物业缴费管理</a>
        </li>
        <li>
            <a>小区公告管理</a>
        </li>
        <li class="menu-item" onclick="personalDetail()">
            <a>个人信息</a>
        </li>
    </ul>
</div>
<script src="${pageContext.request.contextPath}/js/api.js"></script>
<script type="text/javascript" src=""></script>
<script type="text/javascript">
    function personalDetail() {
        alert("1")
       alert(api.personalDetail.toString())
    }
</script>

</body>
</html>
