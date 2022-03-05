<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="../include/header.jsp" %>
<%@ include file="../include/top.jsp" %>

<div id="wrap_content">
	<c:if test="${login.idx eq null}"><c:set var="loginIdx" value="0"/></c:if>
	<c:if test="${login.idx ne null}"><c:set var="loginIdx" value="${login.idx}"/></c:if>
	<!-- Title Content -->
	<div class="wrap_top_summary">
		<div class="cover">
			<div class="front-pack">
				<span class="tit_visual">${content.title}</span>
				<span class="txt_sponsor">${content.agency}</span>
				<div class="hash_group">
					<a class="topic_hash">${subtopic}</a>
					<a class="link_hash">${content.tag1}</a>
					<c:if test="${content.tag2 ne null}">
						<a class="link_hash">${content.tag2}</a>
					</c:if>
					<c:if test="${content.tag3 ne null}">
						<a class="link_hash">${content.tag3}</a>
					</c:if>
				</div>
			</div>
		</div>
		<div class="cont_visual" style="background-image: url('${imgSrc}/for-test/${content.image0}');">		
		</div>
	</div>
	<!-- Body Content -->
	<div id="body_cont">
		<div class="cont_box">
			<span class="tit_head">${content.head1}</span>
			<span class="txt_body">${content.body1}</span>
			<c:if test="${content.image1 ne null}">
			<span class="img_body" style="background-image: url('${imgSrc}/for-test/${content.image1}');"></span>
			</c:if>
			<c:if test="${content.youtube1 ne null}">
			<div class="video_wrap">
				<iframe class="video" src="${content.youtube1}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen=""> 
				</iframe>
			</div>	
			</c:if>	
		</div>
		
		<div class="price_box">
			<span class="txt_price">${content.pricestate}<span class="txt_won">원</span></span>
			<span class="txt_state">${content.price}원 목표</span>
		</div>
	</div>
	<!-- 수정하기 btn -->
	<c:if test="${content.writer == loginIdx}">
		<div id="btn_update">
			<a href="/write?cate=fund&idx=${content.idx}"><span>수 정</span></a>		
		</div>
	</c:if>
</div>

<%@ include file="../include/footer.jsp" %>
