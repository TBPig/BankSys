<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang=en>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="BankRegister">
    <meta name="author" content="TBPig">
    <link rel="icon" href="../statics/icon/favicon.ico">
    
    <title>银行系统注册界面</title>
</head>
<body>
    <h2>用户注册表单</h2>
    <form action="/BankSys/register/doRegister" method="post">
        <table>
            <tr>
                <td>用户编号：</td>
                <td><input type="text" name="user_no" required></td>
            </tr>
            <tr>
                <td>用户名称：</td>
                <td><input type="text" name="name" required></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <td>所有人身份证号：</td>
                <td><input type="text" name="owner_id_card" maxlength="18" required></td>
            </tr>
            <tr>
                <td colspan="2"><br><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
    
    <a href="../login/index">返回登录</a>
</body>
</html>