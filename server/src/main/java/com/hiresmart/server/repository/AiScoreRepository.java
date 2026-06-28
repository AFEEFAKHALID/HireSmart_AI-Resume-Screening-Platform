package com.hiresmart.server.repository;

import com.hiresmart.server.entity.AiScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AiScoreRepository extends JpaRepository<AiScore,Integer>{

    Optional<AiScore> findByAnalysisAnalysisId(Integer analysisId);

}