<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div id="contents">
	<div id="wrap_tab">
		<ul class="list_tab">
			<li>
				<a href="/prom"><span <c:if test="${param.phase==null || param.phase == ''}"> class="on"</c:if>>전체</span></a>
			</li>
			<li>
				<a href="/prom?phase=2"><span <c:if test="${param.phase==2}"> class="on"</c:if>>진행중</span></a>
			</li>
			<li>
				<a href="/prom?phase=3"><span <c:if test="${param.phase==3}"> class="on"</c:if>>종료</span></a>
			</li>
		</ul>
	</div> <!-- end wrap_tab -->
</div> <!-- end contents -->