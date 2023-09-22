package com.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Candidate;

import com.service.CandidateService;



@Controller
public class CandidateController {
	
	@Autowired
	private CandidateService cndServ;
	

	
	@PostMapping("/addcandidate")
	public String addCandidate(@RequestParam("candidate") String candidate, 
			Principal p,Model model, HttpSession session)
	{
		String email = p.getName();
		
		if (cndServ.getCandByUser(email) != null) {
					
			session.setAttribute("msg", "Already Voted");
		}
		else
		{
			String candidate1 = "";
			String candidate2 = "";
			String candidate3 = "";
			String candidate4 = "";

			if (candidate.equals("candidate1"))
				candidate1 = email;
			else if (candidate.equals("candidate2"))
				candidate2 = email;
			else if (candidate.equals("candidate3"))
				candidate3 = email;
			else if (candidate.equals("candidate4"))
				candidate4 = email;

			Candidate cnd = new Candidate();
			cnd.setCandidate1(candidate1);
			cnd.setCandidate2(candidate2);
			cnd.setCandidate3(candidate3);
			cnd.setCandidate4(candidate4);

			cndServ.addCandidate(cnd);
			
			session.setAttribute("msg", "Successfully Voted...");
		}
		
		return "redirect:user/";
	}
	
	

}
