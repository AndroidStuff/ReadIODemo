package com.example.dto;

public class Record {
	private String id;
	private String name;
	private String email;
	private String company;

	@Override
	public String toString() {
		return "[ id : " + id + ", name : " + name + ", email : " + email + ", company : " + company + " ] \n";
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCompany() {
		return company;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
