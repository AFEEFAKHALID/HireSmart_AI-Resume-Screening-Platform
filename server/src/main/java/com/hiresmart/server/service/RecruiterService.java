package com.hiresmart.server.service;

import com.hiresmart.server.dto.request.RecruiterRequest;
import com.hiresmart.server.dto.response.RecruiterResponse;
import com.hiresmart.server.entity.Company;
import com.hiresmart.server.entity.Recruiter;
import com.hiresmart.server.entity.User;
import com.hiresmart.server.enums.RecruiterType;
import com.hiresmart.server.repository.CompanyRepository;
import com.hiresmart.server.repository.RecruiterRepository;
import com.hiresmart.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecruiterService {

    private final RecruiterRepository recruiterRepository;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    public String createRecruiter(RecruiterRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found"));

        Recruiter recruiter = Recruiter.builder()
                .user(user)
                .company(company)
                .designation(request.getDesignation())
                .department(request.getDepartment())
                .recruiterType(RecruiterType.valueOf(request.getRecruiterType()))
                .isPrimary(request.getIsPrimary())
                .totalJobsPosted(0)
                .totalHires(0)
                .build();

        recruiterRepository.save(recruiter);

        return "Recruiter created successfully";
    }

    public List<RecruiterResponse> getAllRecruiters() {

        return recruiterRepository.findAll()
                .stream()
                .map(recruiter -> RecruiterResponse.builder()
                        .recruiterId(recruiter.getRecruiterId())
                        .userId(recruiter.getUser().getUserId())
                        .companyId(recruiter.getCompany().getCompanyId())
                        .designation(recruiter.getDesignation())
                        .department(recruiter.getDepartment())
                        .recruiterType(recruiter.getRecruiterType().name())
                        .message("Success")
                        .build())
                .collect(Collectors.toList());
    }

    public RecruiterResponse getRecruiterById(Integer id) {

        Recruiter recruiter = recruiterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));

        return RecruiterResponse.builder()
                .recruiterId(recruiter.getRecruiterId())
                .userId(recruiter.getUser().getUserId())
                .companyId(recruiter.getCompany().getCompanyId())
                .designation(recruiter.getDesignation())
                .department(recruiter.getDepartment())
                .recruiterType(recruiter.getRecruiterType().name())
                .message("Success")
                .build();
    }

    public String updateRecruiter(Integer id, RecruiterRequest request) {

        Recruiter recruiter = recruiterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));

        recruiter.setDesignation(request.getDesignation());
        recruiter.setDepartment(request.getDepartment());
        recruiter.setRecruiterType(RecruiterType.valueOf(request.getRecruiterType()));
        recruiter.setIsPrimary(request.getIsPrimary());

        recruiterRepository.save(recruiter);

        return "Recruiter updated successfully";
    }

    public String deleteRecruiter(Integer id) {

        Recruiter recruiter = recruiterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));

        recruiterRepository.delete(recruiter);

        return "Recruiter deleted successfully";
    }

}