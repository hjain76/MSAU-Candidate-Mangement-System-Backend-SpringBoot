package com.CandidateManagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;

import com.CandidateManagement.models.Candidate;

@Component
public class trendsDaoImpl implements DAOTrends<Candidate> {
	
	private JdbcTemplate jdbcTemplate;
	
    public trendsDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
    
    @Override
	public List<Map<String, String>> getCountLocation() {
		String Query="SELECT location, COUNT(name) location FROM candidate GROUP BY location ORDER BY COUNT(name) DESC; ";
		List<Map<String,String>> item = new ArrayList<>();
		jdbcTemplate.query(Query, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
				Map<String,String> temp1 = new HashMap<>();
				temp1.put("name",resultSet.getString(1));
				temp1.put("value", resultSet.getString(2));
				item.add(temp1);
				while (resultSet.next()) {
					Map<String,String> temp = new HashMap<>();
					temp.put("name",resultSet.getString(1));
					temp.put("value", resultSet.getString(2));
					item.add(temp);
				}
				
			}
		});
		
		return item;
	}
    
    @Override
	public List<Map<String, String>> getCountSkills() {
		String Query="SELECT skillset, COUNT(name) skillset FROM candidate GROUP BY skillset ORDER BY COUNT(name) DESC; ";
		List<Map<String,String>> item = new ArrayList<>();
		jdbcTemplate.query(Query, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
				Map<String,String> temp1 = new HashMap<>();
				temp1.put("name",resultSet.getString(1));
				temp1.put("value", resultSet.getString(2));
				item.add(temp1);
				while (resultSet.next()) {
					Map<String,String> temp = new HashMap<>();
					temp.put("name",resultSet.getString(1));
					temp.put("value", resultSet.getString(2));
					item.add(temp);
				}
				
			}
		});
		
		return item;
	}
    
    public List<Map<String, String>> getCountInstitute() {
		String Query="SELECT institute, COUNT(name) institute FROM candidate GROUP BY institute ORDER BY COUNT(name) DESC; ";
		List<Map<String,String>> item = new ArrayList<>();
		jdbcTemplate.query(Query, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
				Map<String,String> temp1 = new HashMap<>();
				temp1.put("name",resultSet.getString(1));
				temp1.put("value", resultSet.getString(2));
				item.add(temp1);
				while (resultSet.next()) {
					Map<String,String> temp = new HashMap<>();
					temp.put("name",resultSet.getString(1));
					temp.put("value", resultSet.getString(2));
					item.add(temp);
				}
				
			}
		});
		
		return item;
	}
}
