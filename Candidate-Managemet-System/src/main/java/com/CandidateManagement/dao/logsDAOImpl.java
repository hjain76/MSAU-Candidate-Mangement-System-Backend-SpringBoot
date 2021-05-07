
package com.CandidateManagement.dao;

import org.springframework.stereotype.Component;


import com.CandidateManagement.models.Logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Component
public class logsDAOImpl implements DAOLogs {
	
	
	private static final Logger logger = LoggerFactory.getLogger(logsDAOImpl.class);

	@Autowired
    private JdbcTemplate jdbcTemplate;
    
    public logsDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public String addLogs(Logs log) {
		String sqlQuery = "insert into Logs(name,action,date) values(?, ?, ?)";
		jdbcTemplate.update(sqlQuery,log.getName(),log.getAction(),log.getDate());
		logger.info("Log Added Successfully");
	
		return "ok";
	}	

	@Override
	public List<Logs> getLogs() {
		logger.info("Fetching Log");
		return jdbcTemplate.query(
	            "select * from Logs",
	            (rs, rowNum) ->
	                    new Logs(
	                    	rs.getString("name"),
	                    	 rs.getString("action"),
	                           rs.getDate("date")
	                    )
	    );
	
	}

  

}

