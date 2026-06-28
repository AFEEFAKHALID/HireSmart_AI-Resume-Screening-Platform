package com.hiresmart.server.repository;

import com.hiresmart.server.entity.InterviewFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InterviewFeedbackRepository extends JpaRepository<InterviewFeedback, Integer> {

    Optional<InterviewFeedback> findByInterviewInterviewId(Integer interviewId);

}