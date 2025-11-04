package in.scalive.votezy.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import in.scalive.votezy.dto.CandidateRequestDTO;
import in.scalive.votezy.dto.CandidateResponseDTO;
import in.scalive.votezy.entity.Candidate;
@Mapper(componentModel = "spring")
public interface CandidateMapper {

	// DTO -> Entity
	Candidate toEntity(CandidateRequestDTO dto);

	// Entity -> DTO
	CandidateResponseDTO toResponseDTO(Candidate candidate);

	List<CandidateRequestDTO> toResponseDTOList(List<Candidate> voters);

}
