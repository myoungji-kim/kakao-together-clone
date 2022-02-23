<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!-- 카테고리(param.sort) -->
<div class="group_catelist">
	<div class="inner_catelist">
		<ul>
			<li>
				<a <c:if test="${param.subtopic==null or param.subtopic==''}"> class="on"</c:if> href="/fund/now?sort=1">
					<img src="${imgSrc}/ico_all.png">
					<span>전체</span>
				</a>
			</li>
			<li>
				<a <c:if test="${param.subtopic=='A'}"> class="on"</c:if> href="/fund/now?subtopic=A&sort=1">
					<img src="${imgSrc }/ico_kidz.png">
					<span>어린이</span>
				</a>
			</li>
			<li>
				<a <c:if test="${param.subtopic=='B'}"> class="on"</c:if> href="/fund/now?subtopic=B&sort=1">
					<img src="${imgSrc }/ico_woman.png">
					<span>여성</span>
				</a>
			</li>
		</ul>
	</div>
</div> <!-- end: group_catelist -->

<!-- 게시글 모음 -->
<div class="group_fundlist">
	<div class="sort_cate">
		<span class="inner_sort_cate">
			<a href="/fund/now?topic=${param.subtopic }&sort=1">
				<c:if test="${param.sort == 1 or param.sort == null}"><span class="box_sorting on">최신순</span></c:if>
				<c:if test="${param.sort != 1 and param.sort != null}"><span class="box_sorting">최신순</span></c:if>
			</a>
			<a href="/fund/now?topic=${param.subtopic }&sort=2">
				<c:if test="${param.sort == 2}"><span class="box_sorting on">오래된순</span></c:if>
				<c:if test="${param.sort != 2}"><span class="box_sorting">오래된순</span></c:if>
			</a>
		</span>
	</div>
	<ul class="list_fund">
		<c:forEach var="now" items="${nowList}" varStatus="status">
		<li class="listcard">
			<a href="/fund/now/content?idx=${now.idx}" class="link_content">
				<span class="img_box"><img src="${imgSrc}/for-test/${now.image0}"></span>
				<span class="text_box">
					<span class="title"> ${now.title} </span>
					<span class="agency"> ${now.agency} </span>
					<span class="state">
						<span class="state_bar"></span>
						<span class="state_ing" style="width: ${now.pricestate/now.price*100}px;"></span>
					</span>
					<span class="price_goal"> ${now.priceChar}원 </span>
				</span>
			</a>
		</li>
		</c:forEach>
	</ul>
</div>