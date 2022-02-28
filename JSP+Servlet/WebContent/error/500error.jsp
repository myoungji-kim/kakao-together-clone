<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp" %>

<div style="width: 600px; margin: 100px auto; text-align:center; font-family: KakaoBold; font-size: 30px; color: #555;">
	<img style="width:100%; border-radius:30px; over-flow:hidden;" src="${imgSrc }/500error.jpg">
	<div style="margin-top: 20px;">
		<span>페이지에 문제가 있나봐요</span><br>
		<span style="font-family: KakaoLight; font-size: 20px;">잠시만 기다려주세요! (500)</span><br>
		<a href="javascript:history.back()" style="display: inline-block; margin-top: 30px; padding:6px 25px 10px; border-radius:10px; background-color:#4B89DC;"><span style="color:#fff; font-size: 20px; font-family: KakaoLight">뒤로가기</span></a>
	</div>
</div>

</body>
</html>