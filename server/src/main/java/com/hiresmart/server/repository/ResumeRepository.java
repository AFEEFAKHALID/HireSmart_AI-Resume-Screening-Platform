package com.hiresmart.server.repository;

import com.hiresmart.server.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Integer> {

    List<Resume> findByCandidateCandidateId(Integer candidateId);

    List<Resume> findByIsDefault(Boolean isDefault);

}