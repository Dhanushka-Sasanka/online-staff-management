package com.osms.service;

import com.osms.model.Salary;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public interface SalaryService {

    /**
     * Initialize logger
     */
	Logger log = Logger.getLogger(SalaryService.class.getName());

    /**
     * Add Salary for Salary table
     *
     * @param salary
     * @return boolean
     */
	boolean addSalary(Salary salary) throws Exception;

    /**
     * Get a particular Salary
     *
     * @param empoyeeID
     * @return Salary
     */
	Salary getSalaryByID(String salaryID) throws Exception;

    /**
     * Get all list of Salary
     *
     * @return ArrayList<Salary>
     */
	List<Salary> getSalarys() throws Exception;

    /**
     * Update existing Salary
     *
     * @param salaryID
     * @param salary
     * @return boolean
     */
	boolean updateSalary(String salaryID, Salary salary) throws Exception;

    /**
     * Remove existing Salary
     *
     * @param salaryID
     * @return boolean
     */
	boolean removeSalary(String salaryID) throws Exception;

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
	List<String> getAllSalaryIDs() throws Exception;


    /**
     * getting existing Salary Cost
     */
    int getAllSalaryCost() throws Exception;
}
