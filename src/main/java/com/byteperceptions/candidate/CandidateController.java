package com.byteperceptions.candidate;
/*
 * Copyright 2016 Ryan Ylitalo and BytePerceptions LLC. 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    private CandidateRepository repository;

    @Autowired
	public CandidateController(CandidateRepository repository){
		this.repository = repository;
	}
	
	@ApiOperation(value = "getAllCandidates", nickname = "getAllCandidates")
	@RequestMapping(method = RequestMethod.GET)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = Candidate.class),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure")}) 
	public ResponseEntity<Collection<Candidate>> getAllCandidates(){
		return new ResponseEntity<>((Collection<Candidate>) repository.findAll(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "addCandidate", nickname = "addCandidate")
	@RequestMapping(method = RequestMethod.POST)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = Candidate.class),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure")}) 
	public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate newCandidate){
		 return new ResponseEntity<>(repository.save(newCandidate), HttpStatus.CREATED);
	}

	
	@ApiOperation(value = "getCandidate", nickname = "getCandidate")
    @RequestMapping(method = RequestMethod.GET, path="/{id}")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Candidate.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    public ResponseEntity<Candidate> candidate( @PathVariable( "id" ) Long candidateId) {
        return new ResponseEntity<>(repository.findOne(candidateId), HttpStatus.OK);
    }
	
}
