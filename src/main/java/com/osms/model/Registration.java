package com.osms.model;

import java.util.Date;

public class Registration {
	
	private String rid;
	private String employeId;
	private String designation;
	private Date reg_date;
	private String reg_by;
	private String level;
	
	
	public Registration() {
	}


	public Registration(String rid, String employeId, String designation, Date reg_date, String reg_by, String level) {
		this.rid = rid;
		this.employeId = employeId;
		this.designation = designation;
		this.reg_date = reg_date;
		this.reg_by = reg_by;
		this.level = level;
	}


	public String getRid() {
		return rid;
	}


	public void setRid(String rid) {
		this.rid = rid;
	}


	public String getEmployeId() {
		return employeId;
	}


	public void setEmployeId(String employeId) {
		this.employeId = employeId;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public Date getReg_date() {
		return reg_date;
	}


	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}


	public String getReg_by() {
		return reg_by;
	}


	public void setReg_by(String reg_by) {
		this.reg_by = reg_by;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	@Override
	public String toString() {
		return "Registration [rid=" + rid + ", employeId=" + employeId + ", designation=" + designation + ", reg_date="
				+ reg_date + ", reg_by=" + reg_by + ", level=" + level + "]";
	}
	
	
	

}
