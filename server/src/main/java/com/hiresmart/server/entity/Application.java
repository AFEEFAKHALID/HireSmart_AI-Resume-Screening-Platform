package com.hiresmart.server.entity;

import com.hiresmart.server.enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="application_id")
    private Integer applicationId;

    @ManyToOne
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name="job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name="resume_id")
    private Resume resume;

    @Column(name="application_date")
    private LocalDateTime applicationDate;

    @Enumerated(EnumType.STRING)
    @Column(name="application_status")
    private ApplicationStatus applicationStatus;

    @Column(columnDefinition="TEXT")
    private String coverLetter;

    @Column(columnDefinition="TEXT")
    private String notes;

}