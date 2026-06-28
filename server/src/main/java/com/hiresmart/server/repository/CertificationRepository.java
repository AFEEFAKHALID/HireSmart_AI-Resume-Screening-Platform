package com.hiresmart.server.repository;

import com.hiresmart.server.entity.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, Integer> {

    List<Certification> findByCandidateCandidateId(Integer candidateId);

}