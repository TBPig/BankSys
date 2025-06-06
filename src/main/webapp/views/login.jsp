<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="BankLogin">
    <meta name="author" content="TBPig">
    <link rel="icon" href="../statics/icon/favicon.ico">
    
    <title>银行系统登录界面</title>
</head>
<body>
	<form action="/BankSys/login/doLogin" method="post">
		<h1>给爷登录你的银行账户</h1>
		
        <p>你什么用户类型:</p>
        <select id="user_type" name="user_type">
            <option value="client">客户</option>
            <option value="admin">管理员</option>
        </select>
        
        <input type="text" id="inputEmail" name="user_no" placeholder="用户NO" required autofocus>
        <label for="inputNo">用户编号</label>
        
        <input type="password" id="inputPassword"  name="password" placeholder="密码" required>
        <label for="inputPassword">密码</label>
        
        <button  type="submit">登录</button>
        
	</form>
</body>