package com.hiresmart.server.service;

import com.hiresmart.server.dto.response.DashboardResponse;
import com.hiresmart.server.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final CandidateRepository candidateRepository;
    private final CompanyRepository companyRepository;
    private final RecruiterRepository recruiterRepository;
    private final JobRepository jobRepository;
    private final ResumeRepository resumeRepository;
    private final ApplicationRepository applicationRepository;
    private final InterviewRepository interviewRepository;

    public DashboardResponse getDashboard() {

        return DashboardResponse.builder()
                .totalCandidates(candidateRepository.count())
                .totalCompanies(companyRepository.count())
                .totalRecruiters(recruiterRepository.count())
                .totalJobs(jobRepository.count())
                .totalApplications(applicationRepository.count())
                .totalInterviews(interviewRepository.count())
                .totalResumes(resumeRepository.count())
                .build();

    }

}