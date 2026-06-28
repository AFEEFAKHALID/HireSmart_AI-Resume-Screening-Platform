package com.hiresmart.server.repository;

import com.hiresmart.server.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruiterRepository extends JpaRepository<Recruiter,Integer> {

    List<Recruiter> findByCompanyCompanyId(Integer companyId);

    List<Recruiter> findByUserUserId(Integer userId);

}