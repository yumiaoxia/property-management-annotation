<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎登录</title>
    <style type="text/css">
        * {
            padding: 0;
            margin: 0;
        }

        body {
            background-color: #e3e3e3;
        }
        .login-box {
            width: 400px;
            height: 320px;
            padding: 13px;
            position: absolute;
            left: 50%;
            top: 50%;
            margin-left: -200px;
            margin-top: -200px;
            background-color: #fff;
            border-radius: 10px;
            text-align: center;
        }

        form p > * {
            display: inline-block;
            vertical-align: middle;
        }

        .text_field {
            width: 278px;
            height: 28px;
            padding: 2px 10px;
            border-top-right-radius: 5px;
            border-bottom-right-radius: 5px;
            background-color: #e3e3e3;
            border: 0;
        }

        #btn_login {
            font-size: 14px;
            font-family: 宋体, serif;
            width: 278px;
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

        #login_control {
            display: inline-block;
            width: 278px;
            /*padding: 0 28px;*/
        }

        .login-box>p {
            text-align: left;
            padding-left: 40px;
        }

        .login_title {
            margin: 20px auto;
        }

        .role_select {
            font-size: 14px;
            font-family: 宋体, serif;
            width: 278px;
            height: 30px;
            margin: 12px;
            line-height: 28px;
            background-color: #e3e3e3;
        }
    </style>
</head>
<body>
    <div id="login_frame" class="login-box">
        <h3 class="login_title">Hi,欢迎使用小区智能服务平台</h3>
        <p>请登录</p>
        <br/>
            <form method="post" action="login.js">
                <select class="role_select">
                    <option>物业管理员</option>
                </select>
                <p>
                    <input type="text" id="username" class="text_field" placeholder="用户"/>
                </p>
                <br/>
                <p>
                    <input type="password" id="password" class="text_field" placeholder="密码"/>
                </p>
                <br/>
                <div id="login_control">
                    <input type="button" id="btn_login" value="登录" οnclick="login();"/>
                </div>
            </form>
    </div>
    <script type="text/javascript">
        function login() {
            var username = document.getElementById("username");
            var pass = document.getElementById("password");
            if (username.value == "") {
                alert("请输入用户名");
            } else if (pass.value  == "") {
                alert("请输入密码");
            } else if(username.value == "admin" && pass.value == "123456"){
                window.location.href="welcome.html";
            } else {
                alert("请输入正确的用户名和密码！")
            }}

    </script>



</body>
</html>
