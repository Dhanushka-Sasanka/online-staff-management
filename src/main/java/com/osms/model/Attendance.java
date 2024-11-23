package com.osms.model;

import java.sql.Time;
import java.util.Date;

public class Attendance {
	
	private String aid;
	private String rid;
	private Date date;
	private Time  in;
	private Time  out;
	private String  description;
	
	
	public Attendance() {
		super();
	}


	public Attendance(String aid, String rid, Date date, Time in, Time out, String description) {
		super();
		this.aid = aid;
		this.rid = rid;
		this.date = date;
		this.in = in;
		this.out = out;
		this.description = description;
	}


	public String getAid() {
		return aid;
	}


	public void setAid(String aid) {
		this.aid = aid;
	}


	public String getRid() {
		return rid;
	}


	public void setRid(String rid) {
		this.rid = rid;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Time getIn() {
		return in;
	}


	public void setIn(Time in) {
		this.in = in;
	}


	public Time getOut() {
		return out;
	}


	public void setOut(Time out) {
		this.out = out;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Attendance [aid=" + aid + ", rid=" + rid + ", date=" + date + ", in=" + in + ", out=" + out
				+ ", description=" + description + "]";
	}
	
	

}
