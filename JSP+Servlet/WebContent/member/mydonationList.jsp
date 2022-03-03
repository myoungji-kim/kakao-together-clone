<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div id="mydonation_wrap">
	<ul>
		<c:forEach var="mydonation" items="${MydonationList}" varStatus="status">
		<li>
			<div class="box">
				<span class="thumb_img">
					<img src="${imgSrc}/for-test/${mydonation.image0}">
					
				</span>
				<div class="text_box">
					<span class="title">
						${mydonation.title}
						<span class="txt_price">
							${mydonation.donation}
							<span class="txt_won">원</span>
						</span>
					</span>
					<span class="date">${mydonation.date_donation}</span>
				</div>
				<div class="reset"></div>
			</div>
			
		</li>
		</c:forEach>
	</ul>
	
</div>

