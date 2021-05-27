<div id="layoutSidenav_nav">
	<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
		<div class="sb-sidenav-menu">
			<div class="nav">
				<a class="nav-link"
					href="<%=request.getContextPath()%>/homepage.jsp">
					<div class="sb-nav-link-icon">
						<i class="fas fa-tachometer-alt"></i>
					</div> Dashboard
				</a>

				<!-- 				Employee navigations -->
				<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
					data-bs-target="#collapseLayouts" aria-expanded="false"
					aria-controls="collapseLayouts">
					<div class="sb-nav-link-icon">
						<i class="fas fa-users"></i>
					</div> Employee
					<div class="sb-sidenav-collapse-arrow">
						<i class="fas fa-angle-down"></i>
					</div>
				</a>
				<div class="collapse" id="collapseLayouts"
					aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
					<nav class="sb-sidenav-menu-nested nav">
						<a class="nav-link"
							href="<%=request.getContextPath()%>/employee/new">Add New</a> <a
							class="nav-link"
							href="<%=request.getContextPath()%>/employee/list">All
							Details</a>
					</nav>
				</div>

<!--Registration navigations -->
				<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
					data-bs-target="#collapseRegistration" aria-expanded="false"
					aria-controls="collapseLayouts">
					<div class="sb-nav-link-icon">
						<i class="fas fa-users"></i>
					</div> Registration
					<div class="sb-sidenav-collapse-arrow">
						<i class="fas fa-angle-down"></i>
					</div>
				</a>
				<div class="collapse" id="collapseRegistration"
					aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
					<nav class="sb-sidenav-menu-nested nav">
						<a class="nav-link"
							href="<%=request.getContextPath()%>/register/new">Create</a> <a
							class="nav-link"
							href="<%=request.getContextPath()%>/register/list">All
							Details</a>
					</nav>
				</div>

			</div>
		</div>
		<div class="sb-sidenav-footer">
			<div class="small">Logged in as:</div>
			Staff Management
		</div>
	</nav>
</div>