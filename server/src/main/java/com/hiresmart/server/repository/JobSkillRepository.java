package com.hiresmart.server.repository;

import com.hiresmart.server.entity.JobSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSkillRepository extends JpaRepository<JobSkill,Integer>{

    List<JobSkill> findByJobJobId(Integer jobId);

}