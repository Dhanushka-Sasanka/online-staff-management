package com.osms.service;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import com.osms.model.Employee;

public interface EmployeeService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(EmployeeService.class.getName());

	/**
	 * Add employees for employee table
	 * 
	 * @param employee
	 * @return boolean
	 */
	public boolean addEmployee(Employee employee) throws FileNotFoundException, SQLException, Exception;

	/**
	 * Get a particular Employee
	 *
	 * @param empoyeeID
	 * @return Employee
	 */
	public Employee getEmployeeByID(String empoyeeID) throws FileNotFoundException, SQLException, Exception;

	/**
	 * Get all list of employees
	 *
	 * @return ArrayList<Employee>
	 */
	public List<Employee> getEmployees() throws FileNotFoundException, SQLException, Exception;

	/**
	 * Update existing employee
	 * 
	 * @param employeeID
	 * @param employee
	 *
	 * @return boolean 
	 */
	public boolean updateEmployee(String employeeID, Employee employee) throws FileNotFoundException, SQLException, Exception;

	/**
	 * Remove existing employee
	 * @param employeeID
	 * @return boolean
	 */
	public boolean removeEmployee(String employeeID) throws FileNotFoundException, SQLException, Exception;
	
	/**
	 * Getting next ID 
	 * @return String
	 */
	public String getNextID()throws Exception;
	
	/**
	 * Getting All IDs 
	 * @return List<String>
	 */
	public List<String> getAllEmployeeIDs()throws Exception;
	
	/**
	 * Getting All IDs Not In Registration
	 * @return List<String>
	 */
	public List<String> getAllRegistrationIDsNotInRegistration() throws Exception; 

}
