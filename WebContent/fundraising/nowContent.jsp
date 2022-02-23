<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp" %>
<%@ include file="../include/top.jsp" %>


<div id="wrap_content">
	<!-- Title Content -->
	<div class="wrap_top_summary">
		<div class="cover">
			<div class="front-pack">
				<span class="tit_visual">${nowContent.title }</span>
				<span class="txt_sponsor">${nowContent.agency }</span>
				<div class="hash_group">
					<a class="topic_hash">${subtopic}</a>
					<a class="link_hash">${nowContent.tag1}</a>
					<c:if test="${nowContent.tag2 ne null}">
						<a class="link_hash">${nowContent.tag2}</a>
					</c:if>
					<c:if test="${nowContent.tag3 ne null}">
						<a class="link_hash">${nowContent.tag3}</a>
					</c:if>
				</div>
			</div>
		</div>
		<div class="cont_visual" style="background-image: url('${imgSrc}/for-test/${nowContent.image0}');">		
		</div>
	</div>
	<!-- Body Content -->
	<div id="body_cont">
		<div class="cont_box">
			<span class="tit_head">${nowContent.head1}</span>
			<span class="txt_body">${nowContent.body1}</span>
			<span class="img_body" style="background-image: url('${imgSrc}/for-test/${nowContent.image1 }');"></span>
		</div>
	</div>
	<!-- 수정하기 btn -->
	<c:if test="${nowContent.writer == login.idx}">
		<div id="btn_update">
			<a href="/write?cate=fund&idx=${nowContent.idx}"><span>수 정</span></a>		
		</div>
	</c:if>
</div>



<%@ include file="../include/footer.jsp" %>
