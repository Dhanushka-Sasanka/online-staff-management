package com.osms.service.impl;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.osms.model.Attendance;
import com.osms.model.Attendance;
import com.osms.service.AttendanceService;
import com.osms.util.Constants;
import com.osms.util.CrudUtil;
import com.osms.util.IDGenerator;

public class AttendanceServiceImpl implements AttendanceService {

	@Override
	public boolean addAttendance(Attendance attendance) throws FileNotFoundException, SQLException, Exception {
		String sql = "INSERT into attendance values(?,?,?,?,?,?)";
		return CrudUtil.executeUpdate(sql, attendance.getAid(), attendance.getRid(), attendance.getDate(),
				attendance.getIn(), attendance.getOut(), attendance.getDescription());
	}

	@Override
	public Attendance getAttendanceByID(String attendanceID) throws FileNotFoundException, SQLException, Exception {
		Attendance Attendance = null;
		String sql = "Select * from attendance where aid = ? ";
		ResultSet rst = CrudUtil.executeQuery(sql, attendanceID);
		while (rst.next()) {
			Attendance = new Attendance(rst.getString(1), rst.getString(2), rst.getDate(3), rst.getTime(4),
					rst.getTime(5),rst.getString(6));
		}
		return Attendance;
	}

	@Override
	public List<Attendance> getAttendances() throws FileNotFoundException, SQLException, Exception {
		List<Attendance> Attendances = new ArrayList<>();

		String sql = "SELECT *  from attendance ORDER BY convert(aid, DECIMAL)";
		ResultSet rst = CrudUtil.executeQuery(sql);
		while (rst.next()) {
			Attendances.add(new Attendance(rst.getString(1), rst.getString(2), rst.getDate(3), rst.getTime(4),
					rst.getTime(5),rst.getString(6)));
		}
		return Attendances;
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
		List<String> AttendanceIds = getAllAttendanceIDs();
		return IDGenerator.generateIDs(AttendanceIds, Constants.ATTENDANCE_ID_PREFIX);
	}

	@Override
	public List<String> getAllAttendanceIDs() throws Exception {
		List<String> AttendanceIds = new ArrayList<>();

		String sql = "SELECT aid from attendance";
		ResultSet rst = CrudUtil.executeQuery(sql);
		while (rst.next()) {
			AttendanceIds.add(rst.getString(1));
		}
		return AttendanceIds;
	}
}
