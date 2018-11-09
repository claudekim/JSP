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

<title>ȸ������ ����</title>
</head>
<body>
	<div class="container"
		style="background-color: #ffffff; margin-top: 50px; border-radius: 5px;">
		<!--�׺���̼� ���� -->
		<jsp:include page="nav.jsp" />
		<!--�׺���̼� �� ���� -->

		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div class="page-header">
					<h2>ȸ������ ����</h2>
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
								<td>��й�ȣ</td>
								<td><input type="password" name="pw" value="${dto.pw }">
									<c:if test="${errors.pwNull}">
										<font color=#FF0000>��й�ȣ�� �Է����ּ���</font>
									</c:if></td>
							</tr>
							<tr>
								<td>�̸�</td>
								<td><input name="name" type="text" value="${dto.name }">
									<c:if test="${errors.nameNull}">
										<font color=#FF00000>�̸��� �Է����ּ���</font>
									</c:if></td>
							</tr>
							<tr>
								<td>�ּ�</td>
								<td><input name="address" value="${dto.address }">
									<c:if test="${errors.addressNull}">
										<font color=#FF00000>�ּҸ� �Է����ּ���</font>
									</c:if></td>
							</tr>
							<tr>
								<td>����</td>
								<td><input name="birthday" type="date"
									value="${dto.birthday}"> <c:if
										test="${errors.birthdayNull}">
										<font color=#FF00000>�������Է����ּ���</font>
									</c:if></td>
							</tr>
							<tr>
								<td>����</td>
								<td><c:if test="${dto.sex=='M'}">
										<input type="radio" name="sex" value="M" checked>�� 
	<input type="radio" name="sex" value="F">�� 
	</c:if> <c:if test="${dto.sex=='F'}">
										<input type="radio" name="sex" value="M">�� 
	<input type="radio" name="sex" value="F" checked>�� 
	</c:if> <c:if test="${errors.sexNull}">
										<font color=#FF00000>������ �Է����ּ���</font>
									</c:if></td>
							</tr>
						</tbody>
					</table>
					<div style="text-align: center;">
						<button type="submit" class="btn btn-primary">�Ϸ�</button>
						<button type="reset" class="btn btn-primary">����</button>
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