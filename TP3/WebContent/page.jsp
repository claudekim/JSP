<%@page import="com.dto.PageTO"%>
<%@page import="com.dto.PageTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<link rel="stylesheet" type="text/css" href="css.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	PageTO to = (PageTO) request.getAttribute("to");//to���� ��ȯ�ؼ� ������ ��
	int amount = to.getAmount();//�ۼ�
	int perPage = to.getPerPage();
	int curPage = to.getCurPage();
	int totalPage = (amount - 1) / perPage +1;

	System.out.println("------------------");
	System.out.println("��ü�� �� :" + amount);
	System.out.println("curPage :" + curPage);
	System.out.println("perPage :" + perPage);

	//totalPage = amount % perPage != 0 ? ++totalPage : totalPage;
	System.out.println("��Ż������ :" + totalPage);

	int beginPageNum = ((curPage - 1) / perPage) * perPage + 1;
	System.out.println("���������� :" + beginPageNum);

	int stopPageNum = (((curPage - 1) / perPage) + 1) * perPage;
	/*
	if(stopPageNum>totalPage){
		stopPageNum=totalPage;
	}else{
		stopPageNum=stopPageNum;
	}*/
	stopPageNum=stopPageNum>totalPage?totalPage:stopPageNum;
	System.out.println("�������� :" + stopPageNum);
	System.out.println("------------------");
	//���ε�
	pageContext.setAttribute("beginPageNum", beginPageNum);
	pageContext.setAttribute("stopPageNum", stopPageNum);
	pageContext.setAttribute("curPage", curPage);
%>

<a href="list.four?curPage=${curPage-1}">��</a>&nbsp;
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
<a href="list.four?curPage=${curPage+1}">��</a>


