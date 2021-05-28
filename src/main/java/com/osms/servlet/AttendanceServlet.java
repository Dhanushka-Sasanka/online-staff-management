package com.osms.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
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

import com.osms.model.Attendance;
import com.osms.service.AttendanceService;
import com.osms.service.RegistrationService;
import com.osms.service.impl.AttendanceServiceImpl;
import com.osms.service.impl.EmployeeServiceImpl;
import com.osms.service.impl.RegistrationServiceImpl;

/**
 * Servlet implementation class AttendanceServlet
 */
@WebServlet(urlPatterns = { "/attendance/new", "/attendance/insert", "/attendance/delete", "/attendance/update",
		"/attendance/edit", "/attendance/list" })
public class AttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AttendanceService attendanceService;
	private RegistrationService registrationService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AttendanceServlet() {
		this.attendanceService = new AttendanceServiceImpl();
		this.registrationService = new RegistrationServiceImpl();
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

		switch (action) {
		case "/attendance/new":
			try {
				showNewForm(request, response);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;
		case "/attendance/insert":
			try {

				insertAttendance(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/attendance/delete":
			try {
				deleteAttendance(request, response);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "/attendance/edit":
			try {
				showEditForm(request, response);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "/attendance/update":
			try {
				updateAttendance(request, response);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "/attendance/list":
			try {
				listAttendance(request, response);
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
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/attendance.jsp");
		dispatcher.forward(request, response);

	}

	private void insertAttendance(HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, SQLException, Exception {
		String attendanceID = request.getParameter("attendanceID");
		String registerID = request.getParameter("registerID");
		String attendanceDate = request.getParameter("attendanceDate");
		String inTime = request.getParameter("in-time");
		String outTime = request.getParameter("out-time");
		String description = request.getParameter("description");
		SimpleDateFormat availDate = new SimpleDateFormat("yyyy-MM-dd");
		Date chosenDate = availDate.parse(attendanceDate);

		Date convertedInTime = new SimpleDateFormat("HH:mm").parse(inTime);
		
		Date convertedOutTime = new SimpleDateFormat("HH:mm").parse(outTime);

		Attendance newAttendance = new Attendance(attendanceID, registerID, chosenDate, new Time(convertedInTime.getTime()),
				new Time(convertedOutTime.getTime()), description);
		System.out.println(newAttendance);
		attendanceService.addAttendance(newAttendance);
		response.sendRedirect("list");
//		response.sendRedirect(Constants.FULL_URL+"/list-attendance.jsp");
	}

	public void listAttendance(HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, SQLException, Exception {
		List<Attendance> listAttendances;

		listAttendances = attendanceService.getAttendances();
		request.setAttribute("listAttendances", listAttendances);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/list-attendance.jsp");
		dispatcher.forward(request, response);

	}

	private void deleteAttendance(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		attendanceService.removeAttendance(id);
		response.sendRedirect("list");

	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		Attendance existingAttendance = attendanceService.getAttendanceByID(id);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/attendance.jsp");
		request.setAttribute("existingAttendance", existingAttendance);
		
		List<String> registrationIDs = registrationService.getAllRegistrationIDs();
		request.setAttribute("registrationIDs", registrationIDs);
		
		
		dispatcher.forward(request, response);

	}

	private void updateAttendance(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String attendanceID = request.getParameter("attendanceID");
		String registerID = request.getParameter("registerID");
		String attendanceDate = request.getParameter("attendanceDate");
		String inTime = request.getParameter("in-time");
		String outTime = request.getParameter("out-time");
		String description = request.getParameter("description");
		SimpleDateFormat availDate = new SimpleDateFormat("yyyy-MM-dd");
		Date chosenDate = availDate.parse(attendanceDate);

		Date convertedInTime = new SimpleDateFormat("HH:mm").parse(inTime);
		
		Date convertedOutTime = new SimpleDateFormat("HH:mm").parse(outTime);

		Attendance newAttendance = new Attendance(attendanceID, registerID, chosenDate,
				new Time(convertedInTime.getTime()),
				new Time(convertedOutTime.getTime()), description);
		System.out.println(newAttendance);
		attendanceService.updateAttendance(attendanceID, newAttendance);
		response.sendRedirect("list");
	}

}
