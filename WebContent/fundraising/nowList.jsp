<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!-- 카테고리(param.sort) -->
<div class="group_catelist">
	<div class="inner_catelist">
		<ul>
			<li>
				<a <c:if test="${param.topic==null or param.topic==''}"> class="on"</c:if> href="/fundraising/now?sort=1">
					<img src="${imgSrc}/ico_all.png">
					<span>전체</span>
				</a>
			</li>
			<li>
				<a <c:if test="${param.topic==1}"> class="on"</c:if> href="/fundraising/now?topic=1&sort=1">
					<img src="${imgSrc }/ico_kidz.png">
					<span>어린이</span>
				</a>
			</li>
			<li>
				<a <c:if test="${param.topic==2}"> class="on"</c:if> href="/fundraising/now?topic=2&sort=1">
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
			<a href="/fundraising/now?topic=${param.topic }&sort=1">
				<c:if test="${param.sort == 1 or param.sort == null}"><span class="box_sorting on">최신순</span></c:if>
				<c:if test="${param.sort != 1 and param.sort != null}"><span class="box_sorting">최신순</span></c:if>
			</a>
			<a href="/fundraising/now?topic=${param.topic }&sort=2">
				<c:if test="${param.sort == 2}"><span class="box_sorting on">오래된순</span></c:if>
				<c:if test="${param.sort != 2}"><span class="box_sorting">오래된순</span></c:if>
			</a>
		</span>
	</div>
	<ul class="list_fund">
		<c:forEach var="now" items="${nowList}" varStatus="status">
		<li class="listcard">
			<a href="/fundraising/now/content?ncode=${now.nCode }" class="link_content">
				<span class="img_box"><img src="${imgSrc}/for-test/${now.nImage0}"></span>
				<span class="text_box">
					<span class="title"> ${now.nTitle} </span>
					<span class="agency"> ${now.nAgency} </span>
					<span class="state">
						<span class="state_bar"></span>
						<span class="state_ing" style="width: 33%;"></span>
					</span>
					<span class="price_goal"> ${now.nPrice}원 </span>
				</span>
			</a>
		</li>
		</c:forEach>
	</ul>
</div>