package com.osms.service;

import com.osms.model.Employee;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public interface EmployeeService {

    /**
     * Initialize logger
     */
    Logger log = Logger.getLogger(EmployeeService.class.getName());

    /**
     * Add employees for employee table
     *
     * @param employee
     * @return boolean
     */
    boolean addEmployee(Employee employee) throws Exception;

    /**
     * Get a particular Employee
     *
     * @param empoyeeID
     * @return Employee
     */
    Employee getEmployeeByID(String empoyeeID) throws Exception;

    /**
     * Get all list of employees
     *
     * @return ArrayList<Employee>
     */
    List<Employee> getEmployees() throws Exception;

    /**
     * Update existing employee
     *
     * @param employeeID
     * @param employee
     * @return boolean
     */
    boolean updateEmployee(String employeeID, Employee employee) throws Exception;

    /**
     * Remove existing employee
     *
     * @param employeeID
     * @return boolean
     */
    boolean removeEmployee(String employeeID) throws Exception;

    /**
     * Getting next ID
     *
     * @return String
     */
    String getNextID() throws Exception;

    /**
     * Getting All IDs
     *
     * @return List<String>
     */
    List<String> getAllEmployeeIDs() throws Exception;

    /**
     * Getting All IDs Not In Registration
     *
     * @return List<String>
     */
    List<String> getAllRegistrationIDsNotInRegistration() throws Exception;

    /**
     * getting existing Employee count
     */
    int getAllEmployeeCount() throws Exception;

}
