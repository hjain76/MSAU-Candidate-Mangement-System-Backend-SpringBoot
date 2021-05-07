package com.CandidateManagement.mappers;


	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.junit.jupiter.api.Assertions.assertNotNull;

	import java.sql.ResultSet;
	import java.sql.SQLException;


	import org.junit.jupiter.api.Test;

	import org.mockito.Mock;
	import org.mockito.Mockito;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;

import com.CandidateManagement.RowMapper.candidateRowMapper;
import com.CandidateManagement.models.Candidate;

	@SpringBootTest

	public class TestCandidateRowMapper {

		@Mock 
		ResultSet rs;
		
		@Autowired
		candidateRowMapper crm;
		
		@Test
		public void mapRow() throws SQLException
		{
			int id = 2;
			String name = "Himanshu";
			String email = "himanshu.jain@accolitedigital.com";
			String institute = "MIT";
			String mobno = "7015426625";
			String joining_date = "21/06/2021";
			String job_title = "Software Engineer";
			String batch = "March 2021";
			String location = "Mumbai";
			String skillset = "Java";
			String description = "abcd";
			String feedback = "xyz";
			
			Mockito.when(rs.getInt("id")).thenReturn(id);
			Mockito.when(rs.getString("name")).thenReturn(name);
			Mockito.when(rs.getString("email")).thenReturn(email);
			Mockito.when(rs.getString("institute")).thenReturn(institute);
			Mockito.when(rs.getString("mobno")).thenReturn(mobno);
			Mockito.when(rs.getString("joining_date")).thenReturn(joining_date);
			Mockito.when(rs.getString("job_title")).thenReturn(job_title);
			Mockito.when(rs.getString("batch")).thenReturn(batch);
			Mockito.when(rs.getString("location")).thenReturn(location);
			Mockito.when(rs.getString("skillset")).thenReturn(skillset);
			Mockito.when(rs.getString("description")).thenReturn(description);
			Mockito.when(rs.getString("feedback")).thenReturn(feedback);
			
			Candidate c = crm.mapRow(rs, 0);
			
			assertNotNull(c);
			assertEquals(id, c.getId());
			assertEquals(name , c.getName());
			assertEquals(email , c.getEmail());
			assertEquals(institute , c.getInstitute());
			assertEquals(mobno , c.getMobno());
			assertEquals(joining_date , c.getJoining_date());
			assertEquals(job_title , c.getJob_title());
			assertEquals(batch , c.getBatch());
			assertEquals(location , c.getLocation());
			assertEquals(skillset , c.getSkillset());
			assertEquals(description , c.getDescription());
			assertEquals(feedback , c.getFeedback());
			
			
		}
	}



