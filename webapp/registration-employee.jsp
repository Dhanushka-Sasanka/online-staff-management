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
	<jsp:include page="/GetEmployeeIDsNotInRegistration"></jsp:include>

	<div id="layoutSidenav">

		<!-- side-bar start -->
		<jsp:include page="side-bar.jsp"></jsp:include>
		<!-- side-bar end -->

		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">

					<caption>
						<h2>
							<c:if test="${registration != null}">
								<h3 class="mt-4">EDIT REGISTRATION</h3>
							</c:if>
							<c:if test="${registration == null}">
								<h3 class="mt-4">ADD REGISTRATION</h3>
							</c:if>
						</h2>
					</caption>

					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-user me-1"></i> Basic details of registration
						</div>
						<div class="card-body col-md-10">


							<c:if test="${registration != null}">
								<form action="update" method="post">
							</c:if>
							<c:if test="${registration == null}">
								<form action="insert" method="post">
							</c:if>


							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">REG
									ID</label>

								<div class="col-sm-10">
									<c:if test="${registration == null}">
										<input type="text" class="form-control" id="rid"
											value="${nextID}" name="rid" readonly="readonly" required="required">
									</c:if>
									<c:if test="${registration != null}">
										<input type="text" class="form-control" id="rid"
											value="<c:out value='${registration.rid}'/>" name="rid"
											readonly="readonly" required="required">
									</c:if>

								</div>
							</div>
							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">EMPLOYEE
									ID </label>
								<div class="col-sm-10">
									<select class="custom-select" name="employeId" required="required">

										<c:forEach var="employeeID"
											items="${employeeIDsNotInRegistration}">
											<option selected
												value="<c:out value="${registration.employeId}" />">
												<c:out value="${registration.employeId}" /></option>
											<option value="<c:out value="${employeeID}" />">
												<c:out value="${employeeID}" /></option>

										</c:forEach>
									</select>
								</div>
							</div>

							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">DESIGNATION
								</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="designation" required="required"
										name="designation"
										value="<c:out value='${registration.designation}'/>">
								</div>
							</div>

							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">DATE
								</label>
								<div class="col-sm-10">
									<input type="date" class="form-control" id="dob"
										name="reg_date" required="required"
										value="<c:out value='${registration.reg_date}'/>">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">EMPLOYEE
									LEVEL </label>
								<div class="col-sm-10">
									<select class="custom-select" name="level" required="required">

										<option selected
											value="<c:out value="${registration.level}" />">
											<c:out value="${registration.level}" /></option>
										<option value="LEVEL 1">LEVEL 1</option>
										<option value="LEVEL 2">LEVEL 2</option>
										<option value="LEVEL 3">LEVEL 3</option>
										<option value="LEVEL 4">LEVEL 4</option>
										<option value="LEVEL 5">LEVEL 5</option>
										<option value="LEVEL 6">LEVEL 6</option>
										<option value="LEVEL 7">LEVEL 7</option>
										<option value="LEVEL 8">LEVEL 8</option>
										<option value="LEVEL 9">LEVEL 9</option>
										<option value="LEVEL 10">LEVEL 10</option>
									</select>
								</div>
							</div>



							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">REG_BY</label>
								<div class="col-sm-10" >
									<input type="text" class="form-control" id="reg_by" required="required"
										name="reg_by" value="<c:out value='${registration.reg_by}'/>">
								</div>
							</div>
							<c:if test="${registration != null}">
								<button type="submit"
									class="btn btn-primary text-uppercase mb-2 mt-4 rounded-pill shadow-sm">
									EDIT REGISTER DETAILS</button>
							</c:if>
							<c:if test="${registration == null}">
								<button type="submit"
									class="btn btn-success text-uppercase mb-2 mt-4 rounded-pill shadow-sm">
									REGISTER</button>
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
