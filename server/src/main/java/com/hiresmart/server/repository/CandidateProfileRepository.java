package com.hiresmart.server.repository;

import com.hiresmart.server.entity.CandidateProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateProfileRepository extends JpaRepository<CandidateProfile, Integer> {

    Optional<CandidateProfile> findByCandidateCandidateId(Integer candidateId);

}