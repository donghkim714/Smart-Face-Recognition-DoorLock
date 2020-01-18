<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록 페이지</title>
</head>
<body>
	<h2>회원 등록 폼</h2>
	<form name="dto" method="post" action="${path}/member/insert.do">
		<table border="1" width="400px">
			<tr>
				<td>아이디</td>
				<td><input type="text"name="mem_id" id="mem_id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" id="mem_pw" name="mem_pw"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input name="mem_name" id="mem_name"></td>
			</tr>
			<tr>
				<td>생일</td>
				<td><input type="date" name="mem_birth" id="mem_birth"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="mem_email" id="mem_email"></td>
			</tr>
			<tr>
				<td>폰번호</td>
				<td><input type="number" name="mem_phone" id="mem_phone"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="radio" name="mem_gender" id="mem_gender" value="m">남자</td>
				<td><input type="radio" name="mem_gender" id="mem_gender" value="f">여자</td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="mem_address" id="mem_address"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="확인"	>
					<input type="reset"	 value="취소">			
				</td>
			</tr>
		</table>
	</form>
</body>
</html>