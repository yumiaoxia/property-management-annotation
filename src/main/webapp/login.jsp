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
        <form action="" method="post" name="loginForm">
            <select class="role_select" id="role">
                <option value="ADMIN">系统管理员</option>
                <option value="PROPERTY_ADMIN">物业管理员</option>
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
                    <input type="submit" id="btn_login" value="登录" onsubmit="submitForm()"/>
                </div>
            </form>
    </div>


    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script>
        const role = loginForm.role.value;
        const username = loginForm.username.value;
        const password = loginForm.password.value;

        function submitForm() {
            if (checkForm()) {
                if (role === "ADMIN") {
                    const url = api.adminLogin;
                    axios({
                        url: "http：//localhost:8080/api/admin/login",
                        method: 'post',
                        data: {
                            adminId: username,
                            password: password
                        },
                        transformRequest: [function (data) {
                            let ret = '';
                            for (let it in data) {
                                ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
                            }
                            return ret
                        }],
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded'
                        }
                    }).then(
                        function (reseponse) {
                            console.log(reseponse)
                        }
                    ).catch(function (error) {
                        console.log(error)
                    });
                }
            }
        }


        function checkForm() {
            alert(name + pwd)
            if (name === "" || name == null) {
                alert("请输入用户名");
                loginForm.name.focus();
                return false;
            } else if (pwd === "" || pwd == null) {
                alert("请输入密码");
                loginForm.pwd.focus();
                return false;
            }
            return true;
        }

    </script>



</body>
</html>
