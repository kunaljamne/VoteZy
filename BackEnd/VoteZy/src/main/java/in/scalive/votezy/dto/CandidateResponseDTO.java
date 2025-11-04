package in.scalive.votezy.dto;

import lombok.Data;

@Data
public class CandidateResponseDTO {

	private Long id;
	private String name;
	private String party;
	private int voteCount = 0;
}
