package com.osms.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osms.model.Salary;
import com.osms.service.RegistrationService;
import com.osms.service.SalaryService;
import com.osms.service.impl.RegistrationServiceImpl;
import com.osms.service.impl.SalaryServiceImpl;

/**
 * Servlet implementation class SalaryServlet
 */
@WebServlet(urlPatterns = { "/salary/new", "/salary/insert", "/salary/delete", "/salary/update",
		"/salary/edit", "/salary/list" })
public class SalaryServlet extends HttpServlet {
	
	private SalaryService salaryService;
	private RegistrationService registrationService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalaryServlet() {
        this.salaryService = new SalaryServiceImpl();
        this.registrationService = new RegistrationServiceImpl();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();

		switch (action) {
		case "/salary/new":
			try {
				showNewForm(request, response);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;
		case "/salary/insert":
			try {

				insertSalary(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/salary/delete":
			try {
				deleteSalary(request, response);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "/salary/edit":
			try {
				showEditForm(request, response);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "/salary/update":
			try {
				updateSalary(request, response);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "/salary/list":
			try {
				listSalary(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		default:
//			listUser(request, response);
			break;
		}

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<String> registrationIDs = registrationService.getAllRegistrationIDs();
		request.setAttribute("registrationIDs", registrationIDs);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/salary-employee.jsp");
		dispatcher.forward(request, response);

	}

	private void insertSalary(HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, SQLException, Exception {
		String salaryID = request.getParameter("salaryID");
		String registerID = request.getParameter("registerID");
		String paymentDate = request.getParameter("paymentDate");
		String amount = request.getParameter("amount");
		
		
		SimpleDateFormat availDate = new SimpleDateFormat("yyyy-MM-dd");
		Date chosenDate = availDate.parse(paymentDate);

		Salary newSalary = new Salary(salaryID,registerID ,chosenDate, Double.parseDouble(amount));
		System.out.println(newSalary);
		salaryService.addSalary(newSalary);
		response.sendRedirect("list");
		
	}

	public void listSalary(HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, SQLException, Exception {
		List<Salary> listSalarys;

		listSalarys = salaryService.getSalarys();
		request.setAttribute("listSalarys", listSalarys);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/list-salaries.jsp");
		dispatcher.forward(request, response);

	}

	private void deleteSalary(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		salaryService.removeSalary(id);
		response.sendRedirect("list");

	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		Salary existingSalary = salaryService.getSalaryByID(id);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/salary-employee.jsp");
		request.setAttribute("existingSalary", existingSalary);
		List<String> registrationIDs = registrationService.getAllRegistrationIDs();
		request.setAttribute("registrationIDs", registrationIDs);
		dispatcher.forward(request, response);

	}

	private void updateSalary(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String salaryID = request.getParameter("salaryID");
		String registerID = request.getParameter("registerID");
		String paymentDate = request.getParameter("paymentDate");
		String amount = request.getParameter("amount");
		SimpleDateFormat availDate = new SimpleDateFormat("yyyy-MM-dd");
		Date chosenDate = availDate.parse(paymentDate);
		Salary newSalary = new Salary(salaryID,registerID ,chosenDate, Double.parseDouble(amount));
		salaryService.updateSalary(salaryID, newSalary);
		response.sendRedirect("list");
	}
}
