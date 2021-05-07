package com.CandidateManagement.dao;

import java.util.List;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.CandidateManagement.RowMapper.candidateRowMapper;
import com.CandidateManagement.models.Candidate;
//import com.CandidateManagement.models.Logs;

@Component
public class candidateDaoImpl implements dao<Candidate>{

    private static final Logger log = LoggerFactory.getLogger(candidateDaoImpl.class);
	private JdbcTemplate jdbcTemplate;
	
    @Autowired
    //DAOLogs dao;
    	
    public candidateDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
    

	@Override
	public List<Candidate> getCandidates() {
		
		log.info("Fetching Candidates");
		String sql="SELECT * FROM candidate;";
		List<Candidate> candidates=jdbcTemplate.query(sql,new candidateRowMapper());
		
		
		return candidates;
	
		
	}
	

	@Override
	public Candidate create(Candidate candidate) {
		
		String sql  = "INSERT into candidate(id,name,email,mobno,institute,joining_date,location,skillset,description,feedback,job_title,batch) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
        int index = jdbcTemplate.update(sql, new Object[] {candidate.getId(),candidate.getName(),candidate.getEmail(),candidate.getMobno(),candidate.getInstitute(),candidate.getJoining_date(),
        		candidate.getLocation(),candidate.getSkillset(),candidate.getDescription(),candidate.getFeedback(),candidate.getJob_title(),candidate.getBatch()});
        String new_sql="SELECT * FROM candidate;";
        
        List<Candidate> candidates=jdbcTemplate.query(new_sql,new candidateRowMapper());
        candidate.setId(candidates.get(candidates.size() - 1).getId());

        log.info("Candidate" + candidate.getName() + "Added Successfully");
        return candidate;
 

	}
	
	public Candidate returnOldValue(int id) {
		String sqlString="Select * from candidate where id="+id+";";
		Candidate old = jdbcTemplate.queryForObject(sqlString, new candidateRowMapper());
		return old;
	}
	

	@Override
	public int updateCandidate(Candidate candidate, int id) {
		String sql = "UPDATE candidate set name=?,email=?,mobno=?,institute=?,joining_date=?,location=?,skillset=?,description=?,feedback=?,job_title=?,batch=? where id=?";
		
		Candidate old= returnOldValue(id);
		int index=jdbcTemplate.update(sql,new Object[] {candidate.getName(),candidate.getEmail(),candidate.getMobno(),candidate.getInstitute(),candidate.getJoining_date(),candidate.getLocation(),
				candidate.getSkillset(),candidate.getDescription(),candidate.getFeedback(),candidate.getJob_title(),candidate.getBatch(),id});
		if(index==1) {
			log.info("Candidate By id - " + old.getId() +" Was Updated Successfully");
		}
		
		return index;
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM candidate WHERE id =?";
		Candidate old= returnOldValue(id);

        int index = jdbcTemplate.update(sql, new Object[] {id});

      
      log.info("Candidate By ID --" + old.getId() + "Was deleted Successfully");
       
	}
	
}
