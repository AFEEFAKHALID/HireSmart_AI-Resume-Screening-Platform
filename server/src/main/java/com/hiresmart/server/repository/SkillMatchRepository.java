package com.hiresmart.server.repository;

import com.hiresmart.server.entity.SkillMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillMatchRepository extends JpaRepository<SkillMatch,Integer>{

    List<SkillMatch> findByAnalysisAnalysisId(Integer analysisId);

}