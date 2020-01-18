<?php
	system("sudo raspistill -t 500 -o ./detect123.jpg;sudo cp detect123.jpg /media/windows;");

	header('Location: http://127.0.0.1:8000/hello.do');
?>
