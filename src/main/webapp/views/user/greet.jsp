<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="BankGreet">
    <meta name="author" content="TBPig">
    <link rel="icon" href="../statics/icon/favicon.ico">
    
    <title>欢迎登录</title>
</head>
<body>
    <div>
        <h1 id="welcome-message"></h1>
        <p>${user.name},欢迎光临！</p>
    </div>
    
    <div>
    	<table>
    		<thead>
    			<tr>
    				<th>账户编号</th>
    				<th>账户状态</th>
    				<th>账户余额</th>
    			</tr>
    		</thead>
    		<tbody>
    			<c:forEach  items="${accountList}" var="ti" varStatus="loop">
    			<tr>
    				<td>${ti.accountNo}</td>
    				<td>${ti.status}</td>
    				<td>${ti.balance}</td>
    			</tr>
    			</c:forEach>
    		</tbody>
    	</table>
    </div>
    
    <div>
    <a href="tryAddAccount">创建账户</a>
    </div>
</body>



