package in.scalive.votezy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.scalive.votezy.dto.CandidateRequestDTO;
import in.scalive.votezy.dto.CandidateResponseDTO;
import in.scalive.votezy.dto.CandidateUpdateDTO;
import in.scalive.votezy.entity.Candidate;
import in.scalive.votezy.entity.Vote;
import in.scalive.votezy.exception.ResourceNotFoundException;
import in.scalive.votezy.mapper.CandidateMapper;
import in.scalive.votezy.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CandidateService {

	private final CandidateRepository candidateRepository;
	private final CandidateMapper mapper;

	// Create candidate
	public CandidateResponseDTO addCandidate(CandidateRequestDTO dto) {
		Candidate candidate = mapper.toEntity(dto);
		Candidate savedCandidate = candidateRepository.save(candidate);
		return mapper.toResponseDTO(savedCandidate);
	}

	// Get all candidates
	public List<CandidateResponseDTO> getAllCandidates() {
		List<Candidate> candidates = candidateRepository.findAll();
		return mapper.toResponseDTOList(candidates);
	}

	// Get candidate by ID
	public CandidateResponseDTO getCandidateById(Long id) {
		Candidate candidate = candidateRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Candidate with id " + id + " not found"));
		return mapper.toResponseDTO(candidate);
	}

	// Update candidate
	public CandidateResponseDTO updateCandidate(Long id, CandidateUpdateDTO dto) {
		Candidate candidate = candidateRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Candidate with id " + id + " not found"));

		if (dto.getName() != null) {
			candidate.setName(dto.getName());
		}

		if (dto.getParty() != null) {
			candidate.setParty(dto.getParty());
		}

		Candidate updated = candidateRepository.save(candidate);
		return mapper.toResponseDTO(updated);
	}

	// Delete candidate
	public void deleteCandidate(Long id) {
		Candidate candidate = candidateRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Candidate with id " + id + " not found"));

		// Breaking relationships to avoid FK constraint violations
		List<Vote> votes = candidate.getVote();
		for (Vote vote : votes) {
			vote.setCandidate(null);
		}
		candidate.getVote().clear();

		candidateRepository.delete(candidate);
	}
}
