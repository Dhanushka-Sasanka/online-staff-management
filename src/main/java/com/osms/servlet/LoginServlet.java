package com.osms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.osms.model.User;
import com.osms.service.UserService;
import com.osms.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

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
		
		System.out.println(action);
		
		if(action.equals("/login")) {
			String message = null; 
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			System.out.println(username);
			System.out.println(password);
			System.out.println("adoooooooo");
			
			try {
				
				User user  = userService.getUserAuthority(username, password);
				
				if(user != null) {
					System.out.println("null neee");
					
					if(user.getUserRole().equals("ADMIN")) {
						System.out.println("ADMIN");
						HttpSession session = request.getSession();
						session.setAttribute("valiedUser" ,user.getUserName()); 
						response.sendRedirect("homepage.jsp");
					}
					
					
				}else {
					
					System.out.println("null");
					message = "User name or password is incorrect..!";
					request.setAttribute("message", message);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
					dispatcher.include(request, response);
					
				
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("erroer");
				e.printStackTrace();
			}
			
		}
	}


}
