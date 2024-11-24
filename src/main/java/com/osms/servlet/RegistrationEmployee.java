package com.osms.servlet;

import com.osms.model.Registration;
import com.osms.service.RegistrationService;
import com.osms.service.impl.RegistrationServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class RegistrationRegistration
 */
@WebServlet(urlPatterns = {"/register/new", "/register/insert", "/register/delete", "/register/update",
        "/register/edit", "/register/list"})
public class RegistrationEmployee extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final RegistrationService RegistrationService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationEmployee() {
        this.RegistrationService = new RegistrationServiceImpl();
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();

        switch (action) {
            case "/register/new":
                showNewForm(request, response);
                break;
            case "/register/insert":
                try {
                    insertRegistration(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "/register/delete":
                try {
                    deleteRegistration(request, response);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
            case "/register/edit":
                try {
                    showEditForm(request, response);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
            case "/register/update":
                try {
                    updateRegistration(request, response);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
            case "/register/list":
                try {
                    listRegistration(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            default:
//				listUser(request, response);
                break;
        }

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/registration-employee.jsp");
        dispatcher.forward(request, response);

    }

    private void insertRegistration(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String rid = request.getParameter("rid");
        String eid = request.getParameter("employeId");
        String designation = request.getParameter("designation");
        String reg_date = request.getParameter("reg_date");
        String level = request.getParameter("level");
        String reg_by = request.getParameter("reg_by");
        SimpleDateFormat availDate = new SimpleDateFormat("yyyy-MM-dd");
        Date chosenDate = availDate.parse(reg_date);
        Registration newRegistration = new Registration(rid, eid, designation, chosenDate, reg_by, level);
        RegistrationService.addRegistration(newRegistration);
        response.sendRedirect("list");

    }

    public void listRegistration(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Registration> listRegistrations;

        listRegistrations = RegistrationService.getRegistrations();
        request.setAttribute("listRegistrations", listRegistrations);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/list-registration.jsp");
        dispatcher.forward(request, response);

    }

    private void deleteRegistration(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        RegistrationService.removeRegistration(id);
        response.sendRedirect("list");

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        Registration existingRegistration = RegistrationService.getRegistrationByID(id);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/registration-employee.jsp");
        request.setAttribute("registration", existingRegistration);
        dispatcher.forward(request, response);

    }

    private void updateRegistration(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rid = request.getParameter("rid");
        String eid = request.getParameter("employeId");
        String designation = request.getParameter("designation");
        String reg_date = request.getParameter("reg_date");
        String level = request.getParameter("level");
        String reg_by = request.getParameter("reg_by");
        SimpleDateFormat availDate = new SimpleDateFormat("yyyy-MM-dd");
        Date chosenDate = availDate.parse(reg_date);
        Registration newRegistration = new Registration(rid, eid, designation, chosenDate, reg_by, level);
        RegistrationService.updateRegistration(rid, newRegistration);
        response.sendRedirect("list");
    }
}
