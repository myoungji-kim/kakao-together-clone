<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script type="text/javascript">
	// 글 삭제
	function writeForm_delete(){
		$('input[name=mode]').val("delete");
		var cate = $('input:radio[name=cate]:checked').val();
		var idx = $('input[name=idx]').val();
		
		location.href="/del.action?cate="+cate+"&idx="+idx;
	}

	
	// 유효성 검사
	function writeForm_submit(){
		var mesg = "";
		// 종료일
		if ($('[name=enddate]').val()=="" && $('input:radio[name=cate]:checked').val() == 'prom') {
			mesg = "종료일, "+mesg;
		}
		
		// 태그
		if ($('[name=tag1]').val()=="" && $('input:radio[name=cate]:checked').val() == 'fund') {
			mesg = "태그1, "+mesg;
		}
		
		// 본문1
		if ($('[name=body1]').val()=="") {
			mesg = "본문1, "+mesg;
		}
		
		// 주제1
		if ($('[name=head1]').val()=="") {
			mesg = "주제1, "+mesg;
		}
		
		// 썸네일
		if ($('[name=image0]').val()=="") {
			mesg = "썸네일, "+mesg;
		}
		
		// 목표 금액
		if ($('[name=price]').val()=="" && $('input:radio[name=cate]:checked').val() == 'fund'){
			mesg = "목표 금액, "+mesg;
		} else if (!$.isNumeric($('[name=price]').val()) && $('[name=price]').val()!=""){
			mesg = "목표 금액(숫자만 가능), "+mesg;
		}
		
		// 카테고리
		if ($('input:radio[name=cate]').is(':checked')){
			if ($('input:radio[name=cate]:checked').val() == "fund") {
				if ($('select[name=topic]').val()=="0") mesg = "세부 카테고리, "+mesg;	
				else if ($('select[name=topic]').val()=="1" && $('select[name=subtopic]').val()=="0") mesg = "세부 주제, "+mesg;
			}
		} else {
			mesg = "카테고리, "+mesg;
		}
		
		// 제목
		if ($('[name=title]').val()=="") {
			mesg = "제목, "+mesg;
		} else if ($('[name=title]').val().length > 35){
			mesg = "제목(35자 이내), "+mesg;
		}
		console.log("제목길이 : "+$('[name=title]').val().length);
		
		// Submit
		if (mesg == "") {
			// disabled 풀어주기
			$('input[name=cate], #topic, #subtopic').attr("disabled", false);
			
			alert("등록이 완료되었습니다.");
			$('[name=writeForm]').submit();
		} else {
			mesg = mesg.slice(0, -2);
			alert(mesg+"을(를) 확인해주세요");
		}
	}
	
	function showTopicSelect(){
		if ($('input:radio[name=cate]:checked').val() == "fund"){
			$('#topic').css("visibility", "visible");
			$('#price').css("display", "");
			$('#enddate_wrap').css("display", "none");
			$('#tag_wrap').css("display", "");
		} else {
			$('#topic').css("visibility", "hidden");
			$('#subtopic').css("visibility", "hidden");
			$('#price').css("display", "none");
			$('#enddate_wrap').css("display", "");
			$('#tag_wrap').css("display", "none");
		}
	}
	
	function showSubTopicSelect(){
		if ($('select[name=topic]').val() == "1"){
			$('#subtopic').css("visibility", "visible");
		} else {
			$('#subtopic').css("visibility", "hidden");
		}
	}
	
	$(document).ready(function(){
		// update일 때 카테고리 변경 막기
		if ($('input[name=cCate]').val() != ""){
			$('input[name=cate], #topic, #subtopic').attr("disabled", "true");
			$('#topic, #subtopic').css("visibility", "visible");
		}
		
		// cate가 fund일 때 라디오 체크 및 카테고리 보여주기
		if ($('input[name=cCate]').val() == 'fund'){
			$(':radio[id="fund"]').attr("checked", true);
			$("select[name='topic']").val($('input[name="tTopic"]').val());
		}
		
		// cate가 prom일 때 라디오 
		if ($('input[name=cCate]').val() == 'prom'){
			$(':radio[id="prom"]').attr("checked", true);
		}
		
		// fund > topic이 1일 때 세부 주제 보여주기
		if ($("select[name='topic']").val() == "1"){
			$("select[name='subtopic']").val($('input[name="sSubtopic"]').val());
		}
		
		// prom일 때 enddate 입력창 보여주기
		if ($('input:radio[name=cate]:checked').val() == "prom"){
			$('#enddate_wrap').css("display", "");
		} else {
			$('#enddate_wrap').css("display", "none");
		}
		
	})
	
	// DatePicker
	$.datepicker.setDefaults({
	    dateFormat: 'yy.mm.dd',
	    prevText: '이전 달',
	    nextText: '다음 달',
	    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
	    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
	    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
	    showMonthAfterYear: true,
	    yearSuffix: '년',
	
	});
	
	$(function() {
	  $("#enddate").datepicker();
	} );
</script>


<form action="/write.action" method="post" name="writeForm">
<c:choose>
	<c:when test="${not empty content}">
		<c:set var="mode" value="update"/>
		<c:set var="idx" value="${content.idx}"/>
		<c:set var="topic" value="${content.topic}"/>
		<c:set var="title" value="${content.title}"/>
		<c:set var="writer" value="${content.writer}"/>
		<c:set var="price" value="${content.price}"/>
		<c:set var="image0" value="${content.image0}"/>
		<c:set var="head1" value="${content.head1}"/>
		<c:set var="body1" value="${content.body1}"/>
		<c:set var="image1" value="${content.image1}"/>
		<c:set var="youtube1" value="${content.youtube1}"/>
		<c:set var="tag1" value="${content.tag1}"/>
		<c:set var="tag2" value="${content.tag2}"/>
		<c:set var="tag3" value="${content.tag3}"/>
		<c:set var="subtopic" value="${content.subtopic}"/>
		<c:set var="cate" value="${content.cate}"/>
		<c:set var="enddate" value="${content.enddate}"/>
	</c:when>
	<c:when test="${empty content}"> 
		<c:set var="mode" value="insert"/>
		<c:set var="idx" value=""/>
		<c:set var="title" value=""/>
		<c:set var="writer" value="${login.idx}"/>
		<c:set var="price" value=""/>
		<c:set var="image0" value=""/>
		<c:set var="head1" value=""/>
		<c:set var="body1" value=""/>
		<c:set var="image1" value=""/>
		<c:set var="youtube1" value=""/>
		<c:set var="tag1" value=""/>
		<c:set var="tag2" value=""/>
		<c:set var="tag3" value=""/>
		<c:set var="cate" value=""/>
		<c:set var="enddate" value=""/>
	</c:when>
</c:choose>
<div id="wrap_write">
	<input type="hidden" name="idx" value="${idx}">
	<input type="hidden" name="mode" value="${mode}">
	<input type="hidden" name="cCate" value="${cate}">
	<input type="hidden" name="writer" value="${writer}"> 
	<input type="hidden" name="tTopic" value="${topic}">
	<input type="hidden" name="sSubtopic" value="${subtopic}">
	<table class="main">
		<tr>
			<td colspan="3">
				<div class="top_title">
					<span class="light">
						<c:if test="${mode =='insert'}">글 등록하기</c:if>
						<c:if test="${mode =='update'}">글 수정하기</c:if>
					</span>
				</div>
			</td>
		</tr>
		<tr class="tr_oneLine">
			<th><span>제목</span></th>
			<td colspan="2"><div class="bottom_line"><input type="text" id="title" name="title" placeholder="제목을 입력해주세요" value="${title}"></div></td>
		</tr>
		<tr class="tr_oneLine">
			<th><span>작성자</span></th>
			<td colspan="2"><div class="bottom_line"><input readonly="readonly" id="agency" name="agency" value="${login.username}"></div></td>
		</tr>
	
		<tr class="tr_oneLine">
			<th>카테고리 분류</th>
			<td style="width: 40%;">
				<label>
					<input type="radio" id="fund" name="cate" value="fund" onclick="showTopicSelect()">같이기부
				</label>
				<!-- 모음중/모음후기/나눔캠페인 관련 카테고리 -->
	 			<select id="topic" name="topic" class="topic" onclick="showSubTopicSelect()">
					<option value="0">카테고리 선택</option>
					<option value="1">모금중</option>
					<option value="2">모금후기</option>
					<option value="3">나눔캠페인</option>
				</select> 
				<!-- '모금중'일 경우 주제 선택 -->
				<select id="subtopic" name="subtopic" class="subtopic">
					<option value="0">주제 선택</option>
					<option value="A">어린이</option>
					<option value="B">여성</option>
				</select>
			</td>
			<td>
				<label><input type="radio" name="cate" id="prom" value="prom" onclick="showTopicSelect()">프로모션</label>
			</td>
		</tr>
		<tr class="tr_oneLine" id="price" style="display:<c:if test="${cate != 'fund'}">none</c:if>">
			<th id="price"><span>목표 금액</span></th>
			<td colspan="2"><div class="bottom_line"><input type="text" name="price" placeholder="단위를 제외한 숫자를 적어주세요 (ex. 1000000)" value="${price}" autocomplete="off"></div></td>
		</tr>
		<tr class="tr_oneLine">
			<th>썸네일 등록</th>
			<td colspan="2"><div class="bottom_line"><input type="file" id="image0" name="image0" value="${image0}">${image0}</div></td>
		</tr>
		<tr class="tr_oneLine">
			<th>주제1</th>
			<td colspan="2"><div class="bottom_line"><input type="text" id="head1" name="head1" placeholder="주제를 입력해주세요" value="${head1}"></div></td>
		</tr>
		<tr>
			<th>본문1</th>
			<td colspan="2"><textarea name="body1" placeholder="내용을 입력해주세요">${body1}</textarea></td>
		</tr>
		<tr>
			<th class="tr_oneLine">이미지1</th>
			<td colspan="2"><div class="bottom_line"><input type="file" id="image1" name="image1" value="${image1}">${image1}</div></td>
		</tr>
		<tr class="tr_oneLine">
			<th>첨부영상</th>
			<td colspan="2"><div class="bottom_line"><input type="text" id="youtube1" name="youtube1" value="${youtube1}" placeholder="유튜브 url을 입력해주세요"></div></td>
		</tr>
		<tr id = "tag_wrap" style="display: none">
			<th class="tr_oneLine">태그 설정</th>
			<td colspan="2">
				<div class="input_tag"><input type="text" name="tag1" value="${tag1}" placeholder="태그1 (필수)"></div>
				<div class="input_tag"><input type="text" name="tag2" value="${tag2}" placeholder="태그2 (선택)"></div>
				<div class="input_tag"><input type="text" name="tag3" value="${tag3}" placeholder="태그3 (선택)"></div>
			</td>
		</tr>
		<tr class="tr_oneLine" id="enddate_wrap" style="display: none">
			<th>종료일</th>
			<td colspan="2"><div class="bottom_line"><input type="text" id="enddate" name="enddate" placeholder="종료일을 선택해주세요" value="${enddate}" autocomplete="off"></div></td>
		</tr>
	
	</table>
	
	<div class="wrap_btn">
		<a class="submit_box" onclick="writeForm_submit()">
			<c:if test="${mode =='insert'}">등록하기</c:if>
			<c:if test="${mode =='update'}">수정하기</c:if>
		</a>
		<c:if test="${mode =='update'}">
			<a class="delete_box" onclick="writeForm_delete(${cate})"> 삭제하기 </a>
		</c:if>
	</div>
	
</div>
</form>
