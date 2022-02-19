<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="url" value="${requestScope['javax.servlet.forward.request_uri']}" />
<div id="top_wrap">
	<div id="wrap_logo">
		<a class="mainLogo" href="main"><img src="${imgSrc}/tit_blacklogo_190212.png"></a>
	</div>
	<nav id="wrap_topCate" class="" style="position: static; top: initial;">
		<ul class="inner">
			<li>
				<a href="/fundraising">
					<span <c:if test="${url eq '/main' or fn:contains(url, '/fundraising')}"> class="on"</c:if>>같이기부</span>
				</a>
			</li>
			<li>
				<a href="/promotion"><span <c:if test="${url eq '/promotion'}"> class="on"</c:if>>프로모션</span></a>
			</li>
			<li>
				<a href="/noPage"><span>마음날씨</span></a>
			</li>
			<li>
				<a href="/noPage"><span>더보기</span></a>
			</li>
		</ul>
	</nav>
	<nav id="wrap_util">
		<ul class="inner">
			<li>
				<a class="link_util link_fund" onclick="open_propose()" href="/fundraisings/propose">제안하기</a>
			</li>
			<li>
				<a class="link_util link_login" onclick="open_login()" href="/login">로그인</a>
			</li>
			<li>
				<a class="btn_search" onclick="open_search()" href="/search"><span class="ico_search"><img src="${imgSrc}/ico_search_01.svg"></span></a>
			</li>
		</ul>
	</nav>
</div>