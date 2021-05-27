<%@page import="com.osms.servlet.EmployeeServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>

</head>
<body>
	<!-- header start -->
	<jsp:include page="navigation.jsp"></jsp:include>
	<!-- header end -->


	<div id="layoutSidenav">

		<!-- side-bar start -->
		<jsp:include page="side-bar.jsp"></jsp:include>
		<!-- side-bar end -->


		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h3 class="mt-4">EMPLOYEES DETAILS</h3>

					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-users me-1"></i> All details of employees
						</div>
						<div class="card-body col-md-12">


							<table class="table table-hover">
								<thead>
									<tr class="bg-secondary">
										<th scope="col" class="text-white">#ID</th>
										<th scope="col" class="text-white">Full Name</th>
										<th scope="col" class="text-white">Email</th>
										<th scope="col" class="text-white">Address</th>
										<th scope="col" class="text-white">DOB</th>
										<th scope="col" class="text-white">ACTION</th>
									</tr>
								</thead>
								<tbody>
								
								
									<c:forEach var="employee" items="${listEmployees}">
										<tr>
											<td><c:out value="${employee.eid}" /></td>
											<td><c:out value="${employee.fullName}" /></td>
											<td><c:out value="${employee.email}" /></td>
											<td><c:out value="${employee.address}" /></td>
											<td><c:out value="${employee.dateOfBirth}" /></td>
											<td>
											<a class="btn btn-success" href="edit?id=<c:out value='${employee.eid}'/>">
											EDIT</a>
												&nbsp;&nbsp;&nbsp;&nbsp; <a
												class="btn btn-danger"
												href="delete?id=<c:out value='${employee.eid}' />">REMOVE</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

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