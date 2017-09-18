<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">

		<div class="col-lg-6">
			<!--查询指定姓名学生信息-将用户输入的name1传给 toselectByName方法-->
			<form
				action="${pageContext.request.contextPath}/student?method=toselectByName"
				method="post">
				<div class="input-group" width="150">
					<span class="input-group-btn">
						<button class="btn btn-primary" type="submit">查询</button>
					</span> <input type="text" class="form-control"
						placeholder="请输入学生姓名查询学生信息" name="name1">
				</div>
				<br>
			</form>
			<!--查询指定地址学生信息-将用户输入的address传给 toselectByAddress方法-->
			<form
				action="${pageContext.request.contextPath}/student?method=toselectByAddress"
				method="post">
				<div class="row">
					<div class="col-lg-6">
						<div class="input-group" width="150">
							<span class="input-group-btn">
								<button class="btn btn-primary" type="submit">查询</button>
							</span> <input type="text" class="form-control"
								placeholder="请输入学生地址查询学生信息" name="address">
						</div>
					</div>
				</div>
			</form>
			<br>




			<!--查询指定出生日期区间学生信息-将用户输入的startbirthday,endbirthday传给 toselectByBirthday方法-->
			<form
				action="${pageContext.request.contextPath}/student?method=toselectByBirthday"
				method="post">
				<div class="row">
					<div class="col-lg-6">
						<div class="input-group" width="150">
							<span class="input-group-btn">
								<button class="btn btn-primary" type="submit">查询</button>
							</span> <input type="text" class="form-control"
								placeholder="开始日期----请输入学生生日日期区间查询学生信息" name="startbirthday">
							<input type="text" class="form-control"
								placeholder="结束日期----请输入学生生日日期区间查询学生信息" name="endbirthday">
						</div>
					</div>
				</div>
			</form>
			<br>
		</div>



		<!-- 多条件查询  -->
		<form
			action="${pageContext.request.contextPath}/student?method=selectByCondition"
			method="post">
			<div class="col-lg-6">
				<div class="input-group" width="150">
					<input type="text" class="form-control" placeholder="学生id"
						name="id"> <input type="text" class="form-control"
						placeholder="学生姓名" name="name"> <input type="text"
						class="form-control" placeholder="学生年龄" name="age"> </span> </span> <input
						type="text" class="form-control" placeholder="学生地址" name="address">
					<span class="input-group-btn">
						<button class="btn btn-primary" type="submit">查询</button>
					</span>
				</div>
				<button class="btn btn-default dropdown-toggle" type="button"
					id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="true">
					性别 <select name="gender">
						<option value="">不限
						<option value="男">男
						<option value="女">女
					</select>
				</button>
			</div>
		</form>
	</div>
	<br>

</body>
</html>