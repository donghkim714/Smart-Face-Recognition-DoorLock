<!DOCTYPE html>
<html>
<head>
  <style>
	table{
		border : 1px solid #444444;
	      }
   </style>	
   <title>2차 비밀번호</title>	
   <script type="text/javascript">
      var flag=false;//0이 있는 상태
	function gotoCheck(){
		cal.action="http://192.168.43.70:8181/second/secondCheck.do";
		cal.submit();
	} 

      function operation(num){
         if (flag==false) {//초기화//0이 없는 상태로 만들기
            //flag=false;
            cal.second_pw.value="";//값 초기화
            flag= true;//0이 없는 상태가 됨
         }
 
         cal.second_pw.value+=num;
      }
      function dream(){//result에 출력 함수
         var str = cal.second_pw.value;
         cal.second_pw.value = eval(cal.second_pw.value);
 
      }
      function c(){//clear버튼
         if (flag==true) {//0이 없는 상태
            flag=false;//0이 있는 상태
         cal.second_pw.value = "";
         }
      }
      function bs() {
         cal.second_pw.value = cal.second_pw.value.substring(0, cal.second_pw.value.length-1);
     
      }
   </script>
</head>
<body>
<div align="center">
<h2>판독실패 2차 비밀번호 입력!</h2>
<p></p>
<form name="cal">
<table>
   <!-- 첫번째 줄 -->
   <tr>
      <td colspan="3"><input style="text-align: right;" type="password" name="second_pw" id ="second_pw" value="0" ></td>
   </tr>
   <!-- 두번째 줄 -->
   <tr>
      <td colspan="2" align="center"><input type="button" name="clear" value="Clear" onclick="c()"></td>
      <td><input type="button" name="backspace" value="<--"
         onclick="bs()"></td>
   </tr>
   <!-- 세번째 줄 -->
   <tr>
      <td align="right">
         <input type="button"  value="1" onclick="operation('1')"></td>
      <td align="center">
         <input type="button"  value="2" onclick="operation('2')"></td>
      <td><input type="button"  value="3" onclick="operation('3')"></td>
   </tr>
   <!-- 네번째 줄 -->
   <tr>
      <td align="right"><input type="button"  value="4" onclick="operation(value)"></td>
      <td align="center">
         <input type="button"  value="5" onclick="operation(value)"></td>
      <td><input type="button"  value="6" onclick="operation(value)"></td>
   </tr>
   <!-- 다섯번째 줄 -->
   <tr>
      <td align="right"><input type="button"  value="7" onclick="operation(value)"></td>
      <td align="center">
         <input type="button"  value="8" onclick="operation(value)"></td>
      <td><input type="button"  value="9" onclick="operation(value)"></td>
   </tr>
   <tr>
      <td align="center" colspan="3"><input type="button" name="oper" value="확인" onClick="gotoCheck()"></td
</tr>

</table> 
</div>
</body>
</html>

