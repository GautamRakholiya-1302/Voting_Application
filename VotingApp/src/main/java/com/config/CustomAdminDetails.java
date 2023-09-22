package com.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.model.Admin;
import com.model.Role;
import com.model.User;



public class CustomAdminDetails implements UserDetails {


	private Admin adm;
	
	
	public CustomAdminDetails(Admin adm) {
		this.adm = adm;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		Iterator<Role> itr = adm.getRoles().iterator();
		while(itr.hasNext())
		{
			authorities.add(new SimpleGrantedAuthority(itr.next().getName()));
		}
		
		return authorities;
	}

	@Override
	public String getPassword() {

		return adm.getPassword();
	}

	@Override
	public String getUsername() {

		return adm.getName();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
