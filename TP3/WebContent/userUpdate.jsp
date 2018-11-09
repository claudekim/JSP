<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/candy-box.css" />
<script type="text/javascript" src="css/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="css/bootstrap.min.js"></script>

<title>회원정보 수정</title>
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
					<h2>회원정보 수정</h2>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<form action="userUpdate.four" method="post">
					<table class="table table-striped table-hover">
						<tbody>
							<tr>
								<td>I D</td>
								<td><input type="hidden" name="id" value="${dto.id }">${dto.id }</td>
							</tr>
							<tr>
								<td>비밀번호</td>
								<td><input type="password" name="pw" value="${dto.pw }">
									<c:if test="${errors.pwNull}">
										<font color=#FF0000>비밀번호를 입력해주세요</font>
									</c:if></td>
							</tr>
							<tr>
								<td>이름</td>
								<td><input name="name" type="text" value="${dto.name }">
									<c:if test="${errors.nameNull}">
										<font color=#FF00000>이름을 입력해주세요</font>
									</c:if></td>
							</tr>
							<tr>
								<td>주소</td>
								<td><input name="address" value="${dto.address }">
									<c:if test="${errors.addressNull}">
										<font color=#FF00000>주소를 입력해주세요</font>
									</c:if></td>
							</tr>
							<tr>
								<td>생일</td>
								<td><input name="birthday" type="date"
									value="${dto.birthday}"> <c:if
										test="${errors.birthdayNull}">
										<font color=#FF00000>생일을입력해주세요</font>
									</c:if></td>
							</tr>
							<tr>
								<td>성별</td>
								<td><c:if test="${dto.sex=='M'}">
										<input type="radio" name="sex" value="M" checked>남 
	<input type="radio" name="sex" value="F">여 
	</c:if> <c:if test="${dto.sex=='F'}">
										<input type="radio" name="sex" value="M">남 
	<input type="radio" name="sex" value="F" checked>여 
	</c:if> <c:if test="${errors.sexNull}">
										<font color=#FF00000>성별을 입력해주세요</font>
									</c:if></td>
							</tr>
						</tbody>
					</table>
					<div style="text-align: center;">
						<button type="submit" class="btn btn-primary">완료</button>
						<button type="reset" class="btn btn-primary">리셋</button>
						<br> <br> <br>
					</div>
				</form>
			</div>
			<div class="col-sm-3"></div>
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