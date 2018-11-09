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
<link href="css/login.css" rel="stylesheet" id="bootstrap-css">

<title>ȸ������ �󼼺���</title>
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
					<h2>ȸ������</h2>
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
								<td>�̸�</td>
								<td><input type="hidden" name="name" value="${dto.name }">${dto.name }</td>
							</tr>
							<tr>
								<td>�ּ�</td>
								<td><input type="hidden" name="address"
									value="${dto.address }">${dto.address }</td>
							</tr>
							<tr>
								<td>����</td>
								<td><input type="hidden" name="birthday"
									value="${dto.birthday}">${dto.birthday}</td>
							</tr>
							<tr>
								<td>����</td>
								<td><c:if test="${dto.sex=='M'}">���� 	</c:if> <c:if
										test="${dto.sex=='F'}">����	</c:if></td>
							</tr>
						</tbody>
					</table>
				</form>
				<div style="text-align: center;">
					<a href="userUpdateUi.four?id=${login.id}"><button
							type="button" class="btn btn-primary">����</button></a> <a
						href="userDelete.four?id=${login.id} "><button type="button"
							class="btn btn-danger">ȸ��Ż��</button></a>
				</div>
				<br>
				<br>
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