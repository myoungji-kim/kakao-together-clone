<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	function donate_close(){
		$('#black_bg_donation').css("display", "none");
		$('#wrap_donation').css("display", "none");
	}
	
	function donate_go(){
		$('[name=donationForm]').submit();
		alert('소중한 마음 감사합니다. 따뜻하게 전달할게요♥');
		$('#black_bg_donation').css("display", "none");
		$('#wrap_donation').css("display", "none");
		$('.wrap_fund > .list_pay > .price').text(0);
		$('input[name=price]').val(0);
	}
	
	function changePrice(m){
		var price = $('.wrap_fund > .list_pay > .price').text();
		var newPrice;
		
		if (m == 5000){
			newPrice = parseInt(price)+5000;
		} else if (m == 10000) {
			newPrice = parseInt(price)+10000;
		} else if (m == 50000) {
			newPrice = parseInt(price)+50000;
		} else if (m == 0) {
			newPrice = 0;
		}
		
		$('.wrap_fund > .list_pay > .price').text(newPrice);
		$('input[name=price]').val(newPrice);
	}
	
	
</script>

<div id="wrap_donation">
	<form action="/donation.action" method="post" name="donationForm" class="form">
		<input type="hidden" name="mIdx" value="${loginIdx}">
		<input type="hidden" name="cIdx" value="${content.idx}">
		<div class="wrap_fund">
			<div class="list_pay">
				<span class="txt_tit">기부금 결제</span>
				<a class="btn_close" onclick="donate_close()"><img src="${imgSrc}/btn_close.png"></a>
				<span class="txt_info">무통장은 3천원, 기타 결제는 1천원부터 가능합니다.</span>
				<ul>
					<li><a onclick="changePrice(5000)"><span>+ 5천원</span></a></li>
					<li><a onclick="changePrice(10000)"><span>+ 1만원</span></a></li>
					<li><a onclick="changePrice(50000)"><span>+ 5만원</span></a></li>
					<li><a onclick="changePrice(0)"><span>다시 입력</span></a></li>
				</ul>
				
				<span class="txt_price">원</span>
				<span class="price">0</span>
				<input type="hidden" name="price" value="0">
				<div class="reset"></div>
			</div>
			<div class="write_box">
				<span class="txt_tit">응원 댓글 쓰기</span>
				<span class="txt_limit">0/300</span>
				<textarea id="comment" name="comment" placeholder="따뜻한 한마디를 남겨주세요"></textarea>
				<div class="reset"></div>
			</div>
			<div class="donation_info">
				<span>결제 내역은 마이페이지에서 확인해 주세요</span>
			</div>
		</div>
		<div class="wrap_btn_type">
			<a class="btn" onclick="donate_go()"><span>결제하기</span></a>
		</div>
	</form>
</div>
<div id="black_bg_donation"></div>