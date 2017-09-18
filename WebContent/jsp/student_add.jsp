<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.css" />
<script src="${pageContext.request.contextPath}/jQuery/jquery-3.2.1.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.js"
	type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
	$(function() {
	    $("#name").blur(function(){
	        var name = $(this).val();
	        $.post(
	            "${pageContext.request.contextPath}/student?method=checkName", //url
	            {"name":name}, //data
	            function(data) { //callback
	               if(data.isExit) {//用户已经存在
	                   $("#nameInfo").html("该用户名已存在");
	                   $("#nameInfo").css("color", "red");
	               } else {
	                   $("#nameInfo").html("该用户名可用");
	                   $("#nameInfo").css("color", "green");
	               }
	            },
	            "json" //type
	        );
	    });
	 });
	</script>
	<style type="text/css">
.a {
	position: relative;
	top: -150px;
	left: 80px;
}
</style>
</head>
<body>



	<form class="form-horizontal" action="/qw/student?method=addStudent" method="post">
		<div class="form-group">
			<label class="col-sm-2 control-label">姓名</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="name" id="name">
				<span id="nameInfo"></span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">年龄</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="age">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">性别</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="gender">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">地址</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="address">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">生日</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="birthday">
			</div>
		</div>
		<input type="submit" value="添加" class="btn btn-default a">
	</form>





	<!-- <form action="/qw/addStudent.do" method="post">
		姓名<input type="text" value="" name="name"><br> 年龄<input
			type="text" value="" name="age"><br> 性别<input
			type="text" value="" name="gender"><br> 地址<input
			type="text" value="" name="address"><br> 生日<input
			type="text" value="" name="birthday"><br> <input
			type="submit" value="添加">
	</form> -->

</body>
</html>