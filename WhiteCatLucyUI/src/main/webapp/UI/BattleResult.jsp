<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!

	public boolean end = false;
	
%>
    
<!DOCTYPE html>
<html>
<head>
<link href="../style/style.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Event</title>
</head>
<body>
	<div class="display">
		<%if(end == false) {%>
		<div class="script">전투 결과 표기</div>
		<button type="button" class="button-script button-effect" onclick="location.href='./PlayerActionScript.jsp'">next</button>
		<%} %>
		<%if(end == true) {%>
		<div class="script">end</div>
		<button type="button" class="button-script button-effect" onclick="location.href='./Ending.jsp'">next</button>
		<%} %>
	</div>
</body>
</html>