<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>商品検索</title>
</head>
<body>
	<div align="right">
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
			<form:form modelAttribute="ChargeForm">
				<td><input type="submit" name="charge" value="チャージ"></td>
			</form:form>
			<form:form modelAttribute="CartForm">
				<td><input type="submit" name="next" value="カート"></td>
			</form:form>
			<form:form modelAttribute="LogOutForm">
				<td></td>
				<td><input type="submit" name="LogOut" value="ログアウト"></td>
			</form:form>
		</tr>

		<form:form modelAttribute="ProductSearch">
			<tr>
				<td><form:input path="word" /></td>
				<td><form:select path="category" items="${category}"
						multiple="false" /></td>
				<td><input type="submit" name="search" value="検索"></td>
			</tr>
		</form:form>
	</table>
	<c:if test="${not empty productList}">
		<table border="1">
			<tr>
				<th>商品名</th>
				<th>価格</th>
			</tr>
			<c:forEach var="ProductForm" items="${productList}">
				<tr>
					<form:form modelAttribute="DetailForm">
						<td><input type="submit" name="pro_name"
							value="${ProductForm.pro_name}"></td>
						<td><c:out value="${ProductForm.pro_price}"></c:out>円</td>
					</form:form>
				</tr>
			</c:forEach>
		</table>
		<br>
	</c:if>
</body>
</html>