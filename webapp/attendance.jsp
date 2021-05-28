<%@page import="com.osms.servlet.AttendanceServlet"%>
<%@page import="com.osms.service.impl.AttendanceServiceImpl"%>
<%@page import="com.osms.service.AttendanceService"%>
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
							<c:if test="${existingAttendance != null}">
								<h3 class="mt-4">EDIT ATTENDANCE</h3>
							</c:if>
							<c:if test="${existingAttendance == null}">
								<h3 class="mt-4">ADD ATTENDANCE</h3>
							</c:if>
						</h2>
					</caption>

					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-user me-1"></i> Basic details of attendance
						</div>
						<div class="card-body col-md-10">


							<c:if test="${existingAttendance != null}">
								<form action="update" method="post">
							</c:if>
							<c:if test="${existingAttendance == null}">
								<form action="insert" method="post">
							</c:if>


							<div class="form-group row">
								<label for="attendanceID" class="col-sm-2 col-form-label">ATTENDANCE
									ID</label>

								<div class="col-sm-10">
									<c:if test="${existingAttendance == null}">
										<input type="text" class="form-control" id="attendanceID"
											value="${nextID}" name="attendanceID" readonly="readonly"
											required="required">
									</c:if>
									<c:if test="${existingAttendance != null}">
										<input type="text" class="form-control" id="attendanceID"
											value="<c:out value='${existingAttendance.aid}'/>"
											name="attendanceID" readonly="readonly" required="required">
									</c:if>

								</div>
							</div>
							<div class="form-group row">
								<label for="registerID" class="col-sm-2 col-form-label">REG
									ID</label>

								<div class="col-sm-10">
									<select class="custom-select" name="registerID"
										required="required">

										<c:if test="${existingAttendance != null}">
											<option selected
												value="<c:out value="${existingAttendance.rid}" />">
												<c:out value="${existingAttendance.rid}" /></option>
										</c:if>

										<c:forEach var="registrationID" items="${registrationIDs}">

											<option value="<c:out value="${registrationID}" />">
												<c:out value="${registrationID}" /></option>

										</c:forEach>
									</select>
								</div>
							</div>


							<div class="form-group row">
								<label for="attendanceDate" class="col-sm-2 col-form-label">Date
								</label>
								<div class="col-sm-10">
									<input type="date" class="form-control" id="attendanceDate"
										name="attendanceDate" required="required"
										value="<c:out value='${existingAttendance.date}'/>">
								</div>
							</div>

							<div class="form-group row">
								<label for="in-time" class="col-sm-2 col-form-label">In
									Time</label>
								<div class="col-sm-10">
									<input type="time" class="form-control" id="in-time"
										name="in-time" required="required"
										value="<c:out value='${existingAttendance.in}'/>">
								</div>
							</div>

							<div class="form-group row">
								<label for="out-time" class="col-sm-2 col-form-label">Out
									Time</label>
								<div class="col-sm-10">
									<input type="time" class="form-control" id="out-time"
										name="out-time" required="required"
										value="<c:out value='${existingAttendance.out}'/>">
								</div>
							</div>

							<div class="form-group row">
								<label for="description" class="col-sm-2 col-form-label">DESCRIPTION
								</label>
								<div class="col-sm-10">
									<textarea rows="3" cols="" class="form-control"
										id="description" name="description"
										value="<c:out value='${existingAttendance.description}'
										/>"></textarea>
								</div>
							</div>


							<c:if test="${existingAttendance != null}">
								<button type="submit"
									class="btn btn-primary text-uppercase mb-2 mt-4 rounded-pill shadow-sm">
									EDIT ATTENDANCE</button>
							</c:if>
							<c:if test="${existingAttendance == null}">
								<button type="submit"
									class="btn btn-success text-uppercase mb-2 mt-4 rounded-pill shadow-sm">
									SAVE ATTENDANCE</button>
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