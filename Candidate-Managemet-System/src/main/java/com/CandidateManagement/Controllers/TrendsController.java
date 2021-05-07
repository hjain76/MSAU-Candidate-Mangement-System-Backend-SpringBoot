package com.CandidateManagement.Controllers;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.CandidateManagement.dao.DAOTrends;
import com.CandidateManagement.models.Candidate;

@RestController
@RequestMapping("/candidate")
public class TrendsController {
	@Autowired
    DAOTrends<Candidate> dao ;

	@GetMapping(path = "/trends/location")
	@ResponseBody
	public List<Map<String, String>> getAlllocation() {
		List<Map<String,String>> list = null;
			list = dao.getCountLocation();
		return list;
	}
	
	@GetMapping(path = "/trends/skills")
	@ResponseBody
	public List<Map<String, String>> getAllskills() {
		List<Map<String,String>> list = null;
			list = dao.getCountSkills();
		return list;
	}

	@GetMapping(path = "/trends/institute")
	@ResponseBody
	public List<Map<String, String>> getAllinstitute() {
		List<Map<String,String>> list = null;
			list = dao.getCountInstitute();
		return list;
	}
}
