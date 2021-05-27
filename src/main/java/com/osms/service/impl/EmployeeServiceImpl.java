package com.osms.service.impl;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.osms.model.Employee;
import com.osms.service.EmployeeService;
import com.osms.util.Constants;
import com.osms.util.CrudUtil;
import com.osms.util.IDGenerator;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public boolean addEmployee(Employee employee) throws FileNotFoundException, SQLException, Exception {
		String sql = "INSERT into employee values(?,?,?,?,?)";
		return CrudUtil.executeUpdate(sql, employee.getEid(), employee.getFullName(), employee.getEmail(),
				employee.getDateOfBirth(), employee.getAddress());
	}

	@Override
	public Employee getEmployeeByID(String empoyeeID) throws FileNotFoundException, SQLException, Exception {
		Employee employee = null;
		String sql = "Select * from employee where eid = ? ";
		ResultSet rst = CrudUtil.executeQuery(sql, empoyeeID);
		while (rst.next()) {
			employee = new Employee(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDate(4),
					rst.getString(5));
		}
		return employee;
	}

	@Override
	public List<Employee> getEmployees() throws FileNotFoundException, SQLException, Exception {
		List<Employee> employees = new ArrayList<>();

		String sql = "SELECT *  from employee ORDER BY convert(eid, DECIMAL)";
		ResultSet rst = CrudUtil.executeQuery(sql);
		while (rst.next()) {
			employees.add(new Employee(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDate(4),
					rst.getString(5)));
		}
		return employees;
	}

	@Override
	public boolean updateEmployee(String employeeID, Employee employee)
			throws FileNotFoundException, SQLException, Exception {
		String sql = "UPDATE employee set fullname = ? , email = ? ,dob = ?, address = ? where eid = ?";
		return CrudUtil.executeUpdate(sql, employee.getFullName(), employee.getEmail(),
				employee.getDateOfBirth(), employee.getAddress() , employeeID);
	}

	@Override
	public boolean removeEmployee(String employeeID) throws FileNotFoundException, SQLException, Exception {
		String sql = "DELETE from employee where eid = ?";
		return CrudUtil.executeUpdate(sql, employeeID);
	}
	
	@Override
	public String getNextID() throws Exception{
		List<String> employeeIds = getAllEmployeeIDs();
		return IDGenerator.generateIDs(employeeIds, Constants.EMPLOYEE_ID_PREFIX);
	}

	@Override
	public List<String> getAllEmployeeIDs() throws Exception {
		List<String> employeeIds = new ArrayList<>();

		String sql = "SELECT eid from employee";
		ResultSet rst = CrudUtil.executeQuery(sql);
		while (rst.next()) {
			employeeIds.add(rst.getString(1));
		}
		return employeeIds;
	}
	
	@Override
	public List<String> getAllRegistrationIDsNotInRegistration() throws Exception {
		List<String> RegistrationIds = new ArrayList<>();

		String sql = "SELECT e.eid from employee e WHERE  NOT EXISTS \r\n"
				+ "(SELECT r.emp_id FROM registration r WHERE r.emp_id = e.eid)";
		ResultSet rst = CrudUtil.executeQuery(sql);
		while (rst.next()) {
			RegistrationIds.add(rst.getString(1));
		}
		return RegistrationIds;
	}


}
