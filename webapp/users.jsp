<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<% if(session.getAttribute("valiedUser") == null){ response.sendRedirect(request.getContextPath()+"/login.jsp");} %>
	<!-- header start -->
	<jsp:include page="navigation.jsp"></jsp:include>
	<!-- header end -->
	<jsp:include page="/GetNextIDServlet"></jsp:include>

	<div id="layoutSidenav">

		<!-- side-bar start -->
		<jsp:include page="side-bar.jsp"></jsp:include>
		<!-- side-bar end -->

		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">

					<caption>
						<h2>
							<c:if test="${existingUser != null}">
								<h3 class="mt-4">EDIT USERS</h3>
							</c:if>
							<c:if test="${existingUser == null}">
								<h3 class="mt-4">ADD USERS</h3>
							</c:if>
						</h2>
					</caption>

					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-user me-1"></i> Basic details of users
						</div>
						<div class="card-body col-md-8">


							<c:if test="${existingUser != null}">
								<form action="update" method="post">
							</c:if>
							<c:if test="${existingUser == null}">
								<form action="insert" method="post">
							</c:if>

							<c:if test="${existingUser != null}">
								<div class="form-group row">
									<label for="userID" class="col-sm-2 col-form-label">USER
										ID</label>

									<div class="col-sm-10">
										<input type="text" class="form-control" id="userID"
											value="<c:out value='${existingUser.userID}'/>"
											name="userID" readonly="readonly" required="required">
									</div>
								</div>
							</c:if>


							<div class="form-group row">
								<label for="username" class="col-sm-2 col-form-label">USERNAME
								</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="username"
										required="required" name="username"
										value="<c:out value='${existingUser.userName}'/>">
								</div>
							</div>
							<div class="form-group row">
								<label for="password" class="col-sm-2 col-form-label">PASSWORD
								</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="password"
										required="required" name="password"
										value="<c:out value='${existingUser.password}'/>">
								</div>
							</div>

							<div class="form-group row">
								<label for="userrole" class="col-sm-2 col-form-label">ROLE
								</label>
								<div class="col-sm-10">
									<select class="custom-select" name="userrole" required="required">

										<option selected
											value="<c:out value="${existingUser.userRole}" />">
											<c:out value="${existingUser.userRole}" /></option>
										<option value="ADMIN">ADMIN</option>
										<option value="EMPLOYEE">EMPLOYEE</option>
										<option value="MODERATOR">MODERATOR</option>

									</select>
								</div>
							</div>



							<c:if test="${existingUser != null}">
								<button type="submit"
									class="btn btn-primary text-uppercase mb-2 mt-4 rounded-pill shadow-sm">
									EDIT USER</button>
							</c:if>
							<c:if test="${existingUser == null}">
								<button type="submit"
									class="btn btn-success text-uppercase mb-2 mt-4 rounded-pill shadow-sm">
									SAVE USER</button>
							</c:if>
							</form>

						</div>
						<div class="card-footer small text-muted"></div>
					</div>

				</div>
			</main>
			<!-- footer start -->
			<jsp:include page="footer.jsp"></jsp:include>
			<!-- footer end -->
		</div>
	</div>

	<jsp:include page="main-script.jsp"></jsp:include>

</body>
</html>
