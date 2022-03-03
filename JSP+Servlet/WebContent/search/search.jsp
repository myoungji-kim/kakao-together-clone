<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	function fSearch(f){
		f.method = "get";
		f.submit();
	}
	
	function search_delete(){
		$('input[name=q]').val("");
	}
</script>


<div id="contents">
<!-- 검색창 -->
<div class="wrap_search">
	<form name="searchForm" class="searchForm" method="get">
		<div class="box_search">
			<input placeholder="검색어를 입력하세요" name="q" value="${param.q}" class="input_search">
		</div>
		<a class="btn_delete" onclick="search_delete()">
			<span class="ico_delete">
				<img src="${imgSrc}/ico_delete_01.svg">
			</span>
		</a>
		<a class="btn_search" onclick="fSearch(searchForm)">
			<span class="ico_search">
				<img src="${imgSrc}/ico_search_01.svg">
			</span>
		</a>
	</form>
</div>

<!-- 게시글 모음 -->
<div class="group_fundlist">
	<ul class="list_fund">
		<c:if test="${searchList == null}">
			<div class="search_none">
				<span> 아직 아무것도 검색하지 않았어요! </span>
			</div>
		</c:if>
		<c:forEach var="search" items="${searchList}" varStatus="status">
		<li class="listcard">
			<c:if test="${search.cate == 'fund'}">
			<a href="/fund/now/content?idx=${search.idx}&subtopic=${search.subtopic}" class="link_content">
			</c:if>
			<c:if test="${search.cate == 'prom'}">
			<a href="/prom/content?idx=${search.idx}" class="link_content">
			</c:if>
				<span class="img_box"><img src="${imgSrc}/for-test/${search.image0}"></span>
				<span class="text_box">
					<span class="title"> ${search.title} </span>
					<span class="search_agency"> ${search.agency} </span>
					<span class="search_cate">
						<c:if test="${search.cate == 'fund'}">같이기부</c:if>
						<c:if test="${search.cate == 'prom'}">프로모션</c:if>
					</span>
				</span>
			</a>
		</li>
		</c:forEach>
	</ul>
</div>
</div>