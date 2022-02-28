<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div id="prom_wrap">
	<ul>
		<c:forEach var="prom" items="${promList}" varStatus="status">
		<li>
			<a href="prom/content?idx=${prom.idx}" class="link_card">
				<span class="thumb_img">
					<img src="${imgSrc}/for-test/${prom.image0}">
				</span>
				<div class="text_box">
					<span class="title">
						${prom.title}
					</span>
					<span class="cate">프로모션</span>
					<span class="date">${prom.writeday}~${prom.enddate}</span>
				</div>
			</a>
		</li>
		</c:forEach>
	</ul>
	
	<div style="margin: auto; text-align: center; margin-bottom: 15px;">
		<!-- prev 버튼 -->
		<c:if test="${page.btnPrev}">
			<a style="color: green;" href="?no=${page.beginPage-1}&phase=${param.phase}"><span
				style="border-bottom: 1px solid green;">이전</span></a>
		</c:if>
	
		<!-- 페이징 넘버 -->
		<c:forEach var="i" begin="${page.beginPage}" end="${page.endPage}">
			<a style="color: black;" href="?no=${i}&phase=${param.phase}"><span
				style="border-bottom: 1px solid black;">${i}</span></a>
		</c:forEach>
	
		<!-- next 버튼 -->
		<c:if test="${page.btnNext}">
			<a style="color: green;" href="?no=${page.endPage+1}&phase=${param.phase}"><span
				style="border-bottom: 1px solid green;">다음</span></a>
		</c:if>
	</div>
</div>

