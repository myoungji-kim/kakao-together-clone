<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div id="prom_wrap">
	<ul>
		<c:forEach var="mywrite" items="${mywriteList}" varStatus="status">
		<li>	
			<c:if test="${mywrite.cate == 'fund'}">
			<a href="/fund/now/content?idx=${mywrite.idx}&subtopic=${mywrite.subtopic}" class="link_card">
			</c:if>
			<c:if test="${mywrite.cate == 'prom'}">
			<a href="/prom/content?idx=${mywrite.idx}" class="link_card">
			</c:if>
				<span class="thumb_img">
					<img src="${imgSrc}/for-test/${mywrite.image0}">
				</span>
				<div class="text_box">
					<span class="title">
						${mywrite.title}
					</span>
					<span class="cate">
						<c:if test="${mywrite.cate == 'fund'}">같이기부</c:if>
						<c:if test="${mywrite.cate == 'prom'}">프로모션</c:if>
					</span>
					<span class="date">작성일 : ${mywrite.writeday}</span>
				</div>
			</a>
		</li>
		</c:forEach>
	</ul>
	
	<div id="wrap_paging">
		<!-- prev 버튼 -->
		<c:if test="${page.btnPrev}">
			<a class="btn_prev" href="?no=${page.beginPage-1}&phase=${param.phase}">
				<span>이전</span>
			</a>
		</c:if>
	
		<!-- 페이징 넘버 -->
		<c:forEach var="i" begin="${page.beginPage}" end="${page.endPage}">
			<a class="page_num" href="?no=${i}&phase=${param.phase}">
				<span
					<c:if test="${param.no==i || ((param.no=='' || param.no==null) && i==1)}">
						 style="color:#dc287c; border-color: #dc287c;"
					</c:if>
				>${i}</span>
			</a>
		</c:forEach>
	
		<!-- next 버튼 -->
		<c:if test="${page.btnNext}">
			<a class="btn_next" href="?no=${page.endPage+1}&phase=${param.phase}">
				<span style="">다음</span>
			</a>
		</c:if>
	</div>
</div>

