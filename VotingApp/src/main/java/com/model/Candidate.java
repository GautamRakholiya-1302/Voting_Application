package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Candidates")
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String candidate1;
	private String candidate2;
	private String candidate3;
	private String candidate4;
	
	public Candidate() {
	
	}

	public Candidate(int id, String candidate1, String candidate2, String candidate3, String candidate4) {
		super();
		this.id = id;
		this.candidate1 = candidate1;
		this.candidate2 = candidate2;
		this.candidate3 = candidate3;
		this.candidate4 = candidate4;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCandidate1() {
		return candidate1;
	}

	public void setCandidate1(String candidate1) {
		this.candidate1 = candidate1;
	}

	public String getCandidate2() {
		return candidate2;
	}

	public void setCandidate2(String candidate2) {
		this.candidate2 = candidate2;
	}

	public String getCandidate3() {
		return candidate3;
	}

	public void setCandidate3(String candidate3) {
		this.candidate3 = candidate3;
	}

	public String getCandidate4() {
		return candidate4;
	}

	public void setCandidate4(String candidate4) {
		this.candidate4 = candidate4;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", candidate1=" + candidate1 + ", candidate2=" + candidate2 + ", candidate3="
				+ candidate3 + ", candidate4=" + candidate4 + "]";
	}
	
	
	
	
	
	
}
