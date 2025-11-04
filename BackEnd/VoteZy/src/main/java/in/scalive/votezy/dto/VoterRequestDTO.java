package in.scalive.votezy.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VoterRequestDTO {
	
	@NotBlank(message = "Name is Required")
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid mail format")
	private String email;
	
}
