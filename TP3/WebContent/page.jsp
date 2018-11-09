<%@page import="com.dto.PageTO"%>
<%@page import="com.dto.PageTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<link rel="stylesheet" type="text/css" href="css.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	PageTO to = (PageTO) request.getAttribute("to");//to값을 변환해서 가지구 와
	int amount = to.getAmount();//글수
	int perPage = to.getPerPage();
	int curPage = to.getCurPage();
	int totalPage = (amount - 1) / perPage +1;

	System.out.println("------------------");
	System.out.println("전체글 수 :" + amount);
	System.out.println("curPage :" + curPage);
	System.out.println("perPage :" + perPage);

	//totalPage = amount % perPage != 0 ? ++totalPage : totalPage;
	System.out.println("토탈페이지 :" + totalPage);

	int beginPageNum = ((curPage - 1) / perPage) * perPage + 1;
	System.out.println("시작페이지 :" + beginPageNum);

	int stopPageNum = (((curPage - 1) / perPage) + 1) * perPage;
	/*
	if(stopPageNum>totalPage){
		stopPageNum=totalPage;
	}else{
		stopPageNum=stopPageNum;
	}*/
	stopPageNum=stopPageNum>totalPage?totalPage:stopPageNum;
	System.out.println("끝페이지 :" + stopPageNum);
	System.out.println("------------------");
	//바인딩
	pageContext.setAttribute("beginPageNum", beginPageNum);
	pageContext.setAttribute("stopPageNum", stopPageNum);
	pageContext.setAttribute("curPage", curPage);
%>

<a href="list.four?curPage=${curPage-1}">◀</a>&nbsp;
<c:forEach begin="${beginPageNum }" end="${ stopPageNum}" var="i">
	<b>
	<c:if test="${curPage==i}">
	<mark>${i }</mark>
	</c:if>
		<c:if test="${curPage!=i}">
	<a href="list.four?curPage=${i}">${i}</a>
	</c:if></b>
	&nbsp;
</c:forEach>
<a href="list.four?curPage=${curPage+1}">▶</a>


