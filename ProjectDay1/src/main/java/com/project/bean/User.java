package com.project.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String address;

	
	public User()
	{
		
	}
	
	public User(String email,String password)
	{
		this.email=email;
		this.password=password;
	}

	
	
	
	
	
}
