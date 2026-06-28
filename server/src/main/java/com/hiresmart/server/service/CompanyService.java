package com.hiresmart.server.service;

import com.hiresmart.server.dto.request.CompanyRequest;
import com.hiresmart.server.dto.response.CompanyResponse;
import com.hiresmart.server.entity.Company;
import com.hiresmart.server.enums.CompanyStatus;
import com.hiresmart.server.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public String createCompany(CompanyRequest request) {

        if (companyRepository.existsByCompanyEmail(request.getCompanyEmail())) {
            return "Company already exists";
        }

        Company company = Company.builder()
                .companyName(request.getCompanyName())
                .companyEmail(request.getCompanyEmail())
                .companyPhone(request.getCompanyPhone())
                .website(request.getWebsite())
                .industry(request.getIndustry())
                .companySize(request.getCompanySize())
                .foundedYear(request.getFoundedYear())
                .country(request.getCountry())
                .state(request.getState())
                .city(request.getCity())
                .address(request.getAddress())
                .logo(request.getLogo())
                .description(request.getDescription())
                .status(CompanyStatus.ACTIVE)
                .build();

        companyRepository.save(company);

        return "Company created successfully";
    }

    public List<CompanyResponse> getAllCompanies() {

        return companyRepository.findAll()
                .stream()
                .map(company -> CompanyResponse.builder()
                        .companyId(company.getCompanyId())
                        .companyName(company.getCompanyName())
                        .companyEmail(company.getCompanyEmail())
                        .companyPhone(company.getCompanyPhone())
                        .industry(company.getIndustry())
                        .city(company.getCity())
                        .country(company.getCountry())
                        .message("Success")
                        .build())
                .collect(Collectors.toList());
    }

    public CompanyResponse getCompanyById(Integer id) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        return CompanyResponse.builder()
                .companyId(company.getCompanyId())
                .companyName(company.getCompanyName())
                .companyEmail(company.getCompanyEmail())
                .companyPhone(company.getCompanyPhone())
                .industry(company.getIndustry())
                .city(company.getCity())
                .country(company.getCountry())
                .message("Success")
                .build();
    }

    public String updateCompany(Integer id, CompanyRequest request) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        company.setCompanyName(request.getCompanyName());
        company.setCompanyEmail(request.getCompanyEmail());
        company.setCompanyPhone(request.getCompanyPhone());
        company.setWebsite(request.getWebsite());
        company.setIndustry(request.getIndustry());
        company.setCompanySize(request.getCompanySize());
        company.setFoundedYear(request.getFoundedYear());
        company.setCountry(request.getCountry());
        company.setState(request.getState());
        company.setCity(request.getCity());
        company.setAddress(request.getAddress());
        company.setLogo(request.getLogo());
        company.setDescription(request.getDescription());

        companyRepository.save(company);

        return "Company updated successfully";
    }

    public String deleteCompany(Integer id) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        companyRepository.delete(company);

        return "Company deleted successfully";
    }

}