<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp" %>
 
<script type="text/javascript">
	var ref = document.referrer;
	function login_submit(){
		if ($('[name=userid]').val()=="" || $('[name=passwd]').val()==""){
			alert("아이디 및 비밀번호를 확인해주세요");
		} else {
			if (ref.indexOf("/member/sessionInvalidate.jsp") != -1){
				$('[name=next]').val("/main");
			} else {
				$('[name=next]').val(ref);
			}
			$('[name=loginForm]').submit();
		}
	}

</script>

<div id="top_wrap"><div id="wrap_logo">
	<a class="mainLogo" href="/main"><img src="${imgSrc}/tit_blacklogo_190212.png"></a>
</div></div>

<div id="page_login">
	<div id="main">
		<div class="title">
			<span class="light">당신의 <span class="bold">착한 마음</span>을</span>
			<span class="light">응원합니다 ♡</span>
		</div>
		<form action="/login.action" id="login_form" name="loginForm" method="post">
			<input type="hidden" name="next">
			<div class="item_box"> 
				<div><input type="text" id="userid" name="userid" placeholder="아이디를 입력하세요" autocomplete="off"></div>
			</div>
			<div class="item_box">
				<div><input type="text" id="passwd" name="passwd" placeholder="비밀번호를 입력하세요" autocomplete="off"></div>
			</div>
			<div class="wrap_btn">
				<a class="submit_box" onclick="login_submit()"><span>로그인</span></a>
				<span class="line_or">
					<span class="lineL"></span>
					<span class="txt_or">또는</span>
					<span class="lineR"></span>
				</span>
			</div>
		</form>
		
	</div>
</div>

<%@ include file="../include/footer.jsp" %>