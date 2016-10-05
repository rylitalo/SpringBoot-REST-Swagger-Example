package candidate;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CandidateController {


    @ApiOperation(value = "getCandidate", nickname = "getCandidate")
    @RequestMapping(method = RequestMethod.GET, path="/candidate/{candidateId}", produces = "application/json" )
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Candidate.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    public Candidate candidate( @PathVariable( "candidateId" ) Long candidateId) {
        return CandidateRepository.findByID(candidateId);
    }
    
    
}
