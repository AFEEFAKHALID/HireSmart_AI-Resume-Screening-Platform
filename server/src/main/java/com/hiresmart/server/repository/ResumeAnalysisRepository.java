package com.hiresmart.server.repository;

import com.hiresmart.server.entity.ResumeAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeAnalysisRepository extends JpaRepository<ResumeAnalysis,Integer>{

    List<ResumeAnalysis> findByResumeResumeId(Integer resumeId);

}