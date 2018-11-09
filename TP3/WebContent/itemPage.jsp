<%@page import="com.dto.ItemPageTO"%>
<%@page import="com.dto.ItemPageTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<%
	ItemPageTO Ito = (ItemPageTO) request.getAttribute("Ito");
	int itemAmount = Ito.getItemAmount();
	int itemCurPage = Ito.getItemCurPage();
	int perPage = Ito.getPerPage();
	int itemTotalPage = (itemAmount - 1) / perPage + 1;

	int beginPageNum = ((itemCurPage - 1) / perPage) * perPage + 1;
	int stopPageNum = (((itemCurPage - 1) / perPage) + 1) * perPage;

	System.out.println("------------------");
	System.out.println("전체글 수 :" + itemAmount);
	System.out.println("현재 페이지 :" + itemCurPage);
	System.out.println("perPage :" + perPage);
	stopPageNum = stopPageNum > itemTotalPage ? itemTotalPage : stopPageNum;
	pageContext.setAttribute("beginPageNum", beginPageNum);
	pageContext.setAttribute("stopPageNum", stopPageNum);
	pageContext.setAttribute("itemCurPage", itemCurPage);
%>
<div class="text-center">
	<ul class="pagination">
		<c:if test="${ itemCurPage == 1 }">
			<li><span> <span aria-hidden="true">◀</span>
			</span></li>
		</c:if>
		<c:if test="${ itemCurPage > 1 }">
			<li><a href="itemList.four?itemCurPage=${itemCurPage-1}">◀</a></li>
		</c:if>
		<c:forEach begin="${beginPageNum}" end="${stopPageNum}" var="i">
			<c:if test="${itemCurPage == i}">
				<li class="active"><a href="itemList.four?itemCurPage=${i}">${i}</a></li>
			</c:if>
			<c:if test="${itemCurPage != i}">
				<li><a href="itemList.four?itemCurPage=${i}">${i}</a></li>
			</c:if>
		</c:forEach>
		<c:if test="${itemCurPage<stopPageNum }">
			<li><a href="itemList.four?itemCurPage=${itemCurPage+1}">▶</a></li>
		</c:if>
		<c:if test="${itemCurPage==stopPageNum }">
			<li><span> <span aria-hidden="true">▶</span></span></li>
		</c:if>
	</ul>
</div>