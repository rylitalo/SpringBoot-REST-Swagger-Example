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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Candidate {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String[] competencies;
    private String onlineResume;
    
    public Candidate(){}
    
    public Candidate(long id, String name, String[] competencies, String onlineResume) {
        this.id = id;
        this.name = name;
        this.competencies = competencies;

//		if (!StringUtils.isEmpty(onlineResume)) {
//			try {
//				new URL(onlineResume).openConnection();
//			} catch (Exception e) {
//				throw new MisconfiguredCandidateException();
//			}
//		}
        
        this.onlineResume = onlineResume;
    }

    public long getId() {
        return id;
    }

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The name of the user", required = true)
    public String getName() {
        return name;
    }
    
    @JsonProperty(required = false)
    @ApiModelProperty(notes = "The location of online resume", required = false)
    public String getOnlineResume() {
        return onlineResume;
    }
    
    
    @JsonProperty(required = false)
    @ApiModelProperty(notes = "The competencies exhibited by this candidate", required = false)
    public String[] getCompetencies(){
    	return competencies;
    }
    
}
