package in.scalive.votezy.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class CandidateRequestDTO{
	private Long id;

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Party is required")
	private String party;
	
	private int voteCount = 0;
}