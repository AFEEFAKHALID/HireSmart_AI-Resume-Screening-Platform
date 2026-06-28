package com.hiresmart.server.entity;

import com.hiresmart.server.enums.RecruiterType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "recruiters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruiter_id")
    private Integer recruiterId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private String designation;

    private String department;

    @Enumerated(EnumType.STRING)
    @Column(name = "recruiter_type")
    private RecruiterType recruiterType;

    @Column(name = "is_primary")
    private Boolean isPrimary;

    @Column(name = "total_jobs_posted")
    private Integer totalJobsPosted;

    @Column(name = "total_hires")
    private Integer totalHires;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

}