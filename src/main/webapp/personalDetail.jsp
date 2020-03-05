
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
    <form id="personalForm" class="personal-form">
        <label>
            <p>管理员工号</p>
            <input type="text" class="text-field" name="id"/>
        </label>
        <label>
            <p>管理员类型</p>
            <select class="text-field" name="type" onselect="2" disabled>
                <option value="1">系统管理员</option>
                <option value="2">物业管理员</option>
            </select>
        </label>
        <label>
            <p>管理员性别</p>
            <select name="sex" class="text-field" onselect="2" disabled>
                <option value="1">男</option>
                <option value="2">女</option>
            </select>
        </label>
        <label>
            <p>管理员电话号码</p>
            <input type="text" class="text-field" name="phone"/>
        </label>
        <label>
            <p>管理员职称</p>
            <input type="text" class="text-field" name="position"/>
        </label>
        <label>
            <p>管理员身份证号码</p>
            <input type="text" class="text-field" name="identity"/>
        </label>
        <input class="btn-submit" type="submit" value="提交">
    </form>
</div>

<script type="text/javascript">
    $(function () {
        init();

        function init() {
            let currentUser = localStorage.getItem("currentUser");
            const roleType = localStorage.getItem("roleType")
            if (currentUser) {
                let userDetailUrl;
                if (roleType && roleType === "1") {
                    userDetailUrl = api.adminDetail;
                } else if (roleType && roleType === "2") {
                    userDetailUrl = api.peopertyAdminDetail;
                }
                let userObj = JSON.parse(currentUser);
                network.get({
                    url: api.adminDetail + "/" + userObj.username,
                    success: (resonse) => {
                        if (resonse.success) {
                            let user = resonse.data;
                            personalForm.adminId.value = roleType === "1" ? user.adminId : proadminId;
                            personalForm.type.value = roleType
                            personalForm.sex.value = roleType === "1" ? user.adminSex : user.proadminSex;
                        } else {
                            alert(resonse.message)
                        }
                    }
                })
            }

        }
    })
</script>
</body>
</html>
