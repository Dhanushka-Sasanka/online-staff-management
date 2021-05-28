<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="dist/css/custom/loginpage.css">
</head>
<body>

	<div class="container-fluid">
		<div class="row no-gutter">
			<!--         The image half¢ -->
			<div class="col-md-6 d-none d-md-flex bg-image">

				<div class="bg-image-content">
					<h1>
						Staff <br /> Management <br />System
					</h1>
				</div>
			</div>


			<!--         The content half -->
			<div class="col-md-6 bg-light">
				<div class="login d-flex align-items-center py-5">

					<!--                 Demo content -->
					<div class="container">
						<div class="row">
							<div class="col-lg-10 col-xl-7 mx-auto">
								<h2 class="mb-4">LOGIN</h2>



								<c:if test="${message != null}">
									<div class="alert alert-danger" role="alert">
									User name or Password Incorrect..!</div>
								</c:if>


								<form action="login" method="post">
									<div class="form-group mb-3">
										<input id="inputEmail" type="text" placeholder="Username"
											required="required" autofocus="" name="username"
											class="form-control rounded-pill border-0 shadow-sm px-4">
									</div>
									<div class="form-group mb-3">
										<input id="inputPassword" type="password"
											placeholder="Password" required="required" name="password"
											class="form-control rounded-pill border-0 shadow-sm px-4">
									</div>
									<div class="custom-control custom-checkbox mb-3">
										<input id="customCheck1" type="checkbox" checked
											class="custom-control-input"> <label
											for="customCheck1" class="custom-control-label">Remember
											password</label>
									</div>

									<button type="submit"
										class="btn btn-primary btn-block text-uppercase mb-2 mt-4 rounded-pill shadow-sm">
										Login</button>
								</form>
							</div>
						</div>
					</div>

				</div>
			</div>

		</div>
	</div>





	<script src="dist/js/jquery-3.3.1.min.js"></script>
	<script src="dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>





