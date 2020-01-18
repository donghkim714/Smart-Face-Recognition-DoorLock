<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.member.example.dto.MemberDTO"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>회원 목록</title>
</head>
<body>
	<h2>회원 목록</h2>
	<input type="button" value="회원등록" onclick="location.href='${path}/member/write.do'">
	<table border="1" width="700px">
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			
		</tr>
		
			<c:forEach var="row" items="${list}">
			<tr>
				<td>${row.mem_id}</td>
				<td>${row.mem_pw}</td>
			</tr>
			</c:forEach>
		
	</table>
	
</body>
</html>