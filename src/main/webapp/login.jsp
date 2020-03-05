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

    <script src="/static/js/api.js"></script>
    <script src="/static/js/network.js"></script>
    <script src="/static/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<div id="login_frame" class="login-box">
    <h3 class="login_title">Hi,欢迎使用小区智能服务平台</h3>
    <p>请登录</p>
    <br/>
    <form action="" method="post" id="loginForm">
        <select class="role_select" onselect="0" name="role">
            <option value="0">请选择</option>
            <option value="1">系统管理员</option>
            <option value="2">物业管理员</option>
        </select>
        <p>
            <input type="text" name="username" class="text_field" placeholder="用户"/>
        </p>
        <br/>
        <p>
            <input type="password" name="password" class="text_field" placeholder="密码"/>
        </p>
        <br/>
        <div id="login_control">
            <input type="button" id="btn_login" value="登录"/>
        </div>
    </form>
</div>


<script type="text/javascript">
    $(function () {
        $("#btn_login").on("click", function () {
            const role = loginForm.role.value;
            const username = loginForm.username.value;
            const password = loginForm.password.value;
            if (checkForm(username, password)) {
                network.post({
                    url: api.adminLogin,
                    data: "username=" + role + "-" + username + "&password=" + password,
                    success: function (response) {
                        if (response.success) {
                            localStorage.setItem("currentUser", JSON.stringify(response.data));
                            window.location.href = "main.jsp"
                        } else {
                            alert(response.message);
                            loginForm.role.value = "0";
                            loginForm.username.value = "";
                            loginForm.password.value = "";
                        }
                    },
                    error: function (error) {
                        alert("网络错误")
                    }
                })
            }
        })


        function checkForm(username, password) {
            if (username === "" || username == null) {
                alert("请输入用户名");
                loginForm.username.focus();
                return false;
            } else if (password === "" || password == null) {
                alert("请输入密码");
                loginForm.password.focus();
                return false;
            }
            return true;
        }
    })


</script>


</body>
</html>
