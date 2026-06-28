package com.hiresmart.server.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="shortlists")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shortlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="shortlist_id")
    private Integer shortlistId;

    @ManyToOne
    @JoinColumn(name="application_id")
    private Application application;

    @ManyToOne
    @JoinColumn(name="recruiter_id")
    private Recruiter recruiter;

    @Column(name="shortlisted_date")
    private LocalDateTime shortlistedDate;

    @Column(columnDefinition="TEXT")
    private String remarks;

}