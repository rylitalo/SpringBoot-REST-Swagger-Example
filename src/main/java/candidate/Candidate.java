package candidate;

import java.net.URL;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class Candidate {

    private final long id;
    private final String name;
    private final String[] competencies;
    private final String onlineResume;
    

    public Candidate(long id, String name, String[] competencies, String onlineResume) {
        this.id = id;
        this.name = name;
        this.competencies = competencies;

		if (!StringUtils.isEmpty(onlineResume)) {
			try {
				new URL(onlineResume).openConnection();
			} catch (Exception e) {
				throw new MisconfiguredCandidateException();
			}
		}
        
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
