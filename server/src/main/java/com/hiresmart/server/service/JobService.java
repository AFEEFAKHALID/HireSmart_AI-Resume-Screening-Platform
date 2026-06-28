package com.hiresmart.server.service;

import com.hiresmart.server.dto.request.JobRequest;
import com.hiresmart.server.dto.response.JobResponse;
import com.hiresmart.server.entity.*;
import com.hiresmart.server.enums.*;
import com.hiresmart.server.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;
    private final RecruiterRepository recruiterRepository;
    private final CompanyRepository companyRepository;
    private final JobCategoryRepository jobCategoryRepository;

    public String createJob(JobRequest request) {

        Recruiter recruiter = recruiterRepository.findById(request.getRecruiterId())
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));

        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found"));

        JobCategory category = jobCategoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Job job = Job.builder()
                .recruiter(recruiter)
                .company(company)
                .category(category)
                .jobTitle(request.getJobTitle())
                .jobDescription(request.getJobDescription())
                .responsibilities(request.getResponsibilities())
                .qualifications(request.getQualifications())
                .experienceRequired(request.getExperienceRequired())
                .salaryMin(request.getSalaryMin())
                .salaryMax(request.getSalaryMax())
                .employmentType(EmploymentType.valueOf(request.getEmploymentType()))
                .workplaceType(WorkplaceType.valueOf(request.getWorkplaceType()))
                .country(request.getCountry())
                .state(request.getState())
                .city(request.getCity())
                .vacancies(request.getVacancies())
                .applicationDeadline(request.getApplicationDeadline())
                .status(JobStatus.OPEN)
                .build();

        jobRepository.save(job);

        return "Job created successfully";
    }

    public List<JobResponse> getAllJobs() {

        return jobRepository.findAll()
                .stream()
                .map(job -> JobResponse.builder()
                        .jobId(job.getJobId())
                        .jobTitle(job.getJobTitle())
                        .companyName(job.getCompany().getCompanyName())
                        .recruiterName(job.getRecruiter().getUser().getFirstName()
                                + " " +
                                job.getRecruiter().getUser().getLastName())
                        .status(job.getStatus().name())
                        .message("Success")
                        .build())
                .collect(Collectors.toList());

    }

    public JobResponse getJobById(Integer id) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        return JobResponse.builder()
                .jobId(job.getJobId())
                .jobTitle(job.getJobTitle())
                .companyName(job.getCompany().getCompanyName())
                .recruiterName(job.getRecruiter().getUser().getFirstName()
                        + " " +
                        job.getRecruiter().getUser().getLastName())
                .status(job.getStatus().name())
                .message("Success")
                .build();

    }

    public String updateJob(Integer id, JobRequest request) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        job.setJobTitle(request.getJobTitle());
        job.setJobDescription(request.getJobDescription());
        job.setResponsibilities(request.getResponsibilities());
        job.setQualifications(request.getQualifications());
        job.setExperienceRequired(request.getExperienceRequired());
        job.setSalaryMin(request.getSalaryMin());
        job.setSalaryMax(request.getSalaryMax());
        job.setEmploymentType(EmploymentType.valueOf(request.getEmploymentType()));
        job.setWorkplaceType(WorkplaceType.valueOf(request.getWorkplaceType()));
        job.setCountry(request.getCountry());
        job.setState(request.getState());
        job.setCity(request.getCity());
        job.setVacancies(request.getVacancies());
        job.setApplicationDeadline(request.getApplicationDeadline());

        jobRepository.save(job);

        return "Job updated successfully";
    }

    public String deleteJob(Integer id) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        jobRepository.delete(job);

        return "Job deleted successfully";
    }

}