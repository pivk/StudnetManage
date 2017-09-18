<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
<meta charset="utf-8">
<title>学生管理系统 登录</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">

<link href="../moban/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="../moban/css/bootstrap-responsive.min.css" rel="stylesheet"
	type="text/css" />

<link href="css/font-awesome.css" rel="stylesheet">
<link
	href="http://libs.useso.com/css?family=Open+Sans:400italic,600italic,400,600"
	rel="stylesheet">

<link href="../moban/css/style.css" rel="stylesheet" type="text/css">
<link href="../moban/css/pages/signin.css" rel="stylesheet"
	type="text/css">

</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/jquery/jquery-1.11.1.js"></script>

<script type="text/javascript">
	function refreshCode() {
		$("#codeImg").attr("src",
				"${pageContext.request.contextPath}/checkImg?" + Math.random());
	}
</script>

<body>

	<div class="navbar navbar-fixed-top">

		<div class="navbar-inner">

			<div class="container">

				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="index.html"> 学生登录 </a>

				<div class="nav-collapse">
					<ul class="nav pull-right">

						<li class=""><a href="signup.html" class=""> 注册账号 </a></li>
					</ul>

				</div>
				<!--/.nav-collapse -->

			</div>
			<!-- /container -->

		</div>
		<!-- /navbar-inner -->

	</div>
	<!-- /navbar -->



	<div class="account-container">

		<div class="content clearfix">

			<form
				action="${pageContext.request.contextPath}/loginServlet?methods=service"
				method="post">

				<h1>用户登录</h1>

				<div class="login-fields">

					<div class="field">
						<label for="username">用户名</label> <input type="text" id="username"
							name="userName" value="" placeholder="Username"
							class="login username-field" />
					</div>
					<!-- /field -->

					<div class="field">
						<label for="password">密码:</label> <input type="password"
							id="password" name="password" value="" placeholder="Password"
							class="login password-field" />
					</div>
					<!-- /password -->

					<div class="field">
						<input type="text" id="username" name="checkCode" value=""
							placeholder="验证码" class="login " style="width: 73px;" /> <img
							id="codeImg" src="${pageContext.request.contextPath}/checkImg"
							onclick="refreshCode();"
							style="float: right; margin-top: -34px; hight: 30px" />

					</div>

				</div>
				<!-- /login-fields -->

				<div class="login-actions">

					<button type="submit" class="button btn btn-success btn-large">登录
					</button>

				</div>
				<!-- .actions -->



			</form>

		</div>
		<!-- /content -->

	</div>
	<!-- /account-container -->




</body>

</html>
