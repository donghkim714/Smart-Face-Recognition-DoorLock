<!DOCTYPE html>
tml>
	<head>
		<meta name="viewport" content="width=device-width, minimum-scale=0.1" charset="UTF-8">
		<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script type="text/javascript">
			var a = new XMLHttpRequest();
			a.open("GET","test3.php");
			a.onreadystatechange=function(){
				if(a.readyState==4){
					if(a.status==200){
						location.href='http://127.0.0.1:8181/member/loginCheck.do?mem_id=rlaehdgud7&mem_pw=1234';
					}
					else alert("HTTP ERROR");
					}
			}
			a.send();
		</script>
	</head>

<body>
	<center>
	<h2>Open</h2>
	</center>
</body>
</html>
