package candidate;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MisconfiguredCandidateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MisconfiguredCandidateException(){
		super();
	}
}
