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
							<c:if test="${existingSalary != null}">
								<h3 class="mt-4">EDIT SALARY</h3>
							</c:if>
							<c:if test="${existingSalary == null}">
								<h3 class="mt-4">ADD SALARY</h3>
							</c:if>
						</h2>
					</caption>
					
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-user me-1"></i> Basic details of employee salaries
						</div>
						<div class="card-body col-md-8">


							<c:if test="${existingSalary != null}">
								<form action="update" method="post">
							</c:if>
							<c:if test="${existingSalary == null}">
								<form action="insert" method="post">
							</c:if>


							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">SALARY
									ID</label>

								<div class="col-sm-10">
									<c:if test="${existingSalary == null}">
										<input type="text" class="form-control" id="salaryID"
											value="${nextID}" name="salaryID" readonly="readonly" required="required">
									</c:if>
									<c:if test="${existingSalary != null}">
										<input type="text" class="form-control" id="salaryID"
											value="<c:out value='${existingSalary.salaryID}'/>" name="salaryID"
											readonly="readonly" required="required">
									</c:if>

								</div>
							</div>

							<div class="form-group row">
								<label for="registerID" class="col-sm-2 col-form-label">REG
									ID</label>

								<div class="col-sm-10">
									<select class="custom-select" name="registerID"
										required="required">

										<c:if test="${existingSalary != null}">
											<option selected
												value="<c:out value="${existingSalary.rid}" />">
												<c:out value="${existingSalary.rid}" /></option>
										</c:if>

										<c:forEach var="registrationID" items="${registrationIDs}">

											<option value="<c:out value="${registrationID}" />">
												<c:out value="${registrationID}" /></option>

										</c:forEach>
									</select>
								</div>
							</div>
							

							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">Date
							</label>
								<div class="col-sm-10">
									<input type="date" class="form-control" id="paymentDate" name="paymentDate" required="required"
										value="<c:out value='${existingSalary.payDate}'/>">
								</div>
							</div>

							<div class="form-group row">
								<label for="amount" class="col-sm-2 col-form-label">Amount LKR</label>
								<div class="col-sm-10">
									<input type="number" class="form-control" id="amount" required="required"
										name="amount" value="<c:out value='${existingSalary.amount}'/>">
								</div>
							</div>
							<c:if test="${existingSalary != null}">
								<button type="submit"
									class="btn btn-primary text-uppercase mb-2 mt-4 rounded-pill shadow-sm">
									EDIT PAYMENT</button>
							</c:if>
							<c:if test="${existingSalary == null}">
								<button type="submit"
									class="btn btn-success text-uppercase mb-2 mt-4 rounded-pill shadow-sm">
									SAVE PAYMENT</button>
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
