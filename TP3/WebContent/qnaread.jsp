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

<title>문의글 보기</title>
</head>
<body>
	<div class="container"
		style="background-color: #ffffff; margin-top: 50px; border-radius: 5px;">
		<!--네비게이션 시작 -->
		<jsp:include page="nav.jsp" />
		<!--네비게이션 바 종료 -->
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div class="page-header">
					<h2>문의글 보기</h2>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<table class="table table-bordered">
					<tr>
						<td>제목</td>
						<td>${dto.qtitle}</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${dto.qid}</td>
					</tr>
					<tr>
						<td>작성일</td>
						<td>${dto.qwriteday}</td>
					</tr>
					<tr>
						<td>조회수</td>
						<td>${dto.readcnt}</td>
					</tr>
					<tr>
						<td colspan="2" ><textarea rows="10" readonly style="width:100%;">${dto.qcontent}</textarea>
						</td>
					<tr>
				</table>
				<div style="text-align: center;">
					<c:if test="${login.id == dto.qid}">
						<a href="qnamodifyui.four?qnum=${dto.qnum}"><button
								type="button" class="btn btn-primary">수정</button></a>
					</c:if>
					<c:if test="${login.id == dto.qid || login.who == 'A'}">
						<a href="qnadelete.four?qnum=${dto.qnum}&&gnum=${dto.qgnum}&&id=${login.id}"><button
								type="button" class="btn btn-danger">삭제</button></a>
					</c:if>
					<c:if test="${login.who == 'A'}">
						<a href="qnareplyui.four?qnum=${dto.qnum}"><button
								type="button" class="btn btn-success">답변</button></a>
					</c:if>
					<a href="itemRead.four?gnum=${dto.qgnum}"><button
								type="button" class="btn btn-primary">목록보기</button></a> <br> <br>
				</div>
			</div>
		</div><br> <br>	<br>
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