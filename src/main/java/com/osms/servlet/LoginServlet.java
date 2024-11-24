package com.osms.servlet;

import com.osms.model.User;
import com.osms.service.UserService;
import com.osms.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final UserService userService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {

        this.userService = new UserServiceImpl();

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
        if (action.equals("/login")) {
            String message = null;
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            try {
                User user = userService.getUserAuthority(username, password);
                if (user != null) {
                    if (user.getUserRole().equals("ADMIN")) {
                        HttpSession session = request.getSession();
                        session.setAttribute("valiedUser", user.getUserName());
                        response.sendRedirect("homepage.jsp");
                    }
                } else {
                    message = "User name or password is incorrect..!";
                    request.setAttribute("message", message);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                    dispatcher.include(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


}
