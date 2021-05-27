package com.osms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osms.service.EmployeeService;
import com.osms.service.RegistrationService;
import com.osms.service.impl.EmployeeServiceImpl;
import com.osms.service.impl.RegistrationServiceImpl;

/**
 * Servlet implementation class GetEmployeeIDsNotInRegistration
 */
public class GetEmployeeIDsNotInRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeService employeeService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployeeIDsNotInRegistration() {
    	this.employeeService = new EmployeeServiceImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<String> employeeIDsNotInRegistration;
		try {
			employeeIDsNotInRegistration = getEmployeeIdsNotInRegistration();
			request.setAttribute("employeeIDsNotInRegistration", employeeIDsNotInRegistration);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private List<String>getEmployeeIdsNotInRegistration() throws Exception {
		return this.employeeService.getAllRegistrationIDsNotInRegistration();
	}

}
