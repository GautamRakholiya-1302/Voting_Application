package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Admin;
import com.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository admrepo;
	
	public void addAdmin(Admin adm)
	{
		admrepo.save(adm);
	}
	
	public List<Admin> getAllAdmin()
	{
		return admrepo.findAll();
	}
	
	public Admin getAdminById(int id)
	{
		Optional<Admin> adm = admrepo.findById(id);
		if(adm.isPresent())
		{
			return adm.get();
		}
		
		return adm.get();
	}
	
	public void deleteAdmin(int id)
	{
		admrepo.deleteById(id);
	}
	
	public Admin getAdminByName(String name)
	{
		return admrepo.getAdminByName(name);
	}

}
