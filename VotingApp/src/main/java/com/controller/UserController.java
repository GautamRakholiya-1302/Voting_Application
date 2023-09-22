package com.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.User;
import com.service.CandidateService;
import com.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private CandidateService cndServ;
	
	@RequestMapping("")
	public String dashboard(Model m,Principal p)
	{
		String userName = p.getName(); // it will give the username(email) of person who is login		

		User user = userServ.getUserByEmail(userName);
		
		
		String status = "Not Voted";
		if (cndServ.getCandByUser(userName) != null) {
			
			status = "Voted";
		}
		
		m.addAttribute("status",status);
		
		m.addAttribute("user",user);
		
		
		m.addAttribute("title","Voter Home");
		return "user/dashboard";
	}

}
