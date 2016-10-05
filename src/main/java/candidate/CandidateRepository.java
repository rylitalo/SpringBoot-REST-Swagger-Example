package candidate;

public class CandidateRepository {
	
	public static Candidate findByID(long id){
		if(id == 1){
			return new Candidate(1, "Ryan Ylitalo");
		}
		
		throw new CandidateNotFoundException();
	}

}
