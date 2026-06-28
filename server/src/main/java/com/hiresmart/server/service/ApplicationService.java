package com.hiresmart.server.service;

import com.hiresmart.server.dto.request.ApplicationRequest;
import com.hiresmart.server.dto.response.ApplicationResponse;
import com.hiresmart.server.entity.Application;
import com.hiresmart.server.entity.Candidate;
import com.hiresmart.server.entity.Job;
import com.hiresmart.server.entity.Resume;
import com.hiresmart.server.enums.ApplicationStatus;
import com.hiresmart.server.repository.ApplicationRepository;
import com.hiresmart.server.repository.CandidateRepository;
import com.hiresmart.server.repository.JobRepository;
import com.hiresmart.server.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final CandidateRepository candidateRepository;
    private final JobRepository jobRepository;
    private final ResumeRepository resumeRepository;

    public String applyJob(ApplicationRequest request) {

        Candidate candidate = candidateRepository.findById(request.getCandidateId())
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        Job job = jobRepository.findById(request.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found"));

        Resume resume = resumeRepository.findById(request.getResumeId())
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        if (applicationRepository.existsByCandidateCandidateIdAndJobJobId(
                request.getCandidateId(),
                request.getJobId())) {

            return "You have already applied for this job.";
        }

        Application application = Application.builder()
                .candidate(candidate)
                .job(job)
                .resume(resume)
                .applicationDate(LocalDateTime.now())
                .applicationStatus(ApplicationStatus.APPLIED)
                .coverLetter(request.getCoverLetter())
                .notes(request.getNotes())
                .build();

        applicationRepository.save(application);

        return "Application submitted successfully.";
    }

    public List<ApplicationResponse> getAllApplications() {

        return applicationRepository.findAll()
                .stream()
                .map(application -> ApplicationResponse.builder()
                        .applicationId(application.getApplicationId())
                        .candidateId(application.getCandidate().getCandidateId())
                        .jobId(application.getJob().getJobId())
                        .resumeId(application.getResume().getResumeId())
                        .applicationStatus(application.getApplicationStatus().name())
                        .message("Success")
                        .build())
                .collect(Collectors.toList());

    }

    public ApplicationResponse getApplicationById(Integer id) {

        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        return ApplicationResponse.builder()
                .applicationId(application.getApplicationId())
                .candidateId(application.getCandidate().getCandidateId())
                .jobId(application.getJob().getJobId())
                .resumeId(application.getResume().getResumeId())
                .applicationStatus(application.getApplicationStatus().name())
                .message("Success")
                .build();
    }

    public String updateApplication(Integer id, ApplicationRequest request) {

        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        application.setCoverLetter(request.getCoverLetter());
        application.setNotes(request.getNotes());

        applicationRepository.save(application);

        return "Application updated successfully.";
    }

    public String deleteApplication(Integer id) {

        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        applicationRepository.delete(application);

        return "Application deleted successfully.";
    }

}