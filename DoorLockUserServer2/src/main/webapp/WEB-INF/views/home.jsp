<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<%@ include file="include/menu.jsp" %>
	<c:if test="${msg=='success'}">
		<h2>환영합니다</h2>
		<h3>가동을 눌러 얼굴 인식</h3>
		<a href="../board/detectControl.do">가동</a>
	</c:if>
</body>
</html>
