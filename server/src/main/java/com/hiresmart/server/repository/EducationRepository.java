package com.hiresmart.server.repository;

import com.hiresmart.server.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {

    List<Education> findByCandidateCandidateId(Integer candidateId);

}