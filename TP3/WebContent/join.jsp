
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/candy-box.css" />
<script type="text/javascript" src="css/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="css/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/css.css">
<title>ȸ������</title>
</head>
<body>
<div class="input">
   <h1 style="text-align: center;">ȸ������</h1>
   <hr>
   <form action="join.four" method="post">
   <table class="JoinTable">
   <tr>
    <td>  ID   </td><td><input name="id" value="${id}"> <c:if test="${errors.IDexist}"><font color=#FF0000>���̵� �ߺ��Դϴ�.</font></c:if><c:if test="${errors.idNull}"><font color=#FF0000>���̵� �Է����ּ���.</font></c:if> <br> 
     </td> </tr><tr>
   <td>   ��й�ȣ </td><td> <input type="password" name="pw"> <c:if test="${errors.pwNull}"><font color=#FF0000>��й�ȣ�� �Է����ּ���</font></c:if> <br>
    </td> </tr><tr>
   <td>   ��ȣȮ��</td><td> <input type="password" name="repw"> <c:if test="${errors.PWdisagree}"><font color=#FF00000>��ȣ�� Ȯ���� ����ġ�մϴ�</font></c:if> <br>
       </td> </tr><tr>
   <td>   �̸� </td><td> <input name="name" value="${name}"><c:if test="${errors.nameNull}"><font color=#FF00000>�̸��� �Է����ּ���</font></c:if><br>
     </td>  </tr><tr>
   <td>   �ּ� </td><td><textarea rows="5" name="address" style="height: 30px;width: 168px" >${address}</textarea><c:if test="${errors.addressNull}"><font color=#FF00000>�ּҸ� �Է����ּ���</font></c:if><br>
      </td> </tr><tr>
   <td>   ���� </td><td> <input type="radio" name="sex" value="M">�� <input type="radio" name="sex" value="F">�� <c:if test="${errors.sexNull}"><font color=#FF00000>������ �Է����ּ���</font></c:if><br>
       </td> </tr><tr>
   <td>   �������</td><td><input name="birthday" type="date"> <c:if test="${errors.birthdayNull}"><font color=#FF00000>�������Է����ּ���</font></c:if> <br>
      </td> </tr>
</table>
      
      <br>
     <button type="reset" class="btn btn-primary">�ǵ�����</button>
          <button type="submit" class="btn btn-primary">�����ϱ�</button>
   </form><br>
   	<a href="index.jsp"><button>�� �α��� ȭ������ ���ư���</button></a>
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