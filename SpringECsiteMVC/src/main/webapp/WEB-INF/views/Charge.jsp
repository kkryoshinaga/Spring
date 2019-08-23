<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>チャージ</title>
</head>
<body>
	<div>
		<p>Date : ${serverTime}</p>
		<p>
			ログイン中のユーザ ：
			<c:out value="${userId}" />
		</p>
		<p>
			残高 ：
			<c:out value="${money}" />
			円
		</p>
	</div>

	<table>
		<form:form modelAttribute="ChargeForm">
			<tr>
				<td><c:out value="${message}"></c:out></td>
			</tr>
			<tr>
				<td><form:input path="chargeMoney" />&nbsp; <form:errors
						path="chargeMoney" cssStyle="color:red" />円</td>
				<td></td>
				<td></td>
				<td><input type="submit" name="charge" value="チャージ"></td>
			</tr>
		</form:form>

		<tr>
			<form:form modelAttribute="BackForm">
				<td><input type="submit" name="back" value="検索画面へ"></td>
			</form:form>
			<form:form modelAttribute="CartForm">
				<td><input type="submit" name="next" value="カートへ"></td>
			</form:form>
		</tr>


	</table>
</body>
</html>