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
	<jsp:include  page="/GetNextIDServlet"></jsp:include >

	<div id="layoutSidenav">

		<!-- side-bar start -->
		<jsp:include page="side-bar.jsp"></jsp:include>
		<!-- side-bar end -->
		
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">

					<caption>
						<h2>
							<c:if test="${employee != null}">
								<h3 class="mt-4">EDIT EMPLOYEE</h3>
							</c:if>
							<c:if test="${employee == null}">
								<h3 class="mt-4">ADD EMPLOYEE</h3>
							</c:if>
						</h2>
					</caption>
					
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-user me-1"></i> Basic details of employee
						</div>
						<div class="card-body col-md-8">


							<c:if test="${employee != null}">
								<form action="update" method="post">
							</c:if>
							<c:if test="${employee == null}">
								<form action="insert" method="post">
							</c:if>


							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">Employee
									ID</label>

								<div class="col-sm-10">
									<c:if test="${employee == null}">
										<input type="text" class="form-control" id="employeeID"
											value="${nextID}" name="employeeID" readonly="readonly" required="required">
									</c:if>
									<c:if test="${employee != null}">
										<input type="text" class="form-control" id="employeeID"
											value="<c:out value='${employee.eid}'/>" name="employeeID"
											readonly="readonly" required="required">
									</c:if>

								</div>
							</div>

							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">Full
									Name</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="fullname"
										name="fullname" required="required" value="<c:out value='${employee.fullName}'/>">
								</div>
							</div>

							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
								<div class="col-sm-10">
									<input type="email" class="form-control" id="employee-email"
										name="employee-email" required="required"
										value="<c:out value='${employee.email}'/>">
								</div>
							</div>

							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">Date
									Of Birth</label>
								<div class="col-sm-10">
									<input type="date" class="form-control" id="dob" name="dob" required="required"
										value="<c:out value='${employee.dateOfBirth}'/>">
								</div>
							</div>

							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">Address</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="address" required="required"
										name="address" value="<c:out value='${employee.address}'/>">
								</div>
							</div>
							<c:if test="${employee != null}">
								<button type="submit"
									class="btn btn-primary text-uppercase mb-2 mt-4 rounded-pill shadow-sm">
									EDIT</button>
							</c:if>
							<c:if test="${employee == null}">
								<button type="submit"
									class="btn btn-success text-uppercase mb-2 mt-4 rounded-pill shadow-sm">
									SAVE</button>
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
