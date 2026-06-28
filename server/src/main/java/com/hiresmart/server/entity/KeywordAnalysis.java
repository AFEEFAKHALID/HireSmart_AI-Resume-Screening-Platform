package com.hiresmart.server.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="keyword_analysis")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KeywordAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="keyword_analysis_id")
    private Integer keywordAnalysisId;

    @ManyToOne
    @JoinColumn(name="analysis_id")
    private ResumeAnalysis analysis;

    private String keyword;

    private Integer frequency;

    @Column(name="is_matched")
    private Boolean matched;

}