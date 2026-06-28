package com.hiresmart.server.repository;

import com.hiresmart.server.entity.KeywordAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeywordAnalysisRepository extends JpaRepository<KeywordAnalysis,Integer>{

    List<KeywordAnalysis> findByAnalysisAnalysisId(Integer analysisId);

}