<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="BankSave">
    <meta name="author" content="TBPig">
    <link rel="icon" href="../statics/icon/favicon.ico">
    
    <title>把钱存进来吧</title>
</head>

<body>
	<h2>存钱系统</h2>
	
    <div id = "errorMsg"> ${save_msg} </div>
	
	<form action="/BankSys/account/doSave" method="post">
		<table>
            <tr>
                <td>选择账户</td>
                <td><input type="text" name="account_no" required></td>
            </tr>
            <tr>
                <td>存入金额</td>
                <td><input type="number" name="money" required></td>
            </tr>
            <tr>
                <td colspan="2"><br><input type="submit" value="提交"></td>
            </tr>
		</table>
	</form>
	
    <a href="../user/greet">返回</a>
</body>