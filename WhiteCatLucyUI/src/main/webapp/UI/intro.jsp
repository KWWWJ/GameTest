<%@page import="javax.swing.Box"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="../style/main.css" rel="stylesheet" type="text/css">
<link href="../style/button.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Intro</title>
</head>
<body>
	<div class="display">
		<div class="scriptBox">
			<jsp:forward page="../../WhiteCatLucyServlet/intro.java">
				<jsp:param value="" name=""/>
			</jsp:forward>
		</div>
		<button type="button" class="button-title" onclick="다음스크립트">
			<img class="butten-hover" alt="발바닥이미지" src="../image/whitefoot.png" style="width:80px; height:120px;">
		</button>
		<button type="button" class="button-temporary" onclick="location.href='./tutoral.jsp' ">임시 이동버튼</button>
	</div>
</body>
</html>