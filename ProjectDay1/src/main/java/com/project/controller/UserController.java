package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.bean.User;
import com.project.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/app")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping(value="/register",produces="application/json")
	public String forAddUser()
	{

		return "on register page";
	}

	
	@PostMapping(value="/register",produces="application/json",consumes="application/json")
	public String forAddUser(@RequestBody User user)
	{
		if(userService.addUser(user)>0) {
			return "register successfull";
		}
		return "register not successful";
	}
	
	@GetMapping(value = "/login",produces="application/json")
	public String forLogin()
	{
		return "on login page";
	}
	
/*	@PostMapping(value = "/login",produces="application/json", consumes="application/json")
	public String forLogin(@RequestBody User user)
	{
		System.out.println("email:"+user.getEmail()+"passowrd:"+user.getPassword());
		User u=userService.validate(user.getEmail(),user.getPassword());
		System.out.println(u);
		if(u!=null)
		{
			return "login successfull";
		}
		else {
			return "login fail";
		}
	}  */
	
	
	@PostMapping(value = "/login",produces="application/json", consumes="application/json")
	@ResponseBody
	public User forLogin(@RequestBody User user)
	{
//		System.out.println("email:"+email+"passowrd:"+password);
		User u=userService.validate(user.getEmail(), user.getPassword());
		System.out.println(u);
		if(u!=null)
		{
			return u;
		}
		else {
			return null;
		}
	}
	
	@GetMapping("/logout")
	public String forLogout()
	{
		return "logout";
	}
	


	
	
}
