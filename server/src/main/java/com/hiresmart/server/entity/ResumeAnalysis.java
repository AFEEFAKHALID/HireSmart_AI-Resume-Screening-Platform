package com.hiresmart.server.entity;

import com.hiresmart.server.enums.AnalysisStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="resume_analysis")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="analysis_id")
    private Integer analysisId;

    @ManyToOne
    @JoinColumn(name="resume_id")
    private Resume resume;

    @ManyToOne
    @JoinColumn(name="job_id")
    private Job job;

    @Enumerated(EnumType.STRING)
    @Column(name="analysis_status")
    private AnalysisStatus analysisStatus;

    @Column(name="analysis_date")
    private LocalDateTime analysisDate;

    @Column(columnDefinition="LONGTEXT")
    private String extractedText;

    @Column(columnDefinition="LONGTEXT")
    private String summary;

}