<%@page import="java.util.List"%>
<%@page import="POJO.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7-dist/css/bootstrap.css" />
<script src="js/jquery-3.2.1.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"
	type="text/javascript" charset="utf-8"></script>
<style type="text/css">
.a {
	position: relative;
	top: -150px;
	left: 80px;
}
</style>
</head>
<body>

	<%-- 	</form>
	<%
		List<Student> list = (List<Student>) request.getAttribute("student");
	%>
	<form action="/qw/updateStudent.do" method="post">
		<%
			for (Student student : list) {
		%>
		id<input type="text" value="<%=student.getId()%>" name="id"><br>
		姓名<input type="text" value="<%=student.getAge()%>" name="name"><br>
		年龄<input type="text" value="<%=student.getAge()%>" name="age"><br>
		性别<input type="text" value="<%=student.getGender()%>" name="gender"><br>
		地址<input type="text" value="<%=student.getAddress()%>" name="address"><br>
		生日<input type="text" value="<%=student.getBirthday()%>"
			name="birthday"><br>
		<%
			}
		%>
		<input type="submit" value="确认修改">
	</form> --%>



	<%-- <%
		List<Student> list = (List<Student>) request.getAttribute("list");
	%> --%>

	<form class="form-horizontal" action="${pageContext.request.contextPath}/student?method=updateStudent"
		method="post">
		<%-- <%
			for (Student student : list) {
		%> --%>
		<c:forEach items="${list }" var="student">
	
		<div class="form-group">
			<label class="col-sm-2 control-label">id</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" value="${student.id }"
					name="id" readonly>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">姓名</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					value="${student.name }" name="name">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">年龄</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					value="${student.age }" name="age">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">性别</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					value="${student.gender }" name="gender">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">地址</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					value="${student.address }" name="address">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">生日</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"
					value="${student.birthday }" name="birthday">
			</div>
		</div>
		</c:forEach>
		<%-- <%
			}
		%> --%>
		<button type="submit" class="a btn btn-default">确认修改</button>
	</form>

</body>
</html>