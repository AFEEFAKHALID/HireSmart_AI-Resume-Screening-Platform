package com.hiresmart.server.repository;

import com.hiresmart.server.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

    Optional<Company> findByCompanyEmail(String companyEmail);

    boolean existsByCompanyEmail(String companyEmail);

}