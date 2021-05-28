package com.osms.model;

import java.util.Date;

public class Salary {
	
	private String salaryID;
	private String rid;
	private Date payDate;
	private Double  amount;
	
	
	public Salary() {}


	public Salary(String salaryID, String rid, Date payDate, Double amount) {
		this.salaryID = salaryID;
		this.rid = rid;
		this.payDate = payDate;
		this.amount = amount;
	}


	public String getSalaryID() {
		return salaryID;
	}


	public void setSalaryID(String salaryID) {
		this.salaryID = salaryID;
	}


	public String getRid() {
		return rid;
	}


	public void setRid(String rid) {
		this.rid = rid;
	}


	public Date getPayDate() {
		return payDate;
	}


	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Salary [salaryID=" + salaryID + ", rid=" + rid + ", payDate=" + payDate + ", amount=" + amount + "]";
	}
	
	
	

}
