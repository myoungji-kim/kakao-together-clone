<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ include file="../include/header.jsp" %>
<%@ include file="../include/top.jsp" %>

<div id="wrap_cnt_prom">
	<!-- Title Content -->
	<div class="wrap_top_summary">
		<div class="cover">
			<div class="front-pack">
				<span class="txt_sponsor">${content.agency}</span>
				<span class="tit_visual">${content.title}</span>
			</div>
		</div>
		<div class="cont_visual" style="background-image: url('${imgSrc}/for-test/${content.image0}');">		
		</div>
	</div>
	
	<!-- Body Content -->
	<div id="body_cont">
		<div class="cont_box">
			<span class="img_ico"><img src="${imgSrc}/ico_pink_pot.png"></span>
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
	</div>
	
	<!-- 수정하기 btn -->
	<c:if test="${content.writer == login.idx}">
		<div id="btn_update">
			<a href="/write?cate=prom&idx=${content.idx}"><span>수 정</span></a>		
		</div>
	</c:if>
</div>



<%@ include file="../include/footer.jsp" %>



