package in.scalive.votezy.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VoteRequestDTO {

	@NotNull(message = "Voter id is required")
	private Long voterId;
	
	
	@NotNull(message = "Candidate Id Is required")
	private Long candidateId;
	
}
