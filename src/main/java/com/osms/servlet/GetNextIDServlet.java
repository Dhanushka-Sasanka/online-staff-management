package com.osms.servlet;

import com.osms.service.AttendanceService;
import com.osms.service.EmployeeService;
import com.osms.service.RegistrationService;
import com.osms.service.SalaryService;
import com.osms.service.impl.AttendanceServiceImpl;
import com.osms.service.impl.EmployeeServiceImpl;
import com.osms.service.impl.RegistrationServiceImpl;
import com.osms.service.impl.SalaryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class GetNextIDServlet
 */
//@WebServlet("/GetNextIDServlet")
public class GetNextIDServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final EmployeeService employeeService;
    private final RegistrationService registrationService;
    private final AttendanceService attendanceService;
    private final SalaryService salaryService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNextIDServlet() {
        this.employeeService = new EmployeeServiceImpl();
        this.registrationService = new RegistrationServiceImpl();
        this.attendanceService = new AttendanceServiceImpl();
        this.salaryService = new SalaryServiceImpl();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
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
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private String getNextID(String url) {

        String nextId = "";
        switch (url) {

            case "new-employee.jsp":
                try {
                    nextId = this.employeeService.getNextID();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "registration-employee.jsp":
                try {
                    nextId = this.registrationService.getNextID();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "attendance.jsp":
                try {
                    nextId = this.attendanceService.getNextID();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "salary-employee.jsp":
                try {
                    nextId = this.salaryService.getNextID();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
        return nextId;
    }
}
