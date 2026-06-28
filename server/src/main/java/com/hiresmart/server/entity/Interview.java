package com.hiresmart.server.entity;

import com.hiresmart.server.enums.InterviewStatus;
import com.hiresmart.server.enums.InterviewType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="interviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="interview_id")
    private Integer interviewId;

    @ManyToOne
    @JoinColumn(name="application_id")
    private Application application;

    @ManyToOne
    @JoinColumn(name="recruiter_id")
    private Recruiter recruiter;

    @Enumerated(EnumType.STRING)
    @Column(name="interview_type")
    private InterviewType interviewType;

    @Column(name="interview_round")
    private String interviewRound;

    @Column(name="interview_date")
    private LocalDateTime interviewDate;

    @Column(name="duration_minutes")
    private Integer durationMinutes;

    @Column(name="meeting_link")
    private String meetingLink;

    @Column(name="interview_location")
    private String interviewLocation;

    @Enumerated(EnumType.STRING)
    @Column(name="interview_status")
    private InterviewStatus interviewStatus;

    @Column(name="created_at")
    private LocalDateTime createdAt;

}