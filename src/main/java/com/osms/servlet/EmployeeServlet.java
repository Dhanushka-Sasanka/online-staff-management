package com.osms.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osms.model.Employee;
import com.osms.service.EmployeeService;
import com.osms.service.impl.EmployeeServiceImpl;
import com.osms.util.Constants;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet(urlPatterns = { "/employee/new", "/employee/insert", "/employee/delete", "/employee/update",
		"/employee/edit", "/employee/list" })
public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private EmployeeService employeeService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
		this.employeeService = new EmployeeServiceImpl();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println("action" + action);
		switch (action) {
		case "/employee/new":
			showNewForm(request, response);
			break;
		case "/employee/insert":
			try {

				insertEmployee(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/employee/delete":
			try {
				deleteEmployee(request, response);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "/employee/edit":
			try {
				showEditForm(request, response);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "/employee/update":
			try {
				updateEmployee(request, response);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "/employee/list":
			try {
				listEmployee(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		default:
//			listUser(request, response);
			break;
		}

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/new-employee.jsp");
		dispatcher.forward(request, response);

	}

	private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, SQLException, Exception {
		String eid = request.getParameter("employeeID");
		String fullName = request.getParameter("fullname");
		String email = request.getParameter("employee-email");
		String date = request.getParameter("dob");
		String address = request.getParameter("address");
		SimpleDateFormat availDate = new SimpleDateFormat("yyyy-MM-dd");
		Date chosenDate = availDate.parse(date);
		Employee newEmployee = new Employee(eid, fullName, email, chosenDate, address);
		employeeService.addEmployee(newEmployee);
		response.sendRedirect("list");
//		response.sendRedirect(Constants.FULL_URL+"/list-employee.jsp");
	}

	public void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, SQLException, Exception {
		List<Employee> listEmployees;

		listEmployees = employeeService.getEmployees();
		request.setAttribute("listEmployees", listEmployees);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/list-employee.jsp");
		dispatcher.forward(request, response);

	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		employeeService.removeEmployee(id);
		response.sendRedirect("list");

	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		Employee existingEmployee = employeeService.getEmployeeByID(id);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/new-employee.jsp");
		request.setAttribute("employee", existingEmployee);
		dispatcher.forward(request, response);

	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String eid = request.getParameter("employeeID");
		String fullName = request.getParameter("fullname");
		String email = request.getParameter("employee-email");
		String date = request.getParameter("dob");
		String address = request.getParameter("address");
		SimpleDateFormat availDate = new SimpleDateFormat("yyyy-MM-dd");
		Date chosenDate = availDate.parse(date);
		Employee newEmployee = new Employee(eid, fullName, email, chosenDate, address);
		System.out.println(newEmployee);
		employeeService.updateEmployee(eid, newEmployee);
		response.sendRedirect("list");
	}
}
