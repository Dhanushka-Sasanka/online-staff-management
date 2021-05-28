package com.osms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osms.service.AttendanceService;
import com.osms.service.EmployeeService;
import com.osms.service.RegistrationService;
import com.osms.service.impl.AttendanceServiceImpl;
import com.osms.service.impl.EmployeeServiceImpl;
import com.osms.service.impl.RegistrationServiceImpl;

/**
 * Servlet implementation class GetNextIDServlet
 */
//@WebServlet("/GetNextIDServlet")
public class GetNextIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeService employeeService;
	private RegistrationService registrationService;
	private AttendanceService attendanceService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetNextIDServlet() {
		this.employeeService = new EmployeeServiceImpl();
		this.registrationService = new RegistrationServiceImpl();
		this.attendanceService = new AttendanceServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURI();
		String pageName = url.split("/")[2];
		String nextID = getNextID(pageName);
		request.setAttribute("nextID", nextID);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private String getNextID(String url) {

		String nextId = "";
		switch (url) {

		case "new-employee.jsp":
			try {
				nextId = this.employeeService.getNextID();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "registration-employee.jsp":
			try {
				nextId = this.registrationService.getNextID();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "attendance.jsp":
			try {
				nextId = this.attendanceService.getNextID();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		return nextId;
	}
}
