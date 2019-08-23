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
	<div>
	<p>Date : ${serverTime}</p>
	<p>ログイン中のユーザ　：<c:out value="${LoginInfo.userId}"/></p>
	<p>残高　：<c:out value="${LoginInfo.money}"/>円</p>
	</div>
	
<table>
	<form:form modelAttribute="ProductSearch">
	<tr>
	<td><form:input path="word"/>&nbsp;</td>
	<td><form:select path="category" items="${category}" multiple="false" /></td>
	<td><input type="submit" value="検索"></td>
	</tr>
	</form:form>
</table>
	<c:if test="${not empty productList}">
		<table border="1">
			<tr>
				<th>商品名</th>
				<th>価格</th>
			</tr>
			<c:forEach var="productForm" items="${productList}">
				<tr>
					<td><input type="submit" value="${productForm.name}"></td>
					<td><c:out value="${productForm.price}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
		<br>
	</c:if>
</body>
</html>