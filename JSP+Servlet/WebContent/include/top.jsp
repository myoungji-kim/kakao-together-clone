<%@page import="com.dto.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="url" value="${requestScope['javax.servlet.forward.request_uri']}" />
<div id="top_wrap">
	<div id="wrap_logo">
		<a class="mainLogo" href="/main"><img src="${imgSrc}/main_logo.png"></a>
	</div>
	<nav id="wrap_topCate" class="" style="position: static; top: initial;">
		<ul class="inner">
			<li>
				<a href="/fund/now">
				<c:if test="${url eq '/main' or fn:contains(url, '/fund')}">
					<span class="on">같이기부</span></a>
				</c:if>
				<c:if test="${url ne '/main' and not fn:contains(url, '/fund')}">
					<span>같이기부</span>
				</c:if>
				</a>
			</li>
			<li>
				<a href="/prom">
				<c:if test="${fn:contains(url, '/prom')}">
					<span class="on">프로모션</span>
				</c:if>
				<c:if test="${not fn:contains(url, '/prom')}">
					<span>프로모션</span>
				</c:if>
				</a>
			</li>
			<li>
				<a href="/Error404"><span>마음날씨</span></a>
			</li>
			<li>
				<a href="/Error404"><span>더보기</span></a>
			</li>
		</ul>
	</nav>
	
	<nav id="wrap_util">
		<ul class="inner">
			<%
				MemberDTO loginDTO = (MemberDTO) session.getAttribute("login");
				if (loginDTO == null){
			%>
			<li>
				<a class="link_util link_fund" href="/join"">회원가입</a>
			</li>
			<li>
				<a class="link_util link_login" href="/login">로그인</a>
			</li>
			
			<% } else { %>
			<li>
				<c:if test="${url ne '/write'}">
				<a class="link_util link_fund" href="/write" 
				 style="background-color:#dc287c; border-color:#dc287c;">등록하기</a>
				</c:if>
			</li>
			<li>
				<a class="link_util link_login" href="/mypage" 
				 style="background-color:#333; border-color:#333; color: #fff;">마이페이지</a>
			</li>
			<li>
				<a class="link_util link_login" href="/logout.action">로그아웃</a>
			</li>
			<% } %>
			<li>
				<a class="btn_search" href="/search"><span class="ico_search"><img src="${imgSrc}/ico_search_01.svg"></span></a>
			</li>
		</ul>
	</nav>
</div>