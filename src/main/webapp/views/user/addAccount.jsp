<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang=en>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="BankAddAccount">
    <meta name="author" content="TBPig">
    <link rel="icon" href="../statics/icon/favicon.ico">
    
    <title>添加属于您的账户</title>
</head>

<body>
	<h2>账户注册表单</h2>
    <div id = "errorMsg"> ${add_account_msg} </div>
	<form action="/BankSys/user/addAccount" method="post">
		<table>
            <tr>
                <td>新账户编号：</td>
                <td><input type="text" name="account_no" required></td>
            </tr>
            <tr>
                <td colspan="2"><br><input type="submit" value="提交"></td>
            </tr>
		</table>
	</form>
	
    <a href="greet">返回</a>
</body>