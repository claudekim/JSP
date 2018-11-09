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

		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="page-header">
					<h2>상품 게시판</h2>
				</div>
			</div>
		</div>
		<!-- 테이블 검색공간시작 -->
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-1"></div>
			<div class="col-lg-1"></div>
			<div class="col-lg-1"></div>
			<div class="col-lg-1"></div>
			<div class="col-lg-1"></div>
			<div class="col-lg-1"></div>
			<form action="itemSearch.four" method="get">
				<div class="col-lg-1">
					<div class="form-group">
						<select class="form-control" name="searchName"
							style="width: 90px;">
							<option value="gcontent">내용</option>
							<option value="gtitle">제목</option>
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

		<!-- 테이블공간시작 -->
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th style="width: 55px; text-align: center;">번호</th>
							<th style="text-align: center;">제품명</th>
							<th style="width: 120px; text-align: center;">작성일</th>
							<th style="width: 80px; text-align: center;">조회수</th>
							<th style="width: 80px; text-align: center;">문의글</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${Ito.itemList}" var="dto">
							<tr>
								<td style="text-align: center">${dto.gnum}</td>
								<td style="padding: 2px 10px 2px 10px"><a
									href="itemRead.four?gnum=${dto.gnum}&id=${login.id}"
									style="text-decoration: none">${dto.gtitle}</a></td>
								<td style="text-align: center">${dto.gwriteday}</td>
								<td style="text-align: center">${dto.greadcnt}</td>
								<td style="text-align: center">${dto.qnaNum}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		<br>
		</div>
		<jsp:include page="itemPage.jsp" />
			<br> <br>	<br>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>

