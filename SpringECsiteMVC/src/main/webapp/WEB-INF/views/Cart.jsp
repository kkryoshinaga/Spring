<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="utf-8">
<title>カート</title>
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
			<form:form modelAttribute="ChargeForm">
				<td><input type="submit" name="charge" value="チャージ"></td>
			</form:form>
			<td></td>
			<td></td>
			<td><c:out value="${message}"></c:out></td>
		</tr>
	</table>
	<table>
<c:if test="${not empty CartList}">
		<tr>

			<td>商品名</td>
			<td>価格（円）</td>
			<td>個数</td>
			<td>小計（円）</td>
		</tr>
		
			<c:forEach var="CartInfo" items="${CartList}">
				<tr>
					<td><c:out value="${CartInfo.pro_name}"></c:out></td>
					<td><c:out value="${CartInfo.pro_price}"></c:out></td>
					<td><c:out value="${CartInfo.num}"></c:out></td>
					<td><c:out value="${CartInfo.price}"></c:out></td>
					<form:form modelAttribute="CancelForm">
					<td><input type="hidden" name="name" value="${CartInfo.pro_name}"></td>
					<td><input type="submit" name="cancel" value="キャンセル"></td>
					</form:form>
				</tr>
			</c:forEach>
		</c:if>
		<tr>
			<td></td>
			<td></td>
			<td colspan="2">合計：<c:out value="${sumPrice}"></c:out>円(税込)
			</td>
		</tr>
		<tr>
			<form:form modelAttribute="BackForm">
				<td></td>
				<td><input type="submit" name="back" value="戻る"></td>
			</form:form>
			<c:if test="${not empty CartList}">
			<form:form modelAttribute="FinForm">
				<td><input type="hidden" name="money" value="${sumPrice}"></td>
				<td><input type="submit" name="buy" value="購入"></td>
			</form:form>
			</c:if>
		</tr>
	</table>

</body>
</html>