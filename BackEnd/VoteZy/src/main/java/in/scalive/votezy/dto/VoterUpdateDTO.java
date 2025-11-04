package in.scalive.votezy.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class VoterUpdateDTO {
	@Size(min = 1,message = "Name cannot be empty")
	private String name;
	
	@Size(min = 1,message = "Party cannot be empty")
	@Email(message = "Email must be valid")
	private String email;

}
