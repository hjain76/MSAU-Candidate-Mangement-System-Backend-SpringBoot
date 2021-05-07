package com.CandidateManagement.controllers;


import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.CandidateManagement.Controllers.CandidateController;
import com.CandidateManagement.dao.dao;
import com.CandidateManagement.models.Candidate;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TestCandidateController {

	@InjectMocks
	CandidateController candidateController;
	
	@Mock
	dao<Candidate> d;
	
	Candidate c = new Candidate();
	
	@Test
	public void testAddCandidate()
	{
		 MockHttpServletRequest request = new MockHttpServletRequest();
	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	         
	        Mockito.when(d.create(c)).thenReturn(c);
	         
	        Candidate c1 = new Candidate();
	        ResponseEntity<Candidate> responseEntity = candidateController.addCandidate(c1);
	         
	        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
	        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
	}
}
