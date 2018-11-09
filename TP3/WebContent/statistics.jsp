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
<title>��� ������</title>
<style type="text/css">
td {
	text-align: center;
}

.td1 {
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="container"
		style="background-color: #ffffff; margin-top: 50px; border-radius: 5px;">
		<!--�׺���̼� ���� -->
		<jsp:include page="nav.jsp" />
		<!--�׺���̼� �� ���� -->

		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<div class="page-header">
					<h2>���</h2>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<table class="table table-bordered">
					<tr>
						<th colspan="2" style="text-align: center;">����</th>
						<th style="text-align: center; width: 200px;">���</th>
					</tr>
					<tr>
						<td rowspan="2" style="width: 200px; vertical-align: middle;"
							class="td1">����</td>
						<td class="td1">����</td>
						<td class="td2">${dto.men}</td>

					</tr>
					<tr>
						<td class="td1">����</td>
						<td>${dto.women}</td>

					</tr>
					<tr>

					</tr>
					<tr>
						<td colspan="2" class="td1">��ü ȸ����</td>
						<td>${dto.sum}</td>
					</tr>

					<tr>
						<td rowspan="2" style="width: 200px; vertical-align: middle;"
							class="td1">�湮�ڼ�</td>
						<td style="width: 100px;" class="td1">��¥</td>
						<td><c:forEach items="${dto.list}" var="list">
					${list.day}
					</c:forEach></td>
					</tr>
					<tr>
						<td style="width: 100px;" class="td1">�湮�� ��</td>
						<td><c:forEach items="${dto.list}" var="list">
					${list.cnt}
				</c:forEach></td>

					</tr>

				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-5"></div>
			<div class="col-sm-2" style="text-align: center;">
				<a href="itemList.four">
					<button type="button" class="btn btn-primary">�� ���ư���</button>
				</a><br>
				<br>
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