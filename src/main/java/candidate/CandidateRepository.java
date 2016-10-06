package candidate;

public class CandidateRepository {
	
	private static final String[] competencies = {"Strategic Problem Solving and Analytical Skills", "Design and Architecture Skills", "Customer Focus", "Communication", "Self-Awareness"};
	
	public static Candidate findByID(long id){
		if(id == 1){
			return new Candidate(1, "Ryan Ylitalo", competencies, "http://www.ryanylitalo.com");
		}else if(id ==2){
			return new Candidate(2, "BadRequest Candidate", competencies, "xxasd://www.someinvalidurl.com");
		}
		else if(id ==3){
			throw new ServerException();
		}
		
		throw new CandidateNotFoundException();
	}

}
