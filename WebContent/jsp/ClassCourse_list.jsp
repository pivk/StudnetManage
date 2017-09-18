<%@page import="POJO.ClassCourse"%>
<%@page import="POJO.Manager"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
</head>
<body>
	<form action="" method="post">

		<table>
			<%
				List<ClassCourse> list = (List<ClassCourse>) request.getAttribute("list");
			%>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>年龄</td>
			
			</tr>
			<%
				for (ClassCourse ClassCourse : list) {
			%>
			<tr>
				<td><%=ClassCourse.getId()%></td>
				<td><%=ClassCourse.getCoName()%></td>
		
			</tr>
			<%
				}
			%>
		</table>


	</form>
</body>
</html>