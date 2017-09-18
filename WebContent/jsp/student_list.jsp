<%@page import="POJO.Student"%>
<%@page import="vo.PageBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.css" />
<script
	src="${pageContext.request.contextPath}/jQuery/jquery-3.2.1.min.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	function selectall() {
		$("input[name=selectIds]").prop("checked",
				$("#selectAll").is(":checked"));
	}
	function deleteAll() {
		$("#mainForm").attr("action",
				"${pageContext.request.contextPath}/student?method=deleteAll");
		$("#mainForm").submit();
	}
</script>
</head>
<body>

	<div class="container">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#">学生管理</a></li>
			<li><a href="#">班级管理</a></li>
			<li><a href="${pageContext.request.contextPath}/Classcourseselevt?methods=findAllStudent">课程管理</a></li>
			<li><a href="#">教务管理</a></li>
			<li style="float: right;">
				<!--注销按钮执行loginOutServlet-->
				<form action="${pageContext.request.contextPath}/loginOutServlet">
					<button type="submit" class="btn btn-warning">注销登录</button>
				</form> <br>
			</li>

		</ul>
	</div>


	<div class="container">
		<div class="row">
			<div class="col-sm-2">
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#">学生管理</a></li>
					<li>
						<!-- 添加学生按钮 执行student_add方法--> <a
						href="${pageContext.request.contextPath}/jsp/student_add.jsp">添加学生</a>
					</li>
					<li> <a
						href="${pageContext.request.contextPath}/jsp/StudentSeach.jsp">
							学生搜索</a></li>

				</ul>


			</div>
			<div class="col-sm-10">

				<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">提交</button>
					</form>
				</div>
				</nav>




		

				<!-- 批量删除学生按钮 执行JS:deleteAll()方法-->
				<button onclick="deleteAll();" class="btn btn-primary btn-lg">批量删除</button>


			
				<!-- bootstrap列表展示数据库所有学生信息 -附删除(直接执行deleteStudent方法)和修改(提取当前id的学生信息转发到jsp页面toUpdateStudent)按钮 -->
				<%-- <%
		List<Student> list = (List<Student>) request.getAttribute("list1");
	%> --%>
				<form id="mainForm" action="" method="post">
					<table class="table table-hover table-bordered">
						<tr>
							<td><input type="checkbox" onclick="selectall();"
								id="selectAll"></td>
							<td>编号</td>
							<td>姓名</td>
							<td>年龄</td>
							<td>性别</td>
							<td>地址</td>
							<td>生日</td>
							<td colspan="2">操作选择</td>
						</tr>
						<c:forEach var="student" items="${list }">
							<%-- <%
			for (Student student : list) {
		%> --%>
							<tr>
								<td><input type="checkbox" name="selectIds"
									value="${student.id }"></td>
								<td>${student.id }</td>
								<td>${student.name }</td>
								<td>${student.age }</td>
								<td>${student.gender }</td>
								<td>${student.address }</td>
								<td>${student.birthday }</td>
								<td><a
									href="${pageContext.request.contextPath}/student?method=deleteStudent&id=${student.id }"><input
										type="button" value="删除" class="btn btn-danger"></a></td>
								<td><a
									href="${pageContext.request.contextPath}/student?method=toUpdateStudent&id=${student.id }"><input
										type="button" value="修改" class="btn btn-info"></a></td>
							</tr>
						</c:forEach>
						<%-- <%
			}
		%> --%>
					</table>
				</form>
				<!-- 分页开始 -->
										<nav aria-label="Page navigation">
				<ul class="pagination pagination-lg">
					<li><c:if test="${pageBean.pageIndex==1}">
							<li class="disabled"><a href="javascript:void(0);"
														aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if> <c:if test="${pageBean.pageIndex!=1}">
							<a
														href="${pageContext.request.contextPath}/student?method=pageList&pageIndex=${pageBean.pageIndex -1 }"
														aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a>
						</c:if></li>
					<c:forEach begin="1" end="${pageBean.totalPage }" var="page">
						<c:if test="${pageBean.pageIndex!=page }">
							<li><a
														href="${pageContext.request.contextPath}/student?method=pageList&pageIndex=${page }">${page }</a></li>
						</c:if>
						<c:if test="${pageBean.pageIndex==page }">
							<li class="active"><a
														href="${pageContext.request.contextPath}/student?method=pageList&pageIndex=${page }">${page }</a></li>
						</c:if>
					</c:forEach>
					<li><c:if test="${pageBean.pageIndex==pageBean.totalPage}">
							<li class="disabled"><a href="javascript:void(0);"
														aria-label="Previous"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</c:if> <c:if test="${pageBean.pageIndex!=pageBean.totalPage}">
							<a
														href="${pageContext.request.contextPath}/student?method=pageList&pageIndex=${pageBean.pageIndex +1 }"
														aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a>
						</c:if></li>
				</ul>
				</nav>
			
									</div>
		</div>
	</div>
	<!-- 分页结束 -->
	</contoin>
</body>
</html>