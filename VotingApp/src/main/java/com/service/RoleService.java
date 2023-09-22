package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Role;
import com.model.User;
import com.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	public void addRole(Role role)
	{
		roleRepository.save(role);
	}
	
	public List<Role> getAllRoles()
	{
		return  roleRepository.findAll();
		
		
	}
	
	public Role getRoleByName(String name)
	{
		return roleRepository.getRoleByName(name);
	}
	
	public Role getRoleById(int id)
	{
		return roleRepository.getById(id);
	}
	
	public void deleteRole(int id)
	{
		roleRepository.deleteById(id);
	}
	
	


}
