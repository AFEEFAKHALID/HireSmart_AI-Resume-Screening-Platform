package com.hiresmart.server.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterviewRequest {

    private Integer applicationId;

    private Integer recruiterId;

    private String interviewType;

    private String interviewRound;

    private LocalDateTime interviewDate;

    private Integer durationMinutes;

    private String meetingLink;

    private String interviewLocation;

}