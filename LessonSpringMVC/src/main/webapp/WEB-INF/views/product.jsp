<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
</head>
<body>
	<c:if test="${not empty productList}">
		<table border="1">
			<tr>
				<th>名前</th>
				<th>年齢</th>
				<th>性別</th>
				<th>E-mail</th>
				<th>出身地</th>
				<th>興味のある言語</th>
				<th>備考</th>
			</tr>
			<c:forEach var="productForm" items="${productList}">
				<tr>
					<td><c:out value="${productForm.name}"></c:out></td>
					<td><c:out value="${productForm.price}"></c:out></td>
					<td><c:out value="${productForm.gender}"></c:out></td>
					<td><c:out value="${productForm.mail}"></c:out></td>
					<td><c:out value="${productForm.birthplace}"></c:out></td>
					<td><c:out value="${productForm.favoriteLangs}"></c:out></td>
					<td><c:out value="${productForm.others}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
		<br>
	</c:if>
	<p>
		<c:out value="${message}" />
	</p>
	<form:form modelAttribute="productForm"> 
	名前<form:input path="name" placeholder="名前を入力してください" />
		<form:errors path="name" cssStyle="color:red" />
		<br /> 
	年齢<form:input path="price" placeholder="0" />
		<form:errors path="price" cssStyle="color:red" />
		<br />
	性別<form:radiobuttons path="gender" items="${genders}" />
		<br />
	E-mail<form:input path="mail" placeholder="E-mailを入力してください" />
		<br />
	出身地<form:select path="birthplace" items="${birthplaces}" multiple="false" />
		<br />
	興味のある言語<form:checkboxes path="favoriteLangs" items="${langs}" />
		<br/>
	備考<textarea name ="others"rows="4" cols="40"></textarea>
		<br />
		<input type="submit" value="送信">
		<br />
	</form:form>
</body>
</html>