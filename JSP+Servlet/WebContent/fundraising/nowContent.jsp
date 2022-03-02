<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp" %>
<%@ include file="../include/top.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){  
	    // Scroll 위치에 따라 하단바 불투명도 조절
	    $(window).scroll(function(){
	    	var scrollBottom = $(document).height() - $(window).height() - $(window).scrollTop();
	        if (scrollBottom < $('#wrap_footer').height()){
	        	$('.fund_float').css('opacity', 0.3);
	        } else {
	        	$('.fund_float').css('opacity', 1);
	        }
	    })
	})

	var httpRequest;
	var gCheer;
	
	function cheer(cIdx, mIdx){
		if (mIdx != 0){
			httpRequest = new XMLHttpRequest();
			httpRequest.onreadystatechange=responseFun;
			gCheer = parseInt($('.num_active').text()) + 1;
			
			var url = "/fund/insertCheer?cIdx="+cIdx+"&mIdx="+mIdx;
			
			httpRequest.open("get", url, true);
			httpRequest.send(null);
		} else {
			alert("로그인 후 이용 가능합니다");
		}
	}
	
	
	function responseFun(){
		if(httpRequest.readyState==4 & httpRequest.status == 200){
			alert("응원해 주셔서 감사합니다♬");
			$('.num_active').text(gCheer);
		}
	}
	
	
	function donate(){
		
	}
</script>

<div id="wrap_content">
	<c:if test="${login.idx eq null}">
		<c:set var="loginIdx" value="0"/>
	</c:if>
	<c:if test="${login.idx ne null}">
		<c:set var="loginIdx" value="${login.idx}"/>
	</c:if>
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
			<span class="img_body" style="background-image: url('${imgSrc}/for-test/${content.image1 }');"></span>
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
	<c:if test="${content.writer == loginIdx}">
		<div id="btn_update">
			<a href="/write?cate=fund&idx=${content.idx}"><span>수 정</span></a>		
		</div>
	</c:if>
	
	<!-- 응원하기 하단바 -->
	<div class="fund_float">
		<a class="btn_c" onclick="cheer(${content.idx}, ${loginIdx})">
			<span class="ico_cheer"><img src="${imgSrc}/ico_cheer.svg"></span>
			<span class="txt_cheer">응원</span>
			<span class="num_active">${cheer}</span>
			<div class="after"></div>
		</a>
		<a class="btn_s" onclick="share()">
			<span class="ico_share"><img src="${imgSrc}/ico_share.svg"></span>
			<span class="txt_share">공유</span>
		</a>
		<a class="btn_d" onclick="donate(${content.idx}, ${loginIdx})">
			<span>기부하기</span>
		</a>
	</div>
</div>



<%@ include file="../include/footer.jsp" %>
