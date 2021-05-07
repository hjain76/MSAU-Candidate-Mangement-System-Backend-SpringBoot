
package com.CandidateManagement.Controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CandidateManagement.dao.DAOLogs;

import com.CandidateManagement.models.Logs;


import java.util.List;


@RestController
@RequestMapping("/candidate")
public class LogsController {
	
	private static final Logger logger = LoggerFactory.getLogger(LogsController.class);
    
	@Autowired
    DAOLogs dao;

	@RequestMapping("/addlogs")
	public String addlogs(@RequestBody Logs logs)
	{
		logger.info("Inside add Logs Controller");
		return dao.addLogs(logs);
	}
	@GetMapping("/getlogs")
	public List<Logs> getlogs()
	{
		logger.info("Inside Get Logs Controller");
		return dao.getLogs();
	}
    

}

