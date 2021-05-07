package com.CandidateManagement.Controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.CandidateManagement.dao.dao;
import com.CandidateManagement.models.Candidate;

@RestController()
@RequestMapping("/candidate")
public class CandidateController {
	@Autowired
    dao<Candidate> dao ;
    
    @GetMapping("/view")
	public ResponseEntity<List<Candidate>> getAllCandidates(){
    	
		List<Candidate> candidates = new ArrayList<Candidate>();
		candidates=dao.getCandidates();
		return new ResponseEntity<>(candidates, HttpStatus.OK);
	}
    
    @PostMapping("/add" )
	public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate candidate){
    	
		Candidate newCandidate = dao.create(candidate);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(candidate.getId())
                .toUri();
		
		return new ResponseEntity<>(newCandidate,HttpStatus.CREATED);
	}
    
    @PutMapping("/update")
    public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate) {
    	
        int index=dao.updateCandidate(candidate,candidate.getId());
        if(index>0) {
        	return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCandidate(@PathVariable(value="id") int id) {
    	
        dao.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
