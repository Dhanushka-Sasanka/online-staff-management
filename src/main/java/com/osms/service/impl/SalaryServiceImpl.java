package com.osms.service.impl;

import com.osms.model.Salary;
import com.osms.service.SalaryService;
import com.osms.util.Constants;
import com.osms.util.CrudUtil;
import com.osms.util.IDGenerator;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryServiceImpl implements SalaryService {

	@Override
	public boolean addSalary(Salary salary) throws FileNotFoundException, SQLException, Exception {
		String sql = "INSERT into salary values(?,?,?,?)";
		return CrudUtil.executeUpdate(sql, salary.getSalaryID(), salary.getRid(), salary.getPayDate(),
				salary.getAmount());
	}

	@Override
	public Salary getSalaryByID(String salaryID) throws FileNotFoundException, SQLException, Exception {
		Salary salarys = null;
		String sql = "select * from salary where salaryid = ? ";
		ResultSet rst = CrudUtil.executeQuery(sql, salaryID);
		while (rst.next()) {
			salarys = new Salary(rst.getString(1), rst.getString(2), rst.getDate(3), rst.getDouble(4));
		}
		return salarys;
	}

	@Override
	public List<Salary> getSalarys() throws FileNotFoundException, SQLException, Exception {
		List<Salary> salarys = new ArrayList<>();

		String sql = "SELECT *  from salary ORDER BY convert(salaryID, DECIMAL)";
		ResultSet rst = CrudUtil.executeQuery(sql);
		while (rst.next()) {
			salarys.add(new Salary(rst.getString(1), rst.getString(2), rst.getDate(3), rst.getDouble(4)));
		}
		return salarys;
	}

	@Override
	public boolean updateSalary(String salaryID, Salary salary) throws FileNotFoundException, SQLException, Exception {
		String sql = "UPDATE salary set regID = ? , salaryDate = ? , amount = ? where salaryID = ?";
		return CrudUtil.executeUpdate(sql, salary.getRid(), salary.getPayDate(),
				salary.getAmount() , salaryID);
	}

	@Override
	public boolean removeSalary(String salaryID) throws FileNotFoundException, SQLException, Exception {
		String sql = "DELETE from salary where salaryID = ?";
		return CrudUtil.executeUpdate(sql, salaryID);
	}

	@Override
	public String getNextID() throws Exception {
		List<String> AttendanceIds = getAllSalaryIDs();
		return IDGenerator.generateIDs(AttendanceIds, Constants.SALARY_ID_PREFIX);
	}

	@Override
	public List<String> getAllSalaryIDs() throws Exception {
		List<String> AttendanceIds = new ArrayList<>();

		String sql = "SELECT salaryID from salary";
		ResultSet rst = CrudUtil.executeQuery(sql);
		while (rst.next()) {
			AttendanceIds.add(rst.getString(1));
		}
		return AttendanceIds;
	}

	@Override
	public int getAllSalaryCost() throws Exception {
		int totalSalaryCost = 0;
		String sql = "SELECT SUM(amount) FROM salary";
		ResultSet rst = CrudUtil.executeQuery(sql);
		while (rst.next()) {
			totalSalaryCost = rst.getInt(1);
		}
		return totalSalaryCost;
	}

}
