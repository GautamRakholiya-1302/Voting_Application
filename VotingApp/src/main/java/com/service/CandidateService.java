package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Candidate;
import com.repository.CandidateRepository;

@Service
public class CandidateService {
	
	@Autowired
	private CandidateRepository cndrepo;
	
	
	public void addCandidate(Candidate cnd)
	{
		cndrepo.save(cnd);
	}
	
	public List<Candidate> getAllCandidates()
	{
		return cndrepo.findAll();
	}

	public Candidate getCandidateById(int id)
	{
		Optional<Candidate> cnd = cndrepo.findById(id);
		if(cnd.isPresent())
		{
			return cnd.get();
		}
		return cnd.get();
	}
	
	
	public void deleteCandidate(int id)
	{
		cndrepo.deleteById(id);
	}
	
	public Candidate getCandByUser(String email)
	{
		return cndrepo.getCandByUser(email);
	}
	
	
}
