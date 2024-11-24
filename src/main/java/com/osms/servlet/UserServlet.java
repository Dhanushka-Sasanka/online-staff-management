package com.osms.servlet;

import com.osms.model.User;
import com.osms.service.UserService;
import com.osms.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(urlPatterns = {"/user/new", "/user/insert", "/user/delete", "/user/update",
        "/user/edit", "/user/list"})
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final UserService userService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        this.userService = new UserServiceImpl();

    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/user/new":
                try {
                    showNewForm(request, response);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                break;
            case "/user/insert":
                try {

                    insertUser(request, response);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "/user/delete":
                try {
                    deleteUser(request, response);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
            case "/user/edit":
                try {
                    showEditForm(request, response);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
            case "/user/update":
                try {
                    updateUser(request, response);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                break;
            case "/user/list":
                try {
                    listUser(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            default:
//			listUser(request, response);
                break;
        }

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/users.jsp");
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userrole = request.getParameter("userrole");


        User newUser = new User(0, username, password, userrole);
        userService.addUser(newUser);
        response.sendRedirect("list");

    }

    public void listUser(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<User> listUsers;

        listUsers = userService.getUsers();
        request.setAttribute("listUsers", listUsers);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/list-users.jsp");
        dispatcher.forward(request, response);

    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        userService.removeUser(Integer.parseInt(id));
        response.sendRedirect("list");

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        User existingUser = userService.getUserByID(Integer.parseInt(id));
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/users.jsp");
        request.setAttribute("existingUser", existingUser);

        dispatcher.forward(request, response);

    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userID = request.getParameter("userID");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userrole = request.getParameter("userrole");
        User newUser = new User(Integer.parseInt(userID), username, password, userrole);

        userService.updateUser(Integer.parseInt(userID), newUser);
        response.sendRedirect("list");
    }
}
