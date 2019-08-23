<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
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
		<form:form modelAttribute="CartForm">
			<c:if test="${not empty DetailList}">
				<c:forEach var="DetailsForm" items="${DetailList}">
					<tr>

						<td rowspan="4"><img src="${DetailsForm.pro_pic}"></td>
						<td>商品名：</td>
						<td><input type="hidden" name="pro_name" value="${DetailsForm.pro_name}"></td>
						<td><c:out value="${DetailsForm.pro_name}"></c:out></td>
						<td></td>
					</tr>
					<tr>
						<td>価格：</td>
						<td><input type="hidden" name="pro_price" value="${DetailsForm.pro_price}"></td>
						<td><c:out value="${DetailsForm.pro_price}"></c:out></td>
						<td>円</td>
					</tr>
					<tr>
						<td>商品詳細：</td>
						<td colspan="2"><c:out value="${DetailsForm.pro_req}"></c:out></td>
					</tr>
				</c:forEach>
			</c:if>
			
			<tr>

				<td><form:select path="nums" items="${numList}"/>個</td>
				<td><input type="submit" name="next" value="カートへ"></td>
			</tr>
			</form:form>
			<tr>
			<form:form modelAttribute="BackForm">
				<td><input type="submit" name="back" value="戻る"></td>
			</form:form>
			</tr>
		
	</table>




</body>
</html>