<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="contents">
<!-- 검색창 -->
<div class="wrap_search">
	<form class="searchForm" method="get">
		<div class="box_search">
			<input placeholder="검색어를 입력하세요" name="search" class="input_search">
		</div>
		<button type="button" class="btn_delete">
			<span class="ico_delete">삭제</span>
		</button>
		<button type="submit" class="btn_search">
			<span class="ico_search">검색</span>
		</button>
	</form>
</div>

<!-- 게시글 모음 -->
<div class="group_fundlist">
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
</div>