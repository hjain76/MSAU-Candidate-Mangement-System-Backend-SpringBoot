package com.CandidateManagement.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.CandidateManagement.models.Candidate;

public class candidateRowMapper implements RowMapper<Candidate>{
	
 	@Override
 	public Candidate mapRow(ResultSet rs , int row_number) throws SQLException {
	 	Candidate candidate = new Candidate();
		candidate.setId(rs.getInt("id"));
		candidate.setName(rs.getString("name"));
		candidate.setEmail(rs.getString("email"));
		candidate.setMobno(rs.getString("mobno"));
		candidate.setInstitute(rs.getString("institute"));
		candidate.setJoining_date(rs.getString("joining_date"));
		
		candidate.setLocation(rs.getString("location"));
		candidate.setSkillset(rs.getString("skillset"));
		candidate.setDescription(rs.getString("description"));
		candidate.setFeedback(rs.getString("feedback"));
		candidate.setJob_title(rs.getString("job_title"));
		candidate.setBatch(rs.getString("batch"));
		//candidate.setLastUpdatedBy(rs.getString("lastUpdatedBy"));

		return candidate;
 	}

}
