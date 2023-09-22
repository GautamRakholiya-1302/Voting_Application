package com.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	@Query("select r from Role r where r.name = :name")
	public Role getRoleByName(@Param("name") String name);
	
	
	
}
