<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!-- 카테고리(param.sort) -->
<div class="group_catelist">
	<div class="inner_catelist">
		<ul>
			<li>
				<a <c:if test="${param.topic==1}"> class="on"</c:if> href="/fundraising/now?topic=1">
					<img src="${imgSrc}/ico_all.png">
					<span>전체</span>
				</a>
			</li>
			<li>
				<a <c:if test="${param.topic==2}"> class="on"</c:if> href="/fundraising/now?topic=2">
					<img src="${imgSrc }/ico_kidz.png">
					<span>어린이</span>
				</a>
			</li>
			<li>
				<a <c:if test="${param.topic==3}"> class="on"</c:if> href="/fundraising/now?topic=3">
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
			<span class="box_sorting on">추천순</span>
			<span class="box_sorting">최신순</span>
		</span>
	</div>
	<ul class="list_fund">
		<li class="listcard">
			<a href="" class="link_content">
				<span class="img_box"><img src="${imgSrc}/for-test/survey_01.png"></span>
				<span class="text_box">
					<span class="title"> 소상공인분들께 전달하는 아이들의 응원의 메세지 </span>
					<span class="agency"> 큰별지역아동센터 </span>
					<span class="state">
						<span class="state_bar"></span>
						<span class="state_ing" style="width: 33%;"></span>
					</span>
					<span class="price_goal"> 318,600원 </span>
				</span>
			</a>
		</li>
	
	</ul>
</div>