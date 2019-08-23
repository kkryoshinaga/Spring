<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="utf-8">
<title>購入完了</title>
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
		<tr>
			<td>ご購入ありがとうございました。</td>
		</tr>
	</table>
	<table>
	<tr><form:form modelAttribute="BackForm">
				<td></td>
				<td><input type="submit" name="back" value="買い物を続ける"></td>
			</form:form>
	</tr>
	<tr><form:form modelAttribute="LogOutForm">
				<td></td>
				<td><input type="submit" name="LogOut" value="ログアウト"></td>
			</form:form>
	</tr>
	</table>
</body>
</html>