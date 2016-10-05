package candidate;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CandidateNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CandidateNotFoundException(){
		super();
	}
}
