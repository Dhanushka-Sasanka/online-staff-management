package com.osms.service;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import com.osms.model.Attendance;

public interface AttendanceService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(AttendanceService.class.getName());

	/**
	 * Add Attendances for Attendance table
	 * 
	 * @param Attendance
	 * @return boolean
	 */
	public boolean addAttendance(Attendance Attendance) throws FileNotFoundException, SQLException, Exception;

	/**
	 * Get a particular Attendance
	 *
	 * @param empoyeeID
	 * @return Attendance
	 */
	public Attendance getAttendanceByID(String empoyeeID) throws FileNotFoundException, SQLException, Exception;

	/**
	 * Get all list of Attendances
	 *
	 * @return ArrayList<Attendance>
	 */
	public List<Attendance> getAttendances() throws FileNotFoundException, SQLException, Exception;

	/**
	 * Update existing Attendance
	 * 
	 * @param AttendanceID
	 * @param Attendance
	 *
	 * @return boolean 
	 */
	public boolean updateAttendance(String AttendanceID, Attendance Attendance) throws FileNotFoundException, SQLException, Exception;

	/**
	 * Remove existing Attendance
	 * @param AttendanceID
	 * @return boolean
	 */
	public boolean removeAttendance(String AttendanceID) throws FileNotFoundException, SQLException, Exception;
	
	/**
	 * Getting next ID 
	 * @return String
	 */
	public String getNextID()throws Exception;
	
	/**
	 * Getting All IDs 
	 * @return List<String>
	 */
	public List<String> getAllAttendanceIDs()throws Exception;

	/**
	 * getting existing Attendance count
	 */
    int getAllAttendanceCount()throws Exception;
}
