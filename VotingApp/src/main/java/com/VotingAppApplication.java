package com;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.model.Admin;
import com.model.Role;
import com.service.AdminService;
import com.service.RoleService;

@SpringBootApplication
public class VotingAppApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(VotingAppApplication.class, args);
	}

	@Autowired 
	private RoleService roleserv;
	
	@Autowired
	private AdminService admserv;
	
	@Override
	public void run(String... args) throws Exception {
		
		Role role1 = new Role();
		role1.setId(1);
		role1.setName("ROLE_ADMIN");
		roleserv.addRole(role1);
		
		Role role2 = new Role();
		role2.setId(2);
		role2.setName("ROLE_USER");
		roleserv.addRole(role2);
		
		Admin a1 = new Admin();
		a1.setId(1);
		a1.setName("admin");
		a1.setPassword("admin");
		
		List<Role> r = new ArrayList<>();
		r.add(roleserv.getRoleByName("ROLE_ADMIN"));
	
		a1.setRoles(r);
		admserv.addAdmin(a1);
		
		
		
	}

}
