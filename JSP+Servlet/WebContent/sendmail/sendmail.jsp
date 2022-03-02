<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">

	// 유효성 검사
	function mail_submit(){
		var mesg = "";
		
		// 내용
		if ($('[name=content]').val()=="") {
			mesg = "내용, "+mesg;
		}
		
		// 제목
		if ($('[name=subject]').val()=="") {
			mesg = "제목, "+mesg;
		}
		
		// 닉네임
		if ($('[name=fromName]').val()=="") {
			mesg = "닉네임, "+mesg;
		}
		
		// 이메일 주소
		if ($('[name=fromMail]').val()=="") {
			mesg = "이메일, "+mesg;
		}
		
		// Submit
		if (mesg != "") {
			mesg = mesg.slice(0, -2);
			alert(mesg+"을(를) 확인해주세요");
		} else {
			$('[name=mailForm]').submit();
		}
	}
</script>

<form action="/sendmail.action" method="get" name="mailForm" enctype="multipart/form-data">
<div id="wrap_write">
	<table class="main">
		<tr>
			<td colspan="3">
				<div class="top_title">
					<span class="light">
						메일 보내기
					</span>
				</div>
			</td>
		</tr>
		<tr class="tr_oneLine">
			<th><span>보낸 이(이메일)</span></th>
			<td colspan="2"><div class="bottom_line"><input type="text" id="fromMail" name="fromMail" placeholder="회신 받으실 이메일 주소를 입력해주세요"></div></td>
		</tr>
		<tr class="tr_oneLine">
			<th><span>보낸 이(닉네임)</span></th>
			<td colspan="2"><div class="bottom_line"><input type="text" id="fromName" name="fromName" placeholder="본인의 이름(혹은 닉네임)을 입력해주세요"></div></td>
		</tr>
		<tr class="tr_oneLine">
			<th><span>제목</span></th>
			<td colspan="2"><div class="bottom_line"><input type="text" id="subject" name="subject" placeholder="제목을 입력해주세요"></div></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="2"><textarea name="content" placeholder="내용을 입력해주세요"></textarea></td>
		</tr>
	</table>
	
	<div class="wrap_btn">
		<a class="submit_box" onclick="mail_submit()">
			메일 전송
		</a>
	</div>
	
</div>
</form>
