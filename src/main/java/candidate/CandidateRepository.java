package candidate;

public class CandidateRepository {
	
	private static final String[] competencies = {"Strategic Problem Solving and Analytical Skills", "Design and Architecture Skills", "Customer Focus", "Communication", "Self-Awareness"};
	
	public static Candidate findByID(long id){
		if(id == 1){
			return new Candidate(1, "Ryan Ylitalo", competencies, "http://www.ryanylitalo.com");
		}
		
		throw new CandidateNotFoundException();
	}

}
