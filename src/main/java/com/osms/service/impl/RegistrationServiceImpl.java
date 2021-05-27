package com.osms.service.impl;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.osms.model.Registration;
import com.osms.model.Registration;
import com.osms.service.RegistrationService;
import com.osms.util.Constants;
import com.osms.util.CrudUtil;
import com.osms.util.IDGenerator;

public class RegistrationServiceImpl implements RegistrationService{

	@Override
	public boolean addRegistration(Registration registration) throws FileNotFoundException, SQLException, Exception {
		String sql = "INSERT into registration values(?,?,?,?,?,?)";
		return CrudUtil.executeUpdate(sql, registration.getRid(), registration.getEmployeId(), registration.getDesignation(),
				registration.getReg_date(), registration.getReg_by(),registration.getLevel());
	}

	@Override
	public Registration getRegistrationByID(String empoyeeID) throws FileNotFoundException, SQLException, Exception {
		Registration registration = null;
		String sql = "Select * from registration where rid = ? ";
		ResultSet rst = CrudUtil.executeQuery(sql, empoyeeID);
		while (rst.next()) {
			registration = new Registration(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDate(4),
					rst.getString(5),rst.getString(6));
		}
		return registration;
	}

	@Override
	public List<Registration> getRegistrations() throws FileNotFoundException, SQLException, Exception {
		List<Registration> registrations = new ArrayList<>();

		String sql = "SELECT *  from registration ORDER BY convert(rid, DECIMAL)";
		ResultSet rst = CrudUtil.executeQuery(sql);
		while (rst.next()) {
			registrations.add(new Registration(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDate(4),
					rst.getString(5),rst.getString(6)));
		}
		return registrations;
	}

	@Override
	public boolean updateRegistration(String registrationID, Registration registration)
			throws FileNotFoundException, SQLException, Exception {
		String sql = "UPDATE registration set emp_id = ? , designation = ? ,reg_date = ? ,registered_by = ?, level = ?"
				+ "where rid = ?";
		return CrudUtil.executeUpdate(sql, registration.getEmployeId(), registration.getDesignation(),
				registration.getReg_date(), registration.getReg_by(),registration.getLevel(), registrationID);
	}

	@Override
	public boolean removeRegistration(String registrationID) throws FileNotFoundException, SQLException, Exception {
		String sql = "DELETE from registration where rid = ?";
		return CrudUtil.executeUpdate(sql, registrationID);
	}
	
	@Override
	public String getNextID() throws Exception{
		List<String> RegistrationIds = getAllRegistrationIDs();
		return IDGenerator.generateIDs(RegistrationIds, Constants.REGISTRATION_ID_PREFIX);
	}

	@Override
	public List<String> getAllRegistrationIDs() throws Exception {
		List<String> RegistrationIds = new ArrayList<>();

		String sql = "SELECT rid from registration";
		ResultSet rst = CrudUtil.executeQuery(sql);
		while (rst.next()) {
			RegistrationIds.add(rst.getString(1));
		}
		return RegistrationIds;
	}
	


}
