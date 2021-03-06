package com.project.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.bean.User;

public interface UserService{

	int addUser(User user);
	
	User validate(String email,String password);
	
}
