<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp" %>

<script type="text/javascript">
	// 유효성 검사
	function mypage_submit(){
		var mesg = "";
		// 이메일
		if ($('[name=email1]').val()=="" || $('[name=email2]').val()=="") {
			mesg = "이메일, "+mesg;
		}
		
		// 전화번호
		if ($('[name=post]').val()=="" || $('[name=addr1]').val()=="" || $('[name=addr2]').val()=="") {
			mesg = "전화번호, "+mesg;
		}
		
		// 주소
		if ($('[name=post]').val()=="" || $('[name=addr1]').val()=="" || $('[name=addr2]').val()=="") {
			mesg = "주소, "+mesg;
		}

		// Submit
		if (mesg == "") {
			alert("정보수정이 완료되었습니다.");
			$('[name=joinForm]').submit();
		} else {
			mesg = mesg.slice(0, -2);
			alert(mesg+"을(를) 확인해주세요");
		}
	}
	
	// id랑 함수명 겹치면 error남
	// 선택한 이메일 자동 insert
	function f_emailSelect(obj){
		$('[name=email2]').val(obj.value);
	}
</script>

<div id="top_wrap"><div id="wrap_logo">
	<a class="mainLogo" href="/main"><img src="${imgSrc}/tit_blacklogo_190212.png"></a>
</div></div>

<div id="page_join">
	<div id="main">
		<div class="title">
			<span class="light"> 회원정보 수정 </span>
		</div>
		<form action="/mypage.action" id="join_form" name="joinForm" method="post">
			<input type="hidden" name="idx" value="${member.idx }">
			<table class="join_table">
				<tr>
					<td class="item_th">
						<div><span>이름</span></div>
					</td>
					<td class="item_box">
						<div><input readonly="readonly" id="username" name="username" value="${member.username }"></div>
					</td>
				</tr>
				<tr>
					<td class="item_th">
						<div><span>아이디</span></div>
					</td>
					<td class="item_box">
						<div><input readonly="readonly" id="userid" name="userid" onkeyup="idCheck()" value="${member.userid }"></div>
					</td>
				</tr>
				<tr>
					<td class="item_th">
						<div><span>비밀번호</span></div>
					</td>
					<td class="item_box">
						<div><input readonly="readonly" id="passwd" name="passwd" value="${member.passwd }"></div>
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td class="td_addr" style="margin-top: 10px;">
						<input type="text" name="post" id="postcode" value="${member.post }" style="margin-top: 10px;" autocomplete="off">
						<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" style="margin-top: 20px;">
						<input type="text" name="addr1" id="roadAddress" value="${member.addr1 }" autocomplete="off">
						<input type="text" name="addr2" id="jibunAddress" value="${member.addr2 }"  autocomplete="off">
					</td>
				</tr>
				<tr>
					<td class="item_th"><div>전화번호</div></td>
					<td class="td_phone">
						<select name="phone1">
						  <option value="010">010</option>
						  <option value="011">011</option>
						</select>
						<span class="link">-</span>
						<input type="text" name="phone2" value="${member.phone2 }" autocomplete="off">
						<span class="link">-</span>
						<input type="text" name="phone3" value="${member.phone3 }" autocomplete="off">
					</td>
				</tr>
				<tr>
					<td class="item_th">이메일</td>
					<td class="td_email">
						<input type="text" name="email1" id="email1" value="${member.email1 }" autocomplete="off">
						<span class="link">@</span>
					    <input type="text" name="email2" id="email2" value="${member.email2 }" autocomplete="off">
					    <select id="emailSelect" onchange="f_emailSelect(this)">
					    	<option value="">직접입력</option>
							<option value="daum.net">daum.net</option>
					        <option value="naver.com">naver.com</option>
					    </select>
					</td>
				</tr>
				<tr>
					<td class="item_th">
						<div><span>가입일</span></div>
					</td>
					<td class="item_box">
						<div><input readonly="readonly" id="joindate" name="joindate" value="${member.joindate }"></div>
					</td>
				</tr>
			</table>
			<div class="wrap_btn">
				<a class="submit_box" onclick="mypage_submit()"><span>정보 수정</span></a>
			</div>
		</form>
	</div>
</div>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소 구성
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('roadAddress').value = fullRoadAddr;
                document.getElementById('jibunAddress').value = data.jibunAddress;
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
</script>


<%@ include file="../include/footer.jsp" %>