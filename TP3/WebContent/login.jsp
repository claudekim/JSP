<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<html>
<head>

<link href="css/login.css" rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<title>상품 소개 홈페이지 로그인</title>
</head>
<body id="LoginForm">

<c:if test="${refuse}">
	<script type="text/javascript">alert("아이디 또는 비밀번호를 확인해주세요");</script>
</c:if>

<br>
	<div class="container">
		<h1 class="form-heading"> </h1>
		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>상품 소개 홈페이지</h2>
					<br>
					<p><b>로그인</b></p>
				</div>
				<form id="Login" action="loginUi.four" method="post">

					<div class="form-group">


						<input type="text" class="form-control" id="inputEmail" name="id" placeholder="ID">

					</div>

					<div class="form-group">

						<input type="password" class="form-control" id="inputPassword"
							name="pw"placeholder="Password">

					</div>
					<div class="newuser">
						<a href="joinUi.four">▶ 회원가입하기</a>
					</div>
					<button type="submit" class="btn btn-primary">Login</button>

				</form>
			</div>
			<p class="botto-text"></p>
		</div>
	</div>


</body>
</html>
