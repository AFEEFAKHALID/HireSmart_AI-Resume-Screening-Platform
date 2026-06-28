package com.hiresmart.server.repository;

import com.hiresmart.server.entity.Application;
import com.hiresmart.server.enums.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    List<Application> findByCandidateCandidateId(Integer candidateId);

    List<Application> findByJobJobId(Integer jobId);

    List<Application> findByApplicationStatus(ApplicationStatus applicationStatus);

    boolean existsByCandidateCandidateIdAndJobJobId(Integer candidateId, Integer jobId);

}