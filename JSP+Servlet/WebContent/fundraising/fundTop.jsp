<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div id="contents">
	<div id="wrap_tab">
		<ul class="list_tab">
			<li>
				<a href="/fund/now?sort=1"><span <c:if test="${url eq '/main' or fn:contains(url, '/fund/now')}"> class="on"</c:if>>모금중</span></a>
			</li>
			<li>
				<a href="/fund/epil?sort=1"><span <c:if test="${fn:contains(url, '/fund/epil')}"> class="on"</c:if>>모금후기</span></a>
			</li>
			<li>
				<a href="/Error404"><span <c:if test="${fn:contains(url, '/fund/campaign')}"> class="on"</c:if>>나눔캠페인</span></a>
			</li>
		</ul>
	</div> <!-- end wrap_tab -->
</div> <!-- end contents -->