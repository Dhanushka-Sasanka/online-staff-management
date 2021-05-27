package com.osms.service;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import com.osms.model.Registration;

public interface RegistrationService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(RegistrationService.class.getName());

	/**
	 * Add Registrations for Registration table
	 * 
	 * @param Registration
	 * @return boolean
	 */
	public boolean addRegistration(Registration registration) throws FileNotFoundException, SQLException, Exception;

	/**
	 * Get a particular Registration
	 *
	 * @param empoyeeID
	 * @return Registration
	 */
	public Registration getRegistrationByID(String registrationID) throws FileNotFoundException, SQLException, Exception;

	/**
	 * Get all list of Registrations
	 *
	 * @return ArrayList<Registration>
	 */
	public List<Registration> getRegistrations() throws FileNotFoundException, SQLException, Exception;

	/**
	 * Update existing Registration
	 * 
	 * @param RegistrationID
	 * @param Registration
	 *
	 * @return boolean 
	 */
	public boolean updateRegistration(String registrationID, Registration registration) throws FileNotFoundException, SQLException, Exception;

	/**
	 * Remove existing Registration
	 * @param RegistrationID
	 * @return boolean
	 */
	public boolean removeRegistration(String registrationID) throws FileNotFoundException, SQLException, Exception;
	
	/**
	 * Getting next ID 
	 * @return String
	 */
	public String getNextID()throws Exception;
	
	/**
	 * Getting All IDs 
	 * @return List<String>
	 */
	public List<String> getAllRegistrationIDs()throws Exception;
	
}
