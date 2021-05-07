package com.CandidateManagement.models;

import java.io.Serializable;

public class Candidate implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	private String name;
	private String email;
	private String institute;
	private String mobno;

	private String joining_date;
	private String job_title;
	private String batch;
	private String location;
	private String skillset;
	private String description;
	private String feedback;
	

	

	public Candidate() {}

	
	
	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getInstitute() {
		return institute;
	}




	public void setInstitute(String institute) {
		this.institute = institute;
	}




	public String getMobno() {
		return mobno;
	}




	public void setMobno(String mobno) {
		this.mobno = mobno;
	}




	public String getJoining_date() {
		return joining_date;
	}




	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}




	public String getJob_title() {
		return job_title;
	}




	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}




	public String getBatch() {
		return batch;
	}




	public void setBatch(String batch) {
		this.batch = batch;
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	public String getSkillset() {
		return skillset;
	}




	public void setSkillset(String skillset) {
		this.skillset = skillset;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getFeedback() {
		return feedback;
	}




	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}







	public Candidate(int id, String name, String email, String institute, String mobno, String joining_date,
			String job_title, String batch, String location, String skillset, String description, String feedback) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.institute = institute;
		this.mobno = mobno;
		this.joining_date = joining_date;
		this.job_title = job_title;
		this.batch = batch;
		this.location = location;
		this.skillset = skillset;
		this.description = description;
		this.feedback = feedback;
	}




	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", email=" + email + ", institute=" + institute + ", mobno="
				+ mobno + ", joining_date=" + joining_date + ", job_title=" + job_title + ", batch=" + batch
				+ ", location=" + location + ", skillset=" + skillset + ", description=" + description + ", feedback="
				+ feedback + "]";
	}








	



	

	
}
