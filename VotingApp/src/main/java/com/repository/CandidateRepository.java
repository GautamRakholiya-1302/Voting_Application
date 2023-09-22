package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer>{

	
	@Query("select v from Candidate v where v.candidate1 = :email or v.candidate2 = :email or v.candidate3 = :email or v.candidate4 = :email")
	public Candidate getCandByUser(@Param("email")String email);
	
	
}
