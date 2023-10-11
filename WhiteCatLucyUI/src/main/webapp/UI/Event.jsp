<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="../style/main.css" rel="stylesheet" type="text/css">
<link href="../style/button.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Event</title>
</head>
<body>
	<div class="display">
		<div class="script">이벤트 스크립트. 만약 확률로 전투가 일어나면 redirect로 battle에 보내기. 전투가 일어나지 않았다면 바로 PlayerActionScript로 이동. 조건 달성시 엔딩으로 이동</div>
		<button type="button" class="button-script button-effect" onclick="스크립트 넘기기">next</button>
		<button type="button" class="button-temporary" onclick="location.href='./BattleStart.jsp' ">임시 이동버튼</button>
	</div>
</body>
</html>