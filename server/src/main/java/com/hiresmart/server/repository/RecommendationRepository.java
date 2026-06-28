package com.hiresmart.server.repository;

import com.hiresmart.server.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation,Integer>{

    List<Recommendation> findByAnalysisAnalysisId(Integer analysisId);

}