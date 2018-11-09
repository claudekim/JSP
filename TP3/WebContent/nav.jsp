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

<!--네비게이션 시작 -->

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
					style="font-weight: bolder;">상품 게시판</a>
			</div>
			<div class="navbar-collapse collapse navbar-inverse-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li style="font-size: medium;"><a href="#">어서오세요 <b> <c:if
									test="${login.who=='U' }">
								${login.id}
								</c:if> <c:if test="${login.who=='A' }">
								관리자
								</c:if> <c:if test="${login.who=='C' }">
								경영자
								</c:if>
						</b>님
					</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">마이메뉴<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<c:if test="${login.who=='U' }">
								<li><a href="userSelectListUi.four">내 문의글</a></li>
								<li><a href="userSelect.four?id=${login.id} ">계정 정보</a></li>
							</c:if>
							<c:if test="${login.who=='A' }">
								<li><a href="itemWriteui.four">상품등록</a></li>
							</c:if>
							<c:if test="${login.who=='C' }">
								<li><a href="statistics.four">통계보기</a></li>
							</c:if>
						</ul></li>
					<li><a href="out.four">로그아웃</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!--네비게이션 바 종료 -->