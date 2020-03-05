<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>欢迎使用智能小区服务平台</title>
    <style>
        .header-container {
            height: 80px;
            background-color: #fff;
        }

        .main-container {
            background-color: #e3e3e3;
            height: 100%;
            display: flex;
            justify-content: flex-start;
        }

        .left-slider {
            background-color: #fff;
            width: 240px;
        }

        .main {
            position: relative;
            width: 100%;
        }

        .content-pane {
            margin: 20px;
            padding: 25px;
            height: 100%;
            background-color: #fff;
        }

    </style>

    <script src="/static/js/api.js"></script>
    <script src="/static/js/network.js"></script>
    <script src="/static/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            init();

            function init() {
                let currentUser = JSON.parse(localStorage.getItem("currentUser"));
                console.log("currentUser" + JSON.stringify(currentUser));
                $("#current-user").html(currentUser.username);
                addMenuClickListener()

            }

            function addMenuClickListener() {
                menuClickHandle("#owner-menu-item", "")
                menuClickHandle("tenant-menu-item", "")
                menuClickHandle("#owner-view-menu-item", "")
                menuClickHandle("#bulletin-menu-item", "")
                menuClickHandle("#personal-menu-item", "/page/personalDetail.jsp");
                menuClickHandle("#fee-menu-item", "/page/feeManagement.jsp");
            }

            function menuClickHandle(selectorName, fileName) {
                $(selectorName).on("click", function () {
                    $(".content-pane").empty().load(fileName);
                })
            }


        })
    </script>
</head>
<body>
<div class="header-container">
    <%@ include file="header.jsp" %>
</div>
<div class="main-container">
    <div class="left-slider">
        <%@ include file="menuSlider.jsp" %>
    </div>
    <div id="content-box" class="main">
        <div class="content-pane">
        </div>
    </div>
</div>


</body>
</html>
