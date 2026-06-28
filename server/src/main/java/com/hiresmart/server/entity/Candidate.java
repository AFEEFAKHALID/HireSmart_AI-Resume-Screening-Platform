package com.hiresmart.server.entity;

import com.hiresmart.server.enums.Availability;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="candidates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="candidate_id")
    private Integer candidateId;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="profile_completed")
    private Boolean profileCompleted;

    @Column(name="current_job_title")
    private String currentJobTitle;

    @Column(name="total_experience")
    private BigDecimal totalExperience;

    @Column(name="expected_salary")
    private BigDecimal expectedSalary;

    @Column(name="current_salary")
    private BigDecimal currentSalary;

    @Column(name="notice_period")
    private Integer noticePeriod;

    @Enumerated(EnumType.STRING)
    private Availability availability;

    @Column(name="willing_to_relocate")
    private Boolean willingToRelocate;

    @Column(name="open_to_remote")
    private Boolean openToRemote;

    @Column(name="linkedin_url")
    private String linkedinUrl;

    @Column(name="github_url")
    private String githubUrl;

    @Column(name="portfolio_url")
    private String portfolioUrl;

    @Column(name="created_at",insertable=false,updatable=false)
    private LocalDateTime createdAt;

    @Column(name="updated_at",insertable=false,updatable=false)
    private LocalDateTime updatedAt;

}