<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="BankLogin">
    <meta name="author" content="TBPig, BellaYe">
    <link rel="icon" href="../statics/icon/favicon.ico">
    <title>银行系统登录界面</title>

    <link rel="stylesheet" href="../statics/css/login.css">

    <script src="../statics/js/login.js"></script>
</head>
<body>
    <div class="login-container">
        <form action="/BankSys/login/doLogin" method="post" class="login-form" id="loginForm" novalidate>
            <h1 class="login-title">银行账户登录</h1>
            <p class="subtitle">请选择用户类型并输入信息</p>
            <div class="form-group">
                <label for="user_type">用户类型:</label>
                <select id="user_type" name="user_type">
                    <option value="client">客户</option>
                    <option value="admin">管理员</option>
                </select>
            </div>
            <div class="form-group">
                <label for="inputEmail">用户编号</label>
                <input type="text" id="inputEmail" name="user_code" placeholder="用户ID" required autofocus>
                <div class="input-feedback" id="userCodeFeedback"></div>
            </div>
            <div class="form-group">
                <label for="inputPassword">密码</label>
                <input type="password" id="inputPassword" name="password" placeholder="密码" required>
                <div class="password-strength" id="passwordStrength"></div>
                <div class="input-feedback" id="passwordFeedback"></div>
            </div>
            <div id = "errorMsg"> 
                ${login_msg} 
            </div>
            <div class="form-group form-remember">
                <label>
                    <input type="checkbox" name="remember_me" id="rememberMe">
                    记住我
                </label>
                <a href="#" class="forgot-password">忘记密码？</a>
            </div>
            <button type="submit" class="login-btn" id="loginBtn">
                <span class="btn-text">登录</span>
                <span class="btn-loading" id="btnLoading" style="display:none;"></span>
            </button>
        </form>

        <a href="../register/index" class="btn btn-lg btn-primary btn-block">前往注册</a>
    
    </div>
</body>
</html>
