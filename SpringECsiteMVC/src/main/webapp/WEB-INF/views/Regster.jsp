<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="utf-8">
<title>会員登録</title>
</head>
<body>
<p>Date : ${serverTime}</p>
<br><br>
	<h2>${message}</h2>
	<form:form modelAttribute="loginForm">
		ID:　 <form:input path="userId" />&nbsp; 
		<form:errors path="userId" cssStyle="color:red" />
		<br>
		<br>
		PASS:<form:password path="password" />&nbsp; 
		<form:errors path="password" cssStyle="color:red" />
		<br>
		<br>
		<input type="submit" name="send" value="送信">
	</form:form>
	<br>
		<br>
	<form:form modelAttribute="RegsterForm">
	<input type="submit" name="regster" value ="ログイン画面へ">
	</form:form>
</body>
</html>