<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="epil_top_span">
	<span>응원, 공유하면 기부되는 가장 쉬운 나눔</span>
</div>
<!-- 게시글 모음 -->
<div class="group_fundlist">
	<div class="sort_cate">
		<span class="inner_sort_cate">
			<a href="/fund/epil?sort=1">
				<c:if test="${param.sort == 1 or param.sort == null}"><span class="box_sorting on">최신순</span></c:if>
				<c:if test="${param.sort != 1 and param.sort != null}"><span class="box_sorting">최신순</span></c:if>
			</a>
			<a href="/fund/epil?sort=2">
				<c:if test="${param.sort == 2}"><span class="box_sorting on">오래된순</span></c:if>
				<c:if test="${param.sort != 2}"><span class="box_sorting">오래된순</span></c:if>
			</a>
		</span>
	</div>
	<ul class="list_fund">
		<c:forEach var="epil" items="${epilList}" varStatus="status">
		<li class="listcard">
			<a href="/fund/epil/content?idx=${epil.idx}" class="link_content">
				<span class="img_box"><img src="${imgSrc}/for-test/${epil.image0}"></span>
				<span class="text_box">
					<span class="title"> ${epil.title} </span>
					<span class="agency"> ${epil.agency} </span>
					<span class="state">
						<span class="state_bar"></span>
						<c:if test="${epil.pricestate > epil.price}">
							<c:set var="state" value="120"/>
						</c:if>
						<c:if test="${epil.pricestate <= epil.price}">
							<c:set var="state" value="${epil.pricestate/epil.price*100}"/>
						</c:if>
						
						<span class="state_ing" style="width: ${state}px; background-color:#444;"></span>
					</span>
					<span class="price_goal"> ${epil.priceChar}원 </span>
				</span>
			</a>
		</li>
		</c:forEach>
	</ul>
</div>