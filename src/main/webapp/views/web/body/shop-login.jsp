<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Supper Shop-Login</title>
	
<link rel='stylesheet'
	href='<c:url value ="/template/assets/corporate/css/all.min.css"></c:url>'>
<link rel="stylesheet" href='<c:url value = "/template/assets/corporate/css/login.css"></c:url>'>

</head>
<body>
	<!-- partial:index.partial.html -->
	<h2>Weekly Coding Challenge #1: Sign in/up Form</h2>
	<div class="container" id="container">
		<div class="form-container sign-up-container">
			<form action="register" method="post">
				<h1 style="margin-bottom: 20px">Create Account</h1>

				<input type="text" placeholder="Họ và tên" name = "fullname" /> 
				<input type="email" placeholder="Email"name = "email"  />
				<input type="password" placeholder="Password"name = "password"  />
				<input type="text" placeholder="Số điện thoại" name = "phone" />
				<input type="text" placeholder="Địa chỉ"name = "address"  />
		
				<button>Sign Up</button>
			</form>
		</div>
		<div class="form-container sign-in-container">
			<form action="login" method="post">
				<h1>Sign in</h1>
				<div class="social-container">
					<a href="#" class="social"><i class="fab fa-facebook-f"></i></a> <a
						href="#" class="social"><i class="fab fa-google-plus-g"></i></a> <a
						href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
				</div>
				<span>or use your account</span> <input type="email" name = "email"
					placeholder="Email" /> <input type="password" name ="password"
					placeholder="Password" /> <a href="#" style="color: red">Forgot your password?</a>
					<a href="#">${error }</a>
				<button>Sign In</button>
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>Welcome Back!</h1>
					<p>To keep connected with us please login with your personal
						info</p>
					<button class="ghost" id="signIn">Sign In</button>
				</div>
				<div class="overlay-panel overlay-right">
					<h1>Hello, Friend!</h1>
					<p>Enter your personal details and start journey with us</p>
					<button class="ghost" id="signUp">Sign Up</button>
				</div>
			</div>
		</div>
	</div>
	<!-- partial -->
	<script src='<c:url value = "/template/assets/corporate/scripts/script.js"></c:url>'></script>

</body>
</html>
