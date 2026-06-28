package com.hiresmart.server.repository;

import com.hiresmart.server.entity.Job;
import com.hiresmart.server.enums.JobStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Integer>{

    List<Job> findByStatus(JobStatus status);

    List<Job> findByCompanyCompanyId(Integer companyId);

    List<Job> findByRecruiterRecruiterId(Integer recruiterId);

}