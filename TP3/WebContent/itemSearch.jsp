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

<title>검색 결과</title>
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
					<h2>검색결과보기</h2>
				</div>
			</div>
		</div>
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
					<c:forEach items="${searchList}" var="dto">
						<tr>
							<td style="text-align: center">${dto.gnum}</td>
							<td style="padding: 2px 10px 2px 10px"><a
								href="itemread.four?gnum=${dto.gnum}">${dto.gtitle}</a></td>
							<td style="text-align: center">${dto.gwriteday}</td>
							<td style="text-align: center">${dto.greadcnt}</td>
							<td style="text-align: center">${dto.qnaNum}</td>
							
						</tr>
					</c:forEach>
				</table>
				<br>
				<div>
					<a href="itemList.four"><button type="button"
							class="btn btn-primary">◀ 돌아가기</button></a>&nbsp;&nbsp;

				</div>
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