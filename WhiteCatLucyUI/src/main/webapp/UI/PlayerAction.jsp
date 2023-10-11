<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="../style/main.css" rel="stylesheet" type="text/css">
<link href="../style/button.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="display">
		<div class="script">무엇을할까?</div>
		<button type="button" class="button-move button-effect" onclick="location.href='./Move.jsp'">이동하기</button>
		<button type="button" class="button-bag button-effect" onclick="location.href='./Bag.jsp'">배낭열기</button>
		<button type="button" class="button-rest button-effect" onclick="location.href='./Rest.jsp'">휴식하기</button>
		<button type="button" class="button-rest button-effect" onclick="location.href='./Status.jsp'">상태확인하기</button>
	</div>
</body>
</html>