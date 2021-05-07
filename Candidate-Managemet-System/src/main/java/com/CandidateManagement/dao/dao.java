package com.CandidateManagement.dao;

import com.CandidateManagement.models.Candidate;
import java.util.List;

public interface dao<Candidate> {
	
	List<Candidate> getCandidates();
		
	Candidate create(Candidate candidate);
		
	int updateCandidate(Candidate candidate, int id);
	
	void delete(int id);
}
