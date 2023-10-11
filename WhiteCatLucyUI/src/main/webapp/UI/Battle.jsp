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
		<div class="script">어떻게할까?</div>
		<button type="button" class="button-move button-effect" onclick="location.href='./BattleScript.jsp'">일반공격</button>
		<button type="button" class="button-bag button-effect" onclick="location.href='./BattleBag.jsp'">아이템 사용하기</button>
		<button type="button" class="button-rest button-effect" onclick="location.href='./BattleScript.jsp'">스킬</button>
	</div>
</body>
</html>