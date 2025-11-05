package in.scalive.votezy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.scalive.votezy.dto.CandidateRequestDTO;
import in.scalive.votezy.dto.CandidateResponseDTO;
import in.scalive.votezy.dto.CandidateUpdateDTO;
import in.scalive.votezy.entity.Candidate;
import in.scalive.votezy.service.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
@RequiredArgsConstructor
public class CandidateController {

	private final CandidateService candidateService;

	@PostMapping("/add")
	public ResponseEntity<CandidateResponseDTO> addCandidate(@Valid @RequestBody CandidateRequestDTO candidate) {
		CandidateResponseDTO savedCandidate = candidateService.addCandidate(candidate);
		return new ResponseEntity<>(savedCandidate, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Candidate>> getAllCandidates() {
		List<Candidate> candidatesList = this.candidateService.getAllCandidates();
		return new ResponseEntity<List<Candidate>>(candidatesList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Candidate> getCandidateById(@PathVariable Long id) {
		Candidate candidate = this.candidateService.getCandidateById(id);
		return new ResponseEntity<>(candidate, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Candidate> updateCandidate(@PathVariable Long id,
			@Valid @RequestBody CandidateUpdateDTO candidateDTO) {
		Candidate updateCandidate = candidateService.updateCandidate(id, candidateDTO);
		return ResponseEntity.ok(updateCandidate);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCandidate(@PathVariable Long id) {
		this.candidateService.deleteCandidate(id);
		return new ResponseEntity<>("candidate with Id: " + id + " successfully deleted", HttpStatus.OK);

	}

}
