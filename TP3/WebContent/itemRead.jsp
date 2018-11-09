<%@page import="com.dto.ItemPageTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/candy-box.css" />
<script type="text/javascript" src="css/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="css/bootstrap.min.js"></script>
<title>상품 소개 페이지</title>
</head>
<body>
	<div class="container"
		style="background-color: #ffffff; margin-top: 50px; border-radius: 5px;">
		<!--네비게이션 시작 -->
		<jsp:include page="nav.jsp" />
		<!--네비게이션 바 종료 -->


		<!-- 상품상세정보나열 -->
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="page-header">
					<h2>상품 상세 정보</h2>
				</div>
			</div>
		</div>
		<!-- 상세정보 나열 테이블 시작 -->
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-5" style="text-align: center;">
				<img src="img/${Ito.fileName}" width=400 /> <br> <br>
			</div>
			<div class="col-sm-5">

				<table class="table table-bordered">
					<tr>
						<td class="td1">상품 번호</td>
						<td class="td2">${Ito.dto.gnum}</td>
					</tr>
					<tr>
						<td class="td1">상품명</td>
						<td class="td2">${Ito.dto.gtitle}</td>
					</tr>
					<tr>
						<td class="td1">작성일</td>
						<td class="td2">${Ito.dto.gwriteday}</td>
					</tr>
					<tr>
						<td class="td1">조회수</td>
						<td class="td2">${Ito.dto.greadcnt}</td>
					</tr>
					<tr class="tr1">
						<td class="td1">상품 설명</td>
						<td class="td3">${Ito.dto.gcontent}</td>
					</tr>
				</table>
				<!-- 관리자용버튼 -->
				<c:if test="${login.who=='A' }">
					<a href="itemModifyui.four?gnum=${Ito.dto.gnum}&id=${login.id}">
						<button type="button" class="btn btn-primary">수정</button>
					</a>
					<a href="itemDelete.four?gnum=${Ito.dto.gnum}"><button
							type="button" class="btn btn-primary">상품소개글 삭제</button></a>
				</c:if>
			</div>
		</div>
		<br>

		<!-- 문의하기 -->
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-1">

				<!-- 게시판으로 돌아가기 -->
				<a href="itemList.four">
					<button type="button" class="btn btn-primary">◀ 돌아가기</button>
				</a>
			</div>
			<div class="col-lg-4"></div>
			<div class="col-lg-1">
				<c:if test="${login.who=='U' }">
					<a href="qnaWriteui.four?gnum=${Ito.dto.gnum}&&qid=${login.id}"><button
							type="button" class="btn btn-success">문의하기</button></a>
				</c:if>
			</div>

			<!-- 문의검색 -->
			<form action="qnasearch.four" method="post">
				<div class="col-lg-1">
					<div class="form-group">
						<input type="hidden" name="gnum" value="${Ito.dto.gnum}">
						<select class="form-control" name="searchName"
							style="width: 90px;">
							<option value="qid">작성자</option>
							<option value="qtitle">제목</option>
						</select>
					</div>
				</div>
				<div class="col-lg-2">
					<div class="input-group" style="width: 262px; text-align: right;">
						<input name="searchValue" class="form-control"> <span
							class="input-group-btn">
							<button class="btn btn-default" type="submit">검색</button>
						</span>
					</div>
				</div>
			</form>
		</div>
		<!-- 문의테이블시작 -->
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th style="width: 55px; text-align: center;">번호</th>
							<th style="text-align: center;">제목</th>
							<th style="width: 120px; text-align: center;">작성자</th>
							<th style="width: 120px; text-align: center;">작성일</th>
							<th style="width: 80px; text-align: center;">조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${to.list}" var="dto">
							<tr>
								<td>${dto.qnum}</td>
								<td><c:forEach begin="1" end="${dto.repIndent}">					
								&nbsp;&nbsp;&nbsp;└ RE : 
				</c:forEach> <a href="qnaread.four?qnum=${dto.qnum}">${dto.qtitle}</a></td>
								<td>${dto.qid}</td>
								<td>${dto.qwriteday}</td>
								<td>${dto.readcnt}</td>

							</tr>

						</c:forEach>
					</tbody>
				</table>
				<br>
				<jsp:include page="qnapage.jsp" />
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>