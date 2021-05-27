package com.osms.model;

import java.util.Date;

public class Employee {
	
	private String eid;
	private String fullName;
	private String email;
	private Date dateOfBirth;
	private String address;
	
	public Employee() {}
	
	
	public Employee(String eid, String fullName, String email, Date dateOfBirth, String address) {
		this.eid = eid;
		this.fullName = fullName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", fullName=" + fullName + ", email=" + email + ", dateOfBirth=" + dateOfBirth
				+ ", address=" + address + "]";
	}
	

}
