<%@page import="com.dto.ItemPageTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/candy-box.css" />

<script type="text/javascript" src="css/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="css/bootstrap.min.js"></script>

</head>

<!--�׺���̼� ���� -->

<div class="row">
	<div class="col-lg-13">
		<div class="navbar navbar-inverse">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-inverse-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="itemList.four"
					style="font-weight: bolder;">��ǰ �Խ���</a>
			</div>
			<div class="navbar-collapse collapse navbar-inverse-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li style="font-size: medium;"><a href="#">������� <b> <c:if
									test="${login.who=='U' }">
								${login.id}
								</c:if> <c:if test="${login.who=='A' }">
								������
								</c:if> <c:if test="${login.who=='C' }">
								�濵��
								</c:if>
						</b>��
					</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">���̸޴�<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<c:if test="${login.who=='U' }">
								<li><a href="userSelectListUi.four">�� ���Ǳ�</a></li>
								<li><a href="userSelect.four?id=${login.id} ">���� ����</a></li>
							</c:if>
							<c:if test="${login.who=='A' }">
								<li><a href="itemWriteui.four">��ǰ���</a></li>
							</c:if>
							<c:if test="${login.who=='C' }">
								<li><a href="statistics.four">��躸��</a></li>
							</c:if>
						</ul></li>
					<li><a href="out.four">�α׾ƿ�</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!--�׺���̼� �� ���� -->