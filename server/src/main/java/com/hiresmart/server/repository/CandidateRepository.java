package com.hiresmart.server.repository;

import com.hiresmart.server.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    Optional<Candidate> findByUserUserId(Integer userId);

    boolean existsByUserUserId(Integer userId);

}