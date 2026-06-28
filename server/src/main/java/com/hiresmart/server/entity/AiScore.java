package com.hiresmart.server.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name="ai_scores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AiScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="score_id")
    private Integer scoreId;

    @OneToOne
    @JoinColumn(name="analysis_id")
    private ResumeAnalysis analysis;

    @Column(name="overall_score")
    private BigDecimal overallScore;

    @Column(name="skills_score")
    private BigDecimal skillsScore;

    @Column(name="experience_score")
    private BigDecimal experienceScore;

    @Column(name="education_score")
    private BigDecimal educationScore;

    @Column(name="keyword_score")
    private BigDecimal keywordScore;

    @Column(name="ats_score")
    private BigDecimal atsScore;

}