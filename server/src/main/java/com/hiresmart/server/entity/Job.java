package com.hiresmart.server.entity;

import com.hiresmart.server.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="job_id")
    private Integer jobId;

    @ManyToOne
    @JoinColumn(name="recruiter_id")
    private Recruiter recruiter;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name="category_id")
    private JobCategory category;

    @Column(name="job_title")
    private String jobTitle;

    @Column(name="job_description",columnDefinition="LONGTEXT")
    private String jobDescription;

    @Column(columnDefinition="LONGTEXT")
    private String responsibilities;

    @Column(columnDefinition="LONGTEXT")
    private String qualifications;

    @Column(name="experience_required")
    private BigDecimal experienceRequired;

    @Column(name="salary_min")
    private BigDecimal salaryMin;

    @Column(name="salary_max")
    private BigDecimal salaryMax;

    @Enumerated(EnumType.STRING)
    @Column(name="employment_type")
    private EmploymentType employmentType;

    @Enumerated(EnumType.STRING)
    @Column(name="workplace_type")
    private WorkplaceType workplaceType;

    private String country;

    private String state;

    private String city;

    private Integer vacancies;

    @Column(name="application_deadline")
    private LocalDate applicationDeadline;

    @Enumerated(EnumType.STRING)
    private JobStatus status;

    @Column(name="created_at",insertable=false,updatable=false)
    private LocalDateTime createdAt;

    @Column(name="updated_at",insertable=false,updatable=false)
    private LocalDateTime updatedAt;

}