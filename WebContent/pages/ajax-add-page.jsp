<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="/Laitiqiu/widgets/jquery/jquery-2.1.3.min.js"></script>

<title>Spring MVC - jQuery 整合教程</title>

</head>
<body>

	<h3>Spring MVC - jQuery 整合教程</h3>
	<h4>AJAX version</h4>

	Demo 1
	<div style="border: 1px solid #ccc; width: 250px;">
		Add Two Numbers: <br /> <input id="inputNumber1" type="text" size="5">
		+ <input id="inputNumber2" type="text" size="5"> <input
			type="submit" value="Add" onclick="add()" /> <br /> Sum: <span
			id="sum">(Result will be shown here)</span>
	</div>


	<script type="text/javascript">
		function add() {
			$.post("/Laitiqiu/ajaxController/add2.do", {
				inputNumber1 : $("#inputNumber1").val(),
				inputNumber2 : $("#inputNumber2").val()
			}, function(data, status, xhr) {
				if (status == "success")
					alert(data);
				if (status == "error")
					alert("Error: " + xhr.status + ": " + xhr.statusText);
			});
		}
	</script>
</body>
</html>
