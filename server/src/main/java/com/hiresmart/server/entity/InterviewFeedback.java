package com.hiresmart.server.entity;

import com.hiresmart.server.enums.InterviewRecommendation;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="interview_feedback")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterviewFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="feedback_id")
    private Integer feedbackId;

    @OneToOne
    @JoinColumn(name="interview_id")
    private Interview interview;

    private BigDecimal technicalScore;
    private BigDecimal communicationScore;
    private BigDecimal problemSolvingScore;
    private BigDecimal culturalFitScore;
    private BigDecimal overallScore;

    @Column(columnDefinition="TEXT")
    private String strengths;

    @Column(columnDefinition="TEXT")
    private String weaknesses;

    @Enumerated(EnumType.STRING)
    private InterviewRecommendation recommendation;

    @Column(columnDefinition="TEXT")
    private String comments;

    @Column(name="submitted_at")
    private LocalDateTime submittedAt;

}