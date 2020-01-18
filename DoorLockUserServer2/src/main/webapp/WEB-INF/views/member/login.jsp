<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<%@ include file="../include/header.jsp" %>
<script>
	$(document).ready(function(){
		$("#btnLogin").click(function(){
			// 태그.val() : 태그에 입력된 값
			// 태그.val("값") : 태그의 값을 변경
			var mem_id = document.getElementById('mem_id');
			var mem_pw = $('#mem_pw').val();
			if(mem_id ==""){
				alert("아이디를 입력하세요.");
				$('#mem_id').focus(); //입력포커스 이동
				return;
			}
			if(mem_pw == ""){
				alert("패스워드를 입력하세요.");
				$('#mem_pw').focus();
				return;
			}
			//폼 내부의 데이터를 전송할 주소
			document.form1.action="member/loginCheck.do";
			document.form1.submit();
		});
	});
</script>
</head>
<body>
	<h2>로그인</h2>
		<form name="form1" method="post">
			<table border="1" width="400px">
				<tr>
					<td>아이디</td>
					<td><input name="mem_id" id="mem_id"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="mem_pw" id="mem_pw"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"></td>
						<button type="button" id="btnLogin">로그인</button>
					<c:if test="${msg == 'failure'}">
						<div style="color: red">
							아이디 또는 비밀번호가 일치하지 않습니다.
						</div>
					</c:if>
					<c:if test="${msg == 'logout'}">
						<div style="color: red">
							로그아웃되었습니다.
						</div>
					</c:if>
				</tr>
			</table>
		</form>
</body>
</html>