package com.osms.service.impl;

import com.osms.model.Attendance;
import com.osms.service.AttendanceService;
import com.osms.util.Constants;
import com.osms.util.CrudUtil;
import com.osms.util.IDGenerator;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceServiceImpl implements AttendanceService {

	@Override
	public boolean addAttendance(Attendance attendance) throws FileNotFoundException, SQLException, Exception {
		String sql = "INSERT into attendance values(?,?,?,?,?,?)";
		return CrudUtil.executeUpdate(sql, attendance.getAid(), attendance.getRid(), attendance.getDate(),
				attendance.getIn(), attendance.getOut(), attendance.getDescription());
	}

	@Override
	public Attendance getAttendanceByID(String attendanceID) throws FileNotFoundException, SQLException, Exception {
		Attendance attendance = null;
		String sql = "Select * from attendance where aid = ? ";
		ResultSet rst = CrudUtil.executeQuery(sql, attendanceID);
		while (rst.next()) {
			attendance = new Attendance(rst.getString(1), rst.getString(2), rst.getDate(3), rst.getTime(4),
					rst.getTime(5),rst.getString(6));
		}
		return attendance;
	}

	@Override
	public List<Attendance> getAttendances() throws FileNotFoundException, SQLException, Exception {
		List<Attendance> attendance = new ArrayList<>();

		String sql = "SELECT *  from attendance ORDER BY convert(aid, DECIMAL)";
		ResultSet rst = CrudUtil.executeQuery(sql);
		while (rst.next()) {
			attendance.add(new Attendance(rst.getString(1), rst.getString(2), rst.getDate(3), rst.getTime(4),
					rst.getTime(5),rst.getString(6)));
		}
		return attendance;
	}

	@Override
	public boolean updateAttendance(String attendanceID, Attendance attendance)
			throws FileNotFoundException, SQLException, Exception {
		String sql = "UPDATE attendance set rid = ? , date = ? ,in = ?, out = ? where aid = ?";
		return CrudUtil.executeUpdate(sql, attendance.getRid(), attendance.getDate(),
				attendance.getIn(), attendance.getOut() , attendanceID);
	}

	@Override
	public boolean removeAttendance(String attendanceID) throws FileNotFoundException, SQLException, Exception {
		String sql = "DELETE from attendance where aid = ?";
		return CrudUtil.executeUpdate(sql, attendanceID);
	}
	
	@Override
	public String getNextID() throws Exception{
		List<String> attendanceIds = getAllAttendanceIDs();
		return IDGenerator.generateIDs(attendanceIds, Constants.ATTENDANCE_ID_PREFIX);
	}

	@Override
	public List<String> getAllAttendanceIDs() throws Exception {
		List<String> attendanceIds = new ArrayList<>();

		String sql = "SELECT aid from attendance";
		ResultSet rst = CrudUtil.executeQuery(sql);
		while (rst.next()) {
			attendanceIds.add(rst.getString(1));
		}
		return attendanceIds;
	}

	@Override
	public int getAllAttendanceCount() throws Exception {
		int totalAttendanceCount = 0;
		String sql = "SELECT COUNT(*) FROM attendance where MONTH(DATE) = MONTH(CURDATE())";
		ResultSet rst = CrudUtil.executeQuery(sql);
		while (rst.next()) {
			totalAttendanceCount = rst.getInt(1);
		}
		return totalAttendanceCount;
	}
}
