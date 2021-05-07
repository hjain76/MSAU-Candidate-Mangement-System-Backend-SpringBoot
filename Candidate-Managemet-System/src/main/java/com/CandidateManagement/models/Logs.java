package com.CandidateManagement.models;

import java.io.Serializable;
import java.sql.Date;

public class Logs implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String action;
	private Date date;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Logs( String name, String action, Date date) {
		super();
		
		this.name = name;
		this.action = action;
		this.date = date;
	}
	
	public Logs()
	{
		
	}
	@Override
	public String toString() {
		return "Logs [name=" + name + ", action=" + action + ", date=" + date + "]";
	}
	
	
	
}