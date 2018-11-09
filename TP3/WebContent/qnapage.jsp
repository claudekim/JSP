
<%@page import="com.dto.qnaPageTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<%
	qnaPageTO to = (qnaPageTO)request.getAttribute("to");
	int amount = to.getAmount();
	int perPage = to.getPerPage();
	int curPage = to.getCurPage();
	int totalPage = (amount - 1) / perPage + 1;
	
	int beginPageNum = ((curPage-1)/perPage) * perPage + 1;
	int stopPageNum = ((curPage - 1)/perPage) * perPage + perPage;

	
	stopPageNum = stopPageNum>totalPage? totalPage:stopPageNum;
	
	
	pageContext.setAttribute("totalPage", totalPage);
	pageContext.setAttribute("beginPageNum", beginPageNum);
	pageContext.setAttribute("stopPageNum", stopPageNum);
	pageContext.setAttribute("curPage", curPage);
%>



<div class="text-center">
	<ul class="pagination">
		<c:if test="${curPage == 1 }">
			<li><span> <span aria-hidden="true">¢¸</span>
			</span></li>
		</c:if>
		<c:if test="${curPage!=1}">
			<li><a
				href="itemRead.four?curPage=${curPage-1}&&gnum=${Ito.dto.gnum}">¢¸</a></li>
		</c:if>
		
		<c:forEach begin="${beginPageNum}" end="${stopPageNum}" var="i">
			<c:if test="${curPage==i}">
			<li class="active"><span> <span aria-hidden="true">${i}	</span></span></li>
		</c:if>
			<c:if test="${curPage!=i}">
				<li><a href="itemRead.four?curPage=${i}&&gnum=${Ito.dto.gnum}">${i}</a></li>
			</c:if>
		</c:forEach>
		
		<c:if test="${curPage!=totalPage}">
			<li><a href="itemRead.four?curPage=${curPage+1}&&gnum=${Ito.dto.gnum}">¢º</a></li>
		</c:if>
		<c:if test="${curPage==totalPage }">
			<li><span> <span aria-hidden="true">¢º</span></span></li>
		</c:if>
	</ul>
</div>



	
	
	