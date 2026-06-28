package com.hiresmart.server.repository;

import com.hiresmart.server.entity.Interview;
import com.hiresmart.server.enums.InterviewStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Integer> {

    List<Interview> findByApplicationApplicationId(Integer applicationId);

    List<Interview> findByRecruiterRecruiterId(Integer recruiterId);

    List<Interview> findByInterviewStatus(InterviewStatus interviewStatus);

}