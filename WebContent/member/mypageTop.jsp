<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div id="contents">
	<div id="wrap_tab">
		<ul class="list_tab">
			<li>
				<a href="/mypage"><span <c:if test="${url eq '/mypage'}"> class="on"</c:if>>내 정보</span></a>
			</li>
			<li>
				<a href="/Error404"><span <c:if test="${fn:contains(url, '/mypage/mywrite')}"> class="on"</c:if>>나의 글</span></a>
			</li>
			<li>
				<a href="/Error404"><span <c:if test="${fn:contains(url, '/mypage/mydonation')}"> class="on"</c:if>>내 기부</span></a>
			</li>
		</ul>
	</div> <!-- end wrap_tab -->
</div> <!-- end contents -->