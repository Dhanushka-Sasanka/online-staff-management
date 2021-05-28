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
<% if(session.getAttribute("valiedUser") == null){ response.sendRedirect(request.getContextPath()+"/login.jsp");} %>
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
					<h3 class="mt-4">SALARY DETAILS</h3>

					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-users me-1"></i> All details of salaries
						</div>
						<div class="card-body col-md-12">


							<table class="table table-hover">
								<thead>
									<tr class="bg-secondary">
										<th scope="col" class="text-white">#SALARY_ID</th>
										<th scope="col" class="text-white">#RID</th>
										<th scope="col" class="text-white">DATE</th>
										<th scope="col" class="text-white">PAID AMOUNT</th>
										<th scope="col" class="text-white">ACTION</th>
									</tr>
								</thead>
								<tbody>
								
								
									<c:forEach var="salary" items="${listSalarys}">
										<tr>
											<td><c:out value="${salary.salaryID}" /></td>
											<td><c:out value="${salary.rid}" /></td>
											<td><c:out value="${salary.payDate}" /></td>
											<td><c:out value="${salary.amount}" /></td>
											<td>
											<a class="btn btn-success" href="edit?id=<c:out value='${salary.salaryID}'/>">
											EDIT</a>
												&nbsp;&nbsp;&nbsp;&nbsp; <a
												class="btn btn-danger"
												href="delete?id=<c:out value='${salary.salaryID}' />">REMOVE</a></td>
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