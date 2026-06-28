package com.hiresmart.server.repository;

import com.hiresmart.server.entity.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, Integer> {

    List<CandidateSkill> findByCandidateCandidateId(Integer candidateId);

    List<CandidateSkill> findBySkillSkillId(Integer skillId);

}