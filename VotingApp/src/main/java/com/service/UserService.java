package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userrepo;
	
	
	public void addUser(User user)
	{
		userrepo.save(user);
	}
	
	public List<User> getAllUsers()
	{
		return userrepo.findAll();
	}
	
	public User getUserById(int id)
	{
		Optional<User> user = userrepo.findById(id);
		if(user.isPresent())
		{
			return user.get();
		}
		return null;
	}

	public void deleteUser(int id)
	{
		userrepo.deleteById(id);
	}
	
	public User getUserByEmail(String email)
	{
		return userrepo.getUserByEmail(email);
	}
	
	
}
