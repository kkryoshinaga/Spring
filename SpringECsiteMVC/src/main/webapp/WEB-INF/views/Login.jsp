<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="utf-8">
<title>Login画面</title>
</head>
<body>
	<a>ログイン画面</a>
	<h2>${message}</h2>
	<form:form modelAttribute="loginForm">
		ID:　 <form:input path="userId" />&nbsp; 
		<form:errors path="userId" cssStyle="color:red" />
		<br>
		<br>
		PASS:<form:password path="password" />&nbsp; <form:errors path="password"
			cssStyle="color:red" />
		<br>
		<br>
		<input type="submit">
	</form:form>
</body>
</html>