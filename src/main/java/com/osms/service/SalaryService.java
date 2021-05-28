package com.osms.service;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import com.osms.model.Salary;

public interface SalaryService {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(SalaryService.class.getName());

	/**
	 * Add Salary for Salary table
	 * 
	 * @param salary
	 * @return boolean
	 */
	public boolean addSalary(Salary salary) throws FileNotFoundException, SQLException, Exception;

	/**
	 * Get a particular Salary
	 *
	 * @param empoyeeID
	 * @return Salary
	 */
	public Salary getSalaryByID(String salaryID) throws FileNotFoundException, SQLException, Exception;

	/**
	 * Get all list of Salary
	 *
	 * @return ArrayList<Salary>
	 */
	public List<Salary> getSalarys() throws FileNotFoundException, SQLException, Exception;

	/**
	 * Update existing Salary
	 * 
	 * @param salaryID
	 * @param salary
	 *
	 * @return boolean 
	 */
	public boolean updateSalary(String salaryID, Salary salary) throws FileNotFoundException, SQLException, Exception;

	/**
	 * Remove existing Salary
	 * @param salaryID
	 * @return boolean
	 */
	public boolean removeSalary(String salaryID) throws FileNotFoundException, SQLException, Exception;
	
	/**
	 * Getting next ID 
	 * @return String
	 */
	public String getNextID()throws Exception;
	
	/**
	 * Getting All IDs 
	 * @return List<String>
	 */
	public List<String> getAllSalaryIDs()throws Exception;
	

}
