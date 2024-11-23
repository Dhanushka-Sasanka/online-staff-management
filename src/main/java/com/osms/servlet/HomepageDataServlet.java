package com.osms.servlet;

import com.osms.service.*;
import com.osms.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class HomepageDataServlet
 */
//@WebServlet("/HomepageDataServlet")
public class HomepageDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeService employeeService;
	private UserService userService;
	private AttendanceService attendanceService;
	private SalaryService salaryService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomepageDataServlet() {
		this.employeeService = new EmployeeServiceImpl();
		this.userService = new UserServiceImpl();
		this.attendanceService = new AttendanceServiceImpl();
		this.salaryService = new SalaryServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("employeeCount", getHomePageData("total-employee"));
		request.setAttribute("usersCount", getHomePageData("total-users"));
		request.setAttribute("attendanceCount", getHomePageData("total-attendances"));
		request.setAttribute("salaryCost", getHomePageData("total-salaryCost"));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private int getHomePageData(String url) {

		int count = 0;
		switch (url) {

		case "total-employee":
			try {
				count = this.employeeService.getAllEmployeeCount();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "total-users":
			try {
				count = this.userService.getAllUsersCount();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "total-attendances":
			try {
				count = this.attendanceService.getAllAttendanceCount();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "total-salaryCost":
			try {
				count = this.salaryService.getAllSalaryCost();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		return count;
	}
}
