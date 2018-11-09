<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>내 문의글 보기</title>
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
					<h2>내 문의글 보기</h2>
				</div>
			</div>
		</div>
		<!-- 테이블공간시작 -->
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th style="width: 55px; text-align: center;">번호</th>
							<th style="text-align: center;">제목</th>
							<th style="width: 120px; text-align: center;">작성일</th>
							<th style="width: 80px; text-align: center;">조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="dto">
							<tr>
								<td>${dto.qnum}</td>
								<td><c:forEach begin="1" end="${dto.repIndent}">&nbsp;└ RE : 
				</c:forEach> <a href="qnaread.four?qnum=${dto.qnum}">${dto.qtitle}</a></td>
								<td>${dto.qwriteday}</td>
								<td>${dto.readcnt}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br> <br>
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
	<br>
</body>
</html>