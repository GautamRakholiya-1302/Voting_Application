package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.model.Admin;
import com.model.User;
import com.repository.AdminRepository;
import com.repository.UserRepository;

@Service
public class AdminDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private AdminRepository adminRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		//fetching user from 
		
	Admin admin = adminRepository.getAdminByName(username);

		if(admin == null)
		{
			throw new UsernameNotFoundException("Could not found admin !!");
			
		}
		CustomAdminDetails customAdminDetails = new CustomAdminDetails(admin);
		
		return customAdminDetails;
	}

}
