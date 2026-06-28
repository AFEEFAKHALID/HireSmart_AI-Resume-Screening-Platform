package com.hiresmart.server.service;

import com.hiresmart.server.dto.request.CandidateRequest;
import com.hiresmart.server.dto.response.CandidateResponse;
import com.hiresmart.server.entity.Candidate;
import com.hiresmart.server.entity.User;
import com.hiresmart.server.enums.Availability;
import com.hiresmart.server.repository.CandidateRepository;
import com.hiresmart.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final UserRepository userRepository;

    public String createCandidate(CandidateRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (candidateRepository.existsByUserUserId(request.getUserId())) {
            return "Candidate profile already exists";
        }

        Candidate candidate = Candidate.builder()
                .user(user)
                .profileCompleted(false)
                .currentJobTitle(request.getCurrentJobTitle())
                .totalExperience(request.getTotalExperience())
                .expectedSalary(request.getExpectedSalary())
                .currentSalary(request.getCurrentSalary())
                .noticePeriod(request.getNoticePeriod())
                .availability(Availability.IMMEDIATE)
                .willingToRelocate(request.getWillingToRelocate())
                .openToRemote(request.getOpenToRemote())
                .linkedinUrl(request.getLinkedinUrl())
                .githubUrl(request.getGithubUrl())
                .portfolioUrl(request.getPortfolioUrl())
                .build();

        candidateRepository.save(candidate);

        return "Candidate created successfully";
    }

    public List<CandidateResponse> getAllCandidates() {

        return candidateRepository.findAll()
                .stream()
                .map(candidate -> CandidateResponse.builder()
                        .candidateId(candidate.getCandidateId())
                        .userId(candidate.getUser().getUserId())
                        .currentJobTitle(candidate.getCurrentJobTitle())
                        .message("Success")
                        .build())
                .collect(Collectors.toList());

    }

    public CandidateResponse getCandidateById(Integer id) {

        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        return CandidateResponse.builder()
                .candidateId(candidate.getCandidateId())
                .userId(candidate.getUser().getUserId())
                .currentJobTitle(candidate.getCurrentJobTitle())
                .message("Success")
                .build();

    }

    public String updateCandidate(Integer id, CandidateRequest request) {

        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        candidate.setCurrentJobTitle(request.getCurrentJobTitle());
        candidate.setTotalExperience(request.getTotalExperience());
        candidate.setExpectedSalary(request.getExpectedSalary());
        candidate.setCurrentSalary(request.getCurrentSalary());
        candidate.setNoticePeriod(request.getNoticePeriod());
        candidate.setWillingToRelocate(request.getWillingToRelocate());
        candidate.setOpenToRemote(request.getOpenToRemote());
        candidate.setLinkedinUrl(request.getLinkedinUrl());
        candidate.setGithubUrl(request.getGithubUrl());
        candidate.setPortfolioUrl(request.getPortfolioUrl());

        candidateRepository.save(candidate);

        return "Candidate updated successfully";
    }

    public String deleteCandidate(Integer id) {

        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        candidateRepository.delete(candidate);

        return "Candidate deleted successfully";
    }

}